package learn.corejava;

import java.util.Date;

public class TestCode {

	public static void main(String[] args) {
		Date d=new Date();
		String temp=d.toString();
		System.out.println(temp);
		String arr[]=temp.split(" ");

		int i=0;
		while(i<arr.length) {
			System.out.println(arr[i]);
			i+=1;
			//i++;
			//i=i+1;
		}
		
		for(int ij=0;ij<20;ij++) {
			System.out.println("Hello");
			System.out.println(ij);
		}
		System.out.println("Code Completed");


	}

}
