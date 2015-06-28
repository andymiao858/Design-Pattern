package com.rabbit.designpattern.structural;


public class Facade2 {
	
	public static void main(String[] args){
		Facade facade = new FacadeImpl();
		facade.assembleCPU();
		facade.assembleMem();
		facade.assembleMainBoard();
		
	}
	
	
	public static interface Facade{
		
		public void assembleComputer();
		
		public void assembleCPU();
		
		public void assembleMem();
		
		public void assembleMainBoard();
		
	}
	
	public static class FacadeImpl implements Facade{

		@Override
		public void assembleComputer() {
			CPU cpu = new CPUImpl();
			cpu.assembleCPU();
			
			Memory mem = new MemoryImpl();
			mem.assembleMem();
			
			MainBoard board = new MainBoardImpl();
			board.assembleMainBoard();
			
		}
		
		@Override
		public void assembleCPU() {
			CPU cpu = new CPUImpl();
			cpu.assembleCPU();
		}
		
		@Override
		public void assembleMem() {
			Memory mem = new MemoryImpl();
			mem.assembleMem();
		}
		
		@Override
		public void assembleMainBoard() {
			MainBoard board = new MainBoardImpl();
			board.assembleMainBoard();
			
		}
		
	}
	
	public static interface CPU{
		public void assembleCPU();
	}
	
	public static class CPUImpl implements CPU{

		@Override
		public void assembleCPU() {
			System.out.println("Assemble intel CPU.");
		}
	}
	
	public static interface Memory{
		public void assembleMem();
	}
	
	public static class MemoryImpl implements Memory{

		@Override
		public void assembleMem() {
			System.out.println("Assemble Kingston Mem.");
		}
	}
	
	public static interface MainBoard{
		public void assembleMainBoard();
		public void addCPU();
		public void addMemory();
	}
	
	public static class MainBoardImpl implements MainBoard{

		@Override
		public void assembleMainBoard() {
			System.out.println("Assemble Asus MainBoard.");
		}

		@Override
		public void addCPU() {
			System.out.println("Add CPU to MainBoard.");
			
		}

		@Override
		public void addMemory() {
			System.out.println("Add Memory to MainBoard.");
		}
		
		
	}


}
