package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.doctorDashboard.PatientRegistrationPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import utils.SheetTest;
import utils.TestData;

public class PatientRegistrationTestCase extends BaseClass {

	// test data
	private static final String PATIENT_NAME = TestData.getInstance().getInputData("patient_name");
	private static final String PATIENT_GENDER = TestData.getInstance().getInputData("patient_gender");
	private static final String PATIENT_MOBILE = TestData.getInstance().getInputData("patient_mobile");
	private static final String EmailAddress = TestData.getInstance().getInputData("email");
	private static final String PATIENT_ALTERNATE_NAME = TestData.getInstance().getInputData("patient_alternate_name");
	private static final String PATIENT_ALTERNATE_MOBILE = TestData.getInstance()
			.getInputData("patient_alternate_mobile");
	private static final String Reaching_Time = TestData.getInstance().getInputData("reaching_time");
	private static final String PATIENT_AGE = TestData.getInstance().getInputData("patient_age");
	private static final String OCCUPATION = TestData.getInstance().getInputData("occupationOptn");
	private static final String ADDRESS = TestData.getInstance().getInputData("address");
	private static final String CITY = TestData.getInstance().getInputData("city");
	private static final String STATE = TestData.getInstance().getInputData("state");
	private static final String PIN_CODE = TestData.getInstance().getInputData("pin_code");
	private static final String MED_HIST_DIS_1 = TestData.getInstance().getInputData("medical_hist_disease_1");
	private static final String MED_HIST_STS_1 = TestData.getInstance().getInputData("medical_hist_status_1");
	private static final String MED_HIST_DIS_2 = TestData.getInstance().getInputData("medical_hist_disease_2");
	private static final String MED_HIST_STS_2 = TestData.getInstance().getInputData("medical_hist_status_2");
	private static final String OTH_MED_HIST = TestData.getInstance().getInputData("other_medical_hist");
	private static final String PAST_HIST_NOTES = TestData.getInstance().getInputData("past_hist_notes");
	private static final String ALLRGY_NOTES = TestData.getInstance().getInputData("allergy_notes");
	private static final String MEDICATN_NOTES = TestData.getInstance().getInputData("medication_notes");
	private static final String GROUP_NOTES = TestData.getInstance().getInputData("group_notes");
	private static final String PATIENT_NOTES = TestData.getInstance().getInputData("patient_notes");

	private static final String EDIT_PATIENT_NAME = TestData.getInstance().getInputData("edit_patient_name");
	private static final String EDIT_PATIENT_MOBILE = TestData.getInstance().getInputData("edit_patient_mobile");
	private static final String EDIT_PATIENT_EMAIL = TestData.getInstance().getInputData("edit_patient_email");

//	private static final String PATIENT_DOCTOR_NAME= TestData.getInstance().getInputData("patient_doctor_name");
	private static final String teeth[] = { TestData.getInstance().getInputData("teeth1"),
			TestData.getInstance().getInputData("teeth2") };
	private static final String dentalCheckUpOptn = TestData.getInstance().getInputData("dentalCheckUp_Optn1");

	// Messages for extent report
	private static final String HEADER_LISTING_PAGE = "Patient Registration";
	private static final String HEADER_LISTING_DASHBRD_PAGE = "Patient Dashboard";
	private static final String VERIFY_PATIENT_REGISTRATION_HOME_PAGE = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test scripts has been completed here @@";
	private static final String PATIENT_REGISTRATION_PAGE = "Validating patient registration page All Web Element";
	private static final String CHECK_MANDATORY_FIELDS = "Validating all mandatory fields patient name,mobile,patient alternate name,patient alternate mobile,guardian name ,guardian mobile and age";
//	private static final String BEHAVIOUR_OF_PAST_HISTORY = "Validating the teeth behavior at past history";
	private static final String CREATE_PATIENT = "Validating create new patient with best time to reach,address,medical history and patient notes";
	private static final String VALIDATE_PATIENT_DETAILS = "Validating new patient details which are provided during registration process.";
	private static final String BEHAVIOUR_OF_ALL_SELECT_OF_MIXED = "Search the patient from the global search edit the patient and update past history with all teeth";
	private static final String DENTAL_CHECKUP_MEDICATION_ALLERGIES = "Checking the Dental checkup,medication and allergies";
	private static final String VERIFY_ALREADY_EXITING_PATIENT_MSG = "Validating messages for already exiting patient and approve  appointment save scenario";
	private static final String VERIFY_EDIT_PATIENT_DASHBOARD = "Validating the editing patient from the patient dash board and checked same details prefilled at the patient registration";
	private static final String DEFAULT_COUNTRY = "India";
	private static final String SELECT_COUNTRY_TEST = "Pakistan";
	private static final String SELECT_COUNTRY = "India";
	private static final String VERIFY_STATE = "Delhi";
	private static final String DOB_FOR_TEST_AGE_CALCULATION = "08-09-1994";
	private static final String MOBILE_UNDER_TEN_DIGIT = "258951";
	Map<String, String> patntRegData = null;

	@BeforeTest
	public void testSetup() {
		patntRegData = SheetTest.prepareData("Registration", "PatientRegistration", "A2", "Q2");
	}

	@Test(groups = { "Regression" }, enabled = true, description = PATIENT_REGISTRATION_PAGE, priority = 1)
	public void PatientRegistrationPageActions() {
		logger.log(Status.PASS, PATIENT_REGISTRATION_PAGE);

		BaseClass.openPatientRegistrationHomePage();
		BasePatientLifeCyclePageActions.headerOnListPage(HEADER_LISTING_PAGE);
		PatientRegistrationPageActions.checkPatientName();
		PatientRegistrationPageActions.checkGender();
		PatientRegistrationPageActions.checkAge();
		PatientRegistrationPageActions.checkEmailId();
		PatientRegistrationPageActions.checkMobile();
		PatientRegistrationPageActions.checkSmsCallEmailCheckbox();
		PatientRegistrationPageActions.checkLandline();
		PatientRegistrationPageActions.landlineMaxLength();
		PatientRegistrationPageActions.checkAlternateContactName();
		PatientRegistrationPageActions.checkAlternateContactNo();
//		PatientRegistrationPageActions.checkPrimaryDentist(PATIENT_DOCTOR_NAME);
		PatientRegistrationPageActions.checkReachTime();
		PatientRegistrationPageActions.checkOccupation();
		PatientRegistrationPageActions.checkOccupationOthers();
//		PatientRegistrationPageActions.checkAddress();
		PatientRegistrationPageActions.byDefaultCountry(DEFAULT_COUNTRY);
		PatientRegistrationPageActions.selectCountry(SELECT_COUNTRY_TEST);
		PatientRegistrationPageActions.selectCountry(SELECT_COUNTRY);
		PatientRegistrationPageActions.verifyStatesAccordingToCountry(VERIFY_STATE);
		PatientRegistrationPageActions.checkActionsButton();
		PatientRegistrationPageActions.scrollUp();
		PatientRegistrationPageActions.patientPastHistory();
		PatientRegistrationPageActions.scrollDown();
		PatientRegistrationPageActions.checkAgeCalculation(DOB_FOR_TEST_AGE_CALCULATION);
		Assert.assertTrue(CommonPageActions.verification().contains(HEADER_LISTING_PAGE));
	}

	@Test(groups = { "Sanity", "Regression",
			"Functional" }, enabled = true, description = CHECK_MANDATORY_FIELDS, priority = 2)
	public void checkMandatoryFields() {
		logger.log(Status.PASS, CHECK_MANDATORY_FIELDS);

		BaseClass.openPatientRegistrationHomePage();
		BasePatientLifeCyclePageActions.headerOnListPage("Patient Registration");
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterPatientNameMsg();

		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.selectGenderMsg();

		// -------Validate Enter Mobile Number Message---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterMobileNoMsg();

		// -------Validate Mobile Number Length Message---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.enterMobileNO(MOBILE_UNDER_TEN_DIGIT);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterTenDigitMobileNoMsg();

		// -------Validate Invalid Mobile Number Message---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.enterMobileNO("000000000");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterValidMobileNoMsg();

		// -------Validate Without Providing Email---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.validateEnterEmailMsg();

		// -------Validate Invalid Email Message---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterEmailAddress("dentals.patientyopmail.com");
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.validateInvalidEmailMsg();

		// -------Validate Email Verification ---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterEmailAddress("dentals.patient@gmail.com");
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
//		PatientRegistrationPageActions.verificationOfValidEmail();

		// -------Validate Alternate Contact Name Message ---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterAlternateContactNameMsg();

		// -------Validate Alternate Contact Number Message ---------------
		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterAlternateContactNoMsg();

		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAlternateMobileNO("1111");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterTenDigitMobileNoMsg();

		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.enterMobileNO("0101010101");
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterValidMobileNoMsg();

		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		// -------always give age less than 18 here---------------
		PatientRegistrationPageActions.enterAge("12");
		PatientRegistrationPageActions.enterGuardianNo("1111111111");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterGuardianNameMsg();

		driver.navigate().refresh();
		PatientRegistrationPageActions.enterPatientName(PATIENT_NAME);
		PatientRegistrationPageActions.selectGenderMale(PATIENT_GENDER);
		PatientRegistrationPageActions.enterMobileNO(PATIENT_MOBILE);
		PatientRegistrationPageActions.enterAlterContactName(PATIENT_ALTERNATE_NAME);
		PatientRegistrationPageActions.enterAlternateMobileNO(PATIENT_ALTERNATE_MOBILE);
		// -------always give age less than 18 here---------------
		PatientRegistrationPageActions.enterAge("12");
		PatientRegistrationPageActions.enterGuardianName("guardian name");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterGuardianContactNoMsg();
		PatientRegistrationPageActions.enterGuardianName("guardian name");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterGuardianContactNoMsg();
		PatientRegistrationPageActions.enterGuardianNo("11111");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterTenDigitMobileNoMsg();
		PatientRegistrationPageActions.enterGuardianNo("0000000000");
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.enterValidMobileNoMsg();
		// -------give age 18 or more than 18--------
		PatientRegistrationPageActions.enterAge(PATIENT_AGE);
		PatientRegistrationPageActions.guardianDetailsHide();
		Assert.assertTrue(CommonPageActions.verification().contains(HEADER_LISTING_PAGE));
	}

//	 * Creating new patient with beat time to reach,Address,medical history,with patient groups and patient notes
//	 * checked same patient name at patient dash board at the top
//	 * Then Opening the view modal and checked all the data at view modal and close the view modal
//   * Then print the patient profile to check the medical history

	@Test(groups = { "Smoke", "Sanity", "Functional",
			"Regression" }, enabled = true, description = CREATE_PATIENT, priority = 3)
	public void createNewPatient() {
		logger.log(Status.PASS, CREATE_PATIENT);

		// temp code
		CommonPageActions.selectClinicFrmHeader("Bhumkar Chowk");

		BaseClass.openPatientRegistrationHomePage();
		BasePatientLifeCyclePageActions.headerOnListPage(HEADER_LISTING_PAGE);
		PatientRegistrationPageActions.enterPatientName(patntRegData.get("patient_name"));
		PatientRegistrationPageActions.selectGenderMale(patntRegData.get("patient_gender"));
		PatientRegistrationPageActions.enterAge(patntRegData.get("patient_age"));
		PatientRegistrationPageActions.enterEmailAddress(patntRegData.get("email"));
		PatientRegistrationPageActions.enterMobileNO(patntRegData.get("patient_mobile"));
		PatientRegistrationPageActions.enterAlterContactName(patntRegData.get("patient_alternate_name"));
		PatientRegistrationPageActions.enterAlternateMobileNO(patntRegData.get("patient_alternate_mobile"));
		PatientRegistrationPageActions.enterInReachTime(patntRegData.get("reaching_time"));
		PatientRegistrationPageActions.selectOccupation(patntRegData.get("occupationOptn"));
		PatientRegistrationPageActions.enterAddress(patntRegData.get("address"));
		PatientRegistrationPageActions.enterCity(patntRegData.get("city"));
		PatientRegistrationPageActions.selectState(patntRegData.get("state"));

		PatientRegistrationPageActions.enterPinCode(patntRegData.get("pin_code"));
//		PatientRegistrationPageActions.verifyCharacterLimitOfPinText();
		PatientRegistrationPageActions.clickOnMedicalHistory();
		PatientRegistrationPageActions.scrollDown();
		PatientRegistrationPageActions.selectMedicalHistory(MED_HIST_DIS_1, MED_HIST_STS_1);
		PatientRegistrationPageActions.selectMedicalHistory(MED_HIST_DIS_2, MED_HIST_STS_2);
		PatientRegistrationPageActions.selectAllMedicalHistory(OTH_MED_HIST);
		PatientRegistrationPageActions.clickOnAddBtnPastHistory();
		PatientRegistrationPageActions.clickOnAdult();
		PatientRegistrationPageActions.selectTeeth(teeth);
		PatientRegistrationPageActions.verifyTeethIsSelected(teeth);
		PatientRegistrationPageActions.enterNotes(PAST_HIST_NOTES);
		PatientRegistrationPageActions.clickOnSaveBtnOfPastHistory();
		PatientRegistrationPageActions.verifySelectedTeethPastHistory(teeth);
		PatientRegistrationPageActions.clickOnDentalCheckUP();
		PatientRegistrationPageActions.selectDentalCheckUpOptions(dentalCheckUpOptn);
		PatientRegistrationPageActions.clickOnAllergies();
		PatientRegistrationPageActions.clickOnAllergiesYesBtn();
		PatientRegistrationPageActions.enterAllergy(ALLRGY_NOTES);
		PatientRegistrationPageActions.clickMedication();
		PatientRegistrationPageActions.clickOnMedicationCheckUpYesBtn();
		PatientRegistrationPageActions.enterMedication(MEDICATN_NOTES);
		PatientRegistrationPageActions.clickOnGroup();
		PatientRegistrationPageActions.enterGroup(GROUP_NOTES);
		PatientRegistrationPageActions.clickOnPatientNotes();
		PatientRegistrationPageActions.enterPatientNotes(PATIENT_NOTES);
		PatientRegistrationPageActions.clickOnApproveSave();
		BasePatientLifeCyclePageActions.clickOnAlert();
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.enterMobileNo(patntRegData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntRegData.get("patient_mobile"), patntRegData.get("patient_name"));
		PatientDashboardPageActions.patientNamePatientDashboard(patntRegData.get("patient_name"));
		/* Added in View Details of Patient */

//		PatientDashboardPageActions.clickOnProfileViewBtn();
//		PatientDashboardPageActions.verifyTimeReachOnPatientProfile(Reaching_Time);
//		PatientDashboardPageActions.verifyOccupationOnPatientProfile(OCCUPATION);
//		PatientDashboardPageActions.verifyAddressOnPatientProfile(ADDRESS);
//		PatientDashboardPageActions.verifyCityOnPatientProfile(CITY);
//		PatientDashboardPageActions.verifyStateOnPatientProfile(STATE);
//		PatientDashboardPageActions.verifyPostalCodeOnPatientProfile(PIN_CODE);
//		PatientDashboardPageActions.verifyPatientNotesOnPatientProfile(PATIENT_NOTES);
//		PatientDashboardPageActions.verifyGroupNameOnPatientProfile(GROUP_NOTES);
//    	PatientDashboardPageActions.clickOnClosePopUp();
//		loginPage.clickEscapeKeyboardButton();

		PatientDashboardPageActions.clickOnPrint();
		Assert.assertTrue(CommonPageActions.verification().contains(HEADER_LISTING_DASHBRD_PAGE));
	}

//	 * Validate of Patient Registration Details 
//	 * checked same patient name at patient dash board at the top

	@Test(groups = { "Sanity", "Functional",
			"Regression" }, enabled = true, description = VALIDATE_PATIENT_DETAILS, priority = 4)
	public void validteDetailsOfPatient() {
		logger.log(Status.PASS, VALIDATE_PATIENT_DETAILS);

		BaseClass.openPatientRegistrationHomePage();
		BasePatientLifeCyclePageActions.headerOnListPage(HEADER_LISTING_PAGE);
		PatientRegistrationPageActions.clickOnCancelBtn();
		CommonPageActions.enterMobileNo(patntRegData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntRegData.get("patient_mobile"), patntRegData.get("patient_name"));
		PatientDashboardPageActions.medicalProblemAlertModal(MED_HIST_DIS_1, MED_HIST_STS_1);
		PatientDashboardPageActions.medicalProblemAlertModal(MED_HIST_DIS_2, MED_HIST_STS_2);
		PatientDashboardPageActions.medicationAlertModal(MEDICATN_NOTES);
		PatientDashboardPageActions.allergiesAlertModal(ALLRGY_NOTES);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnProfileViewBtn();
		PatientDashboardPageActions.verifyHeadInProfileView();
		PatientDashboardPageActions.checkAllDataInPatientProfileView();
		PatientDashboardPageActions.verifyPatientNameIDOnPatientProfile(patntRegData.get("patient_name"));
		PatientDashboardPageActions.verifyGenderOnPatientProfile(patntRegData.get("patient_gender"));
		PatientDashboardPageActions.verifyAgeOnPatientProfile(patntRegData.get("patient_age"));
		PatientDashboardPageActions.verifyPatientEmailOnPatientProfile(patntRegData.get("email"));
		PatientDashboardPageActions.verifyPatientMoblieOnPatientProfile(patntRegData.get("patient_mobile"));
		PatientDashboardPageActions.verifyAlternateNameOnPatientProfile(patntRegData.get("patient_alternate_name"));
		PatientDashboardPageActions.verifyAlterNateNoOnPatientProfile(patntRegData.get("patient_alternate_mobile"));
		PatientDashboardPageActions.verifyTimeReachOnPatientProfile(patntRegData.get("reaching_time"));
		PatientDashboardPageActions.verifyOccupationOnPatientProfile(patntRegData.get("occupationOptn"));
		PatientDashboardPageActions.verifyAddressOnPatientProfile(patntRegData.get("address"));
		PatientDashboardPageActions.verifyCityOnPatientProfile(patntRegData.get("city"));
		PatientDashboardPageActions.verifyStateOnPatientProfile(patntRegData.get("state"));
		PatientDashboardPageActions.verifyPostalCodeOnPatientProfile(patntRegData.get("pin_code"));
		PatientDashboardPageActions.verifyToothNoOnPatientProfile(teeth);
		PatientDashboardPageActions.verifyNotesOnPastHistoryPatientProfile(PAST_HIST_NOTES);
		PatientDashboardPageActions.verifyGroupNameOnPatientProfile(GROUP_NOTES);
		PatientDashboardPageActions.verifyPatientNotesOnPatientProfile(PATIENT_NOTES);
		PatientDashboardPageActions.clickOnClosePopUp();
	}

//	* Search the patient from global
//	* Edit the patient from the patient listing	 
//	* Checked All teeth functionality at the past history modal* save all teeth of mixed and save it.
//	* Checked same at the patient dash board patient view modal

	@Test(groups = { "Regression" }, enabled = true, description = BEHAVIOUR_OF_ALL_SELECT_OF_MIXED, priority = 5)
	public void behaviourOfAllSelectOfMixed() {
		logger.log(Status.PASS, BEHAVIOUR_OF_ALL_SELECT_OF_MIXED);

		BaseClass.openPatientRegistrationHomePage();
		BasePatientLifeCyclePageActions.headerOnListPage(HEADER_LISTING_PAGE);
		PatientRegistrationPageActions.clickOnCancelBtn();
		CommonPageActions.enterMobileNo(patntRegData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.editPatient(patntRegData.get("patient_name"), patntRegData.get("patient_mobile"));
		PatientRegistrationPageActions.clickOnAddBtnPastHistory();
		PatientRegistrationPageActions.clickOnMixed();
		PatientRegistrationPageActions.clickOnAllTeeth();
		PatientRegistrationPageActions.clickOnAdult();
		PatientRegistrationPageActions.clickOnPedo();
		PatientRegistrationPageActions.pedoCheckedAllTeethDeselected();
		PatientRegistrationPageActions.clickOnMixed();
		PatientRegistrationPageActions.adultCheckedAllTeethDeselected();
		PatientRegistrationPageActions.clickOnAllTeeth();
		PatientRegistrationPageActions.enterNotes(PATIENT_NOTES);
		PatientRegistrationPageActions.clickOnSaveBtnOfPastHistory();
		PatientRegistrationPageActions.clickOnDeleteBtn();
		PatientRegistrationPageActions.verifyPastHistoryAfterDelete();
		PatientRegistrationPageActions.clickOnAddBtnPastHistory();
		PatientRegistrationPageActions.clickOnMixed();
		PatientRegistrationPageActions.clickOnAllTeeth();
		PatientRegistrationPageActions.enterNotes(PATIENT_NOTES);
		PatientRegistrationPageActions.clickOnSaveBtnOfPastHistory();
		PatientRegistrationPageActions.scrollUp();
		PatientRegistrationPageActions.clickOnApproveSave();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnProfileViewBtn();
		PatientDashboardPageActions.verifyPatientNameIDOnPatientProfile(patntRegData.get("patient_name"));
		PatientDashboardPageActions.verifyPatientMoblieOnPatientProfile(patntRegData.get("patient_mobile"));
		// PatientDashboardPageActions.selectedTeethVerificationPatientDashboard("All
		// mixed");
		PatientDashboardPageActions.clickOnClosePopUp();
	}

	/**
	 * * Enter the details of exiting patient and checked Checked it is showing
	 * patient already exit Reset the data and checked all page is refreshed Saving
	 * the Approve and appointment it will redirect to appointment add page with
	 * prefilled name and mobile
	 */

	@Test(groups = { "Functional",
			"Regression" }, enabled = true, description = VERIFY_ALREADY_EXITING_PATIENT_MSG, priority = 6)
	public void verifyAlreadyExitingPatientMsg() {
		logger.log(Status.PASS, VERIFY_ALREADY_EXITING_PATIENT_MSG);

		BaseClass.openPatientRegistrationHomePage();
//		BasePatientLifeCyclePageActions.headerOnListPage(HEADER_LISTING_PAGE);
		PatientRegistrationPageActions.enterPatientName(patntRegData.get("patient_name"));
		PatientRegistrationPageActions.selectGenderMale(patntRegData.get("patient_gender"));
		PatientRegistrationPageActions.enterAge(patntRegData.get("patient_age"));
		PatientRegistrationPageActions.enterEmailAddress(patntRegData.get("email"));
		PatientRegistrationPageActions.enterMobileNO(patntRegData.get("patient_mobile"));
		PatientRegistrationPageActions.enterAlterContactName(patntRegData.get("patient_alternate_name"));
		PatientRegistrationPageActions.enterAlternateMobileNO(patntRegData.get("patient_alternate_mobile"));
		PatientRegistrationPageActions.enterInReachTime(patntRegData.get("reaching_time"));
		PatientRegistrationPageActions.selectOccupation(patntRegData.get("occupationOptn"));
		PatientRegistrationPageActions.enterAddress(patntRegData.get("address"));
		PatientRegistrationPageActions.enterCity(patntRegData.get("city"));
		PatientRegistrationPageActions.selectState(patntRegData.get("state"));
		PatientRegistrationPageActions.enterPinCode(patntRegData.get("pin_code"));
		PatientRegistrationPageActions.clickOnApproveSave();
		PatientRegistrationPageActions.nameAndPhoneAlreadyExit();
		PatientRegistrationPageActions.clickOnCancelBtn();
//		PatientRegistrationPageActions.clickOnApproveApp();
//		PatientRegistrationPageActions.nameAndPhoneAlreadyExit();
//		PatientRegistrationPageActions.clickOnResetBtn();
//		PatientRegistrationPageActions.clickOnApproveSave();
//		PatientRegistrationPageActions.enterMobileNoMsg();
//		CommonPageActions.enterMobileNo(patntRegData.get("patient_mobile"));
//		CommonPageActions.clickOnSearchBtn();
//		CommonPageActions.editPatient(patntRegData.get("patient_name"),patntRegData.get("patient_mobile"));
//		PatientRegistrationPageActions.clickOnApproveApp();
//		CommonPageActions.backTODoctorDashboard();
	}

}
