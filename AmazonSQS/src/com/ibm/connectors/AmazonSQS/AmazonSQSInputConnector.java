package com.ibm.connectors.AmazonSQS;

import java.util.List;
import java.util.Properties;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.ibm.connectors.AbstractPollingInputConnector;
import com.ibm.connectors.ConnectorCallback;
import com.ibm.connectors.ConnectorException;

public class AmazonSQSInputConnector extends AbstractPollingInputConnector {

	//String access_key_id = getProperty("AccessKeyId");
    //String secret_access_key = getProperty("SecretAccessKey");
    //BasicAWSCredentials credentials;
    //AmazonSQS sqs;
    //GetQueueUrlResult queueUrl;
    
    
	@Override
	public void poll(long waitInterval ) {
		Properties properties = new Properties();
		
		String access_key_id = getProperty("AccessKeyId");
        String secret_access_key = getProperty("SecretAccessKey");
        BasicAWSCredentials credentials = new BasicAWSCredentials(access_key_id, secret_access_key);
		
        AmazonSQS sqs = new AmazonSQSClient(credentials);
        
        // Region selection
        Region region = Region.getRegion(Regions.fromName(getProperty("region")));
        sqs.setRegion(region);
        
        GetQueueUrlResult queueUrl = sqs.getQueueUrl(getProperty("Queue"));
        
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl.getQueueUrl());
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        
        String outputMessage = "";
        // if there are messages then do the processing
        if(messages.size() > 0){
        	
        	//append the message properties to the localenv tree
        	for (Message message : messages) {
                properties.setProperty("MessageId", message.getMessageId());
                properties.setProperty("ReceiptHandle", message.getReceiptHandle());
                properties.setProperty("MD5OfBody", message.getMD5OfBody());
                // get the message body to a string
                outputMessage = message.getBody();
            }
        	properties.setProperty("queueUrl", queueUrl.getQueueUrl());
            // delete the message from the queue
            String messageReceiptHandle = messages.get(0).getReceiptHandle();
            sqs.deleteMessage(new DeleteMessageRequest(queueUrl.getQueueUrl(), messageReceiptHandle));
            ConnectorCallback callback = getCallback();
    		callback.processInboundData(outputMessage.getBytes(), properties);
        }
	}

	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() throws ConnectorException {
		
		/*
        this.credentials = new BasicAWSCredentials(this.access_key_id, this.secret_access_key);
        this.sqs = new AmazonSQSClient(credentials);
        
        // Region selection
        Region region = Region.getRegion(Regions.fromName(getProperty("region")));
        sqs.setRegion(region);
        
        this.queueUrl = sqs.getQueueUrl(getProperty("Queue"));
        */
        
	}

	@Override
	public void stop() throws ConnectorException {
		// TODO Auto-generated method stub
		
	}

}
