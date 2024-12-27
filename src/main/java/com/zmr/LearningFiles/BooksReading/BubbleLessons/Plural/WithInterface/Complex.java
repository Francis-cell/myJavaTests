package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface;

import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Impl.ComplexImplCartesianImpl;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Impl.ComplexImplPolarImpl;
import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.Interface.ComplexImpl;

/**
 * <p> 使用桥梁模式实现复数 </p>
 */
public final class Complex {
    private ComplexImpl complex;

    public Complex(double x, double y, ComplexType type) {
        switch (type) {
            // 极坐标实现
            case POLAR:
                complex = new ComplexImplPolarImpl(x, y);
                break;
            // 直角坐标实现
            case CARTESIAN:
                complex = new ComplexImplCartesianImpl(x, y);
                break;
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
    }

    public double real() {
        return complex.real();
    }

    public double imaginary() {
        return complex.imaginary();
    }

    public double modulus() {
        return complex.modulus();
    }

    public double argument() {
        return complex.argument();
    }

    public Complex add(Complex other) {
        return complex.add(other);
    }

    public Complex multiply(Complex other) {
        return complex.multiply(other);
    }
}
