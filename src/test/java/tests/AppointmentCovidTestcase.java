package tests;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.doctorDashboard.PatientRegistrationPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.CovidAppointmentNewUIPageActions;
import pageActions.patientDashboard.CovidDeclarationFormPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.ExcelReader;
import utils.TestData;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class AppointmentCovidTestcase extends BaseClass {

	// file used to store input data
	private static final String FILE_PATH = TestData.getInstance().getInputData("covid_test_data_file_path");
	private static final String APPOINTMENT_SHEET = TestData.getInstance()
			.getInputData("appointment_covid_test_data_sheet_name");
	private static final String TREATMENT_SHEET = TestData.getInstance()
			.getInputData("treatment_covid_test_data_sheet_Name");
	private static final String TODAY_DATE = TestData.getInstance().getTodayDate();

	// Message here which We will print extent execution report after execution
	private static final String DOCTOR_DASHBOARD = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed here@@";
	private static final String APPOINTMENT_COVID_PATIENT = "Redirected at the appointment add page\n"
			+ "     * checked default text for covid at appointment page\n"
			+ "     * enter new patient details for appointment and trying to save the appointment\n"
			+ "     * Verified covid alert message for new patient and grey button,covid modal open button\n"
			+ "     * verifying all the question present at covid modal with their respective options\n"
			+ "     * validated all question mandatory filed one by one with their error message";
	private static final String BOOK_APPOINTMENT_GREEN_FLAG = "* Book appointment for a new patient with green covid status\n"
			+ "     * redirected to appointment listing page checked same appointment with green status\n"
			+ "     * Also open covid form at the appointment listing and checked same option selected\n"
			+ "     * clicking on same appointment it will redirect to the patient registration page\n"
			+ "     * enter the alternate name,alternate mobile,age and registered the patient it will redirect to patient dashboard\n"
			+ "     * close alert modal at patient dashboard and open the covid modal and verify same options selected and close the covid modal\n"
			+ "     * now redirect at appointment listing(patient dashboard) and open covid modal and check all the data at the covis modal";
	private static final String TREATMENT_GREEN_PATIENT = "Search same patient at global search and click on the patient it will redirect to patient dashboard\n"
			+ "     * now close alert modal at patient dashboard\n"
			+ "     * now select at teeth and select two treatment of the diagnosis and save it and verify same at treatment input listing\n"
			+ "     * now try to start treatment from treatment plan input listing and treatment plan listing without temperature and oximeter checked alert message in both cases\n"
			+ "     * now update the temperature and oximeter and start the treatment from treatment input list and treatment plan listing";
	private static final String WORK_DONE_ADD_PAGE = "verify the treatment details at the work done add page and work done history page";
	private static final String TREATMENT_STAGE_INPROGRESS = "Changing the work done stages and checked All new updated data at work done add page and work done history page";
	private static final String TREATMENT_STAGE_COMPLETE = "Changing the stages of the treatment to complete and checked all new changes at the work done history and work done add";
	private static final String FOLLOW_UP = "Validated all cases of the follow up modal and checked same at work done history and work done add";
	private static final String CONVERTING_GREEN_TO_RED_FLAG = "Now converting the covid status from green to red\n"
			+ "     * Adding new treatment for red covid patient\n"
			+ "     * checking checkbox should not be present in treatment input listing\n"
			+ "     * and also checking start should not be present at the treatment plan listing";
	private static final String RE_TREAT = "Validated retreat for the treatment scenario at the both page work done history and work done add page";
	private static final String APPOINTMENT_RED_COVID_PATIENT = "Redirecting at Appointment add page\n"
			+ "     * selecting same patient from the suggestion\n"
			+ "     * validated appointment should not be book for red covid flag patient";

	/**
	 * Redirecting to the provides url in qa.properties entering the username,
	 * password and click on submit button verifying it is redirected at doctor
	 * dashboard page successfully
	 */

	/**
	 * Redirected at the appointment add page checked default text for covid at
	 * appointment page enter new patient details for appointment and trying to save
	 * the appointment Verified covid alert message for new patient and grey
	 * button,covid modal open button verifying all the question present at covid
	 * modal with their respective options validated all question mandatory filed
	 * one by one with their error message
	 */
	@Test(priority = 1)
	public void appointmentCovidPatient() {
		logger.log(Status.PASS, APPOINTMENT_COVID_PATIENT);
		CommonPageActions.selectClinicFrmHeader("Amanora");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.covidOption();
		AppointmentAddPageActions.enterPatientName(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentAddPageActions.enterMobileNumber(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		AppointmentAddPageActions.enterEmailAddress(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 3));
		AppointmentAddPageActions
				.selectClinicFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		AppointmentAddPageActions.appointmentDate(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 6));
		AppointmentAddPageActions
				.selectTimeSlotFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 7));
		AppointmentAddPageActions.enterTimeDuration(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 8));
		AppointmentAddPageActions
				.selectDoctorFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		AppointmentAddPageActions.enterNote(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 10));
		AppointmentAddPageActions.clickOnSaveBtn();
//        AppointmentAddPageActions.covidAlertMsgGrey();
		AppointmentAddPageActions.checkPatientCovidStatus();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.checkActionsNewPatient();
		CovidAppointmentNewUIPageActions.question_1();
		CovidAppointmentNewUIPageActions.question_2();
		CovidAppointmentNewUIPageActions.question_3();
		CovidAppointmentNewUIPageActions.question_4();
		CovidAppointmentNewUIPageActions.question_5();
		CovidAppointmentNewUIPageActions.question_6();
		CovidAppointmentNewUIPageActions.question_7();
		CovidAppointmentNewUIPageActions.question_8();
		CovidAppointmentNewUIPageActions.question_9();
		CovidAppointmentNewUIPageActions.question_10();
		CovidAppointmentNewUIPageActions.question_11();
		CovidAppointmentNewUIPageActions.question_12();
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("High Fever");
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.saveCovidForm();
		CovidAppointmentNewUIPageActions.errorMsgDisplayed();
		CovidAppointmentNewUIPageActions.closeCovidForm();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
	}

	/**
	 * Book appointment for a new patient with green covid status redirected to
	 * appointment listing page checked same appointment with green status Also open
	 * covid form at the appointment listing and checked same option selected
	 * clicking on same appointment it will redirect to the patient registration
	 * page enter the alternate name,alternate mobile,age and registered the patient
	 * it will redirect to patient dashboard close alert modal at patient dashboard
	 * and open the covid modal and verify same options selected and close the covid
	 * modal now redirect at appointment listing(patient dashboard) and open covid
	 * modal and check all the data at the covis modal
	 */
	@Test(priority = 2)
	public void bookAppointmentGreenFlag() {
		logger.log(Status.PASS, BOOK_APPOINTMENT_GREEN_FLAG);
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterPatientName(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentAddPageActions.enterMobileNumber(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		AppointmentAddPageActions.enterEmailAddress(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 3));
		AppointmentAddPageActions
				.selectClinicFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		AppointmentAddPageActions.appointmentDate(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 6));
		AppointmentAddPageActions
				.selectTimeSlotFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 7));
		AppointmentAddPageActions.enterTimeDuration(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 8));
		AppointmentAddPageActions
				.selectDoctorFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		AppointmentAddPageActions.enterNote(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 10));
		AppointmentAddPageActions.openCovidForm();
		CovidAppointmentNewUIPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidAppointmentNewUIPageActions.selectFirstQuestion("None of Them");
		CovidAppointmentNewUIPageActions.noOption(2);
		CovidAppointmentNewUIPageActions.noOption(3);
		CovidAppointmentNewUIPageActions.noOption(4);
		CovidAppointmentNewUIPageActions.noOption(5);
		CovidAppointmentNewUIPageActions.noOption(6);
		CovidAppointmentNewUIPageActions.noOption(7);
		CovidAppointmentNewUIPageActions.noOption(8);
		CovidAppointmentNewUIPageActions.noOption(9);
		CovidAppointmentNewUIPageActions.greenFlag();
		CovidAppointmentNewUIPageActions.saveCovidForm();
		AppointmentAddPageActions.covidStatusUpdate();
		AppointmentAddPageActions.patientCovidGreen();
		AppointmentAddPageActions.clickOnSaveBtn();
		CommonPageActions.selectClinicFrmHeader(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.appointmentStatus(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1), "New");
		AppointmentsLisitngPageActions.appointmentType(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1),
				"Confirmed");
		AppointmentsLisitngPageActions.verifyClinic(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		AppointmentsLisitngPageActions.viewButton(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentsLisitngPageActions.editButton(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentsLisitngPageActions.deleteButton(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentsLisitngPageActions.openGreenFlag(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.selectedFirstQuestion("None of Them");
		CovidDeclarationFormPageActions.noOptionSelected(2);
		CovidDeclarationFormPageActions.noOptionSelected(3);
		CovidDeclarationFormPageActions.noOptionSelected(4);
		CovidDeclarationFormPageActions.noOptionSelected(5);
		CovidDeclarationFormPageActions.noOptionSelected(6);
		CovidDeclarationFormPageActions.noOptionSelected(7);
		CovidDeclarationFormPageActions.noOptionSelected(8);
		CovidDeclarationFormPageActions.noOptionSelected(9);
		CovidDeclarationFormPageActions.closeCovidForm();
		AppointmentsLisitngPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		PatientRegistrationPageActions.enterAlterContactName(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		PatientRegistrationPageActions.enterAlternateMobileNO(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		PatientRegistrationPageActions.enterAge("27");
		PatientRegistrationPageActions.clickOnApproveSave();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.openCovidForm();
		CovidDeclarationFormPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.selectedFirstQuestion("None of Them");
		CovidDeclarationFormPageActions.noOptionSelected(2);
		CovidDeclarationFormPageActions.noOptionSelected(3);
		CovidDeclarationFormPageActions.noOptionSelected(4);
		CovidDeclarationFormPageActions.noOptionSelected(5);
		CovidDeclarationFormPageActions.noOptionSelected(6);
		CovidDeclarationFormPageActions.noOptionSelected(7);
		CovidDeclarationFormPageActions.noOptionSelected(8);
		CovidDeclarationFormPageActions.noOptionSelected(9);
		CovidDeclarationFormPageActions.closeCovidForm();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.openCovidForm();
		CovidDeclarationFormPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.selectedFirstQuestion("None of Them");
		CovidDeclarationFormPageActions.noOptionSelected(2);
		CovidDeclarationFormPageActions.noOptionSelected(3);
		CovidDeclarationFormPageActions.noOptionSelected(4);
		CovidDeclarationFormPageActions.noOptionSelected(5);
		CovidDeclarationFormPageActions.noOptionSelected(6);
		CovidDeclarationFormPageActions.noOptionSelected(7);
		CovidDeclarationFormPageActions.noOptionSelected(8);
		CovidDeclarationFormPageActions.noOptionSelected(9);
		CovidDeclarationFormPageActions.closeCovidForm();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointments List"));
	}

	/**
	 * Search same patient at global search and click on the patient it will
	 * redirect to patient dashboard now close alert modal at patient dashboard now
	 * select at teeth and select two treatment of the diagnosis and save it and
	 * verify same at treatment input listing now try to start treatment from
	 * treatment plan input listing and treatment plan listing without temperature
	 * and oximeter checked alert message in both cases now update the temperature
	 * and oximeter and start the treatment from treatment input list and treatment
	 * plan listing
	 */
	@Test(priority = 3, dependsOnMethods = "bookAppointmentGreenFlag")
	public void treatmentGreenPatient() {
		logger.log(Status.PASS, TREATMENT_GREEN_PATIENT);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 1));
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 2, 1));
		TreatmentPlansPageActions.saveTreatment();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.checkedInputListDataName();
		TreatmentPlansPageActions.selectTreatmentInputList(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlansPageActions.setCovidUpdateAlert();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.checkedWithoutTreatmentStart();
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.setCovidUpdateAlert();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.openCovidForm();
		CovidDeclarationFormPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.selectedFirstQuestion("None of Them");
		CovidDeclarationFormPageActions.noOptionSelected(2);
		CovidDeclarationFormPageActions.noOptionSelected(3);
		CovidDeclarationFormPageActions.noOptionSelected(4);
		CovidDeclarationFormPageActions.noOptionSelected(5);
		CovidDeclarationFormPageActions.noOptionSelected(6);
		CovidDeclarationFormPageActions.noOptionSelected(7);
		CovidDeclarationFormPageActions.noOptionSelected(8);
		CovidDeclarationFormPageActions.noOptionSelected(9);
		CovidDeclarationFormPageActions.patientTemperature();
		CovidDeclarationFormPageActions.patientOximeter();
		CovidDeclarationFormPageActions.setPatientTemperature("97");
		CovidDeclarationFormPageActions.setPatientOximeter("100");
		CovidDeclarationFormPageActions.saveCovidForm();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.openCovidForm();
		CovidDeclarationFormPageActions.checkPatientTemperature("97");
		CovidDeclarationFormPageActions.checkPatientOximeter("100");
		CovidDeclarationFormPageActions.closeCovidForm();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions
				.selectTreatmentInTreatmentListPage(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
		driver.navigate().back();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.selectTreatmentInputList(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 2, 2));
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}

	/**
	 * verify the treatment details at the work done add page and work done history
	 * page
	 */
	@Test(priority = 4, dependsOnMethods = "treatmentGreenPatient")
	public void workDoneAddPage() {
		logger.log(Status.PASS, WORK_DONE_ADD_PAGE);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		WorksDonePageActions.checkedAddAllBtn();
		WorksDonePageActions.checkLabWorkOrderBtn();
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedPrintBtn();
		WorksDonePageActions.checkedHistoryBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorksDonePageActions.checkDateTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorksDonePageActions.checkSourceNo(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "24");
		WorksDonePageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "Started");
		WorksDonePageActions.checkProgressDropDown(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.checkSuspededBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.checkDataName(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.checkBox(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorksDonePageActions.checkDoctorSelected(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorksDonePageActions.checkedClinic(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorksDonePageActions.checkTimeSelected(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "Select Time");
		WorksDonePageActions.checkedRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.checkedAddButton(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		/*-------------work done history check all data-----------------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorkDoneHistoryPageActions.checkDateTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"In-Progress");
		WorkDoneHistoryPageActions.checkDataName(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.checkedClinic(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorkDoneHistoryPageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "Started");
		WorkDoneHistoryPageActions.checkedRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "No Remarks");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * Changing the work done stages and checked All new updated data at work done
	 * add page and work done history page
	 */
	@Test(priority = 5, dependsOnMethods = "workDoneAddPage")
	public void treatmentStageInProgress() {
		logger.log(Status.PASS, TREATMENT_STAGE_INPROGRESS);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectDoctor(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorksDonePageActions.selectTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "15");
		WorksDonePageActions.enterRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "it is for testing");
		WorksDonePageActions.selectStages(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "In-Progress");
		WorksDonePageActions.clickOnAdd(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorksDonePageActions.closeAppoitmentPopup();
		WorksDonePageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"In-Progress");
		WorksDonePageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorksDonePageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorksDonePageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "15");
		WorksDonePageActions.checkStatus(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "In-Progress");
		WorksDonePageActions.checkRemarksWorkDoneAddPage(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"it is for testing");
		WorksDonePageActions.checkEdit(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		/*-------Changed stages of treatment and checked in workdone History---------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkDateTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"In-Progress");
		WorkDoneHistoryPageActions.checkDataName(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.checkedClinic(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorkDoneHistoryPageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"In-Progress");
		WorkDoneHistoryPageActions.checkedRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"it is for testing");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * changing the stages of the treatment to complete and checked all new changes
	 * at the work done history and work done add
	 */
	@Test(priority = 6, dependsOnMethods = "treatmentStageInProgress")
	public void treatmentStageComplete() {
		logger.log(Status.PASS, TREATMENT_STAGE_COMPLETE);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectDoctor(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorksDonePageActions.selectTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "30");
		WorksDonePageActions.enterRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "Change to complete");
		WorksDonePageActions.selectStages(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "Completed");
		WorksDonePageActions.clickOnAdd(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.checkDateTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Completed");
		WorkDoneHistoryPageActions.followUpBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.reTreatBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.checkDataName(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.checkedClinic(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorkDoneHistoryPageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "30");
		WorkDoneHistoryPageActions.checkStageTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Completed");
		WorkDoneHistoryPageActions.checkedRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Change to complete");
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * validated all cases of the follow up modal and checked same at work done
	 * history and work done add
	 */
	@Test(priority = 7, dependsOnMethods = "treatmentStageComplete")
	public void followUp() {
		logger.log(Status.PASS, FOLLOW_UP);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Completed");
		WorkDoneHistoryPageActions.clickFollowUpBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.headerFollowUpModal("Follow up");
		WorkDoneHistoryPageActions.closeBtnFollowUpModal();
		WorkDoneHistoryPageActions.treatmentFollowUpModal(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.sourceFollowUpModal("24");
		WorkDoneHistoryPageActions.clinicNameFollowUpModal(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.errorMessageDisplayed();
		WorkDoneHistoryPageActions.notesFollowUp("follow up testing");
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.closeBtnFollowUpModal();
		WorkDoneHistoryPageActions.selectSpentTime("15");
		WorkDoneHistoryPageActions
				.selectTreatingDentistFollowUpModal(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.checkDateTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Completed");
		WorkDoneHistoryPageActions.followUpBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.reTreatBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.checkDataName(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.checkedClinic(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 5));
		WorkDoneHistoryPageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"Follow Up");
		WorkDoneHistoryPageActions.checkedRemarks(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"follow up testing");
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * Now converting the covid status from green to red Adding new treatment for
	 * red covid patient checking checkbox should not be present in treatment input
	 * listing and also checking start should not be present at the treatment plan
	 * listing
	 */
	@Test(priority = 8, dependsOnMethods = "bookAppointmentGreenFlag")
	public void convertingGreenToRedFlag() {
		logger.log(Status.PASS, CONVERTING_GREEN_TO_RED_FLAG);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.openCovidForm();
		CovidDeclarationFormPageActions.patientNameCovidForm(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		CovidDeclarationFormPageActions.selectedFirstQuestion("None of Them");
		CovidDeclarationFormPageActions.noOptionSelected(2);
		CovidDeclarationFormPageActions.noOptionSelected(3);
		CovidDeclarationFormPageActions.noOptionSelected(4);
		CovidDeclarationFormPageActions.noOptionSelected(5);
		CovidDeclarationFormPageActions.noOptionSelected(6);
		CovidDeclarationFormPageActions.noOptionSelected(7);
		CovidDeclarationFormPageActions.noOptionSelected(8);
		CovidDeclarationFormPageActions.noOptionSelected(9);
		CovidDeclarationFormPageActions.checkPatientTemperature("97");
		CovidDeclarationFormPageActions.checkPatientOximeter("100");
		CovidDeclarationFormPageActions.setPatientTemperature("100");
		CovidDeclarationFormPageActions.setPatientOximeter("90");
		CovidDeclarationFormPageActions.saveCovidForm();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.checkPatientRedFlag();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 1));
		TreatmentPlansPageActions.saveTreatment();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.checkedInputListDataName();
		TreatmentPlansPageActions.startCheckBoxInputListNotPresent();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE);
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions
				.selectDoctorFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		AppointmentAddPageActions.patientCovidRed();
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.covidAlertMsgRed();
		Assert.assertTrue(CommonPageActions.verification().contains("Add Appointment"));
	}

	/**
	 * validated retreat for the treatment scenario at the both page work done
	 * history and work done add page
	 */
	@Test(priority = 9, dependsOnMethods = "treatmentStageComplete")
	public void reTreatRedCovidPatient() {
		logger.log(Status.PASS, RE_TREAT);
		CommonPageActions.enterMobileNo(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		WorkDoneHistoryPageActions.followUpBtnRedCovidFlag(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.clickReTreatBtn(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		WorkDoneHistoryPageActions.headerReTreatModal("Are you sure you want to re-treat this treatment?");
		WorkDoneHistoryPageActions.closeBtnRetreatBtn();
		WorkDoneHistoryPageActions
				.selectTreatingDentistReTreatModal(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorkDoneHistoryPageActions.stageDropDownFirstTime();
		WorkDoneHistoryPageActions.saveRetreatDetails();
		WorkDoneHistoryPageActions.errorMessage("Select Reason");
		WorkDoneHistoryPageActions.selectReason("Others");
		WorkDoneHistoryPageActions.saveRetreatDetails();
		WorkDoneHistoryPageActions.errorMessage("Enter Notes");
		WorkDoneHistoryPageActions.notesRetreat("re-treat testing");
		WorkDoneHistoryPageActions.selectStage("Select Stage");
		WorkDoneHistoryPageActions.saveRetreatDetails();
		WorkDoneHistoryPageActions.errorMessage("Select Stage");
		WorkDoneHistoryPageActions.selectStage("In-Progress");
		WorkDoneHistoryPageActions.saveRetreatDetails();
		WorksDonePageActions.checkedStatusTreatment(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"In-Progress");
		WorksDonePageActions.modifiedDate(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), TODAY_DATE);
		WorksDonePageActions.checkDoctorTreated(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		WorksDonePageActions.checkSpentTime(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "0");
		WorksDonePageActions.checkStatus(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2), "In-Progress: Re-Treat");
		WorksDonePageActions.checkRemarksWorkDoneAddPage(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2),
				"re-treat testing");
		WorksDonePageActions.workDoneAddBtnRedCovidPatient(ExcelReader.readExcelData(FILE_PATH, TREATMENT_SHEET, 1, 2));
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}

	/**
	 * Redirecting at Appointment add page selecting same patient from the
	 * suggestion validated appointment should not be book for red covid flag
	 * patient
	 */
	@Test(priority = 10, dependsOnMethods = "bookAppointmentGreenFlag")
	public void appointmentRedCovidPatient() {
		logger.log(Status.PASS, APPOINTMENT_RED_COVID_PATIENT);
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterPatientName(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentAddPageActions
				.selectPatientSuggestion(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 1));
		AppointmentAddPageActions.patientCovidRed();
		AppointmentAddPageActions
				.selectDoctorFromDropdown(ExcelReader.readExcelData(FILE_PATH, APPOINTMENT_SHEET, 1, 9));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.covidAlertMsgRed();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
	}
}
