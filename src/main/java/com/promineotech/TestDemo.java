package com.promineotech;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameter must be positive!");
		}
		return a + b;
	}
	
	public BigDecimal averageOfArray(double[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException("Array must have values.");
		}
		
		double sum = 0;
		for (double num : arr) {
			sum += num;
		}
		double avg = sum / arr.length;
		
		return new BigDecimal(avg).setScale(2, RoundingMode.HALF_DOWN);
	}
	
	public int randomNumberSquared() {
		int randInt = getRandomInt();
		
		return randInt * randInt;
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}

}
