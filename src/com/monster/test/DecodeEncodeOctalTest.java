package com.monster.test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.monster.main.DecodeEncodeOctal;

public class DecodeEncodeOctalTest {
	
	@Test
	public void testcalculateSHA1HashValue() throws NoSuchAlgorithmException {
		byte [] byteArr = {103, 77, 97};
        String result = DecodeEncodeOctal.calculateSHA1HashValue(byteArr);
        assertEquals("a1eb071da2e9580ef3f8db6b579ea98300cc7296", result);
	}

	@Test
	public void testEncodeBase64() {
		byte [] byteArr = {103, 77, 97};
        String result = DecodeEncodeOctal.encodeBase64(byteArr);
        assertEquals("Z01h", result);
	}

	@Test
	public void testEncodeHexadecimal() {
		byte [] byteArr = {103, 77, 97};
        String result = DecodeEncodeOctal.encodeHexadecimal(byteArr);
        assertEquals("674d61", result);
	}

	@Test
	public void testEncodeOctal() {
		byte [] byteArr = {103, 77, 97};
        String result = DecodeEncodeOctal.encodeOctal(byteArr);
        assertEquals("31646541", result);
	}

	@Test
	public void testOctalToBinary() {
		String octalNum="31646541";
		String result = DecodeEncodeOctal.octalToBinary(octalNum);
		assertEquals("011001110100110101100001", result);
	}

	@Test
	public void testGetByteByString() {
		String binaryStr="011001110100110101100001";
		byte[] result = DecodeEncodeOctal.getByteByString(binaryStr);
		assertArrayEquals(new byte[] {103, 77, 97}, result);
	}

}
