package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreenWithMenuComponents
import io.qameta.allure.Step
import popups.SortPopUp

open class ListOfProductsScreen : BaseScreenWithMenuComponents() {
    private val firstProductButton = findElementsByCssSelector("android.widget.TextView")[8]
    private val secondProductButton = findElementsByCssSelector("android.view.ViewGroup")[0]
    val filterButton = findById("section_ll_filter")
    val sortButton = findById("section_ll_sort")

    @Step("Open second product Description")
    fun openSecondProductScreen(): ProductDescriptionScreen {
        log.info("Open second product Description")
        secondProductButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Open first product Description")
    fun openFirstProductScreen(): ProductDescriptionScreen {
        log.info("Open first product Description")
        firstProductButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Open Product Description")
    fun openProductDescription(productName: String): ProductDescriptionScreen {
        log.info("Open Product Description")
        val product = findElementByText(productName).should(Condition.visible)
        if (!product.isDisplayed) {
            log.error("The product isn`t exist")
            throw Exception("The product isn`t exist")
        }
        product.click()

        return ProductDescriptionScreen()
    }

    @Step("Open Sort Pop Up")
    fun openSortPopUp(): SortPopUp {
        log.info("Open Sort Pop Up")
        sortButton.click()

        return SortPopUp()
    }
}