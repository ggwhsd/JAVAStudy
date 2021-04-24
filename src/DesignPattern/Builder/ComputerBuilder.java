package DesignPattern.Builder;

public interface ComputerBuilder {
	public ComputerBuilder cpu(String cpu);
	public ComputerBuilder gpu(boolean gpu);
	public ComputerBuilder mem(String mem);
	public ComputerBuilder hardDisk(String hdd);
	public ComputerProduct Build();
}
