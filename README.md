# tproject
Тесты написаны на groovy, с использованием фреймворков:
 - [Selenide](https://github.com/selenide/selenide)
 - [TestNg](https://testng.org)
 - [Allure](https://github.com/allure-framework/allure2) 

##Запуск тестов
Запуск тестов осуществляется мавеном

    mvn clean test
 
##Получение отчетов

Для отчетов используется Allure 2.0, чтобы построить отчеты нужно запсутить после тестов:

    mvn allure:report
    
Отчет появится в папке, по адресу: `target\site\allure-maven-plugin\index.html`