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
	String file = "TRAIN_FILE";
	List<String> words = new ArrayList<String>();
	
	public void read() {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File("experiments/" + file)));

			BufferedWriter writer = new BufferedWriter(
					new FileWriter(new File("result/" + file + "_bag")));
			
			int count = 1;
			while( reader.ready() ) {
				
				String line = reader.readLine().split("	",2)[1];
				String content = line.substring(1, line.length()-1);
				
				write(writer,content.replaceAll("<.+?>", "").replaceAll("\\.","").toLowerCase());
				
				reader.readLine();
				reader.readLine();
				reader.readLine();
				
				count ++;
			}

			reader.close();
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



	private void write(BufferedWriter writer, String line) throws IOException {
		String tmp[] = line.split("\\s+");
		
		for (int i = 0; i < tmp.length; i++) {
			if( !tmp[i].substring(tmp[i].length()-1).matches("\\w"))
				tmp[i] = tmp[i].substring(0,tmp[i].length()-1);
			
			porter.add(tmp[i].toCharArray(),tmp[i].length());
			porter.stem();

			String word = porter.toString();
//			System.out.println(word);
			if( !words.contains(word)) {
				words.add(word);
				
				writer.write(word);
				writer.newLine();
			}

			porter.reset();
		}
       
		
	}

	public static void main(String[] args) {
		WordBag bag = new WordBag();
		bag.read();
	}
}
