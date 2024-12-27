package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithPimpl;

import com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.WithInterface.ComplexType;

public class Complex {
    private ComplexImpl impl; // Pimpl: 指向具体实现的指针（引用）

    public Complex(double a, double b, ComplexType type) {
        switch (type) {
            case CARTESIAN:
                impl = new ComplexImplCartesianImpl(a, b);
                break;
            case POLAR:
                impl = new ComplexImplPolarImpl(a, b);
                break;
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
    }

    public double real() {
        return impl.real();
    }

    public double imaginary() {
        return impl.imaginary();
    }

    public double modulus() {
        return impl.modulus();
    }

    public double argument() {
        return impl.argument();
    }

    public Complex add(Complex other) {
        return new Complex(impl.add(other.impl));
    }

    public Complex multiply(Complex other) {
        return new Complex(impl.multiply(other.impl));
    }

    // Private constructor for internal use
    private Complex(ComplexImpl impl) {
        this.impl = impl;
    }

    // 内部实现类接口（隐藏外部访问）
    private interface ComplexImpl {
        double real();

        double imaginary();

        double modulus();

        double argument();

        ComplexImpl add(ComplexImpl other);

        ComplexImpl multiply(ComplexImpl other);
    }

    // 直角坐标实现
    private static class ComplexImplCartesianImpl implements ComplexImpl {
        private double x, y;

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
        public ComplexImpl add(ComplexImpl other) {
            return new ComplexImplCartesianImpl(x + other.real(), y + other.imaginary());
        }

        @Override
        public ComplexImpl multiply(ComplexImpl other) {
            return new ComplexImplCartesianImpl(
                    x * other.real() - y * other.imaginary(),
                    x * other.imaginary() + y * other.real()
            );
        }
    }

    // 极坐标实现
    private static class ComplexImplPolarImpl implements ComplexImpl {
        private double r, theta;

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
        public ComplexImpl add(ComplexImpl other) {
            double newReal = this.real() + other.real();
            double newImaginary = this.imaginary() + other.imaginary();
            return new ComplexImplCartesianImpl(newReal, newImaginary); // 转为直角坐标处理
        }

        @Override
        public ComplexImpl multiply(ComplexImpl other) {
            double newR = this.r * other.modulus();
            double newTheta = this.theta + other.argument();
            return new ComplexImplPolarImpl(newR, newTheta);
        }
    }
}
