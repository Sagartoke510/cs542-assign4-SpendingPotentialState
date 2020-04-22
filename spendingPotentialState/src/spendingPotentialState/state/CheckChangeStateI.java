package spendingPotentialState.state;

/**
 * This {@code CheckChangeStateI} is an interface implemented by the classes
 * needed to change the state
 * 
 * @author sagar Toke
 *
 */
public interface CheckChangeStateI {

	/**
	 * Method to check and change the state on running average
	 * 
	 * @param runningAverage running average of money earned
	 * @return current state state of the person
	 */
	public ChangeStateI changeState(Double runningAverage);
}
