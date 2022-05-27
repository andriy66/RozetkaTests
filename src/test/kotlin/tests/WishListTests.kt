package tests

import helpers.BaseTest
import io.qameta.allure.Description
import org.testng.Assert
import org.testng.annotations.Test
import screens.HomeScreen

class WishListTests : BaseTest() {
    @Test
    @Description("Verify that you can add the product to the Wish List")
    fun verifyThatCustomerCanAddProductToLikedList() {
        val chooseTheSubCategory = HomeScreen()
            .openCatalog()
            .openCategoryLaptopsAndComputersSubCategoryScreen()
            .openListOfProducts()

        //Get monitor name
        val monitorName = "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W"

        //Open monitor description
        val monitorDescription = chooseTheSubCategory
            .openProductDescription(monitorName)

        //Adding Monitor to the Wish List
        monitorDescription.addToWishList()
        val addMonitor = monitorDescription.openWishList()

        //Get monitor
        val monitor = addMonitor.monitor

        //Check that monitor is in Wish List
        Assert.assertEquals(monitor.text, monitorName, "The product isn`t in the Wish List")

        //Relocate the monitor and create list
        val createWishList = addMonitor
            .openItemMenu()
            .clickRelocateProduct()
            .createWishList()

        //Check that Wish List is unchecked
        val isDefaultWishList = createWishList.makeDefaultWishListCheckBox.isSelected
        softAssert.assertFalse(isDefaultWishList, "It is default Wish List")

        //Create new Wish List
        val wishListName = "Test"
        createWishList.fillInWishListName(wishListName)
        val emptyWishList = createWishList.clickCreateWishList()

        //Check that Wish List is empty
        Assert.assertTrue(emptyWishList.wishListIsEmpty(), "Wish List isn`t empty")

        //Go to the List of Products
        val listOfProductsScreen = emptyWishList
            .getBackToProductDescription()
            .getBack()

        //Open Wish Lists
        val wishLists = listOfProductsScreen.openWishLists()

        //Open Wish List
        val testWishScreen = wishLists.openWishList()
        val monitorInTestWishList = testWishScreen.monitor

        //Check that monitor is in Test Wish List
        Assert.assertEquals(monitorInTestWishList.text, monitorName, "The product isn`t in the Wish List")

        //Deleting Wish List
        val deleteFromWishLists = testWishScreen
            .getBackToWishLists()
            .openWishListMenu()
            .deleteWishList()
        val message = deleteFromWishLists.message.text
        deleteFromWishLists.clickDelete()

        //Check that message for deleting pop up is shown
        softAssert.assertEquals(message, "Ви дійсно хочете видалити список \"Test\" в якому 1 товар?")
    }

}