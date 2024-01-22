package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.InvoiceListingPageActions;
import pageActions.patientDashboard.NewReceiptPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.ReceiptListingPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.SheetTest;
import utils.TestData;

public class InvoiceListingTestCase extends BaseClass {

	/**
	 * update Details of new patient to execute all test cases of invoice listing
	 */
	private static final String FILE_PATH = TestData.getInstance().getInputData("invoice_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("invoices_file_sheet_name");
	private static final String INVOICE_CREATED_DATE = TestData.getInstance().getTodayDate();
	private static final String PATIENT_NAME = TestData.getInstance().getInputData("invoice_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("invoice_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("invoice_doctor_name");
	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("invoice_doctor_nikName");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("invoice_clinic_name");

	/**
	 * test cases message which will print on the extent report after test cases
	 * execution complete
	 */

	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String INVOICE_LIST_WITHOUT_INVOICES = "Validating invoice listing page without any invoice for the a patient - #InvoiceListWithoutInvoices";
	private static final String CREATE_INVOICE = "Validating the invoice listing page after creating a invoice - #createInvoice";
	private static final String DISCOUNT_COUPON_APPLIED = "Validating the data at view modal for a particular invoice - #discountCouponApplied";
	private static final String DELETE_TREATMENT_INVOICE_DELETE = "Validating the New Receipt page - #deleteTreatmentInvoiceDelete";
	private static final String INVOICE_LISTING_VIEW_MODAL = "Validating discount popup of the invoice - #invoiceListingViewModal";
	Map<String, String> billingData = null;
	Map<String, String> patntTrtmntPlanData = null;

	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		billingData = SheetTest.prepareData("BillingData", "Billing", "A1", "Z");
		patntTrtmntPlanData = SheetTest.prepareData("Treatment&Plan", "TreatmentPlans", "A1", "Z");
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(MOBILE_NUMBER, PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();
	}

	/**
	 * checked side navigation all module button checked header of the invoice
	 * listing page checked patient name and patient id at invoice listing checked
	 * receipt button checked patient Dash board button checked treatment status
	 * drop down its options and its default selection checked invoices status drop
	 * down its options and its default selection checked date filter checked show
	 * details button checked search button and reset button checked for first time
	 * total due amount and total advance amount checked collect advance payment
	 * button checked No Record Found message!
	 */

	@Test(groups = { "Regression" }, priority = 1)
	public void InvoiceListWithoutInvoices() {
		logger.log(Status.PASS, INVOICE_LIST_WITHOUT_INVOICES);

		PatientDashboardPageActions.clickOnInvoiceList();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		InvoiceListingPageActions.headerPage("Invoice Listing");
		InvoiceListingPageActions.verifyUserName(billingData.get("patient_name2"));
		InvoiceListingPageActions.checkReceiptBtn();
		BasePatientLifeCyclePageActions.commonDashBoardBtnVerify();
		InvoiceListingPageActions.invoiceStatusDropDown("Select Invoice Status");
		InvoiceListingPageActions.showDetailsCheckBox();
		InvoiceListingPageActions.checkSearchBtn();
		InvoiceListingPageActions.checkResetBtn();
		InvoiceListingPageActions.amountSection();
		InvoiceListingPageActions.checkCollectAdvacePaymentBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Invoice Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/**
	 * creating a treatment for the patient checked Appointment not available
	 * withing last 24 hr then booking an appointment start the treatment from the
	 * treatment plan listing Invoice created and checked the invoices listing
	 */

	@Test(groups = { "Regression", "Smoke", "Sanity", "Functional" }, priority = 2)
	public void createInvoice() {
		logger.log(Status.PASS, CREATE_INVOICE);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.clickOnTeethImageFromTreatmentList("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan2"));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(billingData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.selectTimeSlotFromDropdown("20:00");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyStartBtn(INVOICE_CREATED_DATE);
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(INVOICE_CREATED_DATE);
		WorksDonePageActions.clickInvoiceListBtn();
		InvoiceListingPageActions.invoiceListTableColumnName();
		InvoiceListingPageActions.invoiceDataTable();
		InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
		Assert.assertTrue(CommonPageActions.verification().contains("Invoice Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/**
	 * open coupon modal checked message if we try to save the coupon modal without
	 * any changes checked patient name at coupon modal checked header of the coupon
	 * modal checked invoice number.invoice created date checked total due amount at
	 * coupon modal checked column name at coupon modal for the treatment Applied
	 * coupon in percentage and also validated the effective price validated coupon
	 * adjustment notes text fields and enter notes Again reopen the coupon modal
	 * and applied in amount checked effective prize at coupon amount close the
	 * coupon modal same treatment checking at treatment listing coupon applied also
	 * same treatment with applied coupon checked view modal at treatment plan
	 * listing
	 */
	@Test(groups = { "Regression", "Sanity", "Functional" }, priority = 3)
	public void discountCouponApplied() {
		logger.log(Status.PASS, DISCOUNT_COUPON_APPLIED);

		PatientDashboardPageActions.hideDueWarningPopup();

		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.openCouponModal(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.withoutChangeCouponMsg();
		InvoiceListingPageActions.checkPatientNameCouponModal(billingData.get("patient_name2"));
		InvoiceListingPageActions.headerCouponPopup();
		InvoiceListingPageActions.invoiceNumberInvoiceDate(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.couponAdjustmentNotes("coupon notes");
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.updateCouponValueCouponBasAddCouponAdjustmentNotes();
		InvoiceListingPageActions.closeModal();
		InvoiceListingPageActions.openCouponModal(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.totalDueCouponModal();
		InvoiceListingPageActions.treatmentTable("Employee Discount", 200);
		InvoiceListingPageActions.couponAdjustmentNotes("coupon notes");
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.openCouponModal(INVOICE_CREATED_DATE);

//      InvoiceListingPageActions.treatmentTableAfterCouponApplied("Employee Discount",200);

		/* Deprecated As Percentage coupon discount has been removed from invoice */
//        InvoiceListingPageActions.treatmentTable("Amt",20);
//        InvoiceListingPageActions.saveModalDetails();
//        InvoiceListingPageActions.openCouponModal(INVOICE_CREATED_DATE);
//        InvoiceListingPageActions.treatmentTableAfterCouponApplied("Amt",20);

		InvoiceListingPageActions.closeModal();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions
				.verifyCouponImpactInMainList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions
				.verifyCouponImpactInMainList(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnViewBtn(INVOICE_CREATED_DATE);
		TreatmentPlanListingPageActions.couponDiscountInViewPopup(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions
				.verifyCouponImpactInMainList(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}

	/**
	 * open the delete modal validated the patient name at delete modal checked
	 * invoice number and invoice created checked total due amount validated delete
	 * reason drop down and it options validated msg if user try to delete the
	 * treatment without selecting any treatment and reason validated message if
	 * user selected reason but not selected any treatment selected a treatment and
	 * deleted after deleted and coupon applied the invoice checked invoice listing
	 * again open the delete modal and deleted the invoice again checked the same
	 * invoice at the invoice listing after deleted the invoice by selecting the
	 * show details modal search for deleted invoices checked all coupon adjusted,
	 * treatment deleted and both treatment deleted and coupon adjusted checked both
	 * treatment deleted at the treatment listing and treatment plan listing view
	 * modal
	 */

	@Test(groups = { "Regression" }, priority = 4)
	public void invoiceListingViewModal() {
		logger.log(Status.PASS, INVOICE_LISTING_VIEW_MODAL);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.invoiceListTableColumnName();
		InvoiceListingPageActions.invoiceDataTable();
		InvoiceListingPageActions.netAmountAllInvoices();
		InvoiceListingPageActions.couponAmountAllInvoices();
		InvoiceListingPageActions.amountDueAllInvoices();
		InvoiceListingPageActions.amountPaidAllInvoices();
		InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
		InvoiceListingPageActions.checkCollectPaymentBtn();
		InvoiceListingPageActions.openViewModal();
		InvoiceListingPageActions.patientNamePatientId(billingData.get("patient_name2"));
		InvoiceListingPageActions.totalDueViewModal();
		InvoiceListingPageActions.closeViewModal();
		Assert.assertTrue(CommonPageActions.verification().contains("Invoice Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}

	@Test(groups = { "Regression", "Smoke", "Sanity", "Functional" }, priority = 5)
	public void deleteTreatmentInvoiceDelete() {
		logger.log(Status.PASS, DELETE_TREATMENT_INVOICE_DELETE);

		PatientDashboardPageActions.hideDueWarningPopup();

		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.openDeleteModal(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.checkPatientNameDeleteModal(billingData.get("patient_name2"));
		InvoiceListingPageActions.checkHeaderDeleteModal();
		InvoiceListingPageActions.invoiceNumberInvoiceDate(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.totalDueDeleteModal();
		InvoiceListingPageActions.invoiceDeleteReason("Select Reasons");
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.errorNoReasonSelected();
		InvoiceListingPageActions.selectDeleteReason("Incorrect treatment plan");
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.errorMsgTreatmentNotSelected();
		InvoiceListingPageActions.selectTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		InvoiceListingPageActions.saveModalDetails();
//      InvoiceListingPageActions.correctionNotes(INVOICE_CREATED_DATE,"Invoice/Treatment(s) deleted successfully!");
		InvoiceListingPageActions.openDeleteModal(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.selectDeleteReason("Incorrect treatment plan");
		InvoiceListingPageActions.selectTreatment("all");
		InvoiceListingPageActions.saveModalDetails();
		InvoiceListingPageActions.selectShowDetails();
		InvoiceListingPageActions.clickOnSearch();
		InvoiceListingPageActions.invoiceDeleted(INVOICE_CREATED_DATE);
		InvoiceListingPageActions.negativeInvoiceAfterDelete(INVOICE_CREATED_DATE);
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
//      BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions
				.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions
				.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnViewBtn(INVOICE_CREATED_DATE);
		TreatmentPlanListingPageActions
				.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions
				.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}

	/**
	 * checked invoices column name checked for each invoice created date,invoices
	 * status,invoices number,treatment status,net amount,coupon amount,amount
	 * due,amount paid,doctor,correction notes checking for all invoices together
	 * net amount,coupon amount,amount due,amount paid checked actions button coupon
	 * button,view button,delete button,receipt button and print button on the basis
	 * of the invoices created date selected a random invoice and open view modal
	 * checked header,patient name ,patient Id and save and close button. checked
	 * all treatment for that particular invoice if treatment is deleted from the
	 * invoices then checked correction deletion entry for the treatment at view
	 * modal in correction detail. if coupon adjusted then checked correction coupon
	 * adjustment entry at view modal checked notes section for the both cases
	 * either with note or without note after executed the view modal scenario it
	 * will close the popup
	 */

	@Test(groups = { "Regression", "Smoke", "Sanity", "Functional" }, priority = 6)
	public void createAndPayInvoice() {
		logger.log(Status.PASS, CREATE_INVOICE);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();

		OralExamsPageActions.clickOnTeethImageFromTreatmentList("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan2"));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
//      BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(billingData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyStartBtn(INVOICE_CREATED_DATE);
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(INVOICE_CREATED_DATE);
		WorksDonePageActions.clickInvoiceListBtn();
		InvoiceListingPageActions.invoiceListTableColumnName();
		InvoiceListingPageActions.invoiceDataTable();
		InvoiceListingPageActions.actionsButton_InvoicesCreatedDate();
		Assert.assertTrue(CommonPageActions.verification().contains("Invoice Listing"));
		InvoiceListingPageActions.collectPayment();
		NewReceiptPageActions.invoiceTable();
		NewReceiptPageActions.makePayment("Partial", "Cash", "NA", "NA");
		ReceiptListingPageActions.checkReceiptListingTableHead();
//		ReceiptListingPageActions.actionsButton_ReceiptsCreatedDate();
		ReceiptListingPageActions.receiptDataTable();
		ReceiptListingPageActions.openViewModal();
		ReceiptListingPageActions.receiptHeaderInView("Receipt Details");
		ReceiptListingPageActions.patientNamePatientId(billingData.get("patient_name2"));
		ReceiptListingPageActions.checkDataInView();
		ReceiptListingPageActions.viewData();
		ReceiptListingPageActions.closeViewModal();
		ReceiptListingPageActions.clickOnPayInvoice();
		NewReceiptPageActions.invoiceTable();
		NewReceiptPageActions.makePayment("Full", "Cash", "NA", "NA");
		ReceiptListingPageActions.checkReceiptListingTableHead();
		BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}
}
