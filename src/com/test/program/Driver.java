package com.test.program;

import java.util.Scanner;

public class Driver {
	int mIndexOfProblem;
	static Scanner in = new Scanner(System.in);
	public static void main(String arg[]) {
		System.out.print("1. Nqueen problem \n2. Knight Problem\n3. String manipulation\n");
		System.out.print("Please Enter(number) the choise of "+
			"problem you want to solve.\n");
		int mIndexOfProblem = Integer.parseInt(in.next());
		Driver mDriver = new Driver();
		switch(mIndexOfProblem) {
			case 1:
				mDriver.solveNQueen();
				break;
			case 2:
				mDriver.solveKnight();
				break;
			case 3:
				mDriver.SolveStringProblem();
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

	private void solveKnight() {
		System.out.println("Please Enter the x,y and N, for Knight problem," +
			"it should be in one line and one space seperated.");
		int x = Integer.parseInt(in.next());
		int y = Integer.parseInt(in.next());
		int n = Integer.parseInt(in.next());
		Knight mKnight = Knight.getInstance();
		System.out.println("The result is :"+mKnight.getResult(x,y,n));
	}

	private void SolveStringProblem() {
		System.out.println("Please Enter the T(number of TEST CASES) ,N(length of string) and String ," +
			"please check README for example Test case");
		int T = Integer.parseInt(in.next());
		int n = Integer.parseInt(in.next());
		String str = in.next();
		for(int i=0; i<T; i++) {
			System.out.println("Result for TestCase "+ i +"is : " +
				MidString.getInstance().getResult(n, str));
		}
	}
}
