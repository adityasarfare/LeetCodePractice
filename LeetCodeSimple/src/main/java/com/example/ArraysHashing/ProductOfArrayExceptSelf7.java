package com.example.ArraysHashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf7 {
	public int[] productExceptSelf(int[] nums) {
		
		int n = nums.length;
		int [] ans = new int[n];
		
		Arrays.fill(ans, 1);
		int cur =1;
		
		for(int i=0; i<n; i++) {
			ans[i] *=cur;
			cur *= nums[i];
		}
		
		cur =1;
		for(int i=n-1; i>=0; i--) {
			ans [i] *= cur;
			cur *=nums[i];
		}
		
		return ans;
	}
}
