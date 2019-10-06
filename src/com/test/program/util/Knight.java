package com.test.program;

class Knight {
	private static final int N = 10;
	private static int mBoard[][] = new int[N][N];
	private static int result = 0;
	private static Knight mKnight;
	private Knight() {}

	public static synchronized Knight getInstance() {
		if(mKnight == null) {	
			mKnight = new Knight();
		}
		return mKnight;
	}

	public int getResult(int x, int y, int n) {
		for(int i=0; i<N; i++) {
			mBoard[i] = new int[N];
			for(int j=0; j<N;j++) {
				mBoard[i][j] = 0;	
			}		
		}
		solve_problem(x,y,n);
		return result-1;
	}

	public int[][] getSolution() {
		return mBoard;
	}

	private void solve_problem(int x, int y, int n) {
		if(x<0 || x>=10 || y<0 ||y>=10) return;

		if(n==0) {
			if(mBoard[x][y] == 0) {
				mBoard[x][y] = 1;
				result++;
			}
			return;		
		}
		if(mBoard[x][y] == 0) {	
			mBoard[x][y] = 1;
			result++;
			solve_problem(x-1,y-2,n-1);
			solve_problem(x-2,y-1,n-1);
			solve_problem(x-2,y+1,n-1);
			solve_problem(x-1,y+2,n-1);
			solve_problem(x+1,y+2,n-1);
			solve_problem(x+2,y+1,n-1);
			solve_problem(x+1,y-2,n-1);
			solve_problem(x+2,y-1,n-1);
		}
	}
}
