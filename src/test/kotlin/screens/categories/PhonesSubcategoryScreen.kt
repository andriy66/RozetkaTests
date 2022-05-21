package screens.categories

import com.codeborne.selenide.Condition
import helpers.BaseScreen
import io.qameta.allure.Step

class PhonesSubcategoryScreen : BaseScreen() {
    private val categoryAdapterLayout = findElementByText("Смартфони, ТВ і електроніка")
    private val categoryAdaptorsButton = findElementByText("Кабелі та адаптери")

    @Step("Open sub category 'Кабелі та адаптери'")
    fun openSubCategoryAdaptors(): AdaptorsSubCategoryScreen {
        categoryAdaptorsButton.click()

        return AdaptorsSubCategoryScreen()
    }

    @Step("Phones SubCategory Screen was opened")
    fun phonesSubcategoryScreenOpened(): Boolean {
        categoryAdapterLayout.shouldBe(Condition.visible)

        return categoryAdapterLayout.isDisplayed
    }
}