package com.home.tika;

import org.apache.tika.Tika;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.sax.PhoneExtractingContentHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class FileTypeDetection {

    private Tika tika = new Tika();

    @Test
    void od() throws IOException {
        String test = "тестовая строка";
        InputStream is = new ByteArrayInputStream(test.getBytes(StandardCharsets.UTF_8));
        String result = tika.detect(is);
        Assertions.assertEquals("text/plain", result);
    }

    @Test
    @DisplayName("check if tika capable recognize json")
    void checkIfTikaCapableRecognizeJson() throws IOException {
        String json = "{ 'test': 100, 'test2':'he is the one', 'content': { 'str': 'str', 'num': 1999 } }";
        InputStream is = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        String result = tika.detect(is);
        Assertions.assertEquals("text/plain", result);  // it did not recognize json
    }

}
