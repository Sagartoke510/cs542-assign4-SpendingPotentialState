package spendingPotentialState.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProcessorItem {

	private BufferedReader reader;
	private String line;
	private Map<String, List<String>> itemsList=null;


	public String getLine() {
		return line;
	}

	public FileProcessorItem(String inputFilePath) 
		throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		
		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("invalid input file or input file in incorrect location");
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
	}
	
	/**
	 * Method to read input file line by line
	 * @return String line read from the input file
	 * @throws IOException throws exception if null
	 */
	public String poll() throws IOException {
		if (null == line) return null;

		String newValue = line.trim();
		line = reader.readLine();
		return newValue;
	}

	public Map<String,List<String>> fetchItems(String itemFile) throws IOException{
		reader = new BufferedReader(new FileReader(new File(itemFile)));
		String[] list = new String[2];
		itemsList = new HashMap<String, List<String>>();
		ArrayList<String> itemsValue = new ArrayList<>();
		while(true) {
		line = reader.readLine();
		
		if(null == line) break;
		list=line.split(":");
		
		if(itemsList.containsValue(list[0])) {
			itemsList.put(list[0], itemsValue);
		}
		itemsList.get(list[0]).add(list[1]);
		}
		return itemsList;
		
	}
	/**
	 * Method to close all the resources open to read the file
	 * @throws IOException throws exception if null
	 */
	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException("failed to close file", e);
		}
	}
}
