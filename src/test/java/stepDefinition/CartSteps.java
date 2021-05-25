package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.photon.UIconstants.CartPageConstants;
import com.photon.UIconstants.PDPPageConstants;
import com.photon.library.CommonLibrary;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSteps extends CommonLibrary {

	static boolean StartAftermethod = false;
	public int i = 1;
	public static String Username;
	public static String Password;

	public static String Scenario;

	public CartSteps() throws ConfigurationException, IOException {
		super();

	}

	@Then("^user clicks cart icon in header section$")
	public void user_clicks_cart_icon_in_header_section() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.headerCartIcon),
				"User clicks on Cart icon in header");
	}

	@Then("^user should able to land on Cart page$")
	public void user_should_able_to_land_on_cart_page() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.CartPageTitle),
				"User lands on cart page");
	}

	@Then("^User should able to to view the title of the page as \"([^\"]*)\"$")
	public void user_should_able_to_to_view_the_title_of_the_page_as_cart(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.CartPageTitle, strArg1),
				"The Title of the Cart page is displayed as:  " + strArg1);
	}

	// List of items in the cart
	@Then("^User should able to view the list of products added to cart \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_able_to_view_the_list_of_products_added_to_cart_something_and_something(String strArg1,
			String strArg2) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.cartProduct + strArg1 + "')]"),
				strArg1 + " Is added to the cart");
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.cartProduct + strArg1 + "')]"),
				strArg2 + " Is added to the cart");

	}

	@Then("^User should able to view the count of the number of products available in cart$")
	public void user_should_able_to_view_the_count_of_the_number_of_products_available_in_cart() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.actualCount),
				"Count of the number of products available in cart is displayed");
		String itemCount = CommonLibrary.getElementByProperty(CartPageConstants.actualCount, driver).getText();
		char str1 = itemCount.charAt(0);
		itemCount = Character.toString(str1);
		CartPageConstants.totalItemCount = Integer.parseInt(itemCount);

	}

	@Then("^user shoud able to Increase the product quantity as \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_shoud_able_to_increase_or_decrease_the_product_quantity_in_the_cart(String strArg1, String strArg2)
			throws Throwable {

		int j = Integer.parseInt(strArg1);

		for (int i = 1; i < j; i++) {
			Thread.sleep(3000);
			CommonLibrary.Assert(
					CommonLibrary.isElementPresentVerifyClick(
							CartPageConstants.addQuantity1 + strArg2 + CartPageConstants.addQuantity2),
					strArg2 + " Qty increased to " + (i + 1));
		}
		Thread.sleep(3000);

	}

	@Then("^The product count should get updated to actuals plus \"([^\"]*)\"$")
	public void the_product_count_should_get_updated(String strArg1) throws Throwable {
		Thread.sleep(3000);
		String itemCount = CommonLibrary.getElementByProperty(CartPageConstants.actualCount, driver).getText();
		char str1 = itemCount.charAt(0);
		itemCount = Character.toString(str1);
		int updateCount = Integer.parseInt(itemCount);

		if (updateCount == CartPageConstants.totalItemCount + Integer.parseInt(strArg1)) {

			System.out.println("Product count is updated in the cart");
		} else {
			throw new Exception("The Product count is not updated");
		}

	}

	@Then("^user should able to view the cart is empty$")
	public void user_should_able_to_veiw_empty_cart() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.emptyCart), "Cart is empty");
	}

	@And("^user able to view the product variant and Color for \"([^\"]*)\"$")
	public void user_able_to_view_the_product_variant_and_color_for_something(String strArg1) throws Throwable {
		WebElement wb = getElementByProperty(CartPageConstants.cartProduct + strArg1 + CartPageConstants.variantName2,
				driver);
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.variantName2),
				"The Variant/Color is displayed as :" + wb.getText());
	}

	@Then("^User should able to view the free gifts products grouped in a section with the title \"([^\"]*)\" product category$")
	public void user_should_able_to_view_the_free_gifts_products_grouped_in_a_section_with_the_title_somethingproduct_category(
			String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.freeGiftTitle + strArg1 + "']"),
				"Free gift section title is displayed as :" + strArg1);

		CartPageConstants.freeProductName = getElementByProperty(CartPageConstants.freeGiftProduct, driver).getText();
	}

	@And("^User should able to view the quantity field in the free gifts products group$")
	public void user_should_able_to_view_the_quantity_field_in_the_free_gifts_products_group_against_each_free_gift_product()
			throws Throwable {
		CommonLibrary.Assert((CommonLibrary.isElementPresentVerification(CartPageConstants.freeGiftQty)),
				"Free Gift Quantity is displayed");
	}

	@And("^The quantity should increase or decrease based on the parent product quantity \"([^\"]*)\"$")
	public void the_quantity_should_increase_or_decrease_based_on_the_parent_product_quantity(String strArg1)
			throws Throwable {
		String freeGiftQty = getElementByProperty(CartPageConstants.freeGiftQty, driver).getText();
		String productQty = getElementByProperty(CartPageConstants.cartProduct + strArg1 + CartPageConstants.productQty,
				driver).getAttribute("value");
		if (freeGiftQty.equalsIgnoreCase(productQty)) {
			System.out.println("Free gift product quantity is updated as per parent product");
		} else {
			throw new Exception("Free gift product quantity is not updated");
		}

	}

	@And("^User should able to view the strikethrough price of the free products and also the \"([^\"]*)\" text$")
	public void user_should_able_to_view_the_strikethrough_price_of_the_free_products_and_also_the_something_text(
			String strArg1) throws Throwable {
		CommonLibrary.Assert((CommonLibrary.isElementPresentVerification(CartPageConstants.freeText + strArg1 + "']")),
				"Free text is displayed against the free product");

	}

	@And("^User should able to view the \"([^\"]*)\" link below each free product$")
	public void user_should_able_to_view_the_something_link_below_each_free_product(String strArg1) throws Throwable {
		String linkText = getElementByProperty(CartPageConstants.addAnotherLink + strArg1 + "')]", driver).getText();

		CommonLibrary.Assert(
				(CommonLibrary.isElementPresentVerification(CartPageConstants.addAnotherLink + strArg1 + "')]")),
				linkText + " Link is displayed");

	}

	@When("^clicking on \"([^\"]*)\" link below each free product$")
	public void clicking_on_something_link_below_each_free_product(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.addAnotherLink + strArg1 + "')]")),
				strArg1 + " Link is clicked");
	}

	@Then("^user should able to view another product added to cart$")
	public void user_should_able_to_view_another_product_added_to_cart() throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(
						CartPageConstants.productInCart + CartPageConstants.freeProductName + "']"),
				CartPageConstants.freeProductName + " is added to the cart");
	}

	@Then("^User should able to view the close button against each product for \"([^\"]*)\"$")
	public void user_should_able_to_view_the_close_button_against_each_product_for_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.removeCartbutton2),
				strArg1 + " Close button is displayed");
	}

	@When("^clicking on close button against \"([^\"]*)\"$")
	public void clicking_on_close_button_against_something(String strArg1) throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.removeCartbutton2),
				strArg1 + " Close button is Clicked");
		Thread.sleep(3000);
	}

	@Then("^It should remove the \"([^\"]*)\" from the list$")
	public void it_should_remove_the_something_from_the_list(String strArg1) throws Throwable {

		CommonLibrary.Assert(
				CommonLibrary.isElementNotPresentVerification(CartPageConstants.cartProduct + strArg1 + "')]"),
				strArg1 + " is Removed from the cart");
	}

	@Then("^The free product should also automatically get removed from cart$")
	public void the_free_product_should_also_automatically_get_removed_from_cart() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CartPageConstants.freeGiftSection),
				"Free Gift section has been removed");
	}

	@Then("^user should able to click on view cart button$")
	public void user_should_able_to_click_on_viewcart_buttton() throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.goToCartButton),
				"View cart Button is clicked");
	}

	@Then("^user should able to view error message for ordering more than 50 Qty$")
	public void user_should_able_to_view_error_message_for_ordering_more_than_50_qty() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartQtyError),
				"Error message is displayed above the cart title for more than 50 qty");
	}

	@Then("^user should able to view the error message gets disappear$")
	public void user_should_able_to_view_error_message_gets_disappear() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CartPageConstants.cartQtyError),
				"Error message Get disapprear when the product quantity is reduced");
	}

	@Then("^the error message should read as \"([^\"]*)\"$")
	public void the_error_message_should_read_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.cartQtyError, strArg1),
				strArg1 + " Error message is displayed");
	}

	// Temperory Step belwo1

	@Then("^user should able to add the product \"([^\"]*)\" from \"([^\"]*)\"$")
	public void user_should_able_to_add_the_product_something_to_cart(String strArg1, String strArg2) throws Throwable {

		CommonLibrary.moveToElement(PDPPageConstants.productCategory + strArg2 + "'])[1]");
		if (!strArg1.contains("Sheets")) {
			CommonLibrary.Assert(
					CommonLibrary.moveToElementAndClick(PDPPageConstants.GenericProductLink + strArg1 + "'])[1]"),
					"Selected product : " + strArg1);
			Thread.sleep(3000);
		}

		else if (strArg1.contains("Sheets")) {
			CommonLibrary.Assert(
					CommonLibrary.moveToElementAndClick(PDPPageConstants.GenericProductLink + "Purple Sheets'])[1]"),
					"User lands on Sheets listing page");

			CommonLibrary.Assert(
					CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.PDPGenericProduct + strArg1 + "']"),
					"Selected product : " + strArg1);
		}
		if (CommonLibrary.isElementPresentVerification(PDPPageConstants.shopnowButton) == true) {
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.shopnowButton),
					"shop now button clicked for " + strArg1);
		}
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.addToCartButton),
				"Add Items to cart button is clicked");

	}

	// Temperory steps
	@Then("^user should able to add the product \"([^\"]*)\"$")
	public void user_should_able_to_add_the_product_something_to_cart1(String strArg1) throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerifyClick(PDPPageConstants.GenericButton + strArg1 + "']/following::a[1]"),
				"Navigated to " + strArg1 + " prodcut detail page");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(3000);
	}

	@Then("^user should able to click on keep shopping button$")
	public void user_should_able_to_click_on_keep_shopping_button() throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.keepShoppingButton),
				"Keep shopping button is clicked");
	}

	// Temo ends

	@And("^User navigates to the Purple site$")
	public void user_navigates_to_the_purple_site() throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.PurpleLogo),
				"User Navigates to Purple Site Successfully");
	}

	@Then("^user should be able to view \"([^\"]*)\" section in cart page$")
	public void user_should_be_able_to_view_something_section_in_cart_page(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CartPageConstants.cartPagePromoSections + strArg1 + "')]", strArg1),
				strArg1 + " Title Section is displayed");
	}

	// Promo code and Affirm section

	@Then("^user should able to view \"([^\"]*)\" link below order summary section$")
	public void user_should_able_to_view_something_link_below_order_summary_section(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.addpromoLink + strArg1 + "']", strArg1),
				strArg1 + " Link is displayed");
	}

	@Then("^user should able to click \"([^\"]*)\" link$")
	public void user_should_able_to_click_something_link(String strArg1) throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.addpromoLink + strArg1 + "']"),
				strArg1 + " Link is Clicked");
	}

	@Then("^user should be able to view the promo code field with place holder as \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_promo_code_field_with_place_holder_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.promoCodePlaceholderText, strArg1),
				strArg1 + " Place holder text is displayed");
	}

	@And("^user should be able to enter promocode in the field as \"([^\"]*)\"$")
	public void user_should_be_able_to_enter_a_promo_code_in_the_field_as_something(String strArg1) throws Throwable {

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CartPageConstants.promoTextField, strArg1),
				"User Enters promo code  as " + strArg1);
	}

	@And("^user should be able to enter a promocode in the field as (.+)$")
	public void user_should_be_able_to_enter_a_promo_code_in_the_field(String activityName, DataTable table)
			throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);

		String promoCode = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Promocode");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CartPageConstants.promoTextField, promoCode),
				"User Enters promo code as " + promoCode);

	}

	@Then("^user should be able to click on apply button$")
	public void user_should_be_able_to_click_on_apply_button() throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.applyButton),
				"Apply Button is Clicked");

	}

	@And("^the offer should be applied Successfully$")
	public void the_offer_should_be_applied_to_the_cart_value() throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoBoxTitle),
				"Promo code Applied successfully");

	}

	@Then("^user should be able to view the promo box with image, title and description$")
	public void user_should_be_able_to_view_the_promo_box_with_image_title_and_description() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoBoxImage),
				"Promo code Image is Displayed");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoBoxTitle),
				"Promo code Title is Displayed");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoBoxDesc),
				"Promo code Description is Displayed");

	}

	@Then("^user should be able to click on the close button in the promo code$")
	public void user_should_be_able_to_click_on_the_close_button_in_the_promo_code() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.promoClose),
				"User clicks on close button in the promobox");
		Thread.sleep(5000);

	}

	@Then("^the applied promo code should be removed$")
	public void the_applied_promo_code_should_be_removed() throws Throwable {
		CommonLibrary.Assert(!CommonLibrary.isElementPresentVerification(CartPageConstants.promoBoxTitle),
				"Promo code has been removed");

	}

	@And("^the dicount value should not be displayed in the cart$")
	public void the_dicount_value_should_not_be_displayed_in_the_cart() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CartPageConstants.OrderSummaryPromoLineItem),
				"Promo Details are not displayed in Oreder Summary Section");
	}

	@Then("^user should be able to view the error message as \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_error_message_as_something(String strArg1) throws Throwable {
		// WebElement wb = getElementByProperty(CartPageConstants.promoErrorMessage,
		// driver);
		// System.out.println("-----"+wb.getText());

		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.promoErrorMessage, strArg1),
				strArg1 + " is displayed in red as inline error");

	}

	@Then("^user should remove the product from the cart to make it empty$")
	public void user_should_remove_the_product_from_the_cart_to_make_it_empty() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.removeProduct),
				"User removes product from the cart");
		Thread.sleep(3000);
	}

	@Then("^user should be able to view the Affrim Logo$")
	public void user_should_be_able_to_view_the_affrim_logo() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmLogo),
				"Affirm Logo is Displayed");
	}

	@And("^user should be able to view a short decription$")
	public void user_should_be_able_to_view_a_short_decription() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.afffirmDesc),
				"Affirm Description is Displayed");
	}

	@And("^user should be able to view a Learn more link$")
	public void user_should_be_able_to_view_a_learn_more_link() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmLearnMoreLink),
				"Learn More Link is Displayed in Affrim Section");
	}

	@Then("^user should be able to view Continue shopping button under affirm marketing content$")
	public void user_should_be_able_to_view_continue_shopping_button_under_affirm_marketing_content() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.continueShoppingBtn),
				"Continue Shopping button displayed");
	}

	@Then("^user should be able to click on the Continue shopping button$")
	public void user_should_be_able_to_click_on_the_continue_shopping_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.continueShoppingBtn),
				"Continue Shopping button is Clicked");
	}

	@And("^user should be navigated to the previously accessed page$")
	public void user_should_be_navigated_to_the_previously_accessed_page() throws Throwable {

	}

	@And("^User should able to view the line item which indicates the total number of products added to cart \"([^\"]*)\"$")
	public void user_should_able_to_view_the_line_item_which_indicates_the_total_number_of_products_added_to_cart_something(
			String strArg1) throws Throwable {

		String itemCount = CommonLibrary.getElementByProperty(CartPageConstants.actualCount, driver).getText();
		char str1 = itemCount.charAt(0);
		itemCount = Character.toString(str1);
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CartPageConstants.itemCountfield, strArg1 + itemCount + " )"),
				"Line item for Count of the product is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.OSItemCount, itemCount),
				"Product Counts displayed are correct");
	}

	@Then("^User should able to view the total cost of the product$")
	public void user_should_able_to_view_the_total_cost_of_the_product() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartTotal),
				"Total Cost of the products is displayed");

	}

	@Then("^User should able to view the line item with details on the promo code applied, the discounted cost should be shown as a negative value$")
	public void user_should_able_to_view_the_line_item_with_details_on_the_promo_code_applied_the_discounted_cost_should_be_shown_as_a_negative_value()
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoLineItem),
				"The Applied promo code line item is displayed in Order summary section");
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.promoValue, "-"),
				"Discounted price is shown as a negative value ");

	}

	@And("^User should able to view a highlighted box with the total savings value  \"([^\"]*)\"$")
	public void user_should_able_to_view_a_highlighted_box_with_the_total_savings_value_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.yourSavingBox, strArg1),
				"Your Saving box is displayed");
	}

	@Then("^user should be able to view the subtotal value$")
	public void user_should_able_to_view_the_subtotal_line_item_with_the_value() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.subtotalValue, "$"),
				"SubTotal is displayed in $ value");
	}

	@And("^User should able to view the EMI Per month value$")
	public void user_should_able_to_view_the_emi_per_month_value() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.EMIValue),
				"EMI Value is displayed");
	}

	@When("^User click on Prequalify link$")
	public void user_click_on_prequalify_link() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.preQualifyLink),
				"Prequalify Link is Clicked");
	}

	@Then("^User should able to view the Prequalify link$")
	public void user_should_able_to_view_the_something_link() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.preQualifyLink),
				"Prequalify Link is displayed");
	}

	@Then("^user closed the Affirm pop up$")
	public void user_closed_the_affirm_pop_up() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.switchtoFrame("prequal-application");
		WebElement wb = getElementByProperty(CartPageConstants.affirmPopupClose, driver);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", wb);
		System.out.println("Affirm Popup closed");
	}

	@And("^The promo code line item should not be displayed$")
	public void the_promo_code_line_item_should_not_be_displayed() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CartPageConstants.noPromoLineItem),
				"Promo Code line item is not displayed");
	}

	@Then("^User should able to view a note below the Estimated shipping & Taxes line item \"([^\"]*)\" if applicable$")
	public void user_should_able_to_view_a_note_below_the_estimated_shipping_taxes_line_item_something_if_applicable(
			String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.estShipping),
				"Estimated shipping line item is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.whiteGloveFree, strArg1),
				"White Glove eligibility is displayed");
	}

	// Our Promise SEction

	@Then("^user should able to view Our Promise Section$")
	public void user_should_able_to_view_our_promise_section() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseSection),
				"Our Promise section is displayed");
	}

	@Then("^user should able to view \"([^\"]*)\" title$")
	public void user_should_able_to_view_something_title(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseTitle + strArg1 + " ']"),
				strArg1 + " Title is displayed in Our promise section");
	}

	@And("^user should able view \"([^\"]*)\" icon in Our Promise Section$")
	public void user_should_able_view_something_icon_in_our_promise_section(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseIcon + strArg1 + "']"),
				strArg1 + " icon is displayed");
	}

	@And("^user should able view \"([^\"]*)\" text below the icon$")
	public void user_should_able_view_something_text_below_the_icon(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseIconText + strArg1 + "']"),
				strArg1 + " Text is displayed below Icon");
	}

	@Then("^user able to view \"([^\"]*)\" for \"([^\"]*)\"$")
	public void user_able_to_view_something_for_something(String strArg1, String strArg2) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseIconText + strArg1 + "']"),
				strArg1 + " promise is displayed below Icon");
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(
						CartPageConstants.ourPromiseIconText + strArg1 + "']/following-sibling::p", strArg2),
				strArg1 + " Promise displayed for :" + strArg2);
	}

	@Then("^user able to view \"([^\"]*)\" and description as \"([^\"]*)\"$")
	public void user_able_to_view_something_and_description_as_something(String strArg1, String strArg2)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.ourPromiseIconText + strArg1 + "']"),
				strArg1 + " promise is displayed below Icon");
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(
						CartPageConstants.ourPromiseIconText + strArg1 + "']/following-sibling::p", strArg2),
				strArg1 + " Promise displayed for :" + strArg2);
	}

	// Customer Service Section

	@Then("^user should able to view \"([^\"]*)\" link$")
	public void user_should_able_to_view_something_link(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.viewPoductLink),
				strArg1 + " Link is Displayed");
	}

	@Then("^user should able to view Chat with a service agent link$")
	public void user_should_able_to_view_chat_with_a_service_agent_link() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.csChatLink),
				"Chat Link is displayed");
	}

	@Then("^user should able to view Chat with a service agent icon$")
	public void user_should_able_to_view_chat_with_a_service_agent_icon() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.csChatIcon),
				"Chat Icon is displayed");
	}

	@Then("^user should able to view Customer service icon$")
	public void user_should_able_to_view_customer_service_icon() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.csCustomerNumberIcon),
				"Customer Service Phone number icon is displayed");
	}

	@Then("^user should able to view Customer service number link$")
	public void user_should_able_to_view_customer_service_number_link() throws Throwable {
		String phNumber1 = getElementByProperty(CartPageConstants.csCustomerNumberLink1, driver).getText();
		String phNumber2 = getElementByProperty(CartPageConstants.csCustomerNumberLink2, driver).getText();

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.csCustomerNumberLink1),
				"Customer Service Phone number is displayed as :" + phNumber1 + " or " + phNumber2);
	}

	@Then("^user clicks on Customer service number link$")
	public void user_clicks_on_customer_service_number_link() throws Throwable {
		WebElement wb = getElementByProperty(CartPageConstants.csCustomerNumberLink1, driver);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", wb);
		// CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.csCustomerNumberLink2),
		// "Customer service phone number is clicked");

		System.out.println("Customer service phone number is clicked");

	}

	// Variant Popup

	@Then("^user should able to view edit link of \"([^\"]*)\"$")
	public void user_should_able_to_view_edit_link_of_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.editLink),
				"Edit link for " + strArg1 + " is displayed ");
		// driver.findElement(By.xpath(CartPageConstants.productInCart+strArg1+CartPageConstants.editLink));

	}

	@Then("^The edit link should not be displayed to \"([^\"]*)\"$")
	public void the_edit_link_should_not_be_displayed_to_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementNotPresentVerification(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.editLink),
				"Edit link for " + strArg1 + " is not displayed ");
	}

	@Then("^user should able to click edit link of \"([^\"]*)\"$")
	public void user_should_able_to_click_edit_link_of_something(String strArg1) throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(
						CartPageConstants.cartProduct + strArg1 + CartPageConstants.editLink),
				"Edit link for " + strArg1 + " is Clicked ");
	}

	@Then("^user shoud able to view the varaint popup for \"([^\"]*)\"$")
	public void user_shoud_able_to_view_the_varaint_popup(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupTitle),
				"Variant popup is displayed for " + strArg1);
	}

	@Then("^close the popup for \"([^\"]*)\"$")
	public void close_the_popup(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.closePopup),
				strArg1 + " Variant popup is Closed");
	}

	@Then("^user should able to view Popup title as \"([^\"]*)\"$")
	public void user_should_able_to_view_popup_title_as_edit_popup(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.popupTitle, strArg1),
				"Variant popup title is displayed as " + strArg1);
	}

	@Then("^user should able to view \"([^\"]*)\" name$")
	public void user_should_able_to_view_something_name(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.popupPoductName, strArg1),
				"Variant popup Product name is displayed as " + strArg1);
	}

	@Then("^user should able to view product image$")
	public void user_should_able_to_view_product_image() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupImage),
				"Product Image is displayed on variant popup");
	}

	@Then("^user should able to view Size dropdown$")
	public void user_should_able_to_view_size_dropdown() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupSizeDD),
				"Size dropdown is displayed on variant popup");
	}

	@Then("^user should able to view colour selection$")
	public void user_should_able_to_view_colour_selection() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupColorSection),
				"Colour selection is displayed on variant popup");
	}

	@Then("^user should able to view product price$")
	public void user_should_able_to_view_product_price() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupPrice),
				"Product price is displayed variant popup");
	}

	@Then("^user should able to view Update button$")
	public void user_should_able_to_view_something_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.popupUpdateButton),
				"Update Button is displayed variant popup");
	}

	@Then("^user should able to view Close popup button$")
	public void user_should_able_to_view_close_popup_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.closePopup),
				"Close button is displayed for variant popup");
	}

	@Then("^user should able to select the size as \"([^\"]*)\"$")
	public void user_should_able_to_select_the_size_as_something(String strArg1) throws Throwable {
		Thread.sleep(5000);
		Select drpState = new Select(getElementByProperty(CartPageConstants.popupSizeDD, driver));
		drpState.selectByVisibleText(strArg1);
		System.out.println(strArg1 + " is selected from Size dropdown");
	}

	@Then("^user should able to select the colour as \"([^\"]*)\"$")
	public void user_shoulda_able_to_select_the_colour_as_stonegrey(String strArg1) throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.popupColorSelection),
				strArg1 + " Color selected from variant Popup");
	}

	@Then("^User clicks on update button$")
	public void user_clicks_on_update_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.popupUpdateButton),
				"Update Button in Variant popup is clicked");
	}

	@Then("^user able to view the Size \"([^\"]*)\" is updated in cart page for \"([^\"]*)\"$")
	public void user_able_to_view_the_size_something_is_updated_in_cart_page(String strArg1, String strArg2)
			throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(
						CartPageConstants.cartProduct + strArg2 + CartPageConstants.variantName2, strArg1),
				"Product variant is updated in the cart");
	}

	// Promo Label steps

	@Then("^user should able to view the promo lable for freegift$")
	public void user_should_able_to_view_the_promo_lable_for_freegift() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartPromoLabel),
				"promo label is displayed in the cart page");
	}

	@Then("^user shoud able to view a gift icon in the promo labels shown for Free Products$")
	public void user_shoud_able_to_view_a_gift_icon_in_the_promo_labels_shown_for_Free_Products() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartProductGiftIcon),
				"Gift icon in the promo label is displayed");
	}

	@Then("^user shoud able to view a Free product should be shown as a separate line item$")
	public void user_shoud_able_to_view_a_Free_product_should_be_shown_as_a_separate_line_item() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartProductGiftIcon),
				"Affirm and splitit section is displayed in cart page");
	}

//AOV section steps

	@Then("^user should able to view the AOV section$")
	public void user_should_able_to_view_the_AOV_section() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.cartAOVSection),
				"AOV section is displayed in cart page");
	}

	@Then("^User should be able to view maximum (\\d+) products in the single slide$")
	public void user_should_be_able_to_view_maximum_products_in_the_single_slide(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		int lineItemCount = driver.findElements(By.cssSelector(CartPageConstants.cartAOVLineitem)).size();
		System.out.println(lineItemCount);
		if (arg1 == lineItemCount) {
			System.out.println("Max of 3 products is displayed in AOV slide");
		} else {
			throw new Exception("NO MATCHING DATA FOUND");
		}

	}

	@Then("^user should be able to view the AOV bundle of Hybrid mattress is displayed as it has highest pricing$")
	public void user_should_be_able_to_view_the_aov_bundle_of_hybrid_mattress_is_displayed_as_it_has_highest_pricing()
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CartPageConstants.cartAOVSection,
				"Complete your Sleep Solution"), "The AOV section for Highest priced product is displayed");
	}

	@Then("^user should be able to add all the products from AOV section$")
	public void user_should_be_able_to_add_all_the_products_from_aov_section() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.addAOVLineitem),
				"All product added from the AOV section");
	}

	@Then("^user should not be able to view the AOV section$")
	public void user_should_not_be_able_to_view_the_aov_section() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CartPageConstants.cartAOVSection),
				"AOV section is not displayed in cart page");
	}

	// Affirm and Splitit section

	@Then("^user should able to view the affirm splitit section title as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_affirm_splitit_section_title_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.affirmSplititTitle, strArg1),
				"Affirm splitit section title is displayed as :" + strArg1);
	}

	@Then("^user should able to vxxxiew the affirm splitit section description as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_affirm_splitit_section_description_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.affirmSplititDesc, strArg1),
				"Affirm splitit section description is displayed as :" + strArg1);
	}

	@Then("^user should able to view splitit and affirm section in Cart page$")
	public void user_should_able_to_view_splitit_and_affirm_section_in_cart_page() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmSplititSection),
				"Affirm and splitit section is displayed in cart page");
	}

	@Then("^user should able to view splitit logo and short description as \"([^\"]*)\"$")
	public void user_should_able_to_view_splitit_logo_and_short_description_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.splititLogo),
				"Splitit Logo is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.splititDesc, strArg1),
				"splitit section description is displayed as :" + strArg1);

	}

	@Then("^user should able to view \"([^\"]*)\" link of splitit$")
	public void user_should_able_to_view_something_link_of_splitit(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.splititLearnMoreLink),
				strArg1 + " is displayed for Splitit");
	}

	@When("^user click on \"([^\"]*)\" link of splitit$")
	public void user_click_on_something_link_of_splitit(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.splititLearnMoreLink),
				strArg1 + " is Clicked for splitit");
	}

	@Then("^user should able to view affirm logo and short description as \"([^\"]*)\"$")
	public void user_should_able_to_view_affirm_logo_and_short_description_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmLogo),
				"Affirm Logo is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.affirmDesc, strArg1),
				"Affirm section description is displayed as :" + strArg1);
	}

	@Then("^user should able to view \"([^\"]*)\" link of affirm$")
	public void user_should_able_to_view_something_link_of_affirm(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmLearnMoreLink),
				strArg1 + " is displayed for Affirm");
	}

	@When("^user click on \"([^\"]*)\" link of affirm$")
	public void user_click_on_something_link_of_affirm(String strArg1) throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.affirmLearnMoreLink),
				strArg1 + " is Clicked for Affirm");
	}

	@Then("^user should able to view Splitit popup$")
	public void user_should_able_to_view_splitit_popup() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.splititpopup),
				"Splitit popup is displayed");
	}

	@Then("^user should able to close the splitit popup$")
	public void user_should_able_to_close_the_splitit_popup() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.splititpopupClose),
				"Splitit popup is Closed");

	}

	@Then("^user should able to view affirm popup$")
	public void user_should_able_to_view_affirm_popup() throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.switchtoFrame("prequal-application");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.affirmpopup),
				"Affirm popup is displayed");
	}

	@Then("^user should able to close the affirm popup$")
	public void user_should_able_to_close_the_affirm_popup() throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.affirmpopupClose),
				"Affirm popup is Closed");
		CommonLibrary.switchtodefault();

	}

	@Then("^Verify the text name is \"([^\"]*)\"$")
	public void verify_the_text_name_is(String txtPreQualifyLinkName) throws Throwable {

		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.preQualifyLink),
				"Prequalify Link is displayed");

		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.preQualifyLink, txtPreQualifyLinkName),
				"The Prequalify Now with Affirm name is displayed as:  " + txtPreQualifyLinkName);

	}

	@Then("^user able to verify strikethrough price in AOV section$")
	public void user_able_to_verify_strikethrough_price_in_AOV_section() throws Throwable {

		String strikeThroughPrice = CommonLibrary
				.getElementByProperty(CartPageConstants.strikethroughPriceAOVLineitem, driver).getText();
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CartPageConstants.strikethroughPriceAOVLineitem),
				"Strikethrough price is displayed in AOV section :" + strikeThroughPrice);

	}

	@Then("^user able to verify promo label in AOV section$")
	public void user_able_to_verify_promo_label_in_AOV_section() throws Throwable {

		String promoLabel = CommonLibrary.getElementByProperty(CartPageConstants.promoLabelAOVLineitem, driver)
				.getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoLabelAOVLineitem),
				"Promo label is displayed in AOV section :" + promoLabel);

	}

	@Then("^user able to verify strikethrough price in product section$")
	public void user_able_to_verify_strikethrough_price_in_product_section() throws Throwable {
		String strikeThroughPrice = CommonLibrary.getElementByProperty(CartPageConstants.strikeThroughPrice, driver)
				.getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.strikeThroughPrice),
				"Strikethrough price is displayed in product section :" + strikeThroughPrice);
	}

	@Then("^user able to verify promo label in product section$")
	public void user_able_to_verify_promo_label_in_product_section() throws Throwable {

		String promoLabel = CommonLibrary.getElementByProperty(CartPageConstants.promoLabelLineitem, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CartPageConstants.promoLabelLineitem),
				"Promo label is displayed in product section :" + promoLabel);
	}

	@Then("^user should be able to add the products from AOV section$")
	public void user_should_be_able_to_add_the_products_from_AOV_section() throws Throwable {
		CommonLibrary.isElementPresentVerifyClick(CartPageConstants.addAOVItem);
	}

	@Then("^user able to verify the cart icon persistent$")
	public void user_able_to_verify_the_cart_icon_persistent() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementDisplayed(CartPageConstants.headerCartIcon),
				"User able to verify cart icon");

	}

	@Then("^user verify free product is displayed$")
	public void user_verify_free_product_is_displayed() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementDisplayed(CartPageConstants.freePriceAmount), 
				"User able to view free product");
	}

	@Then("^user able to see new line item added to the cart$")
	public void user_able_to_see_new_line_item_added_to_the_cart() throws Throwable {
		
		Thread.sleep(4000);
		int lineItemCount = driver.findElements(By.xpath(CartPageConstants.numberOfCartItem)).size();
		System.out.println("Number of line item after adding product");
		
		CommonLibrary.Assert(lineItemCount==3, "New line item added in the cart:"+lineItemCount);

	}

	@Then("^user able to see new line item removed to the cart$")
	public void user_able_to_see_new_line_item_removed_to_the_cart() throws Throwable {
		Thread.sleep(4000);
		
		int lineItemCount = driver.findElements(By.xpath(CartPageConstants.numberOfCartItem)).size();
		System.out.println("Number of line item after removing product" + lineItemCount);
		
		

	}
	
	@Then("^verify promo label is displayed for the product$")
	public void verify_promo_label_is_displayed_for_the_product() throws Throwable {
	    
	}

	@Then("^verify promo label is displayed for AOV product$")
	public void verify_promo_label_is_displayed_for_AOV_product() throws Throwable {
	    
	}

}
