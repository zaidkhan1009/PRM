package pageActions.doctorDashboard;

import com.aventstack.extentreports.Status;
import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.ProductSalePage;
import pages.doctorDashboard.SubscriberListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductSalePageActions extends BaseClass {

	final public static int highlight_Products_In_Listing = 120;
	final public static int stop_highlighting_Products_In_Listing = 180;
	final public static int remove_Near_expiry_product_from_listing = 30;

	static Login Login = PageFactory.initElements(driver, Login.class);
	static ProductSalePage productSalePage = PageFactory.initElements(driver, ProductSalePage.class);

	public static boolean isProductSaleTabDisplayed() {
		waitTillLoaderDisappear();

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "CHecking ProductSale Tab is Displayed");
		BaseClass.waitForElementToBeClickable(productSalePage.getProductSalesTab());
		return productSalePage.getProductSalesTab().isDisplayed();

	}

	public static void clickOnProductSaleTab() {
		BaseClass.waitForElementToBeClickable(productSalePage.getProductSalesTab());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "Clicking on ProductSale Tab");
		productSalePage.getProductSalesTab().click();
	}

	public static boolean verifyPatientNameField() {
		BaseClass.waitForElementToBeClickable(productSalePage.getPatientName());
		boolean isPlaceHolderDisplayed = productSalePage.getPatientName().getAttribute("placeholder")
				.contains("» enter patient name*");
		boolean isPatientNameFieldDisplayed = checkWebElementIsDisplayed(productSalePage.getPatientName());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "Checking PatientName field and placeholder in PatientName field on Product listing");
		return isPlaceHolderDisplayed && isPatientNameFieldDisplayed;
	}

	public static boolean verifyMobileNumberField() {
		BaseClass.waitForElementToBeClickable(productSalePage.getPatientMobile());
		boolean isPlaceHolderDisplayed = productSalePage.getPatientMobile().getAttribute("placeholder")
				.contains("» enter patient mobile*");
		boolean isPatientMobileNumberDisplayed = checkWebElementIsDisplayed(productSalePage.getPatientMobile());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "Checking MobileNumber field and placeholder in MobileNumber field on Product listing");
		return isPatientMobileNumberDisplayed && isPlaceHolderDisplayed;
	}

	public static boolean verifyPatientIdField() {
		BaseClass.waitForElementToBeClickable(productSalePage.getPatientId());
		boolean isPlaceHolderDisplayed = productSalePage.getPatientId().getAttribute("placeholder")
				.contains("» enter patient id");
		boolean isPatientMobileNumberDisplayed = checkWebElementIsDisplayed(productSalePage.getPatientMobile());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "Checking PatientID field and placeholder in PatientId field on Product listing");
		return isPatientMobileNumberDisplayed && isPlaceHolderDisplayed;
	}

	public static boolean verifyPatientEmailIdField() {
		BaseClass.waitForElementToBeClickable(productSalePage.getPatientEmailId());
		boolean isPlaceHolderDisplayed = productSalePage.getPatientEmailId().getAttribute("placeholder")
				.contains("» enter patient email");
		boolean isPatientEmailFieldDisplayed = checkWebElementIsDisplayed(productSalePage.getPatientEmailId());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "Checking PatientEmail field and placeholder in PatientEmail field on Product listing");
		return isPlaceHolderDisplayed && isPatientEmailFieldDisplayed;
	}

	public static boolean checkSaveButton() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getSaveButton());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "clicking on Save button on Product Listing");
		return checkWebElementIsDisplayed(productSalePage.getSaveButton());
	}

	public static boolean checkCancelButton() {
		BaseClass.waitForElementToBeClickable(productSalePage.getCancelButton());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "clicking on Cancel button on Product Listing");
		return checkWebElementIsDisplayed(productSalePage.getCancelButton());
	}

	public static boolean checkResetButton() {
		BaseClass.waitForElementToBeClickable(productSalePage.getResetButton());

		// changing LogStatus to Status for newer functionality
		logger.log(Status.INFO, "clicking on reset button on Product Listing");
		return checkWebElementIsDisplayed(productSalePage.getResetButton());
	}

	public static boolean checkSearchProduct() {
		waitTillLoaderDisappear();
		BaseClass.waitForElementToBeClickable(productSalePage.getSearchProducts());
		boolean isPlaceHolderDisplayed = productSalePage.getSearchProducts().getAttribute("placeholder")
				.contains("» search by name and batch");
		// ExtentReport extentReport=new ExtentReport (BaseClass,"Checking
		// searchProducts field and placeholder of searchProducts field On Product
		// Listing");
		return checkWebElementIsDisplayed(productSalePage.getSearchProducts()) && isPlaceHolderDisplayed
				&& productSalePage.getSearchProductButton().isDisplayed();
	}

	public static boolean noProductFoundErrMsg() {
		BaseClass.waitForElementToBeClickable(productSalePage.getNoProductFoundMsg());
		return productSalePage.getNoProductFoundMsg().isDisplayed();

	}

	public static void searchProductByNameAndBatch(String searchDetails) {
		BaseClass.waitForElementToBeClickable(productSalePage.getSearchProducts());
		productSalePage.getSearchProducts().clear();
		productSalePage.getSearchProducts().sendKeys(searchDetails);

	}

	public static void clickOnSaveButton() {
		clickOnWebElement(productSalePage.getSaveButton());
	}

	public static void clickOnCancelButton() {
		clickOnWebElement(productSalePage.getCancelButton());
	}

	public static void clickOnResetButton() {
		clickOnWebElement(productSalePage.getResetButton());
	}

	public static void enterPatientName(String name) {
		enterText(productSalePage.getPatientName(), name);

	}

	public static void enterMobileNumber(String mobileNumber) {
		enterText(productSalePage.getPatientMobile(), mobileNumber);

	}

	public static void enterPatientId(String id) {

		enterText(productSalePage.getPatientId(), id);
	}

	public static void enterPatientEmail(String email) {
		enterText(productSalePage.getPatientEmailId(), email);
	}

	public static void enterSearchedDetails(String searchDetail) {
		enterText(productSalePage.getSearchProducts(), searchDetail);
	}

	public static boolean verifyEnterPatientNameErrorMsg() {
		try {
			BaseClass.WaitTillElementIsPresent(productSalePage.getEnterNameErrMsg());
			return productSalePage.getEnterNameErrMsg().isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;
		}

	}

	public static boolean verifyEnterPatientMobileNumberErrorMsg() {
		try {
			BaseClass.WaitTillElementIsPresent(productSalePage.getEnterMobileErrMsg());
			return productSalePage.getEnterMobileErrMsg().isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;

		}

	}

	public static boolean verifyAddProductErrMsg() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getAddProductErrorMsg());
		return productSalePage.getAddProductErrorMsg().isDisplayed();
	}

	public static boolean verifyEnterTenDigitMobileNumberErrMsg() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getEnterTenDigitMobileNumberErrMsg());
		return productSalePage.getEnterTenDigitMobileNumberErrMsg().isDisplayed();
	}

	public static boolean verifyEnterValidMobileNumberErrMsg() {
		try {
			BaseClass.WaitTillElementIsPresent(productSalePage.getEnterValidMobileNumberErrMsg());
			return productSalePage.getEnterValidMobileNumberErrMsg().isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;
		}

	}

	public static boolean verifyEnterValidEmailErrorMsg() {
		try {
			BaseClass.WaitTillElementIsPresent(productSalePage.getEnterValidEmailErrMsg());
			return productSalePage.getEnterValidEmailErrMsg().isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	public static boolean verifyProductSearchByName(String productName) {
		boolean isProductShowingRelatedToSearch = false;
		productName = productName.toLowerCase();
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		for (WebElement product : productSalePage.getListOfProduct()) {
			WebElement elements = product.findElement(By.xpath("div/div[contains(@class,'product-info')]/h5"));
			String actualProductName = elements.getText().trim().toLowerCase();
			if (actualProductName.contains(productName)) {
				isProductShowingRelatedToSearch = true;
			} else {
				isProductShowingRelatedToSearch = false;
			}
		}

		return isProductShowingRelatedToSearch;
	}

	public static boolean verifyProductSearchByBatchNumber(String itemBatchNumber) {
		boolean isProductShowingRelatedToSearch = false;
		itemBatchNumber = itemBatchNumber.toLowerCase();
		for (WebElement product : productSalePage.getListOfProduct()) {
			WebElement elements = product.findElement(By.xpath(
					"div/div[contains(@class,'product-info')]/div[contains(@class,'batch_expiry_info')]/span[1]"));
			String actualProductName = elements.getText().trim().toLowerCase();
			if (actualProductName.contains(itemBatchNumber)) {
				isProductShowingRelatedToSearch = true;
			} else {
				isProductShowingRelatedToSearch = false;
			}
		}
		return isProductShowingRelatedToSearch;

	}

	public static String getPatientName() {
		String patientName = getEnteredText("patientname");
		return patientName;

	}

	public static String getPatientMobile() {
		String patientMobile = getEnteredText("mobile");
		return patientMobile;

	}

	public static String getPatientId() {
		String patientId = getEnteredText("patientid");
		return patientId;

	}

	public static String getPatientEmail() {
		String patientEmail = getEnteredText("email");
		return patientEmail;

	}

	public static boolean verifyProductSelectedOnListing(String productName, String batchNumber) {
		WebElement element = driver.findElement(By.xpath("//div/span[contains(text(),'" + batchNumber
				+ "')]/../preceding-sibling::h5[contains(text(),'" + productName + "')]/../.."));
		BaseClass.WaitTillElementIsPresent(element);
		if (element.getAttribute("class").contains("selected")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean verifyProductListingData() {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		boolean isAllDetailsCorrectOnListing = false;
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		for (int i = 0; i < productSalePage.getListOfProduct().size(); i++) {
			String name = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//div[@class='product-info']/h5")).getText().trim();
			String companyName = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//div[@class='company_name ng-binding ng-scope']")).getText().trim();
			String price = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//span[contains(@class,'discounted_price ng-binding')]")).getText().trim();
			WebElement defaultQtyCount = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//span[contains(@class,'product-quantity ng-binding')]"));
			WebElement addedQtySign = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//span[contains(@class,'qtyBtns pos')]"));
			WebElement removeQtySign = productSalePage.getListOfProduct().get(i)
					.findElement(By.xpath("//span[contains(@class,'qtyBtns neg disabled')]"));

			boolean isNameDisplayed = !(name.equalsIgnoreCase("NA") || name.equalsIgnoreCase("Null"));
			boolean isCompanyNameDisplayed = !(companyName.equalsIgnoreCase("NA")
					|| companyName.equalsIgnoreCase("Null"));
			boolean isPriceDisplayed = !(price.equalsIgnoreCase("NA") || price.equalsIgnoreCase("NUll"));
			boolean isAddedQtySignDisplayed = addedQtySign.isDisplayed();
			boolean isRemoveQtySignDisplayed = removeQtySign.isDisplayed();
			boolean defaultQtyCountDisplayedIsZero = Integer.valueOf(defaultQtyCount.getText()) == 0;

			isAllDetailsCorrectOnListing = isNameDisplayed && isCompanyNameDisplayed && isPriceDisplayed
					&& isAddedQtySignDisplayed && isRemoveQtySignDisplayed && defaultQtyCountDisplayedIsZero;
		}

		return isAllDetailsCorrectOnListing;
	}

	public static void addProductQtyToCart(String productName, String batchNumber, int qty) {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		WebElement addQty = driver.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'"
				+ productName + "')]/following-sibling::div/span[contains(text(),'" + batchNumber
				+ "')]/../../following-sibling::div//span[contains(@class,'qtyBtns pos')]"));
		for (int i = qty + 1; i > 0; i--) {
			addQty.click();
		}
	}

	public static void removeProductQtyFromCart(String productName, String batchNumber, int qty) {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		WebElement removeQty = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'" + productName
						+ "')]/following-sibling::div/span[contains(text(),'" + batchNumber
						+ "')]/../../following-sibling::div//span[contains(@class,'qtyBtns neg')]"));
		for (int i = 1; i <= qty; i++) {
			removeQty.click();
		}
	}

	public static String verifyProductCompanyName(String productName, String batchNumber) {
		String companyName = driver
				.findElement(By.xpath("//div[@class='product-item']//h5[contains(text(),'" + productName
						+ "')]/following-sibling::div/span[contains(text(),'" + batchNumber
						+ "')]/../../preceding-sibling::div[@class='company_name ng-binding ng-scope']"))
				.getText().trim();
		return companyName;
	}

	public static String verifyProductSize(String productName, String batchNumber) {
		String productSize = driver.findElement(By.xpath("//div[@class='product-item']//h5[contains(text(),'"
				+ productName + "')]/following-sibling::div/span[contains(text(),'" + batchNumber
				+ "')]/../../div[@class='size_info ng-binding ng-scope']")).getText().trim();
		return productSize;
	}

	public static boolean verifyProductOriginalPrice(String productName, String batchNumber,
			String productOriginalPrice) {
		double actualOriginalPrice = Double.valueOf(driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'" + productName
						+ "')]/following-sibling::div/span[contains(text(),'" + batchNumber
						+ "')]/../../following-sibling::div//span[contains(@class,'discounted_price ng-binding disabled_orig_cost')]"))
				.getText());
		double expectedOriginalPrice = Double.valueOf(productOriginalPrice);
		if (actualOriginalPrice == expectedOriginalPrice) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verifyProductPriceAfterDiscount(String productName, String batchNumber, int discount) {
		String price = driver.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'"
				+ productName + "')]/following-sibling::div/span[contains(text(),'" + batchNumber
				+ "')]/../../following-sibling::div//span[contains(@class,'discounted_price ng-binding disabled_orig_cost')]"))
				.getText();
		double originalPrice = Double.valueOf(price);
		String actualPrice = driver.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'"
				+ productName + "')]/following-sibling::div/span[contains(text(),'" + batchNumber
				+ "')]/../../following-sibling::div//span[contains(@class,'discounted_price ng-binding ng-scope')]"))
				.getText();
		double actualDiscountPrice = Double.valueOf(actualPrice.split("\n")[0] + actualPrice.split("\n")[1]);
		double expectedDiscountPrice = originalPrice - getTwoDecimalPlacesValue((discount * originalPrice) / 100);
		return actualDiscountPrice == expectedDiscountPrice;

	}

	public static boolean verifyProductName(String productName, String batchNumber) {
		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//div/span[contains(text(),'" + batchNumber
						+ "')]/../preceding-sibling::h5[contains(text(),'" + productName + "')]"));
		BaseClass.WaitTillElementIsPresent(element);
		return element.isDisplayed();

	}

	public static boolean verifyProductBatchNumber(String productName, String batchNumber) {
		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//div/h5[contains(text(),'" + productName
						+ "')]/following-sibling::div/span[contains(text(),'" + batchNumber + "')]/.."));
		BaseClass.WaitTillElementIsPresent(element);
		return element.isDisplayed();

	}

	public static boolean verifyQtyDiscountTagOnProduct(String productName, String batchNumber, int offerQty,
			int discount) {
		String discountTag;
		if (offerQty > 1) {
			discountTag = "Buy " + offerQty + " get " + discount + "% " + "Off";
		} else {
			discountTag = discount + "% Off";
		}
		WebElement element = driver.findElement(By.xpath("//div[@class='product-info']//h5[@title='" + productName
				+ "']/following-sibling::div/span[contains(text(),'" + batchNumber
				+ "')]/../../preceding-sibling::div[@class='product-image']//strong[contains(text(),'" + discountTag
				+ "')]"));
		BaseClass.WaitTillElementIsPresent(element);
		if (checkWebElementIsDisplayed(element)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean verifySpecialDiscountTagOnProduct(String productName, String batchNumber,
			String discountFromDate, String discountToDate) {
		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//div/span[contains(text(),'" + batchNumber
						+ "')]/../preceding-sibling::h5[contains(text(),'" + productName
						+ "')]/.././preceding-sibling::div[@class='product-image']/div[normalize-space()='special offer']/div"));
		BaseClass.WaitTillElementIsPresent(element);
		Date currentDate = new Date();
		Date fromDate = convertStringIntoDate(discountFromDate);
		Date toDate = convertStringIntoDate(discountToDate);
		if ((currentDate.after(fromDate) || currentDate.equals(fromDate))
				&& (currentDate.before(toDate) || currentDate.equals(toDate))) {
			if (checkWebElementIsDisplayed(element)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public static boolean verifyToolTipOnProduct(String productName, String batchNumber) {
		WebElement element = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//div/span[contains(text(),'" + batchNumber
						+ "')]/../preceding-sibling::h5[contains(text(),'" + productName
						+ "')]/.././preceding-sibling::div/span[@class='info medical']"));
		BaseClass.WaitTillElementIsPresent(element);
		return checkWebElementIsDisplayed(element);

	}

	public static int getAddedQtyCountOnProduct(String productName, String batchNumber) {
		int qty = Integer
				.valueOf(driver
						.findElement(By.xpath("//div[contains(@class,'product-item')]//div/h5[contains(text(),'"
								+ productName + "')]/following-sibling::div/span[contains(text(),'" + batchNumber
								+ "')]/../../following-sibling::div//span[@class='product-quantity ng-binding']"))
						.getText());
		return qty;

	}

	public static boolean verifyEditProductTab() {
		try {
			BaseClass.WaitTillElementIsPresent(productSalePage.getEditProductSalesTab());
			return productSalePage.getEditProductSalesTab().isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;
		}

	}

	public static void clickOnEditProductTab() {
		BaseClass.waitForElementToBeClickable(productSalePage.getEditProductSalesTab());
		productSalePage.getEditProductSalesTab().click();
	}

	public static boolean verifyColumnLabelOnProductCart() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getProductNameColumnLabel());
		boolean isAllColumnLabelPresent = checkWebElementIsDisplayed(productSalePage.getProductNameColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getUnitCostColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getQtyColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getNetAmountColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getCouponColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getCouponBasisColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getAmountPayableColumnLabel())
				&& checkWebElementIsDisplayed(productSalePage.getActionColumnLabel());
		return isAllColumnLabelPresent;

	}

	public static boolean verifyAmtPayableOfProductAddedInCart() {

		double expectedTotalAmtPayable = 0.00;
		List<WebElement> listOfProductAddedInCart = driver
				.findElements(By.xpath("//div[@class='product-item selected']"));

		if (listOfProductAddedInCart.size() > 0) {
			BaseClass.visibilityOfListLocated(listOfProductAddedInCart);
			for (int i = 0; i < listOfProductAddedInCart.size(); i++) {
				String amtPayableOfSingleQty = listOfProductAddedInCart.get(i).findElement(By.xpath(
						"child::div[@class='product-action-btns']//span[contains(@class,'discounted_price ng-binding')]"))
						.getText().trim();
				amtPayableOfSingleQty = amtPayableOfSingleQty.split("\n")[0] + amtPayableOfSingleQty.split("\n")[1];
				int selectedQty = Integer.valueOf(listOfProductAddedInCart.get(i).findElement(By.xpath(
						"child::div[@class='product-action-btns']//span[contains(@class,'product-quantity ng-binding')]"))
						.getText().trim());
				double amtPayable = getTwoDecimalPlacesValue(Double.valueOf(amtPayableOfSingleQty) * selectedQty);
				expectedTotalAmtPayable = expectedTotalAmtPayable + amtPayable;

			}
			double actualTotalAmtPayable = getTwoDecimalPlacesValue(
					Double.valueOf(productSalePage.getAmtPayable().getText().trim().split("\n")[1]));
			boolean isAmtPayableCorrectDisplayedOnListing = expectedTotalAmtPayable == actualTotalAmtPayable;

			return isAmtPayableCorrectDisplayedOnListing;
		} else {
			try {
				BaseClass.WaitTillElementIsPresent(productSalePage.getAmtPayable());
				return productSalePage.getAmtPayable().isDisplayed();
			} catch (NoSuchElementException noSuchElementException) {
				return false;
			}

		}

	}

	public static boolean verifyZeroQuantityErrorMsg() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getProductQtyZeroErrorMsg());
		return productSalePage.getProductQtyZeroErrorMsg().isDisplayed();

	}

	public static boolean verifyMaxQtyAddedErrorMsg(String maxQty) {
		WebElement errorMsg = driver.findElement(
				By.xpath("//span[contains(text(),'Only " + maxQty + " quantity of this product is available!')]"));
		BaseClass.WaitTillElementIsPresent(errorMsg);
		return errorMsg.isDisplayed();

	}

	public static boolean verifyPlusIconOnAddingMaxQtyOnListing(String productName, String batch) {
		WebElement plusIconOnProduct = driver
				.findElement(By.xpath("//div[contains(@class,'product-item')]//h5[contains(text(),'" + productName
						+ "')]/following-sibling::div/span[contains(text(),'" + batch
						+ "')]/../../following-sibling::div//span[@class='qtyBtns pos disabled']"));
		BaseClass.WaitTillElementIsPresent(plusIconOnProduct);
		return plusIconOnProduct.isDisplayed();
	}

	public static boolean verifyPlusIconOnAddingMaxQtyOnCart(String productName, String batchNumber) {
		WebElement plusIconOnProduct = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[contains(@class,'qtyBtns pos ng-scope')]"));
		BaseClass.WaitTillElementIsPresent(plusIconOnProduct);
		return plusIconOnProduct.isDisplayed();
	}

	public static String checkAddedProductCompanyShortNameDisplayed(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../preceding-sibling::span[@class='company_name ng-binding ng-scope']"));
		String actualProductCompanyName = element.getText().split(" ")[0];
		return actualProductCompanyName;
	}

	public static boolean checkAddedProductNameDisplayed(String productName, String batchNumber) {
		try {
			WebElement element = driver
					.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(text(),'"
							+ batchNumber + " ')]/../parent::span[contains(normalize-space(),'" + productName + "')]"));
			BaseClass.WaitTillElementIsPresent(element);
			return checkWebElementIsDisplayed(element);
		} catch (NoSuchElementException noSuchElementException) {
			return false;
		}

	}

	public static boolean checkAddedProductBatchDisplayed(String productName, String batchNumber) {
		try {
			WebElement element = driver.findElement(
					By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
							+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber + " ')]"));
			BaseClass.WaitTillElementIsPresent(element);
			return checkWebElementIsDisplayed(element);
		} catch (NoSuchElementException noSuchElementException) {
			return false;
		}
	}

	public static boolean verifyDetailsOfProductInCart() {
		boolean isAllValuesDisplayedCorrect = false;

		for (int i = 0; i < productSalePage.getListOfProductAddedInCart().size(); i++) {
			WebElement productName = productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("//span[@class='company_name ng-binding ng-scope']/.."));
			WebElement companyName = productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("//span[@class='company_name ng-binding ng-scope']"));
			double unitCost = Double.valueOf(productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[2]")).getText().trim());
			int qty = Integer.valueOf(productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[3]//span[@class='product-quantity ng-binding']")).getText().trim());
			double netAmount = Double.valueOf(productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[4]")).getText().trim());
			double coupon = Double.valueOf(productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[5]")).getText().trim());
			double amountPayable = Double.valueOf(productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[7]")).getText().trim());
			WebElement deleteButton = productSalePage.getListOfProductAddedInCart().get(i)
					.findElement(By.xpath("td[8]//span[@class='actn-icn delete']"));
			String couponBasis = productSalePage.getListOfProductAddedInCart().get(i).findElement(By.xpath("td[6]"))
					.getText().trim();

			boolean isUnitCostCorrect = getTwoDecimalPlacesValue(
					netAmount / Double.valueOf(qty)) == getTwoDecimalPlacesValue(unitCost);
			boolean isNetAmountCorrect = getTwoDecimalPlacesValue(
					(unitCost * Double.valueOf(qty))) == getTwoDecimalPlacesValue(netAmount);
			System.out.println("***********" + (netAmount - amountPayable));
			System.out.println("######" + coupon);
			boolean isCouponCorrect = getTwoDecimalPlacesValue((netAmount - amountPayable)) == getTwoDecimalPlacesValue(
					coupon);
			boolean isAmountPayableCorrect = getTwoDecimalPlacesValue((netAmount - coupon)) == getTwoDecimalPlacesValue(
					amountPayable);
			boolean qtyShouldMoreThanZero = qty > 0;
			boolean isDeleteButtonDisplayed = deleteButton.isDisplayed();
			boolean isCouponBasisDisplayedCorrect = false;
			boolean productNameDisplayed = !(productName.getText().trim().equalsIgnoreCase("NA")
					|| productName.getText().trim().equalsIgnoreCase("Null"));
			boolean companyNameDisplayed = !(companyName.getText().trim().equalsIgnoreCase("NA")
					|| companyName.getText().trim().equalsIgnoreCase("Null"));

			if (coupon != 0) {
				isCouponBasisDisplayedCorrect = !(couponBasis.equals("NA") || couponBasis.equals("Not Applicable"));

			} else {
				isCouponBasisDisplayedCorrect = couponBasis.equals("Not Applicable");
			}

			isAllValuesDisplayedCorrect = isUnitCostCorrect && isNetAmountCorrect && isCouponCorrect
					&& isAmountPayableCorrect && qtyShouldMoreThanZero && isDeleteButtonDisplayed
					&& isCouponBasisDisplayedCorrect && productNameDisplayed && companyNameDisplayed;

		}
		return isAllValuesDisplayedCorrect;

	}

	public static double getUnitCostOfAddedProduct(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td[1]"));
		double actualUnitCost = Double.valueOf(element.getText());
		return actualUnitCost;
	}

	public static int getAddedQtyOfProductOnListing(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[@class='product-quantity ng-binding']"));
		int actualQty = Integer.valueOf(element.getText());
		return actualQty;

	}

	public static boolean verifyNetAmountOfAddedProduct(String productName, String batchNumber) {
		double expectedNetAmount = getUnitCostOfAddedProduct(productName, batchNumber)
				* Double.valueOf(getAddedQtyOfProductOnListing(productName, batchNumber));
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td[3]"));
		double actualNetAmount = Double.valueOf(element.getText());
		if (expectedNetAmount == actualNetAmount) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean verifyCouponAmtOfAddedProduct(String productName, String batchNumber,
			int discountPercentage) {
		double originalAmount = getUnitCostOfAddedProduct(productName, batchNumber)
				* Double.valueOf(getAddedQtyOfProductOnListing(productName, batchNumber));
		double expectedCouponValue = (originalAmount * (Double.valueOf(discountPercentage) / 100.00));
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td[4]"));
		double actualCouponValue = Double.valueOf(element.getText());

		if (actualCouponValue == expectedCouponValue) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean verifyAmtPayableOfAddedProduct(String productName, String batchNumber,
			int discountPercentage) {
		double netAmount = getUnitCostOfAddedProduct(productName, batchNumber)
				* Double.valueOf(getAddedQtyOfProductOnListing(productName, batchNumber));
		double couponAmount = (netAmount * (Double.valueOf(discountPercentage) / 100.00));
		double expectedAmtPayable = netAmount - couponAmount;

		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td[6]"));
		double actualAmountPayable = Double.valueOf(element.getText());

		if (actualAmountPayable == expectedAmtPayable) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean verifyDeleteButton(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[@class='actn-icn delete']"));
		BaseClass.WaitTillElementIsPresent(element);
		BaseClass.waitForElementToBeClickable(element);
		return checkWebElementIsDisplayed(element);
	}

	public static void clickOnDeleteButton(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[@class='actn-icn delete']"));
		BaseClass.WaitTillElementIsPresent(element);
		BaseClass.waitForElementToBeClickable(element);
		element.click();
	}

	public static boolean verifyTotalAmountPayableOfCart() {
		double totalNetAmountOfCart = 0.00;
		double totalCouponValueOfCart = 0.00;
		for (int i = 0; i < productSalePage.getListOfProductAddedInCart().size(); i++) {
			String netAmount = productSalePage.getListOfProductAddedInCart().get(i).findElement(By.xpath("td[4]"))
					.getText().trim();
			String couponAmount = productSalePage.getListOfProductAddedInCart().get(i).findElement(By.xpath("td[5]"))
					.getText().trim();
			totalNetAmountOfCart = totalNetAmountOfCart + Double.valueOf(netAmount);
			totalCouponValueOfCart = totalCouponValueOfCart + Double.valueOf(couponAmount);

		}
		WebElement element = driver.findElement(By.xpath(
				"//table[@class='table table-striped']/tfoot/tr/td/strong[text()='Total Amount Payable:']/../following-sibling::td[1]"));
		double actualTotalAmtPayable = Double.valueOf(element.getText());
		double expectedTotalAmtPayable = totalNetAmountOfCart - totalCouponValueOfCart;

		if (actualTotalAmtPayable == expectedTotalAmtPayable) {
			return true;
		} else {
			return false;
		}

	}

	public static String getCouponBasisOfAddedProduct(String productName, String batchNumber) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td[5]"));
		BaseClass.WaitTillElementIsPresent(element);
		String couponBasis = element.getText().trim();
		return couponBasis;

	}

	public static void increaseQtyOfAddedProduct(String productName, String batchNumber, int qtyToBeIncreased) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[contains(@class,'qtyBtns pos ng-scope')]"));
		for (int i = 1; i <= qtyToBeIncreased; i++) {
			BaseClass.waitForElementToBeClickable(element);
			element.click();
		}

	}

	public static void decreaseQtyOfAddedProduct(String productName, String batchNumber, int qtyToBeDecreased) {
		WebElement element = driver.findElement(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td//span[contains(normalize-space(),'"
						+ productName + "')]//following-sibling::span[contains(text(),'" + batchNumber
						+ "')]/../../../following-sibling::td//span[@class='qtyBtns neg ng-scope']"));
		for (int i = 1; i <= qtyToBeDecreased; i++) {
			BaseClass.waitForElementToBeClickable(element);
			element.click();
		}

	}

	public static boolean verifyProductDeletedFromCartSucessMsg() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getProductDeletedSuccessMsg());
		BaseClass.waitForElementToBeClickable(productSalePage.getProductDeletedSuccessMsg());
		return productSalePage.getProductDeletedSuccessMsg().isDisplayed();

	}

	public static int getNumberOfProductInCart() {
		int numberOfProductAddedInCart = Integer.valueOf(productSalePage.getItemInCart().getText().trim());
		return numberOfProductAddedInCart;

	}

	public static void selectGlobalClinicFromProductSale() {

	}

	public static void autoSuggestByPatientName(String patientName, String patientMobileNumber) {
		patientSelectionFromAutoSuggest(productSalePage.getAutoSuggest(), patientName, patientMobileNumber);

	}

	public static void autoSuggestByPatientMobile(String patientMobileNumber, String patientName) {
		patientSelectionFromAutoSuggest(productSalePage.getAutoSuggest(), patientMobileNumber, patientName);
	}

	public static void autoSuggestByPatientId(String patientId, String patientName, String patientMobileNumber) {
		String patientNameAndMobile = patientName + " : " + patientMobileNumber;
		patientSelectionFromAutoSuggest(productSalePage.getAutoSuggestByPatientId(), patientId, patientNameAndMobile);

	}

	private static void patientSelectionFromAutoSuggest(List<WebElement> autoSuggestList, String searchString,
			String otherDetails) {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		BaseClass.visibilityOfListLocated(autoSuggestList);
		for (WebElement element : autoSuggestList) {
			String text = element.findElement(By.xpath("strong")).getText().toLowerCase();
			Assert.assertTrue(searchString.toLowerCase().contains(text));
		}
		WebElement matchOtherDetails = driver.findElement(By.xpath("//span[contains(text(),'" + otherDetails + "')]"));
		BaseClass.WaitTillElementIsPresent(matchOtherDetails);
		BaseClass.waitForElementToBeClickable(matchOtherDetails);
		BaseClass.hoverOnElement(matchOtherDetails);
		matchOtherDetails.click();

	}

	public static boolean verifyConfirmationPopUpShownOnLeavingScreen() {
		final String expectedMsgOnPopUp = "Product(s) added in cart will get removed, as they are not invoiced! Click cancel(X) to stay on the page?";
		BaseClass.WaitTillElementIsPresent(productSalePage.getConfirmationModal());
		BaseClass.waitForElementToBeClickable(productSalePage.getConfirmationModal());
		String actualMsgOnPopUp = productSalePage.getConfirmationModal().getText().trim();
		if (actualMsgOnPopUp.contains(expectedMsgOnPopUp)
				&& checkWebElementIsDisplayed(productSalePage.getConfirmationModal())
				&& checkWebElementIsDisplayed(productSalePage.getYesButtonOnConfirmationModal())
				&& checkWebElementIsDisplayed(productSalePage.getCancelBtnOnConfirmationModal())) {
			return true;
		} else {
			return false;
		}
	}

	public static void clickOnCancelBtnOnPopUp() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getConfirmationModal());
		BaseClass.waitForElementToBeClickable(productSalePage.getCancelBtnOnConfirmationModal());
		productSalePage.getCancelBtnOnConfirmationModal().click();

	}

	public static void clickOnYesBtnOnPopUp() {
		BaseClass.WaitTillElementIsPresent(productSalePage.getConfirmationModal());
		BaseClass.waitForElementToBeClickable(productSalePage.getYesButtonOnConfirmationModal());
		productSalePage.getYesButtonOnConfirmationModal().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void clickOnGlobalSearchBtn() {
		BaseClass.waitForElementToBeClickable(productSalePage.getGlobalSearchButton());
		productSalePage.getGlobalSearchButton().click();

	}

	public static void clickOnGlobalClinicDrpDwn() {
		BaseClass.waitForElementToBeClickable(productSalePage.getGlobalClinicDrpDwnBtn());
		productSalePage.getGlobalClinicDrpDwnBtn().click();

	}

	public static boolean verifyLeftNavigationOnProductSale() {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		BaseClass.waitForElementToBeClickable(productSalePage.getLeftNavigation());
		return productSalePage.getLeftNavigation().isDisplayed();

	}

	public static boolean verifyPatientNameAndIdOnProductSale(String patientName, String patientId) {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
		BaseClass.WaitTillElementIsPresent(productSalePage.getPatientNameAndIdOnProductListing());
		String expectedPatientNameAndId = patientName + " : " + patientId;
		String actualPatientNameAndId = productSalePage.getPatientNameAndIdOnProductListing().getText().trim();
		if (actualPatientNameAndId.equalsIgnoreCase(actualPatientNameAndId)) {
			return true;
		} else {
			return false;
		}

	}

	public static void verifyRemoveNearExpiryProductFromListing() {
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		List<WebElement> expiryDateList = driver.findElements(By.xpath(
				"//div[contains(@class,'product-item')]/div[@class='product-info']/div[contains(@class,'batch_expiry_info')]/span[2]"));
		Date date = getDateFromCurrentDatePlusDays(remove_Near_expiry_product_from_listing);
		for (WebElement expiry : expiryDateList) {
			String expiryDate = expiry.getText().trim().split(" ")[1].trim();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			try {
				Date expiryD = sdf1.parse(expiryDate);
				expiryDate = sdf2.format(expiryD);
				expiryD = sdf2.parse(expiryDate);
				if (expiryD.after(date)) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}

		}

	}

	/*
	 * .Product Expiry Date lies between (Today Date +Product Highlight Start Day)
	 * And (Today Date +Product Highlight end Days )
	 */
	public static void verifyHighlightProductInListingBeforeExpiry() {
		BaseClass.visibilityOfListLocated(productSalePage.getListOfProduct());
		List<WebElement> expiryDateList = driver.findElements(By.xpath(
				"//div[contains(@class,'product-item')]/div[@class='product-info']/div[contains(@class,'batch_expiry_info')]/span[2]"));
		Date productHighlightDate = getDateFromCurrentDatePlusDays(highlight_Products_In_Listing);
		Date stopProductHighlightDate = getDateFromCurrentDatePlusDays(stop_highlighting_Products_In_Listing);

		for (WebElement expiry : expiryDateList) {
			String expiryDate = expiry.getText().trim().split(" ")[1].trim();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			try {
				Date expiryD = sdf1.parse(expiryDate);
				expiryDate = sdf2.format(expiryD);
				expiryD = sdf2.parse(expiryDate);
				if (expiryD.after(productHighlightDate) && expiryD.before(stopProductHighlightDate)) {
					boolean isHighlighted = expiry.findElement(By.xpath("../../..")).getAttribute("class")
							.contains("item-highlight");
					Assert.assertTrue(isHighlighted);
				} else {
					boolean isHighlighted = expiry.findElement(By.xpath("../../..")).getAttribute("class")
							.contains("item-highlight");
					Assert.assertFalse(isHighlighted);
				}
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}

		}
	}

	private static boolean checkWebElementIsDisplayed(WebElement element) {
		BaseClass.WaitTillElementIsPresent(element);
		return element.isDisplayed();
	}

	public static void clickOnWebElement(WebElement element) {
		BaseClass.waitForElementToBeClickable(element);
		element.click();
	}

	public static void enterText(WebElement element, String text) {
		BaseClass.waitForElementToBeClickable(element);
		element.clear();
		element.sendKeys(text);
	}

	public static void waitTillLoaderDisappear() {
		BaseClass.waitTillInvisiblityOfElement(productSalePage.getLoader());
	}

	private static String getEnteredText(String id) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String text = (String) javascriptExecutor.executeScript("return document.getElementById('" + id + "').value;");
		return text;
	}

	private static double getTwoDecimalPlacesValue(double d) {

		return Math.round(d * 100.0) / 100.0;
	}

	public static Date getDateFromCurrentDatePlusDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, days);
		Date datesAfterDaysLater = getDateInFormat(calendar.getTime(), "dd-MM-yyyy");
		return datesAfterDaysLater;

	}

	public static Date getDateInFormat(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateString = sdf.format(date);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date convertStringIntoDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
