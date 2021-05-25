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
import com.photon.UIconstants.ExpressCheckoutConstants;
import com.photon.UIconstants.PDPPageConstants;
import com.photon.library.CommonLibrary;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDPSteps extends CommonLibrary {


	public static String Scenario;

	public PDPSteps() throws ConfigurationException, IOException {
		super();

	}

	//Product qualities
	@Then("^user should able to land on PDP page$")
	public void user_should_able_to_land_on_pdp_page() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.PDPpage),
				"User lands on product detail page");
	}

	@Then("^user should able to view the product qualities section$")
	public void user_should_able_to_view_the_product_qualities_section() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.productQualitySection),
				" Product quality Section is displayed");
	}

	@Then("^user should able to view the product quality icon for \"([^\"]*)\"$")
	public void user_should_able_to_view_the_product_quality_icon_for_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.productQualityIcon + strArg1 + "'])[1]"),
				strArg1 + " Product quality icon is displayed");
	}

	@Then("^user should able to view the procut quality text as \"([^\"]*)\" below the icon$")
	public void user_should_able_to_view_the_procut_quality_text_as_something(String strArg1) throws Throwable {
		CommonLibrary.Assert(
				CommonLibrary.text_Validation(
						PDPPageConstants.productQualityIcon + strArg1 + PDPPageConstants.productQualityText, strArg1),
				"Product quality text is displayed as "+strArg1);
	}
	

    @Then("^user should able to click on the \"([^\"]*)\" qualities to open a popup$")
    public void user_should_able_to_click_on_the_something_qualities_to_open_a_pop_up(String strArg1) throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.productQualityIcon + strArg1 + "'])[1]"),
				strArg1 + " Product quality is Clicked");
    }

    @Then("^user should able to view the popup with title \"([^\"]*)\" with logo on left side$")
    public void user_should_able_to_view_the_popup_with_title_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.productQualityIcon + strArg1 + "'])[2]"),
				strArg1 + " Product quality icon is displayed in popup");
    	CommonLibrary.Assert(
				CommonLibrary.text_Validation(
						PDPPageConstants.productQualityIcon + strArg1 + PDPPageConstants.productQualityText, strArg1),
				"Product quality popup title is displayed as "+strArg1);
    }

   
    
    @Then("^user should able to view the popup description$")
    public void user_should_able_to_view_the_popup_description() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.productQualityPopupDesc),
				"Product quality Popup Description is displayed");
    }

    @Then("^user should able to view the Learn More link in popup$")
    public void user_should_able_to_view_the_learn_more_link_in_popup() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.productQualityPopupLearnMoreButton),
				"Product quality Learn More button is displayed");
    }
    
    @Then("^user should able to close the popup to land on PDP page$")
    public void user_should_able_to_close_the_popup_to_land_on_pdp_page() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.productQualityPopupclose),
				" Product quality Popup closed");
    }
    
    @Then("^user should able to Click on learn more button and navigate to confirgured external page$")
    public void user_should_able_to_click_on_learn_more_button_and_navigate_to_confirgured_external_page() throws Throwable {
    	
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.productQualityPopupLearnMoreButton),
				"Product quality learn more button is Clicked");
    	CommonLibrary.switchToNewWindow();
    	String url = driver.getCurrentUrl();
    	
    	if (url.contains("https://purple.com/")) {
    	System.out.println("User is navigated to expected external webpage");
    	} else {
    		throw new Exception ("No new tab found");
    	}
    }
    
    
    //Certified Clean air
    
    @Then("^user should able to view the Certified Clean Air section$")
    public void user_should_able_to_view_the_certified_clean_air_section() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.CCASection),
				"Certified clean air is displayed");
    }

    @Then("^user should able to view the Certified Clean Air section as \"([^\"]*)\"$$")
    public void user_should_able_to_view_the_title_of_the_section_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.text_Validation(PDPPageConstants.CCASectionTitle,strArg1),
				"Certified clean air title is displayed as: "+strArg1);
    }

    @Then("^user should able to view the description below the title$")
    public void user_should_able_to_view_the_description_below_the_title() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.CCASectionDesc),
				"Certified clean air description is displayed");
    }

    @Then("^user should able to view the relevant images to the left of the section$")
    public void user_should_able_to_view_the_relevant_images_to_the_left_of_the_section() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.CCASectionImage),
				"Certified clean air Image section is displayed");
    }

    
    //Product Overview
    
    @Then("^user should able to view the Product Overview section$")
    public void user_should_able_to_view_the_product_overview_section() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.OverviewSection),
				"Product overview section is displayed");
    }

    @Then("^user should able to view the Product Overview section title as \"([^\"]*)\"$")
    public void user_should_able_to_view_the_product_overview_section_title_as_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.text_Validation(PDPPageConstants.OverviewTitle,strArg1),
				"Product overview section title is displayed as: "+strArg1);
    }

    @Then("^user should able to veiw the product Overview description on the left side$")
    public void user_should_able_to_veiw_the_product_overview_description_on_the_left_side() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.OverviewDesc),
				"Product overview Description is displayed on the left side");
    }

    @Then("^user should able to veiw the product Overview Ticklist on the right side$")
    public void user_should_able_to_veiw_the_product_overview_ticklist_on_the_right_side() throws Throwable {
    	CommonLibrary.Assert(
				CommonLibrary.isElementPresentVerification(PDPPageConstants.OverviewTicklist),
				"Product overview Ticklist is displayed on the right side");
    }
    
    
    //Our Promise Section
    
    
    
    //Affirm and splitit section
    
    @Then("^user should able to view splitit and affirm section in product detail page$")
	public void user_should_able_to_view_splitit_and_affirm_section_in_cart_page() throws Throwable {
		CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.affirmSplititSection),
				"Affirm and splitit section is displayed in product detail page");
	}
    
    @When("^user click on \"([^\"]*)\" link for splitit$")
    public void user_click_on_something_link_for_splitit(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClick(PDPPageConstants.splititLearnMoreLink),
				strArg1 + " is Clicked for splitit");
    }

    @Then("^user should able to view splitit logo and description as \"([^\"]*)\"$")
    public void user_should_able_to_view_splitit_logo_description_as_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.splititLogo),
				"Splitit Logo is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(PDPPageConstants.splititDesc, strArg1),
				"splitit section description is displayed as :" + strArg1);
    }

    @Then("^user should able to view \"([^\"]*)\" link for splitit$")
    public void user_should_able_to_view_something_link_for_splitit(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.splititLearnMoreLink),
				strArg1 + " is displayed for Splitit");
    }
    
    @When("^user click on \"([^\"]*)\" link for affirm$")
    public void user_click_on_something_link_for_affirm(String strArg1) throws Throwable {
    	Thread.sleep(5000);
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerifyClickJavaScript(PDPPageConstants.affirmLearnMoreLink),
				strArg1 + " is Clicked for Affirm");
    }

    @Then("^user should able to view affirm logo and description as \"([^\"]*)\"$")
    public void user_should_able_to_view_affirm_logo_and_description_as_something(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.affirmLogo),
				"Affirm Logo is displayed");
		CommonLibrary.Assert(CommonLibrary.text_Validation(PDPPageConstants.affirmDesc, strArg1),
				"Affirm section description is displayed as :" + strArg1);
    }

    @Then("^user should able to view \"([^\"]*)\" link for affirm$")
    public void user_should_able_to_view_something_link_for_affirm(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.affirmLearnMoreLink),
				strArg1 + " is displayed for Affirm");
    }
    
    @Then("^user should able to view the affirm value is fetched with \"([^\"]*)\" text$")
    public void user_should_able_to_view_the_affirm_value_is_fetched_with_something_text(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(PDPPageConstants.payAsLowAs, strArg1),
				"The text Affirm Valud text is displayed as :" + strArg1);
    }

    @And("^the user should able to view \"([^\"]*)\" value$")
    public void the_user_should_able_to_view_something_value(String strArg1) throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.text_ValidationUsingContains(PDPPageConstants.payOnce, strArg1),
				"Pay Once Value is displayed");
    }
    
    @Then("^user should able to view the Vertical line in between$")
    public void user_should_able_to_view_the_vertical_line_in_between() throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementPresentVerification(PDPPageConstants.verticalLine),
				"Vertical line is displayed in between");
    }
    
    @And("^the Affirm and splitit section should not be displayed for the cart value < 100$")
    public void the_affirm_and_splitit_section_should_not_be_displayed_for_the_cart_value_100() throws Throwable {
    	CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(PDPPageConstants.payAsLowAs),
				"Pay As low as is not displayed");
    	CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(PDPPageConstants.splititLogo),
				"Splitit logo is not displayed");
    	CommonLibrary.Assert(CommonLibrary.isElementNotPresentVerification(PDPPageConstants.affirmLogo),
				"Affirm logo is not displayed");
    }


}
