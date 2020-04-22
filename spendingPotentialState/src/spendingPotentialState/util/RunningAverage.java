package spendingPotentialState.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is {@code RunningAverage} class which implements an
 * ({@code RunningAverageI} interface and calculates running average on input
 * stream based on the window provided
 * 
 * @author Sagar Toke
 *
 */

public class RunningAverage implements RunningAverageI {

	private Integer windowSize;
	private static Queue<Number> numbers = new LinkedList<Number>();
	private double runningAverage = 0.0;
	private double sum;

	public RunningAverage(Integer windowSizeIn) {
		windowSize = windowSizeIn;

	}

	@Override
	public Double calculateRunningAverage(Number n) {

		sum = sum + n.intValue();
		numbers.add(n);
		if (numbers.size() > windowSize) {

			sum = sum - numbers.remove().intValue();
		}
		runningAverage = sum / numbers.size();
		return runningAverage;
	}
}