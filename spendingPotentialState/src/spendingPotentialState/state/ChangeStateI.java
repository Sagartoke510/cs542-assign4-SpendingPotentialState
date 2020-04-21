package spendingPotentialState.state;

public interface ChangeStateI {

	public ChangeStateI changeStateOnRunningAverage(Double runningAverage);
	public void checkItem(String item);
}
