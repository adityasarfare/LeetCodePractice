package com.example.ArraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements5 {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		
		List<Integer>[] freq = new List[nums.length +1];
		
		
		for(int i=0; i<freq.length; i++) {
			freq[i] = new ArrayList();
		}
		
		for(int n: nums) {
			hm.put(n, hm.getOrDefault(n, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			freq[entry.getValue()].add(entry.getKey());
		}
		
		int[] res = new int[k];
		int index =0;
		
		for(int i=freq.length-1; i>=0; i++) {
			for(int n : freq[i]) {
				res[index] = n;
				index++;
			}
			if(index ==k) {
				return res;
			}
		}
		return res;
	}
}
