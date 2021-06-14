package com.gugw.demo.redis;

import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisApp {
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
    public static void ShowAllKeys(Jedis jedis)
    {
    	showln("===============获取所有key=====================");
    	Set<String> keys = jedis.keys("*");
    	 Iterator<String> it=keys.iterator() ; 
    	 while(it.hasNext()){  
    		 String key = it.next();
    		 
    		 if(jedis.type(key).equals("string"))
    		 {
    			 showln("key:"+key+" type:"+jedis.type(key) +" value:"+jedis.get(key));
    		 }
    		 else
    		 {
    			 showln("key:"+key+" type:"+jedis.type(key));
    		 }
    	 }
    }
    public static void DeleteKey(Jedis jedis,String key)
    {
    	ExistKey(jedis,key);
    	showln("删除Key："+key+":"+jedis.del(key));
    }
    public static boolean ExistKey(Jedis jedis, String key)
    {
    	showln("判断Key： "+ key +" 是否存在："+jedis.exists(key));
    	return jedis.exists(key);
    }
    public static void SetKey(Jedis jedis, String key, String value)
    {
    	showln("设置Key： "+ key +" 值为："+value);
    	jedis.set(key,value);
    }
    public static void ExpireKey(Jedis jedis,String key,int seconds)
    {
    	showln("设置Key的超时:"+key+" "+seconds);
    	jedis.expire(key, seconds);
    	
    }
    public static void CancelExpireKey(Jedis jedis ,String key)
    {
    	;
    	showln("取消Key的超时设定："+key +" 剩余时间:"+jedis.ttl(key));
    	jedis.persist(key);
    }
    
    //jedis.mset可以一次性设置多个key和value
    //jedis.mget可以一次性获取多个
    //jedis.del(new String[]{"1", "2"}) 一次性删除多个
    
    
    public static void ClearDB(Jedis jedis)
    {
    	jedis.flushDB();
    	
    }
    //列表操作
    public static void ListOp(Jedis jedis)
    {
    	
    	Date today = new Date();
    	
    	int days =7;
    	while(days>0)
    	{
    		jedis.lpush("list1", today.toString());
    		showln("添加列表中元素 "+today.toString());
    		today=new Date(today.getTime() + 1 * 24 * 60 * 60 * 1000);
    		days--;
    	}
    	jedis.lpop("list1"); //出栈，也会删除该元素
    	showln("===========列表==================");
    	showln("长度："+jedis.llen("list1"));
    	for(String value : jedis.lrange("list1", 0, -1))
    	{
    		showln("删除"+value);
    		jedis.lrem("list1",1,value);
    		//jedis.ltrim删除一个区间的数据
    	}
    	for(String value : jedis.lrange("list1", 0, -1))
    	{
    		showln("存在"+value);
    		
    	}
    	//jedis.lindex获取某个位置上的value
    	
    }
    
    //集合操作
    public static void SetOp(Jedis jedis)
    {
    	System.out.println("向sets集合中加入元素："+jedis.sadd("sets", "1")); 
        System.out.println("向sets集合中加入元素："+jedis.sadd("sets", "2"));
        showln("集合中有如下数据:");
        for(String value :jedis.smembers("sets"))
        {
        	showln(value);
        }
        showln("删除集合中某个元素");
        jedis.srem("sets", "1");
        showln("集合中有如下数据:");
        for(String value :jedis.smembers("sets"))
        {
        	showln(value);
        }
        System.out.println("判断是否在集合sets中："+jedis.sismember("sets", "2"));
        
        System.out.println("sets2中添加元素1："+jedis.sadd("sets2", "1")); 
        System.out.println("sets2中添加元素2："+jedis.sadd("sets2", "2")); 
        showln("集合操作");
        showln("sets中交集合："+jedis.sinter("sets2", "sets")); 
        showln("sets中并集合："+jedis.sunion("sets","sets2"));
        showln("sets中差集合："+jedis.sdiff("sets","sets2"));
    }
    
    //有效集合
    public static void SortedSetOp(Jedis jedis)
    {
    	System.out.println("向zsets集合中加入元素："+jedis.zadd("zsets", 1.0,"1")); 
        System.out.println("向zsets集合中加入元素："+jedis.zadd("zsets", 2.0,"2"));
        showln(""+jedis.zrange("zsets", 0, -1));
        showln("集合中有如下数据:");
        for(String value :jedis.zrange("sets",0,-1))
        {
        	showln(value);
        }
        showln("删除集合中某个元素");
        jedis.zrem("sets", "1");
        showln("集合中有如下数据:");
        for(String value :jedis.zrange("sets",0,-1))
        {
        	showln(value);
        }
        showln("统计zsets中元素个数："+jedis.zcard("zset") );
        showln("统计zsets中某个权重范围的元素个数："+jedis.zcount("zset",0,5) );
        showln("查看zsets中某个元素的权重:"+jedis.zscore("zset","1"));

    }
    
    public static void HashOp(Jedis jedis)
    {
    	showln("向hashdb中添加key和value"+jedis.hset("hashdb", "key1", "value1"));
    	showln("向hashdb中添加key和value"+jedis.hset("hashdb", "key2", "value2"));
    	showln("获取hashdb中的所有value");
    	for(String value :jedis.hvals("hashdb"))
        {
        	showln(value);
        }
    	showln("获取hashdb中的所有key");
    	for(String key :jedis.hkeys("hashdb"))
        {
        	showln(key);
        }
    	jedis.hdel("hashdb", "key1");
    	showln("对hashdb中key3进行增加数值计算");
    	jedis.hincrBy("hashdb", "key3", 1);
    	jedis.hincrBy("hashdb", "key3", 1);
    	showln("判断是否存在某个key:"+jedis.hexists("hashdb","key3"));
    	showln("获取是否存在某个key:"+jedis.hget("hashdb","key3"));
    	showln("获取是否存在某个key:"+jedis.hmget("hashdb","key3","key1"));
    	
    }
    
    //redis的其他一些操作
    public static void OthreOP(Jedis jedis)
    {
    	//showln("将数据同步保存到磁盘"+jedis.save());
    	//showln("将数据异步保存到磁盘"+jedis.bgsave());
    	showln("获取上次保存的时间戳"+jedis.lastsave() + " 时间:"+new Date(jedis.lastsave()).toString());
    	//showln("保存数据到磁盘，并且关闭redis server，该操作会中断所有其他客户端到server上的连接"+jedis.shutdown());
    	showln("获取redis上的统计信息"+jedis.info());
    	
    }
    
	public static void main(String[] args) throws InterruptedException {
		
		Jedis jedis = getJedis();
		System.out.println("redis connect status :"+jedis.isConnected());
		System.out.println("redis ping :"+jedis.ping());
		SetKey(jedis,"SetKey",new Date().toString());
		ExpireKey(jedis,"SetKey",1);
		ExistKey(jedis,"SetKey");
		Thread.sleep(2000);
		DeleteKey(jedis,"SetKey");
		SetKey(jedis,"SetKey",new Date().toString());
		ExpireKey(jedis,"SetKey",10);
		Thread.sleep(1000);
		CancelExpireKey(jedis,"SetKey");
		showln("获取一个key的value，"+ jedis.getSet("SetKey","value2") +"并将其设置为新的value2");
		showln(jedis.get("SetKey"));
		//ShowAllKeys(jedis);
		ListOp(jedis);
		SetOp(jedis);
		SortedSetOp(jedis);
	}

}
