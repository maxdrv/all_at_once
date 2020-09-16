package com.home.bytes;

import com.home.util.AppUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SpringBootTest
class ByteAndCharDemo {

    @Autowired
    private AppUtil util;

    @Nested
    @DisplayName("chars to ints")
    class CharsToInts{

        @Test
        @DisplayName("Translate chars to base10 integers")
        void translateCharsToBase10Integers(){
            char[] chars = util.range('а', 'д');
            int[] actualInts = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                actualInts[i] = chars[i];
            }
            int[] expected = {1072, 1073, 1074, 1075, 1076};
            Assertions.assertArrayEquals(expected, actualInts);
        }

        @Test
        @DisplayName("Translate chars to base16 integers")
        void translateCharsToBase16Integers(){
            char[] chars = util.range('а', 'д');
            int[] actualInts = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                actualInts[i] = Integer.parseInt(Integer.toHexString(chars[i]));
            }
            int[] expected = {430, 431, 432, 433, 434};
            Assertions.assertArrayEquals(expected, actualInts);
        }

        @Test
        @DisplayName("Translate chars to base2 longs")
        void translateCharsToBase2Longs(){
            char[] chars = util.range('а', 'д');
            long[] actualLongs = new long[chars.length];
            for (int i = 0; i < chars.length; i++) {
                actualLongs[i] = Long.parseLong(Integer.toBinaryString(chars[i]));
            }
            long[] expected = {100_0011_0000L, 100_0011_0001L, 100_0011_0010L, 100_0011_0011L, 100_0011_0100L};
            Assertions.assertArrayEquals(expected, actualLongs);
        }

    }

    @DisplayName("chars to bytes of different encodings")
    @Nested
    class CharsToBytes{
        @Test
        @DisplayName("English character translated to bytes of UTF-8")
        void englishCharacterTranslatedToBytesOfUtf8(){
            String pseudoChar = "S";
            byte[] bytes = pseudoChar.getBytes(StandardCharsets.UTF_8);
            Assertions.assertArrayEquals(new byte[]{83}, bytes);
        }

        @Test
        @DisplayName("Two english characters translated to bytes of UTF-8")
        void twoEnglishCharactersTranslatedToBytesOfUtf8(){
            String pseudoChar = "SU";
            byte[] bytes = pseudoChar.getBytes(StandardCharsets.UTF_8);
            Assertions.assertArrayEquals(new byte[]{83, 85}, bytes);
        }

        @Test
        @DisplayName("English character translated to bytes of UTF-16")
        void englishCharacterTranslatedToBytesOfUtf16(){
            String pseudoChar = "S";
            byte[] bytes = pseudoChar.getBytes(StandardCharsets.UTF_16);
            Assertions.assertArrayEquals(new byte[]{-2, -1, 0, 83}, bytes);
        }

        @Test
        @DisplayName("Two english characters translated to bytes of UTF-16")
        void twoEnglishCharactersTranslatedToBytesOfUtf16(){
            String pseudoChar = "SU";
            byte[] bytes = pseudoChar.getBytes(StandardCharsets.UTF_16);
            Assertions.assertArrayEquals(new byte[]{-2, -1, 0, 83, 0, 85}, bytes);
        }

        @Test
        @DisplayName("Two english characters translated to bytes of US_ASCII")
        void twoEnglishCharactersTranslatedToBytesOfUsAscii(){
            String pseudoChar = "SU";
            byte[] bytes = pseudoChar.getBytes(StandardCharsets.US_ASCII);
            Assertions.assertArrayEquals(new byte[]{83, 85}, bytes);
        }

    }

    @Test
    @DisplayName("ByteClassDemo")
    void byteClassDemo(){
        byte maxValue = Byte.MAX_VALUE;
        Assertions.assertEquals(127, maxValue);

        byte minValue = Byte.MIN_VALUE;
        Assertions.assertEquals(-128, minValue);

        int numberOfBytesInOneByte = Byte.BYTES;
        Assertions.assertEquals(1, numberOfBytesInOneByte);

        int numberOfBitsInOneByte = Byte.SIZE;
        Assertions.assertEquals(8, numberOfBitsInOneByte);
    }

    @Test
    @DisplayName("bytes to base64")
    void bytesToBase64(){
        byte[] twoBytes = new byte[]{83, 85};
        byte[] base64bytes = Base64.getEncoder().encode(twoBytes);
        System.out.println(new String(base64bytes, StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test name")
    void testName() throws UnsupportedEncodingException {
        String result = util.encode("SU");
        System.out.println(result);
    }

    @Test
    @DisplayName("encoding")
    void encoding(){
        String test = "test";
        byte[] bytesUtf8 = test.getBytes(StandardCharsets.UTF_8);
        byte[] expected = {116, 101, 115, 116};
        Assertions.assertArrayEquals(expected, bytesUtf8);

        StringBuilder builder = new StringBuilder();
        for (byte b : bytesUtf8) {
            builder.append(binary(b));
        }
        int limit = 6;
        char[] buffer = new char[limit];
        List<String> strings = new ArrayList<>();
        int position = 0;
        int cursor = 0;
        while (position < builder.length()) {
            if (cursor < limit) {
                buffer[cursor] = builder.charAt(position);
                cursor++;
                position++;
            } else if (cursor == limit) {
                strings.add(new String(buffer));
                buffer = new char[limit];
                cursor = 0;
            }
        }
        strings.add(new String(buffer));
        for (String str : strings) {
            System.out.print(str + " ");
//            System.out.println(Byte.parseByte(str, 2));
        }

    }

    private String binary(byte b) {
        StringBuilder binaryForm = new StringBuilder(Integer.toBinaryString(b));
        while (binaryForm.length() < 8) {
            binaryForm.insert(0, "0");
        }
        return binaryForm.toString();
    }

    
}
