package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.ExtendsAbout;

/**
 * <p> 正方形 </p>
 */
public class Square extends Rectangle{
    public Square(double side) {
        super(side, side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
