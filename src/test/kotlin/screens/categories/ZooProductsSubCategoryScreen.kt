package screens.categories

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class ZooProductsSubCategoryScreen : BaseScreen() {
    private val cormButton = findElementByText("Корм")

    @Step("Choose the Sub Category 'Корм'")
    fun chooseTheCormSubCategory(): ListOfProductsScreen {
        log.info("Choose the Sub Category 'Корм'")
        cormButton.click()

        return ListOfProductsScreen()
    }
}