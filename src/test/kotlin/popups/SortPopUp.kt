package popups

import io.qameta.allure.Step
import screens.ListOfProductsScreen

class SortPopUp : ListOfProductsScreen() {
    @Step("Choose option from cheap to expensive")
    fun chooseFromCheapToExpensive(): ListOfProductsScreen {
        val fromCheapToExpensiveButton = findById("section_tv_filter")
        fromCheapToExpensiveButton.click()

        return ListOfProductsScreen()
    }

    @Step("Choose option from expensive to cheap")
    fun chooseFromExpensiveToCheap(): ListOfProductsScreen {
        val fromExpensiveToCheap = findElementByText("від дорогих до дешевих")
        fromExpensiveToCheap.click()

        return ListOfProductsScreen()
    }
}