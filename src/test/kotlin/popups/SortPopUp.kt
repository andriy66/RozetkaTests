package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.ListOfProductsScreen

class SortPopUp : BaseScreen() {
    private val fromCheapToExpensiveButton = findById("section_tv_filter")
    private val fromExpensiveToCheap = findElementByText("від дорогих до дешевих")

    @Step("Choose option from cheap to expensive")
    fun chooseFromCheapToExpensive(): ListOfProductsScreen {
        log.info("Choose option from cheap to expensive")
        fromCheapToExpensiveButton.click()

        return ListOfProductsScreen()
    }

    @Step("Choose option from expensive to cheap")
    fun chooseFromExpensiveToCheap(): ListOfProductsScreen {
        log.info("Choose option from expensive to cheap")
        fromExpensiveToCheap.click()

        return ListOfProductsScreen()
    }
}