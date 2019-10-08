package com.test.program;

class MidString {

	private static MidString mMidString;
	private MidString() {}

	public static synchronized MidString getInstance() {
		if(mMidString == null) {
			mMidString = new MidString();
		}
		return mMidString;
	}

	public String getResult(int strLen, String str) {
		if(strLen == 1 || strLen == 2) return str;
		return solveProblem(strLen,str);

	}

	private String solveProblem(int n, String str) {
		if(n == 0) return "";
		if(n == 1) return str;
		int mid = -1;
		if((n & 1) == 0){  //even number
			mid = (n-1)/2;
		} else {
			mid = n/2;
		}
		String leftSubString = str.substring(0,mid);
		String rightubString = str.substring(mid+1,n);

		return str.charAt(mid) + solveProblem(leftSubString.length(), leftSubString) +
				solveProblem(rightubString.length(), rightubString);
	}
}