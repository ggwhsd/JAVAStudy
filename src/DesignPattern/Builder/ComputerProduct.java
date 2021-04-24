package DesignPattern.Builder;

public class ComputerProduct {
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getMem() {
		return Mem;
	}
	public void setMem(String mem) {
		Mem = mem;
	}
	public String getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}
	public boolean isGPU() {
		return GPU;
	}
	public void setGPU(boolean gPU) {
		GPU = gPU;
	}
	private String CPU;
	private String Mem;
	private String hardDisk;
	private boolean GPU;
	
	
	@Override
    public String toString() {
		return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", memory='" + Mem + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", gPU='" + GPU +
                '}';
	}
	
	
}
