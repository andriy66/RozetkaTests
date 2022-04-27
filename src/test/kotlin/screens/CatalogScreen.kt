package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class CatalogScreen : BaseScreen() {
    val categoryLaptopsAndComputers = findElementByText("Ноутбуки та комп’ютери")

    @Step("Open Category 'Laptops And Computers'")
    fun openCategoryLaptopsAndComputers(): LaptopsSubCategories {
        categoryLaptopsAndComputers.click()

        return LaptopsSubCategories()
    }
}