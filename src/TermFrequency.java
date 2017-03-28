import java.io.*;
import java.util.*;

/**
 * @author Sneha Saran
 * This program expects 2 arguments: 
 * 1. Path to the folder containing all input files.
 * 2. Word(s) to be searched.
 * 
 * Output is displayed on the command line. 
 */

public class TermFrequency {
	public static void main(String[] args) {
		if(args.length <2){
			System.out.println("Enter <path to folder> <atleast one word to find term Index, separate multiple words by spaces>");
			System.exit(0);
		}else{
			String pathToFolder = args[0];
			String[] input = Arrays.copyOfRange(args, 1, args.length);
			get_term_freq(pathToFolder, input);
		}
	}
	
	/**
	 * This method calculate term frequencies for a word/list of words
	 * @param pathToFolder Path to the folder containing all input files. 
	 * @param input Word/List of words whose term frequency is to be calculated.
	 */
	public static void get_term_freq(String pathToFolder, String[] input){
		Map<String, HashMap<String, Integer>> scores_map = new HashMap<String, HashMap<String,Integer>>();  
		File folder = new File(pathToFolder);
		Map<String, Integer> total_words = new HashMap<String, Integer>();
		File[] listOfFiles = folder.listFiles();
		Map<String, Integer> word_count;
		for (int i = 0; i < listOfFiles.length; i++) {
			word_count =  new HashMap<String,Integer>();
			int number_of_word = 0;
			if (listOfFiles[i].isFile()) {
				try(BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]))){
					String line;
					while ((line = br.readLine()) != null) {
						line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase(); //Data cleaning. removes all non-letter characters
						String words[] = line.split(" ");
						for(String w: words){
							number_of_word++;
							if(word_count.containsKey(w)){
								word_count.put(w,word_count.get(w) + 1);
							}else{
								word_count.put(w,1);
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}

			}
			total_words.put(listOfFiles[i].getName(), number_of_word);
			scores_map.put(listOfFiles[i].getName(), (HashMap<String, Integer>) word_count);
		}

		for(String inp : input){
			inp = inp.toLowerCase().replaceAll("[^a-zA-Z ]", ""); //Data cleaning. removes all non-letter characters
			float max_term_freq = 0;
			String max_freq_files = null;
			for(String s:scores_map.keySet()){
				float term_freq = 0;
				if(scores_map.get(s).containsKey(inp)){
					term_freq = (float)scores_map.get(s).get(inp) / (float)total_words.get(s);
					if(term_freq > max_term_freq){
						max_term_freq = term_freq;
						max_freq_files = s;
					}
				}
			}
			System.out.println(inp + "--> " + max_freq_files + " --> " + max_term_freq);
		}

	}
}
