package com.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

        private void classifyImpl(Deque<DirectedGraphNode> tuple,
                              Set<DirectedGraphNode> visited,
                              Set<DirectedGraphNode> levelSet,
                              double probability) {
        if (levelSet.isEmpty()) {
            // End the recursion, record the tuple and its probability as a new
            // system state.
            Map<DirectedGraphNode, Boolean> variableMap = new HashMap<>();

            for (DirectedGraphNode node : tuple) {

            }


            return;
        }

        Iterator<DirectedGraphNode> iterator = levelSet.iterator();
            DirectedGraphNode parent = null;

        // Remove the nodes from 'levelSet' whose some parents are not yet
        // processed.
        outer:
   


            visited.add(parent);

            if (tuple.size() < visited.size()) {
                tuple.addLast(parent);
            }

        


        boolean doInit = true;



        // Clean up the state for further recursion.
        for (DirectedGraphNode node : levelSet) {
            visited.remove(node);
        }
    }

    private double computeProbability(DirectedGraphNode[] nodeArray) {
        double p = 1.0;

     
        return p;
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



