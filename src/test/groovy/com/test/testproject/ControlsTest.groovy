package com.test.testproject

import com.test.testproject.base.BaseTest
import io.qameta.allure.Step
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static com.codeborne.selenide.Condition.cssClass
import static com.codeborne.selenide.Condition.matchText

class ControlsTest extends BaseTest {

    @DataProvider(name = "negativeData")
    Object[][] negativeData() {
        //todo т.к. нет ни ТЗ, ни спеки, ожидаемые сообщения выбраны исходя тз логики и опыта
        return [["    ", "Запрос не может состоять только из пробелов"],
                ["1", "Запрос должен состоять из более чем трех символов"],
                ["{ [ ( ~ ! @ # \$ % ^ & * ` | \\ : ” ; ’ < > ? , . / * - + ) ] }", ""]
        ]
    }

    @Test(description = "Проверка на ввод обязательных параметров")
    void requiredParams() {
        ctx.open()
        ctx.main.searchButton.click()
        checkAlert("Не переданы обязательные параметры")

        ctx.open()
        ctx.main.searchInput.val("123")
        ctx.main.searchButton.click()
        checkAlert("Не переданы обязательные параметры")

        ctx.open()
        ctx.main.pageNumber.selectOptionByValue("25")
        ctx.main.searchButton.click()
        checkAlert("Не переданы обязательные параметры")
    }

    @Test(description = "Проверка ввода негативных параметров", dataProvider = "negativeData")
    void negativeParams(String inputString, String expectedMessage) {
        ctx.open()
        ctx.main.searchInput.val(inputString)
        ctx.main.searchButton.click()
        checkAlert(expectedMessage)
    }


    @Step("Проверка срабатывания контроля {text}")
    void checkAlert(String text) {
        ctx.main.alert
                .shouldHave(matchText(text))
                .shouldHave(cssClass("alert-danger"))
                .shouldHave(cssClass("alert"))
    }
}
