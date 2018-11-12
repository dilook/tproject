package com.test.testproject

import com.test.testproject.base.BaseTest
import com.test.testproject.utils.StringUtils
import io.qameta.allure.Step
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static com.codeborne.selenide.Condition.*

class PageNumberTest extends BaseTest {

    @DataProvider(name = "pages")
    Object[] pages() {
        return [25, 50, 100]
    }

    @DataProvider(name = "data")
    Object[] data() {
        return [StringUtils.getRandomString(1, 'A'..'Z'),
                StringUtils.getIntString(2),
                ('1'..'3').join(),
                "automated"
        ]
    }

    @Test(description = "Проверка отображения количества страниц", dataProvider = "data")
    void numberPageCheck(String searchString) {
        ctx.open()

        [25, 50, 100].each { page ->
            ctx.main.searchInput.val(searchString)
            ctx.main.pageNumber.selectOptionByValue(page as String)
            ctx.main.searchButton.shouldBe(enabled).click()
            checkRowCount(page)
            ctx.result.back.click()
            checkMainFields()
        }
    }

    @Step("Проверка главной страницы")
    void checkMainFields() {
        ctx.main.pageNumber.shouldNotBe(selected)
        ctx.main.searchInput
                .shouldHave(value(""))
                .shouldHave(attribute("placeholder", "Введите ключевое слово"))
    }

    @Step("Проверка количества результатов для {page} страниц")
    void checkRowCount(int page) {
        (1..2).each { def pageNum ->
            ctx.result.pageNumberTitle.shouldHave(matchesText("Страница $pageNum"))
            ctx.result.resultRows.shouldHaveSize(page)
            ctx.result.forward.shouldBe(exist).click()
        }
    }

}
