package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Impl;

import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Complex;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.ComplexType;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Interface.ComplexImpl;

/**
 * <p> 直角坐标实现 </p>
 */
public class ComplexImplCartesianImpl implements ComplexImpl {
    private double x;
    private double y;

    public ComplexImplCartesianImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double real() {
        return x;
    }

    @Override
    public double imaginary() {
        return y;
    }

    @Override
    public double modulus() {
        return StrictMath.hypot(x, y);
    }

    @Override
    public double argument() {
        return StrictMath.atan2(y, x);
    }

    @Override
    public Complex add(Complex other) {
        return new Complex(x + other.real(), y + other.imaginary(), ComplexType.CARTESIAN);
    }

    @Override
    public Complex multiply(Complex other) {
        return new Complex(x * other.real() - y * other.imaginary(),
                x * other.imaginary() + y * other.real(), ComplexType.CARTESIAN);
    }
}
