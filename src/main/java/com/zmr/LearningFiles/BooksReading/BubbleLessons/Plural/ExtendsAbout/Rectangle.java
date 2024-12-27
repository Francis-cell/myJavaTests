package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.ExtendsAbout;

/**
 * <p> 矩形 </p>
 */
public class Rectangle {
    private double width;

    private double height;

    public Rectangle(double width, double height) {
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}
