package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.PolarCoordinates;

/**
 * <p> 极坐标实现复数类 </p>
 */
public final class Complex {
    private double r;
    private double theta;

    public Complex(double x, double y) {
        r = StrictMath.hypot(x, y);
        theta = StrictMath.atan2(y, x);
    }

    public double real() {
        return r * StrictMath.cos(theta);
    }

    public double imaginary() {
        return r * StrictMath.sin(theta);
    }

    public double modulus() {
        return r;
    }

    public double argument() {
        return theta;
    }

    public Complex add(Complex other) {
        return new Complex(r * StrictMath.cos(theta) + other.r * StrictMath.cos(other.theta),
                r + StrictMath.sin(theta) + other.r * StrictMath.sin(other.theta));
    }

    public Complex multiply(Complex other) {
        Complex product = new Complex(0, 0);
        product.r = r * other.r;
        product.theta = theta + other.theta;
        return product;
    }
}
