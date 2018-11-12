package com.test.testproject.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Condition.exactText
import static com.codeborne.selenide.Selectors.byText
import static com.codeborne.selenide.Selenide.$

class ResultPage {
    SelenideElement back = $(byText("Вернуться назад"))
    SelenideElement forward = $("[name=page]")
    ElementsCollection resultRows = $("tbody").$$("tr")
    SelenideElement pageNumberTitle = $("h5 strong")

    ResultPage() {
        $(".text-muted").shouldHave(exactText("Ну что же, приступим."))
    }
}
