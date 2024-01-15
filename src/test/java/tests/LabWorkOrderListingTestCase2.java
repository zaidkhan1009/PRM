package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import utils.ExcelReader;
import utils.TestData;
import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.InvoiceListingPageActions;
import pageActions.patientDashboard.LabWorkOrderEditPageActions;
import pageActions.patientDashboard.LabWorkOrderListingPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;

public class LabWorkOrderListingTestCase2 extends BaseClass {

	/*
	 * Storing mandatory input required to run work done test cases or please update
	 * the mandatory input before running the test cases
	 */
	private static final String FILE_PATH = TestData.getInstance().getInputData("lab_work_order2_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("lab_work_order2_file_sheet_name");
	private static final String PATIENT_NAME = TestData.getInstance().getInputData("lab_work_order2_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("lab_work_order2_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("lab_work_order2_doctor_name");
	private static final String DOCTOR_FIRST_NAME = TestData.getInstance()
			.getInputData("lab_work_order2_doctor_first_name");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("lab_work_order2_clinic_name");
	private static final String TODAY_DATE = TestData.getInstance().getTodayDate();
	private static final String START_DATE_TIME = TestData.getInstance().getFewMinuteBackFromCurrentDateTime();
	private static final String END_DATE_TIME = TestData.getInstance().getFewMinuteAfterFromCurrentDateTime();
	private static String SLOT_TIME = null;

	/*
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String CHECK_SUSPEND_RELATED_SCENARIO_ON_LAB_WORK_ORDER = "Validate Scenerio of Suspend related and check the impact on Lab Work Order -#checkSuspendRelatedScenarioOnLabWorkOrder";
	private static final String CHECK_SUSPEND_RELATED_ANOTHER_SCENARIO_ON_LAB_WORK_ORDER = "Validate Another Scenerio of Suspend related and check the impact on Lab Work Order -#CheckSuspendRelatedAnotherScenerioOnLWO";
	private static final String CHECK_BRIDGEABLE_RELATED_SCENARIO = "Validate Bridgeable related Scenario and Check the Impact on LWO -#checkbridgeableRelatedScenerio";
	private static final String CHECK_BY_ARCH_RELATED_SCENARIO = "Validate ByArch related Scenario and Check the Impact on LWO -#checkByArchRelatedScenario";

	/*
	 * loginPage with username and password search for patients from the doctor
	 * dashboard verified patients will redirect at the patient dashboard
	 */

	@BeforeMethod
	public void testSetup() {
		CommonPageActions.selectClinicFrmHeader(CLINIC_NAME);
		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(MOBILE_NUMBER, PATIENT_NAME);
		Assert.assertTrue(CommonPageActions.verification().contains("Patient Dashboard"));
	}

	@Test(enabled = true, priority = 1)
	public void checkSuspendRelatedScenarioOnLabWorkOrder() {
		logger.log(Status.PASS, CHECK_SUSPEND_RELATED_SCENARIO_ON_LAB_WORK_ORDER);
		// SLOT_TIME = "13:00";

		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(DOCTOR_NAME);
		SLOT_TIME = AppointmentAddPageActions.getTimeSlotFromDropdown();
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();

		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.selectMultipleTeeth("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));
		OralExamsPageActions.clickOnTeethImage("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		TreatmentPlansPageActions.clickOnYes();
		TreatmentPlansPageActions.clickOnIpCDOPBank();
		TreatmentPlansPageActions.clickOnSearchField(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 1));
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 1));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickLWOBtnWD();

		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.clickOnEdit(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));
		LabWorkOrderEditPageActions.selectLab(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 0));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.selectItemsSend(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 5));
		LabWorkOrderEditPageActions.addFile(System.getProperty("user.dir") + "\\PatientFiles\\"
				+ ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 21));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.selectRequire(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 10));
		LabWorkOrderEditPageActions.selectShade(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 11));
		LabWorkOrderEditPageActions.selectShadeOptionFromDrpDwn(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 12));
		LabWorkOrderEditPageActions.selectStainsInternal(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 13));
		LabWorkOrderEditPageActions.selectStainsExternal(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 14));
		LabWorkOrderEditPageActions.addTransluency(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 15));
		LabWorkOrderEditPageActions.addTexture(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 16));
		LabWorkOrderEditPageActions.selectConfigurations(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 17),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 18));
		LabWorkOrderEditPageActions.enterNotes(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 20));
		LabWorkOrderEditPageActions.clickSubmittedToLab();
		LabWorkOrderListingPageActions.verifySuccessfullMessage();

		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		BasePatientLifeCyclePageActions.clickOnDashBoard();

		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickSuspendBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));
		WorksDonePageActions.selectRequire("Assuring for refund.");
		WorksDonePageActions.clickSaveBtnOnReasonPopUp();
		WorksDonePageActions.clickLWOBtnWD();

		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkInActiveEntry(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 7), "Trt. Suspended");
		LabWorkOrderListingPageActions.checkInActiveRevisionReasonMainList(
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4), ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 7),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 8));
		LabWorkOrderListingPageActions.checkInActiveViewBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 7));

		// LabWorkOrderListingPageActions.checkDateTimeMainList(ExcelReader.
		// readExcelData(FILE_PATH, // // SHEET, 3, 4),START_DATE_TIME, END_DATE_TIME);

		LabWorkOrderListingPageActions
				.checkSourceForSuspAndRetreatMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));

		LabWorkOrderListingPageActions.checkSourceMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 7), ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 8));
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));

		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions
				.checkSourceForSuspendedViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4), "Suspended");
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9));
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 9));
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionNoViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 22));
		LabWorkOrderListingPageActions.verifyRevisionDateInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 9));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();

		PatientDashboardPageActions.clickOnWorkDoneAdd();

		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.completePaymentToCompleteTrt();

		WorksDonePageActions.selectTime(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 2), "15");
		WorksDonePageActions.enterRemarks(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 2), "Change to complete");
		WorksDonePageActions.selectStages(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 2), "Cementation");
		WorksDonePageActions.clickOnAdd(ExcelReader.readExcelData(FILE_PATH, SHEET, 20, 2));
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		WorksDonePageActions.clickLWOBtnWD();

		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkStatusDateMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 9), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9));
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 9));
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 9));
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 9));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		WorkDoneHistoryPageActions.clickReOpenBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));
		WorkDoneHistoryPageActions.selectRequire("Patient returned back for the treatment.");
		WorkDoneHistoryPageActions.clickSaveBtnOnReasonPopUp();
		WorksDonePageActions.clickLWOBtnWD();

		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");

		LabWorkOrderListingPageActions.checkInActiveEntry(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 7), "Trt. Reopened");
		LabWorkOrderListingPageActions.checkInActiveRevisionReasonMainList(
				ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4), ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 7),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 5, 8));
		LabWorkOrderListingPageActions.checkInActiveViewBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 7));
		LabWorkOrderListingPageActions.checkDateTimeMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions
				.checkSourceForSuspAndRetreatMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4));
		LabWorkOrderListingPageActions.checkSourceMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));

		LabWorkOrderListingPageActions.checkRevisionReasonMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 7), ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 8));
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");

		// Not validating below options right now

		/*
		 * LabWorkOrderListingPageActions.checkSourceForReopenAndTrtCompleteViewList(
		 * ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4), "Reopened");
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 1, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 2, 9));
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 1, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 2, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.checkRevisionNoViewList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 3, 22));
		 * LabWorkOrderListingPageActions.verifyRevisionDateInView(START_DATE_TIME,
		 * END_DATE_TIME);
		 * LabWorkOrderListingPageActions.checkCurrentStatusViewList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 2, 9));
		 * 
		 * LabWorkOrderListingPageActions.clickViewScreenClose();
		 * BasePatientLifeCyclePageActions.clickOnDashBoard();
		 * 
		 * BasePatientLifeCyclePageActions.clickOnAlert();
		 * PatientDashboardPageActions.clickOnWorkDoneAdd();
		 * BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		 * WorksDonePageActions.selectTime(ExcelReader.readExcelData(FILE_PATH, SHEET,
		 * 20, 2), "15");
		 * WorksDonePageActions.enterRemarks(ExcelReader.readExcelData(FILE_PATH, SHEET,
		 * 20, 2), "Change to complete");
		 * WorksDonePageActions.selectStages(ExcelReader.readExcelData(FILE_PATH, SHEET,
		 * 20, 2), "Cementation");
		 * WorksDonePageActions.clickOnAdd(ExcelReader.readExcelData(FILE_PATH, SHEET,
		 * 20, 2));
		 * BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		 * WorksDonePageActions.clickLWOBtnWD();
		 * BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		 * LabWorkOrderListingPageActions.checkStatusDateMainList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 3, 4), ExcelReader.readExcelData(FILE_PATH,
		 * SHEET, 4, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 3, 4));
		 * LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		 * LabWorkOrderListingPageActions.checkSourceForReopenAndTrtCompleteViewList(
		 * ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4),
		 * ExcelReader.readExcelData(FILE_PATH, SHEET, 6, 8));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 1, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 2, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 4, 9));
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 1, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 2, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 4, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.checkCurrentStatusViewList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 4, 9));
		 * LabWorkOrderListingPageActions.clickViewScreenClose();
		 * BasePatientLifeCyclePageActions.clickOnDashBoard();
		 * BasePatientLifeCyclePageActions.clickOnAlert();
		 * PatientDashboardPageActions.clickOnInvoiceList();
		 * InvoiceListingPageActions.headerPage("Invoice Listing"); //
		 * InvoiceListingPageActions.clickInvoicePaymentBtn(); //
		 * newReceiptPage.headerNewReceipt("New Receipt"); //
		 * newReceiptPage.clickPaymentByInvoice(); //
		 * newReceiptPage.collectByInvoiceNewReceipts(5980); //
		 * newReceiptPage.selectPaymentMode("Cash"); //
		 * newReceiptPage.saveNewReceipts();
		 * BasePatientLifeCyclePageActions.clickOnDashBoard();
		 * BasePatientLifeCyclePageActions.clickOnAlert();
		 * PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		 * BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		 * LabWorkOrderListingPageActions.checkStatusDateMainList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 3, 4), ExcelReader.readExcelData(FILE_PATH,
		 * SHEET, 5, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 3, 4));
		 * LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		 * LabWorkOrderListingPageActions.checkSourceForReopenAndTrtCompleteViewList(
		 * ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 4),
		 * "Payment and Trt. Completed");
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 1, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 2, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 3, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 4, 9));
		 * LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 6, 9));
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 1, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 2, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 3, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 4, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(
		 * FILE_PATH, SHEET, 6, 9), START_DATE_TIME, END_DATE_TIME);
		 * LabWorkOrderListingPageActions.checkCurrentStatusViewList(ExcelReader.
		 * readExcelData(FILE_PATH, SHEET, 5, 9));
		 * LabWorkOrderListingPageActions.clickViewScreenClose();
		 * Assert.assertTrue(CommonPageActions.verification().
		 * contains("Lab Work Order Listing"));
		 */
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * check the Impact on LWO when we start two Teeth Trt check the Impact on LWO
	 * when we suspend First Teeth check the Impact on LWO when we Complete the
	 * WorkDone of second Teeth and also take full payment check the Impact on LWO
	 * when we reopen the suspended Trt
	 *
	 */

	// @Test(enabled = true, priority = 2)
	public void CheckSuspendRelatedAnotherScenerioOnLWO() {

		// Not testing the scenario right now

		logger.log(Status.PASS, CHECK_SUSPEND_RELATED_ANOTHER_SCENARIO_ON_LAB_WORK_ORDER);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.selectMultipleTeeth("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		OralExamsPageActions.clickOnTeethImage("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		TreatmentPlansPageActions.clickOnYes();
		TreatmentPlansPageActions.clickOnBoneGraftAndMembranes();
		TreatmentPlansPageActions.clickOnSearchField(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 1));
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 1));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.clickOnEdit(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 4));
		LabWorkOrderEditPageActions.selectLab(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 0));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.selectItemsSend(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 5));
		LabWorkOrderEditPageActions.addFile(
				"D:\\Clone\\prmautomation\\PatientFiles\\" + ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 21));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.selectRequire(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 10));
		LabWorkOrderEditPageActions.selectShade(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 11));
		LabWorkOrderEditPageActions.selectShadeOptionFromDrpDwn(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 12));
		LabWorkOrderEditPageActions.selectStainsInternal(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 13));
		LabWorkOrderEditPageActions.selectStainsExternal(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 14));
		LabWorkOrderEditPageActions.addTransluency(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 15));
		LabWorkOrderEditPageActions.addTexture(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 16));
		LabWorkOrderEditPageActions.selectConfigurations(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 17),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 18));
		LabWorkOrderEditPageActions.enterNotes(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 20));
		LabWorkOrderEditPageActions.clickSubmittedToLab();
		LabWorkOrderListingPageActions.verifySuccessfullMessage();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectTime(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 2), "15");
		WorksDonePageActions.enterRemarks(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 2), "Change to complete");
		WorksDonePageActions.selectStages(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 2), "Completed");
		WorksDonePageActions.clickOnAdd(ExcelReader.readExcelData(FILE_PATH, SHEET, 19, 2));
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		WorkDoneHistoryPageActions.clickAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickSuspendBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		WorksDonePageActions.selectRequire("Assuring for refund.");
		WorksDonePageActions.clickSaveBtnOnReasonPopUp();
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnInvoiceList();
		InvoiceListingPageActions.headerPage("Invoice Listing");
//		InvoiceListingPageActions.clickInvoicePaymentBtn();
//		newReceiptPage.headerNewReceipt("New Receipt");
//		newReceiptPage.clickPaymentByInvoice();
//		newReceiptPage.collectByInvoiceNewReceipts(2180);
//		newReceiptPage.selectPaymentMode("Cash");
//		newReceiptPage.saveNewReceipts();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		WorkDoneHistoryPageActions.clickReOpenBtn(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		WorkDoneHistoryPageActions.selectRequire("Patient returned back for the treatment.");
		WorkDoneHistoryPageActions.clickSaveBtnOnReasonPopUp();
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions
				.checkSourceForSuspAndRetreatMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		LabWorkOrderListingPageActions.checkDateTimeMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkSourceMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 7), ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 8));
		LabWorkOrderListingPageActions.checkStatusDateMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkSourceViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 4));
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9));
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * check the Impact on LWO when we start bridgeable enable Trt
	 */
	@Test(enabled = true, priority = 3)
	public void checkbridgeableRelatedScenerio() {
		logger.log(Status.PASS, CHECK_BRIDGEABLE_RELATED_SCENARIO);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.selectMultipleTeeth("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 5, 4));
		OralExamsPageActions.clickOnTeethImage("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 6, 4));
		TreatmentPlansPageActions.clickOnYes();
		TreatmentPlansPageActions.clickOnProsthoExceptCrowns();
		TreatmentPlansPageActions.clickOnSearchField(ExcelReader.readExcelData(FILE_PATH, SHEET, 21, 1));
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, SHEET, 21, 1));
		TreatmentPlansPageActions.clickPartOfBridge();
		TreatmentPlansPageActions
				.checkTreatmentsIsSelectedAsBridgeable(ExcelReader.readExcelData(FILE_PATH, SHEET, 21, 1));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, SHEET, 21, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 5, 4));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9));
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9),
				START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyTreatmentNameView(ExcelReader.readExcelData(FILE_PATH, SHEET, 21, 2), 2);
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * check the Impact on LWO when we start Arch enable Trt
	 */
	@Test(enabled = true, priority = 4)
	public void checkByArchRelatedScenario() {
		logger.log(Status.PASS, CHECK_BY_ARCH_RELATED_SCENARIO);

		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		TreatmentPlansPageActions.clickOnByArch();
		OralExamsPageActions.clickOnTeethImage("Adult", ExcelReader.readExcelData(FILE_PATH, SHEET, 6, 4));
		TreatmentPlansPageActions.clickOnProsthoExceptCrowns();
		TreatmentPlansPageActions.clickOnSearchField(ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 1));
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 1));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);

		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");

		LabWorkOrderListingPageActions.checkClinicNameMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				CLINIC_NAME);
		LabWorkOrderListingPageActions.checkLabNameMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 0));
		LabWorkOrderListingPageActions.checkDateMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4), TODAY_DATE);

		LabWorkOrderListingPageActions.checkOrderTypeMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 3));
		LabWorkOrderListingPageActions.checkLabWorkOrderNo(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4));

		// LabWorkOrderListingPageActions.checkDateTimeMainList(ExcelReader.readExcelData(FILE_PATH,
		// SHEET, 7, 4),
		// START_DATE_TIME, END_DATE_TIME);

		LabWorkOrderListingPageActions.checkWorkDetailsMainlist(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 2));
		LabWorkOrderListingPageActions.checkSourceMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4));
		LabWorkOrderListingPageActions.checkDoctorMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				DOCTOR_FIRST_NAME);
		LabWorkOrderListingPageActions.checkItemSentMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 5));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 7), ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 8));
		LabWorkOrderListingPageActions.checkStatusDateMainList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4));

		// Not calling this method because fields are different in current view
		// LabWorkOrderListingPageActions.checkedViewDataName();

		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyPatientNameView(PATIENT_NAME);
		LabWorkOrderListingPageActions.verifyLabWorkOrderNoView();
		LabWorkOrderListingPageActions.verifyDateTimeInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkLabNameViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 0));
		LabWorkOrderListingPageActions.checkOrderTypeViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 3));
		LabWorkOrderListingPageActions.checkWorkDetailViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 2));

		LabWorkOrderListingPageActions.checkSourceViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 4));
		LabWorkOrderListingPageActions.checkItemSentViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 5));
		LabWorkOrderListingPageActions.checkRequireViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 10));

		LabWorkOrderListingPageActions.checkShadeViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 11),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 11));

		LabWorkOrderListingPageActions.checkNotesViewList(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 20));
		LabWorkOrderListingPageActions.checkStatusEnableInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9));
		LabWorkOrderListingPageActions.verifyStatusInView(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 9),
				START_DATE_TIME, END_DATE_TIME);

		LabWorkOrderListingPageActions.verifyTreatmentNameView(ExcelReader.readExcelData(FILE_PATH, SHEET, 22, 2), 1);
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
		CommonPageActions.backTODoctorDashboard();
	}

}
