package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	
	
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		loadDic();
		
		
/*//		String str = "Conflicting loads were stalled while pending <e1>stores</e1> were draining into <e2>memory</e2>.";
		String str  = "Instead, <e1>criminal law</e1> is set out in a diverse <e2>range</e2> of statutes and court decisions.";
//		String str = "I've got the <e1>world</e1> in a <e2>jug</e2>, the stopper's in my hand.";
		
		System.out.println(str.substring(str.indexOf("<e1>")+4,str.indexOf("</e1>")));
		System.out.println(str.substring(str.indexOf("<e2>")+4,str.indexOf("</e2>")));
		System.out.println(str.replaceAll("<.+?>", ""));*/
	}

}
