package tests

import io.qameta.allure.Description
import org.testng.annotations.Test
import screens.HomeScreen
import helpers.BaseTest
import helpers.Properties
import org.testng.Assert.assertEquals

class Tests : BaseTest() {

    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val homeScreen = HomeScreen()
        val yetScreen = homeScreen.openYet()

        //Check that Yet Screen components are displayed
        softAssert.assertEquals(
            yetScreen.rozetkaLogoImage.isDisplayed,
            true,
            "The 'Rozetka Logo' image isn`t displayed"
        )
        assertEquals(yetScreen.signInButton.isDisplayed, true, "The 'Sign In' button isn`t displayed")

        val authorizeScreen = yetScreen.openAuthorizeScreen()

        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        val authorizeProfile = authorizeScreen
            .authorize(validEmail, validPassword)

        //Check that the user login
        softAssert.assertEquals(
            authorizeProfile.rozetkaLogoIcon.isDisplayed,
            true,
            "The 'Rozetka Logo' icon is displayed"
        )
        assertEquals(authorizeProfile.getProfileOwnerName(), "Лютак Андрій", "Invalid login")
    }

    @Test
    @Description("Verify that you can add the product to the cart")
    fun verifyThatYouCanAddProductToTheCart() {
        val catalogScreen = HomeScreen()
            .openCatalog()

        val chooseTheCategory = catalogScreen.openCategoryLaptopsAndComputers()
        val chooseTheSubCategory = chooseTheCategory.openListOfProducts()

        //Check that List of Products Screen opened
        softAssert.assertEquals(chooseTheSubCategory.sortButton.isDisplayed, true, "Button 'Sort' isn`t displayed")
        softAssert.assertEquals(chooseTheSubCategory.filterButton.isDisplayed, true, "Button 'Filter' isn`t displayed")

        val monitorName = "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W"

        val monitorDescription = chooseTheSubCategory
            .openProductDescription(monitorName)

        //Adding the product to the cart
        val cartScreen = monitorDescription
            .addToCart()
            .openCart()
        val product = cartScreen.getMonitorFromCart()

        //Check that product is in the cart
        assertEquals(
            product.text,
            "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W",
            "Product isn`t in cart"
        )

        val removeFromCart = cartScreen
            .openItemMenu()
            .clickRemoveFromCart()

        //Check that product has been deleted
        assertEquals(removeFromCart.emptyCart(), true, "Product had`t been deleted")
    }

    @Test
    @Description("Verify that you can add the product to the Wish List")
    fun verifyThatCustomerCanAddProductToLikedList() {
        val catalogScreen = HomeScreen().openCatalog()
        val chooseTheCategory = catalogScreen.openCategoryLaptopsAndComputers()
        val chooseTheSubCategory = chooseTheCategory.openListOfProducts()

        val monitorName = "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W"

        val monitorDescription = chooseTheSubCategory
            .openProductDescription(monitorName)

        //Adding Monitor to the Wish List
        val addMonitor = monitorDescription
            .addToWishList()
            .openWishList()

        val monitor = addMonitor.getMonitorFromWishList()

        //Check that monitor is in Wish List
        assertEquals(monitor.text, monitorName, "The product isn`t in the Wish List")

        val itemMenu = addMonitor.openItemMenu()
        val relocateMonitor = itemMenu.clickRelocateProduct()

        val createWishList = relocateMonitor.createWishList()

        //Check that Wish List is unchecked
        val isDefaultWishList = createWishList.makeDefaultWishListCheckBox.isSelected

        softAssert.assertEquals(isDefaultWishList, false, "It is default Wish List")

        //Create new Wish List
        val wishListName = "Test"
        createWishList.fillInWishListName(wishListName)
        val emptyWishList = createWishList.clickCreateWishList()

        //Check that Wish List is empty
        assertEquals(emptyWishList.wishListIsEmpty(), true, "Wish List isn`t empty")

        val productDescription = emptyWishList.getBackToProductDescription()
        val listOfProductsScreen = productDescription.getBack()

        //Open Wish Lists
        val wishLists = listOfProductsScreen.openWishLists()

        //Open Wish List
        val testWishScreen = wishLists.openWishList()
        val monitorInTestWishList = testWishScreen.getMonitorFromWishList()

        //Check that monitor is in Test Wish List
        assertEquals(monitorInTestWishList.text, monitorName, "The product isn`t in the Wish List")

        //Deleting Wish List
        val deleteFromWishLists = testWishScreen
            .getBackToWishLists()
            .openWishListMenu()
            .deleteWishList()

        softAssert.assertEquals(
            deleteFromWishLists.getMessage(),
            "Ви дійсно хочете видалити список \"Test\" в якому 1 товар?"
        )

        deleteFromWishLists.clickDelete()
    }
}