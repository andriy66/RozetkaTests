package tests

import io.qameta.allure.Description
import org.testng.Assert
import helpers.Properties
import helpers.BaseTest
import org.testng.annotations.Test
import screens.HomeScreen

class Tests : BaseTest() {
    @Test
    @Description("Verify that you can log in with valid data")
    fun verifyThatCantLogInWithValidDataAndCanLogInWithValid() {
        val yetScreen = HomeScreen().openYet()

        //Check that Yet Screen components are displayed
        softAssert.assertTrue(yetScreen.rozetkaLogoImage.isDisplayed, "The 'Rozetka Logo' image isn`t displayed")
        Assert.assertTrue(yetScreen.signInButton.isDisplayed, "The 'Sign In' button isn`t displayed")

        //Get valid data
        val validEmail = Properties.getProperty("email")
        val validPassword = Properties.getProperty("password")

        //Authorize and check that the user login
        val authorizeProfile = yetScreen.openAuthorizeScreen()
            .authorize(validEmail, validPassword)
        softAssert.assertTrue(authorizeProfile.rozetkaLogoIcon.isDisplayed, "The 'Rozetka Logo' icon is displayed")
        Assert.assertEquals(authorizeProfile.profileOwnerNameButton.text, "Лютак Андрій", "Invalid login")
    }

    @Test
    @Description("Verify that customer can add the product to the cart")
    fun verifyThatYouCanAddProductToTheCart() {
        val catalogScreen = HomeScreen()
            .openCatalog()

        //Open list of products
        val chooseTheSubCategory = catalogScreen
            .openCategoryLaptopsAndComputersSubCategoryScreen()
            .openListOfProducts()

        //Check that List of Products Screen opened
        softAssert.assertTrue(chooseTheSubCategory.sortButton.isDisplayed, "Button 'Sort' isn`t displayed")
        softAssert.assertTrue(chooseTheSubCategory.filterButton.isDisplayed, "Button 'Filter' isn`t displayed")

        //Get monitor name
        val monitorName = "Монітор 27\" Dell S2722DC (210-BBRR) 75Hz/8-bit/USB Type-C Power Delivery 65W"

        //Open monitor description
        val monitorDescription = chooseTheSubCategory
            .openProductDescription(monitorName)

        //Adding the product to the cart
        val cartScreen = monitorDescription
            .addToCart()
            .openCart()

        //Get product from cart
        val product = cartScreen.monitor

        //Check that product is in the cart
        Assert.assertEquals(product.text, monitorName, "Product isn`t in cart")

        //Remove product from Cart
        val removeFromCart = cartScreen
            .openItemMenu()
            .removeFromCart()

        //Check that product has been deleted
        Assert.assertTrue(removeFromCart.emptyCart(), "Product had`t been deleted")
    }

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
        val addMonitor = monitorDescription
            .addToWishList()
            .openWishList()

        //Get monitor
        val monitor = addMonitor.getMonitorFromWishList()

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
        Assert.assertTrue(emptyWishList.wishListIsEmpty(),  "Wish List isn`t empty")

        //Go to the List of Products
        val listOfProductsScreen = emptyWishList
            .getBackToProductDescription()
            .getBack()

        //Open Wish Lists
        val wishLists = listOfProductsScreen.openWishLists()

        //Open Wish List
        val testWishScreen = wishLists.openWishList()
        val monitorInTestWishList = testWishScreen.getMonitorFromWishList()

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

    @Test
    @Description("Verify that sort is working correctly")
    fun checkThatFilterAndSortIsWorkingCorrectly() {
        val listOfProductsScreen = HomeScreen()
            .findProduct("iphone 13")

        //Get product names
        val cheapProduct = "Мобільний телефон Apple iPhone 13 mini 128 GB (PRODUCT) Red Офіційна гарантія"
        val expensiveProduct = "Мобільний телефон Apple iPhone 13 Pro Max 1TB Gold Офіційна гарантія"

        //Sort the products from cheap to expensive
        val sort = listOfProductsScreen
            .openSortPopUp()
            .chooseFromCheapToExpensive()

        //Get the price of product after sorting from cheap to expensive
        val cheapProductPrice =
            sort.getProductPrice(cheapProduct)

        //Sort the products from expensive to cheap
        val sortListOfProducts = sort
            .openSortPopUp()
            .chooseFromExpensiveToCheap()

        //Get the price of product after sorting from expensive to cheap
        val expensiveProductPrice = sortListOfProducts
            .getProductPrice(expensiveProduct)

        //Check that the price of first product after sorting from cheap to expensive is less that the price of first element after sorting from expensive to cheap
        Assert.assertTrue(cheapProductPrice < expensiveProductPrice)
    }

    @Test
    @Description("Verify that after searching the product is adding to 'Переглянуті товари'")
    fun checkThatAfterSearchingProdAddToViewScreen() {
        val productName = "Мобільний телефон Apple iPhone 13 Pro Max 128 GB Gold Офіційна гарантія"

        //Delete data in Watched List if it exists
        val clearData = HomeScreen()
            .openYet()
            .openWatchedScreen()
            .clearWatchedData()

        //Check that data from Watched List is empty
        var message = clearData.message.text
        Assert.assertEquals(message, "Ви ще не переглядали товари")

        //Find the product
        val listOfProduct = clearData
            .openHomeScreen()
            .findProduct("iphone 13")

        //Get product description and open the Watch Screen
        val watchedScreen = listOfProduct.openProductDescription(productName)
            .getBack()
            .openHomeScreen()
            .openWatchScreen()

        //Check that product is in Watched List
        val productFromWatchedList = watchedScreen.getProductFromWatchedList(productName)
        Assert.assertTrue(productFromWatchedList.isDisplayed)

        //Clear all data
        watchedScreen.clearWatchedData()

        //Check that data was deleted
        message = clearData.message.text
        Assert.assertEquals(message, "Ви ще не переглядали товари")
    }

    @Test
    @Description("Verify that customer can add the products for comparison")
    fun verifyThatCustomerCanAddTheProductsForComparison() {
        val catalogScreen = HomeScreen()
            .openCatalog()

        //Choose the category 'Gamers Product'
        val gamerProducts = catalogScreen.openCategoryGamersProducts()

        //Get products name
        val firstProductName = "Ігрова консоль XoKo Hey Boy Червона (XOKO Нb-RD)"
        val secondProductName = "Ігрова консоль XoKo Hey Boy Чорна (XOKO Нb-BK)"

        //Open the Sub Category
        val listOfProducts = gamerProducts.openGameConsolesListOfProducts()

        //Add first product to Comparison
        val firstProduct =
            listOfProducts.openProductDescription(firstProductName)
            .addToComparison()
            .getBack()

        //Add second product to Comparison
        val secondProduct = firstProduct.openProductDescription(secondProductName)
            .addToComparison()
            .getBack()

        //Open Comparison
        val comparisonScreen = secondProduct.openYet()
            .openComparisonScreen()
            .openComparisonList()

        //Check difference
        val difference = comparisonScreen.clickDifference()
        val firstProductProp = difference.isProperDisplayed("Червоний")
        val secondProductProp = difference.isProperDisplayed("Чорний")
        Assert.assertEquals(firstProductProp, secondProductProp, "The properties are displayed")

        //Delete list
        val deleteList = difference
            .getBack()
            .deleteComparisonList()
        val messageOfDeleting = deleteList.message.text

        //Check that list was deleted
        Assert.assertEquals(messageOfDeleting, "Немає товарів в порівнянні", "The list was`t deleted")
    }
}