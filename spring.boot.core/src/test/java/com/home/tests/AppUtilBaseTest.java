package com.home.tests;


import com.home.util.AppUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@DisplayName("using basic base64 encoder")
class AppUtilBaseTest {

    @Autowired
    private AppUtil base;

    @Test
    void inputIsNativeJavaEncoding() throws UnsupportedEncodingException {
        String src = "input string in standart java string encoding";
        String result = base.encode(src, "UTF-8");
        Assertions.assertEquals("aW5wdXQgc3RyaW5nIGluIHN0YW5kYXJ0IGphdmEgc3RyaW5nIGVuY29kaW5n", result);
    }

    @DisplayName("english characters")
    @Nested
    class engCharacters{
        @Test
        @DisplayName("encode string from default String.getBytes")
        void encodeStringFromDefaultStringGetBytes() throws UnsupportedEncodingException {
            String src = "abcd";
            String result = base.encode(src);
            System.out.println("result = " + result);
            Assertions.assertEquals("YWJjZA==", result);
        }

        @Test
        @DisplayName("encode utf16 string as base64")
        void encodeUtf16StringAsBase64() throws UnsupportedEncodingException {
            String src = "abcd";
            String result = base.encode(src, "UTF-16");
            System.out.println("result = " + result);
            Assertions.assertEquals("/v8AYQBiAGMAZA==", result);
        }

        @Test
        @DisplayName("encode us_ascii as base64")
        void encodeUsAsciiAsBase64() throws UnsupportedEncodingException {
            String src = "abcd";
            String result = base.encode(src, "US-ASCII");
            System.out.println("result = " + result);
            Assertions.assertEquals("YWJjZA==", result);
        }

        @Test
        @DisplayName("encode utf8 string as base64")
        void encodeUtf8StringAsBase64() throws UnsupportedEncodingException {
            String src = "abcd";
            String result = base.encode(src, "UTF-8");
            Assertions.assertEquals("YWJjZA==", result);
        }
    }

    @DisplayName("ru characters")
    @Nested
    class ruCharacters{

        private String src = "абвг";

        @Test
        @DisplayName("encode string from default String.getBytes")
        void encodeStringFromDefaultStringGetBytes() throws UnsupportedEncodingException {
            String result = base.encode(src);
            Assertions.assertEquals("0LDQsdCy0LM=", result);
        }

        @Test
        @DisplayName("encode utf16 string as base64")
        void encodeUtf16StringAsBase64() throws UnsupportedEncodingException {
            String result = base.encode(src, "UTF-16");
            Assertions.assertEquals("/v8EMAQxBDIEMw==", result);
        }

        @Test
        @DisplayName("encode us_ascii as base64")
        void encodeUsAsciiAsBase64() throws UnsupportedEncodingException {
            String result = base.encode(src, "US-ASCII");
            Assertions.assertEquals("Pz8/Pw==", result);
        }

        @Test
        @DisplayName("encode utf8 string as base64")
        void encodeUtf8StringAsBase64() throws UnsupportedEncodingException {
            String result = base.encode(src, "UTF-8");
            Assertions.assertEquals("0LDQsdCy0LM=", result);
        }
    }

}
