package com.dataset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nlpir.WordSeparation;

public class DataSet {
	
	final String file = "experiments/train.txt"; 
	final String outFile = "result/train_word.txt";
	
	List<Item> dataSet;
	WordSeparation ws ;

	public DataSet() {
		dataSet = new ArrayList<Item>();
	}
	
	public List<Item> getDataSet() {
		return dataSet;
	}

	public void setDataSet(List<Item> dataSet) {
		this.dataSet = dataSet;
	}

	public void read() {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File(file)));

			while( reader.ready() ) {
				Item item = new Item();
				
				String line = reader.readLine().split("	",2)[1];
				String content = line.substring(1, line.length()-1);
				item.setContent(content);
				recogEntity(item);
				item.setLabel(reader.readLine());
				
				System.out.println(item.getE1() + "," + item.getE2() + "," + item.getLabel());
				dataSet.add(item);
				
				reader.readLine();
				reader.readLine();
			}

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 识别entity并去除tag
	 * @param item
	 */
	private void recogEntity(Item item) {
		String content = item.getContent();
		
		item.setE1(content.substring(content.indexOf("<e1>")+4,content.indexOf("</e1>")));
		item.setE2(content.substring(content.indexOf("<e2>")+4,content.indexOf("</e2>")));
		item.setContent(content.replaceAll("<.+?>", ""));
	}

	//TODO  将dataset写入文件
	public void write() {
		ws = new WordSeparation();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			
			for (int i = 0; i < dataSet.size(); i++) {
				Item item = dataSet.get(i);
				
				writer.write(item.getLabel() + " ");
				//提取词干的时候需要小写
				writer.write( ws.separate(item.getContent().toLowerCase()));
				writer.newLine();
			}
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ws.close();
	}

	public static void main(String[] args) {
		DataSet db = new DataSet();
		db.read();
		db.write();
	}
}
