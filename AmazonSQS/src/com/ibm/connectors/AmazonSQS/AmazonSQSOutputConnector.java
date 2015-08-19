/*
Copyright 2015 IBM Corporation 
Author Oliver Wynn
 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the MIT License
  which accompanies this distribution, and is available at
  http://opensource.org/licenses/MIT
 
  Contributors:
      Oliver Wynn - initial implementation v0.1
*/
package com.ibm.connectors.AmazonSQS;

import com.ibm.connectors.AbstractOutputConnector;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.OutputInteraction;


public class AmazonSQSOutputConnector extends AbstractOutputConnector
implements OutputConnector{

	@Override
	public OutputInteraction createOutputInteraction()
			throws ConnectorException {
		// TODO Auto-generated method stub
		Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		return new AmazonSQSOutputInteraction();
	}

}
