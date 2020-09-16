package com.home.tika;

import org.apache.tika.parser.txt.CharsetDetector;
import org.apache.tika.parser.txt.CharsetMatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@DisplayName("charset detector")
class TikaCharsetDetectionDemo {

    @Test
    @DisplayName("detect sentence of utf-8")
    void detectSentenceOfUtf8() throws IOException {
        byte[] utf8 = "string in utf-8. А так же присутсвуют символы не английского языка".getBytes(StandardCharsets.UTF_8);
        Assertions.assertEquals("UTF-8", detect(utf8)[0].getName());
    }

    @Disabled("Одного словаа не достаточно что бы определить кодировку, в данном случае предлагается ISO-8859-1")
    @Test
    @DisplayName("detect word of utf-8")
    void detectWordOfUtf8() throws IOException {
        byte[] utf8 = "string".getBytes(StandardCharsets.UTF_8);
        Assertions.assertEquals("UTF-8", detect(utf8)[0].getName());
    }

    @Test
    @DisplayName("detect sentence of windows-1251")
    void detectSentenceOfWindows1251() throws IOException {
        byte[] win1251 = "string in windows-1251. А так же присутсвуют символы не английского языка".getBytes("windows-1251");
        Assertions.assertEquals("windows-1251", detect(win1251)[0].getName());
    }

    @Disabled("Одного словаа не достаточно что бы определить кодировку, в данном случае предлагается Big5")
    @Test
    @DisplayName("detect word of windows-1251")
    void detectWordOfWindows1251() throws IOException {
        byte[] win1251 = "строка".getBytes("windows-1251");
        Assertions.assertEquals("windows-1251", detect(win1251)[0].getName());
    }

    private CharsetMatch[] detect(byte[] bytes) throws IOException {
        CharsetDetector detector = new CharsetDetector();
        detector.setText(bytes);
        return detector.detectAll();
    }

}
