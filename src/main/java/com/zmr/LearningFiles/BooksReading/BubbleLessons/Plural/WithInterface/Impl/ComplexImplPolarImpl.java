package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Impl;

import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Complex;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.ComplexType;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Interface.ComplexImpl;

/**
 * <p> 极坐标实现 </p>
 */
public class ComplexImplPolarImpl implements ComplexImpl {
    private double r;
    private double theta;

    public ComplexImplPolarImpl(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    @Override
    public double real() {
        return r * StrictMath.cos(theta);
    }

    @Override
    public double imaginary() {
        return r * StrictMath.sin(theta);
    }

    @Override
    public double modulus() {
        return r;
    }

    @Override
    public double argument() {
        return theta;
    }

    @Override
    public Complex add(Complex other) {
        double real = this.real() + other.real();
        double imaginary = this.imaginary() + other.imaginary();
        return new Complex(real, imaginary, ComplexType.POLAR);
    }

    @Override
    public Complex multiply(Complex other) {
        return new Complex(r * other.modulus(), theta + other.argument(), ComplexType.POLAR);
    }
}
