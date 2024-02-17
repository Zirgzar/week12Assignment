package com.promineotech;

public class TestDemo {
	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameter must be positive!");
		}
		return a + b;
	}

}
