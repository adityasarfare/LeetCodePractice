package com.example.TwoPointers;

public class TrapingRainWater5 {

	 public int trap(int[] height) {
		  if(height == null || height.length ==0){
	            return 0;
	        } 

	        int l=0;
	        int r=height.length-1;

	        int leftMax= height[l];
	        int rightMax= height[r];

	        int res=0;
	        
	        while(l < r){
	            if(leftMax < rightMax){
	                l++;
	                leftMax= Math.max(leftMax, height[l]);
	                res = res+(leftMax - height[l]);
	            }
	            else{
	                r--;
	                rightMax = Math.max(rightMax, height[r]);
	                res = res+(rightMax- height[r]);
	            }

	          } 

	          return res;
	 }
}
