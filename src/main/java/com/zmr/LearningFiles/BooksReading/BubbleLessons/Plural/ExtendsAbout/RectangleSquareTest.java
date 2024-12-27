package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.ExtendsAbout;

public class RectangleSquareTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 6);
        assert (r1.getArea() == 30);

        Rectangle r2 = new Square(5);
        assert (r2.getArea() == 25);

        test(r1);
        test(r2);
    }

    static void test(Rectangle r) {
        r.setWidth(3);
        assert (r.getWidth() == 3);
        r.setHeight(4);
        assert (r.getHeight() == 4);
        assert r.getArea() == 12 : "r's area is not 12.";
    }
}
