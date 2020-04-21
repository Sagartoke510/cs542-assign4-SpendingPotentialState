package spendingPotentialState.util;

import java.util.LinkedList;
import java.util.Queue;

public class RunningAverage implements RunningAverageI {

	private Integer windowSize;
	private static Queue<Number> numbers = new LinkedList<Number>();
	private double runningAverage;
	private double sum;

	public RunningAverage(String windowSizeIn){
		windowSize = Integer.parseInt(windowSizeIn);

	}

	@Override
	public Double calculateRunningAverage(Number n) {
		
			sum = sum + n.intValue();
			numbers.add(n);
			if (numbers.size() == windowSize) {

				sum = sum - numbers.remove().intValue();
			}
			return runningAverage = sum / numbers.size();

	}
}