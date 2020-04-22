package spendingPotentialState.state;

import java.util.List;
import java.util.Map;

import spendingPotentialState.util.ResultI;

public class ExtravagentState implements ChangeStateI {
	private State state;
	private ResultI result;
	private ItemChecker itemChecker;
	private CheckChangeState checkChangeState;
	private ChangeStateI changedState;

	public ExtravagentState(Map<String, List<String>> itemsAvailableList, ResultI resultIn) {
		result = resultIn;
		itemChecker = new ItemChecker(itemsAvailableList);
		checkChangeState = new CheckChangeState(itemsAvailableList, result);
		state = state.EXTRAVAGENT;
	}

	@Override
	public ChangeStateI changeStateOnRunningAverage(Double runningAverage) {
		changedState = checkChangeState.changeState(runningAverage);
		return changedState;
	}

	@Override
	public void checkItem(String item) {
		if(itemChecker.checkSuperExpensiveItemStatus(item)) {
			result.setResult(this.state.toString(), item, "YES");
		}
		else {
			result.setResult(this.state.toString(), item, "NO");
		}

		
	}

}
