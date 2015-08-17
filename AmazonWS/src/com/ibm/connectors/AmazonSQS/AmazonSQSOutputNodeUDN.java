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

import com.ibm.broker.config.appdev.InputTerminal;
import com.ibm.broker.config.appdev.Node;
import com.ibm.broker.config.appdev.NodeProperty;
import com.ibm.broker.config.appdev.OutputTerminal;

/*** 
 * <p>  <I>AmazonSQSOutputNodeUDN</I> instance</p>
 * <p></p>
 */
public class AmazonSQSOutputNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connectors/AmazonSQS/OutputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/AmazonWS/icons/full/obj16/com/ibm/connectors/AmazonSQS/ComIbmOutput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/AmazonWS/icons/full/obj30/com/ibm/connectors/AmazonSQS/ComIbmOutput.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_QUEUE = "Queue";
	protected final static String PROPERTY_ACCESSKEYID = "AccessKeyId";
	protected final static String PROPERTY_SECRETACCESSKEY = "SecretAccessKey";
	protected final static String PROPERTY_REGION = "region";


	/**
	 * <I>ENUM_AMAZONSQSOUTPUT_REGION</I>
	 * <pre>
	 * ENUM_AMAZONSQSOUTPUT_REGION.eu_west_1 = eu-west-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.eu_central_1 = eu-central-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.cn_north_1 = cn-north-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_2 = ap-southeast-2
	 * ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_1 = ap-southeast-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.ap_northeast_1 = ap-northeast-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.govcloud = govcloud
	 * ENUM_AMAZONSQSOUTPUT_REGION.us_east_1 = us-east-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.us_west_1 = us-west-1
	 * ENUM_AMAZONSQSOUTPUT_REGION.us_west_2 = us-west-2
	 * </pre>
	 */
	public static class ENUM_AMAZONSQSOUTPUT_REGION {
		private String value;

		public static final ENUM_AMAZONSQSOUTPUT_REGION eu_west_1 = new ENUM_AMAZONSQSOUTPUT_REGION("eu-west-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION eu_central_1 = new ENUM_AMAZONSQSOUTPUT_REGION("eu-central-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION cn_north_1 = new ENUM_AMAZONSQSOUTPUT_REGION("cn-north-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION ap_southeast_2 = new ENUM_AMAZONSQSOUTPUT_REGION("ap-southeast-2");
		public static final ENUM_AMAZONSQSOUTPUT_REGION ap_southeast_1 = new ENUM_AMAZONSQSOUTPUT_REGION("ap-southeast-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION ap_northeast_1 = new ENUM_AMAZONSQSOUTPUT_REGION("ap-northeast-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION govcloud = new ENUM_AMAZONSQSOUTPUT_REGION("govcloud");
		public static final ENUM_AMAZONSQSOUTPUT_REGION us_east_1 = new ENUM_AMAZONSQSOUTPUT_REGION("us-east-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION us_west_1 = new ENUM_AMAZONSQSOUTPUT_REGION("us-west-1");
		public static final ENUM_AMAZONSQSOUTPUT_REGION us_west_2 = new ENUM_AMAZONSQSOUTPUT_REGION("us-west-2");

		protected ENUM_AMAZONSQSOUTPUT_REGION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_AMAZONSQSOUTPUT_REGION getEnumFromString(String enumValue) {
			ENUM_AMAZONSQSOUTPUT_REGION enumConst = ENUM_AMAZONSQSOUTPUT_REGION.eu_west_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.eu_central_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.eu_central_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.cn_north_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.cn_north_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_2.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_2;
			if (ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.ap_southeast_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.ap_northeast_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.ap_northeast_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.govcloud.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.govcloud;
			if (ENUM_AMAZONSQSOUTPUT_REGION.us_east_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.us_east_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.us_west_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.us_west_1;
			if (ENUM_AMAZONSQSOUTPUT_REGION.us_west_2.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSOUTPUT_REGION.us_west_2;
			return enumConst;
		}

		public static String[] values = new String[]{ "eu-west-1", "eu-central-1", "cn-north-1", "ap-southeast-2", "ap-southeast-1", "ap-northeast-1", "govcloud", "us-east-1", "us-west-1", "us-west-2" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(AmazonSQSOutputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "AmazonSQS","","",	"com/ibm/connectors/AmazonSQS/ComIbmOutput",	"AmazonWS"),
			new NodeProperty(AmazonSQSOutputNodeUDN.PROPERTY_QUEUE,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmOutput",	"AmazonWS"),
			new NodeProperty(AmazonSQSOutputNodeUDN.PROPERTY_ACCESSKEYID,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmOutput",	"AmazonWS"),
			new NodeProperty(AmazonSQSOutputNodeUDN.PROPERTY_SECRETACCESSKEY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmOutput",	"AmazonWS"),
			new NodeProperty(AmazonSQSOutputNodeUDN.PROPERTY_REGION,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.ENUMERATION, "eu-west-1", ENUM_AMAZONSQSOUTPUT_REGION.class,"","",	"com/ibm/connectors/AmazonSQS/ComIbmOutput",	"AmazonWS")
		};
	}

	public AmazonSQSOutputNodeUDN() {
	}

	public final InputTerminal INPUT_TERMINAL_IN = new InputTerminal(this,"InTerminal.in");
	@Override
	public InputTerminal[] getInputTerminals() {
		return new InputTerminal[] {
			INPUT_TERMINAL_IN
	};
	}

	@Override
	public OutputTerminal[] getOutputTerminals() {
		return null;
	}

	@Override
	public String getTypeName() {
		return NODE_TYPE_NAME;
	}

	protected String getGraphic16() {
		return NODE_GRAPHIC_16;
	}

	protected String getGraphic32() {
		return NODE_GRAPHIC_32;
	}

	/**
	 * Set the <I>AmazonSQSOutputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public AmazonSQSOutputNodeUDN setConnectorName(String value) {
		setProperty(AmazonSQSOutputNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSOutputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(AmazonSQSOutputNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>AmazonSQSOutputNodeUDN</I> "<I>Queue</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Queue</I>"
	 */
	public AmazonSQSOutputNodeUDN setQueue(String value) {
		setProperty(AmazonSQSOutputNodeUDN.PROPERTY_QUEUE, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSOutputNodeUDN</I> "<I>Queue</I>" property
	 * 
	 * @return String; the value of the property "<I>Queue</I>"
	 */
	public String getQueue() {
		return (String)getPropertyValue(AmazonSQSOutputNodeUDN.PROPERTY_QUEUE);
	}

	/**
	 * Set the <I>AmazonSQSOutputNodeUDN</I> "<I>AccessKeyId</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>AccessKeyId</I>"
	 */
	public AmazonSQSOutputNodeUDN setAccessKeyId(String value) {
		setProperty(AmazonSQSOutputNodeUDN.PROPERTY_ACCESSKEYID, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSOutputNodeUDN</I> "<I>AccessKeyId</I>" property
	 * 
	 * @return String; the value of the property "<I>AccessKeyId</I>"
	 */
	public String getAccessKeyId() {
		return (String)getPropertyValue(AmazonSQSOutputNodeUDN.PROPERTY_ACCESSKEYID);
	}

	/**
	 * Set the <I>AmazonSQSOutputNodeUDN</I> "<I>SecretAccessKey</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>SecretAccessKey</I>"
	 */
	public AmazonSQSOutputNodeUDN setSecretAccessKey(String value) {
		setProperty(AmazonSQSOutputNodeUDN.PROPERTY_SECRETACCESSKEY, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSOutputNodeUDN</I> "<I>SecretAccessKey</I>" property
	 * 
	 * @return String; the value of the property "<I>SecretAccessKey</I>"
	 */
	public String getSecretAccessKey() {
		return (String)getPropertyValue(AmazonSQSOutputNodeUDN.PROPERTY_SECRETACCESSKEY);
	}

	/**
	 * Set the <I>AmazonSQSOutputNodeUDN</I> "<I>region</I>" property
	 * 
	 * @param value ENUM_AMAZONSQSOUTPUT_REGION ; the value to set the property "<I>region</I>"
	 */
	public AmazonSQSOutputNodeUDN setRegion(ENUM_AMAZONSQSOUTPUT_REGION value) {
		setProperty(AmazonSQSOutputNodeUDN.PROPERTY_REGION, value.toString());
		return this;
	}

	/**
	 * Get the <I>AmazonSQSOutputNodeUDN</I> "<I>region</I>" property
	 * 
	 * @return ENUM_AMAZONSQSOUTPUT_REGION; the value of the property "<I>region</I>"
	 */
	public ENUM_AMAZONSQSOUTPUT_REGION getRegion() {
		ENUM_AMAZONSQSOUTPUT_REGION value = ENUM_AMAZONSQSOUTPUT_REGION.getEnumFromString((String)getPropertyValue(AmazonSQSOutputNodeUDN.PROPERTY_REGION));
		return value;
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "AmazonSQSOutput";
		return retVal;
	};
}
