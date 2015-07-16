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
