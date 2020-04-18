package spendingPotentialState.driver;

import java.io.File;

import spendingPotentialState.validator.ValidatorFetcher;
import spendingPotentialState.validator.ValidatorUtil;


/**
 * @author Sagar Toke 
 * 
 */
public class SpendingPotentialStateDriver {
	

		public static void main(String[] args) {
			System.out.println("I am in Driver");
			final int REQUIRED_NUMBER_OF_ARGS = 4;
			
			if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputFile}"))
					|| (args[1].equals("${availableItemsFile}")) || (args[2].equals("${runningAverageWindowSize}"))
					|| (args[3].equals("${outputFile}"))) {
				System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.\n", REQUIRED_NUMBER_OF_ARGS);
				System.exit(0);
			}

			String ifilename = "";
			String workingDirectory = System.getProperty("user.dir");
			ifilename = workingDirectory + File.separator + args[0];

			try {
				ValidatorUtil.validate("failed",
						ValidatorFetcher.commandLineValidator(args, REQUIRED_NUMBER_OF_ARGS),
						ValidatorFetcher.missingFileValidator(ifilename), ValidatorFetcher.emptyFileValidator(args[0]));


			} catch (Exception e) {
				e.printStackTrace();
			}

		}}
