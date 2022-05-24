package screens.categories

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ProductDescriptionScreen

class AdaptorsSubCategoryScreen : BaseScreen() {
    private val secondProductButton = findElementsByCssSelector("android.view.ViewGroup")[0]

    @Step("Open first product Description")
    fun openSecondProductScreen(): ProductDescriptionScreen {
        secondProductButton.click()

        return ProductDescriptionScreen()
    }
}