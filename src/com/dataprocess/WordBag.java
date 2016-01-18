package com.dataprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nlpir.PorterStemmer;

public class WordBag {
	
	PorterStemmer porter = new PorterStemmer();
	String file = "bag";
	List<String> words = new ArrayList<String>();
	
	public void read() {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File("experiments/" + file)));

			BufferedWriter writer = new BufferedWriter(
					new FileWriter(new File("result/" + file + "_bag")));
			
			while( reader.ready() ) {
				String tmp[] = reader.readLine().split("\\s+");
				for (int i = 1; i < tmp.length; i++) {
					String word[] = tmp[i].split("/");
					
					porter.add(word[0].toCharArray(),word[0].length());
					porter.stem();
					
					String porterWord = porter.toString();
					if( !words.contains(porterWord)) {
						words.add(porterWord);
					}
					porter.reset();
				}
			}
			reader.close();
			
			for (int i = 0; i < words.size(); i++) {
				writer.write(words.get(i));
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WordBag bag = new WordBag();
		bag.read();
	}
}
