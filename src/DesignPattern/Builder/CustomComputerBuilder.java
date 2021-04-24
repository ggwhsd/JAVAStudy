package DesignPattern.Builder;

public class CustomComputerBuilder implements ComputerBuilder {

	private String cpu;
	private String mem;
	private String hdd;
	private boolean gpu;
	
	public CustomComputerBuilder()
	{
		
	}
	public ComputerBuilder cpu(String cpu)
	{
		this.cpu = cpu;
		return this;
	}
	public ComputerBuilder gpu(boolean gpu)
	{
		this.gpu = gpu;
		return this;
	}
	public ComputerBuilder mem(String mem)
	{
		this.mem = mem;
		return this;
	}
	public ComputerBuilder hardDisk(String hdd)
	{
		this.hdd = hdd;
		return this;
	}
	@Override
	public ComputerProduct Build() {
		ComputerProduct cp = new ComputerProduct();
		cp.setCPU(cpu);
		cp.setGPU(gpu);
		cp.setHardDisk(hdd);
		cp.setMem(mem);
		return cp;
	}

	
}
