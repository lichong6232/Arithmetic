package cn.bupt.other.methods;

public class DynamicPlaning {
	
	
	public static void main(String[] args) {
//		System.out.println(getMaxSubSequenceLength("abcdfcba"));
//		System.out.println(getSubSequenceCount("aba"));
//		System.out.println(getMaxSubStringLength("abcddceba"));
//		System.out.println(isPlalindrome("bb"));
		
//		System.out.println("需要在末尾添加的字符为："+addTailStringTurnToPlalindrome("abb"));
		/*int map[][]=new int[][]{{1,2,3},{1,1,1}};
		System.out.println(getMinPath(map,2,3));*/
		/*int job[]={3072,3072,7168,3072,1024};
		int jobLength[]=new int[job.length];
		int sum=0;
		for(int i=0;i<job.length;i++){
			int jobValue=job[i]>>10;
			jobLength[i]=jobValue;
			sum+=jobValue;
		}
		int w=sum/2;
		int ret=getMinTimeDoubleCpu(w,jobLength);
		int countTimes=(sum-ret)<<10;
		System.out.println(countTimes);*/
		System.out.println(getMaxCommonSequenceLength("1A2C3D4B56","B1D23CA45B6A"));
	}
	
	/*
	 * 最长回文子序列
	 * 给定字符串，求它的最长回文子序列长度。回文子序列反转字符顺序后仍然与原序列相同。例如字符串abcdfcba中，最长回文子序列长度为7，abcdcba或abcfcba。
	 */
	public static int getMaxSubSequenceLength(String s){
		int sLength=s.length();
		int dp[][]=new int[sLength][sLength];
		//dp[i][j]表示i到j之间的字符的最大回文子序列长度
		for(int j=0;j<sLength;j++){
			dp[j][j]=1;
			for(int i=j-1;i>=0;i--){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j]=dp[i+1][j-1]+2;
				}else{
					dp[i][j]=dp[i+1][j]>dp[i][j-1]?dp[i+1][j]:dp[i][j-1];
				}
			}
			
		}
		
		return dp[0][sLength-1];
	}
	
	/*
	 * 判断一个字符串是否是回文
	 * 内部方法
	 */
	private static boolean isPlalindrome(String s){
		int i=0,j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
			++i;
			--j;
		}
		return true;
	}
	
	
	/*
	 * 回文子序列个数
	 * 给定字符串，求它的回文子序列个数。回文子序列反转字符顺序后仍然与原序列相同。例如字符串aba中，回文子序列为"a", "a", "aa", "b", "aba"，共5个。内容相同位置不同的子序列算不同的子序列。
	 */
	public static int getSubSequenceCount(String s){
		int sLength=s.length();
		int dp[][]=new int[sLength][sLength];
		//d[i][j]表示回文子序列个数
		for(int j=0;j<sLength;j++){
			dp[j][j]=1;
			for(int i=j-1;i>=0;i--){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j]=dp[i+1][j]+dp[i][j-1]+1;
				}else{
					dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
				}
			}
		}
		
		return dp[0][sLength-1];
	}
	
	/*
	 * 给定一个字符串A以及它的长度n返回最长回文子串的长度
	 * 例如："abc1234321ab",12
	 * 返回：7
	 */
	public static int getMaxSubStringLength(String s){
		int sLength=s.length();
		int dp[][]=new int[sLength][sLength];
		for(int j=0;j<sLength;j++){
			dp[j][j]=1;
			for(int i=j-1;i>=0;i--){
				if(s.charAt(i)==s.charAt(j)){
					int temp=j-i-1;
					if(temp==dp[i+1][j-1]){
						dp[i][j]=dp[i+1][j-1]+2;
					}else{
						dp[i][j]=dp[i+1][j-1];
					}
				}else{
					dp[i][j]=dp[i][j-1]>dp[i+1][j]?dp[i][j-1]:dp[i+1][j];
				}
			}
		}
		
		return dp[0][sLength-1];
	}
	
	/*
	 * 对于一个字符串通过在原字符的末尾添加字符使新的字符变成回文串
	 * 例如："ab"，提那家"a"
	 */
	
	public static String addTailStringTurnToPlalindrome(String s){
		int sLength=s.length();
		int matchIndex=-1;
		for(int i=0;i<sLength;i++){
			String tempString=s.substring(i, sLength);
			
			if(isPlalindrome(tempString)){
				matchIndex=i;
				break;
			}
		}
		
		
		return s.substring(0,matchIndex);
	}
	
	
	/*
	 * 0-1背包问题
	 * 假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值为6。将哪些物品放入背包可使得背包中的总价值最大？
	 */
	public static int maxPrice(int weight[], int price[], int maxWeight){
		int dp[][]=new int[weight.length+1][maxWeight+1];
		for (int i=1;i<dp.length;i++){
			for (int j=1;j<dp[0].length;j++){
				if (weight[i-1]<j){
					if (dp[i-1][j]<dp[i-1][j-weight[i-1]]+price[i-1]){
						dp[i][j]=dp[i-1][j-weight[i-1]]+price[i-1];
					}else {
						dp[i][j]=dp[i-1][j];
					}
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[weight.length][maxWeight];

	}
	
	
	/*
	 * 找零钱问题
	 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
		给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
		测试样例：
		[1,2,4],3,3
		返回：2
	 */
	
	/*
	 * 走方格问题
	 * 
	 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
		给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
		测试样例：
		[[1,2,3],[1,1,1]],2,3
		返回：4
	 * 
	 */

	public static int getMinPath(int map[][],int m, int n){
		int dp[][]=new int[m][n];
		dp[0][0]=map[0][0];
		for (int i=1;i<m;i++){
			dp[i][0]=dp[i-1][0]+map[i][0];
		}
		for (int j=1;j<n;j++){
			dp[0][j]=dp[0][j-1]+map[0][j];
		}
		for (int i=1;i<m;i++){
			for (int j=1;j<n;j++){
				dp[i][j]=dp[i-1][j]<dp[i][j-1]?dp[i-1][j]:dp[i][j-1]+map[i][j];
			}
		}
		return dp[m-1][n-1];
	}
	
	
	
	/*
	 * 走台阶问题
	 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
			给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
			测试样例：
			1
			返回：1
	 */
	
	public static int getCountWays(int n){
		int countWays=0;
		if(n<=2){
			return n;
		}
		return getCountWays(n-1)+getCountWays(n-2);
		
	}
	
	
	
	/*
	 * 最长公共序列数
	 * 
	 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
		给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
		测试样例：
		"1A2C3D4B56",10,"B1D23CA45B6A",12
		返回：6
	 */

	public static int getMaxCommonSequenceLength(String s1, String s2){
		int length1 = s1.length();
		int length2 = s2.length();
		int dp[][] = new int [length1+1][length2+1];
		for (int i=1;i<=length1;i++){
			for (int j=1;j<=length2;j++){
				if (s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[length1][length2];


	}
	
	
	
	/*
	 * 通配符匹配
	 */
	public static boolean isMatch(String s,String p){
		
		if("".equals(p))
			return s.equals(p);
		if("".equals(s)){
			for(int i=0;i<p.length();i++){
				if(p.charAt(i)!='*'){
					return false;
				}
			}
			return true;
		}
		boolean match[][]=new boolean[p.length()+1][s.length()+1];
		match[0][0]=true;
		
		for(int i=1;i<=p.length();i++){
			match[i][0]=match[i-1][0]&&p.charAt(i-1)=='*';
			for(int j=1;j<=s.length();j++){
				if(p.charAt(i-1)=='*'){
					match[i][j]=match[i-1][j]||match[i][j-1];
				}else if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?'){
					match[i][j]=match[i-1][j-1];
				}else{
					match[i][j]=false;
				}
			}
		}
		
		for(int i=0;i<match.length;i++){
			for(int j=0;j<match[i].length;j++){
				System.out.print(match[i][j]);
			}
			System.out.println();
		}
		
		return match[p.length()][s.length()];
	}
	/*
	 * 双cpu问题
	 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
	 * 输入包括两行：
		第一行为整数n(1 ≤ n ≤ 50)
		第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
		输出一个整数，表示最少需要处理的时间
	 */
	public static int getMinTimeDoubleCpu(int w,int jobLength[]){
		int n=jobLength.length;
		int dp[][]=new int[n+1][w+1];
		
		for(int i=0;i<=n;i++){
			dp[i][0]=0;
		}
		for(int i=0;i<=w;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=w;j++){
				if(jobLength[i-1]<=j){
					if(dp[i-1][j]<dp[i-1][j-jobLength[i-1]]+jobLength[i-1]){
						dp[i][j]=dp[i-1][j-jobLength[i-1]]+jobLength[i-1];
					}else{
						dp[i][j]=dp[i-1][j];
					}
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		
		return dp[n][w];
	}

}
