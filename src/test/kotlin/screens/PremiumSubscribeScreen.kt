package screens

import com.codeborne.selenide.Condition
import helpers.BaseScreen
import helpers.ScrollDirection
import io.qameta.allure.Step
import popups.SalesPopUp

class PremiumSubscribeScreen : BaseScreen() {
    private val premiumContentLabel = findById("premium_ll_content")
    private val salesButton = findElementByText("Знижки та промокоди")
    val chooseThePremiumSubButton = findById("premium_btn_header_action")

    @Step("Get delivery price info")
    fun getDeliveryPriceInfo(delivery: Delivery): String {
        log.info("Get delivery price info")
        premiumContentLabel.shouldBe(Condition.visible)
        scroll()
        val delivery = findById(delivery.toString())

        return delivery.text
    }

    @Step("Choose the premium subscribe")
    fun chooseThePremiumSubscribe(): ChoosePremiumScreen {
        log.info("Choose the premium subscribe")
        scroll(ScrollDirection.UP, 3)
        chooseThePremiumSubButton.click()

        return ChoosePremiumScreen()
    }

    @Step("Click sales button")
    fun clickSalesButton(): SalesPopUp {
        log.info("Click sales button")
        salesButton.click()

        return SalesPopUp()
    }

    enum class Delivery(
        delivery: String = "nova_poshta",
        private val type: String = "premium_tv_free_delivery_${delivery}_old_price"
    ) {
        NOVA_POSHTA,
        UKR_POSHTA("ukrposhta"),
        COURIER("courier"),
        JUSTIN("just_in"),
        MEEST("meest");

        override fun toString(): String {
            return type
        }
    }
}

