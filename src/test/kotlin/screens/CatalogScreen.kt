package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step
import screens.categories.GamerSubCategoryScreen
import screens.categories.LaptopsSubCategoryScreen
import screens.categories.PhonesSubcategoryScreen
import screens.categories.ZooProductsSubCategoryScreen

class CatalogScreen : BaseScreenWithMenuComponents() {
    private val categoryLaptopsAndComputersButton = findElementByText("Ноутбуки та комп’ютери")
    private val categoryZooProductsButton = findElementByText("Зоотовари")
    private val categoryGamerButton = findElementByText("Товари для геймерів")
    private val categoryPhonesButton = findElementByText("Смартфони, ТВ і електроніка")

    @Step("Open Category 'Товари для геймерів'")
    fun openCategoryGamersProducts(): GamerSubCategoryScreen {
        log.info("Open Category 'Товари для геймерів'")
        categoryGamerButton.click()

        return GamerSubCategoryScreen()
    }

    @Step("Open Category 'Ноутбуки та комп'ютери'")
    fun openCategoryLaptopsAndComputersSubCategoryScreen(): LaptopsSubCategoryScreen {
        log.info("Open Category 'Ноутбуки та комп'ютери'")
        categoryLaptopsAndComputersButton.click()

        return LaptopsSubCategoryScreen()
    }

    @Step("Open Category 'Зоотовари'")
    fun openZooProductSubCategoryScreen(): ZooProductsSubCategoryScreen {
        log.info("Open Category 'Зоотовари'")
        categoryZooProductsButton.click()

        return ZooProductsSubCategoryScreen()
    }

    @Step("Open Category 'Смартфони, ТВ і електроніка'")
    fun openPhonesSubCategoryScreen(): PhonesSubcategoryScreen {
        log.info("Open Category 'Смартфони, ТВ і електроніка'")
        loaderIcon.shouldBe(Condition.not(Condition.visible))
        categoryPhonesButton.click()

        return PhonesSubcategoryScreen()
    }
}