package com.libsvm;
import java.io.IOException;




public class TestSVMScale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] trainArgs = {"-r","result/UCI-breast-cancer-tra.scale","data/UCI-breast-cancer-tra"};//directory of training file
		try {
			svm_scale.main(trainArgs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
