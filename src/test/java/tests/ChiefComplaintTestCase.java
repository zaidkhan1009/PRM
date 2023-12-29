package tests;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.ChiefComplaintAddPageActions;
import pageActions.patientDashboard.ChiefComplaintListingPageActions;
import utils.SheetTest;
import utils.TestData;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class ChiefComplaintTestCase extends BaseClass {

	/* Mandatory Inputs for chief complaint Test Cases */
//	private static final String PATIENT_NAME=TestData.getInstance().getInputData("chief_complaint_patient_name");
//	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("chief_complaint_patient_mobile");
//	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("chief_complaint_doctor_name");
//	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("chief_complaint_doctor_nikName");
//	private static final String CLINIC_NAME = TestData.getInstance().getInputData("chief_complaint_clinic_name");

	/* Test Cases details for extent report */

	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String CHIEF_COMPLAINT_LIST_HOME_PAGE = "Validating Chief Complaint listing without Chief Complaints - #chiefCompalintListHomePage";
	private static final String CHIEF_COMPLAINT_ADD_PAGE_FIRST_TIME = "Validating Chief Complaint Add when Redirects for first time - #chiefComplaintAddPageFirstTime";
	private static final String APPOINTMENT_WITH_OUT_CHIEF_COMPLAINT_IMPACT_IN_CHIEF_COMPLAINT_LIST = "Appointment WithOut ChiefComplaint Impact In Chief Complaint Listing - #appointmentWithOutChiefComplaintImpactInChiefComplaintList";
	private static final String PAIN_POPUP_ELEMENT_AND_BEHAVIOUR = "Validating all User Interface and Behaviour of Pain popup at chief complaint Add page - #painPopupElementAndBehaviour";
	private static final String VERIFY_DELETE_BTN_CCADD_PAGE = "Validating chief complaint editing and deleting functionality - #VerifyDeleteBTnCCAddPage";
	private static final String ADD_CCWITHOUT_APP_SAME_DAY = "Adding Chief Complaint Without Appointment on same day - #addCCWithoutAppSameDay";
	private static final String CHIEF_COMPLAINT_BY_CLINIC_WISE = "Adding Chief Complaint By changing clinic - #chiefComplaintByClinicWise";
	Map<String, String> patntChiefCmplntData = null;

	/*
	 * loginPage with UserName and Password search for patients from the doctor
	 * dashboard verified patients will redirect at the patient dashboard
	 */

	
	@Test(groups = {
			"Regression" }, enabled = true, description = "Verify Chief Complaint Listing & Elements", priority = 1)
	public void chiefComplaintListHomePage() {
		logger.log(Status.PASS, CHIEF_COMPLAINT_LIST_HOME_PAGE);
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.headerOnListPage("Chief Complaint Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(patntChiefCmplntData.get("patient_name"));
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
//	ChiefComplaintListingPageActions.verifyNoRecordFoundMessage();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
//	BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.headerOnAddPage("Chief Complaints");
		BasePatientLifeCyclePageActions.verifyPatientName(patntChiefCmplntData.get("patient_name"));
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		ChiefComplaintAddPageActions.VerifyChiefCompliantBoxes();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		ChiefComplaintAddPageActions.verifyOralExamBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaints"));
	}

//	/*adding chief complaints for the patient without having chief complaints at the same day
//	* deleted from the input list of the chief complaint Add page
//	* deleted checked at input listing,chief complaint listing and view modal*/	

	@Test(groups = { "Smoke", "Sanity", "Functional",
			"Regression" }, enabled = true, description = "Add Verify & Delete Chief Complaint without Appointment", priority = 2)
	public void addCCWithoutAppSameDay() {
		logger.log(Status.PASS, ADD_CCWITHOUT_APP_SAME_DAY);
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.appointmentAvailable();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Bleeding Gums");
		ChiefComplaintAddPageActions.chiefComplaintAddSuccessMsg();
		ChiefComplaintAddPageActions.checkedInputlistDataName();
		ChiefComplaintAddPageActions.withoutLocationInputList("Bleeding Gums", "NA");
		ChiefComplaintAddPageActions.intensityInputList("Bleeding Gums", "NA");
		ChiefComplaintAddPageActions.periodsBehaviour("Bleeding Gums", 0, 0, "NA");
		ChiefComplaintAddPageActions.notesInputList("Bleeding Gums", "NA");
		ChiefComplaintAddPageActions.actionBtnInputList("Bleeding Gums");
		ChiefComplaintAddPageActions.clickOnDeleteBtn("Bleeding Gums");
		ChiefComplaintAddPageActions.deletedChiefComplaintInInputList("Bleeding Gums");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.verifyDates();
		ChiefComplaintListingPageActions.deletedChiefComplaintInMainList("Bleeding Gums");
		BasePatientLifeCyclePageActions.clickViewBtn(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.verifyDateInView();
		ChiefComplaintListingPageActions.deletedChiefComplaintInView("Bleeding Gums");
		ChiefComplaintListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

	/*
	 * adding appointment checked chief complaint listing any chief complaints are
	 * not added at the time of appointment creation
	 */

	@Test(groups = { "Smoke", "Sanity", "Functional",
			"Regression" }, enabled = true, description = "Book Appointment With Chief Complaint", priority = 3)
	public void appointmentWithOutChiefComplaintImpactInChiefComplaintList() {
		logger.log(Status.PASS, APPOINTMENT_WITH_OUT_CHIEF_COMPLAINT_IMPACT_IN_CHIEF_COMPLAINT_LIST);
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(patntChiefCmplntData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.enterReferralDetails("self");
		AppointmentAddPageActions.clickOnChiefComplaints("Tooth Decay");
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Tooth Decay");
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

//	/*checked chief complaints add and chief complaint listing page default screen
//	* checked left side navigation module
//	*All chief complaints boxes */

	@Test(groups = { "Smoke", "Sanity", "Functional", "Regression" }, enabled = true, priority = 4)
	public void ChiefComplaintAddPageActions() {
		logger.log(Status.PASS, CHIEF_COMPLAINT_ADD_PAGE_FIRST_TIME);
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Discolored Tooth");
		ChiefComplaintAddPageActions.chiefComplaintAddSuccessMsg();
		ChiefComplaintAddPageActions.checkedInputlistDataName();
		ChiefComplaintAddPageActions.withoutLocationInputList("Discolored Tooth", "NA");
		ChiefComplaintAddPageActions.intensityInputList("Discolored Tooth", "NA");
		ChiefComplaintAddPageActions.periodsBehaviour("Discolored Tooth", 0, 0, "NA");
		ChiefComplaintAddPageActions.notesInputList("Discolored Tooth", "NA");
		ChiefComplaintAddPageActions.actionBtnInputList("Discolored Tooth");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.checkedMainlistDataName();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Discolored Tooth");
		ChiefComplaintListingPageActions.locationMainList("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.intensityMainList("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.periodsInMainList("Discolored Tooth", 0, 0, "NA");
		ChiefComplaintListingPageActions.chiefComplaintcreatedBy("Discolored Tooth",
				patntChiefCmplntData.get("doctorNickName"));
		ChiefComplaintListingPageActions.notesMainList("Discolored Tooth", "NA");
		BasePatientLifeCyclePageActions.clickViewBtn(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.verifyDateInView();
		ChiefComplaintListingPageActions.viewChiefComplaint();
		ChiefComplaintListingPageActions.dataNameInView();
		ChiefComplaintListingPageActions.checkedChiefComplaintInView("Discolored Tooth");
		ChiefComplaintListingPageActions.locationInView("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.intentsityInView("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.periodsInView("Discolored Tooth", 0, 0, "NA");
		ChiefComplaintListingPageActions.userNameInView("Discolored Tooth", patntChiefCmplntData.get("doctorNickName"));
		ChiefComplaintListingPageActions.notesInView("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

//	/*checked the all webelement of the popup of the pain,Sensitivity and other
//	* also checked the behavior of the popup
//	* also added pain chief complaints from the popup
//	* and checked at chief complaint add page input listing and
//	* chief complaint listing page and view modal*/

	@Test(groups = { "Smoke", "Functional", "Regression" }, enabled = true, priority = 5)
	public void painPopupElementAndBehaviour() {
		logger.log(Status.PASS, PAIN_POPUP_ELEMENT_AND_BEHAVIOUR);
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Pain");
		ChiefComplaintAddPageActions.checkedPopupElement();
		ChiefComplaintAddPageActions.multiSelectOfLocation();
		ChiefComplaintAddPageActions.clickOnSevere();
		ChiefComplaintAddPageActions.clickOnModerate();
		ChiefComplaintAddPageActions.verifySevereIsNotSelected();
		ChiefComplaintAddPageActions.SelectMonth(4);
		ChiefComplaintAddPageActions.clickOnSaveBtn();
		ChiefComplaintAddPageActions.intensityInputList("Pain", "Moderate");
		ChiefComplaintAddPageActions.periodsBehaviour("Pain", 4, 0, "Value");
		ChiefComplaintAddPageActions.actionBtnInputList("Pain");
		ChiefComplaintAddPageActions.clickEditInInputList("Pain");
		ChiefComplaintAddPageActions.SelectDays(12);
		ChiefComplaintAddPageActions.enterNote("notes testing");
		ChiefComplaintAddPageActions.clickOnSaveBtn();
		ChiefComplaintAddPageActions.intensityInputList("Pain", "Moderate");
		ChiefComplaintAddPageActions.periodsBehaviour("Pain", 4, 12, "Value");
		ChiefComplaintAddPageActions.notesInputList("Pain", "notes testing");
		ChiefComplaintAddPageActions.actionBtnInputList("Pain");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.checkedMainlistDataName();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Pain");
		ChiefComplaintListingPageActions.locationMainList("Pain", "Value");
		ChiefComplaintListingPageActions.intensityMainList("Pain", "Moderate");
		ChiefComplaintListingPageActions.periodsInMainList("Pain", 4, 12, "Value");
		ChiefComplaintListingPageActions.chiefComplaintcreatedBy("Pain", patntChiefCmplntData.get("doctorNickName"));
		ChiefComplaintListingPageActions.notesMainList("Pain", "notes testing");
		BasePatientLifeCyclePageActions.clickViewBtn(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.verifyDateInView();
		ChiefComplaintListingPageActions.viewChiefComplaint();
		ChiefComplaintListingPageActions.dataNameInView();
		ChiefComplaintListingPageActions.checkedChiefComplaintInView("Pain");
		ChiefComplaintListingPageActions.locationInView("Pain", "Value");
		ChiefComplaintListingPageActions.intentsityInView("Pain", "Moderate");
		ChiefComplaintListingPageActions.periodsInView("Pain", 4, 12, "Value");
		ChiefComplaintListingPageActions.userNameInView("Pain", patntChiefCmplntData.get("doctorNickName"));
		ChiefComplaintListingPageActions.notesInView("Pain", "notes testing");
		ChiefComplaintListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

	/*
	 * added chief complaint Plaque verified success message and checked chief
	 * complaints in input listing same checked at chief complaints listing also
	 * checked all action button at both page either chief complaints add page or
	 * chief complaints listing edited from the chief complaints listing page again
	 * edited from the chief complaints add page and checked cancel btn and added
	 * notes and saved.same checked at chief complaints add page and chief complaint
	 * listing
	 */

	@Test(groups = { "Functional", "Regression" }, enabled = true, priority = 6)
	public void VerifyDeleteBTnCCAddPage() {
		logger.log(Status.PASS, VERIFY_DELETE_BTN_CCADD_PAGE);
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Plaque");
		ChiefComplaintAddPageActions.chiefComplaintAddSuccessMsg();
		ChiefComplaintAddPageActions.checkedInputlistDataName();
		ChiefComplaintAddPageActions.withoutLocationInputList("Plaque", "NA");
		ChiefComplaintAddPageActions.intensityInputList("Plaque", "NA");
		ChiefComplaintAddPageActions.periodsBehaviour("Plaque", 0, 0, "NA");
		ChiefComplaintAddPageActions.notesInputList("Plaque", "NA");
		ChiefComplaintAddPageActions.actionBtnInputList("Plaque");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.checkedMainlistDataName();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Plaque");
		ChiefComplaintListingPageActions.locationMainList("Plaque", "NA");
		ChiefComplaintListingPageActions.intensityMainList("Plaque", "NA");
		ChiefComplaintListingPageActions.periodsInMainList("Plaque", 0, 0, "NA");
		ChiefComplaintListingPageActions.notesMainList("Plaque", "NA");
		BasePatientLifeCyclePageActions.clickEditBtn(patntChiefCmplntData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.actionBtnInputList("Plaque");
		ChiefComplaintAddPageActions.clickEditInInputList("Plaque");
		ChiefComplaintAddPageActions.chiefComplaintsInputEdit("Plaque");
		ChiefComplaintAddPageActions.cancelInputListEdit("Plaque");
		ChiefComplaintAddPageActions.actionBtnInputList("Plaque");
		ChiefComplaintAddPageActions.clickEditInInputList("Plaque");
		ChiefComplaintAddPageActions.enterNotesInputList("Plaque", "notes testing");
		ChiefComplaintAddPageActions.saveInputListEdit("Plaque");
		ChiefComplaintAddPageActions.actionBtnInputList("Plaque");
		ChiefComplaintAddPageActions.notesInputList("Plaque", "notes testing");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntChiefCmplntData.get("clinicLocation"));
		ChiefComplaintListingPageActions.checkedMainlistDataName();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Plaque");
		ChiefComplaintListingPageActions.locationMainList("Plaque", "NA");
		ChiefComplaintListingPageActions.intensityMainList("Plaque", "NA");
		ChiefComplaintListingPageActions.periodsInMainList("Plaque", 0, 0, "NA");
		ChiefComplaintListingPageActions.notesMainList("Plaque", "notes testing");
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

//	/*added chief complaints in other clinic by adding Appointment with a chief complaints
//	* same patient with chief complaint in different clinic checked at chief complaints listing*/

	@Test(groups = { "Functional", "Regression" }, enabled = true, priority = 7)
	public void chiefComplaintByClinicWise() {
		logger.log(Status.PASS, CHIEF_COMPLAINT_BY_CLINIC_WISE);
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions
				.selectClinicFromDropdown(TestData.getInstance().getInputData("chief_complaint_another_clinic_name"));
//		AppointmentAddPageActions.selectDateofAppointment(TestData.getInstance().getInputData("chief_complaint_future_date"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntChiefCmplntData.get("doctor"));
		AppointmentAddPageActions.selectChiefComplaints("Discolored Tooth");
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		ChiefComplaintListingPageActions.verifyChiefComplaintByClinicWise(
				TestData.getInstance().getInputData("chief_complaint_another_clinic_name"));
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Discolored Tooth");
		ChiefComplaintListingPageActions.locationMainList("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.intensityMainList("Discolored Tooth", "NA");
		ChiefComplaintListingPageActions.periodsInMainList("Discolored Tooth", 0, 0, "NA");
		ChiefComplaintListingPageActions.notesMainList("Discolored Tooth", "NA");
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

}
