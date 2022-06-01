package screens.categories

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class LaptopsSubCategoryScreen : BaseScreen() {
    val monitorsButton = findElementByText("Монітори")

    @Step("Open List of Products")
    fun openListOfProducts(): ListOfProductsScreen {
        log.info("Open List of Products")
        monitorsButton.click()

        return ListOfProductsScreen()
    }
}