package DesignPattern.Flyweight;

public class SpecificFlyweight extends  Flyweight {
	 private String Innerstate;
	 public SpecificFlyweight(String innerstate) 
     {
         this.Innerstate = innerstate;
     }
	 @Override
	 public void OutInput(int externalstate)
     {
         System.out.println("内部状态："+Innerstate+"————外部状态："+externalstate+"");
     }
	 
}
