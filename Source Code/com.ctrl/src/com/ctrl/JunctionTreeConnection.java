package com.ctrl;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Remove;

public class JunctionTreeConnection extends Thread {

	String ptrain;
	String ptest;
	JTextArea jta;

	public void run() {
		try {
			Instances train = DataSource.read(ptrain);
			Instances test = DataSource.read(ptest);
			train.setClassIndex(train.numAttributes() - 1);
			test.setClassIndex(test.numAttributes() - 1);
			if (!train.equalHeaders(test))
				throw new IllegalArgumentException(
						"Datasets are not compatible!");

			Remove rm = new Remove();
			rm.setAttributeIndices("1");

			J48 j48 = new J48();
			j48.setUnpruned(true);

			FilteredClassifier fc = new FilteredClassifier();
			fc.setFilter(rm);
			fc.setClassifier(j48);

			fc.buildClassifier(train);
			for (int i = 0; i < test.numInstances(); i++) {
				double pred = fc.classifyInstance(test.instance(i));
				jta.append("ID: " + test.instance(i).value(0));
				jta.append(", actual: "
						+ test.classAttribute().value(
								(int) test.instance(i).classValue()));
				jta.append(", predicted: "
						+ test.classAttribute().value((int) pred));
				jta
						.append("\n-----------------------------------------------------------\n");

			}
			JOptionPane.showMessageDialog(null, "Connection Recognition Finished.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(String taianpath, String testpath, JTextArea jta2) {
		// TODO Auto-generated method stub
		this.ptrain=taianpath;
		this.ptest=testpath;
		this.jta=jta2;

	}
}