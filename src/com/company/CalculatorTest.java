package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals("5", calc.calculate("2 3 +"));
    }

    @Test
    public void testSubtract() {
        assertEquals("4", calc.calculate("7 3 -"));
    }

    @Test
    public void testMultiply() {
        assertEquals("21", calc.calculate("7 3 *"));
    }

    @Test
    public void testDivide() {
        assertEquals("4", calc.calculate("12 3 /"));
    }

    @Test
    public void invalidInput() {
        try{
            calc.calculate("alamakota");
        }catch(IllegalArgumentException e) {
        }
    }

    @Test
    public void divideByZero() {
        try{
            calc.calculate("9 0 /");
        }catch(IllegalArgumentException e) {
        }
    }

    @Test
    public void testOperation() {
        assertEquals("27", calc.calculate("13 7 + 2 / 14 3 - 4 * + 2 /"));
    }
}