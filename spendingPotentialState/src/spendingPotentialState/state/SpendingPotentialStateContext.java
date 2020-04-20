package spendingPotentialState.state;

import java.io.IOException;
import java.nio.file.InvalidPathException;

import spendingPotentialState.util.FileProcessor;

public class SpendingPotentialStateContext implements SpendingPotentialStateContextI{
	
	private String inputFile;
	private String itemFile;
	private Integer windowSize;
	private String outputFile;

	public SpendingPotentialStateContext(String inputFilePathIn, String itemFileIn, String windowSizeIn , String outputFileIn) {
	
		inputFile = inputFilePathIn;
		itemFile = itemFileIn;
		windowSize = Integer.parseInt(windowSizeIn);
		outputFile = outputFileIn;
	}

	@Override
	public void checkPotentialState() {
		
		try {
			FileProcessor fp = new FileProcessor(inputFile);
			FileProcessor fpi = new FileProcessor(itemFile);
		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	

}
