package org.example;

import org.example.annotations.*;

//Рефлексия - это не для обычной разработки, а для создателей библиотек и фреймворков.
// Если ты - фреймворк, то не знаешь почти ничего про тех, кто будет использовать твой фреймворк.
// В обычной жизни, ты бы создала тестовый класс через new UserTest и вызывала бы нужные методы напрямую.
// Тут же - ты не знаешь ни имени класса, ни названия методов, которые нужно вызвать
// Процесс тот же, как если бы ты вызывала напрямую:
//  new UserTest -> newInstance
// userTest.test1() -> найти метод + вызвать его
@DisplayName(getnName = "demoTest")
public class DemoTestClass {
    @BeforeEach
    @DisplayName(getnName = "beforeEach")
    void test001() {
    }

    @BeforeAll
    @DisplayName(getnName = "beforeAll")
    void test002() {
        throw new RuntimeException("I am failTest");
    }

    @AfterEach
    @DisplayName(getnName = "afterEach")
    void test003() {
    }

    @AfterAll
    @DisplayName(getnName = "afterAll")
    void test004() {
    }

    @Test
    @DisplayName(getnName = "failTest")
    void test005() {
        throw new RuntimeException("I am failTest");
    }

    @Test
    @DisplayName(getnName = "normalTest")
    void test006() {
    }


}
