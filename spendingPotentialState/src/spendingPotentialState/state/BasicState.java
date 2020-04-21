package spendingPotentialState.state;

import java.util.List;
import java.util.Map;

import spendingPotentialState.util.ResultI;

public class BasicState implements ChangeStateI {
		private State state;
		private ResultI result;
		private ItemChecker itemChecker;
		private CheckChangeState checkChangeState;
		private ChangeStateI changedState;


	public BasicState(Map<String, List<String>> itemsAvailableList, ResultI itemsResultIn) {
		
		result=itemsResultIn;
		itemChecker = new ItemChecker(itemsAvailableList);
		checkChangeState = new CheckChangeState(itemsAvailableList,result);
		state = state.BASIC;
		
		
	}

	@Override
	public ChangeStateI changeStateOnRunningAverage(Double runningAverage) {
		changedState = checkChangeState.changeState(runningAverage);
		return changedState;
	}

	@Override
	public void checkItem(String item) {
		
		
	}

	

}
