package com.zmr.LearningFiles.EffectiveJavaDemos.InterfaceAbstractClass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // public final double AVOGADROS_NUMBER = 6.022_140_857e23;
    // public final double BOLTZMANN_CONST = 1.380_648_52e-23;
    // public final double ELECTRON_MASS = 9.109_383_56e-31;

    public static <T> void main(Class<T> clz) {
        String str = "{'name': [1,2,3,4,5]}";
        T instance = JSON.parseObject(str, new TypeReference<T>() {});
    }


    // public static void main(String[] args) {
    //     // FileOperation fileOperation = new TxtFileOperation();
    //     // fileOperation.readFile("example.txt");
    //     // fileOperation.writeFile("example.txt", "Hello, World!");
    //     //
    //     // Main main = new Main();
    //     // System.out.println(main.AVOGADROS_NUMBER);
    //     // System.out.println(main.BOLTZMANN_CONST);
    //     // System.out.println(main.ELECTRON_MASS);
    //
    //     List<String> strings = new ArrayList<>();
    //     strings.add("1");
    //     strings.add("2");
    //
    //     String[] array = strings.toArray(new String[0]);
    //     for (String element : array) {
    //         System.out.println(element);
    //     }
    // }
}
