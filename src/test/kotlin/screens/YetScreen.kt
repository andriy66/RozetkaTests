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
    val profileNameButton = findById("item_menu_profile_tv_name")
    val profileSettingsButton = findById("item_menu_profile_ll_profile")

    @Step("Open Authorize Screen")
    fun openAuthorizeScreen(): AuthorizeScreen {
        signInButton.click()

        return AuthorizeScreen()
    }

    @Step("Open Watched Screen")
    fun openWatchedScreen(): WatchedScreen {
        scroll()
        watchedButton.click()

        return WatchedScreen()
    }

    @Step("Open Comparison Screen")
    fun openComparisonScreen(): ListOfComparisonScreen {
        comparisonButton.click()

        return ListOfComparisonScreen()
    }

    @Step("Open Premium Subscribe screen")
    fun openPremiumSubscribeScreen(): PremiumSubscribeScreen {
        premiumSubscribeButton.click()

        return PremiumSubscribeScreen()
    }

    @Step("Open profile settings")
    fun openProfileSettings(): ProfileSettingScreen {
        profileSettingsButton.click()

        return ProfileSettingScreen()
    }
}