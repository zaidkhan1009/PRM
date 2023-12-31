package tests;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.doctorDashboard.PatientRegistrationPageActions;
import pageActions.doctorDashboard.ProductSalePageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.InvoiceListingPageActions;
import pages.doctorDashboard.PatientDashboardPage;
import utils.TestData;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Map;

public class ProductSaleTestCases extends BaseClass {

   
    final String VERIFY_WEBELEMENT_ON_PRODUCT_LISTING="Verifying all the Field and button on product listing and product in product listing ";
    final String VERIFY_ERROR_ON_MANDATORY_FIELD="Verify the behaviour when mandatory field are not filled and verify error message shown";
    final String VERIFY_RESET_CANCEL_BUTTON_WORKING="Verify the redirection on click of cancel button and check on reset field are getting blank";
    final String VERIFY_PRODUCT_SEARCH="Verify product search by name and batch on Product listindt and matching the result according to the search";
    final String VERIFY_ADD_REMOVE_ITEM_ON_PRODUCT_LISTING="/*Verifying adding product to cart and removing some qty of added item */ Verify NetAmount,Unit COst,Coupon Value and Amt.Payables valuesremoving qty from product listing tab and then checking qty is also remove from cart */";
    final String VERIFY_ADD_REMOVE_ITEM_FROM_CART="Validating Increase /Decrease Qty of Add item and verifying the effect on Amounts";
    final String VERIFY_PRODUCT_REMOVE_HIGHLIGHT_BEFORE_EXPIRY="Verify Product with Expiry Near to Configured days is removed on product listing and Verify Product with Expiry Near to Configured days are Highlighted";
    final String VERIFY_EXISTING_PATIENT_AUTO_SUGGESTION="Verifying the Auto Suggestion when existing patient Name/Mobile Number/Patient Id is entered.";
    final String VERIFY_NEW_PATIENT_CREATION_FROM_PRODUCT_SALES="Creating New UnApproved patient from PRM and then checking patient is created by searching patient in the clinic Verifying UnApproved patient is created and checking Patient communication.";
    final String VERIFY_PRODUCT_SALES_FOR_EXISTING_PATIENT="Verifying Product Sales for Existing patient";
/*
 * Test Data From test.properties file
 */
    
    final String PRODUCT_SALE_CLINIC=TestData.getInstance().getInputData("product_sale_clinic");
    final String PATIENT_NAME=TestData.getInstance().getInputData("patient_name");
    final String PATIENT_MOBILE=TestData.getInstance().getInputData("patient_mobile");
    final String PATIENT_ID=TestData.getInstance().getInputData("patient_id");
    
    /*
     * Module and Sheet Name for getting Data from Google sheet
     */
    final String MODULE_NAME="Product Sale";
    final String GOOGLE_SHEET_NAME="ProductSaleTestData";
    final String Product_SALE_PAGE_TITLE="Product Sales";
    
    /*
     * Initalizing Map for storing Google Sheet data for the test
     */
    private Map<String ,String> productSaleTestData;
    private Map<String,String> productSalesTestData1;
   

    /*
    Validating all the Field and Button on Product Listing
    and validating Details show on individual product
     */
    @Test(description =VERIFY_WEBELEMENT_ON_PRODUCT_LISTING)
    public void verifyAllWebElementOnAddProductSale(){
        logger.log ( Status.INFO,"Checking productSale Tab is displayed");
        Assert.assertTrue ( ProductSalePageActions.isProductSaleTabDisplayed () );
        Assert.assertTrue ( ProductSalePageActions.verifyPatientNameField () );
        Assert.assertTrue ( ProductSalePageActions.verifyMobileNumberField () );
        Assert.assertTrue ( ProductSalePageActions.verifyPatientIdField () );
        Assert.assertTrue ( ProductSalePageActions.verifyPatientEmailIdField ());
        Assert.assertTrue ( ProductSalePageActions.checkSaveButton () );
        Assert.assertTrue ( ProductSalePageActions.checkCancelButton () );
        Assert.assertTrue ( ProductSalePageActions.checkResetButton () );
        Assert.assertTrue ( ProductSalePageActions.checkSearchProduct () );
        Assert.assertTrue (ProductSalePageActions.verifyProductListingData ());

    }

    /*
    Validating the Error Msg shown on Product Listing when mandatory field are not filled and user click on save button
     */
    @Test(description = VERIFY_ERROR_ON_MANDATORY_FIELD)
    public void verifyMandatoryFieldAndError(){
        ProductSalePageActions.clickOnSaveButton ();
        Assert.assertTrue (ProductSalePageActions.verifyEnterPatientNameErrorMsg());
        Assert.assertTrue ( ProductSalePageActions.verifyEnterPatientMobileNumberErrorMsg() );
        ProductSalePageActions.enterPatientName ( PATIENT_NAME);
        Assert.assertFalse ( ProductSalePageActions.verifyEnterPatientNameErrorMsg () );
        Assert.assertTrue ( ProductSalePageActions. verifyEnterPatientMobileNumberErrorMsg());
        ProductSalePageActions.enterMobileNumber (PATIENT_MOBILE );
        Assert.assertFalse ( ProductSalePageActions.verifyEnterPatientMobileNumberErrorMsg() );
        ProductSalePageActions.enterMobileNumber ( "KKDD837837" );
        Assert.assertTrue (ProductSalePageActions.verifyEnterValidMobileNumberErrMsg ());
        ProductSalePageActions.enterMobileNumber (PATIENT_MOBILE);
        Assert.assertFalse (ProductSalePageActions.verifyEnterValidMobileNumberErrMsg () );
        ProductSalePageActions.clickOnSaveButton ();
        ProductSalePageActions.enterPatientEmail ( "notanemail" );
        Assert.assertTrue (ProductSalePageActions.verifyEnterValidEmailErrorMsg ());
        ProductSalePageActions.enterPatientEmail ( "noemail@clovedental.info" );
        Assert.assertFalse ( ProductSalePageActions.verifyEnterValidEmailErrorMsg () );
        Assert.assertTrue ( ProductSalePageActions.verifyAddProductErrMsg() );
    }

/*
Verify the redirection on click of cancel button and checking on reset field are getting blank
 */
    @Test(description = VERIFY_RESET_CANCEL_BUTTON_WORKING)
    public void verifyResetAndCancelButtonWorking(){
        Assert.assertTrue ( ProductSalePageActions.checkCancelButton () );
        Assert.assertTrue ( ProductSalePageActions.checkResetButton () );
        ProductSalePageActions.enterPatientName ( PATIENT_NAME );
        ProductSalePageActions.enterMobileNumber ( PATIENT_MOBILE );
        ProductSalePageActions.enterPatientId ( PATIENT_ID);
        ProductSalePageActions.enterPatientEmail ( "noemail@clovedental.info" );
        ProductSalePageActions.clickOnResetButton ();
        Assert.assertEquals ( ProductSalePageActions.getPatientName (),"" );
        Assert.assertEquals ( ProductSalePageActions.getPatientMobile (),"" );
        Assert.assertEquals ( ProductSalePageActions.getPatientEmail (),"" );
        Assert.assertEquals ( ProductSalePageActions.getPatientId (),"" );
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertEquals ( CommonPageActions.verification (),"Doctor Dashboard" );

    }
/*
Verify product search by name and batch on Product listing and matching the result according to the search
 */
    @Test(description = VERIFY_PRODUCT_SEARCH)
    public void verifyProductSearch(){
        Assert.assertTrue ( ProductSalePageActions.checkSearchProduct ());
        ProductSalePageActions.enterSearchedDetails ( productSaleTestData.get("product_Name").split(" ")[0]);
        Assert.assertTrue (ProductSalePageActions.verifyProductSearchByName ( productSaleTestData.get("product_Name").split(" ")[0]));
        ProductSalePageActions.enterSearchedDetails (productSaleTestData.get("product_BatchNumber").substring(0,productSaleTestData.get("product_BatchNumber").length()-3));
        Assert.assertTrue (ProductSalePageActions.verifyProductSearchByBatchNumber (productSaleTestData.get("product_BatchNumber").substring(0,productSaleTestData.get("product_BatchNumber").length()-3)) );

    }
/*
Checking discount tag shown on item configured on product
 */
    @Test(description = "")
    public void verifyProductsAndDiscountOnProductListing(){
       Assert.assertTrue (ProductSalePageActions.verifyProductListingData ());
       Assert.assertEquals (ProductSalePageActions.verifyProductCompanyName ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber")), productSaleTestData.get("product_Company"));
       Assert.assertTrue ( ProductSalePageActions.verifyProductName ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
       Assert.assertTrue ( ProductSalePageActions.verifyProductBatchNumber ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
       Assert.assertEquals ( ProductSalePageActions.verifyProductSize ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) , productSaleTestData.get("product_Size"));
       Assert.assertTrue( ProductSalePageActions.verifyProductOriginalPrice ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),productSaleTestData.get("product_Original_Price")));
       Assert.assertTrue ( ProductSalePageActions.verifyProductPriceAfterDiscount ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),5));
       Assert.assertTrue ( ProductSalePageActions. verifyQtyDiscountTagOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),1 ,5));
       ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),1 );
        Assert.assertTrue ( ProductSalePageActions. verifyQtyDiscountTagOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),2 ,15));
        ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),1 );
        Assert.assertTrue ( ProductSalePageActions.verifyProductOriginalPrice ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"), productSaleTestData.get("product_Original_Price")));
        Assert.assertTrue ( ProductSalePageActions.verifyProductPriceAfterDiscount ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),15));
       Assert.assertTrue ( ProductSalePageActions.verifyToolTipOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber")) );
       Assert.assertTrue ( ProductSalePageActions.verifySpecialDiscountTagOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),productSaleTestData.get("discount_From_Date"),productSaleTestData.get("discount_To_Date") ) );
       ProductSalePageActions.clickOnEditProductTab ();
       ProductSalePageActions.clickOnDeleteButton ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") );
       
    }

    /*
    Verify No Product Found error msg found when there is no Product present in clinic
     */
    @Test
    public void verifyNoProductFoundErrMsg(){
        CommonPageActions.backTODoctorDashboard ();
        CommonPageActions.selectClinicFrmHeader ("Camp Clinic - Jaipur" );
        DoctorDashBoardPageActions.clickOnProductSales ();
        Assert.assertTrue ( ProductSalePageActions.noProductFoundErrMsg () );
    }

/*
Verifying adding product to cart and removing some qty of added item
*Verify NetAmount,Unit COst,Coupon Value and Amt.Payables values
removing qty from product listing tab and then checking qty is also remove from cart
 */
    @Test(description = VERIFY_ADD_REMOVE_ITEM_ON_PRODUCT_LISTING)
    public void verifyAddRemoveProductOnListing(){
         ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),2 );
         Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),2 );
         Assert.assertTrue (ProductSalePageActions.verifyEditProductTab ());
         Assert.assertEquals ( ProductSalePageActions.getNumberOfProductInCart (),1 );
         Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );
         ProductSalePageActions.removeProductQtyFromCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),2 );
         Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),0 );
        Assert.assertFalse (ProductSalePageActions.verifyEditProductTab ());
        Assert.assertFalse (ProductSalePageActions.verifyAmtPayableOfProductAddedInCart()  );

         ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),3 );
         Assert.assertEquals ( ProductSalePageActions.getNumberOfProductInCart (),1 );
         ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),2 );
         Assert.assertEquals ( ProductSalePageActions.getNumberOfProductInCart (),2);
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );
        
        ProductSalePageActions.clickOnEditProductTab ();
        Assert.assertTrue ( ProductSalePageActions.verifyColumnLabelOnProductCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );

        ProductSalePageActions.clickOnProductSaleTab ();

        ProductSalePageActions.removeProductQtyFromCart (productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),3 );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),0 );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),2);
        Assert.assertEquals ( ProductSalePageActions.getNumberOfProductInCart (),1 );
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );


         ProductSalePageActions.clickOnEditProductTab ();
         Assert.assertTrue ( ProductSalePageActions.verifyColumnLabelOnProductCart () );
         Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
         Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );

        Assert.assertFalse ( ProductSalePageActions.checkAddedProductNameDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ));
        Assert.assertFalse ( ProductSalePageActions.checkAddedProductBatchDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );

        Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        Assert.assertTrue ( ProductSalePageActions.checkAddedProductBatchDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );


        ProductSalePageActions.clickOnProductSaleTab ();
        ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),3 );
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),3 );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),2 );

        ProductSalePageActions.clickOnEditProductTab ();
        Assert.assertTrue ( ProductSalePageActions.verifyColumnLabelOnProductCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );

         Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
         Assert.assertTrue ( ProductSalePageActions.checkAddedProductBatchDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
         Assert.assertEquals ( ProductSalePageActions.checkAddedProductCompanyShortNameDisplayed ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),productSaleTestData.get("product_Company"));
         Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
         Assert.assertTrue ( ProductSalePageActions.checkAddedProductBatchDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
         Assert.assertEquals ( ProductSalePageActions.checkAddedProductCompanyShortNameDisplayed (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),productSalesTestData1.get("product_Company"));

         ProductSalePageActions.clickOnProductSaleTab ();
         ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),1 );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),3 );
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );

        ProductSalePageActions.clickOnEditProductTab ();
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyOfProductOnListing (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),3 );
        ProductSalePageActions.clickOnDeleteButton (productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"));
        ProductSalePageActions.clickOnDeleteButton ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"));

    }

    /*
    Increasing/Decreasing the item qty from cart tab and verifying Amounts values and then checking in Product Listing Page
    *Deleting added product from Cart and verifying Amount values after item remove from cart.
     */

    @Test(description = VERIFY_ADD_REMOVE_ITEM_FROM_CART)
    public void verifyAddRemoveProductOnCartTab(){
        ProductSalePageActions.addProductQtyToCart ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),3 );
        Assert.assertTrue (ProductSalePageActions.verifyEditProductTab ());
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );

        ProductSalePageActions.clickOnEditProductTab ();
        Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
        Assert.assertTrue ( ProductSalePageActions.checkAddedProductBatchDisplayed( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ) );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyOfProductOnListing ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),3 );

        ProductSalePageActions.increaseQtyOfAddedProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),2 );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyOfProductOnListing ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),5 );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );
        ProductSalePageActions.clickOnProductSaleTab ();
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),5 );
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );

        ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),2 );
        ProductSalePageActions.clickOnEditProductTab ();
        Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyOfProductOnListing (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ),2 );

        ProductSalePageActions.decreaseQtyOfAddedProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber"),2 );
        Assert.assertTrue ( ProductSalePageActions.checkAddedProductNameDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyOfProductOnListing ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),3 );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );

        ProductSalePageActions.clickOnProductSaleTab ();
        Assert.assertEquals ( ProductSalePageActions.getAddedQtyCountOnProduct ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ),3 );
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );

        ProductSalePageActions.clickOnEditProductTab ();
        ProductSalePageActions.decreaseQtyOfAddedProduct (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),2 );
        Assert.assertTrue (ProductSalePageActions.verifyProductDeletedFromCartSucessMsg ());
        Assert.assertFalse ( ProductSalePageActions.checkAddedProductNameDisplayed(productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        Assert.assertTrue ( ProductSalePageActions.verifyDetailsOfProductInCart () );
        Assert.assertTrue ( ProductSalePageActions.verifyTotalAmountPayableOfCart () );

        ProductSalePageActions.clickOnProductSaleTab ();
        Assert.assertTrue ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );
        Assert.assertFalse (  ProductSalePageActions.verifyProductSelectedOnListing (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ));

        ProductSalePageActions.clickOnEditProductTab ();
        ProductSalePageActions.clickOnDeleteButton ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") );
        Assert.assertTrue (ProductSalePageActions.verifyProductDeletedFromCartSucessMsg ());
        Assert.assertFalse ( ProductSalePageActions.verifyAmtPayableOfProductAddedInCart() );
        Assert.assertFalse (  ProductSalePageActions.verifyProductSelectedOnListing ( productSaleTestData.get("product_Name"),productSaleTestData.get("product_BatchNumber") ));

    }

    /*
    Creating New UnApproved patient from PRM and then checking patient is created by searching patient in the clinic
    Verifying UnApproved patient is created and checking Patient communication.
     */
    @Test(description =VERIFY_NEW_PATIENT_CREATION_FROM_PRODUCT_SALES )
    public void verifyNewPatientCreationThroughProductSales(){
        ProductSalePageActions.enterPatientName ( "Prashant kumar Rawat" );
        ProductSalePageActions.enterMobileNumber ( "1111111116" );
        ProductSalePageActions.enterPatientEmail ( "umesh.joshi@instantsys.com" );
        ProductSalePageActions.addProductQtyToCart ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),1 );
        ProductSalePageActions.clickOnSaveButton ();
        CommonPageActions.verifyPageTitle("Invoice Listing");
//        InvoiceListingPageActions.invoiceListTableColumnName();
//        InvoiceListingPageActions.invoiceDataTable();
//        InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
        InvoiceListingPageActions.checkReceiptBtn ();
        BasePatientLifeCyclePageActions.clickOnDashBoard ();
        Assert.assertEquals ( CommonPageActions.verification (),"Doctor Dashboard" );
        CommonPageActions.selectClinicFrmHeader ( PRODUCT_SALE_CLINIC);
        CommonPageActions.enterMobileNo ( "1111111116" );
        CommonPageActions.clickOnSearchBtn();
        CommonPageActions.clickOnPatient("1111111116", "Prashant kumar Rawat");
        Assert.assertEquals (  CommonPageActions.verification (),"Patient Registration");
        PatientRegistrationPageActions.verifyEditPatientName ( "Prashant kumar Rawat" );
        PatientRegistrationPageActions.verifyEditMobile ( "1111111116" );
        PatientRegistrationPageActions.verifyEditEmail ( "umesh.joshi@instantsys.com" );
        Assert.assertTrue (PatientRegistrationPageActions.checkSMSCheckBoxChecked ());
        Assert.assertFalse ( PatientRegistrationPageActions.checkCallCheckBoxChecked () );
        Assert.assertTrue ( PatientRegistrationPageActions.checkEmailCheckBoxChecked () );



    }

    /*
    Verifying Product Sale for existing Patient
    Verifying if patient is not present in clinic from where he/she is buying product then after product sale patient is getting mapped to that clinic or not
    Verifying if patient do not have email and user enter email from product sales>>Getting updated in patient profile.
     */
    @Test(description =VERIFY_PRODUCT_SALES_FOR_EXISTING_PATIENT)
    public void verifyProductSaleForExistingPatientWithoutEmail(){
        ProductSalePageActions.enterPatientName (PATIENT_NAME );
        ProductSalePageActions.enterMobileNumber (PATIENT_MOBILE );
        ProductSalePageActions.enterPatientEmail ( "noemail@clovedental.info" );
        ProductSalePageActions.addProductQtyToCart ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),1 );
        ProductSalePageActions.clickOnSaveButton ();
        CommonPageActions.verifyPageTitle("Invoice Listing");
//        InvoiceListingPageActions.invoiceListTableColumnName();
//        InvoiceListingPageActions.invoiceDataTable();
//        InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
        CommonPageActions.backTODoctorDashboard ();
        CommonPageActions.selectClinicFrmHeader ( PRODUCT_SALE_CLINIC);
        CommonPageActions.enterMobileNo (PATIENT_MOBILE );
        CommonPageActions.clickOnSearchBtn();
        CommonPageActions.clickOnPatient(PATIENT_MOBILE, PATIENT_NAME);
        Assert.assertEquals ( CommonPageActions.verification (),"Patient Dashboard" );
        if(PatientDashboardPage.dueWarningPopup.size()>0){
            PatientDashboardPageActions.hideDueWarningPopup();
        }else {
            BasePatientLifeCyclePageActions.clickOnAlert();
        }
        PatientDashboardPageActions.clickProfileEditBtn ();
        CommonPageActions.verifyPageTitle("Patient Registration");
        PatientRegistrationPageActions.verifyEditEmail ( "noemail@clovedental.info" );
        Assert.assertTrue (PatientRegistrationPageActions.checkSMSCheckBoxChecked ());
        Assert.assertTrue ( PatientRegistrationPageActions.checkCallCheckBoxChecked () );
        Assert.assertTrue ( PatientRegistrationPageActions.checkEmailCheckBoxDisable () );

    }

    /*
    Checking the Auto Suggestion when existing patient Name/Mobile Number/Patient Id is entered.
     */

    @Test(description = VERIFY_EXISTING_PATIENT_AUTO_SUGGESTION)
    public void verifyExistingPatientAutoSuggestOnProductSale (){
        ProductSalePageActions.enterPatientName (PATIENT_NAME.substring(0,PATIENT_NAME.length()-2) );
        ProductSalePageActions.autoSuggestByPatientName(PATIENT_NAME,PATIENT_MOBILE);
        Assert.assertTrue ( ProductSalePageActions.getPatientName ().equalsIgnoreCase ( PATIENT_NAME) );
        Assert.assertEquals ( ProductSalePageActions.getPatientMobile (),PATIENT_MOBILE );
        Assert.assertEquals ( ProductSalePageActions.getPatientId (),PATIENT_ID );
        Assert.assertEquals ( ProductSalePageActions.getPatientEmail (),"umesh.joshi@instantsys.com" );

        ProductSalePageActions.clickOnResetButton ();

        ProductSalePageActions.enterMobileNumber (PATIENT_MOBILE.substring(0,PATIENT_MOBILE.length()-4));
        ProductSalePageActions.autoSuggestByPatientMobile(PATIENT_MOBILE,PATIENT_NAME);
        Assert.assertTrue ( ProductSalePageActions.getPatientName ().equalsIgnoreCase ( PATIENT_NAME) );
        Assert.assertEquals ( ProductSalePageActions.getPatientMobile (),PATIENT_MOBILE );
        Assert.assertEquals ( ProductSalePageActions.getPatientId (),PATIENT_ID );
        Assert.assertEquals ( ProductSalePageActions.getPatientEmail (),"umesh.joshi@instantsys.com" );

        ProductSalePageActions.clickOnResetButton ();
        ProductSalePageActions.enterPatientId (PATIENT_ID.substring(0,PATIENT_ID.length()-1));
        ProductSalePageActions.autoSuggestByPatientId (PATIENT_ID,PATIENT_NAME,PATIENT_MOBILE);
        Assert.assertTrue ( ProductSalePageActions.getPatientName ().equalsIgnoreCase ( PATIENT_NAME) );
        Assert.assertEquals ( ProductSalePageActions.getPatientMobile (),PATIENT_MOBILE );
        Assert.assertEquals ( ProductSalePageActions.getPatientId (),PATIENT_ID );
        Assert.assertEquals ( ProductSalePageActions.getPatientEmail (),"umesh.joshi@instantsys.com" );

    }

    /*
    Verify when user have added some item to cart and user try to exit screen without creating the invoice of product added in cart
     */
    @Test(priority = 1)
    public void verifyConfirmationPopupShownOnExitingFromScreen(){
        ProductSalePageActions.enterPatientName (PATIENT_NAME);
        ProductSalePageActions.autoSuggestByPatientMobile(PATIENT_NAME,PATIENT_MOBILE);
        ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ,1);
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertTrue (ProductSalePageActions.verifyConfirmationPopUpShownOnLeavingScreen ());
        ProductSalePageActions.clickOnCancelBtnOnPopUp ();
        CommonPageActions.verifyPageTitle(Product_SALE_PAGE_TITLE);
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertTrue (ProductSalePageActions.verifyConfirmationPopUpShownOnLeavingScreen ());
        ProductSalePageActions.clickOnYesBtnOnPopUp ();
        CommonPageActions.verifyPageTitle("Doctor Dashboard" );


        DoctorDashBoardPageActions.clickOnProductSales ();
        ProductSalePageActions.enterPatientName (PATIENT_NAME );
        ProductSalePageActions.autoSuggestByPatientMobile(PATIENT_NAME,PATIENT_MOBILE);
        ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ,1);
        ProductSalePageActions.clickOnGlobalSearchBtn ();
        Assert.assertTrue (ProductSalePageActions.verifyConfirmationPopUpShownOnLeavingScreen ());
        ProductSalePageActions.clickOnYesBtnOnPopUp ();
        CommonPageActions.verifyPageTitle("Patient List" );

        CommonPageActions.backTODoctorDashboard ();
        DoctorDashBoardPageActions.clickOnProductSales ();
        ProductSalePageActions.enterPatientName (PATIENT_NAME);
        ProductSalePageActions.autoSuggestByPatientMobile(PATIENT_NAME,PATIENT_MOBILE);
        ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ,1);
        CommonPageActions.backTODoctorDashboard ();
        Assert.assertTrue (ProductSalePageActions.verifyConfirmationPopUpShownOnLeavingScreen ());
        ProductSalePageActions.clickOnYesBtnOnPopUp ();
        CommonPageActions.verifyPageTitle("Doctor Dashboard" );


        DoctorDashBoardPageActions.clickOnProductSales ();
        ProductSalePageActions.enterPatientName (PATIENT_NAME);
        ProductSalePageActions.autoSuggestByPatientMobile(PATIENT_NAME,PATIENT_MOBILE);
        ProductSalePageActions.addProductQtyToCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ,1);
        CommonPageActions.clickOnlogOut ();
        Assert.assertTrue (ProductSalePageActions.verifyConfirmationPopUpShownOnLeavingScreen ());
        ProductSalePageActions.clickOnCancelBtnOnPopUp ();
        ProductSalePageActions.clickOnEditProductTab ();
        ProductSalePageActions.clickOnDeleteButton (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"));
//        ProductSalePageActions.clickOnYesBtnOnPopUp ();
//        Assert.assertEquals ( CommonPageActions.verification (),"Clove Dental :: Login Access To Clinical View" );


    }

    /*
    Verify Product with Expiry Near to Configured days is removed on product listing
    Verify Product with Expiry Near to Configured days are Highlighted
     */
    @Test(description = VERIFY_PRODUCT_REMOVE_HIGHLIGHT_BEFORE_EXPIRY)
    public void verifyProductHighlightBeforeExpiryDate(){
        ProductSalePageActions.verifyRemoveNearExpiryProductFromListing();
        ProductSalePageActions.verifyHighlightProductInListingBeforeExpiry();
    }

/*
Verify Error Msg shown when No Qty of item is added and user click on minus button
Verify Error Msg shown when user has already the max available qty.
 */
    @Test
    public void verifyMinMaxQtyErrorOnProductListing(){
        ProductSalePageActions.removeProductQtyFromCart (productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),1  );
        Assert.assertTrue (ProductSalePageActions.verifyZeroQuantityErrorMsg ());
        ProductSalePageActions.addProductQtyToCart ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),Integer.valueOf(productSalesTestData1.get("available_Qty") ));
        Assert.assertTrue ( ProductSalePageActions.verifyMaxQtyAddedErrorMsg (productSalesTestData1.get("available_Qty") ) );
        Assert.assertTrue ( ProductSalePageActions.verifyPlusIconOnAddingMaxQtyOnListing ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        ProductSalePageActions.clickOnEditProductTab ();
        ProductSalePageActions.increaseQtyOfAddedProduct ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber"),1 );
        Assert.assertTrue ( ProductSalePageActions.verifyMaxQtyAddedErrorMsg (productSalesTestData1.get("available_Qty")) );
        Assert.assertTrue ( ProductSalePageActions.verifyPlusIconOnAddingMaxQtyOnCart ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") ) );
        ProductSalePageActions.clickOnDeleteButton ( productSalesTestData1.get("product_Name"),productSalesTestData1.get("product_BatchNumber") );
    }

    /*
    Verifying Product Sales Button Within Patient Dashboard and Redirection to Product Sale on click
     */
    @Test
    public void verifyRedirectionToProductListingFromPatientDashboardScreen(){
        CommonPageActions.backTODoctorDashboard ();
        CommonPageActions.selectClinicFrmHeader ( PRODUCT_SALE_CLINIC);
        CommonPageActions.enterMobileNo   (PATIENT_MOBILE);
        CommonPageActions.clickOnSearchBtn();
        CommonPageActions.clickOnPatient(PATIENT_MOBILE,PATIENT_NAME);
        if(PatientDashboardPage.dueWarningPopup.size()>0){
            PatientDashboardPageActions.hideDueWarningPopup();
        }else {
            BasePatientLifeCyclePageActions.clickOnAlert();
        }
        Assert.assertEquals ( CommonPageActions.verification (),"Patient Dashboard" );
        PatientDashboardPageActions.clickOnTreatmentPlanListBtn ();
        Assert.assertTrue ( PatientDashboardPageActions.verifyProductSalesButton () );
        PatientDashboardPageActions.clickOnProductSaleButton ();
        Assert.assertEquals ( CommonPageActions.verification (),Product_SALE_PAGE_TITLE);
        Assert.assertTrue (ProductSalePageActions.verifyPatientNameAndIdOnProductSale(PATIENT_NAME,PATIENT_ID) );
        Assert.assertTrue ( ProductSalePageActions.verifyLeftNavigationOnProductSale () );
        BasePatientLifeCyclePageActions.openCloseLeftNavigator();
        BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
        BasePatientLifeCyclePageActions.openCloseLeftNavigator();
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertEquals ( CommonPageActions.verification (),"Treatment Plan Listing" );
        BasePatientLifeCyclePageActions.clickOnAddNewBtn ();
        Assert.assertTrue ( PatientDashboardPageActions.verifyProductSalesButton () );
        PatientDashboardPageActions.clickOnProductSaleButton ();
        Assert.assertEquals ( CommonPageActions.verification (),Product_SALE_PAGE_TITLE);
        Assert.assertTrue (ProductSalePageActions.verifyPatientNameAndIdOnProductSale(PATIENT_NAME,PATIENT_ID) );
        Assert.assertTrue ( ProductSalePageActions.verifyLeftNavigationOnProductSale () );
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertEquals ( CommonPageActions.verification (),"Treatment Plans" );
        BasePatientLifeCyclePageActions.clickOnDashBoard ();
        PatientDashboardPageActions.clickOnInvoiceList ();
        Assert.assertEquals ( CommonPageActions.verification (),"Invoice Listing" );
        Assert.assertTrue ( PatientDashboardPageActions.verifyProductSalesButton () );
        PatientDashboardPageActions.clickOnProductSaleButton ();
        Assert.assertEquals ( CommonPageActions.verification (),Product_SALE_PAGE_TITLE);
        Assert.assertTrue (ProductSalePageActions.verifyPatientNameAndIdOnProductSale(PATIENT_NAME,PATIENT_ID) );
        Assert.assertTrue ( ProductSalePageActions.verifyLeftNavigationOnProductSale () );
        ProductSalePageActions.clickOnCancelButton ();
        Assert.assertEquals ( CommonPageActions.verification (),"Invoice Listing" );

    }

    


}
