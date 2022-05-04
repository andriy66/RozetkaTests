package screens

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.categories.GamerSubCategoryScreen
import screens.categories.LaptopsSubCategoryScreen
import screens.categories.ZooProductsSubCategoryScreen

class CatalogScreen : BaseScreen() {
    private val categoryLaptopsAndComputersButton = findElementByText("Ноутбуки та комп’ютери")
    private val categoryZooProductsButton = findElementByText("Зоотовари")
    private val categoryGamerButton = findElementByText("Товари для геймерів")

    @Step("Open Category 'Товари для геймерів'")
    fun openCategoryGamersProducts(): GamerSubCategoryScreen {
        categoryGamerButton.click()

        return GamerSubCategoryScreen()
    }

    @Step("Open Category 'Ноутбуки та комп'ютери'")
    fun openCategoryLaptopsAndComputersSubCategoryScreen(): LaptopsSubCategoryScreen {
        categoryLaptopsAndComputersButton.click()

        return LaptopsSubCategoryScreen()
    }

    @Step("Open Category 'Зоотовари'")
    fun openZooProductSubCategoryScreen(): ZooProductsSubCategoryScreen {
        categoryZooProductsButton.click()

        return ZooProductsSubCategoryScreen()
    }
}