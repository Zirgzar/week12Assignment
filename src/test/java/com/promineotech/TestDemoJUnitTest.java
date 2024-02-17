package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 5, 5, true),
				arguments(-1, 3, 2, true),
				arguments(-4, -2, -6, true),
				arguments(10, 10, 20, false)
				);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(3,  7)).isEqualTo(10);
		assertThat(testDemo.addPositive(10, 40)).isEqualTo(50);
		assertThatThrownBy(() -> testDemo.addPositive(-5, 7)).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> testDemo.addPositive(0, 7)).isInstanceOf(IllegalArgumentException.class);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAverageOfArray")
	void assertThatAverageOfArrayIsCalculatedCorrectly(double[] arr, BigDecimal expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.averageOfArray(arr)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.averageOfArray(arr)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAverageOfArray() {
		double[] validArr = {2.5, 10.0, 50.25};
		double[] validArrWithNegative = {2.5, -10.0, 50.25};
		double[] emptyArr = {};
		
		return Stream.of(
				arguments(validArr, new BigDecimal(20.92).setScale(2, RoundingMode.HALF_DOWN), false),
				arguments(validArrWithNegative, new BigDecimal(14.25).setScale(2, RoundingMode.HALF_DOWN), false),
				arguments(emptyArr, new BigDecimal(0).setScale(2, RoundingMode.HALF_DOWN), true)
				);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

//		Given: number = 5
		doReturn(5).when(mockDemo).getRandomInt();
		
//		When: square the number
		int fiveSquared = mockDemo.randomNumberSquared();
		
//		Then: return 25
		assertThat(fiveSquared).isEqualTo(25);
	}

}
