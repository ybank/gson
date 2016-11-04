package com.google.gson;

import com.google.gson.common.MoreAsserts;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.math.BigDecimal;

public class JsonPrimitiveTest extends TestCase {

  public void testGetInt() {
  	JsonPrimitive json1 = new JsonPrimitive(new Integer(10));
	assertEquals(10, json1.getAsInt());
	
  	JsonPrimitive json2 = new JsonPrimitive(new BigInteger("10"));
	assertEquals(10, json2.getAsInt());
	
  	JsonPrimitive json3 = new JsonPrimitive(10.1);
	assertEquals(10, json2.getAsInt());

  }
  
  public void testGetOverflowedInt() {
	BigInteger limit = new BigInteger("18446744073709551616"); // 2^64
	JsonPrimitive json = new JsonPrimitive(limit.add(new BigInteger("10")));
  	assertEquals(10, json.getAsInt());
  }
  
  public void testGetOverflowedIntGivenBigDecimal() {
	BigDecimal limit = new BigDecimal("18446744073709551616"); // 2^64
	JsonPrimitive json = new JsonPrimitive(limit.add(new BigDecimal("10.1")));
  	assertEquals(10, json.getAsInt());
  }

}
