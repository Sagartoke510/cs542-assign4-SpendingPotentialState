package spendingPotentialState.state;

import java.util.List;
import java.util.Map;

/**
 * This is Luxurious state class which implements ChangeStateI interface and and
 * change state on runningaverage and calls result to set the result i.e. state of the person
 * 
 * @author Sagar Toke
 *
 */
import spendingPotentialState.util.ResultI;

public class LuxuriousState implements ChangeStateI {
	private State state;
	private ResultI result;
	private ItemCheckerI itemChecker;
	private CheckChangeStateI checkChangeState;
	private ChangeStateI changedState;

	public LuxuriousState(Map<String, List<String>> itemsAvailableList, ResultI resultIn) {
		result = resultIn;
		itemChecker = new ItemChecker(itemsAvailableList);
		checkChangeState = new CheckChangeState(itemsAvailableList, result);
		state = state.LUXURIOUS;
	}

	@Override
	public ChangeStateI changeStateOnRunningAverage(Double runningAverage) {
		changedState = checkChangeState.changeState(runningAverage);
		return changedState;
	}

	@Override
	public void checkItem(String item) {
		if(itemChecker.checkModeratelyExpensiveItemStatus(item)) {
			result.setResult(this.state.toString(), item, "YES");
		}
		else {
			result.setResult(this.state.toString(), item, "NO");
		}

	}

}
