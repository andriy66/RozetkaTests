package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class ListOfComparisonScreen : BaseScreen() {
    private val comparisonListButton = findById("item_comparisons_tv_title")
    private val menuOfListButton = findById("item_comparisons_iv_menu")
    val message = findById("empty_base_tv_title")

    @Step("Open comparison list")
    fun openComparisonList(): ComparisonScreen {
        log.info("Open comparison list")
        comparisonListButton.click()

        return ComparisonScreen()
    }

    @Step("Delete comparison list")
    fun deleteComparisonList(): ListOfComparisonScreen {
        log.info("Delete comparison list")
        if (!message.isDisplayed) {
            menuOfListButton.click()
            val deleteListOption = findElementByText("Видалити список")
            deleteListOption.click()
        } else {
            log.info("The comparison list is empty")
        }

        return this
    }
}