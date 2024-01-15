package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import utils.ExcelReader;
import utils.TestData;

public class AppointmentListingTestCase extends BaseClass {

	// file used to store input data
	private static final String FILE_PATH = TestData.getInstance()
			.getInputData("appointmentList_eventList_test_data_file_path");
	private static final String SHEET = TestData.getInstance()
			.getInputData("appointmentList_eventList_test_data_sheet_name");;
	// Message here which We will print after excution

	private static final String VERIFY_APPOINTMENT_LIST_HOME_PAGE_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String VERIFY_ALL_ELEMENT_ON_APP_LIST_HP = "2: AppointmentList 1:It verified all element are present";
	private static final String VERIFY_APPOINTMENT_TYPE_FILTER = "2: AppointmentList #52:Appointment type filter has been verified";
	private static final String VERIFY_DOCTOR_FILTER = "2: AppointmentList #53:Doctor filter is working fine After selecting from dropdown";
	private static final String CHECKED_FRM_DATE_IS_BEFORE_AFTER_DATE = "2: AppointmentList #54:Validated from Date is Before After Date";
	private static final String VERIFY_CONFIRM_WITH_CONFIRMED = "2: AppointmentList #57:Confirmed appointment with Edit,View and Delete btn";
	private static final String VERIFY_VIEW_BTN_BEHAVIOUR = "2: AppointmentList #58:Verified Behaviour of view Btn";
	private static final String CLICK_ON_EDIT_AND_VERIFY_PAST_DATE = "2: AppointmentList #59:On past Date it is not allowing.A popup apear time is already passed ";
	private static final String VERIFY_ON_CLICK_DELETE_POP_UP_YES = "2: AppointmentList #61:After clicking Delete popup has benn verified";
	private static final String VERIFY_EDIT_BTN = "2: AppointmentList #65:Verified Behaviour of Edit Btn";
	private static final String DATE_FILTER_ALONG_WITH_APP_TYPE = "2: AppointmentList #5:Date filter working fine with App Type filter";
	private static final String NO_RECORD_FOUND_MSG_VERIFICATION = "2: AppointmentList #67:noRecordFound Message is displayed on no data";

	//
	@BeforeMethod
	public void testSetup() {
		DoctorDashBoardPageActions.openAppointmentListingPage();
	}

	@Test(description = VERIFY_ALL_ELEMENT_ON_APP_LIST_HP, enabled = true, priority = 1)
	public void verifyAllElementOnAppListHp() {
		logger.log(Status.PASS, VERIFY_ALL_ELEMENT_ON_APP_LIST_HP);
		AppointmentsLisitngPageActions.verifiyAppointmentListElements();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_APPOINTMENT_TYPE_FILTER, enabled = true, priority = 2)
	public void verifyAppointmentTypeFilter() {
		logger.log(Status.PASS, VERIFY_APPOINTMENT_TYPE_FILTER);
		// CommonPageActions.selectClinicFrmHeader("Amar Colony");
		AppointmentsLisitngPageActions.selectAppType("Tentative");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.appointmentTypeFilter("Tentative");
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_DOCTOR_FILTER, enabled = true, priority = 3)
	public void verifyDoctorFilter() {
		logger.log(Status.PASS, VERIFY_DOCTOR_FILTER);
		//AppointmentsLisitngPageActions.selectDoctorFRmDrpDwn(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 3)); //changed the method since the element is not dropdown
		AppointmentsLisitngPageActions.selectDoctor(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 3));
		
		AppointmentsLisitngPageActions.doctorTypeFilter(ExcelReader.readExcelData(FILE_PATH, SHEET, 1, 4));
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = CHECKED_FRM_DATE_IS_BEFORE_AFTER_DATE, enabled = true, priority = 4)
	public void checkedFrmDateIsBeforeAfterDate() {
		logger.log(Status.PASS, CHECKED_FRM_DATE_IS_BEFORE_AFTER_DATE);
		AppointmentsLisitngPageActions.checkingFromDateIsBeforeAfterDate(
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 1), ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 2));
		AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 1));
		AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 2));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.dateFilter(ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 1),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 2, 2));
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = DATE_FILTER_ALONG_WITH_APP_TYPE, enabled = true, priority = 5)
	public void dateFilterAlongWithAppType() {
		logger.log(Status.PASS, DATE_FILTER_ALONG_WITH_APP_TYPE);
		AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 1));
		AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 2));
		AppointmentsLisitngPageActions.selectAppType("Tentative");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.appointmentTypeFilter("Tentative");
//		AppointmentsLisitngPageActions.intiateData();
		AppointmentsLisitngPageActions.dateFilter(ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 1),
				ExcelReader.readExcelData(FILE_PATH, SHEET, 3, 2));
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_VIEW_BTN_BEHAVIOUR, enabled = true, priority = 6)
	public void verifyViewBtnBehaviour() {
		logger.log(Status.PASS, VERIFY_VIEW_BTN_BEHAVIOUR);
		AppointmentsLisitngPageActions.verifyBehaviourOfViewBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_CONFIRM_WITH_CONFIRMED, enabled = true, priority = 7)
	public void verifyConfirm() {
		AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 1));
		AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 2));
		AppointmentsLisitngPageActions.selectAppType("Confirmed");
		AppointmentsLisitngPageActions.selectAppStatusType("No-Show");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.verifyConfirmWithNoShow();
		AppointmentsLisitngPageActions.selectAppStatusType("Show");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.confirmWithShow();
		AppointmentsLisitngPageActions.selectAppStatusType("ChkIN");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.confirmWithCheckIn();
		/* Functionality not available
		 * AppointmentsLisitngPageActions.selectAppStatusType("Expired");
		 * AppointmentsLisitngPageActions.clickOnSearchBtn();
		 * AppointmentsLisitngPageActions.confirmWithExpired();
		 */
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_CONFIRM_WITH_CONFIRMED, enabled = true, priority = 8)
	public void verifyConfirmWithConfirmed() {
		logger.log(Status.PASS, VERIFY_CONFIRM_WITH_CONFIRMED);
		AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 1));
		AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 4, 2));
		AppointmentsLisitngPageActions.selectAppType("Confirmed");
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.confirmWithConfirmed();
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = VERIFY_ON_CLICK_DELETE_POP_UP_YES, enabled = true, priority = 10)
	public void editAndDeleteValidated() {
		logger.log(Status.PASS, VERIFY_ON_CLICK_DELETE_POP_UP_YES);
		CommonPageActions.backTODoctorDashboard();
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterPatientName("Dummy test");
		AppointmentAddPageActions.enterMobileNumber("8470833998");
		AppointmentAddPageActions.enterEmailAddress("noemail@clovedental.info");
		AppointmentAddPageActions.selectClinicFromDropdown(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 5));
		//AppointmentAddPageActions.selectDateofAppointment(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 1));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 2));
		AppointmentAddPageActions.selectDoctorFromDropdown(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 3));
		AppointmentAddPageActions.clickOnSaveBtn();
		DoctorDashBoardPageActions.clickOnAppListBtn();
		//CommonPageActions.selectClinicFrmHeader(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 5));
		//AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 1));
		//AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 1));
		AppointmentsLisitngPageActions.selectAppType(ExcelReader.readExcelData(FILE_PATH, SHEET, 7, 4));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickEditButton("Dummy test");
		//AppointmentAddPageActions.selectDateofAppointment(ExcelReader.readExcelData(FILE_PATH, SHEET, 8, 1));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(ExcelReader.readExcelData(FILE_PATH, SHEET, 8, 2));
		AppointmentAddPageActions.clickOnSaveBtn();
		//AppointmentsLisitngPageActions.enterFromDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 8, 1));
		//AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 8, 1));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.verifyAfterEditAtAppList("Dummy test",ExcelReader.readExcelData(FILE_PATH, SHEET, 9, 1));
		AppointmentsLisitngPageActions.clickDeleteButton("Dummy test");
		AppointmentsLisitngPageActions.verifyWebElementDeletePopup();
		AppointmentsLisitngPageActions.clickNoDeletePopup();
		AppointmentsLisitngPageActions.clickDeleteButton("Dummy test");
		AppointmentsLisitngPageActions.clickYesDeletePopup();
		AppointmentsLisitngPageActions.verifyErrorMessage();
		AppointmentsLisitngPageActions.selectReasonDelete();
		AppointmentsLisitngPageActions.clickYesDeletePopup();
		AppointmentsLisitngPageActions.strikeOff("Dummy test");
		Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
	}

	@Test(description = NO_RECORD_FOUND_MSG_VERIFICATION, enabled = true, priority = 11)
	public void noRecordFoundMsgVerification() {
		logger.log(Status.PASS, NO_RECORD_FOUND_MSG_VERIFICATION);
		AppointmentsLisitngPageActions.enterToDate(ExcelReader.readExcelData(FILE_PATH, SHEET, 5, 2));
		AppointmentsLisitngPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.noRecordFoundMsg();
		Assert.assertTrue(AppointmentsLisitngPageActions.verifiyAppListHP());
	}
}
