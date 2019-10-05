package com.test.program;

class Nqueen {
	private static int N;
	private static int solution[][];
	private static Nqueen mNqueen= null;

	private Nqueen() {}

	public static synchronized Nqueen getInstance(int n) {		
		if(mNqueen == null) {
			mNqueen = new Nqueen();		
		}
		N = n;
		solution = new int[n][n];
		return mNqueen;
	}

	public boolean getResult(int n) {
		for(int i=0; i<n; i++) {
			solution[i] = new int[n];
			for(int j=0; j<n;j++) {
				solution[i][j] = 0;	
			}		
		}
		if(solve_nqueen(n,0,0)) return true;		
		return false;
	}
	
	public int[][] getSolution() {
		return solution;	
	}

	private boolean isAttacked(int x, int y) {
		//for x row
		for(int i =0; i<N; i++) {
			if(solution[x][i]==1) return true;
			//System.out.println("isAttacked for row:"+i);
		}
	
		//for y col
		for(int j=0; j<N; j++) {
			if(solution[j][y]==1) return true;
			//System.out.println("isAttacked for rcol:"+j);	
		}

		//for low diagonal
		for(int i=x-1,j=y-1; i>=0 && j >=0;i--,j--) {
			if(solution[i][j]==1) return true;
		}
		//for upper diagonal
		for(int i=x-1,j=y+1; i>=0 && j <=N-1;i--,j++) {
			if(solution[i][j]==1) return true;
		}
		return false;
	}
	private boolean solve_nqueen(int n,int r,int c) {
		if(n == 0) {
			return true;		
		}
		for(int i=0;i<N; i++) {
				if(isAttacked(r,i)) {
					//System.out.println("i,j"+r+" ," +i);
					continue;				
				}
				solution[r][i] = 1;
//				System.out.println("i,j >>>>:"+r+" ," +i);
				if(solve_nqueen(n-1,r+1,0)) return true;
//				System.out.println("i,j <<<<<:"+r+" ," +i);
				solution[r][i] = 0;		
		}
		return false;
	}		
}
