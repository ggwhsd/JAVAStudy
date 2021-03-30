package com.gugw.demo.zookeeperDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class DistributeClient {

	private String connctString = "192.168.101.21:30183";
	private int sessionTimeout = 2000;
	private ZooKeeper zkClient=null;
	
	public DistributeClient()
	{
		
	}
	
	public void getConnect()
	{
		
		try {
    		zkClient=new ZooKeeper(connctString,sessionTimeout,null
			);
    		try {
				zkClient.addWatch("/server", new DistributeWatcher(zkClient), AddWatchMode.PERSISTENT);
			} catch (KeeperException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void getChildren() throws KeeperException, InterruptedException
	{
		List<String> children = zkClient.getChildren("/server", true)	;
		List<String> hosts=  new ArrayList<String>();
		for(String child : children)
		{
			byte[] data=zkClient.getData("/server/"+child, false, null);
			if(data!=null)
				hosts.add(new String(data));
		}
		
		System.out.print(hosts);
	}
	
	public void business() throws InterruptedException
	{
		Thread.sleep(100000);
	}
}
