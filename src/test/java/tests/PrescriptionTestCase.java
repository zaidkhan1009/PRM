package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.PrescriptionListingPageActions;
import pageActions.patientDashboard.PrescriptionPageActions;
import utils.SheetTest;
import utils.TestData;

public class PrescriptionTestCase extends BaseClass {

	/*
	 * Storing mandatory input required to run Prescription test cases or please
	 * update the mandatory input before running the test cases
	 */
	/* input data for validation */
	private static final String FILE_PATH = TestData.getInstance().getInputData("prescription_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("prescription_file_sheet_name");
	private static final String PATIENT_NAME = TestData.getInstance().getInputData("prescription_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("prescription_patient_mobile");
	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("prescription_doctor_nikName");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("prescription_clinic_name");
	private static final String EMAIL_ID = TestData.getInstance().getInputData("prescription_patient_email");

	/*
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	public static final String CHECKED_PRESCRIPTION_ADD_AND_PRESCRIPTION_LiSTING_UI = "Validated Prescription add and Prescription listing page without having any prescription of the Patient -#checkedPrescriptionAddAndPrescriptionListingUi";
	private static final String ADD_PRESCRIPTION = "Validated Prescription Add Page and Prescription listing when we add Prescription on it -#addPrescription";
	private static final String CHECKED_PRESCRIPTION_LISTING_AFTER_ADD_PRESCRIPTION = "Validated Prescription listing Page after adding Prescription -#checkedPrescriptionAddPrescriptionListingUi";
	private static final String EDIT_PRESCRIPTION = "Validated data on all fileds when we click on Edit button and also change data after change validate on input and Prescription listing of modified data of prescription -#editPrescription";
	private static final String DELETE_PRESCRIPTION_FROM_INPUT_LIST = "Validated when we delete same Prescription from Input List -#deletePrescriptionFromInputList";
	private static final String DELETE_PRESCRIPTION_FROM_PRESCRIPTION_LISTING = "Validated when we delete same Prescription from Prescription listing -#deletePrescriptionFromPrescriptionListing";
	private static final String VALIDATION_MSGS_ON_ADD_PRESCRIPTION_PAGE = "Validated All mandatory fields with error Message -#validationMsgsOnAddPrescriptionPage";

	/*
	 * Module and Sheet Name for getting Data from Google sheet
	 */
	final String MODULE_NAME = "Prescription";
	final String GOOGLE_SHEET_NAME = "PrescriptionTestData";
	final String Product_SALE_PAGE_TITLE = "Product Sales";

	/*
	 * Initalizing Map for storing Google Sheet data for the test
	 */
	private Map<String, String> patntPresData;
	private Map<String, String> patntPresData1;

	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		patntPresData = SheetTest.prepareData("Prescription", "PrescriptionTestData", "A2", "Q2");
		patntPresData1 = SheetTest.prepareData("Prescription", "PrescriptionTestData", "A3", "Q3");
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(MOBILE_NUMBER, PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();
	}

	/*
	 * checked header of the Prescription page checked Prescription add and
	 * Prescription listing page without any Prescription when we redirect for the
	 * first time checked the patient name and id should not be "null" or "NA"
	 * checked patient Dashboard, Save, Reset and Cancel button. checked left side
	 * navigation all button at both Prescription add and Prescription listing page.
	 * checked Prescription listing page header. checked no record message displayed
	 * on Prescription listing page for first time redirection. checked all fields
	 * name present in Add Prescription page. checked add prescription button on
	 * prescription listing page.
	 */

	@Test(enabled = true, priority = 1)
	public void checkedPrescriptionAddAndPrescriptionListingUi() {
		logger.log(Status.PASS, CHECKED_PRESCRIPTION_ADD_AND_PRESCRIPTION_LiSTING_UI);

		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.commonDashBoardBtnVerify();
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		/* Right Navigation */
		PrescriptionPageActions.checkSave();
		PrescriptionPageActions.checkCancel();
		PrescriptionPageActions.checkReset();
		/* Right column */
		PrescriptionPageActions.checkBrandAndGenericName();
		PrescriptionPageActions.checkStrength();
		PrescriptionPageActions.checkDuration();
		PrescriptionPageActions.chckStrengthDropDownWebelemet();
		PrescriptionPageActions.chckDurationDropDownWebelement();
		PrescriptionPageActions.chckRouteDropDownWebelement();
		PrescriptionPageActions.checkAllCheckbox();
		PrescriptionPageActions.checkInstruction();
		PrescriptionPageActions.checkNotes();
		Assert.assertTrue(CommonPageActions.verification().contains("Add Prescription"));
		/* verify all elements when we go first time on Prescription listing */
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		BasePatientLifeCyclePageActions.commonDashBoardBtnVerify();
		PrescriptionListingPageActions.verifyNoRecordFoundMessage();
		PrescriptionListingPageActions.verifyAddNewBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Prescription Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/*
	 * Added Prescription for the patient. checked same Prescription on the input
	 * listing shown in Add Prescription Page. checked Edit and Cancel button same
	 * Prescription on the input listing. checked same Prescription on the
	 * Prescription listing Page. checked same Prescription on the View pop up shown
	 * in Prescription listing Page. validated all action button present at the both
	 * Prescription add and Prescription listing.
	 */
	@Test(enabled = true, priority = 2)
	public void addPrescription() {
		System.out.println(patntPresData);
		logger.log(Status.PASS, ADD_PRESCRIPTION);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addStrength(patntPresData.get("strength"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDrug(patntPresData.get("drug"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.selectRoute(patntPresData.get("route"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.clickOnAfternoon();
		PrescriptionPageActions.clickOnNight();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.enterNote(patntPresData.get("notes"));
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedInputListDataName();
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData.get("brand_name"));
		PrescriptionPageActions.verifyGenericNameInputListData(patntPresData.get("generic_name"));
		PrescriptionPageActions.verifyStrengthInputListData(patntPresData.get("strength"), patntPresData.get("drug"));
		PrescriptionPageActions.verifyDurationInputListData(patntPresData.get("duration"),
				patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData.get("route"));
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData.get("instruction"));
		PrescriptionPageActions.verifyNotesInputList(patntPresData.get("brand_name"), patntPresData.get("notes"));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.clickEditInputList(patntPresData.get("brand_name"));
		PrescriptionPageActions.cancelInputList(patntPresData.get("brand_name"));
		PrescriptionPageActions.clickEditInputList(patntPresData.get("brand_name"));
		PrescriptionPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.actionBtnInputList(patntPresData.get("brand_name"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		PrescriptionListingPageActions.verifyPrescriptionListHomePage();
		PrescriptionListingPageActions.checkedMainListDataName();
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("brand_name"));
		PrescriptionListingPageActions.genericNameInMainList(patntPresData.get("brand_name"),
				patntPresData.get("generic_name"));
		PrescriptionListingPageActions.strengthMainList(patntPresData.get("brand_name"), patntPresData.get("strength"),
				patntPresData.get("drug"));
		PrescriptionListingPageActions.durationMainList(patntPresData.get("brand_name"), patntPresData.get("duration"),
				patntPresData.get("duration_dropdown"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("route"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("instruction"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.clickViewMainList(patntPresData.get("brand_name"));
		PrescriptionListingPageActions.verifyHeaderInView("Patient Prescription Detail");
		PrescriptionListingPageActions.dataNameInView();
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("brand_name"));
		PrescriptionListingPageActions.checkedGenericNameInView(patntPresData.get("brand_name"),
				patntPresData.get("generic_name"));
		PrescriptionListingPageActions.strengthInView(patntPresData.get("brand_name"), patntPresData.get("strength"),
				patntPresData.get("drug"));
		PrescriptionListingPageActions.durationInView(patntPresData.get("brand_name"), patntPresData.get("duration"),
				patntPresData.get("duration_dropdown"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("route"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("instruction"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.notesInView(patntPresData.get("brand_name"), patntPresData.get("notes"));
		PrescriptionListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Prescription Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}

	/*
	 * checked Prescription on Prescription listing which were added in above test
	 * case. checked all button shown against Added Prescription on Prescription
	 * listing. In view checked all data like pop up heading patient name date and
	 * all data.
	 */
	@Test(enabled = true, priority = 3)
	public void checkedPrescriptionListingAfterAddPrescription() {
		logger.log(Status.PASS, CHECKED_PRESCRIPTION_LISTING_AFTER_ADD_PRESCRIPTION);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		BasePatientLifeCyclePageActions.commonDashBoardBtnVerify();
		PrescriptionListingPageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		BasePatientLifeCyclePageActions.verifyDates();
		PrescriptionListingPageActions.verifyClinicInPrescriptionListing(patntPresData.get("brand_name"), CLINIC_NAME);
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("brand_name"));
		PrescriptionListingPageActions.genericNameInMainList(patntPresData.get("brand_name"),
				patntPresData.get("generic_name"));
		PrescriptionListingPageActions.strengthMainList(patntPresData.get("brand_name"), patntPresData.get("strength"),
				patntPresData.get("drug"));
		PrescriptionListingPageActions.durationMainList(patntPresData.get("brand_name"), patntPresData.get("duration"),
				patntPresData.get("duration_dropdown"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("route"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"),
				patntPresData.get("instruction"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.verifyEditBtnMainList(patntPresData.get("brand_name"));
		PrescriptionListingPageActions.verifyPrintBtnMainList(patntPresData.get("brand_name"));
		PrescriptionListingPageActions.verifySendBtnMainList(patntPresData.get("brand_name"));
		BasePatientLifeCyclePageActions.clickViewBtn(CLINIC_NAME);
		PrescriptionListingPageActions.verifyHeaderInView("Patient Prescription Detail");
		PrescriptionListingPageActions.dataNameInView();
		PrescriptionListingPageActions.verifyPatientNameInView(PATIENT_NAME);
		PrescriptionListingPageActions.verifyDateInViewPopUp();
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("brand_name"));
		PrescriptionListingPageActions.checkedGenericNameInView(patntPresData.get("brand_name"),
				patntPresData.get("generic_name"));
		PrescriptionListingPageActions.strengthInView(patntPresData.get("brand_name"), patntPresData.get("strength"),
				patntPresData.get("drug"));
		PrescriptionListingPageActions.durationInView(patntPresData.get("brand_name"), patntPresData.get("duration"),
				patntPresData.get("duration_dropdown"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("route"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"),
				patntPresData.get("instruction"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.notesInView(patntPresData.get("brand_name"), patntPresData.get("notes"));
		PrescriptionListingPageActions.closeViewPopup();
		PrescriptionListingPageActions.clickSendBtnMainList(patntPresData.get("brand_name"), PATIENT_NAME,
				MOBILE_NUMBER, EMAIL_ID);
		Assert.assertTrue(CommonPageActions.verification().contains("Prescription Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/*
	 * Edit Prescription which is previously added. checked all data coming into all
	 * fields or not when we click on edit button on Add Prescription Page. modified
	 * same prescription and checked on Input list and Prescription listing Page.
	 * checked modified prescription on Main list and View Pop on Prescription
	 * listing Page.
	 */
	@Test(enabled = true, priority = 4)
	public void editPrescription() {
		logger.log(Status.PASS, EDIT_PRESCRIPTION);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.clickEditInputList(patntPresData.get("brand_name"));
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		PrescriptionPageActions.getBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.getStrength(patntPresData.get("strength"));
		PrescriptionPageActions.getDuration(patntPresData.get("duration"));
		PrescriptionPageActions.getGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.getDrug(patntPresData.get("drug"));
		PrescriptionPageActions.getDurationDrpDwn(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.getRoute(patntPresData.get("route"));
		PrescriptionPageActions.getNotes(patntPresData.get("notes"));
		PrescriptionPageActions.addBrandName(patntPresData1.get("brand_name"));
		PrescriptionPageActions.addStrength(patntPresData1.get("strength"));
		PrescriptionPageActions.addDuration(patntPresData1.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData1.get("generic_name"));
		PrescriptionPageActions.selectDrug(patntPresData1.get("drug"));
		PrescriptionPageActions.selectDuration(patntPresData1.get("duration_dropdown"));
		PrescriptionPageActions.selectRoute(patntPresData1.get("route"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.clickOnAfternoon();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.enterNote(patntPresData1.get("notes"));
		PrescriptionPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData1.get("brand_name"));
		PrescriptionPageActions.verifyGenericNameInputListData(patntPresData1.get("generic_name"));
		PrescriptionPageActions.verifyStrengthInputListData(patntPresData1.get("strength"), patntPresData1.get("drug"));
		PrescriptionPageActions.verifyDurationInputListData(patntPresData1.get("duration"),
				patntPresData1.get("duration_dropdown"));
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData1.get("route"));
		PrescriptionPageActions.verifyPrescriptionInputListData(patntPresData1.get("instruction"));
		PrescriptionPageActions.verifyNotesInputList(patntPresData1.get("brand_name"), patntPresData1.get("notes"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.genericNameInMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("generic_name"));
		PrescriptionListingPageActions.strengthMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("strength"), patntPresData1.get("drug"));
		PrescriptionListingPageActions.durationMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("duration"), patntPresData1.get("duration_dropdown"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("route"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData1.get("brand_name"),
				patntPresData1.get("instruction"));
		PrescriptionListingPageActions.prescriptionInMainList(patntPresData1.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.clickViewMainList(patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.verifyHeaderInView("Patient Prescription Detail");
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData1.get("brand_name"),
				patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.checkedGenericNameInView(patntPresData1.get("brand_name"),
				patntPresData1.get("generic_name"));
		PrescriptionListingPageActions.strengthInView(patntPresData1.get("brand_name"), patntPresData1.get("strength"),
				patntPresData1.get("drug"));
		PrescriptionListingPageActions.durationInView(patntPresData1.get("brand_name"), patntPresData1.get("duration"),
				patntPresData1.get("duration_dropdown"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData1.get("brand_name"),
				patntPresData1.get("route"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData1.get("brand_name"),
				patntPresData1.get("instruction"));
		PrescriptionListingPageActions.checkedPrescriptionInView(patntPresData1.get("brand_name"), DOCTOR_NIK_NAME);
		PrescriptionListingPageActions.notesInView(patntPresData1.get("brand_name"), patntPresData1.get("notes"));
		PrescriptionListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Prescription Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();

	}

	/*
	 * Delete Prescription which is previously added/edit. checked whether
	 * prescription is deleted or not from Input list shown on Add Prescription
	 * Page. checked whether prescription is deleted or not from Main list and View
	 * of Main list shown on Prescription listing Page.
	 */
	@Test(enabled = true, priority = 5)
	public void deletePrescriptionFromInputList() {
		logger.log(Status.PASS, DELETE_PRESCRIPTION_FROM_INPUT_LIST);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		PrescriptionPageActions.clickOnDeleteBtn(patntPresData1.get("brand_name"));
		PrescriptionPageActions.clickOnYesDelete();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		PrescriptionPageActions.verifyPrescriptionDeletedInputList(patntPresData1.get("brand_name"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		PrescriptionListingPageActions.verifyPrescriptionDeletedMainList(patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.clickViewMainList(patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.verifyPrescriptionDeletedInViewMainList(patntPresData1.get("brand_name"));
		PrescriptionListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Prescription Listing"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/*
	 * Add Prescription for check the delete scenario and Delete Prescription from
	 * Prescription listing. checked whether prescription is deleted or not from
	 * Input list shown on Add Prescription Page. checked whether prescription is
	 * deleted or not from Main list and View of Main list shown on Prescription
	 * listing Page.
	 */
	@Test(enabled = true, priority = 6)
	public void deletePrescriptionFromPrescriptionListing() {
		logger.log(Status.PASS, DELETE_PRESCRIPTION_FROM_PRESCRIPTION_LISTING);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addStrength(patntPresData.get("strength"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDrug(patntPresData.get("drug"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.selectRoute(patntPresData.get("route"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.clickOnAfternoon();
		PrescriptionPageActions.clickOnNight();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.enterNote(patntPresData.get("notes"));
		PrescriptionPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestList();
		BasePatientLifeCyclePageActions.headerOnListPage("Prescription Listing");
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.clickDeleteBtn(CLINIC_NAME);
		PrescriptionListingPageActions.clickDeletePop();
		PrescriptionListingPageActions.checkBtnAfterDelete();
		PrescriptionListingPageActions.verifyPrescriptionDeletedMainList(patntPresData1.get("brand_name"));
		BasePatientLifeCyclePageActions.clickViewBtn(CLINIC_NAME);
		PrescriptionListingPageActions.dataNameInView();
		PrescriptionListingPageActions.verifyPrescriptionDeletedInViewMainList(patntPresData1.get("brand_name"));
		BasePatientLifeCyclePageActions.closeViewPopup();
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		PrescriptionPageActions.verifyPrescriptionDeletedInputList(patntPresData1.get("brand_name"));
		Assert.assertTrue(CommonPageActions.verification().contains("Add Prescription"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	/*
	 * checked all scenario related to validation msgs on Add prescription Page of
	 * mandatory fields.
	 */
	@Test(enabled = true, priority = 7)
	public void validationMsgAddPrescriptionPage() {
		logger.log(Status.PASS, VALIDATION_MSGS_ON_ADD_PRESCRIPTION_PAGE);

		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnPrescriptionTestAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");
		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorBrand("Enter Brand Name");
		PrescriptionPageActions.checkedErrorGeneric("Enter Generic Name");
		PrescriptionPageActions.checkedErrorDuration("Enter Duration");
		PrescriptionPageActions.checkedErrorDurationDrpDwn("Select Duration Unit");
		PrescriptionPageActions.checkedErrorDosage("Select Dosage");
		PrescriptionPageActions.checkedErrorInstruction("Select Instruction");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorBrand("Enter Brand Name");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorDuration("Enter Duration");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorGeneric("Enter Generic Name");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.clickOnAfternoon();
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorDurationDrpDwn("Select Duration Unit");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.beforeFood();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorDosage("Select Dosage");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		PrescriptionPageActions.addBrandName(patntPresData.get("brand_name"));
		PrescriptionPageActions.addDuration(patntPresData.get("duration"));
		PrescriptionPageActions.addGenericName(patntPresData.get("generic_name"));
		PrescriptionPageActions.selectDuration(patntPresData.get("duration_dropdown"));
		PrescriptionPageActions.clickOnMorning();
		PrescriptionPageActions.clickOnSaveBtn();
		PrescriptionPageActions.checkedErrorInstruction("Select Instruction");
		PrescriptionPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage("Add Prescription");

		BasePatientLifeCyclePageActions.clickOnAlert();
		Assert.assertTrue(CommonPageActions.verification().contains("Add Prescription"));
		BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

}
