package com.didispace.chapter52;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter52ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() throws Exception {
        System.out.println("CacheManager type : " + cacheManager.getClass());

        // 创建1条记录
        userRepository.save(new User("AAA", 10));

        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }

    /**
     * Q:数据更新之后怎么办？
     * A:构建了缓存集群之后(下一章)
     *  1.save操作增加@CachePut注解，让更新操作完成之后将结果再put到缓存中
     *  2.保证缓存事件监听的replicateUpdates=true，这样数据在更新之后可以保证复制到其他节点
     *  这样就可以防止缓存的脏数据了，但缓存集群的同步依然需要时间，还是会存在短暂的不一致。
     *  同时进程内的缓存要在每个实例上都占用，如果大量存储的话始终不那么经济。
     *  所以，很多时候进程内缓存不会作为主要的缓存手段
     */

}
