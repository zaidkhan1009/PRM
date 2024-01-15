package tests;

import com.aventstack.extentreports.Status;

import utils.SheetTest;
import utils.TestData;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.MiscellaneousCallListingPageActions;
import pageActions.doctorDashboard.MiscellaneousCallPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.InvoiceListingPageActions;
import pageActions.patientDashboard.NewReceiptPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.ReceiptListingPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorksDonePageActions;

public class NewReceiptTestCase extends BaseClass{

	/*
	 * Storing mandatory input required to run LWO test cases,make sure you
	 * update the mandatory input before running the test cases
	 *
	 */
	private static final String FILE_PATH = TestData.getInstance().getInputData("receipt_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("receipt_file_sheet_name");
	private static final String PATIENT_NAME= TestData.getInstance().getInputData("receipt_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("receipt_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("receipt_doctor_name");
	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("receipt_doctor_nikName");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("receipt_clinic_name");
	private static final String INVOICE_CREATED_DATE=TestData.getInstance().getTodayDate();

	/*
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG  = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS  = "@@ Test script has been completed @@";

	Map<String, String> billingData = null;
	Map<String, String> patntTrtmntPlanData = null;

	/*
	 * loginPage with username and password
	 * search for patients from the doctor dashboard
	 * verified patients will redirect at the patient dashboard
	 */

	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		billingData = SheetTest.prepareData("BillingData","Billing","A1","Z");
		patntTrtmntPlanData = SheetTest.prepareData("Treatment&Plan","TreatmentPlans","A1","Z");
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(billingData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(billingData.get("patient_mobile"), billingData.get("patient_name"));
		PatientDashboardPageActions.hideDueWarningPopup();
	}


	@Test(groups ={"Regression","Sanity","Functional"},enabled= true, priority = 1)
	public void checkedAdvanceReceiptAndListUI() {
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.clickOnReceiptList();
		BasePatientLifeCyclePageActions.headerOnAddPage("Receipt Listing");
		NewReceiptPageActions.collectAdvancePayment();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		BasePatientLifeCyclePageActions.verifyPatientName(billingData.get("patient_name"));
		NewReceiptPageActions.checkActionBtnForAdvance();
		NewReceiptPageActions.checkModesAndTextFields();
		//		NewReceiptPageActions.checkCollectAdvanceAndAddPaymentBtn();
		NewReceiptPageActions.checkAndSelectAllModes(billingData.get("PaymentModeCash"),billingData.get("Amount"), billingData.get("CheqTrnxNo"),billingData.get("Bank Name"));
		NewReceiptPageActions.checkSubTypeOfModes(billingData.get("PaymentModeCash"));
		NewReceiptPageActions.checkCash();
		NewReceiptPageActions.checkAndSelectAllModes(billingData.get("PaymentModeWallet"),billingData.get("Amount"), billingData.get("CheqTrnxNo"),billingData.get("Bank Name"));
		NewReceiptPageActions.checkSubTypeOfModes(billingData.get("PaymentModeWallet"));
		NewReceiptPageActions.checkAndSelectAllModes(billingData.get("PaymentModeOthers"),billingData.get("Amount"), billingData.get("CheqTrnxNo"),billingData.get("Bank Name"));
		NewReceiptPageActions.checkSubTypeOfModes(billingData.get("PaymentModeOthers"));
		NewReceiptPageActions.checkAndSelectAllModes(billingData.get("PaymentModeCard"),billingData.get("Amount"), billingData.get("CheqTrnxNo"),billingData.get("Bank Name"));
		NewReceiptPageActions.checkSubTypeOfModes(billingData.get("PaymentModeCard"));
		NewReceiptPageActions.selectSubType(billingData.get("CardBajaj"));
		NewReceiptPageActions.checkTxnIdOfSubType(billingData.get("CardBajaj"));
		NewReceiptPageActions.selectSubType(billingData.get("EMI"));
//		NewReceiptPageActions.checkTxnIdOfSubType(billingData.get("EMI"));                  EMI doesn't have txn id 
		//		NewReceiptPageActions.checkCheque();
		//		NewReceiptPageActions.checkNetBanking();
		NewReceiptPageActions.checkAndSelectAllModes(billingData.get("PaymentModeWallet"),billingData.get("Amount"), billingData.get("CheqTrnxNo"),billingData.get("Bank Name"));
		NewReceiptPageActions.checkSubTypeOfModes(billingData.get("PaymentModeWallet"));
		NewReceiptPageActions.selectSubType("UPI");
		NewReceiptPageActions.clickDashboardBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnReceiptList();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		ReceiptListingPageActions.verifyPatientName(billingData.get("patient_name"));
		ReceiptListingPageActions.checkData();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}

	@Test(groups ={"Regression","Functional"},enabled= true, priority = 2)
	public void checkValidationMsgs() {
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnReceiptList();
		BasePatientLifeCyclePageActions.headerOnAddPage("Receipt Listing");
		NewReceiptPageActions.collectAdvancePayment();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.clickSaveBtn();
		NewReceiptPageActions.checkedErrorMode("Please select mode!");
		NewReceiptPageActions.checkedErrorAmount("Please enter amount!");
		NewReceiptPageActions.selectModes("Card");
		NewReceiptPageActions.checkedErrorSubType("Please select type!");
		NewReceiptPageActions.selectSubType("Bajaj Finance");
		NewReceiptPageActions.checkedErrorTxnId("Enter txn id!");
		NewReceiptPageActions.checkedErrorAmount("Please enter amount!");
		NewReceiptPageActions.selectModes("Others");
		NewReceiptPageActions.selectSubType("Cheque");
		NewReceiptPageActions.checkedErrorChequeNo("Enter cheque number!");
		NewReceiptPageActions.checkedErrorBankName("Enter bank name!");
		NewReceiptPageActions.checkedErrorAmount("Please enter amount!");
		NewReceiptPageActions.selectSubType("NetBanking");
		NewReceiptPageActions.checkedErrorTxnRefId("Enter txn id!");
		NewReceiptPageActions.checkedErrorBankName("Enter bank name!");
		NewReceiptPageActions.checkedErrorAmount("Please enter amount!");
		NewReceiptPageActions.selectModes("Wallet");
		NewReceiptPageActions.checkedErrorSubType("Please select type!");
		NewReceiptPageActions.checkedErrorAmount("Please enter amount!");
		NewReceiptPageActions.clickDashboardBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnReceiptList();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}

	@Test(groups ={"Regression","Smoke","Sanity","Functional"},enabled= true, priority = 3)
	public void collectPayment() {
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnReceiptList();
		BasePatientLifeCyclePageActions.headerOnAddPage("Receipt Listing");
		NewReceiptPageActions.collectAdvancePayment();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Cash", "10", "NA", "NA");
		NewReceiptPageActions.enterNotes("cash Test");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Card", "10", "NA", "NA");
		NewReceiptPageActions.selectSubType("Bajaj Finance");
		NewReceiptPageActions.enterTxnId("123456");
		NewReceiptPageActions.enterNotes("Bajaj Finance");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Card", "10", "NA", "NA");
		NewReceiptPageActions.selectSubType("Kotak Finance");
		NewReceiptPageActions.enterTxnId("123456");
		NewReceiptPageActions.enterNotes("Kotak Test");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Others", "100", "654321", "SBI Bank");
		NewReceiptPageActions.selectSubType("Cheque");
		NewReceiptPageActions.enterCheckOrNetBankTxn("654321","SBI");
		NewReceiptPageActions.enterNotes("cheque Test");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Others", "100", "222222", "SBI Bank");
		NewReceiptPageActions.selectSubType("NetBanking");
		NewReceiptPageActions.enterCheckOrNetBankTxn("123456","SBI");
		NewReceiptPageActions.enterNotes("Net Banking Test");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.headerOfPage("New Receipts (Advance)");
		NewReceiptPageActions.checkAndSelectAllModes("Wallet", "100", "NA", "NA");
		NewReceiptPageActions.selectSubType("UPI");
		NewReceiptPageActions.enterNotes("Paytm UPI");
		NewReceiptPageActions.enterTxnId("TRX12345678");
		NewReceiptPageActions.addAmountInDraft();
		NewReceiptPageActions.clickSaveBtn();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.checkTotalAdvance();
		ReceiptListingPageActions.checkReceiptListingTableHead();
		ReceiptListingPageActions.checkTotalAdvance();
		//		ReceiptListingPageActions.actionsButton_ReceiptsCreatedDate();
		ReceiptListingPageActions.receiptDataTable();
		ReceiptListingPageActions.openViewModal();
		ReceiptListingPageActions.receiptHeaderInView("Receipt Details");
		ReceiptListingPageActions.patientNamePatientId(billingData.get("patient_name"));
		ReceiptListingPageActions.checkDataInView();
		ReceiptListingPageActions.viewData();
		ReceiptListingPageActions.closeViewModal();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();

	}
	@Test(groups ={"Regression","Functional"},enabled= true, priority = 4)
	public void editReceipt() {
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnReceiptList();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.clickEditBtn("Card");
		NewReceiptPageActions.headerOfPage("Edit Receipts");
		BasePatientLifeCyclePageActions.verifyPatientName(billingData.get("patient_name"));
		NewReceiptPageActions.checkEditReceiptData("Card", "Kotak Finance");
		NewReceiptPageActions.checkActionBtnForAdvance();
		NewReceiptPageActions.selectModes("Others");
		NewReceiptPageActions.selectSubType("Cheque");
		NewReceiptPageActions.enterCheckOrNetBankTxn("124009","SBI");
		NewReceiptPageActions.enterNotes("cheque Test Edited");
		NewReceiptPageActions.clickSaveBtn();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.openViewModal();
		ReceiptListingPageActions.receiptHeaderInView("Receipt Details");
		ReceiptListingPageActions.patientNamePatientId(billingData.get("patient_name"));
		ReceiptListingPageActions.viewData();
		ReceiptListingPageActions.closeViewModal();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.clickEditBtn("Cash");
		NewReceiptPageActions.headerOfPage("Edit Receipts");
		BasePatientLifeCyclePageActions.verifyPatientName(billingData.get("patient_name"));
		NewReceiptPageActions.checkEditReceiptData("Cash", "NA");
		NewReceiptPageActions.checkActionBtnForAdvance();
		NewReceiptPageActions.selectModes("Card");
		NewReceiptPageActions.selectSubType("HDFC Paper Fin");
		NewReceiptPageActions.enterTxnId("1234");
		NewReceiptPageActions.enterNotes("Testing");
		NewReceiptPageActions.clickSaveBtn();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.openViewModal();
		ReceiptListingPageActions.receiptHeaderInView("Receipt Details");
		ReceiptListingPageActions.patientNamePatientId(billingData.get("patient_name"));
		ReceiptListingPageActions.viewData();
		ReceiptListingPageActions.closeViewModal();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}

	@Test(groups ={"Regression","Functional"},enabled= true, priority = 5)
	public void deleteReceipt() {
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		logger.log(Status.PASS, "Test");
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnReceiptList();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.clickDeleteBtn("Cash");
		ReceiptListingPageActions.checkRequireDropDwn();
		ReceiptListingPageActions.selectRequire("Advance refund");
		ReceiptListingPageActions.clickSaveBtnOnReasonPopUp();
		ReceiptListingPageActions.verifySuccessfullMessage();
		ReceiptListingPageActions.headerOnListPage("Receipt Listing");
		ReceiptListingPageActions.clickShowDetails();
		ReceiptListingPageActions.clickSearchBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}

	@Test(groups ={"Regression"},priority = 6)
	public void createInvoice(){
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan2"));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.appointmentAvailable();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(billingData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyStartBtn(INVOICE_CREATED_DATE);
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(INVOICE_CREATED_DATE);
		WorksDonePageActions.clickInvoiceListBtn();
		InvoiceListingPageActions.invoiceListTableColumnName();
		InvoiceListingPageActions.invoiceDataTable();
		InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
		Assert.assertTrue(CommonPageActions.verification().contains("Invoice Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}
	@Test(groups ={"Regression"},priority = 7)
	public void amountCalculation(){
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.invoiceListTableColumnName();
		InvoiceListingPageActions.invoiceDataTable();
		InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
		InvoiceListingPageActions.collectPayment();
		NewReceiptPageActions.headerOfPage("New Receipts");
		BasePatientLifeCyclePageActions.verifyPatientName(billingData.get("patient_name"));
		NewReceiptPageActions.invoiceTable();
//		NewReceiptPageActions.alertMessages();           FUNCTIONALITY REMOVED
		NewReceiptPageActions.addingReceiptEqualRemainingAmount();
		NewReceiptPageActions.clickSaveBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();

	}
	@Test(groups ={"Regression","Functional"},priority = 8)
	public void paymentDetails(){
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.collectPayment();
		NewReceiptPageActions.checkAndSelectAllModes("Cash", "100", "NA", "NA");
		NewReceiptPageActions.enterNotes("cash Added");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.checkAndSelectAllModes("Card", "100", "NA", "NA");
		NewReceiptPageActions.selectSubType("Bajaj Finance");
		NewReceiptPageActions.enterTxnId("654321");
		NewReceiptPageActions.enterNotes("card added");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.checkAndSelectAllModes("Others", "100", "123456", "SBI Bank");
		NewReceiptPageActions.selectSubType("Cheque");
		NewReceiptPageActions.enterCheckOrNetBankTxn("654321","SBI");
		NewReceiptPageActions.enterNotes("cheque Added");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.checkAndSelectAllModes("Others", "100", "123456", "SBI Bank");
		NewReceiptPageActions.selectSubType("NetBanking");
		NewReceiptPageActions.enterCheckOrNetBankTxn("123454","SBI");
		NewReceiptPageActions.enterNotes("Net Banking Added");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.checkAndSelectAllModes("Wallet", "100", "NA", "NA");
		NewReceiptPageActions.selectSubType("UPI");
		NewReceiptPageActions.enterNotes("Paytm UPI");
		NewReceiptPageActions.enterTxnId("TRX12345609");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.paymentDetailsTable("Cash","100","NA","NA");
		NewReceiptPageActions.paymentDetailsTable("Card","100","NA","654321");
		NewReceiptPageActions.paymentDetailsTable("Others","100","SBI Bank","123456");
		NewReceiptPageActions.paymentDetailsTable("Others","100","SBI Bank","123456");
		NewReceiptPageActions.paymentDetailsTable("Wallet","100","NA","NA");
		NewReceiptPageActions.totalReceipt_RemainingAmountDue();
		NewReceiptPageActions.deleteReceipt("Cash","100");
		NewReceiptPageActions.noDeleteReceipt();
		NewReceiptPageActions.paymentDetailsTable("Cash","100","NA","NA");
		NewReceiptPageActions.deleteReceipt("Cash","100");
		NewReceiptPageActions.yesDeleteReceipt();
		NewReceiptPageActions.checkDeletedReceipt("Cash","100");
		NewReceiptPageActions.totalReceipt_RemainingAmountDue();
		Assert.assertTrue(CommonPageActions.verification().contains("New Receipts"));
		BasePatientLifeCyclePageActions.verifyPatientName(billingData.get("patient_name"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		NewReceiptPageActions.yesDeleteReceipt();
		PatientDashboardPageActions.clickOnReceiptList();
		Assert.assertTrue(CommonPageActions.verification().contains("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}
	
	
	@Test(groups ={"Regression","Functional"},priority = 9)
	public void amountScenario(){
		logger.log(Status.PASS, SCRIPTS_STARTED_MSG );
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.collectPayment();
		NewReceiptPageActions.checkAndSelectAllModes("Cash", "100", "NA", "NA");
		NewReceiptPageActions.enterNotes("cash Added");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.totalReceipt_RemainingAmountDue();
		NewReceiptPageActions.invoiceTable();
		NewReceiptPageActions.totalDue_totalCollection();
		NewReceiptPageActions.addingReceiptEqualRemainingAmount();
		NewReceiptPageActions.totalReceipt_RemainingAmountDue();
		NewReceiptPageActions.invoiceTable();
		NewReceiptPageActions.totalDue_totalCollection();
		NewReceiptPageActions.totalReceipt_RemainingAmountDue();
		NewReceiptPageActions.invoiceTable();
		NewReceiptPageActions.totalDue_totalCollection();
		NewReceiptPageActions.checkAndSelectAllModes("Cash", "100", "NA", "NA");
		NewReceiptPageActions.saveDraftAmount();
		NewReceiptPageActions.advanceCreatedNewReceipt();
		NewReceiptPageActions.clickSaveBtn();
		Assert.assertTrue(CommonPageActions.verification().equals("Receipt Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
	}
}
