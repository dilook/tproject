# tproject
Тесты написаны на groovy, с использованием фреймворков:
 - [Selenide](https://github.com/selenide/selenide)
 - [TestNg](https://testng.org)
 - [Allure](https://github.com/allure-framework/allure2) 

##Требования
Тесты написаны под java 1.8 (работоспособность на версиях java 1.8+ не проверялась). 
Для успешного запуска необходимо наличие установленного браузера последней версии: Google Chrome 70.x, Firefox 63.x

##Запуск тестов

Перед запуском, необходимо указать адрес тестируемого приложения в файле `setup.properties`, свойство `app.host`:

    app.host = "https://www.google.com/"

Запуск тестов осуществляется мавеном

    mvn clean test

По умолчанию запуск происходит на брааузере Google Chrome, чтобы сменить браузер на Firefox необходимо при запуске указать параметр:
 `-Dselenide.browser=firefox` 

##Получение отчетов

Для отчетов используется Allure 2.0, чтобы построить отчеты нужно запсутить после тестов:

    mvn allure:report
    
Отчет появится в папке, по адресу: `target\site\allure-maven-plugin\index.html`