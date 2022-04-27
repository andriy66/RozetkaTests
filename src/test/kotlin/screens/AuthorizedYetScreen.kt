package screens

import helpers.BaseScreen

class AuthorizedYetScreen : BaseScreen() {
    val rozetkaLogoIcon = findById("item_menu_header_ll_logo")
    private val profileOwnerNameButton = findById("item_menu_profile_tv_name")

    fun getProfileOwnerName() : String {
        return profileOwnerNameButton.text
    }
}