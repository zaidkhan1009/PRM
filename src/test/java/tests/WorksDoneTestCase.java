package tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.LabWorkOrderEditPageActions;
import pageActions.patientDashboard.LabWorkOrderListingPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.SheetTest;
import utils.TestData;

public class WorksDoneTestCase extends BaseClass{

	Map<String, String> workDoneData = null;

	/**
	 * Storing mandatory input required to run work done test cases
	 * or please update the mandatory input before running the test cases
	 */
	private static final String FILE_PATH = TestData.getInstance().getInputData("work_done_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("work_done_file_sheet_name");
	private static final String TODAY_DATE = TestData.getInstance().getTodayDate();
//	private static final String PATIENT_NAME= TestData.getInstance().getInputData("work_done_patient_name");
//	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("work_done_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("work_done_doctor_name");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("work_done_clinic_name");

	/**
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String CHECKED_WORK_DONE_ADD_AND_HISTORY_NO_TREATMENT = "Validated work done add and work done history page without any treatment for the patient - #checkedWorkDoneAddAndHistoryNoTreatment";
	private static final String START_TREATMENT = "Validating the work done add page and work done history page after starting the treatment for the patient - #startTreatment";
	private static final String TREATMENT_STAGE_IN_PROGRESS = "Validating the work add page and work done history page after changing the status of the treatment from started to In-progress - #treatmentStageInProgress";
	private static final String TREATMENT_STAGE_COMPLETE = "Validating the work done add and work done history page after changing the status of the treatment from in-progress to complete - #treatmentStageComplete";
	private static final String FOLLOW_UP = "Validating the work done history page, follow up modal and work done add page after doing follow up for the patient - #followUp";
	private static final String RE_TREAT = "Validating the work done history page, retreat modal and work done add page after changing status of the treatment from follow up to retreat for the patient -#reTreat";

	/**
	 * checked header of the work done page
	 * checked works done add page without any treatment when we redirect for the first time
	 * checked the patient name and id should not be "null" or "NA"
	 * checked patient dashboard button, invoice button and works done history button
	 * checked left side navigation all button at both work done add page and Work Done History
	 * checked work done history page header
	 * checked no record message displayed at the both page for first time  redirection
	 */
	
	@Test(enabled = true, priority = 1)
	public void checkedWorkDoneAddAndHistoryNoTreatment() {
		logger.log(Status.PASS, CHECKED_WORK_DONE_ADD_AND_HISTORY_NO_TREATMENT);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		/* Only For First Time */
//		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		WorksDonePageActions.checkedUserName(workDoneData.get("patient_name"));
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectAdvanceBtn();
		WorksDonePageActions.checkedHistoryBtn();
		WorksDonePageActions.checkLabWorkOrderBtn();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		WorksDonePageActions.clickWorkDoneHistory();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		WorksDonePageActions.checkedUserName(workDoneData.get("patient_name"));
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectAdvanceBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * Added treatment for the patient
	 * checked same treatment at the treatment listing
	 * checked the start button at treatment listing if not present then added Appointment for the same patient
	 * started treatment from the treatment plan listing
	 * checked toast message starting the treatment without selecting any treatment at treatment plan listing
	 * selecting the treatment and started
	 * validated same treatment at work done add page
	 * same checked at the work done history page
	 * validated all action button present at the both work done add and work done history page
	 */
	
	@Test(enabled = true, priority = 2,description = "Start Treatment For Auto-Complete Plans")
	public void startTreatmenAutoComplete() {
		logger.log(Status.PASS, START_TREATMENT);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(workDoneData.get("planGroup4_Plan1"));
		TreatmentPlansPageActions.saveTreatment();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		/*Checking start button and booking appointment for appearing start btn in doctor*/
//		TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE);
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(workDoneData.get("doctor"));
        AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.checkedWithoutTreatmentStart();
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(workDoneData.get("planGroup4_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		WorksDonePageActions.checkedTreatmentStartMsgDisplayed();
		WorksDonePageActions.checkedAddAllBtn();
		WorksDonePageActions.checkLabWorkOrderBtn();
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectPaymentBtn();
		WorksDonePageActions.checkedPrintBtn();
		WorksDonePageActions.checkedHistoryBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorksDonePageActions.checkDateTreatment(workDoneData.get("planGroup4_Plan1_FullName"),TODAY_DATE);
		WorksDonePageActions.checkSourceNo(workDoneData.get("planGroup4_Plan1_FullName"), "24");
		WorksDonePageActions.checkedStatusTreatment(workDoneData.get("planGroup4_Plan1_FullName"),"Completed");
		WorksDonePageActions.checkProgressDropDown(workDoneData.get("planGroup4_Plan1_FullName"));
		WorksDonePageActions.checkDataName(workDoneData.get("planGroup4_Plan1_FullName"));
		WorksDonePageActions.checkBox(workDoneData.get("planGroup4_Plan1_FullName"));
		WorksDonePageActions.modifiedDate(workDoneData.get("planGroup4_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkDoctorSelected(workDoneData.get("planGroup4_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.checkedClinic(workDoneData.get("planGroup4_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorksDonePageActions.checkTimeSelected(workDoneData.get("planGroup4_Plan1_FullName"), "Select");
		WorksDonePageActions.checkedRemarks(workDoneData.get("planGroup4_Plan1_FullName"));
		WorksDonePageActions.checkedAddButton(workDoneData.get("planGroup4_Plan1_FullName"));
		/*-------------workdone history check all data-----------------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectPaymentBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorkDoneHistoryPageActions.checkDateTreatment(workDoneData.get("planGroup4_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(workDoneData.get("planGroup4_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup4_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.checkDataName(workDoneData.get("planGroup4_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(workDoneData.get("planGroup4_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(workDoneData.get("planGroup4_Plan1_FullName"),workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.checkStageTreatment(workDoneData.get("planGroup4_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.checkedRemarks(workDoneData.get("planGroup4_Plan1_FullName"), "No Remarks");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}
	
	@Test(enabled = true, priority = 3,description = "Start Treatment For Non Auto-Complete Plans")
	public void startTreatmentAligner() {
		logger.log(Status.PASS, START_TREATMENT);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnCrowns();
		TreatmentPlansPageActions.clickOnTreatments(workDoneData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.saveTreatment();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		/*Checking start button and booking appointment for appearing start btn in doctor*/
//		TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE);
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnAppAdd();
//		AppointmentAddPageActions.selectDoctorFromDropdown(workDoneData.get("doctor"));
//      AppointmentAddPageActions.selectReferralFromDropdown("Patient");
//		AppointmentAddPageActions.clickOnSaveBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.checkedWithoutTreatmentStart();
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(workDoneData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		WorksDonePageActions.checkedTreatmentStartMsgDisplayed();
		WorksDonePageActions.checkedAddAllBtn();
		WorksDonePageActions.checkLabWorkOrderBtn();
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectPaymentBtn();
		WorksDonePageActions.checkedPrintBtn();
		WorksDonePageActions.checkedHistoryBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorksDonePageActions.checkDateTreatment(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkSourceNo(workDoneData.get("planGroup1_Plan1_FullName"), "24");
		WorksDonePageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Started");
		WorksDonePageActions.checkProgressDropDown(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkSuspededBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkDataName(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkBox(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkDoctorSelected(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.checkedClinic(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorksDonePageActions.checkTimeSelected(workDoneData.get("planGroup1_Plan1_FullName"), "Select");
		WorksDonePageActions.checkedRemarks(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkedAddButton(workDoneData.get("planGroup1_Plan1_FullName"));
		/*-------------workdone history check all data-----------------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedCollectPaymentBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorkDoneHistoryPageActions.checkDateTreatment(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(workDoneData.get("planGroup1_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorkDoneHistoryPageActions.checkDataName(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"),workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.checkedClinic(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorkDoneHistoryPageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Started");
		WorkDoneHistoryPageActions.checkedRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "No Remarks");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}
	
	@Test(enabled = true, priority = 3,description = "Start Treatment For Aligners")
	public void startAddWorkDoneForAlignerTreatment() {
		logger.log(Status.PASS, TREATMENT_STAGE_IN_PROGRESS);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
//		WorksDonePageActions.selectDoctor(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.verifyUIAndaddWorkDoneForAlignerTreatment("Invisalign Express Single Arch - Invisible Aligners for Dentofacial Orthopaedics","Single","testing");
//		WorksDonePageActions.checkPlan("Invisalign Express Single Arch - Invisible Aligners for Dentofacial Orthopaedics");
//		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}


	/**
	 * Changing the work done stages and checked All new updated data at work done add page and work done history page
	 */
	@Test(enabled = true, priority = 4,description = "Verify Treatment Stages")
	public void treatmentStageInProgress() {
		logger.log(Status.PASS, TREATMENT_STAGE_IN_PROGRESS);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectDoctor(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.selectTime(workDoneData.get("planGroup1_Plan1_FullName"), "15");
		WorksDonePageActions.enterRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "it is for testing");
		WorksDonePageActions.selectStages(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorksDonePageActions.clickOnAdd(workDoneData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.closeAppoitmentPopup();
		WorksDonePageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorksDonePageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "15");
		WorksDonePageActions.checkStatus(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorksDonePageActions.checkRemarksWorkDoneAddPage(workDoneData.get("planGroup1_Plan1_FullName"),"it is for testing");
		WorksDonePageActions.checkEdit(workDoneData.get("planGroup1_Plan1_FullName"));
		/*-------Changed stages of treatment and checked in workdone History---------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkDateTreatment(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(workDoneData.get("planGroup1_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorkDoneHistoryPageActions.checkDataName(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.checkedClinic(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorkDoneHistoryPageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorkDoneHistoryPageActions.checkedRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "it is for testing");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}

	/**
	 * changing the stages of the treatment to complete and checked all new changes at the work done history and work done add
	 */
	@Test(enabled = true, priority = 5,dependsOnMethods = {"treatmentStageInProgress"})
	public void treatmentStageComplete() {
		logger.log(Status.PASS, TREATMENT_STAGE_COMPLETE);
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectDoctor(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.selectTime(workDoneData.get("planGroup1_Plan1_FullName"), "30");
		WorksDonePageActions.enterRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "Change to complete");
		WorksDonePageActions.selectStages(workDoneData.get("planGroup1_Plan1_FullName"), "Completed");
		WorksDonePageActions.clickOnAdd(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.checkDateTreatment(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(workDoneData.get("planGroup1_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.followUpBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.reTreatBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.checkDataName(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.checkedClinic(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorkDoneHistoryPageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "30");
		WorkDoneHistoryPageActions.checkStageTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.checkedRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "Change to complete");
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		WorksDonePageActions.checkLabWorkOrderBtn();
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedHistoryBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorksDonePageActions.checkedPrintBtnNotPresent();
		WorksDonePageActions.checkedAddAllBtnNotPresent();
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}

	/**
	 * validated all cases of the follow up modal and checked same at work done history and work done add
	 */
	@Test(enabled = true, priority = 6,dependsOnMethods = {"treatmentStageComplete"})
	public void followUp(){
		logger.log(Status.PASS, FOLLOW_UP);
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.clickFollowUpBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.headerFollowUpModal("Follow up");
		WorkDoneHistoryPageActions.closeBtnFollowUpModal();
		WorkDoneHistoryPageActions.treatmentFollowUpModal(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.sourceFollowUpModal("24");
		WorkDoneHistoryPageActions.clinicNameFollowUpModal(workDoneData.get("clinicLocation"));
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.errorMessageDisplayed();
		WorkDoneHistoryPageActions.notesFollowUp("follow up testing");
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.closeBtnFollowUpModal();
		WorkDoneHistoryPageActions.selectSpentTime("15");
		WorkDoneHistoryPageActions.selectTreatingDentistFollowUpModal(workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.saveFollowUpDetails();
		WorkDoneHistoryPageActions.checkDateTreatment(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(workDoneData.get("planGroup1_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Completed");
		WorkDoneHistoryPageActions.followUpBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.reTreatBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.checkDataName(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorkDoneHistoryPageActions.checkedClinic(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("clinicLocation"));
		WorkDoneHistoryPageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "Follow Up");
		WorkDoneHistoryPageActions.checkedRemarks(workDoneData.get("planGroup1_Plan1_FullName"), "follow up testing");
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		WorksDonePageActions.checkLabWorkOrderBtn();
		WorksDonePageActions.checkedInvoiceListBtn();
		WorksDonePageActions.checkedHistoryBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorksDonePageActions.checkedPrintBtnNotPresent();
		WorksDonePageActions.checkedAddAllBtnNotPresent();
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}

	/**
	 * validated retreat for the treatment scenario at the both page work done history and work done add page
	 */
	@Test(enabled = true, priority = 7,dependsOnMethods = {"followUp"})
	public void reTreat(){
		logger.log(Status.PASS, RE_TREAT);
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		WorkDoneHistoryPageActions.clickReTreatBtn(workDoneData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.headerReTreatModal("Are you sure you want to re-treat this treatment?");
		WorkDoneHistoryPageActions.closeBtnRetreatBtn();
		WorkDoneHistoryPageActions.selectTreatingDentistReTreatModal(workDoneData.get("doctor"));
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
		WorksDonePageActions.checkedStatusTreatment(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorksDonePageActions.modifiedDate(workDoneData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkDoctorTreated(workDoneData.get("planGroup1_Plan1_FullName"), workDoneData.get("doctor"));
		WorksDonePageActions.checkSpentTime(workDoneData.get("planGroup1_Plan1_FullName"), "0");
		WorksDonePageActions.checkStatus(workDoneData.get("planGroup1_Plan1_FullName"), "In-Progress: Re-Treat");
		WorksDonePageActions.checkRemarksWorkDoneAddPage(workDoneData.get("planGroup1_Plan1_FullName"),"re-treat testing");
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}
}
