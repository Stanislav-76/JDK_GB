/*
 * Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 * sum(), multiply(), divide(), substract(). Параметры этих методов - два числа разного типа,
 * над которыми должна быть произведена операция.
 */
package Seminar3.Calc;

public class Calculator {

    public static <T extends Number, E extends Number> Double sum (T first, E second) {
        return first.doubleValue() + second.doubleValue();
    }

    public static <T extends Number, E extends Number> Double multiply (T first, E second) {
        return first.doubleValue() * second.doubleValue();
    }
    
    public static <T extends Number, E extends Number> Double divide (T first, E second) {
        return first.doubleValue() / second.doubleValue();
    }

    public static <T extends Number, E extends Number> Double substract (T first, E second) {
        return first.doubleValue() - second.doubleValue();
    }

    
}

class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(123, 5L));
        System.out.println(Calculator.multiply(123, 5L));
        System.out.println(Calculator.divide(123, 5L));
        System.out.println(Calculator.substract(123, 5L));
    }
    
}