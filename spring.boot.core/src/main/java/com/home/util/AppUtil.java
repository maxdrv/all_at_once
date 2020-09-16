package com.home.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Component
public class AppUtil {

    public char[] range(char start, char end) {
        int capacity = Math.abs(end - start) + 1;
        char[] buffer = new char[capacity];
        if (start > end) {
            for (int i = start, j = 0; i >= end; i--, j++) {
                buffer[j] = (char) i;
            }
        } else {
            for (int i = start, j = 0; i <= end; i++, j++) {
                buffer[j] = (char) i;
            }
        }
        return buffer;
    }

    public void printRange(char start, char end) {
        printRange(range(start, end));
    }

    public void printRange(char[] chars) {
        StringBuffer sb = new StringBuffer();
        for (char ch : chars) {
            sb.append(ch).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public String encode(String src) throws UnsupportedEncodingException {
        return encode(src, "UTF-8");
    }

    public String encode(String src, String encoding) throws UnsupportedEncodingException {
        byte[] srcAsBytes = Base64.getEncoder().encode(src.getBytes(encoding));
        return new String(srcAsBytes);
    }

}
