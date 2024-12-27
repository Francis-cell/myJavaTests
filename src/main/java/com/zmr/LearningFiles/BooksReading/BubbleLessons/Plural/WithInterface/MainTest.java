package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface;

public class MainTest {
    public static void main(String[] args) {
        // 直角坐标实现
        Complex c1 = new Complex(3, 4, ComplexType.CARTESIAN);
        // 极坐标实现
        Complex c2 = new Complex(1, Math.PI / 4, ComplexType.POLAR);

        System.out.println("C1: " + c1.real() + " + " + c1.imaginary() + "i");
        System.out.println("C2: " + c2.real() + " + " + c2.imaginary() + "i");

        Complex sum = c1.add(c2);
        System.out.println("Sum: " + sum.real() + " + " + sum.imaginary() + "i");

        Complex product = c1.multiply(c2);
        System.out.println("Product: " + product.real() + " + " + product.imaginary() + "i");
    }
}
