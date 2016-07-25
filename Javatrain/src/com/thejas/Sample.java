package com.thejas;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;



public class Sample   {
	
	

	public static void main(String []args)
	{  
	 Set s = new TreeSet();
	 s.add("2");
	 s.add("3");
	 s.add("1");
	 
	 Iterator it = s.iterator();
	 
	 while(it.hasNext())
	 {
		 System.out.println(it.next()+ " ");
	 }
	 
	 
		
	}

}
