package tests;

import java.util.Map;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import freemarker.core.ParseException;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import utils.SheetTest;

public class AppointmentAddEConsultTestCase extends BaseClass {

	static AppointmentsLisitngPageActions appointmentsLisitngPageActions = PageFactory.initElements(driver,
			AppointmentsLisitngPageActions.class);

	// Message here which We will print extent execution report after execution
	private static final String APPOINTMENT_SHEDULAR_CALENDER = "Appointment Scheduler Calender";
	// private static final int NO_OF_FUTURE_DAYS = 2;
	private static final String APPOINTMENT_ADD_PAGE = "";
	private static final String APPOINTMENT_E_CONSULT_PAGE = "";
	private static final String MANDATORY_FIELDS = "";
	private static final String BOOK_NEW_APPOINTMENT_E_CONSULT = "";
	private static final String EDIT_APPOINTMENT = "";
	private static final String VERIFY_ALREADY_BOOKED_DOCTOR_SLOT = "";
	private static final String VALIDATE_AUTO_SELECT_PATIENT_FROM_SUGGESTION = "";
	private static final String STATUS_OF_SCRIPTS = "";
	Map<String, String> patntAppnmntData = null;

	@BeforeTest
	public void testSetup() {
		patntAppnmntData = SheetTest.prepareData("Appointment", "PatientAppointment", "A2", "X2");
	}

	@Test(groups = { "Regression" }, enabled = true, description = "Verify Appointment Form Elements", priority = 1)
	public void appointmentEConsultPage() {
		logger.log(Status.PASS, APPOINTMENT_E_CONSULT_PAGE); //

		BaseClass.openAddAppointmentPage();
		AppointmentAddPageActions.selectEConsult();
		AppointmentAddPageActions.checkAppointmenteConsult();
		AppointmentAddPageActions.patientNameTextFields();
		AppointmentAddPageActions.patientMobileTextFields();
		AppointmentAddPageActions.patientIdTextFields();
		AppointmentAddPageActions.patientEmailIdTextFields();
		AppointmentAddPageActions.clinicDrpDwn();
		AppointmentAddPageActions.dateCalender();
		AppointmentAddPageActions.timeSlotDrpDwn();
//      appointmentPageActions.selectingFutureDateAndVerifyStartTime(NO_OF_FUTURE_DAYS);
		AppointmentAddPageActions.timeDurationTextFields();
		AppointmentAddPageActions.doctorDrpDwn();
		AppointmentAddPageActions.operatories();
		AppointmentAddPageActions.rooms();
		AppointmentAddPageActions.sourceDrpDwn();
		AppointmentAddPageActions.referralDrpDwn();
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.notesFields();
		AppointmentAddPageActions.chiefComplaints();
		AppointmentAddPageActions.otherChiefComplaint();
		AppointmentAddPageActions.actionsBtnAppointmentAdd();
		AppointmentAddPageActions.checkSchedulerOptions();
		AppointmentAddPageActions.clickOnGoToSchedulerYesBtn();
		Assert.assertTrue(CommonPageActions.verification().contains(APPOINTMENT_SHEDULAR_CALENDER));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Verify Appointment Mandatory Elements", priority = 2)
	public void mandatoryFields() {

		logger.log(Status.PASS, MANDATORY_FIELDS); // Status
		BaseClass.openAddAppointmentPage();
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.selectEConsult();
		AppointmentAddPageActions.checkAppointmenteConsult();
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
//      appointmentPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterPatientNameMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      appointmentPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterMobileNumber("12345");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      appointmentPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.enterTenDigitMobileNoMsg();
		driver.navigate().refresh();
		AppointmentAddPageActions.enterMobileNumber("0000000000");
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
//      appointmentPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
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
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Smoke", "Regression", "Sanity",
			"Functional" }, enabled = true, description = "Book Appointment For E-Consult", priority = 3)
	public void bookNewAppointmentEConsult() throws ParseException, java.text.ParseException, bsh.ParseException {

		logger.log(Status.PASS, BOOK_NEW_APPOINTMENT_E_CONSULT); // Status
		BaseClass.openAddAppointmentPage();
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.selectEConsult();
		AppointmentAddPageActions.checkAppointmenteConsult();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress(patntAppnmntData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("clinicLocation"));
//      appointmentPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("slot"));
		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("duration"));
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.selectSourceFromDropdown(patntAppnmntData.get("source"));
		AppointmentAddPageActions.selectReferralFromDropdown(patntAppnmntData.get("referral"));
		AppointmentAddPageActions.enterReferralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentAddPageActions.clickOnChiefComplaints(patntAppnmntData.get("chiefComplaint"));
		AppointmentAddPageActions.enterNote(patntAppnmntData.get("notes"));
		AppointmentAddPageActions.clickOnSaveBtn();
		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		CommonPageActions.backToDoctorDashbrd();
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "e-Consult");
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
		AppointmentsLisitngPageActions.roomsViewEconsult();
		AppointmentsLisitngPageActions.referralView(patntAppnmntData.get("referral"));
		AppointmentsLisitngPageActions.referralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentsLisitngPageActions.sourceView(patntAppnmntData.get("source"));
		/* Bug In The Version */
//      appointmentsLisitngPageActions.chiefComplaintView(patntAppnmntData.get("chiefComplaint"));
		AppointmentsLisitngPageActions.notesView(patntAppnmntData.get("notes"));
		AppointmentsLisitngPageActions.closeViewModal();
		AppointmentsLisitngPageActions.clickOnPatient(patntAppnmntData.get("patient_name"));

		// work only on registered patient
		BasePatientLifeCyclePageActions.clickOnAlert();

		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.checkAppointmentTime(patntAppnmntData.get("appointmentDate"),
				patntAppnmntData.get("slot"));
//      AppointmentsListPageActions.chiefComplaint(patntAppnmntData.get("chiefComplaint"));
		AppointmentsListPageActions.type("E-consult");
		AppointmentsListPageActions.appointmentType("Confirmed");
		AppointmentsListPageActions.clinicName(patntAppnmntData.get("clinicLocation"));
		AppointmentsListPageActions.doctorName(patntAppnmntData.get("doctor"));
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression", "Sanity",
			"Functional" }, enabled = true, description = "Edit Appointment For E-Consult", priority = 4)
	public void editAppointment() throws ParseException, java.text.ParseException, bsh.ParseException {

		logger.log(Status.PASS, EDIT_APPOINTMENT); // Status

//		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		BaseClass.openAddAppointmentPage();
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.enterToDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.enterFromDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "e-Consult");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.checkDoctorName(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.viewButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.editButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.deleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.clickEditButton(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.getTextPatientMobile(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.getTextPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.patientIDAfterAutoSelect();
		AppointmentAddPageActions.doctorSelected(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.roomSelected();
		AppointmentAddPageActions.clinicSelected(patntAppnmntData.get("clinicLocation"));
		AppointmentAddPageActions.slotSelected(patntAppnmntData.get("slot"));
		AppointmentAddPageActions.sourceSelected(patntAppnmntData.get("source"));
		AppointmentAddPageActions.referralSelected(patntAppnmntData.get("referral"));
		AppointmentAddPageActions.getReferralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentAddPageActions.getNotes(patntAppnmntData.get("notes"));
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("updateSlot"));
		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("updateSlotDuration"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.verifyAppointmentUpdateText("Appointment updated successfully!");
		AppointmentsLisitngPageActions.clickOnLastPage();
//		AppointmentsLisitngPageActions.verifyAppointmentDateTimeOnListing(patntAppnmntData.get("patient_name"),"27-12-2023", "21:00");
		AppointmentsLisitngPageActions.openViewModal(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("updateSlot"));
		AppointmentsLisitngPageActions.patientNameView(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.emailIdView(patntAppnmntData.get("email"));
		AppointmentsLisitngPageActions.mobileNumView(patntAppnmntData.get("patient_mobile"));
		AppointmentsLisitngPageActions.clinicNameView(patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.DateOfAppView();
		AppointmentsLisitngPageActions.durationView(patntAppnmntData.get("updateSlotDuration"));
		AppointmentsLisitngPageActions.closeViewModal();
		CommonPageActions.backTODoctorDashboard();

	}

	@Test(groups = {
			"Regression" }, enabled = true, description = "Edit Appointment For E-Consult With Invalid duration", priority = 6)
	public void editAppointmentWithInvaidHours() {

		logger.log(Status.PASS, EDIT_APPOINTMENT); // Status
//		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.enterToDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.enterFromDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "e-Consult");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("clinicLocation"));
		AppointmentsLisitngPageActions.checkDoctorName(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("doctor"));
		AppointmentsLisitngPageActions.viewButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.editButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.deleteButton(patntAppnmntData.get("patient_name"));
		AppointmentsLisitngPageActions.clickEditButton(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.getTextPatientMobile(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.getTextPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.patientIDAfterAutoSelect();
		AppointmentAddPageActions.doctorSelected(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.roomSelected();
		AppointmentAddPageActions.clinicSelected(patntAppnmntData.get("clinicLocation"));
		AppointmentAddPageActions.slotSelected(patntAppnmntData.get("updateSlot"));
		AppointmentAddPageActions.sourceSelected(patntAppnmntData.get("source"));
		AppointmentAddPageActions.referralSelected(patntAppnmntData.get("referral"));
		AppointmentAddPageActions.getReferralDetails(patntAppnmntData.get("referalDetails"));
		AppointmentAddPageActions.getNotes(patntAppnmntData.get("notes"));
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("updateSlot"));
//		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("updateSlotDuration")+"0");  commented bcz google sheet not sending inaccurate duration req
		AppointmentAddPageActions.enterTimeDuration("900");

		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.verifyrRestrictAppointmentUpdateText(
				"Requested appointment minute(s) is not available for scheduling!");
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression",
			"Functional" }, enabled = true, description = "Verify Already Booked Slots", priority = 7)
	public void verifyAlreadyBookedDoctorSlot() {

		logger.log(Status.PASS, VERIFY_ALREADY_BOOKED_DOCTOR_SLOT); // Status
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress(patntAppnmntData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(patntAppnmntData.get("clinicLocation"));
//      AppointmentAddPageActions.appointmentDate(patntAppnmntData.get("appointmentDate"));
		AppointmentAddPageActions.enterTimeDuration(patntAppnmntData.get("duration"));
//      appointmentPageActions.checkingFirstOperatoryIsDisable();
		AppointmentAddPageActions.selectDoctorFromDropdown(patntAppnmntData.get("doctor"));
		AppointmentAddPageActions.selectSourceFromDropdown(patntAppnmntData.get("source"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(patntAppnmntData.get("updateSlot"));
		AppointmentAddPageActions.enterNote(patntAppnmntData.get("notes"));
		AppointmentAddPageActions.clickOnSaveBtn();
		AppointmentAddPageActions.pleaseSelectDoctorMsg();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Regression", "Sanity",
			"Functional" }, enabled = true, description = "Verify Auto Selection From Suggestion", priority = 8)
	public void validateAutoSelectPatientFromSuggestion() {

		logger.log(Status.PASS, VALIDATE_AUTO_SELECT_PATIENT_FROM_SUGGESTION); // Status
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.autoSelectMobile(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.getTextPatientMobile(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.getTextPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.patientIDAfterAutoSelect();
		AppointmentAddPageActions.verifyMandatoryFieldsOnEdit();
		AppointmentAddPageActions.clickOnAppResetBtn();
		AppointmentAddPageActions.autoSelectPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.getTextPatientMobile(patntAppnmntData.get("patient_mobile"));
		AppointmentAddPageActions.getTextPatientName(patntAppnmntData.get("patient_name"));
		AppointmentAddPageActions.patientIDAfterAutoSelect();
		AppointmentAddPageActions.verifyMandatoryFieldsOnEdit();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment"));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(groups = { "Smoke", "Regression", "Sanity",
			"Functional" }, enabled = true, description = "Verify Appointment Deletion", priority = 9)
	public void deleteAppointment() {
//		CommonPageActions.selectClinicFrmHeader(patntAppnmntData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickOnAppListBtn();

		AppointmentsLisitngPageActions.enterToDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.enterFromDate(patntAppnmntData.get("appointmentDate"));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();
		AppointmentsLisitngPageActions.appointmentStatus(patntAppnmntData.get("patient_name"), "New");
		AppointmentsLisitngPageActions.appointmentType(patntAppnmntData.get("patient_name"), "Confirmed");
		AppointmentsLisitngPageActions.type(patntAppnmntData.get("patient_name"), "e-Consult");
		AppointmentsLisitngPageActions.verifyClinic(patntAppnmntData.get("patient_name"),
				patntAppnmntData.get("clinicLocation"));
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
