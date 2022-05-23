package popups

import helpers.BaseScreen
import io.qameta.allure.Step

class PremiumInfoPopUp : BaseScreen() {
    val message = findById("message", androidPrefix)
    private val closeButton = findById("button1", androidPrefix)

    @Step("Close the pop up")
    fun closePremiumInfoPopUp(): SalesPopUp {
        closeButton.click()

        return SalesPopUp()
    }
}