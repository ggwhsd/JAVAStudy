package com.gugw.demo.zookeeperDemo;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class MyWatcher implements Watcher{

	public ZooKeeper getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZooKeeper zkClient) {
		this.zkClient = zkClient;
	}

	private ZooKeeper zkClient;
	
	public void process(WatchedEvent event) {
		
		if(zkClient==null)
			return;
		List<String> children = null;
		try {
			children = zkClient.getChildren("/", true);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String child : children)
		{
			System.out.println(child);
		}
	}

}
