package com.zmr.LearningFiles.OwnTests.MyJavaTests.javaTests;

import java.util.ArrayList;
import java.util.List;

public class MyTest28 {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item("1"));
        // list.add(new Item(0, "2"));
        // list.add(new Item(0, "4"));
        // list.add(new Item(4, "5"));
        // list.add(new Item(5, "6"));

        boolean val = list.stream().anyMatch(item -> item.getValue() == 1);

        // boolean val = list.stream().anyMatch(item -> {
        //     if ("1".equals(item.getValue())) {
        //         return true;
        //     }
        //     return false;
        // });
        System.out.println(val);
    }

    static class Item {
        private int value;

        private String name;

        public Item() {
        }

        public Item(String name) {
            this.name = name;
        }

        public Item(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
