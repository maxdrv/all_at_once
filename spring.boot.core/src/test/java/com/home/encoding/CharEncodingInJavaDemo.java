package com.home.encoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class CharEncodingInJavaDemo {

    @Test
    @DisplayName("java strings is a us_ascii encoded strings (german example)")
    void javaStringsIsAUsAsciiEncodedStringsGermanExample(){
        String rawString = "Entwickeln Sie mit Vergnugen";
        byte[] germanBytes = rawString.getBytes();

        String asciiEncodedString = new String(germanBytes, StandardCharsets.US_ASCII);
        Assertions.assertEquals(rawString, asciiEncodedString);
    }

    @Test
    @DisplayName("java strings is a us_ascii encoded strings (english example)")
    void javaStringsIsAUsAsciiEncodedStringsEnglishExample(){
        String rawString = "developing is fan";
        byte[] englishBytes = rawString.getBytes();

        String asciiEncodedString = new String(englishBytes, StandardCharsets.US_ASCII);
        Assertions.assertEquals(rawString, asciiEncodedString);
    }

    @Test
    @DisplayName("creating a new string with desired encoding")
    void creatingANewStringWithDesiredEncoding(){
        String rawString = "Entwickeln Sie mit Vergnügen";
        byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        Assertions.assertEquals(rawString, utf8EncodedString);
    }

    @Test
    @DisplayName("encoding strings with features from java 7")
    void encodingStringsWithFeaturesFromJava7(){
        String rawString = "Entwickeln Sie mit Vergnügen";
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString);

        String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
        Assertions.assertEquals(rawString, utf8EncodedString);
    }

    @Test
    @DisplayName("display same stirng in diffrent encodings")
    void displaySameStirngInDiffrentEncodings() {
        String example = "abcd";

        System.out.println(Arrays.toString(example.getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString(example.getBytes(StandardCharsets.UTF_16)));
        System.out.println(Arrays.toString(example.getBytes(StandardCharsets.US_ASCII)));

    }

    /**
     * На моей jvm дефолтная кодировка UFT-8
     * Но класс String все равно должен хранить внутреннее представление строки в UTF-16 согласно документации
     * Изменить дефолтную кодировку в runtime не возможно, jvm должна уже стартовать с заданной дефолтной кодировкой
     * можно передать параметр командной строки что бы изменить кодировку
     * -Dfile.encoding=UTF-16
     */
    @Test
    @DisplayName("Default java platform charset")
    void defaultJavaPlatformCharset(){
        String charsetName = Charset.defaultCharset().name();
        System.out.println("charsetName = " + charsetName);
        Assertions.assertEquals("UTF-8", charsetName);
    }
    

}
