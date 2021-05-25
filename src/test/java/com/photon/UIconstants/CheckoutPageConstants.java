package com.photon.UIconstants;


public class CheckoutPageConstants {	


//Login Page Constants
	
	
	
	public static final String CheckoutPageTitle ="//h1[contains(text(),'Checkout')]";
	
	
	
	
	//Delivery Info
	public static final String firstName ="edit-first-name~ID";
	public static final String lastName ="edit-last-name~ID";
	public static final String address1 ="route~ID";
	public static final String address2 ="edit-address-aparment-suite~ID";
	public static final String city ="locality~ID";
	public static final String zipCode ="postal_code~ID";
	public static final String statedropdown ="//select[@name='address_state']";
	public static final String stateSelect ="edit-first-name";
	public static final String phoneNumber ="telephone~ID";
	public static final String email ="input#edit-email~CSS";
	public static final String promoEmailCheckbox ="label.ppl-checkbox-label~CSS";
	
	public static final String fieldLabel ="(//input/following::label[text()='";
	public static final String dropdownLabel ="(//select/following::label[text()='";
	public static final String popupTitle ="//h2[text()=' ";
	public static final String popupmessage ="//p[text()='";
	public static final String addressPopup ="div.sa-taitle~CSS";
	public static final String addressOriginal ="address#original-address~CSS";
	public static final String addressSuggest ="address#suggestion-address~CSS";
	public static final String addressConfirm ="a.use-confim-add-btn~CSS";

	
	//Error Message Shipping Info
	public static final String errMessage ="//div[@class='error-msg' and @id='err_";
	public static final String errFirstName ="//div[@class='error-msg' and @id='err_firstname']";
	public static final String errLastName ="//div[@class='error-msg' and @id='err_lastname']";
	public static final String errAddress1 ="//div[@class='error-msg' and @id='err_address']";
	public static final String errCity ="//div[@class='error-msg' and @id='err_city']";
	public static final String errZipcode ="//div[@class='error-msg' and @id='err_zipcode']";
	public static final String errState ="//div[@class='error-msg' and @id='err_state']";
	public static final String errPhone ="//div[@class='error-msg' and @id='err_phone']";
	public static final String errEmail ="//div[@class='error-msg' and @id='err_email']";
	
	
	//Payment Methods
	public static final String paymentTitleNote ="//p[text()='";
	public static final String paymentMethod ="//a[@id='";
	public static final String paymentOptionExpand1 ="div#";
	public static final String paymentOptionExpand2 =".active~CSS";
	public static final String creditCardExpand ="div#card.active~CSS";
	public static final String affirmExpand ="div#affirm.active~CSS";
	public static final String splititExpand ="div#splitit.active~CSS";
	public static final String paypalExpand ="div#paypal.active~CSS";
	public static final String amazonpayExpand ="div#amazonpay.active~CSS";
	public static final String affirmOneLiner ="a#affirm-tab .ppl-aff-desc~CSS";
	public static final String splititOneLiner ="a#splitit-tab .ppl-aff-desc~CSS";
	public static final String paymentCartValue =" .cart-display-amt~CSS";
	public static final String paymentErrMessage ="//div[@class='error-msg' and @id='err-";
	public static final String paymentTabText ="-tab .pay-with p~CSS";
	public static final String paymentAffirmPopup ="span.ppl-affirm-value-content~CSS";
	public static final String paymentSplititPopup ="p.ppl-split-link~CSS";
	public static final String cvvInfoIcon ="span.creditCartInfoDetails~CSS";
	public static final String cvvInfoPopupTitle ="div.show h5.creditCartInfo~CSS";
	
	
	
	
	
	
	
	//Select Shipping Method
	
	public static final String shippingMethodTitle ="//p[contains(text(),'";
	public static final String deliveryMethod ="//div[@id='deliveryMethods']";
	public static final String smallShippingMethod ="//div[@class='shippingMethods-fedex-eligible shippingMethods']/div";
	public static final String largeShippingMethod ="//div[@class='shippingMethods-whiteglove-eligible']/div/div";
	public static final String faceMaskShippingMethod ="//div[@class='shippingMethods-express-delivery']/div/div";
	public static final String freeShippingMethod ="//div[@class='shippingMethods-scheduled-delivery shippingMethods']/div[1]";
	public static final String DeliveryMethodSpinner  ="//div[@class='ppl-spinner' and @id='updating-delivery-option-spinner']";
	public static final String defaultShippingTitle  ="//div[@class='lineItems-free-shipping']/h5";
	public static final String groundShippingLargeItems ="//label[@for='shipping-method_scheduled-delivery_0']/div[1]/p";
	public static final String groundShippingSmallItems ="//label[@for='shipping-method_fedex-eligible_0']/div[1]/p";
	public static final String fedexShippingSmallItems ="//label[@for='shipping-method_fedex-eligible_0']/div[1]/span";
	public static final String thumbnailImage ="(//div/img[contains(@alt,'";
	public static final String thumnailProductname = "')])[2]/following::p[1]";
	public static final String freeShippingMethod1 ="//div[@class='shippingMethods-scheduled-delivery shippingMethods']/following::div[@class='check-price']";
	public static final String smallItemInfoIcon ="div.lineItems-fedex-eligible h5 span.icon-info~CSS";
	public static final String largeItemInfoIcon ="div.lineItems-scheduled-delivery h5 span.icon-info~CSS";
	public static final String largeItemInfoPopup ="#scheduled-deliveryInfoModel.show .modal-content~CSS";
	public static final String infoPopupTitle ="div#scheduled-deliveryInfoModel h3~CSS";
	public static final String infoPopupContent ="#scheduled-deliveryInfoModel.show p:nth-of-type(2)~CSS";
	public static final String infoPopupClose ="div.show .pop-close-btn~CSS";
	public static final String DeliveryMethodError ="//div[@class='alert alert-danger error delivery-method-not-get']";
	public static final String NoshoppingAlert ="span#err-msg-delivery-method-no-response~CSS";
	public static final String errDisappear ="div.delivery-method-not-get.d-none";
	public static final String samllItemsShippingMethod ="div.shippingMethods-nonExpedited-shipping~CSS";
	public static final String inHomeSetupShippingMethod ="(//label[@for='shipping-method_whiteglove-eligible_0'])[1]";
	public static final String standardShipping ="(//label[@for='shipping-method_whiteglove-eligible_2'])[1]";
	
	
	
	//Complete Order
	public static final String completeOrderButton ="input#edit-checkoutbutton~CSS";
	public static final String completeOrderButtonCard="#card-submit~CSS";
	//Tepm variable added for affirm  payment
	//public static final String completeOrderButton ="#edit-checkoutbutton~CSS";
	
	//Affirm Payment Details
	public static final String affirmValidNumber ="input[name='phone']~CSS";
	public static final String continueButton ="(//button[@type='submit'])[2]";
	public static final String continueButton1 ="confirm-submit~ID";
	public static final String pinInput ="input[data-testid='phone-pin-field']~CSS";
	public static final String emiMonths ="//span[text()='12']";
	public static final String autoPaybutton ="//label[@for='autopay-toggle']";
	public static final String tncCheckBox = "//label[@for='confirm-disclosure-checkbox']";
	
	//Credit Card details
	public static final String creditCardDetails ="//input[@aria-label='";
	
	//Splitit payment details
	
	public static final String splititCCNumber ="input#cc-number~CSS";
	public static final String splititCCExp ="input#cc-exp-date~CSS";
	public static final String splititCCCVV ="input#cc-cvc~CSS";
	public static final String splititEmail ="//input[@type='email']";
	public static final String expandBillingSec ="//div[text()='Billing Address']";
	public static final String splititTandC ="div.splitit-checkbox use~CSS";
	public static final String splititpayButton ="//button[text()='Pay']";
	
	
	//Cart Summary Section
	public static final String productInCartSummary ="//h5[contains(text(),'";
	public static final String cartSummaryTitle ="//h3[text()='";
	public static final String totalItemCount ="div.cart-tot-count~CSS";
	public static final String cartSummaryProdPrice ="')]/following::div[1]/p";
	public static final String cartSummaryStrikePrice ="')]/following::div[1]/span[1]";
	public static final String cartSummaryProdVariant ="')]/following-sibling::p";
	public static final String cartSummaryFreeGiftSec ="')]/following::div[2]/div[@class='gifts-mattress-checkout']";
	public static final String cartSummaryFreeGiftFreeText ="']/following::div[2]/div[@class='gifts-mattress-checkout']/following::div[6]/p[@class='amount']";
	public static final String cartSummarystrikePrice ="']/following::div[2]/div[@class='gifts-mattress-checkout']/following::div[6]/span[@class='actual-amount']";
	public static final String cartSummaryShipcost ="span.ship-cost~CSS";
	public static final String cartSummaryShipamt ="span.shipp-amt~CSS";
	public static final String cartSummaryRecyclingfee ="//span[text()='Recycling fee']";
	public static final String cartSummaryRecyclingfeeAmt ="span.re-fee-amt~CSS";
	public static final String estShipping ="//span[contains(text(),' Estimated Shipping ')]";
	public static double recyclingfee;
	
	
	//Gift Card Section
	
	public static final String egiftTextField ="input.giftcard-input~CSS";
	public static final String egiftPlaceHolder ="//label[text()='";
	public static final String egiftApplybutton ="button.gift-btn-apply~CSS";
	public static final String egiftDetails ="div.ppl-giftcard~CSS";
	public static final String egiftBalancetitle ="//h5[text()='";
	public static final String egiftBalance ="p.ppl-gift-balace~CSS";
	public static final String egiftRemove ="button.gift-close~CSS";
	public static final String egiftInfoIcon ="span.icon-info.giftCardInfoDetails~CSS";
	public static final String egiftPopup ="div.show .modal-content~CSS";
	public static final String egiftPopupHeader ="div.show .modal-header~CSS";
	public static final String egiftPopupContent ="div.show .modal-body~CSS";
	public static final String egiftPopupClose ="div.show .icon-close~CSS";
	public static final String egiftErrorMessage ="div.ppl-zeropayment p~CSS";
	public static final String egiftZeroPayment ="div.ppl-zeropayment p~CSS";
	
	
	//Billing address
	
	public static final String billingAddress = "address#billing-address~CSS";
	public static final String billingAddressCheckbox = "label.checkbox~CSS";
	
	public static final String paypalPaymentTabSelected = "#checkout-form #paymentTab div.card-header[class$='active']#paypal~CSS";
	public static final String CreditCardFieldSection = "#card-tab #cardSection";
	
	
	
	
	
	
	
	
	
}
