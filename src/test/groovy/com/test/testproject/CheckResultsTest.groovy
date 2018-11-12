package com.test.testproject

import com.test.testproject.base.BaseTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static com.codeborne.selenide.Condition.text

class CheckResultsTest extends BaseTest {
    @DataProvider(name = "positiveData")
    Object[] positiveSearchData() {
        return ["Java", "123", "BUFFER"]
    }

    @Test(description = "Проверка вхождения искомого слова в результатах выдачи", dataProvider = "positiveData")
    void searchSuccessful(String searchText) {
        ctx.open()
        ctx.main.pageNumber.selectOptionByValue("25")
        ctx.main.searchInput.val(searchText)
        ctx.main.searchButton.click()

        ctx.result.resultRows.every { row ->
            row.shouldHave(text(searchText))
        }
    }
}

