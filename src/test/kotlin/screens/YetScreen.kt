package screens

import helpers.BaseScreen
import io.qameta.allure.Step

class YetScreen : BaseScreen() {
    val signUpButton = findById("item_menu_auth_tv_sign_up")
    val signInButton = findById("item_menu_auth_tv_sign_in")
    val rozetkaLogoImage = findById("item_menu_header_ll_logo")
    val ruLanguageButton = findById("item_menu_header_tv_ru")
    val uaLanguageButton = findById("item_menu_header_tv_uk")
    val myOrdersButton = findElementByText("Мої замовлення")
    val myMessagesButton = findElementByText("Мої повідомлення")
    val myCorrespondentsButton = findElementByText("Моє листування")
    val myPocketButton = findElementByText("Мій гаманець")
    val premiumSubscribeButton = findElementByText("Підписка Premium")
    val comparisonButton = findElementByText("Порівняння")
    val watchedButton = findElementByText("Переглянуті")
    val salesButton = findElementByText("Знижки")

    @Step("Open Authorize Screen")
    fun openAuthorizeScreen(): AuthorizeScreen {
        signInButton.click()

        return AuthorizeScreen()
    }

    @Step("Open Comparison Screen")
    fun openComparisonScreen(): ListOfComparisonScreen {
        comparisonButton.click()

        return ListOfComparisonScreen()
    }
}