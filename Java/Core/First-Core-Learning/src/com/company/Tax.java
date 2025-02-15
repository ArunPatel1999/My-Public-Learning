package com.company;

import java.util.Scanner;

public class Tax {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter salary => ");
		double salary = input.nextDouble();
		
		int taxPercentage = 0;
		
		if(salary >= 250000 && 500000 > salary )
			taxPercentage = 5;
		else if(salary >= 500000 && 1000000 > salary )
			taxPercentage = 20;
		else if(salary >= 1000000)
			taxPercentage = 30;
		
		System.out.println("Tex On your Salary is "+(taxPercentage)+" %. In rupees "+(taxPercentage == 0 ? salary : ((double)(salary/taxPercentage))));
		
		input.close();
		
	}
}
