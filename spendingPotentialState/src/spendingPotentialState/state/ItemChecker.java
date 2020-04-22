package spendingPotentialState.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** This {@code ItemChecker} class implments {@code ItemCheckerI} which checks item falls under which category
 * 
 * @author sagar Toke.
 *
 */

public class ItemChecker implements ItemCheckerI {

	public Map<String, List<String>> itemsAvailableList = new HashMap<String, List<String>>();

	public ItemChecker(Map<String, List<String>> itemsAvailableListIn) {
		itemsAvailableList = itemsAvailableListIn;

	}
	
	@Override
	public boolean checkBasicItemStatus(String item) {
		for (String itemCheck : itemsAvailableList.get("basic")) {
			if (itemCheck.contains(item))
				return true;
		}

		return false;
	}
	
	@Override
	public boolean checkModeratelyExpensiveItemStatus(String item) {
		for (String itemCheck : itemsAvailableList.get("moderatelyExpensive")) {
			if (itemCheck.contains(item))
				return true;
		}
		if (checkBasicItemStatus(item))
			return true;

		return false;
	}

	@Override
	public boolean checkSuperExpensiveItemStatus(String item) {
		for (String itemCheck : itemsAvailableList.get("superExpensive")) {
			if (itemCheck.contains(item))
				return true;
		}
		if (checkBasicItemStatus(item))
			return true;
		if (checkModeratelyExpensiveItemStatus(item))
			return true;

		return false;
	}

}
