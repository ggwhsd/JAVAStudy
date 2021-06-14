package com.gugw.demo.zookeeperDemo;

/**
 * Unit test for simple App.
 */
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;;

public class TestZookeeper extends TestCase {
	

	 public TestZookeeper( String testName )
	    {
	    	
	        super( testName );
	        
	    }

	    /**
	     * @return the suite of tests being tested
	     */
	    public static Test suite()
	    {
	    	
	        return new TestSuite( TestZookeeper.class );
	    }

	    
	    /**
	     * Rigourous Test :-)
	     * 每个测试方法，都会创建一个测试实例
	     */
	    public void testInit()
	    {
	    	ZooKeeper zkClient = null;
	    	try {
	    		zkClient=new ZooKeeper("192.168.101.21:30183",2000,new Watcher() {
	    			
					public void process(WatchedEvent event)
					{}
				}
				);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	        assertTrue( true );
	    }
	    
	    public void testCreateNode()
	    {
	    	ZooKeeper zkClient = null;
	    	String path="";
	    	try {
	    		zkClient=new ZooKeeper("192.168.101.21:30183",2000,new Watcher() {
	    			
					public void process(WatchedEvent event)
					{}
				}
				);
	    		
	    		path = zkClient.create("/node3","node3 data xxxyyyzzz".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	    		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeeperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("here show testCreateNode");
	        assertTrue( "/node3".equals(path) );
	    }
	    
	    public void testtestGetNode()
	    {

	    	ZooKeeper zkClient = null;
	    	String path="";
	    	try {
	    		zkClient=new ZooKeeper("192.168.101.21:30183",2000,new Watcher() {
	    			
					public void process(WatchedEvent event)
					{}
				}
				);
	    		Stat stat = zkClient.exists("/node3", false);

	    		path = zkClient.create("/node3","node3 data xxxyyyzzz".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	    		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeeperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("here show testGetNode");
	        assertTrue( "/node3".equals(path) );
	        assertTrue( true );
	    }
	    
	    public void testGetDataAndWatch()
	    {
	    	ZooKeeper zkClient = null;
	    	List<String> children = null;
	    	try {
	    		MyWatcher watch = new MyWatcher();
	    		
	    		zkClient=new ZooKeeper("192.168.101.21:30183",2000,watch);
	    		watch.setZkClient(zkClient);
	    		
	    		children = zkClient.getChildren("/", true);
	    		for(String child : children)
	    		{
	    			System.out.println(child);
	    		}
	    		Thread.sleep(10000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeeperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println("here show testGetDataAndWatch");
	    	
	        assertTrue( children.size()>0 );
	    }
}
