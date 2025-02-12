package org.example.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom5 {

	public static void main(String[] args) {
		
	}
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	      
		 List<List<Integer>> result = new ArrayList<>();
		 
		 if(root == null) {
			 return result;
		 }
		 Queue<TreeNode> queue= new LinkedList<>();
		 queue.offer(root);
		 
		 while(!queue.isEmpty()) {
			 int levelSize = queue.size();
			 List<Integer> currentList = new ArrayList<>(levelSize);
			 for(int i=0; i<levelSize; i++) {
			     TreeNode currentNode = queue.poll();
			     currentList.add(currentNode.val);
			     
			     if(currentNode.left!=null) {
			    	 queue.offer(currentNode.left);
			     }
			     if(currentNode.right!=null) {
			    	 queue.offer(currentNode.right);
			     }
			 }
			result.add(0, currentList);	
		 }
		 return result;
	    }
	
}
