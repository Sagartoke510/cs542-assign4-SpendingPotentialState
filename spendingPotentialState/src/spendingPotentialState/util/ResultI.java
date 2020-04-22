package spendingPotentialState.util;


/**
* ResultI defines an interface to be implemented by
* classes that intend to store the state for each runningaverage calculation
* processed in a stream of numbers.
*/
public interface ResultI {

	/**Method to set state of the person with potential to afford items or not
	 * 
	 * @param stateOfPerson state of a person
	 * @param itemMatch	items list
	 * @param purchaseDecision whether he can afford or not
	 */
	public void setResult(String stateOfPerson, String itemMatch, String purchaseDecision);
	/**
	 * Method to write result in output file
	 */
	public void writeToFile();
	/**
	 * Method to close resources opened for writing to file
	 */
	public void close();
	
	
	
}
