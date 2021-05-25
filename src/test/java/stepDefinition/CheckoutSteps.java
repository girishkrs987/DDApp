package stepDefinition;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.listener.Reporter;
import com.itextpdf.text.log.SysoCounter;
import com.photon.UIconstants.CartPageConstants;
import com.photon.UIconstants.CheckoutPageConstants;
import com.photon.UIconstants.PDPPageConstants;
import com.photon.UIconstants.OrderConfirmationConstants;
import com.photon.library.CommonLibrary;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.qualitycheck.Check;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;

public class CheckoutSteps extends CommonLibrary {

	static boolean StartAftermethod = false;
	public int i = 1;
	public static String Username;
	public static String Password;

	public static String Scenario;

	public CheckoutSteps() throws ConfigurationException, IOException {
		super();

	}

	@Then("^user should able to click on Checkout button$")
	public void user_should_able_to_click_on_checkout_buttton() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.checkOutBtn),
				"User should able to click check out button");
	}

	@Then("^user should able to land on Checkout page$")
	public void user_should_able_to_land_on_checkout_page() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.CheckoutPageTitle),
				"User lands on Checkout page");
		
	}
	
	 @Then("^user should able to view the promotions email checkbox$")
	    public void user_should_able_to_view_the_promotions_email_checkbox() throws Throwable {
		 CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.promoEmailCheckbox),
					"Promotion email checkbox is displayed");
	    }

	    @Then("^user should able to view the copytext of checkbox as \"([^\"]*)\"$")
	    public void user_should_able_to_view_the_copytext_of_checkbox_as_something(String strArg) throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.promoEmailCheckbox,strArg),
					"Promotion Email checkbox copy text is displayed as : "+strArg);
	    }

	@Then("^Enter respective Delivery details in Delivery info section (.+)$")
	public void enter_respective_delivery_details_in_delivery_info_section(String activityName, DataTable table)
			throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String fname = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Fname");
		String lname = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Lname");
		String streetAddress = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Street Address");
		String city = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
				activityName, "City");
		String state = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "State");
		String zipCode = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Zip");
		String email = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Email");
		String phoneNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Phone Number");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.phoneNumber, phoneNumber),
				"Phone Number Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.email, email), "Email Entered");

		CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.firstName);
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.firstName, fname),
				"First Name Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.lastName, lname),
				"Last Name Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.address1, streetAddress),
				"Street Address Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.city, city), "City Entered");

		// Select State
		Select drpState = new Select(getElementByProperty(CheckoutPageConstants.statedropdown, driver));
		drpState.selectByVisibleText(state);

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.zipCode, zipCode),
				"Zip Code Entered");
		CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.city);


		if(isElementPresentVerification(CheckoutPageConstants.addressConfirm)==true) {
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.addressConfirm),
					"Confirm address is clicked");
		}
	}

	@Then("^user should able to select the payment method as \"([^\"]*)\"$")
	public void user_should_able_to_select_the_payment_method_as_something(String strArg1) throws Throwable {

		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.paymentMethod + strArg1 + "-tab']"),
				"User Clicks on " + strArg1 + " payment method");

	}

	@Then("^user should be able to click on complete order button$")
	public void user_should_be_able_to_click_on_complete_order_button() throws Throwable {
		
		
		if (CommonLibrary.isElementPresentVerification(CheckoutPageConstants.completeOrderButtonCard) == true) {
			if (CommonLibrary.isElementPresentVerification(CartPageConstants.closeDialog) == true) {
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.closeDialog),
					"user closes marketing dialog in footer");
			}
			
		}
		if (CommonLibrary.isElementPresentVerification(CheckoutPageConstants.completeOrderButton) == true) {
			
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.completeOrderButton),
					"User Clicks on Compelete Order button");

		} else {
			CommonLibrary.Assert(
					CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.completeOrderButtonCard),
					"User Clicks on Compelete Order button for card");
			Thread.sleep(1000);
		}

	}

	@When("^user completes the Affirm payment process (.+)$")
	public void user_completes_the_affirm_payment_process(String activityName, DataTable table) throws Throwable {

		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String number = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Affirm Valid Number");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.affirmValidNumber, number),
				"Mobile Number Entered");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.continueButton),
				"User Clicks on Continue button");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.pinInput, "1234"),
				"Pin Number Entered");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.emiMonths),
				"select installments");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.autoPaybutton),
				"Disable Autopay");
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.continueButton1),
				"User Clicks on Continue button");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.tncCheckBox),
				"T & C checkbox is clicked");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.continueButton1),
				"User Clicks on Confirm button");

	}

	@When("^user completes the Splitit payment process (.+)$")
	public void user_completes_the_splitit_payment_process(String activityName, DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String cardNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Credit Card Number");
		String expiry = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Expiration Date");
		String CVV = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
				activityName, "CVV");
		String email = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Email");
		String mobileNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Phone Number");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.splititCCNumber, cardNumber),
				cardNumber + " Entered as Credit Card Number");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.splititCCExp, expiry),
				expiry + " Entered as Expiration Date");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.splititCCCVV, CVV),
				CVV + " Entered as CVV");
		Thread.sleep(5000);
		CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.expandBillingSec);
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.splititEmail, email),
				email + " Entered as Email");
		
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.splititTandC),
				"User Select terms and Condition checkbox");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.splititpayButton),
				"User Clicks on Pay Now Button");

		// CommonLibrary.isElementPresentVerification(CheckoutPageConstants.completeOrderButton);
	}

	@Then("^user enters the \"([^\"]*)\" (.+)$")
	public void user_enters_the_something(String strArg1, String activityName, DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String cardDetail = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, strArg1);
		if (strArg1.equalsIgnoreCase("Full Name")) {
			CommonLibrary.switchtoFrame("first-data-payment-field-name");
		} else if (strArg1.equalsIgnoreCase("Credit Card Number")) {
			CommonLibrary.switchtoFrame("first-data-payment-field-card");
		} else if (strArg1.equalsIgnoreCase("Expiration Date")) {
			CommonLibrary.switchtoFrame("first-data-payment-field-exp");
		} else if (strArg1.equalsIgnoreCase("CVV")) {
			CommonLibrary.switchtoFrame("first-data-payment-field-cvv");
		}

		CommonLibrary.Assert(
				CommonLibrary.clearAndEnterText(CheckoutPageConstants.creditCardDetails + strArg1 + "']", cardDetail),
				cardDetail + " Entered as " + strArg1);
		CommonLibrary.switchtodefault();
		CommonLibrary.isElementPresentVerification(CheckoutPageConstants.completeOrderButtonCard);
	}

	@Then("^user should be able to view the current date$")
	public void user_should_be_able_to_view_the_current_date() throws Throwable {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		CommonLibrary.Assert(CommonLibrary.text_Validation(OrderConfirmationConstants.date, date),
				"Current date is displayed");

	}

	@Then("^user should be navigated to the Order Confirmation page with title as \"([^\"]*)\"$")
	public void user_should_be_navigated_to_the_order_confirmation_page_with_title_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.switchtoFrame(OrderConfirmationConstants.jsFrame);
		CommonLibrary.isElementPresentVerifyClick(OrderConfirmationConstants.popupClose);
		CommonLibrary.switchtodefault();
		CommonLibrary.Assert(CommonLibrary.text_Validation(OrderConfirmationConstants.OrderConftitle, strArg1),
				"Order Confirmation Title is displayed");
	}

	@Then("^user should be able to view a note below the order confirmation title$")
	public void user_should_be_able_to_view_a_note_below_the_order_confirmation_title() throws Throwable {
		String strArg = getElementByProperty(OrderConfirmationConstants.OrderConfNote, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(OrderConfirmationConstants.OrderConfNote),
				"Note below the title displayed as : " + strArg);
	}

	@Then("^user should be able to view the order id in the status bar$")
	public void user_should_be_able_to_view_the_order_id_in_the_status_bar() throws Throwable {
		String strArg = getElementByProperty(OrderConfirmationConstants.orderID, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(OrderConfirmationConstants.orderID),
				"Order id is displayed as : " + strArg);
	}

	@Then("^user should be able to view the order status in the status bar$")
	public void user_should_be_able_to_view_the_order_status_in_the_status_bar() throws Throwable {
		String strArg = getElementByProperty(OrderConfirmationConstants.orderStatus, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(OrderConfirmationConstants.orderStatus),
				"Order Status is displayed as : " + strArg);
	}

	@Then("^user should be able to view \"([^\"]*)\" section in order confirmation page$")
	public void user_should_be_able_to_view_something_section(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(OrderConfirmationConstants.OrderConfSections + strArg1 + "']", strArg1),
				strArg1 + " is displayed");
	}

	@Then("^user should able to view the promocode line item is displayed$")
	public void user_should_able_to_view_the_promocode_line_item_is_displayed() throws Throwable {
		String str = getElementByProperty(OrderConfirmationConstants.promocodeline, driver).getText();

		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(OrderConfirmationConstants.promocodeline, "-$"),
				"Promo code line is displayed");
	}

	@Then("^user should be able to view the same products added to cart \"([^\"]*)\"$")
	public void user_should_be_able_to_view_the_list_of_products_added_to_cart_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(OrderConfirmationConstants.products + strArg1 + "')]"),
				strArg1 + " is Displayed in order confirmation page");

	}

	@And("^user should be able to view the title as \"([^\"]*)\" product category$")
	public void user_should_be_able_to_view_the_title_as_something_product_category(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(OrderConfirmationConstants.freeGiftSection + strArg1 + "')]"),
				"Free Gift section is Displayed");
	}

	@And("^user should not able to view the title as \"([^\"]*)\" product category$")
	public void user_should_not_able_to_view_the_title_as_something_product_category(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary
						.isElementNotPresentVerification(OrderConfirmationConstants.freeGiftSection + strArg1 + "')]"),
				"Free Gift section is not Displayed");
	}

	@And("^user should be able to view the count of the number of products in the order$")
	public void user_should_be_able_to_view_the_count_of_number_of_products_in_the_order() throws Throwable {
		List<WebElement> wb = driver.findElements(By.xpath(OrderConfirmationConstants.productquantity));

		int j = wb.size();
		int quantity = 0;
		int temp = 0;

		for (int i = 0; i < j; i++) {
			quantity = Integer.parseInt(wb.get(i).getText());
			temp = quantity + temp;
			quantity = temp;
		}

		CommonLibrary.Assert(
				CommonLibrary.text_Validation(OrderConfirmationConstants.totalitmes, String.valueOf(quantity)),
				"Product quantity is displayed correctly as - " + String.valueOf(quantity));

	}

	@And("^user should be able to view the quantity field in the free gifts products group$")
	public void user_should_be_able_to_view_the_quantity_field_in_the_free_gifts_products_group() throws Throwable {
		throw new PendingException();
	}

	@Then("^user should be able to select the relevant shipping method$")
	public void user_should_be_able_to_select_the_relevant_shipping_methods() throws Throwable {
		Thread.sleep(3000);

		if (isElementPresentVerification(CheckoutPageConstants.deliveryMethod) == true) {

			if (isElementPresentVerification(CheckoutPageConstants.freeShippingMethod) == true) {
				String strArg4 = getElementByProperty(CheckoutPageConstants.freeShippingMethod, driver).getText();
				CommonLibrary.Assert(
						CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.freeShippingMethod),
						"User selects the shipping method for Free Shipping items : " + strArg4);
				Thread.sleep(3000);
			}

			if (isElementPresentVerification(CheckoutPageConstants.largeShippingMethod) == true) {
				String strArg2 = getElementByProperty(CheckoutPageConstants.largeShippingMethod, driver).getText();
				CommonLibrary.Assert(
						CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.largeShippingMethod),
						"User selects the shipping method for large itmes : " + strArg2);
				Thread.sleep(3000);

			}
			if (isElementPresentVerification(CheckoutPageConstants.smallShippingMethod) == true) {
				String strArg1 = getElementByProperty(CheckoutPageConstants.smallShippingMethod, driver).getText();
				CommonLibrary.Assert(
						CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.smallShippingMethod),
						"User selects the shipping method for Small items : " + strArg1);
				Thread.sleep(3000);

			}
			if (isElementPresentVerification(CheckoutPageConstants.faceMaskShippingMethod) == true) {
				String strArg3 = getElementByProperty(CheckoutPageConstants.faceMaskShippingMethod, driver).getText();
				CommonLibrary.Assert(
						CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.faceMaskShippingMethod),
						"User selects the shipping method for Face mask : " + strArg3);
				Thread.sleep(3000);
			}

		} else {
			throw new Exception("Delivery method not displayed");

		}

	}

	@Then("^user should be able to view \"([^\"]*)\" Address in order confirmation page$")
	public void user_should_be_able_to_view_something_address_in_order_confirmation_page(String strArg1)
			throws Throwable {
		String address = CommonLibrary.getElementByProperty(OrderConfirmationConstants.billingAndDelivery1 + strArg1
				+ OrderConfirmationConstants.billingAndDelivery2, driver).getText();
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(OrderConfirmationConstants.billingAndDelivery1 + strArg1
						+ OrderConfirmationConstants.billingAndDelivery3, strArg1),
				strArg1 + " Address is displayed as :" + address);
	}

	@Then("^user should be able to view \"([^\"]*)\" in order confirmation page$")
	public void user_should_be_able_to_view_something_method_in_order_confirmation_page(String strArg1)
			throws Throwable {
		String address = CommonLibrary.getElementByProperty(OrderConfirmationConstants.billingAndDelivery1 + strArg1
				+ OrderConfirmationConstants.billingAndDelivery3, driver).getText();
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(OrderConfirmationConstants.billingAndDelivery1 + strArg1
						+ OrderConfirmationConstants.billingAndDelivery3, strArg1),
				strArg1 + " is displayed as :" + address);
	}

	@Then("^user should be able to view \"([^\"]*)\" button$")
	public void user_should_be_able_to_view_something_button(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(OrderConfirmationConstants.shoppingButton, strArg1),
				strArg1 + " button is displayed");
	}

	// Shipping Info

	@Then("^user able to view \"([^\"]*)\" Field with same label$")
	public void user_able_to_view_something_field_with_same_lable(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.fieldLabel + strArg1 + "'])[1]"),
				strArg1 + " Text Field is displayed with same Label");
	}

	@Then("^user able to view \"([^\"]*)\" dropdown with same label$")
	public void user_able_to_view_something_dropdown_with_same_lable(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.dropdownLabel + strArg1 + "'])[1]"),
				strArg1 + " dropdown is displayed with same Label");
	}

	@Then("^user should able to enter Firstname and Lastname (.+)$")
	public void user_should_able_to_enter_firstname_and_lastname(String activityName, DataTable table)
			throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String fname = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Fname");
		String lname = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Lname");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.firstName, fname),
				"First Name Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.lastName, lname),
				"Last Name Entered");
	}

	@Then("^user should able to enter Address (.+)$")
	public void user_should_able_to_enter_address(String activityName, DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String streetAddress = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Street Address");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.address1, streetAddress),
				"Street Address Entered");
	}

	@Then("^user should able to enter City state and zipcode (.+)$")
	public void user_should_able_to_enter_city_state_and_zipcode(String activityName, DataTable table)
			throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String city = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
				activityName, "City");
		String state = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "State");
		String zipCode = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Zip");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.city, city), "City Entered");

		// Select State
		Select drpState = new Select(getElementByProperty(CheckoutPageConstants.statedropdown, driver));
		drpState.selectByVisibleText(state);

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.zipCode, zipCode),
				"Zip Code Entered");
		CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.phoneNumber);
		
		if(isElementPresentVerification(CheckoutPageConstants.addressConfirm)==true) {
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.addressConfirm),
					"Confirm address is clicked");
		}
	}

	@Then("^user should able to enter Contact details (.+)$")
	public void user_should_able_to_enter_contact_details(String activityName, DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String email = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Email");
		String phoneNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Phone Number");

		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.email, email), "Email Entered");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.phoneNumber, phoneNumber),
				"Phone Number Entered");

	}

	@Then("^user able to view suggestion popup$")
	public void user_able_to_view_suggestion_popup_with_original_and_suggested_address() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.addressPopup),
				"Address Validation Suggestion popup is displayed");

	}

	@Then("^user able to view the popup title as \"([^\"]*)\"$")
	public void user_able_to_view_the_popup_title_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.popupTitle + strArg1 + "']"),
				strArg1 + " Title is displayed on Address validation popup");
	}

	@Then("^user able to view the popup message as \"([^\"]*)\"$")
	public void user_able_to_view_the_popup_msg_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.popupmessage + strArg1 + "']"),
				strArg1 + " Title is displayed on Address validation popup");
	}

	@Then("^user able to view suggested address$")
	public void user_able_to_view_suggested_address() throws Throwable {
		Thread.sleep(3000);
		String address = getElementByProperty(CheckoutPageConstants.addressSuggest, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.addressSuggest),
				"Suggested Address is displayed as : \n" + address);
	}

	@Then("^user able to view Original address$")
	public void user_able_to_view_original_address() throws Throwable {
		Thread.sleep(3000);
		String address = getElementByProperty(CheckoutPageConstants.addressOriginal, driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.addressOriginal),
				"Original Address is displayed as : \n" + address);
	}

	@Then("^user able to click Original address if applicable$")
	public void user_able_to_click_original_address() throws Throwable {
		if (getElementByProperty(CheckoutPageConstants.addressOriginal, driver) != null) {
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.addressOriginal),
					"Original Address is Clicked");
		} else {
			System.out.println("Address suggestion popup not displayed");
		}
	}

	@Then("^user able to click suggested address$")
	public void user_able_to_click_suggested_address() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.addressSuggest),
				"Suggested Address is Clicked");
	}
	

    @Then("^user should able to view the Billing address checkbox$")
    public void user_should_able_to_view_the_billing_address_checkbox() throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.billingAddressCheckbox),
				"Billing Address checkbox is displayed");
    }

	// Error Messages Steps

	@Then("^user able to view the error message for invalid zipcode (.+)$")
	public void user_delete_one_character_and_check_the_invalid_format_error_for_zipcode_field(String activityName,
			DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Error Message");

		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.errZipcode, errMessage),
				"Error message for invalid Zipcode is displayed as : " + errMessage);

	}

	@Then("^user able to view the error message for invalid email (.+)$")
	public void user_delete_one_character_and_check_the_invalid_format_error_for_email_feild(String activityName,
			DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);

		String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Field Validation");

		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.errEmail, errMessage),
				"Error message for invalid Zipcode is displayed as : " + errMessage);

	}

	@Then("^user enters invalid zipcode$")
	public void user_enters_invalid_zipcode() throws Throwable {
		CommonLibrary.clearAndEnterText(CheckoutPageConstants.zipCode, "1234");
	}

	@Then("^user should able to view the error message for zipcode against the state (.+)$")
	public void user_should_able_to_view_the_error_message_for_zipcode_against_the_state(String activityName,
			DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Error Message");

		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.errZipcode, errMessage),
				"Error message for invalid Zipcode against the state is displayed as : " + errMessage);

	}

	@Then("^user should able to view the error message for \"([^\"]*)\" field as (.+)$")
	public void user_should_able_to_view_the_error_message_for_field(String strArg, String activityName,
			DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		int i = Integer.parseInt(activityName);

		for (int j = 1; j <= i; j++) {
			activityName = Integer.toString(j);

			String feild = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "Feild");

			if (strArg.equalsIgnoreCase(feild)) {
				String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
						dataMap.get("SheetName").get(0), activityName, "Error Message");

				CommonLibrary.Assert(
						CommonLibrary.text_Validation(CheckoutPageConstants.errMessage + strArg + "']", errMessage),
						"Error message for " + strArg + " is displayed as : " + errMessage);
			}
		}
	}
	
	

	@Then("^user should able to view the error message for invalid \"([^\"]*)\" field as (.+)$")
	public void user_should_able_to_view_the_error_message_for_invalid_field(String strArg, String activityName,
			DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);

		String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "Field Validation");

		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CheckoutPageConstants.errMessage + strArg + "_char']", errMessage),
				"Error message for invalid " + strArg + " is displayed as : " + errMessage);

	}

	// Cart Summary Section

	@Then("^User should able to view the list of products added in Cart Summary of checkout page \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_able_to_view_the_list_of_products_added_to_cart_something_and_something(String strArg1,
			String strArg2) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(CheckoutPageConstants.productInCartSummary + strArg1 + "')]"),
				strArg1 + " Is displayed in cart Summary");
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(CheckoutPageConstants.productInCartSummary + strArg2 + "')]"),
				strArg2 + " Is displayed in cart Summary");

	}

	@Then("^user should be able to view \"([^\"]*)\" section in checkout page$")
	public void user_should_be_able_to_view_something_section_in_checkout_page(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.cartSummaryTitle + strArg1 + "']"),
				strArg1 + " section in checkout page is displayed");

	}

	@Then("^User should able to view the count of the number of products in checkout page cart Summary$")
	public void user_should_able_to_view_the_count_of_the_number_of_products_available_in_cart() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.totalItemCount),
				"Total Items is cart Summary is displayed");
		String itemCount = CommonLibrary.getElementByProperty(CheckoutPageConstants.totalItemCount, driver).getText();
		char str1 = itemCount.charAt(0);
		itemCount = Character.toString(str1);
		if (CartPageConstants.totalItemCount == Integer.parseInt(itemCount)) {
			System.out.println("The Total items in cart summary is displayed correctly");
		} else {
			throw new Exception("The total items are incorrect");
		}

	}

	@And("^variant and Color is displayed for \"([^\"]*)\"$")
	public void variant_and_color_is_displayed_for_something(String strArg1) throws Throwable {
		String str = getElementByProperty(
				CheckoutPageConstants.productInCartSummary + strArg1 + CheckoutPageConstants.cartSummaryProdVariant,
				driver).getText();
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.productInCartSummary + strArg1
						+ CheckoutPageConstants.cartSummaryProdVariant),
				"Product Variant for " + strArg1 + " is : " + str);
	}

	@And("^strikethrough price is displayed for \"([^\"]*)\"$")
	public void strikethrough_price_is_displayed_for_something(String strArg1) throws Throwable {
		String str = getElementByProperty(
				CheckoutPageConstants.productInCartSummary + strArg1 + CheckoutPageConstants.cartSummaryStrikePrice,
				driver).getText();
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.productInCartSummary + strArg1
						+ CheckoutPageConstants.cartSummaryStrikePrice),
				"Strike through Product Price for " + strArg1 + " is : " + str);
	}

	@And("^actual price is displayed for \"([^\"]*)\"$")
	public void actual_price_is_displayed_for_something(String strArg1) throws Throwable {
		String str = getElementByProperty(
				CheckoutPageConstants.productInCartSummary + strArg1 + CheckoutPageConstants.cartSummaryProdPrice,
				driver).getText();
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(
				CheckoutPageConstants.productInCartSummary + strArg1 + CheckoutPageConstants.cartSummaryProdPrice),
				"Product Price for " + strArg1 + " is : " + str);
	}

	@Then("^User should able to view the free gifts for \"([^\"]*)\" with section title as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_free_gifts_for_something_wi_the_section_title_as_something(String strArg1,
			String strArg2) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CheckoutPageConstants.productInCartSummary + strArg1
						+ CheckoutPageConstants.cartSummaryFreeGiftSec, strArg2),
				"Free Gift section for " + strArg1 + " is displayed with section title as : " + strArg2);
	}

	@And("^User should able to view the line item which indicates the total number of products \"([^\"]*)\"$")
	public void user_should_able_to_view_the_line_item_which_indicates_the_total_number_of_products_added_to_cart_something(
			String strArg1) throws Throwable {

		String itemCount = CommonLibrary.getElementByProperty(CheckoutPageConstants.totalItemCount, driver).getText();
		char str1 = itemCount.charAt(0);
		itemCount = Character.toString(str1);
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CartPageConstants.itemCountfield, strArg1 + itemCount + " )"),
				"Line item for Count of the product is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.OSItemCount, itemCount),
				"Product Counts displayed are correct");
	}

	@And("^User should able to view the strikethrough price of the gift product of \"([^\"]*)\"$")
	public void user_should_able_to_view_the_strikethrough_price_of_the_free_products_of_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.productInCartSummary + strArg1
						+ CheckoutPageConstants.cartSummarystrikePrice),
				"Strikethrough price for  " + strArg1 + " is displayed");
	}

	@And("^User should able to view the \"([^\"]*)\" text for the gift product of \"([^\"]*)\"$")
	public void user_should_able_to_view_the_something_text_for_the_gift_product_of_something(String strArg1,
			String strArg2) throws Throwable {

		CommonLibrary.Assert(
				CommonLibrary.text_Validation(CheckoutPageConstants.productInCartSummary + strArg2
						+ CheckoutPageConstants.cartSummaryFreeGiftFreeText, strArg1),
				"Free text is displayed for free gifts of product " + strArg2);

	}

	@And("^User should able to view Shipping cost line item, if there is no shipping cost, then instead of cost \"([^\"]*)\" text is shown$")
	public void user_should_able_to_view_shipping_cost_line_item_if_there_is_no_shipping_cost_then_instead_of_cost_something_text_is_shown(
			String strArg1) throws Throwable {
		WebElement wb = getElementByProperty(CheckoutPageConstants.cartSummaryShipamt, driver);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.cartSummaryShipcost),
				"Shipping cost line item is displayed");
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.freeShippingMethod, wb.getText()),
				"Shipping price is displayed correctly as :" + strArg1);

	}

	@Then("^User should able to view a note below the Estimated shipping line item \"([^\"]*)\"$")
	public void user_should_able_to_view_a_note_below_the_estimated_shipping_line_item_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.estShipping),
				"Estimated shipping line item is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(CartPageConstants.whiteGloveFree, strArg1),
				"White Glove eligibility is displayed");
	}

	// Recycling Fee

	@And("^user should able to view the \"([^\"]*)\" line item in order summary$")
	public void user_should_able_to_view_the_something_line_item_in_order_summary(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.cartSummaryRecyclingfee, strArg1),
				"Recycling Fee line item is displayed");
	}

	@Then("^user should able to view the recycling fee cost$")
	public void user_should_able_to_view_the_recycling_fee_line_item_in_order_summary() throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.cartSummaryRecyclingfeeAmt),
				"Recycling fee amountis displayed");
		String recyclingfee = getElementByProperty(CheckoutPageConstants.cartSummaryRecyclingfeeAmt, driver).getText();
		String price = recyclingfee.replace("$", "");

		CheckoutPageConstants.recyclingfee = Double.parseDouble(price);

	}

	@Then("^user should able to view the recycling fee is added every mattress$")
	public void user_should_able_to_view_the_recycling_fee_is_added_every_mattress() throws Throwable {
		Thread.sleep(5000);
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.cartSummaryRecyclingfeeAmt),
				"Recycling fee amountis displayed");
		String recyclingfee = getElementByProperty(CheckoutPageConstants.cartSummaryRecyclingfeeAmt, driver).getText();
		String price = recyclingfee.replace("$", "");

		Double fee = Double.parseDouble(price);

		if (fee.equals(CheckoutPageConstants.recyclingfee * 2)) {

			System.out.println("Recycling fee calculation for every mattress");
		} else {
			throw new Exception("Recycling fee is not properly calculated");
		}
	}

	// Delivery Methods

	@Then("^user should be able to view default delivery methods as \"([^\"]*)\" for large items$")
	public void user_should_be_able_to_view_default_delivery_methods_as_something_for_large_items(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.groundShippingLargeItems, strArg1),
				"Default large items shipping method is displayed as : " + strArg1);
	}

	@Then("^user should be able to view default delivery methods as \"([^\"]*)\" for small items$")
	public void user_should_be_able_to_view_default_delivery_methods_as_something_for_small_items(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.samllItemsShippingMethod, strArg1),
				"Default small items shipping method is displayed as : " + strArg1);
	}

	@Then("^User should able to see a loading indicator with message \"([^\"]*)\"$")
	public void user_should_able_to_see_a_loading_indicator_with_message_something(String strArg1) throws Throwable {
		Thread.sleep(1000);
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.DeliveryMethodSpinner, strArg1),
				"Spinner is displayed with the title : " + strArg1);
	}

	@Then("^User should able to view the title of the \"([^\"]*)\" group$")
	public void user_should_able_to_view_the_title_of_the_something_group(String strArg1) throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(CheckoutPageConstants.shippingMethodTitle + strArg1 + "')]"),
				strArg1 + " title is displayed under delivery method");
	}
	
	@Then("^user should be able to view delivery methods as \"([^\"]*)\" for Purple Hybrid Premier Mattresses$")
    public void user_should_be_able_to_view_delivery_methods_as_something_for_purple_hybrid_premier_mattresses(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(CheckoutPageConstants.inHomeSetupShippingMethod),
				strArg1 + " delivery method is displayed for Purple Hybrid Premier Mattresses");
    }

    @Then("^user should be able to view delivery methods as \"([^\"]*)\" for Purple Hybrid Mattress$")
    public void user_should_be_able_to_view_delivery_methods_as_something_for_purple_hybrid_mattress(String strArg1) throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary
						.isElementPresentVerification(CheckoutPageConstants.standardShipping),
				strArg1 + " delivery method is displayed for Purple Hybrid Mattresses");
    }
    
    @Then("^user should able to view paid inhome Setup option for \"([^\"]*)\"$")
    public void user_should_able_to_view_paid_inhome_setup_option_for_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.inHomeSetupShippingMethod,
    			strArg1), "Paid Inhome setup is displayed as $200");
    }


	@Then("^user able to view the shipping method rendered from fedex$")
	public void user_able_to_view_the_shipping_method_rendered_from_fedex() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.fedexShippingSmallItems,
				"business days"), "The shipping methods rendered from fedex successfully");
	}

	@Then("^User should able to view the thumbnail image of \"([^\"]*)\"$")
	public void user_should_able_to_view_the_thumbnail_image_and_product_name_for_all_the_products_listed(
			String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.thumbnailImage + strArg1 + "')])[2]"),
				strArg1 + " thumbnail image is displayed under delivery method");
	}

	@And("^user able to view the \"([^\"]*)\" name with variant size and color$")
	public void user_able_to_view_the_something_name_with_variant_size_and_color(String strArg1) throws Throwable {
		WebElement wb = getElementByProperty(
				CheckoutPageConstants.thumbnailImage + strArg1 + CheckoutPageConstants.thumnailProductname, driver);
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(
				CheckoutPageConstants.thumbnailImage + strArg1 + CheckoutPageConstants.thumnailProductname, strArg1),
				"Product name and variant displayed as expected : " + wb.getText());
	}

	@Then("^User should able to view shipping method below larger itmes group$")
	public void user_should_able_to_view_shipping_method_below_larger_itmes_group() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.freeShippingMethod),
				"Shipping method for larger items are displayed");
	}

	@Then("^User should able to view shipping method below smaller itmes group$")
	public void user_should_able_to_view_shipping_method_below_smaller_itmes_group() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.smallShippingMethod),
				"Shipping method for smaller items are displayed");
	}

	@And("^user able to view shipping cost beside each delivery method or \"([^\"]*)\" text if it is free$")
	public void user_able_to_view_shipping_cost_beside_each_delivery_method_or_something_text_if_it_is_free(
			String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.freeShippingMethod1, strArg1),
				"Cost or Free text is displayed as : " + strArg1);
	}

	@Then("^User should able to view information icon near the larger items section title$")
	public void user_should_able_to_view_information_icon_near_the_larger_items_section_title() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.largeItemInfoIcon),
				"Larger item info icon is displayed");
	}

	@Then("^User should able to view information icon near the smaller items section title$")
	public void user_should_able_to_view_information_icon_near_the_smaller_items_section_title() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.smallItemInfoIcon),
				"Smaller item info icon is displayed");
	}

	@When("^User clicks on the larger item information icon$")
	public void user_clicks_on_the_larger_item_information_icon() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.largeItemInfoIcon),
				"Larger item info icon is clicked");
	}

	@Then("^user able to view the info popup$")
	public void user_able_to_view_the_info_popup() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.largeItemInfoPopup),
				"Larger item info popup is displayed");
	}

	@And("^The pop up should have title as \"([^\"]*)\"$")
	public void the_pop_up_should_have_title_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.infoPopupTitle, strArg1),
				"Popup title is displayed as : " + strArg1);
	}

	@And("^user should able to view the popup information content$")
	public void user_should_able_to_view_the_popup_information_content() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.infoPopupContent),
				"Larger item info popup content is displayed");
	}

	@When("^user clicks on the Close button$")
	public void user_clicks_on_the_close_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.infoPopupClose),
				"Info popup close button is clicked");
	}

	@Then("^The error message should get displayed below Delivery method title as \"([^\"]*)\"$")
	public void the_error_message_should_get_displayed_below_delivery_method_title_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.DeliveryMethodError, strArg1),
				"No Delivery method selected alert is displayed");
	}

	@Then("^User should be able to view a error message should be removed$")
	public void user_should_be_able_to_view_a_error_message_should_be_removed() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.DeliveryMethodError),
				"Error message disappears");
	}

	@Then("^error message should get displayed below Delivery method title as \"([^\"]*)\"$")
	public void error_message_should_get_displayed_below_delivery_method_title_as_something(String strArg1)
			throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.NoshoppingAlert, strArg1),
				strArg1 + "- Error message is displayed");
	}

	@Then("^user should see the error message is removed$")
	public void user_should_see_the_error_message_is_removed() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.NoshoppingAlert),
				"Error message got removed");
	}

	// Gift card steps

	@And("^user shoud able to view note next to title as \"([^\"]*)\"$")
	public void user_shoud_able_to_view_not_next_to_title_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.paymentTitleNote + strArg1 + "']"),
				strArg1 + " note is displayed");
	}

	@And("^user should able to view the gift cart text field under the payment info title$")
	public void user_should_able_to_view_the_gift_cart_text_field_under_the_payment_info_title() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftTextField),
				"Gift card text field is displayed");
	}

	@And("^user should able to view the place holder text as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_place_holder_text_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftPlaceHolder + strArg1 + "']"),
				strArg1 + " place holder text is displayed");
	}

	@And("^user should able to view the apply button$")
	public void user_should_able_to_view_the_apply_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftApplybutton),
				"Gift card Apply button is displayed");
	}

	@And("^user should able to view information below text field as \"([^\"]*)\"$")
	public void user_should_able_to_view_information_below_text_field_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.paymentTitleNote + strArg1 + "']"),
				strArg1 + " Information is displayed below text field");
	}

	@Then("^user should able to enter the gift card number (.+)$")
	public void user_should_able_to_enter_the_gift_card_number(String activityName, DataTable table) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		String giftCardNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
				dataMap.get("SheetName").get(0), activityName, "GCNumber");
		CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.egiftTextField, giftCardNumber),
				"Gift card Entered as " + giftCardNumber);

	}

	@Then("^user should able to enter the giftcard number and click on apply for four times (.+)$")
	public void user_should_able_to_enter_the_gift_card_number_for_4times(String activityName, DataTable table)
			throws Throwable {
		String strArg1 = "Add Gift Card";
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(table);
		int i = Integer.parseInt(activityName);
		for (int j = 1; j <= i; j++) {
			activityName = Integer.toString(j);
			String giftCardNumber = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "GCNumber");
			System.out.println(giftCardNumber);

			CommonLibrary.Assert(CommonLibrary.clearAndEnterText(CheckoutPageConstants.egiftTextField, giftCardNumber),
					"Gift card Entered as " + giftCardNumber);
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.egiftApplybutton),
					"Gift card Apply button is Clicked");
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.addpromoLink + strArg1 + "']"),
					strArg1 + " Link is Clicked");
			
		}
	}

	@Then("^user should able to click apply button$")
	public void user_should_able_to_click_apply_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.egiftApplybutton),
				"Gift card Apply button is Clicked");
	}

	@Then("^user should able to view the gift card details below payment info section$")
	public void user_should_able_to_view_the_gift_card_details_below_payment_info_title() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftDetails),
				"Gift card detail is displayed below the Pyment title");
	}

	@And("^user should able to view the remove button againt each gift card$")
	public void user_should_able_to_view_the_close_button_againt_each_gift_card() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftRemove),
				"Gift card remove button is displayed");
	}

	@And("^user should able to view the gift cart balance text as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_gift_cart_balance_text_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftBalancetitle + strArg1 + "']"),
				"Title for balance amount is displayed as : " + strArg1);
	}

	@And("^user should able to view the balance amount of the gift card$")
	public void user_should_able_to_view_the_balance_amount_of_the_gift_card() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftBalance),
				"Gift card Balance is displayed below the Pyment title");
	}

	@Then("^user should able to view the balance amount on card as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_balance_amount_on_card_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.egiftBalance, strArg1),
				"Gift card Balance is displayed as :" + strArg1);
	}

	@And("^user should able to click on remove button$")
	public void user_should_able_to_click_on_remove_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.egiftRemove),
				"Gift card remove button is Clicked");
	}

	@Then("^user should able to view the applied gift card is removed$")
	public void user_should_able_to_view_the_applied_gift_card_is_removed() throws Throwable {
		Thread.sleep(3000);
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.egiftBalance),
				"Gift cart has been removed");
	}

	@Then("^user should able to view the info icon$")
	public void user_should_able_to_view_the_info_icon() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftInfoIcon),
				"Gift card info icon is displayed");
	}

	@Then("^user should able to click the info icon and view popup$")
	public void user_should_able_to_click_the_info_icon_and_view_popup() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.egiftInfoIcon),
				"Gift card info icon is clicked");
	}

	@Then("^user should able to view the popup header$")
	public void user_should_able_to_view_the_popup_header() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftPopupHeader),
				"Gift card info Popup header is displayed");
	}

	@Then("^user should able to view the popup content$")
	public void user_should_able_to_view_the_popup_content() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftPopupContent),
				"Gift card info Popup content is displayed");
	}

	@Then("^user should able to view the popup close button$")
	public void user_should_able_to_view_the_popup_close_button() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.egiftPopupClose),
				"Gift card info Popup close button is displayed");
	}

	@When("^user clicks on popup close button info popup gets closed$")
	public void user_clicks_on_popup_close_button_info_popup_gets_closed() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.egiftPopupClose),
				"Gift card info Popup close button is clicked");
	}

	@Then("^user refreshes the pages$")
	public void user_refreshes_the_pages() throws Throwable {
		driver.navigate().refresh();
		System.out.println("User refreshes the page");
	}

	@Then("^user should able to view the applied gift card details get reset$")
	public void user_should_able_to_view_the_applied_gift_card_details_get_reset() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.egiftDetails),
				"Gift card detail get reset");
	}

	@Then("^user should able to view the error message as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_error_message_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.egiftErrorMessage, strArg1),
				"Error Message is diplayed as Expected : " + strArg1);
	}

	@Then("^user should able to view the place holder text \"([^\"]*)\"$")
	public void user_should_able_to_view_the_place_holder_text_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.egiftErrorMessage, strArg1),
				"Place Holder is diplayed as Expected : " + strArg1);
	}
	
	//Payment info Scripts
	
	 @Then("^user should able to view the credit card payment is selected by default$")
	    public void user_should_able_to_view_the_credit_card_payment_is_selected_by_default() throws Throwable {
		 if (CommonLibrary.isElementPresentVerification(CheckoutPageConstants.completeOrderButtonCard) == true) {
			 if (CommonLibrary.isElementPresentVerification(CartPageConstants.closeDialog) == true) {	
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.closeDialog),
						"user closes marketing dialog in footer");
			 }
			}
		 CommonLibrary.Assert(
					CommonLibrary.isElementPresentVerification(CheckoutPageConstants.creditCardExpand),
					"Credit card payment option is selected by default");
	    }

	    @And("^user should able to view the \"([^\"]*)\" payment option$")
	    public void user_should_able_to_view_the_something_payment_option(String strArg1) throws Throwable {
	    	CommonLibrary.Assert(
					CommonLibrary.isElementPresentVerification(CheckoutPageConstants.paymentMethod + strArg1 + "']"),
					strArg1 + " payment method is displayed");
	    }
	    

	    @Then("^user should able to view the affirm one liner as \"([^\"]*)\"$")
	    public void user_should_able_to_view_the_affirm_one_liner_as_something(String strArg1) throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.affirmOneLiner, strArg1),
					"Affirm one liner is displayed as: " + strArg1);
	    }

	    @Then("^user should able to view the splitit one liner as \"([^\"]*)\"$")
	    public void user_should_able_to_view_the_splitit_one_liner_as_something(String strArg1) throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.splititOneLiner, strArg1),
					"Splitit one liner is displayed as: " + strArg1);
	    }
	    

	    @Then("^user should able to expand \"([^\"]*)\" payment option and collapse \"([^\"]*)\" payment option$")
	    public void user_should_able_to_expand_something_payment_option_and_collapse_something_payment_option(String strArg1, String strArg2) throws Throwable {
	    	CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.paymentMethod+strArg1+"']");
	    	CommonLibrary.Assert(
	    	CommonLibrary.isElementPresentVerification(CheckoutPageConstants.paymentOptionExpand1+strArg1+CheckoutPageConstants.paymentOptionExpand2),
	    			strArg1 + " Payment option expanded");
	    	CommonLibrary.Assert(
					CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.paymentOptionExpand1+strArg2+CheckoutPageConstants.paymentOptionExpand2),
					strArg2+" payment option collapsed");
	   
	    }
	    

	    @Then("^user should able to view the total payable amount for \"([^\"]*)\" same as in order summary$")
	    public void user_should_able_to_view_the_total_payable_amount_for_something_same_as_in_order_summary(String strArg1) throws Throwable {
	    	String expectedValue = getElementByProperty(CartPageConstants.subtotalValue, driver).getText();
	    	CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.paymentOptionExpand1+strArg1+CheckoutPageConstants.paymentCartValue, expectedValue),
					strArg1+" cart value is displayed as expected");
	    }
	    

	    @Then("^user should able to view \"([^\"]*)\" wallet icon with text as \"([^\"]*)\"$")
	    public void user_should_able_to_view_something_wallet_icon_with_text_as_something(String strArg1, String strArg2) throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.paymentOptionExpand1+strArg1+CheckoutPageConstants.paymentTabText, strArg2),
					strArg1+" Text is displayed as: "+strArg2);
	    }
	    
	    @Then("^user should able to view the error message for credit card \"([^\"]*)\" field as (.+)$")
		public void user_should_able_to_view_the_error_message_for_creditcard_field(String strArg, String activityName,
				DataTable table) throws Throwable {
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(table);
			int i = Integer.parseInt(activityName);

			for (int j = 1; j <= i; j++) {
				activityName = Integer.toString(j);

				String feild = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
						dataMap.get("SheetName").get(0), activityName, "Feild");

				if (strArg.equalsIgnoreCase(feild)) {
					String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
							dataMap.get("SheetName").get(0), activityName, "Error Message");

					CommonLibrary.Assert(
							CommonLibrary.text_Validation(CheckoutPageConstants.paymentErrMessage + strArg + "']", errMessage),
							"Error message for " + strArg + " is displayed as : " + errMessage);
				}
			}
		}
	    
	    @Then("^user should able to view the error message for invalid credit card \"([^\"]*)\" field as (.+)$")
		public void user_should_able_to_view_the_error_message_for_invalid_creditcard_field(String strArg, String activityName,
				DataTable table) throws Throwable {
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(table);
			int i = Integer.parseInt(activityName);

			for (int j = 19; j <= i; j++) {
				activityName = Integer.toString(j);

				String feild = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
						dataMap.get("SheetName").get(0), activityName, "Feild");

				if (strArg.equalsIgnoreCase(feild)) {
					String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
							dataMap.get("SheetName").get(0), activityName, "Error Message");

					CommonLibrary.Assert(
							CommonLibrary.text_Validation(CheckoutPageConstants.paymentErrMessage + strArg + "']", errMessage),
							"Error message for  invalid  " + strArg + " is displayed as : " + errMessage);
				}
			}
		}
	    
	    @Then("^user should able to view CVV info popup title as \"([^\"]*)\"$")
	    public void user_should_able_to_view_cvv_info_popup_title_as_something(String strArg1) throws Throwable {
	    	
	    	CommonLibrary.Assert(
					CommonLibrary.text_Validation(CheckoutPageConstants.cvvInfoPopupTitle, strArg1),
					"CVV info popup title is displayed as : " + strArg1);
	    }
	    
	    @Then("^user should able to click on CVV info icon$")
	    public void user_should_able_to_click_on_cvv_info_icon() throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.cvvInfoIcon),
					"CVV info icon is clicked");
	    }
	    
	    @Then("^user should able to open affirm popup in payment method$")
	    public void user_should_able_to_open_affirm_popup_in_payment_method() throws Throwable {
	    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CheckoutPageConstants.paymentAffirmPopup),
					"user Clicks link to open affirm popup");
	    }



}
