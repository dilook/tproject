package com.test.testproject.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Condition.exactText
import static com.codeborne.selenide.Selenide.$

class MainPage {
    SelenideElement searchInput = $("input#intitle")
    SelenideElement searchButton = $("input.btn")
    SelenideElement showAllReq = $("button.btn-sm")
    SelenideElement pageNumber = $("select#page_number")
    SelenideElement alert = $("[role='alert']")

    MainPage() {
        $(".text-muted").shouldHave(exactText("Быстрый поиск по StackExchange API"))
    }
}
