package com.photon.UIconstants;

public class CartPageConstants {


	
	//Login Page Constants

		public static final String closeDialog = "div.scrolled .btn-close~CSS";
		public static final String userName = "//input[@name='email']";
		public static final String CartPageTitle = "//h1[@class='cart-title']";
		public static final String removeProduct = "(//button[contains(@class,'removecart')])[1]";
		public static final String actualCount ="span.actualcount~CSS";
		public static final String headerCartIcon ="img.icon-cart~CSS";
		public static final String emptyCart ="div.emt-cart~CSS";
		public static final String cartQtyError = "div#carterror-totqty~CSS";
		public static Integer totalItemCount =null;

		
		//List of item in cart
		
		public static  String freeProductName =null;
		public static String freePriceAmount = "//*[text()='$0.00']";
		
		public static final String cartIcon ="span.icon-cart~CSS";
		
		public static final String cartProduct ="//h2[contains(text(),'";
		public static final String productInCart ="//h2[text()='";
		public static final String removeCartbutton2 ="')]/parent::div/parent::div/parent::div/parent::div/button";
		public static final String productQty ="')]/following::input[1]";
		public static final String addQuantity1 ="//h2[contains(text(),'";
		public static final String addQuantity2 ="')]/following::div[5]/p/span[contains(@class,'add')]";
		public static final String variantName2 = "')]/following::div[2]/h3";
		public static final String freeGiftSection = "//div[@class='row freegifts-sec']";
		public static final String freeGiftTitle ="//div[text()='";
		public static final String freeGiftQty ="span.nonedit-Qua~CSS";
		public static final String freeGiftProduct ="//div[contains(@class,'freegift-dtl')]/div/div/h3";
		public static final String freeText ="//span[text()='";
		public static final String addAnotherLink ="//a[contains(text(),'";
		public static final String strikeThroughPrice="//h5[contains(@aria-label,'Actual price')]";
		public static final String promoLabelLineitem = "(//*[contains(@class,'ppl-offer-text  ppl-product-label')])[1]";
		public static final String numberOfCartItem = "//h2[@class='product-name']";
		

		
		
		// Promotions Section
		public static final String addpromoLink ="//a[text()='";
		public static final String addpromoLink1 ="a.ppl-promolink~CSS";
		public static final String cartPagePromoSections = "//h3[contains(text(),'";
		public static final String promoCodePlaceholderText = "//label[contains(text(),'Promo')]";
		public static final String promoTextField = "//input[contains(@class,'promocode-input')]";
		public static final String promoTextFieldDisabled = "input.promocode-input[disabled]~CSS";
		public static final String noPromobox = "div.promo-box[style='display: none;']~CSS";
		public static final String applyButton = "button[role=button]~CSS";
		public static final String applyButtonDisabled = "button[disabled]~CSS";
		public static final String promoBoxTitle = "h5.promo-titl~CSS";
		public static final String promoBoxImage = "img.promo-img~CSS";
		public static final String promoBoxDesc = "p.promo-des~CSS";
		public static final String promoClose = "button.promo-close~CSS";
		public static final String promoErrorMessage = "//span[@role='alertdialog']";

		// OrderSummary Section

		public static final String OrderSummaryPromoLineItem = "tr.promo-details~CSS";
		public static final String checkOutBtn = "//span[text()='CHECKOUT']";
		public static final String OSItemCount = "span.item-count~CSS";
		public static final String cartTotal = "td.cart-total~CSS";
		public static final String itemCountfield ="//td[contains(text(),'Item')]";
		public static final String promoLineItem ="td.promo-text~CSS";
		public static final String promoValue ="td.promo-val~CSS";
		public static final String subtotalValue ="h3.subtotal~CSS";
		public static final String yourSavingBox ="//p[contains(text(),'saving')]";
		public static final String preQualifyLink ="p#affirm-prequalify~CSS";//a.affirm-modal-trigger~CSS";
		public static final String EMIValue ="span.affirm-ala-price~CSS";
		public static final String affirmPopup ="//p[contains(text(),'saving')]";
		public static final String affirmPopupClose ="div.preK2V3mZfR  button#close-button div~CSS";
		public static final String affirmPopupClose1 ="button#affirm-primary-action-button~CSS";
		public static final String estShipping ="//td[text()=' Shipping']";
		public static final String whiteGloveFree ="//td[contains(text(),'qualified')]";
		public static final String noPromoLineItem ="td.promo-text[style*=none]~CSS";

		
		//Empty Cart and Affirm Marketing section
		public static final String afffirmDesc = "//p[contains(text(),'Pay as low')]";
		public static final String continueShoppingBtn = "//a[contains(text(),'CONTINUE')]";
		
		//Our Promise Section
		
		public static final String ourPromiseSection = "h5.our-promise~CSS";
		public static final String ourPromiseTitle = "//span[text()=' ";
		public static final String ourPromiseIcon = "//img[@alt='";
		public static final String ourPromiseIconText = "//p[text()='";
		
		
		//Customer service section
		public static final String csChatLink = "a.cart-email~CSS";
		public static final String csChatIcon = "//img[@alt='chat-icon']";
		public static final String csCustomerNumberIcon = "//img[@alt='phone-icon']";
		public static final String csCustomerNumberLink1 = "(//a[@class='cart-phone'])[1]";
		public static final String csCustomerNumberLink2 = "(//a[@class='cart-phone'])[2]";
		
		
		//Variant Popup Section
		
		public static final String editLink = "')]/following::button[1][text()='Edit']";
		public static final String popupTitle = "div.show .cart-pop-title~CSS";
		public static final String popupImage= "div.show .pop-pro-img~CSS";
		public static final String closePopup = "div.show .icon-close~CSS";
		public static final String popupUpdateButton = "div.show .variantupdate~CSS";
		public static final String popupSizeDD = "div.show #size~CSS";
		public static final String popupColorSection = "div.show .slider-color-choose~CSS";
		public static final String popupColorSelection = "//div[contains(@class,'charcoalGrey')]";//"div.show #pop_charcoalGrey~CSS";
		public static final String popupPrice = "div.show .pop-update-price~CSS";
		public static final String viewPoductLink = "div.show .pop-pro-img a~CSS";
		public static final String popupPoductName = "div.show h2~CSS";
		
		
		//Affirm and Splitit section
		public static final String affirmSplititSection = "div.ppl-payment-container~CSS";
		public static final String affirmSplititTitle = "div.ppl-payment-title~CSS";
		public static final String affirmSplititDesc = "div.ppl-payment-para~CSS";
		public static final String splititLogo = "//img[@alt='Splitit logo']";
		public static final String splititDesc = "//img[@alt='Splitit logo']/following::p[1]";
		public static final String splititLearnMoreLink = "//img[@alt='Splitit logo']/following::span[1]";
		public static final String affirmLogo = "//img[@alt='Affirm logo']";
		public static final String affirmDesc = "//img[@alt='Affirm logo']/following::p[1]";
		public static final String affirmLearnMoreLink = "//img[@alt='Affirm logo']/following::span[1]";
		public static final String splititpopup = "//img[@alt='spilit']";
		public static final String affirmpopup = "div#iframe-child~CSS";
		public static final String splititpopupClose = "button.close~CSS";
		public static final String affirmpopupClose = "(//button[@id='close-button'])[1]/div";
		 
		
		//Cart promo labels
		public static final String cartProductGiftIcon = "div.d-md-flex img~CSS";
		public static final String cartPromoLabel = "(//span[contains(@class,'ppl-product-label')])[1]";
		
		//AOV Section
		public static final String cartAOVSection = "div.promotionindex_0~CSS";
		public static final String cartAOVLineitem = "div.promo-item";
		public static final String addAOVLineitem = "button.add-bundle-promo-product~CSS";
		public static final String strikethroughPriceAOVLineitem = "(//*[contains(@class,'ppl_promt')])[3]";
		public static final String promoLabelAOVLineitem = "(//*[contains(@class,'ppl-offer-text  ppl-product-label')])[3]";
		public static final String addAOVItem = "(//*[@class='ppl-btn-text' and text()='+ ADD'])[3]";
		
		
		

	
}
