package com.libsvm;
import java.io.IOException;

public class LibSVMTest {

	/**JAVA test code for LibSVM
	 * @author Eric Richard
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Test for svm_train and svm_predict
		//svm_train: 
		//	  param: String[], parse result of command line parameter of svm-train
		//    return: String, the directory of modelFile
		//svm_predect:
		//	  param: String[], parse result of command line parameter of svm-predict, including the modelfile
		//    return: Double, the accuracy of SVM classification
		String[] trainArgs = {"result/train_vec"};//directory of training file
		String modelFile = svm_train.main(trainArgs);
		String[] testArgs = {"result/test_vec", modelFile, "result/sem-eval-result"};//directory of test file, model file, result file
		Double accuracy = svm_predict.main(testArgs);
		System.out.println("SVM Classification is done! The accuracy is " + accuracy);
		
		//Test for cross validation
		//String[] crossValidationTrainArgs = {"-v", "10", "UCI-breast-cancer-tra"};// 10 fold cross validation
		//modelFile = svm_train.main(crossValidationTrainArgs);
		//System.out.print("Cross validation is done! The modelFile is " + modelFile);
	}

}
