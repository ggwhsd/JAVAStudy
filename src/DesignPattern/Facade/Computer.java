package DesignPattern.Facade;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<CPU> cpus=new ArrayList<CPU>();
	private List<Memory> mems =new ArrayList<Memory>();
	private List<Disk> disks = new ArrayList<Disk>();
	
	public Computer(int a,int b,int c)
	{
		while(a>0)
		{
			cpus.add(new CPU(a));
			a--;
		}
		while(b>0)
		{
			mems.add(new Memory(b));
			b--;
		}
		while(c>0)
		{
			disks.add(new Disk(c));
			c--;
		}
	}
	
	public void Start()
	{
		for(CPU cpu : cpus)
		{
			cpu.Start();
		}
		for(Memory mem : mems)
		{
			mem.Start();
		}
		for(Disk disk : disks)
		{
			disk.Start();
		}
	}
	
	public void Shutdown()
	{
		for(CPU cpu : cpus)
		{
			cpu.Shutdown();
		}
		for(Memory mem : mems)
		{
			mem.Shutdown();
		}
		for(Disk disk : disks)
		{
			disk.Shutdown();
		}
	}
	public void StartCPU()
	{
		for(CPU cpu : cpus)
		{
			cpu.Start();
		}
	}
	public void ShutdownCPU()
	{
		for(CPU cpu : cpus)
		{
			cpu.Shutdown();
		}
	}
	
}
