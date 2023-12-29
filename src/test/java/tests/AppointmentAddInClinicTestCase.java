package tests;

import bsh.ParseException;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pages.doctorDashboard.AppointmentAddPage;
import utils.SheetTest;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import base.BaseClass;

public class AppointmentAddInClinicTestCase extends BaseClass {

	static AppointmentAddPage appointmentPage = PageFactory.initElements(driver, AppointmentAddPage.class);

	// Message here which We will print extent execution report after execution
	private static final String APPOINTMENT_SHEDULAR_CALENDER = "Appointment Scheduler Calender";
	private static final int NO_OF_FUTURE_DAYS = 2;
	private static final String APPOINTMENT_ADD_PAGE = "";
	private static final String APPOINTMENT_E_CONSULT_PAGE = "";
	private static final String MANDATORY_FIELDS = "";
	private static final String BOOK_NEW_APPOINTMENT_E_CONSULT = "";
	private static final String EDIT_APPOINTMENT = "";
	private static final String VERIFY_ALREADY_BOOKED_DOCTOR_SLOT = "";
	private static final String VALIDATE_AUTO_SELECT_PATIENT_FROM_SUGGESTION = "";
	private static final String STATUS_OF_SCRIPTS = "";
	private static final String BOOK_NEW_APPOINTMENT_IN_CLINIC = "";
	private static final String BOOK_TENTATIVE_APPOINTMENT = "";
	private static final String APPOINTMENT_IN_CLINIC_PAGE = "";
	Map<String, String> patntAppnmntData = null;

	@BeforeTest
	public void testSetup() {
	patntAppnmntData = SheetTest.prepareData("Appointment", "PatientAppointment", "A3", "X3");
	}
	
	@Test(groups = { "Regression" }, enabled = true, description = "Verify Appointment Form Elements", priority = 1)
	public void appointmentInClinicPage() {

		logger.log(Status.PASS, APPOINTMENT_IN_CLINIC_PAGE);

		BaseClass.openAddAppointmentPage();
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.patientMobileTextFields();
		AppointmentAddPageActions.patientNameTextFields();
		AppointmentAddPageActions.patientIdTextFields();
		AppointmentAddPageActions.patientEmailIdTextFields();
		AppointmentAddPageActions.selectInClinic();
		AppointmentAddPageActions.clinicDrpDwn();
		AppointmentAddPageActions.dateCalender();
		AppointmentAddPageActions.timeSlotDrpDwn();
		// AppointmentAddPageActions.selectingFutureDateAndVerifyStartTime(5);
		AppointmentAddPageActions.timeDurationTextFields();
		AppointmentAddPageActions.doctorDrpDwn();
		AppointmentAddPageActions.checkFirstOperatoriesIsSelected();
		AppointmentAddPageActions.sourceDrpDwn();
		AppointmentAddPageActions.referralDrpDwn();
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.notesFields();
		AppointmentAddPageActions.tentativeCheckBox();
		AppointmentAddPageActions.chiefComplaints();
		AppointmentAddPageActions.otherChiefComplaint();
		AppointmentAddPageActions.actionsBtnAppointmentAdd();
		AppointmentAddPageActions.checkSchedulerOptions();
		AppointmentAddPageActions.clickOnGoToSchedulerYesBtn();

		Assert.assertTrue(CommonPageActions.verification().contains("Appointment Scheduler Calender"));
		CommonPageActions.backToDoctorDashbrd();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Verify Appointment Mandatory Elements", priority = 2)
	public void mandatoryFields() {
		
		logger.log(Status.PASS, MANDATORY_FIELDS);
		
		BaseClass.openAddAppointmentPage();
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		// AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("clinicLocation"));
		
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterPatientNameMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterMobileNumber("12345");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		// AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterTenDigitMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterMobileNumber("0000000000");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		// AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterValidMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress("abc");
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));

		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterValidEmailAddressMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.clickOnAppResetBtn();
		AppointmentAddPageActions.enterPatientName("clinic head");
		AppointmentAddPageActions.enterMobileNumber("1111111111");
		AppointmentAddPageActions.getTextPatientName("clinic head");
		AppointmentAddPageActions.getTextPatientMobile("1111111111");
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
		CommonPageActions.backToDoctorDashbrd();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Verify Book In-Clinic Appointments", priority = 3)
	public void bookNewAppointmentInClinic() throws ParseException, java.text.ParseException {

		logger.log(Status.PASS, BOOK_NEW_APPOINTMENT_IN_CLINIC);
		
		BaseClass.openAddAppointmentPage();
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterEmailAddress(patntAppnmntData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("clinicLocation"));
		// AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("slot"));
		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("duration"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown(patntAppnmntData.get("referral"));
		AppointmentAddPageActions.enterReferralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentAddPageActions.clickOnChiefComplaints(patntAppnmntData.get("chiefComplaint"));
		AppointmentAddPageActions.enterNote(patntAppnmntData.get("notes"));
		AppointmentAddPageActions.clickOnSaveBtn();

		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));

		DoctorDashBoardPageActions.clickOnAppListBtn();

		AppointmentsLisitngPageActions.clickOnLastPage();
//      AppointmentsLisitngPageActions.patientFlag(patntAppnmntData.get("patient_name"), "green");
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "in-Clinic");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.checkDoctorName(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.viewButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.editButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.deleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.openViewModal(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("slot"));
		AppointmentsLisitngPageActions.patientIdView();
		AppointmentsLisitngPageActions.patientNameView(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.emailIdView(patntAppnmntData.get("email"));
		AppointmentsLisitngPageActions.mobileNumView(patntAppnmntData.get("patient_mobile"));
		AppointmentsLisitngPageActions.clinicNameView(patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.DateOfAppView();
		AppointmentsLisitngPageActions.durationView(patntAppnmntData.get("duration"));
		AppointmentsLisitngPageActions.doctorView(patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.operatoriesView();
		AppointmentsLisitngPageActions.referralView(patntAppnmntData.get("referral"));
		AppointmentsLisitngPageActions.referralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentsLisitngPageActions.sourceView(patntAppnmntData.get("source"));
//      AppointmentsLisitngPageActions.chiefComplaintView(patntAppnmntData.get("chiefComplaint"));
		AppointmentsLisitngPageActions.notesView(patntAppnmntData.get("notes"));
		AppointmentsLisitngPageActions.closeViewModal();
		AppointmentsLisitngPageActions.clickOnPatient(patntAppnmntData.get("patient_name"));
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.checkAppointmentTime(patntAppnmntData.get("appointmentDate"),patntAppnmntData.get("slot"));
//      appointmentsListPage.chiefComplaint(patntAppnmntData.get("chiefComplaint"));
        AppointmentsListPageActions.type("in-clinic");
        AppointmentsListPageActions.appointmentType("Confirmed");
        AppointmentsListPageActions.clinicName(patntAppnmntData.get("clinicLocation"));
        AppointmentsListPageActions.doctorName(patntAppnmntData.get("doctor"));
        AppointmentsListPageActions.checkViewBtn();
        AppointmentsListPageActions.checkEditBtn();
        AppointmentsListPageActions.checkDeleteBtn();
        AppointmentsListPageActions.openViewModal();
		AppointmentsLisitngPageActions.patientIdView();
		AppointmentsLisitngPageActions.patientNameView(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.emailIdView(patntAppnmntData.get("email"));
		AppointmentsLisitngPageActions.mobileNumView(patntAppnmntData.get("patient_mobile"));
		AppointmentsLisitngPageActions.clinicNameView(patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.DateOfAppView();
		AppointmentsLisitngPageActions.durationView(patntAppnmntData.get("duration"));
		AppointmentsLisitngPageActions.doctorView(patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.operatoriesView();
		AppointmentsLisitngPageActions.referralView(patntAppnmntData.get("referral"));
		AppointmentsLisitngPageActions.referralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentsLisitngPageActions.sourceView(patntAppnmntData.get("source"));
//      AppointmentsLisitngPageActions.chiefComplaintView(patntAppnmntData.get("chiefComplaint"));
		AppointmentsLisitngPageActions.notesView(patntAppnmntData.get("notes"));
		AppointmentsLisitngPageActions.closeViewModal();
		CommonPageActions.backToDoctorDashbrd();
	}

	@Test(groups = { "Regression", "Functional" }, enabled = true, description = "Delete Appointment", priority = 4)
	public void deleteAppointment() {
		
		BaseClass.openAddAppointmentPage();
		AppointmentAddPageActions.clickOnCancelBtn();
		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.enterToDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.enterFromDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "in-Clinic");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"), patntAppnmntData.get("clinicLocation"));
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
