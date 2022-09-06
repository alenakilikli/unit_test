package org.example;

import lombok.SneakyThrows;
import org.example.file_pakage.FileProcessor;
import org.example.file_pakage.TestAnnotations;

public class Main {
    private final static String className = DemoTestClass.class.getName();

    @SneakyThrows
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();

        testRunner.run(className);
         testRunner.run("test005", className);

//
//        TestAnnotations testClass = new TestAnnotations();
//        FileProcessor fileProcessor = new FileProcessor();
//        String className = testClass.getClass().getCanonicalName();
//
//
//        fileProcessor.fileReader(testClass);





    }
}