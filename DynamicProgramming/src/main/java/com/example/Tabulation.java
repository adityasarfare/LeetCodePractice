package com.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Tabulation{

 
    public static void main( String[] args )
    {
    	int n=6;
    	int dp[] = new int[n+1];
    	Arrays.fill(dp, -1);
        dp[0]=0;
        dp[1]=1;
        
        for(int  i=2; i<=n; i++) {
        	dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.println(dp[n]);
    }

	
}

//Time Complexity: O(N)
//
//Reason: We are running a simple iterative loop
//
//Space Complexity: O(N)
//
//Reason: We are using an external array of size ‘n+1’.	0