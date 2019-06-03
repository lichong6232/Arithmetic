package cn.bupt.tree;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String s = "aba";
    }

	public static int getMaxSubSequenceLength(String s){
	    int dp[][] = new int[s.length()][s.length()];

        for (int j=0;j<dp.length;j++){
            dp[j][j] = 1;
	        for (int i=j-1;i>=0;i--){
	            if (s.charAt(i) == s.charAt(j)){
	                int tmp = dp[i+1][j-1];
	                if (tmp >0){
	                    dp[i][j] = tmp+2;
                    }
                }else {
	                dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[0][s.length()-1];
    }


}
