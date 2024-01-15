package tests;

import com.aventstack.extentreports.Status;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import freemarker.core.ParseException;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.ChiefComplaintAddPageActions;
import pageActions.patientDashboard.ChiefComplaintListingPageActions;
import utils.SheetTest;

public class AppointmentAddScanTestCase extends BaseClass {

	// Message here which We will print extent execution report after execution
	private static final String APPOINTMENT_SHEDULAR_CALENDER = "Appointment Scheduler Calender";
//    private static final int NO_OF_FUTURE_DAYS = 2;
	private static final String APPOINTMENT_ADD_PAGE = "";
	private static final String APPOINTMENT_E_CONSULT_PAGE = "";
	private static final String MANDATORY_FIELDS = "";
	private static final String BOOK_NEW_APPOINTMENT_E_CONSULT = "";
//    private static final String EDIT_APPOINTMENT = "";
//    private static final String VERIFY_ALREADY_BOOKED_DOCTOR_SLOT = "";
//    private static final String VALIDATE_AUTO_SELECT_PATIENT_FROM_SUGGESTION = "";
	private static final String STATUS_OF_SCRIPTS = "";
	Map<String, String> patntAppnmntData = null;


	@BeforeTest
	public void testSetup() {
		
		patntAppnmntData = SheetTest.prepareData("Appointment", "PatientAppointment", "A4", "X4");
	}

	@Test(groups = { "Regression" }, enabled = true, description = "Verify Scan Appointment Form Fields", priority = 1)
	public void appointmentScanPage() {
		logger.log(Status.PASS, APPOINTMENT_E_CONSULT_PAGE);
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.patientNameTextFields();
		AppointmentAddPageActions.patientMobileTextFields();
		AppointmentAddPageActions.patientIdTextFields();
		AppointmentAddPageActions.patientEmailIdTextFields();
		AppointmentAddPageActions.clinicDrpDwn();
		AppointmentAddPageActions.selectClinicFromDropdown("ExtSC-Ahmedabad");
		AppointmentAddPageActions.dateCalender();
		AppointmentAddPageActions.timeSlotDrpDwn();
//      AppointmentAddPageActions.selectingFutureDateAndVerifyStartTime(NO_OF_FUTURE_DAYS);
		AppointmentAddPageActions.timeDurationTextFields();
		AppointmentAddPageActions.doctorDrpDwn();
		AppointmentAddPageActions.scanners();
		AppointmentAddPageActions.sourceDrpDwn();
		AppointmentAddPageActions.referralDrpDwn();
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.notesFields();
		AppointmentAddPageActions.chiefComplaints();
		AppointmentAddPageActions.otherChiefComplaint();
		AppointmentAddPageActions.verifyServiceType("Home");
		AppointmentAddPageActions.verifyServiceType("Clinic");
		AppointmentAddPageActions.actionsBtnAppointmentAdd();
		AppointmentAddPageActions.checkSchedulerOptions();
		AppointmentAddPageActions.clickOnGoToSchedulerYesBtn();
		Assert.assertTrue(CommonPageActions.verification().contains(APPOINTMENT_SHEDULAR_CALENDER));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Verify Scan Appointment Mandatory Form Fields", priority = 2)
	public void mandatoryFields() {
		logger.log(Status.PASS, MANDATORY_FIELDS);
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterPatientNameMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterMobileNumber("12345");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterTenDigitMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterMobileNumber("0000000000");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterValidMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress("abc");
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterValidEmailAddressMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.validateServiceTypeMandatoryFieldsMessages("Home");
		AppointmentAddPageActions.validateServiceTypeMandatoryFieldsMessages("Clinic");
		driver.navigate().refresh();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.clickOnAppResetBtn();
		AppointmentAddPageActions.enterPatientName("clinic head");
		AppointmentAddPageActions.enterMobileNumber("1111111111");
		AppointmentAddPageActions.getTextPatientName("clinic head");
		AppointmentAddPageActions.getTextPatientMobile("1111111111");
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
	}

	@Test(groups = { "Regression", "Smoke", "Sanity",
			"Functional" }, enabled = true, description = "Add Scan Appointment", priority = 3)
	public void bookNewAppointmentScanHome() throws ParseException, java.text.ParseException, bsh.ParseException {
		logger.log(Status.PASS, BOOK_NEW_APPOINTMENT_E_CONSULT);
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.selectScan();
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress(patntAppnmntData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("scanCenter"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("slot"));
		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("duration"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown(patntAppnmntData.get("referral"));
		AppointmentAddPageActions.enterReferralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentAddPageActions.clickOnChiefComplaints(patntAppnmntData.get("chiefComplaint"));
		AppointmentAddPageActions.enterNote(patntAppnmntData.get("notes"));
		AppointmentAddPageActions.addHomeServiceAddress("B20");
		AppointmentAddPageActions.addHomeServiceCity("Gorakhpur");
		AppointmentAddPageActions.addHomeServicePincode("201013");
		AppointmentAddPageActions.selectServiceState("Uttar Pradesh");
		AppointmentAddPageActions.clickOnSaveBtn();
		BaseClass.waitForPageToBecomeActive();
		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "Scan");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("scanCenter"));
		AppointmentsLisitngPageActions.checkDoctorName(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.verifyServiceType(patntAppnmntData.get("patient_name"), "@Home");
		AppointmentsLisitngPageActions.verifyServiceLocation(patntAppnmntData.get("patient_name"), "B20");
		AppointmentsLisitngPageActions.viewButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.editButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.deleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.openViewModal(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("slot"));
		AppointmentsLisitngPageActions.patientIdView();
		AppointmentsLisitngPageActions.patientNameView(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.emailIdView(patntAppnmntData.get("email"));
		AppointmentsLisitngPageActions.mobileNumView(patntAppnmntData.get("patient_mobile"));
		AppointmentsLisitngPageActions.clinicNameView(patntAppnmntData.get("scanCenter"));
//      AppointmentsLisitngPageActions.DateOfAppView();
		AppointmentsLisitngPageActions.durationView(patntAppnmntData.get("duration"));
		AppointmentsLisitngPageActions.doctorView(patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.referralView(patntAppnmntData.get("referral"));
		AppointmentsLisitngPageActions.referralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentsLisitngPageActions.sourceView(patntAppnmntData.get("source"));
//      AppointmentsLisitngPageActions.chiefComplaintViewpatntAppnmntData.get("chiefComplaint"));
		AppointmentsLisitngPageActions.notesView(patntAppnmntData.get("notes"));
		AppointmentsLisitngPageActions.closeViewModal();
		AppointmentsLisitngPageActions.clickOnPatient(patntAppnmntData.get("patient_name"));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.checkAppointmentTime(patntAppnmntData.get("appointmentDate"),
				patntAppnmntData.get("slot"));
//      AppointmentsListPageActions.chiefComplaintpatntAppnmntData.get("chiefComplaint"));
		AppointmentsListPageActions.type("Scan");
		AppointmentsListPageActions.appointmentType("Confirmed");
		AppointmentsListPageActions.clinicName(patntAppnmntData.get("scanCenter"));
		AppointmentsListPageActions.doctorName(patntAppnmntData.get("doctor"));
		AppointmentsListPageActions.checkViewBtn();
		AppointmentsListPageActions.checkEditBtn();
		AppointmentsListPageActions.checkDeleteBtn();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
//		ChiefComplaintAddPageActions.verifyChiefComplaintsInputList("Pain"); //Should not be blank or null - Valid value must be selected
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
//		ChiefComplaintListingPageActions.chiefComplaintInMainList("Pain");
//		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Delete Appointment Add Scan Appointment", priority = 4)
	public void deleteAppointment() {
		AppointmentAddPageActions.clickOnCancelBtn();
		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.enterToDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.enterFromDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "Scan");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"), patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.checkDoctorName(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.viewButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.editButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.deleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.clickDeleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.verifyWebElementDeletePopup();
		AppointmentsLisitngPageActions.selectReasonDelete();
		AppointmentsLisitngPageActions.clickYesDeletePopup();
		AppointmentsLisitngPageActions.strikeOff(patntAppnmntData.get("patient_name"));
		CommonPageActions.backTODoctorDashboard();
	}
}
