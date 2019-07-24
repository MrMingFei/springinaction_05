package spittr.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import spittr.bean.Product;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }

    @Bean
    public BasicDataSource Data(){
        BasicDataSource bs = new BasicDataSource();
        bs.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bs.setUrl("jdbc:mysql://localhost:3306/world?useSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC");
        bs.setUsername("root");
        bs.setPassword("271828");
        return bs;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource Data){
        return new JdbcTemplate(Data);
    }

    @Bean
    public SessionFactory sessionFactoryBean(DataSource dataSource){
        try {
            LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
            sfb.setDataSource(dataSource);
            sfb.setPackagesToScan("spittr.bean");
            Properties props = new Properties();
            props.setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect");
            sfb.setHibernateProperties(props);
            sfb.afterPropertiesSet();
            SessionFactory object = sfb.getObject();
            return object;
        }catch (IOException e){
            return null;
        }
    }

    @Bean
    public BeanPostProcessor persisttenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public RedisConnectionFactory redisCF(){
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.afterPropertiesSet();
        return cf;
    }

    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf){
        RedisTemplate<String, Product> redisTemplate = new RedisTemplate<String, Product>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf){
        return new StringRedisTemplate(cf);
    }
}
