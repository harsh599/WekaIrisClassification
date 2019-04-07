import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class ArffToCsv {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		CSVLoader loader  = new CSVLoader();
		loader.setSource(new File("path.csv"));
		Instances data = loader.getDataSet();
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("path.arff"));
		saver.writeBatch();
	}

}
