package com.ctrl;


import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import weka.core.Debug.Random;


public class DataSource {

  
  public static Instances read(String filename) throws Exception {
    ArffLoader loader = new ArffLoader();
    loader.setSource(new File(filename));
    Instances data = loader.getDataSet();
    return data;
  }
  public void k2search ( Instances instances) throws Exception { 
  int nOrder[] = new int [instances.numAttributes()]; 
  nOrder[0] = instances.classIndex(); 
 
  int nAttribute = 0; 
 
  for (int iOrder = 1; iOrder < instances.numAttributes(); iOrder++) { 
    if (nAttribute == instances.classIndex()) { 
      nAttribute++; 
    }  
    nOrder[iOrder] = nAttribute++; 
  }  
      boolean m_bRandomOrder = false;
 
  if (m_bRandomOrder) { 
   // generate random ordering (if required) 
   Random random = new Random(); 
     int iClass; 
     if (setValuesintoIntialBayes()) { 
      iClass = 0;  
     } else { 
      iClass = -1; 
     } 
   for (int iOrder = 0; iOrder < instances.numAttributes(); iOrder++) { 
   int iOrder2 = Math.abs(random.nextInt()) % instances.numAttributes(); 
      if (iOrder != iClass && iOrder2 != iClass) { 
       int nTmp = nOrder[iOrder]; 
       nOrder[iOrder] = nOrder[iOrder2]; 
       nOrder[iOrder2] = nTmp; 
      } 
   } 
  } 
 
  // determine base scores 
  double [] fBaseScores = new double [instances.numAttributes()]; 
  for (int iOrder = 0; iOrder < instances.numAttributes(); iOrder++) { 
   int iAttribute = nOrder[iOrder]; 
 
  } 
 
  // K2 algorithm: greedy search restricted by ordering  
  for (int iOrder = 1; iOrder < instances.numAttributes(); iOrder++) { 
   int iAttribute = nOrder[iOrder]; 
   double fBestScore = fBaseScores[iAttribute]; 
 
   
   while (m_bRandomOrder) { 
    int nBestAttribute = -1; 
    for (int iOrder2 = 0; iOrder2 < iOrder; iOrder2++) { 
     int iAttribute2 = nOrder[iOrder2]; 
 
    } 
   } 
  } 
 } // buildStructure  
 
 /**
  * Sets the max number of parents 
  * 
  * @param nMaxNrOfParents the max number of parents 
  */ 
 public void findMaxNrOfParents(int nMaxNrOfParents) { 
      int m_nMaxNrOfParents = nMaxNrOfParents; 
 }  
 
 /**
  * Gets the max number of parents. 
  * 
  * @return the max number of parents 
  */ 
 public int getMaxNrOfParents() { 
      int m_nMaxNrOfParents = 0;
   return m_nMaxNrOfParents; 
 }  
 
 /**
  * Sets whether to init as naive bayes 
  * 
  * @param bInitAsNaiveBayes whether to init as naive bayes 
  */ 
 public void setFunctiontoBayes(boolean bInitAsNaiveBayes) { 
      boolean m_bInitAsNaiveBayes = bInitAsNaiveBayes; 
 }  
 
 /**
  * Gets whether to init as naive bayes 
  * 
  * @return whether to init as naive bayes 
  */ 
 public boolean setValuesintoIntialBayes() { 
      boolean m_bInitAsNaiveBayes=true;
   return m_bInitAsNaiveBayes; 
 }  
 
 }