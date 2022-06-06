package screens.categories

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class GamerSubCategoryScreen : BaseScreen() {
    private val gameConsoles = findElementByText("Ігрові приставки")

    @Step("Open List of Game Consoles")
    fun openGameConsolesListOfProducts(): ListOfProductsScreen {
        log.info("Open List of Game Consoles")
        gameConsoles.click()

        return ListOfProductsScreen()
    }
}