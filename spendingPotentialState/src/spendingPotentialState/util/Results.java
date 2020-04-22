package spendingPotentialState.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Results implements ResultI{
	private String itemOutputFile;
	private static List<String> runningAverage = new ArrayList<String>();
	private File outputFile;
	private FileWriter outputFileWriter;
	private String result;


	public Results(String itemOutputFileIn) {
		
		itemOutputFile = itemOutputFileIn;
		try {
			outputFile = new File(itemOutputFile);
			outputFileWriter = new FileWriter(itemOutputFile,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	

	@Override
	public void writeToFile() {
		try {

			if (!Files.exists(Paths.get(itemOutputFile))) {
				
				outputFile.createNewFile();

				
				outputFileWriter.write(result + "\n");
				//outputFileWriter.flush();
		
			} else {
				//outputFileWriter = new FileWriter(itemOutputFile,true);
			
					outputFileWriter.write(result + "\n");
					outputFileWriter.flush();
					
			}
			
			//close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void setResult(String stateOfPerson, String itemMatch, String purchaseDecision) {
		result  = stateOfPerson + "::" + itemMatch + "--"+ purchaseDecision;
		System.out.println(result);
		writeToFile();
		//close();
		
		
	}

	@Override
	public void close() {
		try {
			//outputFileWriter.flush();
			outputFileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	
}
