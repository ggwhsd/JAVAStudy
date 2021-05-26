package com.gugw.demo.zookeeperDemo;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class DistributeWatcher  implements Watcher{

private ZooKeeper zkClient;
	
	public DistributeWatcher(ZooKeeper zkClient)
	{
		this.zkClient = zkClient;
	}
	public void process(WatchedEvent event) {
		
		if(zkClient==null)
			return;
		List<String> children = null;
		try {
			children = zkClient.getChildren("/server", false)	;
			List<String> hosts=  new ArrayList<String>();
			for(String child : children)
			{
				byte[] data=zkClient.getData("/server/"+child, false, null);
				System.out.println("+"+child);
				if(data!=null)
					hosts.add(new String(data));
			}
			
			System.out.print(hosts);
		} catch (KeeperException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
