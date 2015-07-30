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

import com.ibm.connectors.AbstractConnectorFactory;
import com.ibm.connectors.ConnectorException;
import com.ibm.connectors.InputConnector;
import com.ibm.connectors.OutputConnector;
import com.ibm.connectors.RequestConnector;

public class AmazonSQSConnectorFactory extends AbstractConnectorFactory{

	@Override
	public InputConnector createInputConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return new AmazonSQSInputConnector();
	}

	@Override
	public OutputConnector createOutputConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return new AmazonSQSOutputConnector();
	}

	@Override
	public RequestConnector createRequestConnector(String arg0)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
