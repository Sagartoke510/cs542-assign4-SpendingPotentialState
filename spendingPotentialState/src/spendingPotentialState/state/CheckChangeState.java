package spendingPotentialState.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spendingPotentialState.util.ResultI;

public class CheckChangeState {
	private ResultI result;
	private ChangeStateI checkAndChangeState;
	private Map<String, List<String>> itemsAvailableList = new  HashMap<String, List<String>>();

	public CheckChangeState(Map<String, List<String>> itemsAvailableListIn, ResultI resultIn) {
		itemsAvailableList = itemsAvailableListIn;
		result =resultIn;
	
	}

	public ChangeStateI changeState(Double runningAverage) {
		
		if(runningAverage >= 0 && runningAverage < 10000)
			checkAndChangeState = new BasicState(itemsAvailableList, result);
		else if(runningAverage >=10000 && runningAverage < 50000)
			checkAndChangeState = new LuxuriousState(itemsAvailableList, result);
		else
			checkAndChangeState = new ExtravagentState(itemsAvailableList, result);
		return checkAndChangeState;
		
		
	}

}
