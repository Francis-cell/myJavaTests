package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.CartesianCoordinates;

/**
 * <p> 直角坐标实现复数类 </p>
 */
public final class Complex {
    private double x;
    private double y;

    public Complex (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double real() {
        return x;
    }

    public double imaginary() {
        return y;
    }

    public double modulus() {
        return StrictMath.hypot(x, y);
    }

    public double argument() {
        return StrictMath.atan2(y, x);
    }

    public Complex add(Complex other) {
        return new Complex(x + other.x, y + other.y);
    }

    public Complex multiply(Complex other) {
        return new Complex(x * other.x - y * other.y, x * other.y + y * other.x);
    }
}
