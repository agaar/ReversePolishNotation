package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Calculator {

    public String calculate(String input) throws IllegalArgumentException{

        Stack<String> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String next = st.nextToken();

            if(isNumeric(next)) {
                stack.push(next);
            }
            else if (next.equals("+")) {
                BigDecimal num1 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal num2 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal result = num1.add(num2);

                stack.push(String.valueOf(result));
            }
            else if (next.equals("-")) {
                BigDecimal num1 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal num2 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal result = num2.subtract(num1);

                stack.push(String.valueOf(result));
            }
            else if (next.equals("*")) {
                BigDecimal num1 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal num2 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal result = num2.multiply(num1);

                stack.push(String.valueOf(result));
            }
            else if (next.equals("/")) {
                BigDecimal num1 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));
                BigDecimal num2 = BigDecimal.valueOf(Integer.parseInt(stack.pop()));

                try {
                    BigDecimal result = num2.divide(num1);
                    stack.push(String.valueOf(result));
                }catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Divide by 0");
                }
            }
            else{
                throw new IllegalArgumentException("Input invalid");
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
