package spendingPotentialState.state;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.text.NumberFormat;
import java.text.ParseException;

import spendingPotentialState.util.FileProcessor;
import spendingPotentialState.util.RunningAverage;

public class SpendingPotentialStateContext implements SpendingPotentialStateContextI{
	
	private String inputFile;
	private String itemFile;
	private Integer windowSize;
	private String outputFile;
	private double sum;
	RunningAverage	runningAverage;

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
			while (fp.getLine() != null) {
				Number n = NumberFormat.getInstance().parse(fp.poll().trim());
			}
			
			FileProcessor fpi = new FileProcessor(itemFile);
		} catch (InvalidPathException | SecurityException | IOException | ParseException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	

}
