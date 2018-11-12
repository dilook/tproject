package com.test.testproject.pages

import com.codeborne.selenide.Selenide
import com.test.testproject.utils.PropertyUtils
import groovy.util.logging.Slf4j

@Slf4j
class Application {
    /**
     * Основной адрес приложения
     */
    static String address = System.getProperty("app.host") ?: PropertyUtils.getProp("app.host")

    /**
     * Метод открытия приложения - главной странцы
     */
    void open() {
        log.info("Открываем $address")
        Selenide.open(address)
    }

    /**
     * Метод обновления страниццы
     */
    void refresh() {
        log.info("Обновлям страничку")
        Selenide.refresh()
    }

    /*Методы получения  пэйджей*/

    MainPage getMain() {
        return new MainPage()
    }

    ResultPage getResult() { return new ResultPage() }

}
