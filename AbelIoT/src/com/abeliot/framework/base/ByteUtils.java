package com.abeliot.framework.base;

public class ByteUtils {

	public static final byte[] hexBytes = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	public static byte[] toHex(byte b){
		byte[] hexs = new byte[2]; 
		hexs[0] = hexBytes[b >> 4];
		hexs[1] = hexBytes[b & 0xf];
		return hexs;
	}
	
	public static byte[] toHex(byte[] bytes){

		byte[] hexs = new byte[bytes.length << 1]; 
		
		for(int i=0; i<bytes.length; i++){
			hexs[(i<<1)+0] = hexBytes[(bytes[i] >> 4) & 0xf];
			hexs[(i<<1)+1] = hexBytes[bytes[i] & 0xf];
		}
		
		return hexs;
	}
	
	public static String toHexString(byte b){
		return new String(toHex(b));
	}
	
	public static String toHexString(byte[] bytes){
		return new String(toHex(bytes));
	}
	
	
}
