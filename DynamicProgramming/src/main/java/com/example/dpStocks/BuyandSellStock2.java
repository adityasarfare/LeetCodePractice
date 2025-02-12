package com.example.dpStocks;

import java.util.Arrays;

public class BuyandSellStock2 {

	public static void main(String[] args) {
     
        int[] arr = {7, 1, 5, 3, 6, 4};
        int n = arr.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + 
        getMaximumProfit(arr, n));
        System.out.println("The maximum profit that can be generated is " + 
                getMaximumProfitTabulation(arr, n));
        System.out.println("The maximum profit that can be generated is " + 
                getMaximumProfitSpaceOptimization(arr, n));
    }

	private static int getMaximumProfit(int[] arr, int n) {
		int[][] dp = new int[n][2];

		for (int[] rows : dp) {
			Arrays.fill(rows, -1);
		}
		if(n==0) {
			return 0;
		}
		
		return dfs(0, 0, n,  arr, dp);
	}

	private static int dfs(int i, int buy, int n, int[] arr, int[][] dp) {
		
		if(i==n) {
			return 0;
		}
		
		if(dp[i][buy] !=-1) {
			return dp[i][buy];
		}
		
		int profit = 0 ;
		
		if(buy ==0) {
		profit = Math.max(-arr[i] + dfs(i+1, 1, n, arr, dp), 0+ dfs(i+1, 0, n, arr, dp));
		}
		else{
			profit = Math.max(arr[i] + dfs(i+1, 0, n, arr, dp), 0+ dfs(i+1, 1, n, arr, dp));
		}
		
		dp[i][buy]= profit;
		return profit;
	}
	

	private static int getMaximumProfitTabulation(int[] arr, int n) {
		
		int dp[][] = new int [n+1][2];
		dp[n][0]=0;
		dp[n][1]=0;
		
		int profit = 0 ;
		for(int i= n-1;i>=0; i--) {
			for(int buy = 0; buy<=1; buy++) {
				
				if(buy ==0) {
				profit = Math.max(-arr[i] + dp[i+1][1], 0+ dp[i+1][0]);
				}
				else{
					profit = Math.max(arr[i] + dp[i+1][0], 0+ dp[i+1][1]);
				}
				
				dp[i][buy]= profit;
				
			}
		}
		return dp[0][0];
	}
	

	private static int getMaximumProfitSpaceOptimization(int[] arr, int n) {
		
		int [] prev = new int[2];
		int [] cur = new int[2];
		
		prev[0]=0;
		prev[1]=0;
		
		int profit = 0 ;
		for(int i= n-1;i>=0; i--) {
			for(int buy = 0; buy<=1; buy++) {
				
				if(buy ==0) {
				profit = Math.max(-arr[i] + prev[1], 0+ prev[0]);
				}
				else{
					profit = Math.max(arr[i] + prev[0], 0+ prev[1]);
				}
				
				cur[buy]= profit;
				
			}
			prev = cur;
		}
		return prev[0];
	}
}
