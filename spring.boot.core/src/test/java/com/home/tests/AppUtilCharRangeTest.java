package com.home.tests;

import com.home.util.AppUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppUtilCharRangeTest {

    @Autowired
    private AppUtil util;

    @Test
    @DisplayName("start and end of range is the same char")
    void startAndEndOfRangeIsTheSameChar(){
        char ch = 's';
        char[] expected = {ch};
        char[] actual = util.range(ch, ch);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("range returns array of 2 in ascending order then its consecutive characters")
    void rangeReturnsArrayOf2InAscendingOrderThenItsConsecutiveCharacters() {
        char start = '0';
        char end = '1';
        char[] expected = {start, end};
        char[] actual = util.range(start, end);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("range returns array of 2 in descending order then its two consecutive characters but placed in inverse order")
    void rangeReturnsArrayOf2InDescendingOrderThenItsTwoConsecutiveCharactersButPlacedInInverseOrder(){
        char start = '1';
        char end = '0';
        char[] expected = {start, end};
        char[] actual = util.range(start, end);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("demo")
    void demo(){
        char[] expected = {'1', '2', '3', '4', '5'};
        char[] actual = util.range('1', '5');
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("demo inverse")
    void demoInverse(){
        char[] expected = {'5', '4', '3', '2', '1'};
        char[] actual = util.range('5', '1');
        Assertions.assertArrayEquals(expected, actual);
    }

}
