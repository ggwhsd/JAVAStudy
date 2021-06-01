package com.gugw.demo.activeMQ;

public class activeMQApp {

	public static void main(String[] args) {
		Producer producter = new Producer();
		producter.setBROKEN_URL("failover://tcp://192.168.101.21:61616");
		producter.init();
		System.out.println("init-"+producter.getBROKEN_URL());
		new Thread(new producterSend(producter)).start();
		Comsumer comsumer = new Comsumer();
		comsumer.BROKEN_URL ="failover://tcp://192.168.101.21:61616";
        comsumer.init();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        comsumer.getMessage("testMQ");
        
	}
	
	

}

class producterSend implements  Runnable
{
	Producer pro;
    public producterSend(Producer p){
        this.pro = p;
    }
    

    public void run() {
      
    	pro.sendMessage("testMQ");
           
        }
}
