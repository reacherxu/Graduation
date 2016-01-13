package com.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "The <e1>byelection</e1> was caused by the <e2>resignation</e2> " +
				"of Boris Johnson following his election as mayor of London in May.";
		System.out.println(str.replaceAll("<.+?>", ""));
	}

}
