package spendingPotentialState.state;

import java.util.List;
import java.util.Map;

import spendingPotentialState.util.ResultI;
import spendingPotentialState.util.Results;

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
		
		if(itemChecker.checkBasicItemStatus(item)) {
			result.setResult(this.state.toString(), item, "YES");
			//result.writeToFile(result);
		}
		else {
			result.setResult(this.state.toString(), item, "NO");
			//result.writeToFile();
		}
		
		
	}

	

}
