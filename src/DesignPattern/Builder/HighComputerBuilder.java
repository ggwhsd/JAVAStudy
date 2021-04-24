package DesignPattern.Builder;

public class HighComputerBuilder implements ComputerBuilder {

	@Override
	public ComputerBuilder cpu(String cpu) {
	
		return this;
	}

	@Override
	public ComputerBuilder gpu(boolean gpu) {
	
		return this;
	}

	@Override
	public ComputerBuilder mem(String mem) {

		return this;
	}

	@Override
	public ComputerBuilder hardDisk(String hdd) {
		
		return this;
	}

	@Override
	public ComputerProduct Build() {
		ComputerProduct cp = new ComputerProduct();
		cp.setCPU("h");
		cp.setGPU(true);
		cp.setHardDisk("500T");
		cp.setMem("32g");
		return cp;
	}

}
