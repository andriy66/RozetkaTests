package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class ListOfProductsScreen : BaseScreen() {
    val filterButton = findById("section_ll_filter")
    val sortButton = findById("section_ll_sort")

    @Step("Open Product Description")
    fun openProductDescription(productName: String): ProductDescriptionScreen {
        val product = findElementByText(productName)
        product.click()

        return ProductDescriptionScreen()
    }
}