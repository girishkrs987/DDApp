package com.photon.UIconstants;

public class ExpressCheckoutConstants {

	//Express Checkout
	
		public static final String expressCheckoutButtons ="//a[@aria-label='";	
		
		
	//Amazon Express Checkout 
		
		public static final String amazonEmail ="input#ap_email~CSS";
		public static final String amazonPass ="input#ap_password~CSS";
		public static final String amazonSubmitButton ="input#signInSubmit~CSS";
		public static final String amazonAddressWidgetFrame ="OffAmazonPaymentsWidgets1IFrame";
		public static final String amazonPaymentWidgetFrame ="OffAmazonPaymentsWidgets2IFrame";
		public static final String amazonAddressWidgetTitle ="//h2[@role='heading']";
		public static final String amazonPaymentWidgetTitle ="//div[@data-ng-controller='walletCtrl']/div/h1";
		public static final String amazonPaymentWidget ="div#OffAmazonPaymentsWidgets2~CSS";
		public static final String amazonaddressChange ="a.change-link~CSS";
		public static final String amazonaddressSelect ="//strong[text()='Jack S.']";
		public static final String amazonaddressSubmit ="button.a-button-text~CSS";
		public static final String amazonInvalidaddressSelect ="//strong[text()='Jane D.']";
		public static final String amazonNonUSaddressError ="div#amazon-errors~CSS";
		
		
		//Express Checkout
		public static  String paypalAddress =null;
		public static final String expresscheckoutTitle ="div[class$='exp-checkout'] div [title='Express Checkout']~CSS";
		public static final String amazonButton = "#checkout-form a[class^='amazon'][role='button']~CSS";
		public static final String paypalButton = "#checkout-form a[class^='paypal'][role='button']~CSS";
		public static final String paypalpage = "//h1[contains(text(),'Pay with PayPal')]";
		public static final String paypalUsername = "#login[data-title='Log in to your PayPal account'] input[id='email']~CSS";
		public static final String paypalNextButton = "#login[data-title='Log in to your PayPal account'] button[id='btnNext']~CSS";
		public static final String paypalPassword = "#login[data-title='Log in to your PayPal account'] input[id='password']~CSS";
		public static final String paypalLoginButton = "#login[data-title='Log in to your PayPal account'] button[id='btnLogin']~CSS";
		public static final String paypalShipTo = "#memberReview #shippingAddress div.addressDisplay~CSS";
		public static final String paypalChangeShipToLink = "#memberReview #shippingAddress a[class*='changeShipping']~CSS";
		public static final String paypalContinueButton = "#memberReview div#button input[class*='continueButton']~CSS";
		public static final String paypalSelectShippingTab = "#selectShipping div.asideContent span.full-address~CSS";
		public static final String paypalSelectShippingContent = "#selectShipping div.asideContent .shippingBlk~CSS";
		
		public static final String paypalPaymentTabSelected = "#checkout-form #paymentTab div.card-header[class$='active']#paypal~CSS";
		public static final String CreditCardFieldSection = "#card-tab #cardSection";
		
	

}
