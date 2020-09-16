package com.home.encoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class WriteDifferentEncodingsToFile {

    private static final Logger LOG = LoggerFactory.getLogger(WriteDifferentEncodingsToFile.class);
    private static final String DEFAULT = "demo/encoding";

    @Test
    @DisplayName("write utf-16 bytes to file")
    void writeUtf16BytesToFile() throws IOException {
        String rawString = "абвгд";
//        String rawString = "abcd";
        byte[] asBytes = rawString.getBytes(StandardCharsets.UTF_16);
        printHex(asBytes);
        write(asBytes, "UTF-16");
    }

    public void write(byte[] bytes, String encoding) throws IOException {
        File file = new File(DEFAULT + "_" + encoding + ".txt");
        file.createNewFile();
        FileOutputStream os = new FileOutputStream(file);
        os.write(bytes);
    }

    private void printHex(byte[] bytes) {
        for (byte b : bytes) {
            String st = String.format("%02X", b);
            System.out.print(st + " ");
        }
    }

}
