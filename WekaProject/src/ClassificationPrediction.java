

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.supervised.attribute.AddClassification;


public class ClassificationPrediction {
	public static void main(String[] args) throws Exception{
		
		 // Read all the instances in the file (ARFF, CSV, XRFF, ...)
		DataSource source = new DataSource("C:\\Users\\harsh\\Desktop\\Swift_Infotech\\ProjectExtract\\Wekajar&dataset\\iris.arff");
		Instances traindata = source.getDataSet();
		
		// Make the last attribute be the class
		traindata.setClassIndex(traindata.numAttributes()-1);
		int numClasses = traindata.numClasses();
		for (int i=0;i<numClasses;i++){
			String classValue = traindata.classAttribute().value(i);
			System.out.println("the "+i+"th class value:"+classValue);
		}
		/**
		 * naive bayes classifier	
		 */
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(traindata);
		/**
		 * load test data
		 */
		DataSource source2 = new DataSource("C:\\Users\\harsh\\Desktop\\Swift_Infotech\\ProjectExtract\\Wekajar&dataset\\iris-test.arff");
		Instances testdata = source2.getDataSet();
		testdata.setClassIndex(testdata.numAttributes()-1);
		
		
		/**
		 * make prediction by naive bayes classifier
		 */
		for (int j=0;j<testdata.numInstances();j++){
			double actualClass = testdata.instance(j).classValue();
			String actual = testdata.classAttribute().value((int) actualClass);
			Instance newInst = testdata.instance(j);
			//System.out.println("actual class:"+newInst.stringValue(newInst.numAttributes()-1));
			double preNB = nb.classifyInstance(newInst);
			String predString = testdata.classAttribute().value((int) preNB);
			System.out.println(actual+" --> "+predString);
		}
		
		
	}

}
