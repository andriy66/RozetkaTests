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
        secondProductButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Open first product Description")
    fun openFirstProductScreen(): ProductDescriptionScreen {
        firstProductButton.click()

        return ProductDescriptionScreen()
    }

    @Step("Open Product Description")
    fun openProductDescription(productName: String): ProductDescriptionScreen {
        val product = findElementByText(productName).should(Condition.visible)
        if (!product.isDisplayed) {
            throw Exception("The product isn`t exist")
        }
        product.click()

        return ProductDescriptionScreen()
    }

    @Step("Open Sort Pop Up")
    fun openSortPopUp(): SortPopUp {
        sortButton.click()

        return SortPopUp()
    }
}