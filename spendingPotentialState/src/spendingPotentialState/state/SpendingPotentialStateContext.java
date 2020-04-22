package spendingPotentialState.state;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spendingPotentialState.util.FileProcessor;
import spendingPotentialState.util.ResultI;
import spendingPotentialState.util.Results;
import spendingPotentialState.util.RunningAverage;
import spendingPotentialState.util.RunningAverageI;

public class SpendingPotentialStateContext implements SpendingPotentialStateContextI {

	private String inputFile;
	private String itemFile;
	private Integer windowSize;
	private String outputFile;
	private double sum;
	private Map<String, List<String>> itemsAvailableList = new HashMap<String, List<String>>();
	private ResultI itemsResult;
	private ChangeStateI currentStateOfPerson;

	public SpendingPotentialStateContext(String inputFilePathIn, String itemFileIn, String windowSizeIn,
			String outputFileIn) {

		inputFile = inputFilePathIn;
		itemFile = itemFileIn;
		windowSize = Integer.parseInt(windowSizeIn);
		outputFile = outputFileIn;
		itemsResult = new Results(outputFileIn);
	}

	@Override
	public void checkPotentialState() {

		try {
			FileProcessor fp = new FileProcessor(inputFile);
			RunningAverageI runningAverage = new RunningAverage(windowSize);
			String[] list = new String[2];
			Double runningAverageResult = 0.0;
			itemsAvailableList = fp.fetchItems(itemFile);
			currentStateOfPerson = new BasicState(itemsAvailableList, itemsResult);
			while (fp.getLine() != null) {
				String line = fp.poll();
				if (line.contains("money")) {
					list = line.split(":");
					runningAverageResult = runningAverage.calculateRunningAverage(Integer.parseInt(list[1]));
					// System.out.println("Running Average " + runningAverageResult);
					currentStateOfPerson = currentStateOfPerson.changeStateOnRunningAverage(runningAverageResult);

				} else if (line.contains("item")) {
					list = line.split(":");
					checkItem(list[1]);

				}
			}

		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkItem(String item) {
		currentStateOfPerson.checkItem(item);

	}

}
