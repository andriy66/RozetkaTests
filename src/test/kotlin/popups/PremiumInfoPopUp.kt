package popups

import helpers.BaseScreen
import io.qameta.allure.Step
import screens.PremiumSubscribeScreen

class PremiumInfoPopUp : BaseScreen() {
    private val closeButton = findById("button1", androidPrefix)
    private val getBackButton = findByXpath("//*[@content-desc='Перейти вгору']")
    val message = findById("message", androidPrefix)

    @Step("Close the pop up and get back")
    fun closePremiumInfoPopUpAndGetBack(): PremiumSubscribeScreen {
        log.info("Close the pop up and get back")
        closeButton.click()
        getBackButton.click()

        return PremiumSubscribeScreen()
    }
}