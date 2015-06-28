package com.rabbit.designpattern.structural;

public class Facade1 {
	
	public static void main(String[] args){
		Facade f = new Facade();
		f.assembleComputer();
		
	}
	
	
	public static class Facade{
		
		public void assembleComputer(){
			CPU cpu = new CPUImpl();
			cpu.assembleCPU();
			
			Memory mem = new MemoryImpl();
			mem.assembleMem();
			
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
	}
	
	public static class MainBoardImpl implements MainBoard{

		@Override
		public void assembleMainBoard() {
			System.out.println("Assemble Asus MainBoard.");
		}
		
	}

}
