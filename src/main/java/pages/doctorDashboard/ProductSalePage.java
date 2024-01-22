package pages.doctorDashboard;

import java.util.List;

//import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSalePage {


    @FindBy(xpath = "//div[@class='modal overlay']")
    private WebElement loader;
    @FindBy(xpath = "//span[@class='title']/span[contains(text(),'Products')]")  // changed the xpath from "//span[@class='title']/span[text()='Product Sales']")
    private WebElement productSalesTab;
    @FindBy(xpath = "//span[@class='title' and text()='Edit Products']")
    private WebElement editProductSalesTab;
    @FindBy(xpath = "//span[@class='actn-icn save']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[@class='actn-icn cancel']/..")
    private WebElement cancelButton;
    @FindBy(id = "searchProducts")
    private WebElement searchProducts;
    @FindBy(xpath = "//div[@class='product-srch-icn']")
    private WebElement searchProductButton;
    @FindBy(xpath = "//span[@class='glyphicon glyphicon-exclamation-sign']/following-sibling::i[text()='No Product Found!']")
    private WebElement noProductFoundMsg;
    @FindBy(id = "patientname")
    private WebElement patientName;
    @FindBy(id = "mobile")
    private WebElement patientMobile;
    @FindBy(id = "patientid")
    private WebElement patientId;
    @FindBy(id = "email")
    private WebElement patientEmailId;
    @FindBy(xpath = "//span[@class='actn-icn manualUpdate']")
    private WebElement resetButton;
    @FindBy(xpath = "//span[@class='cart-badge cart-filled']/span")
    private WebElement itemInCart;
    @FindBy(xpath = "//span[@class='cart-badge cart-filled']/span")
    private WebElement selectedItemInCart;
    @FindBy(xpath = "//div[@class='payable_sec ng-binding ng-scope']/span[text()='Amt. Payable']")
    private WebElement amtPayableLabel;
    @FindBy(xpath = "//div[@class='col-xs-5 col-sm-4 col-md-3 col-lg-2 product-spc ng-scope']")
    private List<WebElement> listOfProduct;
    @FindBy(xpath = "//div[@class='error ng-binding ng-scope' and text()='Enter patient name']")
    private WebElement enterNameErrMsg;
    @FindBy(xpath = "//div[@class='error ng-binding ng-scope' and text()='Enter mobile no.']")
    private WebElement enterMobileErrMsg;
    @FindBy(xpath = "//div[text()='Enter 10 digit mobile no.']")
    private WebElement enterTenDigitMobileNumberErrMsg;
    @FindBy(xpath = "//div[text()='Enter a valid mobile no.']")
    private WebElement enterValidMobileNumberErrMsg;
    @FindBy(xpath = "//div[text()='Enter valid email address']")
    private WebElement enterValidEmailErrMsg;
    @FindBy(xpath = "//span[text()='Please add product(s) before clicking on Save button!']")
    private WebElement addProductErrorMsg;
    @FindBy(xpath = "//span[text()='Quantity for product is zero!']")
    private WebElement productQtyZeroErrorMsg;
    @FindBy(xpath = "//div[contains(@class,'modal-inset mdleConfirmationTxtValign ng-scope')]")
    private WebElement confirmationModal;
    @FindBy(xpath = "//div[@class='modalBtns']//span[@class='cmnicons cncl-mdl']")
    private WebElement cancelBtnOnConfirmationModal;
    @FindBy(xpath = "//div[@class='modalBtns']//span[@class='cmnicons yes-mdl']")
    private WebElement yesButtonOnConfirmationModal;

    @FindBy(xpath = "//table[@class='table table-striped']//th[1]/span[text()='Product(s) - Company, Batch & Expiry']")
    private WebElement productNameColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[2][text()='Unit Cost']")
    private WebElement unitCostColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[3][text()='Qty.']")
    private WebElement qtyColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[4][text()='Net Amount']")
    private WebElement netAmountColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[5][text()='Cpn. Amount']")
    private WebElement couponColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[6][text()='Coupon Basis']")
    private WebElement couponBasisColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[7][text()='Amt. Pay.']")
    private WebElement amountPayableColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']//th[8][text()='Action']")
    private WebElement actionColumnLabel;
    @FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
    private List<WebElement> listOfProductAddedInCart;
    @FindBy(xpath = "//span[text()='Product deleted successfully!']")
    private WebElement productDeletedSuccessMsg;
    @FindBy(xpath = "//span[contains(@ng-bind-html,'match.label | typeaheadHighlight:query')]")
    private List<WebElement> autoSuggest;
    @FindBy(xpath = "//span[contains(@ng-bind-html,'match.model.pubpid | typeaheadHighlight:query')]")
    private List<WebElement> autoSuggestByPatientId;
    @FindBy(xpath ="//span[text()='Amt. Payable']/..")
    private WebElement amtPayable;


    @FindBy(xpath = "//span[@class='left-nav']")
    private WebElement leftNavigation;
    @FindBy(xpath = "//span[@class='mdl-hdr-text ng-binding ng-scope']")
    private WebElement patientNameAndIdOnProductListing;

    @FindBy(xpath = "//a[@class='searchBtn fa fa-search cursor-pointer']")
    private WebElement globalSearchButton;
    @FindBy(xpath = "//a[@class='btn-warning dropBtn']")
    private WebElement globalClinicDrpDwnBtn;

    
    public WebElement getLoader() {
		return loader;
	}
	public WebElement getProductSalesTab() {
		return productSalesTab;
	}
	public WebElement getEditProductSalesTab() {
		return editProductSalesTab;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}
	public WebElement getSearchProducts() {
		return searchProducts;
	}
	public WebElement getSearchProductButton() {
		return searchProductButton;
	}
	public WebElement getNoProductFoundMsg() {
		return noProductFoundMsg;
	}
	public WebElement getPatientName() {
		return patientName;
	}
	public WebElement getPatientMobile() {
		return patientMobile;
	}
	public WebElement getPatientId() {
		return patientId;
	}
	public WebElement getPatientEmailId() {
		return patientEmailId;
	}
	public WebElement getResetButton() {
		return resetButton;
	}
	public WebElement getItemInCart() {
		return itemInCart;
	}
	public WebElement getSelectedItemInCart() {
		return selectedItemInCart;
	}
	public WebElement getAmtPayableLabel() {
		return amtPayableLabel;
	}
	public List<WebElement> getListOfProduct() {
		return listOfProduct;
	}
	public WebElement getEnterNameErrMsg() {
		return enterNameErrMsg;
	}
	public WebElement getEnterMobileErrMsg() {
		return enterMobileErrMsg;
	}
	public WebElement getEnterTenDigitMobileNumberErrMsg() {
		return enterTenDigitMobileNumberErrMsg;
	}
	public WebElement getEnterValidMobileNumberErrMsg() {
		return enterValidMobileNumberErrMsg;
	}
	public WebElement getEnterValidEmailErrMsg() {
		return enterValidEmailErrMsg;
	}
	public WebElement getAddProductErrorMsg() {
		return addProductErrorMsg;
	}
	public WebElement getProductQtyZeroErrorMsg() {
		return productQtyZeroErrorMsg;
	}
	public WebElement getConfirmationModal() {
		return confirmationModal;
	}
	public WebElement getCancelBtnOnConfirmationModal() {
		return cancelBtnOnConfirmationModal;
	}
	public WebElement getYesButtonOnConfirmationModal() {
		return yesButtonOnConfirmationModal;
	}
	public WebElement getProductNameColumnLabel() {
		return productNameColumnLabel;
	}
	public WebElement getUnitCostColumnLabel() {
		return unitCostColumnLabel;
	}
	public WebElement getQtyColumnLabel() {
		return qtyColumnLabel;
	}
	public WebElement getNetAmountColumnLabel() {
		return netAmountColumnLabel;
	}
	public WebElement getCouponColumnLabel() {
		return couponColumnLabel;
	}
	public WebElement getCouponBasisColumnLabel() {
		return couponBasisColumnLabel;
	}
	public WebElement getAmountPayableColumnLabel() {
		return amountPayableColumnLabel;
	}
	public WebElement getActionColumnLabel() {
		return actionColumnLabel;
	}
	public List<WebElement> getListOfProductAddedInCart() {
		return listOfProductAddedInCart;
	}
	public WebElement getProductDeletedSuccessMsg() {
		return productDeletedSuccessMsg;
	}
	public List<WebElement> getAutoSuggest() {
		return autoSuggest;
	}
	public List<WebElement> getAutoSuggestByPatientId() {
		return autoSuggestByPatientId;
	}
	public WebElement getAmtPayable() {
		return amtPayable;
	}
	public WebElement getLeftNavigation() {
		return leftNavigation;
	}
	public WebElement getPatientNameAndIdOnProductListing() {
		return patientNameAndIdOnProductListing;
	}
	public WebElement getGlobalSearchButton() {
		return globalSearchButton;
	}
	public WebElement getGlobalClinicDrpDwnBtn() {
		return globalClinicDrpDwnBtn;
	}
	

}
