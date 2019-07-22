import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.bean.Product;
import spittr.config.DataConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Product> redis;

    @Autowired
    private StringRedisTemplate stringRedis;

    @Test
    public void getFromRedis(){
        stringRedis.opsForValue().set("str", "zhang");
        assertEquals("zhang", stringRedis.opsForValue().get("str"));
    }

    @Test
    public void workingWithList(){
        Product product = new Product();
        product.setSku("9781617291203");
        product.setName("Spring in Action");
        product.setPrice(39.99f);

        redis.opsForList().rightPush("cart", product);

        assertEquals(1, redis.opsForList().size("cart").longValue());
    }
}
