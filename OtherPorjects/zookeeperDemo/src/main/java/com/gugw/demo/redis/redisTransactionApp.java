package com.gugw.demo.redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

public class redisTransactionApp {
	private static String ADDR = "192.168.101.21";
	private static int PORT = 6379;
	private static String AUTH = "foobared";

	//可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            
            config.setMaxIdle(MAX_IDLE);
           
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
        	jedis.close();
        }
    }
    
    public static void showln(String str)
    {
    	System.out.println(str);
    }
	public static void main(String[] args) {
		Jedis jedis = getJedis();
		String key = "money";
		
		jedis.setnx(key, "1000");

		Long value = Long.parseLong(jedis.get(key));
		jedis.watch(key); //观察key，事务EXEC时，如果观察的key被其他连接修改，则EXEC会执行失败。可以看作是一种乐观锁
		int useMoney=500;
		if(null == jedis.get(key))
		{
			jedis.unwatch();
			showln("不存在key");
		}
		else
		{
			Transaction transaction = jedis.multi();
			if(useMoney>value)
			{
				transaction.discard();//取消事务。
				showln("钱不够");
				jedis.incrBy(key, 10000);
			}
			else {
				transaction.decrBy(key, useMoney);
				try {
					showln("模拟其他客户端操作");
					Thread.sleep(5000); //以便其他客户端修改数据，方便模拟。
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				//showln(jedis.get(key)); 在multi标志后，是不能使用jedis的，否则会报错。
				
				List<Object> exec = transaction.exec(); // 执行exec后，之前的监控锁都自动取消掉
				
				if(exec==null || exec.size()<=0)
				{
					showln("其他客户端已经对key进行了修改，事务无法执行。");
				}
				else
				{
					for(Object j : exec)
					{
						showln("exec的结果"+j.toString());
					}
				}
			}
		}
		
		

	}

}
