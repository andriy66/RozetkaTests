package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class LaptopsSubCategories : BaseScreen() {
    val monitorsButton = findElementByText("Монітори")

    @Step("Open List of Products")
    fun openListOfProducts(): ListOfProductsScreen {
        monitorsButton.click()

        return ListOfProductsScreen()
    }
}