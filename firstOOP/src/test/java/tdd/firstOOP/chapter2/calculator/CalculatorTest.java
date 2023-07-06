package tdd.firstOOP.chapter2.calculator;

import org.junit.jupiter.api.Test;
import tdd.firstOOP.chap02.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void plus(){
        int result = Calculator.plus(1,2);
        assertEquals(3, result);
        assertEquals(5, Calculator.plus(4, 1));
    }


}
