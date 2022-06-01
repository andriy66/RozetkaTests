package popups

import helpers.BaseScreen
import io.qameta.allure.Step

class SalesPopUp : BaseScreen() {
    private val availWithPremiumSubButton = findElementByText("ДОСТУПНО З ПІДПИСКОЮ PREMIUM")

    @Step("Click available with Premium Subscribe")
    fun clickAvailWithPremiumSub(): PremiumInfoPopUp {
        log.info("Click available with Premium Subscribe")
        availWithPremiumSubButton.click()

        return PremiumInfoPopUp()
    }
}