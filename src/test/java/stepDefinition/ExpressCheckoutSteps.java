package stepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.configuration.ConfigurationException;
import com.photon.UIconstants.CartPageConstants;
import com.photon.UIconstants.CheckoutPageConstants;
import com.photon.UIconstants.ExpressCheckoutConstants;
import com.photon.library.CommonLibrary;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExpressCheckoutSteps extends CommonLibrary {

	static boolean StartAftermethod = false;
	public int i = 1;
	public static String Username;
	public static String Password;

	public static String Scenario;

	public ExpressCheckoutSteps() throws ConfigurationException, IOException {
		super();

	}

	 @Then("^user should able to view the options for \"([^\"]*)\" under Express Checkout section$")
	    public void user_should_able_to_view_the_options_for_something_under_express_checkout_section(String strArg1) throws Throwable {
		 CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(ExpressCheckoutConstants.expressCheckoutButtons+strArg1+"']"),
					strArg1 + " Button in Express checkout is displayed");
	    }

	 @Then("^user should able to click on \"([^\"]*)\" button in express checkout$")
	    public void user_should_able_to_click_on_something_button_in_express_checkout(String strArg1) throws Throwable {
		 CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.expressCheckoutButtons+strArg1+"']"),
					strArg1 + " Button in Express checkout is Clicked");
	    }

	   
	    
	    @Then("^user should able to login to amazon account (.+)$")
		public void user_should_able_to_login_to_amazon_account_something(String activityName, DataTable table)
				throws Throwable {
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(table);
			String userName = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "Username");
			String passWord = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "Password");
		
			mainWindow = CommonLibrary.getMainWindow();
			CommonLibrary.switchToNewWindow();
			CommonLibrary.Assert(CommonLibrary.clearAndEnterText(ExpressCheckoutConstants.amazonEmail, userName),
					"Amazon Username Entered");
			CommonLibrary.Assert(CommonLibrary.clearAndEnterText(ExpressCheckoutConstants.amazonPass, passWord), "Amazon Password Entered");
			 CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonSubmitButton),
						"Amazon Submit button is clicked");
			 
			CommonLibrary.switchToMainWindow();

	    }

	@Then("^user should able to view the amazon widget with title as \"([^\"]*)\"$")
	public void user_should_able_to_view_the_amazon_widget_with_title_as_something(String strArg1) throws Throwable {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		CommonLibrary.switchtoFrame(ExpressCheckoutConstants.amazonAddressWidgetFrame);
		CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(ExpressCheckoutConstants.amazonAddressWidgetTitle, strArg1),
				"Widget title is displayed as " + strArg1);
	}
	
	  @Then("^user should able to select the valid address from address book$")
	    public void user_should_able_to_select_the_valid_address_from_address_book() throws Throwable {
		CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonaddressChange);
		
		CommonLibrary.switchToNewWindow();
		Thread.sleep(5000);
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonaddressSelect),
				"Valid address selected from amazon widget");
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonaddressSubmit),
				"Done Button clicked on amazon widget");
		
		CommonLibrary.switchToMainWindow();
	}
	  
	  @Then("^user should able to select the invalid address from address book$")
	    public void user_should_able_to_select_the_invalid_address_from_address_book() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonInvalidaddressSelect),
				"Non USA address selected from amazon widget");
		CommonLibrary.switchToMainWindow();
	}
	  
	  @Then("^user should able to view the error message below widget as (.+)$")
	    public void user_should_able_to_view_the_error_message_below_widget_as(String activityName,
				DataTable table) throws Throwable {
				Map<String, List<String>> dataMap = null;
				dataMap = CommonLibrary.getHorizontalData(table);
				String errMessage = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
						dataMap.get("SheetName").get(0), activityName, "Error Message");

				CommonLibrary.Assert(CommonLibrary.text_Validation(ExpressCheckoutConstants.amazonNonUSaddressError, errMessage),
						"Error message is displayed as : " + errMessage);

	    }
	  
	  
	  @Then("^user should able to view the payment method will be auto selected to amazon pay and payment widget is displayed$")
	    public void user_should_able_to_view_the_payment_method_will_be_auto_selected_to_amazon_pay_and_payment_widget_is_displayed() throws Throwable {
	       
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.amazonPaymentWidget),
					"Widget title is displayed as ");
	    }
	  
	  @Then("^user should able to view the amazon payment widget with title as \"([^\"]*)\"$")
		public void user_should_able_to_view_the_amazon_payment_widget_with_title_as_something(String strArg1) throws Throwable {
			CommonLibrary.switchtoFrame(ExpressCheckoutConstants.amazonPaymentWidgetFrame);
			CommonLibrary.Assert(CommonLibrary.text_Validation(ExpressCheckoutConstants.amazonPaymentWidgetTitle, strArg1),
					"Payment Widget title is displayed as " + strArg1);
			CommonLibrary.switchToMainWindow();
			
		}
	  
	  
	  //Paypal
	  
	  
	    @Then("^user should able to login to paypal account (.+)$")
		public void user_should_able_to_login_to_paypal_account_something(String activityName, DataTable table)
				throws Throwable {
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(table);
			String userName = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "Username");
			String passWord = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0),
					dataMap.get("SheetName").get(0), activityName, "Password");
		
			CommonLibrary.Assert(CommonLibrary.clearAndEnterText(ExpressCheckoutConstants.paypalUsername, userName),
					"Paypal Username Entered");
			CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.paypalNextButton),
					"Next button is clicked in the paypal site login page");
			CommonLibrary.Assert(CommonLibrary.clearAndEnterText(ExpressCheckoutConstants.paypalPassword, passWord), "Paypal Password Entered");
			 CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(ExpressCheckoutConstants.paypalLoginButton),
						"Paypal Submit button is clicked");
			 

	    }

	  
	  //88888888888888*************************888888888888888888888*****************************888888888888888888888*************
	  
	  
		 
						
		
				
		 @Then("^user should be successfully logged in to paypal site$")
			public void user_should_be_successfully_logged_in_to_paypal_site() throws Throwable {
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(ExpressCheckoutConstants.paypalShipTo),
						"successfully logged in to paypal site");
		 }
		 
		 @Then("^user should able to view the Ship to address from paypal$")
		    public void user_should_able_to_view_the_ship_to_address_from_paypal_site_as_something() throws Throwable {
			 String address = getElementByProperty(ExpressCheckoutConstants.paypalShipTo, driver).getText().replace('\n', ' ');
			 String[] parts = address.split(",");
			 ExpressCheckoutConstants.paypalAddress = parts[0];
			
		    }

		 @Then("^user should able to click the Continue button in the paypal site$")
			public void user_clicks_on_the_continue_button_in_the_paypal_site_login_page() throws Throwable {
				
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClickJavaScript(ExpressCheckoutConstants.paypalContinueButton),
						"user should able to click the Continue button in the paypal site");
				
		 }
		 
		 @Then("^user should able to view the address from paypal will be pre populated in the checkout page$")
		    public void user_should_able_to_view_the_address_from_paypal_will_be_pre_populated_in_the_checkout_page_as_something() throws Throwable {
				
				 CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.billingAddress, ExpressCheckoutConstants.paypalAddress),
							"Firstname, Lastname and address from paypal is pre populated in the checkout page");
				 
		    }
		 
		 @Then("^user should able to view the payment method will be auto selected to paypal in checkout page$")
		 	public void user_should_be_able_to_view_the_paypal_payment_method_auto_selected_in_checkout_page() throws Throwable {
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(ExpressCheckoutConstants.paypalPaymentTabSelected),
						"Paypal payment method is auto selected in checkout page");
		 }

		 @When("^user click on Cart Icon$")
			public void user_click_on_cart_icon() throws Throwable {
			 	CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.cartIcon),
						"Cart Icon is clicked in the Checkout page");
			 	Thread.sleep(5000);
		 }
	
		 
		 @When("^user navigates again to \"([^\"]*)\" page$")
		 	public void user_goes_out_of_the_checkout_page_and_comes_back_to_the_checkout_page(String strArg1) throws Throwable {
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(CartPageConstants.checkOutBtn),
						"User should able to click check out button");
				CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.CheckoutPageTitle),
						"User lands on Checkout page");
				CommonLibrary.Assert(CommonLibrary.text_Validation(CheckoutPageConstants.CheckoutPageTitle, strArg1),
						"The Title of the Checkout page is displayed as:  " + strArg1);
			}
		 
		 @Then("^user should able to see all information already entered should be retained in the checkout page$")
		    public void user_should_able_to_see_address_and_paypal_payment_should_be_retained_in_the_checkout_page_as_something() throws Throwable {
			 CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(CheckoutPageConstants.billingAddress, ExpressCheckoutConstants.paypalAddress),
						"Shipping info is retained when user navigates again to checkout page");
				 CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(CheckoutPageConstants.paypalPaymentTabSelected),
							"Paypal payment method is auto selected in checkout page");
				 CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(CheckoutPageConstants.CreditCardFieldSection),
							"Credit Card field is not enabled in checkout page");
		    }
	
		

}
