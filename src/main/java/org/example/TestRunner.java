package org.example;


import lombok.SneakyThrows;
import org.example.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class TestRunner {

    public static boolean isTestMethod(Annotation annotation, Method method) {
        return method.isAnnotationPresent(annotation.annotationType())
                && Modifier.isPublic(method.getModifiers())
                && method.getReturnType().equals(void.class)
                && method.getParameterCount() == 0
                && !Modifier.isStatic(method.getModifiers());
    }

    @SneakyThrows
    public void run(String testName, String testClassName) {

        Object instance = Class.forName(testClassName).getDeclaredConstructors()[0].newInstance();
        Method method = instance.getClass().getDeclaredMethod(testName);
        displayName(method);
        Annotation annotation = method.getDeclaredAnnotations()[0];

        if (isTestMethod(annotation, method)) {

            method.invoke(instance);
        }


    }

    @SneakyThrows
    public void run(String testClassName) {
        Object instance = Class.forName(testClassName).getDeclaredConstructors()[0].newInstance();

        displayName(instance);

        runBeforeAll(instance);

        for (Method method : instance.getClass().getDeclaredMethods()) {

            runBeforeEach(instance);

            if (method.isAnnotationPresent(Test.class) && isTestMethod(method.getAnnotation(Test.class), method)) {
                displayName(method);
                method.invoke(instance);
            }
            runAfterEach(instance);

        }

        runAfterAll(instance);
    }


    private void displayName(Object instance) {

        String info = instance.getClass().getAnnotation(DisplayName.class).getnName();
        System.out.println(info);

    }

    private void runAfterAll(Object instance) {

        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterAll.class)) {
                if (isTestMethod(method.getAnnotation(AfterAll.class), method)) {
                    try {
                        method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void runBeforeAll(Object instance) {

        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeAll.class)) {
                if (isTestMethod(method.getAnnotation(BeforeAll.class), method)) {
                    try {
                        method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void runBeforeEach(Object instance) {

        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeEach.class)) {
                if (isTestMethod(method.getAnnotation(BeforeEach.class), method)) {
                    try {
                        method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    private void runAfterEach(Object instance) {

        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterEach.class)) {
                if (isTestMethod(method.getAnnotation(AfterEach.class), method)) {
                    try {
                        method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}





