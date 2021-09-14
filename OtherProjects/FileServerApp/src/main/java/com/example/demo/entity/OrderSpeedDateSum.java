package com.example.demo.entity;

public class OrderSpeedDateSum {
	public OrderSpeedDateSum(String actionDay, int sumOrder) {
		super();
		ActionDay = actionDay;
		SumOrder = sumOrder;
	}
	public String getActionDay() {
		return ActionDay;
	}
	public void setActionDay(String actionDay) {
		ActionDay = actionDay;
	}
	public int getSumOrder() {
		return SumOrder;
	}
	public void setSumOrder(int sumOrder) {
		SumOrder = sumOrder;
	}
	private String ActionDay;
private int SumOrder;

}
