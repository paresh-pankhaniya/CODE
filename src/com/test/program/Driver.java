package com.test.program;

import java.util.Scanner;

public class Driver {
	int mIndexOfProblem;
	static Scanner in = new Scanner(System.in);
	public static void main(String arg[]) {
		System.out.print("1. Nqueen problem \n");
		System.out.print("Please Enter(number) the choise of "+
			"problem you want to solve.\n");
		int mIndexOfProblem = Integer.parseInt(in.next());
		switch(mIndexOfProblem) {
			case 1:
				new Driver().solveNQueen();
				break;		
		}
	}
	
	private void solveNQueen() {
		System.out.println("Please Enter the N, for Nqueen");
		int n = Integer.parseInt(in.next());
		Nqueen mQueen = Nqueen.getInstance(n);
		String str="";
		boolean ans = false;
		System.out.println("Getting	result.....");		
		if(mQueen.getResult(n)) {
			int solution [][] = mQueen.getSolution();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n;j++) {
					System.out.println(i+" "+j+" "+solution[i][j]);	
				}		
			}
		} else {
			System.out.println("No Solution");			
		}
		
			
	}
}
