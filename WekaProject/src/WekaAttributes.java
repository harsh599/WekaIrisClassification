import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaAttributes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DataSource source = new DataSource("E:\\jars\\arff-datasets-master\\arff-datasets-master\\classification\\car.arff");
		Instances data = source.getDataSet();
		if(data.classIndex() == -1){
			data.setClassIndex(data.numAttributes()-1);
		}
		System.out.println("class index "+data.classIndex());
		int numAttr = data.numAttributes()-1;
		
		System.out.println("number of attributes "+numAttr);
		
		for(int i =0;i<numAttr;i++){
			if(data.attribute(i).isNominal()){
				System.out.println(i+ " th attribute is nominal");
				int n = data.attribute(i).numValues();
				System.out.println(i +" th attribute has "+n+"values");
			}
			
		}
		int numInst = data.numInstances();
		for(int j=0;j<numInst;j++){
				Instance inst = data.instance(j); // creating instance and not instances
				double cv= inst.classValue();
				System.out.println(inst.classAttribute().value((int) cv));
		}
		
	}

}
