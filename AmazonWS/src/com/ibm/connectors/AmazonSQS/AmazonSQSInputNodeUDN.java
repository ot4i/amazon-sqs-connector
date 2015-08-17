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
 * <p>  <I>AmazonSQSInputNodeUDN</I> instance</p>
 * <p></p>
 */
public class AmazonSQSInputNodeUDN extends Node {

	private static final long serialVersionUID = 1L;

	// Node constants
	protected final static String NODE_TYPE_NAME = "com/ibm/connectors/AmazonSQS/PollingInputNode";
	protected final static String NODE_GRAPHIC_16 = "platform:/plugin/AmazonWS/icons/full/obj16/com/ibm/connectors/AmazonSQS/ComIbmPollingInput.gif";
	protected final static String NODE_GRAPHIC_32 = "platform:/plugin/AmazonWS/icons/full/obj30/com/ibm/connectors/AmazonSQS/ComIbmPollingInput.gif";

	protected final static String PROPERTY_CONNECTORNAME = "connectorName";
	protected final static String PROPERTY_QUEUE = "Queue";
	protected final static String PROPERTY_WAITINTERVAL = "waitInterval";
	protected final static String PROPERTY_ACCESSKEYID = "AccessKeyId";
	protected final static String PROPERTY_SECRETACCESSKEY = "SecretAccessKey";
	protected final static String PROPERTY_REGION = "region";


	/**
	 * <I>ENUM_AMAZONSQSINPUT_REGION</I>
	 * <pre>
	 * ENUM_AMAZONSQSINPUT_REGION.eu_west_1 = eu-west-1
	 * ENUM_AMAZONSQSINPUT_REGION.eu_central_1 = eu-central-1
	 * ENUM_AMAZONSQSINPUT_REGION.cn_north_1 = cn-north-1
	 * ENUM_AMAZONSQSINPUT_REGION.ap_northeast_1 = ap-northeast-1
	 * ENUM_AMAZONSQSINPUT_REGION.ap_southeast_1 = ap-southeast-1
	 * ENUM_AMAZONSQSINPUT_REGION.ap_southeast_2 = ap-southeast-2
	 * ENUM_AMAZONSQSINPUT_REGION.govcloud = govcloud
	 * ENUM_AMAZONSQSINPUT_REGION.sa_east_1 = sa-east-1
	 * ENUM_AMAZONSQSINPUT_REGION.us_east_1 = us-east-1
	 * ENUM_AMAZONSQSINPUT_REGION.us_west_1 = us-west-1
	 * ENUM_AMAZONSQSINPUT_REGION.us_west_2 = us-west-2
	 * </pre>
	 */
	public static class ENUM_AMAZONSQSINPUT_REGION {
		private String value;

		public static final ENUM_AMAZONSQSINPUT_REGION eu_west_1 = new ENUM_AMAZONSQSINPUT_REGION("eu-west-1");
		public static final ENUM_AMAZONSQSINPUT_REGION eu_central_1 = new ENUM_AMAZONSQSINPUT_REGION("eu-central-1");
		public static final ENUM_AMAZONSQSINPUT_REGION cn_north_1 = new ENUM_AMAZONSQSINPUT_REGION("cn-north-1");
		public static final ENUM_AMAZONSQSINPUT_REGION ap_northeast_1 = new ENUM_AMAZONSQSINPUT_REGION("ap-northeast-1");
		public static final ENUM_AMAZONSQSINPUT_REGION ap_southeast_1 = new ENUM_AMAZONSQSINPUT_REGION("ap-southeast-1");
		public static final ENUM_AMAZONSQSINPUT_REGION ap_southeast_2 = new ENUM_AMAZONSQSINPUT_REGION("ap-southeast-2");
		public static final ENUM_AMAZONSQSINPUT_REGION govcloud = new ENUM_AMAZONSQSINPUT_REGION("govcloud");
		public static final ENUM_AMAZONSQSINPUT_REGION sa_east_1 = new ENUM_AMAZONSQSINPUT_REGION("sa-east-1");
		public static final ENUM_AMAZONSQSINPUT_REGION us_east_1 = new ENUM_AMAZONSQSINPUT_REGION("us-east-1");
		public static final ENUM_AMAZONSQSINPUT_REGION us_west_1 = new ENUM_AMAZONSQSINPUT_REGION("us-west-1");
		public static final ENUM_AMAZONSQSINPUT_REGION us_west_2 = new ENUM_AMAZONSQSINPUT_REGION("us-west-2");

		protected ENUM_AMAZONSQSINPUT_REGION(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}

		protected static ENUM_AMAZONSQSINPUT_REGION getEnumFromString(String enumValue) {
			ENUM_AMAZONSQSINPUT_REGION enumConst = ENUM_AMAZONSQSINPUT_REGION.eu_west_1;
			if (ENUM_AMAZONSQSINPUT_REGION.eu_central_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.eu_central_1;
			if (ENUM_AMAZONSQSINPUT_REGION.cn_north_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.cn_north_1;
			if (ENUM_AMAZONSQSINPUT_REGION.ap_northeast_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.ap_northeast_1;
			if (ENUM_AMAZONSQSINPUT_REGION.ap_southeast_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.ap_southeast_1;
			if (ENUM_AMAZONSQSINPUT_REGION.ap_southeast_2.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.ap_southeast_2;
			if (ENUM_AMAZONSQSINPUT_REGION.govcloud.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.govcloud;
			if (ENUM_AMAZONSQSINPUT_REGION.sa_east_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.sa_east_1;
			if (ENUM_AMAZONSQSINPUT_REGION.us_east_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.us_east_1;
			if (ENUM_AMAZONSQSINPUT_REGION.us_west_1.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.us_west_1;
			if (ENUM_AMAZONSQSINPUT_REGION.us_west_2.value.equals(enumValue)) enumConst = ENUM_AMAZONSQSINPUT_REGION.us_west_2;
			return enumConst;
		}

		public static String[] values = new String[]{ "eu-west-1", "eu-central-1", "cn-north-1", "ap-northeast-1", "ap-southeast-1", "ap-southeast-2", "govcloud", "sa-east-1", "us-east-1", "us-west-1", "us-west-2" };

	}
	protected NodeProperty[] getNodeProperties() {
		return new NodeProperty[] {
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_CONNECTORNAME,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, "AmazonSQS","","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS"),
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_QUEUE,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS"),
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_WAITINTERVAL,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.INTEGER, "5","","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS"),
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_ACCESSKEYID,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS"),
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_SECRETACCESSKEY,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.STRING, null,"","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS"),
			new NodeProperty(AmazonSQSInputNodeUDN.PROPERTY_REGION,		NodeProperty.Usage.OPTIONAL,	false,	NodeProperty.Type.ENUMERATION, "eu-west-1", ENUM_AMAZONSQSINPUT_REGION.class,"","",	"com/ibm/connectors/AmazonSQS/ComIbmPollingInput",	"AmazonWS")
		};
	}

	public AmazonSQSInputNodeUDN() {
	}

	@Override
	public InputTerminal[] getInputTerminals() {
		return null;
	}

	public final OutputTerminal OUTPUT_TERMINAL_CATCH = new OutputTerminal(this,"OutTerminal.Catch");
	public final OutputTerminal OUTPUT_TERMINAL_OUT = new OutputTerminal(this,"OutTerminal.out");
	public final OutputTerminal OUTPUT_TERMINAL_FAILURE = new OutputTerminal(this,"OutTerminal.Failure");
	@Override
	public OutputTerminal[] getOutputTerminals() {
		return new OutputTerminal[] {
			OUTPUT_TERMINAL_CATCH,
			OUTPUT_TERMINAL_OUT,
			OUTPUT_TERMINAL_FAILURE
		};
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
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>connectorName</I>"
	 */
	public AmazonSQSInputNodeUDN setConnectorName(String value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_CONNECTORNAME, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> "<I>connectorName</I>" property
	 * 
	 * @return String; the value of the property "<I>connectorName</I>"
	 */
	public String getConnectorName() {
		return (String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_CONNECTORNAME);
	}

	/**
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>Queue</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>Queue</I>"
	 */
	public AmazonSQSInputNodeUDN setQueue(String value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_QUEUE, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> "<I>Queue</I>" property
	 * 
	 * @return String; the value of the property "<I>Queue</I>"
	 */
	public String getQueue() {
		return (String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_QUEUE);
	}

	/**
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>waitInterval</I>" property
	 * 
	 * @param value int ; the value to set the property "<I>waitInterval</I>"
	 */
	public AmazonSQSInputNodeUDN setWaitInterval(int value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_WAITINTERVAL, Integer.toString(value));
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> <I>waitInterval</I> property
	 * 
	 * @return int; the value of the property "<I>waitInterval</I>"
	 */
	public int getWaitInterval() {
		String value = (String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_WAITINTERVAL);
		return Integer.valueOf(value).intValue();
	}

	/**
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>AccessKeyId</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>AccessKeyId</I>"
	 */
	public AmazonSQSInputNodeUDN setAccessKeyId(String value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_ACCESSKEYID, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> "<I>AccessKeyId</I>" property
	 * 
	 * @return String; the value of the property "<I>AccessKeyId</I>"
	 */
	public String getAccessKeyId() {
		return (String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_ACCESSKEYID);
	}

	/**
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>SecretAccessKey</I>" property
	 * 
	 * @param value String ; the value to set the property "<I>SecretAccessKey</I>"
	 */
	public AmazonSQSInputNodeUDN setSecretAccessKey(String value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_SECRETACCESSKEY, value);
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> "<I>SecretAccessKey</I>" property
	 * 
	 * @return String; the value of the property "<I>SecretAccessKey</I>"
	 */
	public String getSecretAccessKey() {
		return (String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_SECRETACCESSKEY);
	}

	/**
	 * Set the <I>AmazonSQSInputNodeUDN</I> "<I>region</I>" property
	 * 
	 * @param value ENUM_AMAZONSQSINPUT_REGION ; the value to set the property "<I>region</I>"
	 */
	public AmazonSQSInputNodeUDN setRegion(ENUM_AMAZONSQSINPUT_REGION value) {
		setProperty(AmazonSQSInputNodeUDN.PROPERTY_REGION, value.toString());
		return this;
	}

	/**
	 * Get the <I>AmazonSQSInputNodeUDN</I> "<I>region</I>" property
	 * 
	 * @return ENUM_AMAZONSQSINPUT_REGION; the value of the property "<I>region</I>"
	 */
	public ENUM_AMAZONSQSINPUT_REGION getRegion() {
		ENUM_AMAZONSQSINPUT_REGION value = ENUM_AMAZONSQSINPUT_REGION.getEnumFromString((String)getPropertyValue(AmazonSQSInputNodeUDN.PROPERTY_REGION));
		return value;
	}

	public String getNodeName() {
		String retVal = super.getNodeName();
		if ((retVal==null) || retVal.equals(""))
			retVal = "AmazonSQSInput";
		return retVal;
	};
}
