package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Author: by DaiLiang
 * Describe:
 * Created on 2018/1/18.
 */
public class RedisSingle {
    @Test
    public void jedisSingle(){
        Jedis jedis =new Jedis("192.168.1.16",6379);
            jedis.set("key1","hello");
            String value = jedis.get("key1");
            System.out.println(value);
            jedis.close();
    }

    /**
     * 使用连接连接池连接redis
     */
    @Test
    public void pool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大连接空闲数
        config.setMaxIdle(2);

        JedisPool pool = new JedisPool(config, "192.168.1.16", 6379);
        Jedis jedis = null;

        try  {
            jedis = pool.getResource();

            jedis.set("name", "lisi");
            String name = jedis.get("name");
            System.out.println(name);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(jedis != null){
                //关闭连接
                jedis.close();
            }
        }

    }
}
