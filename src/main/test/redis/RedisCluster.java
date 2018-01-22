package redis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * Author: by DaiLiang
 * Describe:
 * Created on 2018/1/21.
 */
public class RedisCluster {
    @Test
    public void testJedisCluster() {
        /*redis 自带连接池*/
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.1.16", 7001));
        nodes.add(new HostAndPort("192.168.1.16", 7002));
        nodes.add(new HostAndPort("192.168.1.16", 7003));
        nodes.add(new HostAndPort("192.168.1.16", 7004));
        nodes.add(new HostAndPort("192.168.1.16", 7005));
        nodes.add(new HostAndPort("192.168.1.16", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);
        try{
            cluster.close();
        }catch (Exception e){

        }

    }
}
