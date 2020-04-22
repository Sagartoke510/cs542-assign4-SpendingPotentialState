package spendingPotentialState.validator;
/**
 * Validator defines an interface to be implemented by 
 * classes that intend to validate input given from command line.
 */
public interface Validator {
	/**
	 * Method to run appropriate validator
	 * @throws Exception  exception handled by validatorfetcher class
	 */
	void run() throws Exception;

}
