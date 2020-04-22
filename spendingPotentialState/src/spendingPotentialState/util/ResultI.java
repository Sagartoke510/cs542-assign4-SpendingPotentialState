package spendingPotentialState.util;

public interface ResultI {

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
