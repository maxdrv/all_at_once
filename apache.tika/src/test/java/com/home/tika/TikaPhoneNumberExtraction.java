package com.home.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.CleanPhoneText;
import org.apache.tika.sax.PhoneExtractingContentHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Спорный способ извлекать номера телефонов
 * Хотя внутренние регулярки стоит испытать
 */
class TikaPhoneNumberExtraction {

    private static Parser AUTO_DETECT_PARSER = new AutoDetectParser();

    @Test
    @DisplayName("extract phone number from text with tika")
    void extractPhoneNumberFromTextWithTika() throws IOException, TikaException, SAXException {
        Metadata metadata = new Metadata();
        // The PhoneExtractingContentHandler will examine any characters for phone numbers before passing them
        // to the underlying Handler.
        PhoneExtractingContentHandler handler = new PhoneExtractingContentHandler(new BodyContentHandler(), metadata);
        try (InputStream stream = TikaPhoneNumberExtraction.class.getResourceAsStream("/test-documents/testPhoneNumberExtractor.txt")) {
            AUTO_DETECT_PARSER.parse(stream, handler, metadata, new ParseContext());
        }
        String[] phoneNumbers = metadata.getValues("phonenumbers");
        assertEquals("9498888888", phoneNumbers[0]);
    }

    @Test
    @DisplayName("CleanPhoneTest usage")
    void cleanPhoneTestUsage(){
        System.out.println(CleanPhoneText.extractPhoneNumbers("test with phone 8-888-889"));


    }

}
