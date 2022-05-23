package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class ComparisonScreen : BaseScreen() {
    private val differenceButton = findById("comparison_tv_diff_title")
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")

    @Step("Click difference button")
    fun clickDifference() {
        differenceButton.click()
    }

    @Step("Is proper displayed")
    fun isProperDisplayed(prop: String): Boolean {
        val prop = findElementByText(prop)

        return prop.isDisplayed
    }

    @Step("Get back")
    fun getBack(): ListOfComparisonScreen {
        getBackButton.click()

        return ListOfComparisonScreen()
    }
}