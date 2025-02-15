package com.company;

public class Profit {
	public static void main(String[] args) {

		int a[] = { 465, 260, 340, 310, 40, 22, 985};
		
		int buyDay = 3;
		int sellDay = 6;
		
		if(sellDay >= a.length )
			System.out.println("please provide proper range");
		else
			System.out.print(maxProfit(a, buyDay, sellDay));
		  
		
	}
	
	public static int maxProfit(int price[], int start, int end) {
		 if (end <= start)
		        return 0;
		    int profit = 0;
		    for (int i = start; i < end; i++) {
		        for (int j = i + 1; j <= end; j++) {
		            if (price[j] > price[i]) {
		                int curr_profit = price[j] - price[i]
		                                + maxProfit(price, start, i - 1)
		                                + maxProfit(price, j + 1, end);
		                profit = Math.max(profit, curr_profit);
		            }
		        }
		    }
		return profit;
	}
}
