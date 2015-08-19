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

import java.util.Properties;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.ibm.connectors.AbstractOutputInteraction;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;

public class AmazonSQSOutputInteraction extends AbstractOutputInteraction{

	@Override
	public long asyncSend(Properties arg0, Object arg1, ConnectorCallback arg2)
			throws ConnectorException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Properties send(Properties properties, Object message)
			throws ConnectorException {
		
		
		String access_key_id = properties.getProperty("AccessKeyId");
        String secret_access_key = properties.getProperty("SecretAccessKey");
        BasicAWSCredentials credentials = new BasicAWSCredentials(access_key_id, secret_access_key);
		
        AmazonSQS sqs = new AmazonSQSClient(credentials);
        //System.out.println(properties.getProperty("region"));
        // Region selection
        Region region = Region.getRegion(Regions.fromName(properties.getProperty("region")));
        sqs.setRegion(region);
        
        GetQueueUrlResult queueUrl = sqs.getQueueUrl(properties.getProperty("Queue"));
        String messageStr = new String((byte[])message);
        
        sqs.sendMessage(new SendMessageRequest(queueUrl.getQueueUrl(), messageStr));
        
		return properties;
	}

}
