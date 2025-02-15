package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTraversal {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(41,50,64,74,68,40));  
		
		System.out.print("Traversal Using For Loop => ");
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
		
		
		System.out.print("\nTraversal Using While Loop => "); 		
	    int count = 0; 		
	    while (list.size() > count) {
		 System.out.print(list.get(count)+" ");
	     count++;
	   }
	    
	    System.out.print("\nTraversal Using Advance For Loop => ");
	    for(Integer x : list) 
	      System.out.print(x+" ");
	}
	
}
