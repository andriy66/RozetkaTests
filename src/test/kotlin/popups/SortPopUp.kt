package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class SortPopUp : BaseScreen() {
    val fromCheapToExpensiveButton = findById("section_tv_filter")
    val fromExpensiveToCheap = findElementByText("від дорогих до дешевих")

    @Step("Choose option from cheap to expensive")
    fun chooseFromCheapToExpensive(): ListOfProductsScreen {
        fromCheapToExpensiveButton.click()

        return ListOfProductsScreen()
    }

    @Step("Choose option from expensive to cheap")
    fun chooseFromExpensiveToCheap(): ListOfProductsScreen {
        fromExpensiveToCheap.click()

        return ListOfProductsScreen()
    }
}