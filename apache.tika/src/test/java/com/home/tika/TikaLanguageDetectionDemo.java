package com.home.tika;

import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Для опознания языка следует использовать класс
 * LanguageDetector
 * Например его имлементация OptimaizeLangDetector, ей не требуется использовать rest api и интернет
 * <groupId>org.apache.tika</groupId>
 * <artifactId>tika-langdetect</artifactId>
 *
 * есть еще две имплементации
 * Lingo24LangDetector - для нее требуется соединение с интернетом и получение ключа
 * TextLangDetector - для нее требуется развернуть в локальной сети сервис https://github.com/trevorlewis/TextREST.jl
 */
class TikaLanguageDetectionDemo {

    @Test
    @DisplayName("detection of english text with default lang models")
    void detectionOfEnglishText() throws IOException {
        LanguageDetector detector = new OptimaizeLangDetector();
        detector.loadModels();
        LanguageResult result = detector.detect("text in english");

        Assertions.assertAll(
                () -> assertEquals("en", result.getLanguage()),
                () -> assertEquals("HIGH", result.getConfidence().toString())
        );
    }

    @Test
    @DisplayName("detection of english text with three lang models")
    void detectionOfEnglishTextWithThreeLangModels() throws IOException {
        Set<String> langs = new HashSet<>();
        langs.add("ru");
        langs.add("en");
        langs.add("de");
        LanguageDetector detector = new OptimaizeLangDetector();
        detector.loadModels(langs);

        LanguageResult result = detector.detect("text in english");
        Assertions.assertAll(
                () -> assertEquals("en", result.getLanguage()),
                () -> assertEquals("HIGH", result.getConfidence().toString())
        );
    }

    @Test
    @DisplayName("then loading all languages tika can not provide solid results on small amount of text")
    void thenLoadingAllLanguagesTikaCanNotProvideSolidResultsOnSmallAmountOfText() throws IOException {
        LanguageDetector detector = new OptimaizeLangDetector();
        detector.loadModels();

        LanguageResult result = detector.detect("слово");
        Assertions.assertAll(
                () -> assertEquals("mk", result.getLanguage()),  // опознано как македонский язык с средней уверенностью
                () -> assertEquals("MEDIUM", result.getConfidence().toString())
        );
    }

    @Test
    @DisplayName("Then loading only two languages tika can provide solid results on small amount of text")
    void thenLoadingOnlyTwoLanguagesTikaCanProvideSolidResultsOnSmallAmountOfText() throws IOException {
        Set<String> langs = new HashSet<>();
        langs.add("ru");
        langs.add("en");
        LanguageDetector detector = new OptimaizeLangDetector();
        detector.loadModels(langs);

        LanguageResult result = detector.detect("слово");
        Assertions.assertAll(
                () -> assertEquals("ru", result.getLanguage()),
                () -> assertEquals("HIGH", result.getConfidence().toString())
        );
    }

    @Test
    @DisplayName("then loading all languages tika can provide solid results on medium amount of text")
    void thenLoadingAllLanguagesTikaCanProvideSolidResultsOnMediumAmountOfText() throws IOException {
        LanguageDetector detector = new OptimaizeLangDetector();
        detector.loadModels();

        LanguageResult result = detector.detect("различные слова русского языка, одно предложение");
        Assertions.assertAll(
                () -> assertEquals("ru", result.getLanguage()),  // опознано как македонский язык с средней уверенностью
                () -> assertEquals("HIGH", result.getConfidence().toString())
        );
    }

}
