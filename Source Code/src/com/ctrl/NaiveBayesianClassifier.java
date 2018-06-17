package com.ctrl;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class NaiveBayesianClassifier {

	ArffLoader loader = new ArffLoader();
	Instances structure;
	NaiveBayesUpdateable nb;

	public void setFile(String path){

		try {
			loader.setFile(new File(path));
			structure = loader.getStructure();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void training(JTextArea jtaTraining) {

		try {
			structure.setClassIndex(structure.numAttributes() - 1);
			nb = new NaiveBayesUpdateable();
			nb.buildClassifier(structure);
			Instance current;
			while ((current = loader.getNextInstance(structure)) != null) {
				jtaTraining.append(current + "\n");
				nb.updateClassifier(current);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void classify(JTextArea jtaClass){
		try {
			jtaClass.setText(""+nb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
