package spittr.data;

import org.springframework.cache.annotation.Cacheable;
import spittr.bean.Spittle;
import java.util.List;

public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);

    @Cacheable("spittleCache")
    Spittle findOne(long id);

    void save(Spittle spittle);
}
