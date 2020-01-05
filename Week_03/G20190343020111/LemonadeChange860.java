package com.solution;

public class LemonadeChange860 {

	public static void main(String[] args) {
		int[] bills = { 5, 5, 10, 10, 20 };
		System.out.println(new LemonadeChange860().lemonadeChange(bills));

	}

	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int i : bills) {
			if (i == 5) {
				five++;
			}
			if (i == 10) {
				five--;
				ten++;
			}
			if (i == 20) {
				if (ten > 0) {
					ten--;
					five--;
				} else {
					five = five - 3;
				}
			}
			if (five < 0) {
				return false;
			}
		}
		return true;
	}
}
