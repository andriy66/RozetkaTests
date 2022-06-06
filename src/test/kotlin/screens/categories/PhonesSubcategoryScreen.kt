package screens.categories

import com.codeborne.selenide.Condition
import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class PhonesSubcategoryScreen : BaseScreen() {
    private val categoryAdapterLayout = findElementByText("Смартфони, ТВ і електроніка")
    private val categoryAdaptorsButton = findElementByText("Кабелі та адаптери")

    @Step("Open sub category 'Кабелі та адаптери'")
    fun openSubCategoryAdaptors(): ListOfProductsScreen {
        log.info("Open sub category 'Кабелі та адаптери'")
        categoryAdaptorsButton.click()

        return ListOfProductsScreen()
    }

    @Step("Phones SubCategory Screen was opened")
    fun phonesSubcategoryScreenOpened(): Boolean {
        categoryAdapterLayout.shouldBe(Condition.visible)

        return categoryAdapterLayout.isDisplayed
    }
}