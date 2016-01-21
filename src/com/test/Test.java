package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.dataset.DataSet;
import com.idfcal.IDFCal;

public class Test {
	
	
	
	@SuppressWarnings("unused")
	private static void loadDic() {
		Map<String,Integer> dic = new HashMap<String,Integer>();
		
		String docLine;
		int count = 1;
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("dic/dic_chs.txt"))));
			while((docLine = br.readLine())!=null)
			{
				String s[] = docLine.split("");
				dic.put(s[0],count++);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	
	public static void read() {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File("test/法律文书-result.txt")));
			
			while( reader.ready() ) {
				String line = reader.readLine();
				if( !line.matches("\\s+") ) {
					String tmp[] = line.split("\\s+");

					for (int i = 0; i < tmp.length; i++) {
						if( tmp[i].contains("nr"))
							System.out.println(tmp[i]);
					}
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		read();
		/*String fileName = "test";
		
		DataSet db = new DataSet();
		db.setFile(fileName);
		db.read();
		db.write();
		String input = db.getOutFile();
		
		IDFCal idfCal = new IDFCal(input,"test_vec");
		idfCal.getDocs();
		idfCal.getTermList();
		idfCal.word2Vec();*/
		
//		String str = "Conflicting loads were stalled while pending <e1>stores</e1> were draining into <e2>memory</e2>.";
//		String str  = "Flamenco and bullfight cultural icons such as the ghostly bullhorns of the bullfight, or the anvil of the Romani (gypsy) blacksmiths are used in these paintings to visually sing a seguiriyas.";
//		String str = "I've got the <e1>world</e1> in a <e2>jug</e2>, the stopper's in my hand.";
		
//		System.out.println(str.substring(0,str.length()-1));
//		System.out.println("d".matches("\\w"));
//		String tmp[] = str.split("\\s");
//		for (int i = 0; i < tmp.length; i++) {
//			System.out.print(tmp[i] + "  ");
//		}
		
//		System.out.println(str.replaceAll("<.+?>", ""));
	}

}
