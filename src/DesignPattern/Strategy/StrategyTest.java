package DesignPattern.Strategy;

public class StrategyTest {

	public static void main(String[] args) {
		
		ICalculator cal = new Plus(); 
		System.out.println(cal.calculate("1+7"));  
		
		cal = new Minus(); 
		System.out.println(cal.calculate("1-7"));  
		
		cal = new Multiply(); 
		System.out.println(cal.calculate("1*7"));  
		
		
		
	}

}
