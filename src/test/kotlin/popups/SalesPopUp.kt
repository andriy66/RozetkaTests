package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.PremiumSubscribeScreen

class SalesPopUp : BaseScreen() {
    private val availWithPremiumSubButton = findElementByText("ДОСТУПНО З ПІДПИСКОЮ PREMIUM")

    @Step("Click available with Premium Subscribe")
    fun clickAvailWithPremiumSub(): PremiumInfoPopUp {
        availWithPremiumSubButton.click()

        return PremiumInfoPopUp()
    }
}