package spendingPotentialState.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import spendingPotentialState.cmdLineExceptions.CmdLineInputException;
import spendingPotentialState.cmdLineExceptions.WindowException;

/**
 * The class {@code ValidatorFetcher} is to validate input from command line
 */
public class ValidatorFetcher {
	public static Validator missingFileValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws FileNotFoundException {
				if (!Files.exists(Paths.get(inputFilePath))) {
					throw new FileNotFoundException("Invalid input file or input file in incorrect location");
				}
			}
		};
	}

	public static Validator emptyFileValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				File file = new File(inputFilePath);
				if (file.length() == 0) {
					throw new IOException("Input file is empty");
				}

			}
		};
	}

	public static Validator integerValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				String text = "";
				String pattern = "^[0-9\\r\\n]*$";
				text = new String(Files.readAllBytes(Paths.get(inputFilePath)));
				if (!text.matches(pattern)) {
					throw new IOException("Invalid line or line contains other than integers");
				}

			}
		};
	}

	public static Validator fileContentFormatValidator(String inputFilePath) {
		return new Validator() {
			@Override
			public void run() throws IOException {
				BufferedReader reader = new BufferedReader(new FileReader(new File(inputFilePath)));
				String line = reader.readLine();
				while (true) {
					if (null == line)
						break;
					if (line.contains(":")) {
						String[] wordsInLine = line.split(":");
						if (wordsInLine.length > 2)
							throw new IOException(
									"Input file line has invalid format, more than one : character");
						else {
							if (wordsInLine[0].equals("money") && Integer.parseInt(wordsInLine[1]) <= 0) {
								throw new IOException("Input file paramter value has invalid format, money earned <= 0");
							} else if (!(wordsInLine[0].equals("money") || wordsInLine[0].equals("item"))) {
								throw new IOException("Input file has invalid format");
							}
						}
					}else {
						String error = "Input file doesn't contain" + " : " + "to distinguish between type and paramter->format wrong";
						throw new IOException(error);
					}
					line = reader.readLine();
				}
				reader.close();
			}
		};
	}

	public static Validator commandLineValidator(String[] args, int numOfArg) {
		return new Validator() {
			@Override
			public void run() throws CmdLineInputException {
				if ((args.length != numOfArg) || (args[0].equals("${inputFile}"))
						|| (args[1].equals("${availableItemsFile}")) || (args[2].equals("${runningAverageWindowSize}"))
						|| (args[3].equals("${outputFile}"))) {
					System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.\n",
							numOfArg);
					throw new CmdLineInputException("Incorrect number of arguments");
				}
			}
		};

	}

	public static Validator windowValidator(String windowSizeIn) {
		return new Validator() {

			@Override
			public void run() throws WindowException {
				if (Integer.parseInt(windowSizeIn) <= 0)
					throw new WindowException("Invalid window Size");
			}
		};
	}

}
