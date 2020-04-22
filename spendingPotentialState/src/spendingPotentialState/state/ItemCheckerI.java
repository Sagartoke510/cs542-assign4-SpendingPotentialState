package spendingPotentialState.state;

/**
 * {@code ItemCheckerI} defines an interface to be implemented by classes that
 * intend to check the state for input item files
 */
public interface ItemCheckerI {
	/**
	 * Method to check whether item falls under basic state, if yes return true else
	 * return false
	 * 
	 * @param item item string for items file
	 * @return true or false
	 */
	public boolean checkBasicItemStatus(String item);

	/**
	 * Method to check whether item falls under basic state and moderate state, if
	 * yes return true else return false
	 * 
	 * @param item item string for items file
	 * @return true or false
	 */
	public boolean checkModeratelyExpensiveItemStatus(String item);

	/**
	 * Method to check whether item falls under basic state,moderate state and
	 * moderately expensive if yes return true else return false
	 * 
	 * @param item item string for items file
	 * @return true or false
	 */
	public boolean checkSuperExpensiveItemStatus(String item);

}
