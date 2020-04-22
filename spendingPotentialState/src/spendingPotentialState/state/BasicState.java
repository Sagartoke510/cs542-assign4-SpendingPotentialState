package spendingPotentialState.state;

import java.util.List;
import java.util.Map;

import spendingPotentialState.util.ResultI;
import spendingPotentialState.util.Results;

/**
 * This is Basic state class which implements ChangeStateI interface and and
 * shnage state on runningaverage and calls result to set the result i.e. state of the person
 * 
 * @author Sagar Toke
 *
 */

public class BasicState implements ChangeStateI {
	private State state;
	private ResultI result;
	private ItemCheckerI itemChecker;
	private CheckChangeStateI checkChangeState;
	private ChangeStateI changedState;

	public BasicState(Map<String, List<String>> itemsAvailableList, ResultI itemsResultIn) {

		result = itemsResultIn;
		itemChecker = new ItemChecker(itemsAvailableList);
		checkChangeState = new CheckChangeState(itemsAvailableList, result);
		state = state.BASIC;

	}

	@Override
	public ChangeStateI changeStateOnRunningAverage(Double runningAverage) {
		changedState = checkChangeState.changeState(runningAverage);
		return changedState;
	}

	@Override
	public void checkItem(String item) {

		if (itemChecker.checkBasicItemStatus(item)) {
			result.setResult(this.state.toString(), item, "YES");
			// result.writeToFile(result);
		} else {
			result.setResult(this.state.toString(), item, "NO");
			// result.writeToFile();
		}

	}

}
