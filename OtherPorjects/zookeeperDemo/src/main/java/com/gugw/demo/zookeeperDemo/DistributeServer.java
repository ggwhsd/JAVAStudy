package com.gugw.demo.zookeeperDemo;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class DistributeServer {

	public DistributeServer()
	{
		
	}
	
	private String connctString = "192.168.101.21:30183";
	private int sessionTimeout = 2000;
	private ZooKeeper zkClient=null;
	
	public void getConnect()
	{
		
		try {
    		zkClient=new ZooKeeper(connctString,sessionTimeout,new Watcher() {
    			
				public void process(WatchedEvent event)
				{
					
				}
			}
			);
    		
    				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void reister(String hostname) throws KeeperException, InterruptedException
	{
		
		
		String path =zkClient.create("/server/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname+"is online");
		
	}
	
	public void business() throws InterruptedException
	{
		Thread.sleep(100000);
	}
}
