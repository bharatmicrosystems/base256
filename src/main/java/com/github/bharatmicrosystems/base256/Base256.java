package com.github.bharatmicrosystems.base256;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Base256 {
	private static String charsetStr = "àáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƀƁƂƃƄƅƆƇƈƉ=_-`~|[]{}ƞ?,()^*$%!#.ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	private static char[] char_set = charsetStr.toCharArray();
	public static String base256Encode(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (byte b : bytes) {
			buff.append(byteToBase256(b));
		}

		return buff.toString();
	}

	public static byte[] base256Decode(String base256String) {
		char[] base256chars = base256String.toCharArray();
		byte[] output = new byte[base256String.length()];
		int i = 0;
		for (char c: base256chars){
			output[i]=base256ToByte(c);
			i++;
		}
		return output;
	}

	public static void print(Object str) {
		System.out.println(str);
	}

	public static void main(String[] args) throws IOException {
		String encodedString = Base256.base256Encode(FileUtils.readFileToByteArray(new File("statements.pdf")));
		print (encodedString);
		byte[] decodedString = Base256.base256Decode(encodedString);
		FileUtils.writeByteArrayToFile(new File("output/statements.pdf"), decodedString);
	}
	
	private static byte base256ToByte(char c){
		byte b = (byte) (charsetStr.indexOf(c) - 128);
		return b;
	}

	private static char byteToBase256(int b) {
		return char_set[b+128];
	}

}
