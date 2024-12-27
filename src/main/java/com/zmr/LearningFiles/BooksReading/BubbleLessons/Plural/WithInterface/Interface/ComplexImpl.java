package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Interface;

import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Complex;

public interface ComplexImpl {
    public double real();

    public double imaginary();

    public double modulus();

    public double argument();

    public Complex add(Complex other);

    public Complex multiply(Complex other);
}
