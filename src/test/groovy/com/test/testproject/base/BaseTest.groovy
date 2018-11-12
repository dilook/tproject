package com.test.testproject.base

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.logevents.SelenideLogger
import com.test.testproject.pages.Application
import groovy.util.logging.Slf4j
import io.qameta.allure.selenide.AllureSelenide
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeSuite

@Slf4j
class BaseTest {
    def ctx = new Application()

    @BeforeSuite
    void setUpListeners() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide())

        if (!System.getProperty("selenide.browser")) {
            Configuration.browser = WebDriverRunner.CHROME
        }

        log.info("Запуск на браузере " + Configuration.browser)
    }

    @AfterMethod(description = "Clean cookies")
    void cleanUp() {
        log.info("Clean cookies")
        WebDriverRunner.webDriver.manage().deleteAllCookies()
    }
}
