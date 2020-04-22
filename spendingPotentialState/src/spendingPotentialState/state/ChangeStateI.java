package spendingPotentialState.state;

/**
 * This {@code ChangeStateI} is an interface which is implemented by all the
 * classes where states need to be changed.
 * 
 * @author Sagar Toke
 *
 */
public interface ChangeStateI {

	/**
	 * Method to change state on running average
	 * 
	 * @param runningAverage running average of money earned
	 * @return state state of the person
	 */
	public ChangeStateI changeStateOnRunningAverage(Double runningAverage);

	/**
	 * method to set result of the state with spending capabilities
	 * 
	 * @param item items form the items file
	 */
	public void checkItem(String item);
}
