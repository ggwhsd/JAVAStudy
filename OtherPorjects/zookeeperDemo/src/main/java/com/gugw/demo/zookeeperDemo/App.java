package com.gugw.demo.zookeeperDemo;

import org.apache.zookeeper.KeeperException;

/**
 * Hello world!
 *
 */
public class App 
{
	//参数为主机名
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("输入参数:");
        StringBuilder sbtr = new StringBuilder();
        
        for(String arg : args)
        {
        	sbtr.append(arg).append(" ");
        }
        sbtr.append("\r\n");
        System.out.println(sbtr);
        if(args.length>0)
        {
	        DistributeServer server = new DistributeServer();
	        server.getConnect();
	        try {
				server.reister(args[0]);
				server.business();
	        } catch (KeeperException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        else
        {
        	DistributeClient client = new DistributeClient();
        	client.getConnect();
	        try {
	        	
	        	
	        	
	        	client.getChildren();
	        	client.business();
				
				
				
				
				
				
	        } catch (KeeperException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
        }
    }
}
