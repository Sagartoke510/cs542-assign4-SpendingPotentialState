package spendingPotentialState.driver;

import java.io.File;

import spendingPotentialState.state.SpendingPotentialStateContext;
import spendingPotentialState.state.SpendingPotentialStateContextI;
import spendingPotentialState.util.ResultI;
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

			File file = new File(args[0]);
			String inputFilePath = file.getAbsolutePath();
			file = new File(args[1]);
			String itemFile = file.getAbsolutePath();
			file = new File(args[3]);
			String outputFile = file.getAbsolutePath();

			try {
				ValidatorUtil.validate("failed",
						ValidatorFetcher.commandLineValidator(args, REQUIRED_NUMBER_OF_ARGS),
						ValidatorFetcher.missingFileValidator(inputFilePath),ValidatorFetcher.missingFileValidator(itemFile),
						ValidatorFetcher.emptyFileValidator(args[0]),ValidatorFetcher.emptyFileValidator(args[1]),
						ValidatorFetcher.fileContentFormatValidator(inputFilePath),
						ValidatorFetcher.windowValidator(args[2]));
				
				SpendingPotentialStateContextI sps = new SpendingPotentialStateContext(inputFilePath, itemFile, args[2], outputFile);
				sps.checkPotentialState();
		
			} catch (Exception e) {
				e.printStackTrace();
			}

		}}
