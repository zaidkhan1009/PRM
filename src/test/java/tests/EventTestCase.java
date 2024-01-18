package tests;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import utils.SheetTest;
import utils.TestData;
import bsh.ParseException;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.EventListingPageActions;
import pageActions.doctorDashboard.EventPageActions;
import pages.doctorDashboard.DoctorDashBoardPage;

public class EventTestCase extends BaseClass {

	private static final String INCILINIC_FACILITY = TestData.getInstance().getInputData("event_inclinic_facility");
	private static final String ECONSULT_FACILITY = TestData.getInstance().getInputData("event_econsult_facility");
	private static final String SCANNER_FACILITY = TestData.getInstance().getInputData("event_scanner_facility");

	/*
	 * Page Url of Add Event,Edit Event ,DoctorDashboard and Event Listing
	 */
	private static final String ADD_EVENT_PAGE_TITLE = "Add Appointment/Event";
	private static final String DOCTOR_DASHBOARD_PAGE_TITLE = "Doctor Dashboard";
	private static final String EVENTLISTING_PAGE_TITLE = "Appointment/Event Listing";

	/*
	 * // Message here which We will print extent execution report after execution
	 *
	 */
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String VERIFY_ALL_WEB_ELEMENT_ON_EVENT_ADD = "EventAdd #:Verifying all Mandatory WebElements in By Doctor,By Operatory ,By Room and By Scanner are present on event Add";
	private static final String CHECKING_WITHOUT_MANDATORY_FIELDS = "EventAdd  #Verifying all error Msg shown when mandatory field are not filled on Add Event ";
	private static final String VERIFY_VALIDATION_FOR_EVENT_TIME_FIELDS = "# Verifying Validation on Hours,Minutes and Duration field";
	private static final String VERIFY_BY_DOCTOR_EVENT = "#1 Add ByDoctor Event #2: Verify Event Details on  the Event Listing home page #3: check on Add Appoinment Doctor Name is coming disable in Doctor Dropdown";
	private static final String VERIFY_BY_OPERATORY_EVENT = "#1: Add ByOperatory Event #Verify Event Details on the Event Listing home Page #3: check on Add Appointment page event Added Operatory is disabled";
	private static final String VERIFY_BY_ROOM_EVENT = "#1: Add ByRoom Event #2: Verify Event Details on the Event Listing home Page #3: check on Add Appointment page event Added Room is disbaled";
	private static final String VERIFY_BY_SCANNER_EVENT = "#1: Add ByScanner Event #2 Verify Event Details on the Event Listing hoome Page #3: check on Add Appointment page event Added Scanner is disabled";
	private static final String VERIFY_BY_DOCTOR_EVENT_UPDATE = "Verify Updating Single Doctor Event to  All Doctors event and checking Add Appointment update event time slot is disabled for all doctor and previous time slot is available now.";
	private static final String VERIFY_BY_DOCTOR_EVENT_DELETED = "Verify Deleting By Doctor Event and checking doctor is available after event deleted";
	private static final String VERIFY_ADD_EVENT_FOR_ALREADY_BOOKED_APPOINTMENT_TIME = "Verify Booking event for the same time for which already a booked appointment is present";
	private static final String VERIFY_BY_OPERATORY_EVENT_UPDATE = "Verify Updating By Operatory Event and checking Add Appointment update event time slot is disabled for operatory and for previous time slot operatory is available now.";
	private static final String VERIFY_BY_OPERATORY_EVENT_DELETED = "Verify Deleting By Operatory Event and checking operatory is available after event deleted";
	private static final String VERIFY_BY_ROOM_EVENT_UPDATE = "Verify Updating Room Event and checking on Add Appointment room is disabled for update event time slot and room is available on previous time slot.";
	private static final String VERIFY_BY_ROOM_EVENT_DELETED = "Verify Delete By Room event and checking on add appointment room is available after event deleted";
	private static final String VERIFY_BY_SCANNER_EVENT_UPDATE = "Verify Updating Single Doctor Event to  All Doctors event and checking Add Appointment update event time slot is disabled for all doctor and previous time slot is available now.";
	private static final String VERIFY_BY_SCANNER_EVENT_DELETED = "Verify Delete By Scanner event and checking on add appointment scanner is available after event deleted";
	private static final String VERIFY_DOC_IF_ALREADY_EVENT_ON_SAME_TIME = "1: EventAdd #Doctor has aleady an event added for the same time verified";
	private static final String EVENT_TIME__ALREADY_PASSED = "1: EventAdd # Event Time Alreay Passed";
	private static final String VERIFY_RESET_BTN = "1: EventAdd #9:Reset Btn is working fine";
	private static final String VERIFY_CANCEL_BTN = "1: EventAdd #10:Cancel Btn is working fine";
	private static final String VERIFY_ADDING_EVENT_ON_LAST_AVAILABLE_OPERATORY = ":1 Verify Event cannot be added  on Last available  Operatory";
	private static final String VERIFY_ADDING_EVENT_ON_LAST_AVAILABLE_SCANNER = "Verify Event cannot be added on Last available Scanner";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed here@@";
	private static final String VERIFY_ADDING_EVENT_FOR_A_SLOT_FOR_WHICH_TENTATIVE_APPT_ALREADY_BOOKED = "Verifying add event for same time slot for which tentative appointment is present";
	// -------------------------Event listing Msg------------------------------
	private static final String VERIFY_ELEMENT_ON_EVENT_LIST = "2: Event Listing #71:All  WebElement are present on event listing home page";
	private static final String VERIFY_ADD_EVENT_FROM_EVENT_LISTING = "2: Event Listing #72:Verify Event Add redirection from Event Listing # Verify redirection to event listing after event save ";
	private static final String VERIFY_FRM_AND_TO_DATE_FILTER = "2: Event Listing #75:All event date is b/w frm and to date";
	private static final String CHECK_FRM_DATE_IS_NOT_LATER_TO_TO_DATE = "2: Event Listing #76:frm Date is not later than to Date";
	private static final String VERIFY_DOCTOR_FILTER_ON_EVENT_LIST = "2: Event Listing #77:Doctor filter is working fine";
	private static final String VERIFY_FILTER_OF_CATEGORY_TYPE = "2: Event Listing #78:Category filter is working fine";
	private static final String VERIFY_EVENT_TYPE_FILTER_ON_EVENT_LIST = "2: Event Listing #79:Event Type filter is working fine";
	private static final String VERIFY_RESET_BUTTON_FUNCTIONALITY_ON_EVENT_LISTING = "2: Verify Reset Button woking on Event Listing";

	/*
	 * Google Sheet Name where data is present
	 */
	private final String MODULE_NAME = "Event";
	private final String TEST_DATA_SHEET_NAME = "EventTestData";

	/*
	 * Google Sheet Test Data in Map
	 */
	private Map<String, String> addDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A2",
			"O2");
	private Map<String, String> updateDoctorEventTestData = null;
	private Map<String, String> addOperatoryEventTestData = null;
	private Map<String, String> updateOperatoryEventTestData = null;
	private Map<String, String> addRoomEventTestData = null;
	private Map<String, String> updateRoomEventTestData = null;
	private Map<String, String> addScannerRoomEvent = null;
	private Map<String, String> updateScannerRoomEvent = null;
	private Map<String, String> confirmedAppointmentTestData = null;
	private Map<String, String> tentativeAppointmentTestData = null;

	/*
	 * Verify Title Duration,Date,Clinic and Notes field on Add Event Verify default
	 * Event Type and Date selected on Add Event Verify Event Type according to
	 * clinic Supported Consultation Type Verify Doctor,Operatory,Room,Scanner
	 * DropDown in By Doctor,By Operatory ,By Room and By Scanner Event
	 */

	@Test(groups = { "Smoke", "Sanity", "Functional", "Regression" }, description = VERIFY_ALL_WEB_ELEMENT_ON_EVENT_ADD)
	public void verifyAllWebElementOnEventAdd() {
		logger.log(Status.PASS, VERIFY_ALL_WEB_ELEMENT_ON_EVENT_ADD);
		CommonPageActions.selectClinicFrmHeader(INCILINIC_FACILITY);
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.verifyDefaultSelectedEventType();
		EventPageActions.verifySelectedDateInEvent(EventPageActions.getCurrentDate());
		EventPageActions.verifyDefaultSelectedClinic(INCILINIC_FACILITY);
		EventPageActions.verifyAllMandatoryWebElementOnByDoctorEvent();
		EventPageActions.selectClinicInEvent(INCILINIC_FACILITY);
		EventPageActions.verifyAllMandatoryWebElementOnByOperatoryEvent();
		EventPageActions.selectClinicInEvent(ECONSULT_FACILITY);
		EventPageActions.verifyAllMandatoryWebElementOnByRoomEvent();
		EventPageActions.selectClinicInEvent(SCANNER_FACILITY);
		// commenting below code since the functionality has been removed
//		EventPageActions.verifyAllMandatoryWebElementOnByScannerEvent();
//		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);
	}

	/*
	 * Verify all Error Message shown on Add Event when Mandatory field are not
	 * filled with data.
	 */

	@Test(groups = { "Sanity", "Functional", "Regression" }, description = CHECKING_WITHOUT_MANDATORY_FIELDS)
	public void checkingWithoutMandatoryFields() {
		logger.log(Status.INFO, CHECKING_WITHOUT_MANDATORY_FIELDS);
		CommonPageActions.selectClinicFrmHeader(INCILINIC_FACILITY);
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.clickOnEventSaveBtn();

		EventPageActions.enterTittleErrorMsg();
		EventPageActions.verifyDefaultSelectedOptionInDoctorDrpDwn();
		EventPageActions.selectDoctorErrorMsg();
		EventPageActions.verifyDefaultSelectedOptionInCategoryDrpDwn();
		EventPageActions.selectCategoryErrorMsg();
		EventPageActions.eventDurationErrorMsg();

		EventPageActions.selectOperatoryErrorMsg();
		EventPageActions.enterTittleErrorMsg();
		EventPageActions.verifyDefaultSelectedOptionInOperatoryDrpDwn();
		EventPageActions.verifyDefaultSelectedOptionInCategoryDrpDwn();
		EventPageActions.selectCategoryErrorMsg();
		EventPageActions.eventDurationErrorMsg();

		EventPageActions.selectClinicInEvent(ECONSULT_FACILITY);
		EventPageActions.selectRoomErrorMsg();
		EventPageActions.enterTittleErrorMsg();
		EventPageActions.verifyDefaultSelectedOptionInRoomDrpDwn();
		EventPageActions.verifyDefaultSelectedOptionInCategoryDrpDwn();
		EventPageActions.selectCategoryErrorMsg();
		EventPageActions.eventDurationErrorMsg();

		EventPageActions.selectClinicInEvent(SCANNER_FACILITY);
//		Commenting the below line since the functionality is not available anymore
//		EventPageActions.selectScannerErrorMsg();
		EventPageActions.enterTittleErrorMsg();
//		Commenting the below line since the functionality is not available anymore
//		EventPageActions.verifyDefaultSelectedOptionInScannerDrpDown();
		EventPageActions.verifyDefaultSelectedOptionInCategoryDrpDwn();
		EventPageActions.selectCategoryErrorMsg();
		EventPageActions.eventDurationErrorMsg();
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);

	}

	/*
	 * Verify the validation on Hours field should be b/w 1-12 Verify the validation
	 * on Minutes field should be b/w 0-59 Verify the validation on Duration field
	 * should be less minute left in current day. Verify validation event duration
	 * cannot be zero
	 */

	@Test(groups = { "Sanity", "Functional", "Regression" }, description = VERIFY_VALIDATION_FOR_EVENT_TIME_FIELDS)
	public void verifyHoursMinsutesAndDurationValidation() {
		logger.log(Status.PASS, VERIFY_VALIDATION_FOR_EVENT_TIME_FIELDS);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		/*
		 * verify when full day event CheckBox is checked then Hours,Minutes,AM/PM and
		 * Duration fields is disabled
		 */
		EventPageActions.behaviourOfEventType();
		EventPageActions.clickOnEventResetBtn();

		EventPageActions.enterHours("30");
		BaseClass.pressTabKey(driver);
		EventPageActions.verifyInvalidHoursErrorMsg();
		EventPageActions.clickOnEventResetBtn();

		EventPageActions.enterMinutes("72");
		BaseClass.pressTabKey(driver);
		EventPageActions.verifyInvalidMintuesErrorMsg();
		EventPageActions.clickOnEventResetBtn();

		EventPageActions.enterTitleName(addDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(addDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addDoctorEventTestData.get("event_Date"));
		EventPageActions.enterHours("3");
		EventPageActions.enterMinutes("40");
		EventPageActions.selectAmPm("PM");
		EventPageActions.enterEventDuration("00");
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyDurationCannotBeZeroErrorMsg();
		EventPageActions.clearEventDuration();
		EventPageActions.enterEventDuration("3000");
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyDurationMoreThanAvailableMinErrorMsg();
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);

	}

	/*
	 * Adding By Doctor Event and then verify added Event on Event Listing Checking
	 * on Add Appointment Page Event Added Doctor is Non-Selected in DropDown for
	 * the Event Duration
	 */
	@Test(groups = { "Smoke", "Sanity", "Functional", "Regression" }, description = VERIFY_BY_DOCTOR_EVENT)
	public void verifyAddingByDoctorEvent() {
		logger.log(Status.INFO, VERIFY_BY_DOCTOR_EVENT);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName(addDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(addDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addDoctorEventTestData.get("event_Date"));
		EventPageActions.enterHours(addDoctorEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(addDoctorEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(addDoctorEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(addDoctorEventTestData.get("event_duration"));
		EventPageActions.enterNotes(addDoctorEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
//		EventPageActions.verifyEventAddSuccessMsg();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectDoctor(addDoctorEventTestData.get("event_On"));
		EventListingPageActions.selectFrmdateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectType(addDoctorEventTestData.get("event_Type"));
		EventListingPageActions.selectCategroy(addDoctorEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(addDoctorEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(addDoctorEventTestData.get("event_Title"), "Doctor");
		EventListingPageActions.verifyCategoryDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("doctor_nickName"));
		EventListingPageActions.verifyClinicDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(addDoctorEventTestData.get("event_Title"),
				addDoctorEventTestData.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(addDoctorEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();

		// Since the doctor is not enabled so new method has been implemented.
		// Commenting below line of code
		// EventPageActions.checkEventAddedDoctorIsDisable(addDoctorEventTestData.get("event_On"),addDoctorEventTestData.get("event_Date"),addDoctorEventTestData.get("event_duration"),addDoctorEventTestData.get("appointmentTimeSlot"));
		EventPageActions.checkEventAddedDoctorIsUnavailable(addDoctorEventTestData.get("event_On"),
				addDoctorEventTestData.get("event_Date"), addDoctorEventTestData.get("event_duration"),
				addDoctorEventTestData.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * Verify Adding Event for Doctor for same Time for which doctor is already
	 ** having a Event
	 */
	@Test(groups = { "Functional", "Regression" }, description = VERIFY_DOC_IF_ALREADY_EVENT_ON_SAME_TIME)
//			,dependsOnMethods = "verifyAddingByDoctorEvent")
	public void verifyDocEventIfAlreadyEventOnSameTime() {
		logger.log(Status.INFO, VERIFY_DOC_IF_ALREADY_EVENT_ON_SAME_TIME);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName(addDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(addDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addDoctorEventTestData.get("event_Date"));
		EventPageActions.enterHours(addDoctorEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(addDoctorEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(addDoctorEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(addDoctorEventTestData.get("event_duration"));
		EventPageActions.enterNotes(addDoctorEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyEventAlreadyBookedForSlotErrorMsg();
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);
	}

	/*
	 * Verify Updating Single Doctor Event to All Doctors event and then verifying
	 * the update event details on Event listing Checking on Add Appointment update
	 * event added time slot is disabled for all doctor and previous time slot is
	 * available now.
	 */
	@Test(groups = { "Sanity", "Functional", "Regression" }, description = VERIFY_BY_DOCTOR_EVENT_UPDATE)
	// , dependsOnMethods = "verifyAddingByDoctorEvent")
	public void verifyUpdateDoctorEvent() {
		updateDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A3", "O3");
		logger.log(Status.INFO, VERIFY_BY_DOCTOR_EVENT_UPDATE);

		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectCategroy(addDoctorEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.clickOnEditBtn(addDoctorEventTestData.get("event_Title"));
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);

		EventPageActions.verifyEnteredEventTitleInEdit(addDoctorEventTestData.get("event_Title"));
		EventPageActions.verifySelectedDateInEvent(addDoctorEventTestData.get("event_Date"));
		EventPageActions.verifySelectedClinicInEdit(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.verifySelectedDoctorInEdit(addDoctorEventTestData.get("event_On"));
		EventPageActions.verifySelectedCategoryInEdit(addDoctorEventTestData.get("category"));
		EventPageActions.verifyFullDayEventCheckboxInEdit();
		EventPageActions.enterTitleName(updateDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(updateDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(updateDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(updateDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(updateDoctorEventTestData.get("event_Date"));
		EventPageActions.enterHours(updateDoctorEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(updateDoctorEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(updateDoctorEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(updateDoctorEventTestData.get("event_duration"));
		EventPageActions.enterNotes(updateDoctorEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();

		CommonPageActions.selectClinicFrmHeader(updateDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(updateDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(updateDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectCategroy(updateDoctorEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				"Doctor");
		EventListingPageActions.verifyCategoryDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("doctor_nickName"));
		EventListingPageActions.verifyClinicDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(updateDoctorEventTestData.get("event_Title"),
				updateDoctorEventTestData.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(updateDoctorEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		/*
		 * in method checkDoctorIsSelectableInAddAppointmentDoctorDropdown we are
		 * checking the date/time for which initially Event added before edit is now
		 * free from event
		 */
		EventPageActions.checkDoctorIsSelectableInAddAppointmentDoctorDropdown(addDoctorEventTestData.get("event_On"),
				addDoctorEventTestData.get("event_Date"), addDoctorEventTestData.get("event_duration"),
				addDoctorEventTestData.get("appointmentTimeSlot"));
		/*
		 * in checkEventAddedDoctorIsDisable we are checking the event is added for
		 * updated date/time after edit
		 */
		EventPageActions.checkTimeSlotIsDisableOnAddAppt(updateDoctorEventTestData.get("event_Date"),
				updateDoctorEventTestData.get("appointmentTimeSlot"), updateDoctorEventTestData.get("event_duration"));

		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);

	}

	/*
	 * Deleting a By Doctor Event Verify Deleted Event record is strike off on Event
	 * Listing Checking on Add Appointment doctor is available after event deleted.
	 */
	@Test(groups = { "Functional", "Regression" }, description = VERIFY_BY_DOCTOR_EVENT_DELETED)
	// , dependsOnMethods = "verifyUpdateDoctorEvent")
	public void verifyDeleteDoctorEvent() {
		updateDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A3", "O3");
		logger.log(Status.PASS, VERIFY_BY_DOCTOR_EVENT_DELETED);
		CommonPageActions.selectClinicFrmHeader(updateDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(updateDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(updateDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectType(updateDoctorEventTestData.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyEditAndDeletBtn(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnNoBtnDeletePopUp(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnYesBtnDeletePopUp();
//		EventPageActions.verifyEventDeleteSuccessMsg ();
		EventListingPageActions.verifyAfterDelete(updateDoctorEventTestData.get("event_Title"));
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		/*
		 * *checking after doctor event is deleted ,date/time for which doctor event is
		 * added is now available
		 */
		EventPageActions.checkTimeSlotIsSelectableOnAddAppt(updateDoctorEventTestData.get("event_Date"),
				updateDoctorEventTestData.get("appointmentTimeSlot"), addDoctorEventTestData.get("event_duration"));

		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);

	}

	/*
	 * Adding a In-clinic confirmed appointment for a doctor then adding a Doctor
	 * event for the same time for which appointment is already booked Verify the
	 * error message on event save.
	 *
	 */
	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_ADD_EVENT_FOR_ALREADY_BOOKED_APPOINTMENT_TIME, priority = 1)
	public void verifyAddEventIfAppointmentAlreadyBookedForTime() throws ParseException, java.text.ParseException {
		confirmedAppointmentTestData = SheetTest.prepareData("Appointment", "PatientAppointment", "A8", "X8");
		logger.log(Status.INFO, VERIFY_ADD_EVENT_FOR_ALREADY_BOOKED_APPOINTMENT_TIME);
		CommonPageActions.selectClinicFrmHeader(confirmedAppointmentTestData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.selectInClinic();
		AppointmentAddPageActions.enterPatientName(confirmedAppointmentTestData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(confirmedAppointmentTestData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress(confirmedAppointmentTestData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(confirmedAppointmentTestData.get("clinicLocation"));
		AppointmentAddPageActions.appointmentDate(confirmedAppointmentTestData.get("appointmentDate"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(confirmedAppointmentTestData.get("slot"));
		AppointmentAddPageActions.enterTimeDuration(confirmedAppointmentTestData.get("duration"));
		AppointmentAddPageActions.selectDoctorFromDropdown(confirmedAppointmentTestData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Doctor");
		AppointmentAddPageActions.clickOnSaveBtn();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);

		CommonPageActions.selectClinicFrmHeader(confirmedAppointmentTestData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName("Doctor Having Appointment already for slot");
		EventPageActions.selectClinicInEvent(confirmedAppointmentTestData.get("clinicLocation"));
		EventPageActions.selectDoctorInEvent(confirmedAppointmentTestData.get("doctor"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(confirmedAppointmentTestData.get("appointmentDate"));
		EventPageActions.enterHours(
				BaseClass.convert24HourFormatTo12HourFormat(confirmedAppointmentTestData.get("slot")).split(":")[0]);
		EventPageActions.enterMinutes(
				BaseClass.convert24HourFormatTo12HourFormat(confirmedAppointmentTestData.get("slot")).split(":")[1]);
		EventPageActions.selectAmPm(
				BaseClass.convert24HourFormatTo12HourFormat(confirmedAppointmentTestData.get("slot")).split(" ")[1]
						.toUpperCase());
		EventPageActions.enterEventDuration(confirmedAppointmentTestData.get("duration"));
		EventPageActions.enterNotes(addDoctorEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyEventAlreadyBookedForSlotErrorMsg();

	}

	/*
	 * Verify Adding By Operatory Event for Full Day then verify event details on
	 * event listing Check event added Operatory is Non Selectable on Add
	 * Appointment Page.
	 */
	@Test(groups = { "Sanity", "Functional", "Regression" }, description = VERIFY_BY_OPERATORY_EVENT)
	public void verifyByOperatoryEvent() {
		addOperatoryEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A6", "O6");
		logger.log(Status.INFO, VERIFY_BY_OPERATORY_EVENT);
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.selectClinicInEvent(addOperatoryEventTestData.get("event_Clinic"));
		EventPageActions.selectByOperatoryEvent();
		EventPageActions.enterTitleName(addOperatoryEventTestData.get("event_Title"));
		EventPageActions.selectOperatory(addOperatoryEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addOperatoryEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterNotes(addOperatoryEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn(); //
		EventPageActions.verifyEventAddSuccessMsg();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectType(addOperatoryEventTestData.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(addOperatoryEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(addOperatoryEventTestData.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(addOperatoryEventTestData.get("event_Title"),
				addOperatoryEventTestData.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(addOperatoryEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkEventAddedOperatoryIsDisable(addOperatoryEventTestData.get("event_On"),
				addOperatoryEventTestData.get("event_Date"), addOperatoryEventTestData.get("event_duration"),
				addOperatoryEventTestData.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();
		BaseClass.softAssert().assertAll();
	}

	/*
	 * Verify event cannot be added to last available Operatory in clinic Assuming
	 * that only two Operatories is available in clinic,event will be added on first
	 * Operatories by above @test
	 *
	 */
	@Test(groups = { "Functional", "Regression" }, description = VERIFY_ADDING_EVENT_ON_LAST_AVAILABLE_OPERATORY)
	// , dependsOnMethods = "verifyByOperatoryEvent")
	public void verifyAddingEventOnLastOpearatoryAvailable() {
		addOperatoryEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A6", "O6");
		logger.log(Status.INFO, VERIFY_ADDING_EVENT_ON_LAST_AVAILABLE_OPERATORY);
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.selectByOperatoryEvent();
		EventPageActions.enterTitleName(addOperatoryEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addOperatoryEventTestData.get("event_Clinic"));
		EventPageActions.selectOperatory("Operatory 2");
		EventPageActions.selectEventCategory(addOperatoryEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterNotes(addOperatoryEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyErrorOnAddingEventOnLastAvailableOperatory();
		Assert.assertTrue(CommonPageActions.verification().contains(ADD_EVENT_PAGE_TITLE));
		CommonPageActions.backTODoctorDashboard();

	}

	/*
	 * Updating By Operatory Event and then checking on event listing Checking on
	 * Add Appointment page for the Updated date/time operatory is not available
	 * Checking on Add Appointment Operatory is available for date/time for which
	 * event was added before update.
	 */
	@Test(groups = { "Functional", "Regression" }, description = VERIFY_BY_OPERATORY_EVENT_UPDATE)
	// , dependsOnMethods = "verifyByOperatoryEvent")
	public void verifyUpdateByOperatoryEvent() {
		addOperatoryEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A6", "O6");
		updateOperatoryEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A7", "O7");
		logger.log(Status.PASS, VERIFY_BY_OPERATORY_EVENT_UPDATE);
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectType(addOperatoryEventTestData.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.clickOnEditBtn(addOperatoryEventTestData.get("event_Title"));
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);

		EventPageActions.verifyEnteredEventTitleInEdit(addOperatoryEventTestData.get("event_Title"));
		EventPageActions.verifySelectedDateInEvent(addOperatoryEventTestData.get("event_Date"));
		EventPageActions.verifySelectedClinicInEdit(addOperatoryEventTestData.get("event_Clinic"));
		EventPageActions.verifySelectedOperatoryInEdit(addOperatoryEventTestData.get("event_On"));
		EventPageActions.verifySelectedCategoryInEdit(addOperatoryEventTestData.get("category"));
		EventPageActions.verifyFullDayEventCheckboxInEdit();

		EventPageActions.enterTitleName(updateOperatoryEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(updateOperatoryEventTestData.get("event_Clinic"));
		EventPageActions.selectOperatory(updateOperatoryEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(updateOperatoryEventTestData.get("category"));
		EventPageActions.selectDateInEvent(updateOperatoryEventTestData.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterHours(updateOperatoryEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(updateOperatoryEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(updateOperatoryEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(updateOperatoryEventTestData.get("event_duration"));
		EventPageActions.enterNotes(updateOperatoryEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
////		EventPageActions.verifyEventUpdatedSuccessMsg ();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(updateOperatoryEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(updateOperatoryEventTestData.get("event_Title"),
				updateOperatoryEventTestData.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(updateOperatoryEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(addOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkOperatoryIsSelectableInAddAppt(addOperatoryEventTestData.get("event_On"),
				addOperatoryEventTestData.get("event_Date"), addOperatoryEventTestData.get("event_duration"),
				addOperatoryEventTestData.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkEventAddedOperatoryIsDisable(updateOperatoryEventTestData.get("event_On"),
				updateOperatoryEventTestData.get("event_Date"), updateOperatoryEventTestData.get("event_duration"),
				updateOperatoryEventTestData.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();

	}

	@Test(groups = { "Functional", "Regression" }, description = VERIFY_BY_OPERATORY_EVENT_DELETED)
	// , dependsOnMethods = "verifyUpdateByOperatoryEvent")
	public void verifyDeleteByOperatoryEvent() {
		updateOperatoryEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A7", "O7");
		updateDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A3", "O3");
		logger.log(Status.INFO, VERIFY_BY_OPERATORY_EVENT_DELETED);
		CommonPageActions.selectClinicFrmHeader(updateOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(updateOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(updateOperatoryEventTestData.get("event_Date"));
		EventListingPageActions.selectType(updateOperatoryEventTestData.get("event_Type"));
		EventListingPageActions.selectCategroy(updateOperatoryEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyEditAndDeletBtn(updateOperatoryEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateOperatoryEventTestData.get("event_Title"));
		EventListingPageActions.clickOnNoBtnDeletePopUp(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateOperatoryEventTestData.get("event_Title"));
		EventListingPageActions.clickOnYesBtnDeletePopUp();
//		EventPageActions.verifyEventDeleteSuccessMsg ();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		EventListingPageActions.verifyAfterDelete(updateOperatoryEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateOperatoryEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkOperatoryIsSelectableInAddAppt(updateOperatoryEventTestData.get("event_On"),
				updateOperatoryEventTestData.get("event_Date"), updateOperatoryEventTestData.get("event_duration"),
				updateOperatoryEventTestData.get("appointmentTimeSlot"));

	}

	/*
	 * Verify tentative appointment is present then user can add event for same time
	 * slot tentative appointment.
	 */
	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_ADDING_EVENT_FOR_A_SLOT_FOR_WHICH_TENTATIVE_APPT_ALREADY_BOOKED)
	public void verifyAddEventIfTentativeAppointmentAlreadyBookedForTime()
			throws ParseException, java.text.ParseException {
		addDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A2", "O2");
		tentativeAppointmentTestData = SheetTest.prepareData("Appointment", "PatientAppointment", "A8", "X8");
		logger.log(Status.PASS, VERIFY_ADDING_EVENT_FOR_A_SLOT_FOR_WHICH_TENTATIVE_APPT_ALREADY_BOOKED);

		CommonPageActions.selectClinicFrmHeader(tentativeAppointmentTestData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		AppointmentAddPageActions.checkAppointmentInClinic();
		AppointmentAddPageActions.selectInClinic();
		AppointmentAddPageActions.enterPatientName(tentativeAppointmentTestData.get("patient_name"));
		AppointmentAddPageActions.enterMobileNumber(tentativeAppointmentTestData.get("patient_mobile"));
		AppointmentAddPageActions.enterEmailAddress(tentativeAppointmentTestData.get("email"));
		AppointmentAddPageActions.selectClinicFromDropdown(tentativeAppointmentTestData.get("clinicLocation"));
		AppointmentAddPageActions.appointmentDate(tentativeAppointmentTestData.get("appointmentDate"));
		AppointmentAddPageActions.selectTimeSlotFromDropdown(tentativeAppointmentTestData.get("slot"));
		AppointmentAddPageActions.enterTimeDuration(tentativeAppointmentTestData.get("duration"));
		AppointmentAddPageActions.clickOnTentative();
		AppointmentAddPageActions.selectDoctorFromDropdown(tentativeAppointmentTestData.get("doctor"));
		AppointmentAddPageActions.selectReferralFromDropdown("Doctor");
		AppointmentAddPageActions.clickOnSaveBtn();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);

		CommonPageActions.selectClinicFrmHeader(tentativeAppointmentTestData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName("Tentative Appointment booked for given slot");
		EventPageActions.selectClinicInEvent(tentativeAppointmentTestData.get("clinicLocation"));
		EventPageActions.selectDoctorInEvent(tentativeAppointmentTestData.get("doctor"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(tentativeAppointmentTestData.get("appointmentDate"));
		EventPageActions.enterHours(
				BaseClass.convert24HourFormatTo12HourFormat(tentativeAppointmentTestData.get("slot")).split(":")[0]);
		EventPageActions.enterMinutes(
				BaseClass.convert24HourFormatTo12HourFormat(tentativeAppointmentTestData.get("slot")).split(":")[1]);
		EventPageActions.selectAmPm(
				BaseClass.convert24HourFormatTo12HourFormat(tentativeAppointmentTestData.get("slot")).split(" ")[1]
						.toUpperCase());
		EventPageActions.enterEventDuration(tentativeAppointmentTestData.get("duration"));
		EventPageActions.enterNotes(tentativeAppointmentTestData.get("notes"));
		EventPageActions.clickOnEventSaveBtn();
//		EventPageActions.verifyEventAddSuccessMsg ();
		CommonPageActions.selectClinicFrmHeader(tentativeAppointmentTestData.get("clinicLocation"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkEventAddedDoctorIsDisable(tentativeAppointmentTestData.get("doctor"),
				tentativeAppointmentTestData.get("appointmentDate"), tentativeAppointmentTestData.get("duration"),
				tentativeAppointmentTestData.get("slot"));
		CommonPageActions.backTODoctorDashboard();

	}

	/*
	 * Verify Adding By Room Event Verify the event details on Event Check event
	 * added Room is non selectable on Add Appointment page
	 */

	@Test(groups = { "Sanity", "Functional", "Regression" }, description = VERIFY_BY_ROOM_EVENT)
	public void verifyByRoomEvent() {
		addRoomEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A10", "O10");
		logger.log(Status.PASS, VERIFY_BY_ROOM_EVENT);

		CommonPageActions.selectClinicFrmHeader(addRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.selectClinicInEvent(addRoomEventTestData.get("event_Clinic"));
		EventPageActions.selectByRoomEvent();
		EventPageActions.enterTitleName(addRoomEventTestData.get("event_Title"));
		EventPageActions.selectRoom(addRoomEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addRoomEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addRoomEventTestData.get("event_Date"));
		EventPageActions.enterHours(addRoomEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(addRoomEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(addRoomEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(addRoomEventTestData.get("event_duration"));
		EventPageActions.enterNotes(addRoomEventTestData.get("event_DateTime"));
		EventPageActions.clickOnEventSaveBtn(); //
		EventPageActions.verifyEventAddSuccessMsg();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);
		CommonPageActions.selectClinicFrmHeader(addRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectType(addRoomEventTestData.get("event_Type"));
		EventListingPageActions.selectCategroy(addRoomEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(addRoomEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(addRoomEventTestData.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(addRoomEventTestData.get("event_Title"),
				addRoomEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyEditAndDeletBtn(addRoomEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();

		CommonPageActions.selectClinicFrmHeader(addRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterMobileNumber("1112211111");
		AppointmentAddPageActions.selectEConsult();
		EventPageActions.checkRoomIsDisableOnAddAppointment(addRoomEventTestData.get("event_On"),
				addRoomEventTestData.get("event_Date"), addRoomEventTestData.get("event_duration"),
				addRoomEventTestData.get("appointmentTimeSlot"));

		BaseClass.softAssert().assertAll();

	}

	@Test(groups = { "Functional", "Regression" }, description = VERIFY_BY_ROOM_EVENT_UPDATE)
	// , dependsOnMethods = "verifyByRoomEvent")
	public void verifyUpdateByRoomEvent() {
		addRoomEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A10", "O10");
		updateRoomEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A11", "O11");
		logger.log(Status.PASS, VERIFY_BY_ROOM_EVENT_UPDATE);

		CommonPageActions.selectClinicFrmHeader(addRoomEventTestData.get("event_Clinic"));

		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectType(addRoomEventTestData.get("event_Type"));
		EventListingPageActions.selectCategroy(addRoomEventTestData.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.clickOnEditBtn(addRoomEventTestData.get("event_Title"));
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);

		EventPageActions.verifyEnteredEventTitleInEdit(addRoomEventTestData.get("event_Title"));
		EventPageActions.verifySelectedDateInEvent(addRoomEventTestData.get("event_Date"));
		EventPageActions.verifySelectedClinicInEdit(addRoomEventTestData.get("event_Clinic"));
		EventPageActions.verifySelectedRoomInEdit(addRoomEventTestData.get("event_On"));
		EventPageActions.verifySelectedCategoryInEdit(addRoomEventTestData.get("category"));
		EventPageActions.getHours(addRoomEventTestData.get("event_hours"));
		EventPageActions.getMinutes(addRoomEventTestData.get("event_mintues"));
		EventPageActions.getAMPM(addRoomEventTestData.get("AM_PM"));
		EventPageActions.getDurations(addRoomEventTestData.get("event_duration"));
		EventPageActions.getEventNotes(addRoomEventTestData.get("event_DateTime"));

		EventPageActions.enterTitleName(updateRoomEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(updateRoomEventTestData.get("event_Clinic"));
		EventPageActions.selectRoom(updateRoomEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(updateRoomEventTestData.get("category"));
		EventPageActions.selectDateInEvent(updateRoomEventTestData.get("event_Date"));
		EventPageActions.enterHours(updateRoomEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(updateRoomEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(updateRoomEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(updateRoomEventTestData.get("event_duration"));
		EventPageActions.enterNotes(updateRoomEventTestData.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();

		CommonPageActions.selectClinicFrmHeader(updateRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(updateRoomEventTestData.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(updateRoomEventTestData.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(updateRoomEventTestData.get("event_Title"),
				updateRoomEventTestData.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(updateRoomEventTestData.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();

		CommonPageActions.selectClinicFrmHeader(addRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterMobileNumber("1112211111");
		AppointmentAddPageActions.selectEConsult();

		EventPageActions.checkRoomIsSelectableOnAddAppt(addRoomEventTestData.get("event_On"),
				addRoomEventTestData.get("event_Date"), addRoomEventTestData.get("event_duration"),
				addRoomEventTestData.get("appointmentTimeSlot"));

		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.selectEConsult();
		EventPageActions.checkRoomIsDisableOnAddAppointment(updateRoomEventTestData.get("event_On"),
				updateRoomEventTestData.get("event_Date"), updateRoomEventTestData.get("event_duration"),
				updateRoomEventTestData.get("appointmentTimeSlot"));

	}

	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_BY_ROOM_EVENT_DELETED)
			//, dependsOnMethods = "verifyUpdateByRoomEvent")
	public void verifyDeleteByRoomEvent() {
		updateRoomEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A11", "O11");
		updateDoctorEventTestData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A3", "O3");
		logger.log(Status.PASS, VERIFY_BY_ROOM_EVENT_DELETED);
		CommonPageActions.selectClinicFrmHeader(updateRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(updateRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(updateRoomEventTestData.get("event_Date"));
		EventListingPageActions.selectType(updateRoomEventTestData.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyEditAndDeletBtn(updateRoomEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateRoomEventTestData.get("event_Title"));
		EventListingPageActions.clickOnNoBtnDeletePopUp(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateRoomEventTestData.get("event_Title"));
		EventListingPageActions.clickOnYesBtnDeletePopUp();
		EventListingPageActions.verifyAfterDelete(updateRoomEventTestData.get("event_Title"));
		Assert.assertTrue(AppointmentsLisitngPageActions.verifiyAppListHP());
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateRoomEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		AppointmentAddPageActions.enterMobileNumber("1112211111");
		AppointmentAddPageActions.selectEConsult();
		EventPageActions.checkRoomIsSelectableOnAddAppt(updateRoomEventTestData.get("event_On"),
				updateRoomEventTestData.get("event_Date"), updateRoomEventTestData.get("event_duration"),
				updateRoomEventTestData.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.verifyPageTitle(DOCTOR_DASHBOARD_PAGE_TITLE);

	}

	/*
	 ** Check when event is added for Time already Passed and error message show on
	 * save
	 */

	@Test(groups = { "Functional", "Regression" }, description = EVENT_TIME__ALREADY_PASSED)
	public void addingEventForPastTime() {
		logger.log(Status.PASS, EVENT_TIME__ALREADY_PASSED);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName(addDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(addDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.enterHours("12");
		EventPageActions.enterMinutes("00");
		EventPageActions.selectAmPm("AM");
		EventPageActions.enterEventDuration("90");
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyEventTimePassedErrorMessage();

		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyEventTimePassedErrorMessage();
		Assert.assertTrue(CommonPageActions.verification().contains(ADD_EVENT_PAGE_TITLE));
	}

	/*
	 ** Verify Adding By Scanner Event and then verify the event details on Event
	 * Listing Check event added Scanner is not available on Add Appointment page
	 */

	
	// can't run the test because we are having only 1 scanner we have to get it configured
	@Test(groups = { "Functional", "Regression" }, description = VERIFY_BY_SCANNER_EVENT)
	public void verifyByScannerEvent() {
		addScannerRoomEvent = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A15", "O15");
		logger.log(Status.PASS, VERIFY_BY_SCANNER_EVENT);
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.selectClinicInEvent(addScannerRoomEvent.get("event_Clinic"));
		EventPageActions.selectByScannerEvent();
		EventPageActions.enterTitleName(addScannerRoomEvent.get("event_Title"));
		EventPageActions.selectScanner(addScannerRoomEvent.get("event_On"));
		EventPageActions.selectEventCategory(addScannerRoomEvent.get("category"));
		EventPageActions.selectDateInEvent(addScannerRoomEvent.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterNotes(addScannerRoomEvent.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectType(addScannerRoomEvent.get("event_Type"));
		EventListingPageActions.selectCategroy(addScannerRoomEvent.get("category"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(addScannerRoomEvent.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(addScannerRoomEvent.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(addScannerRoomEvent.get("event_Title"),
				addScannerRoomEvent.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(addScannerRoomEvent.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkEventAddedScannerIsDisable(addScannerRoomEvent.get("event_On"),
				addScannerRoomEvent.get("event_Date"), addScannerRoomEvent.get("event_duration"),
				addScannerRoomEvent.get("appointmentTimeSlot"));

	}

	/*
	 * Verify event cannot be added to last available Scanner in clinic Assuming
	 * that only two Scanner is available in clinic,event will be added on first
	 * Scanner by above @test
	 *
	 */
	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_ADDING_EVENT_ON_LAST_AVAILABLE_SCANNER)
			//, dependsOnMethods = "verifyByScannerEvent")
	public void verifyAddingEventOnLastScannerAvailable() {
		addScannerRoomEvent = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A15", "O15");
		logger.log(Status.PASS, VERIFY_BY_SCANNER_EVENT_UPDATE);
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		BaseClass.waitForPageLoad();
		EventPageActions.clickOnEvent();
		EventPageActions.selectByScannerEvent();
		EventPageActions.enterTitleName(addScannerRoomEvent.get("event_Title"));
		EventPageActions.selectClinicInEvent(addScannerRoomEvent.get("event_Clinic"));
		EventPageActions.selectScanner("Scanner 201");
		EventPageActions.selectEventCategory(addScannerRoomEvent.get("category"));
		EventPageActions.selectDateInEvent(addScannerRoomEvent.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterNotes(addScannerRoomEvent.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		EventPageActions.verifyErrorOnAddingEventOnLastAvailableScanner();
		Assert.assertTrue(CommonPageActions.verification().contains(ADD_EVENT_PAGE_TITLE));

	}

	/*
	 * Update Scanner Event Added by @test verifyByScannerEvent Verify Updated
	 * Scanner details on Event Listing Checking in add appointment the Event is
	 * added on the Scanner Checking in the add appointment Scanner is available for
	 * the previous time slot
	 *
	 */
	// can't run the test because we are having only 1 scanner we have to get it configured
	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_BY_SCANNER_EVENT_UPDATE)
			//, dependsOnMethods = "verifyByScannerEvent")
	public void verifyUpdateByScannerEvent() {
		addScannerRoomEvent = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A15", "O15");
		updateScannerRoomEvent = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A16", "O16");
		logger.log(Status.PASS, VERIFY_BY_SCANNER_EVENT_UPDATE);
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectType(addScannerRoomEvent.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyEditAndDeletBtn(addScannerRoomEvent.get("event_Title"));
		EventListingPageActions.clickOnEditBtn(addScannerRoomEvent.get("event_Title"));
		Assert.assertEquals(driver.getTitle(), ADD_EVENT_PAGE_TITLE);

		EventPageActions.verifyEnteredEventTitleInEdit(addScannerRoomEvent.get("event_Title"));
		EventPageActions.verifySelectedDateInEvent(addScannerRoomEvent.get("event_Date"));
		EventPageActions.verifySelectedClinicInEdit(addScannerRoomEvent.get("event_Clinic"));
		EventPageActions.verifySelectedScannerInEdit(addScannerRoomEvent.get("event_On"));
		EventPageActions.verifySelectedCategoryInEdit(addScannerRoomEvent.get("category"));
		EventPageActions.verifyFullDayEventCheckboxInEdit();
		EventPageActions.getEventNotes(addScannerRoomEvent.get("event_notes"));

		EventPageActions.enterTitleName(updateScannerRoomEvent.get("event_Title"));
		EventPageActions.selectClinicInEvent(updateScannerRoomEvent.get("event_Clinic"));
		EventPageActions.selectScanner(updateScannerRoomEvent.get("event_On"));
		EventPageActions.selectEventCategory(updateScannerRoomEvent.get("category"));
		EventPageActions.selectDateInEvent(updateScannerRoomEvent.get("event_Date"));
		EventPageActions.clickOnFullDayCheckBox();
		EventPageActions.enterHours(updateScannerRoomEvent.get("event_hours"));
		EventPageActions.enterMinutes(updateScannerRoomEvent.get("event_mintues"));
		EventPageActions.selectAmPm(updateScannerRoomEvent.get("AM_PM"));
		EventPageActions.enterEventDuration(updateScannerRoomEvent.get("event_duration"));
		EventPageActions.enterNotes(updateScannerRoomEvent.get("event_notes"));
		EventPageActions.clickOnEventSaveBtn();
		Assert.assertEquals(CommonPageActions.verification(), EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.verifyDateTimeDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("event_DateTime"));
		EventListingPageActions.verifyDurationDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("event_duration"));
		EventListingPageActions.verifyTitleDisplayOnEventlist(updateScannerRoomEvent.get("event_Title"));
		EventListingPageActions.verifyEventTypeDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("event_On"));
		EventListingPageActions.verifyCategoryDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("category"));
		EventListingPageActions.verifyDoctorDisplayOnEventList(updateScannerRoomEvent.get("event_Title"), "NA");
		EventListingPageActions.verifyClinicDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("event_Clinic"));
		EventListingPageActions.verifyNotesDisplayOnEventList(updateScannerRoomEvent.get("event_Title"),
				updateScannerRoomEvent.get("event_notes"));
		EventListingPageActions.verifyEditAndDeletBtn(updateScannerRoomEvent.get("event_Title"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(addScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkScannerIsSelectableOnAddAppt(addScannerRoomEvent.get("event_On"),
				addScannerRoomEvent.get("event_Date"), addScannerRoomEvent.get("event_duration"),
				addScannerRoomEvent.get("appointmentTimeSlot"));
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkEventAddedScannerIsDisable(updateScannerRoomEvent.get("event_On"),
				updateScannerRoomEvent.get("event_Date"), updateScannerRoomEvent.get("event_duration"),
				updateScannerRoomEvent.get("appointmentTimeSlot"));

	}

	/*
	 * Delete the Added Scanner Event Checking on Add appointment after Scanner
	 * Event is deleted Scanner is available
	 *
	 */

	// can't run the test because we are having only 1 scanner we have to get it configured
	@Test(groups = { "Functional",
			"Regression" }, description = VERIFY_BY_SCANNER_EVENT_DELETED)
			//, dependsOnMethods = "verifyUpdateByScannerEvent")
	public void verifyDeleteByScannerEvent() {
		logger.log(Status.PASS, VERIFY_BY_SCANNER_EVENT_DELETED);
		CommonPageActions.selectClinicFrmHeader(updateScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(updateScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(updateScannerRoomEvent.get("event_Date"));
		EventListingPageActions.selectType(updateScannerRoomEvent.get("event_Type"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.verifyEditAndDeletBtn(updateScannerRoomEvent.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateScannerRoomEvent.get("event_Title"));
		EventListingPageActions.clickOnNoBtnDeletePopUp(updateDoctorEventTestData.get("event_Title"));
		EventListingPageActions.clickOnDeleteBtn(updateScannerRoomEvent.get("event_Title"));
		EventListingPageActions.clickOnYesBtnDeletePopUp();
		EventListingPageActions.verifyAfterDelete(updateScannerRoomEvent.get("event_Title"));
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(updateScannerRoomEvent.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.checkScannerIsSelectableOnAddAppt(updateScannerRoomEvent.get("event_On"),
				updateScannerRoomEvent.get("event_Date"), updateScannerRoomEvent.get("event_duration"),
				updateScannerRoomEvent.get("appointmentTimeSlot"));

	}

	/*
	 * Check Cancel button working on Add Event Page and Redirection after click on
	 * cancel button Verify Reset button working on Add Event Page.
	 */
	@Test(groups = { "Regression" }, description = VERIFY_CANCEL_BTN)
	public void verifyCancelAndResetBtnWorkingOnAddEvent() {
		logger.log(Status.PASS, VERIFY_CANCEL_BTN);
		logger.log(Status.INFO, VERIFY_RESET_BTN);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		EventPageActions.clickOnEvent();
		EventPageActions.enterTitleName(addDoctorEventTestData.get("event_Title"));
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent(addDoctorEventTestData.get("event_On"));
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(addDoctorEventTestData.get("event_Date"));
		EventPageActions.enterHours(addDoctorEventTestData.get("event_hours"));
		EventPageActions.enterMinutes(addDoctorEventTestData.get("event_mintues"));
		EventPageActions.selectAmPm(addDoctorEventTestData.get("AM_PM"));
		EventPageActions.enterEventDuration(addDoctorEventTestData.get("event_duration"));
		EventPageActions.enterNotes(addDoctorEventTestData.get("event_notes"));
		EventPageActions.clickOnEventResetBtn();

		EventPageActions.verifyEnteredEventTitleInEdit("");
		EventPageActions.verifySelectedClinicInEdit(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.verifySelectedDoctorInEdit("Select Doctor");
		EventPageActions.verifySelectedDateInEvent(EventPageActions.getCurrentDate());
		EventPageActions.verifySelectedCategoryInEdit("Select Category");
		EventPageActions.getEventNotes("");
		EventPageActions.getHours("");
		EventPageActions.getDurations("");
		EventPageActions.getMinutes("");

		EventPageActions.clickOnCancelBtn();
		Assert.assertTrue(CommonPageActions.verification().contains(DOCTOR_DASHBOARD_PAGE_TITLE));
	}

	/*
	 * Check All the Filter and Button Present on Event Listing Check Column Header
	 * on Event Listing
	 */

	@Test(groups = { "Regression" }, description = VERIFY_ELEMENT_ON_EVENT_LIST)
	public void verifyElementOnEventList() {
		logger.log(Status.PASS, VERIFY_ELEMENT_ON_EVENT_LIST);
		DoctorDashBoardPageActions.clickOnAppListBtn();
		BaseClass.waitForPageLoad();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.verifyAllMandatoryWebElement();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
	}

	/*
	 * Check Add Event Button on Event Listing Check On Click Redirecting to Add
	 * Event Check on click on Cancel button redirect to event listing Add event and
	 * check redirecting to event listing
	 */
	@Test(groups = { "Regression" }, description = VERIFY_ADD_EVENT_FROM_EVENT_LISTING)
	public void verifyAddEventFromEventListingAndRedirection() {
		logger.log(Status.PASS, VERIFY_ADD_EVENT_FROM_EVENT_LISTING);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.clickOnAddEventBtnOnEventListing();
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);
		EventPageActions.clickOnCancelBtn();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
		EventListingPageActions.clickOnAddEventBtnOnEventListing();
		CommonPageActions.verifyPageTitle(ADD_EVENT_PAGE_TITLE);
		EventPageActions.enterTitleName("Doctor out of station due to seminar");
		EventPageActions.selectClinicInEvent(addDoctorEventTestData.get("event_Clinic"));
		EventPageActions.selectDoctorInEvent("Sup Head");
		EventPageActions.selectEventCategory(addDoctorEventTestData.get("category"));
		EventPageActions.selectDateInEvent(EventPageActions.getCurrentDate());
		EventPageActions.enterHours("08");
		EventPageActions.enterMinutes("00");
		EventPageActions.selectAmPm("PM");
		EventPageActions.enterEventDuration("30");
		EventPageActions.clickOnEventSaveBtn();
//		EventPageActions.verifyEventAddSuccessMsg ();
		Assert.assertEquals(CommonPageActions.verification(), EVENTLISTING_PAGE_TITLE);

	}

	/*
	 * Apply date filter on Event Listing Verifying data after filter is applied
	 */

	@Test(groups = { "Functional", "Regression" }, description = VERIFY_FRM_AND_TO_DATE_FILTER, priority = 1)
	public void verifyFrmAndToDateFilter() {
		logger.log(Status.PASS, VERIFY_FRM_AND_TO_DATE_FILTER);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.dateFilter(addDoctorEventTestData.get("event_Date"),
				addDoctorEventTestData.get("event_Date"));
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);
	}

	/*
	 * Checking From date cannot be greater than to date in date Filter
	 */

	@Test(groups = { "Functional", "Regression" }, description = CHECK_FRM_DATE_IS_NOT_LATER_TO_TO_DATE)
	public void checkFrmDateIsNotLaterToToDate() {
		logger.log(Status.PASS, CHECK_FRM_DATE_IS_NOT_LATER_TO_TO_DATE);
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent("01/10/2024");
		EventListingPageActions.selectTodateInEvent("03/22/2023");
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.checkFrmDateIsNotLaterToToDate();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);

	}

	/*
	 * Applying Doctor Filter with date filter verifying data is filtered according
	 * to selected doctor and date
	 */
	@Test(groups = { "Regression" }, description = VERIFY_DOCTOR_FILTER_ON_EVENT_LIST, priority = 1)
	public void verifyDoctorFilterWithDateFilterOnEventList() {
		logger.log(Status.PASS, VERIFY_DOCTOR_FILTER_ON_EVENT_LIST);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectDoctor("Sup Zonehead");
		EventListingPageActions.verifyFilterDoctorInEventList("sup.zch");

		EventListingPageActions.selectFrmdateInEvent(EventPageActions.getCurrentDate());
		EventListingPageActions.selectTodateInEvent(EventPageActions.getCurrentDate());
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.dateFilter(EventPageActions.getCurrentDate(), EventPageActions.getCurrentDate());

		EventListingPageActions.verifyFilterDoctorInEventList("sup.zch");

	}

	/*
	 * Checking EventType Filter with date filter and verifying data is filtered
	 * according to selected Event Type and date
	 */

	@Test(groups = { "Regression" }, description = VERIFY_EVENT_TYPE_FILTER_ON_EVENT_LIST, priority = 1)
	public void verifyEventTypeFilterWithDateFilter() {
		logger.log(Status.PASS, VERIFY_EVENT_TYPE_FILTER_ON_EVENT_LIST);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.verifyOptionInEventTypeFilter();
		EventListingPageActions.selectFrmdateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectType("By Doctor");
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.dateFilter(addDoctorEventTestData.get("event_Date"),
				addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.verifyFilterEventTypeInEventList("Doctor");

	}

	/*
	 * Checking Event Category filter along with date and event type filter
	 * verifying data is filtered according to selected Category Type ,date and
	 * event type
	 */
	@Test(groups = { "Regression" }, description = VERIFY_FILTER_OF_CATEGORY_TYPE, priority = 1)
	public void verifyCategoryFilterWithDateAndTypeFilter() {
		logger.log(Status.PASS, VERIFY_FILTER_OF_CATEGORY_TYPE);
		CommonPageActions.selectClinicFrmHeader(addDoctorEventTestData.get("event_Clinic"));
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectTodateInEvent(addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.selectType("By Doctor");
		EventListingPageActions.selectCategroy("Lunch");
		EventListingPageActions.clickOnSearch();
		EventListingPageActions.dateFilter(addDoctorEventTestData.get("event_Date"),
				addDoctorEventTestData.get("event_Date"));
		EventListingPageActions.verifyFilterEventTypeInEventList("Doctor");
		EventListingPageActions.verifyFilterCategoryInEventList("Lunch");

	}

	/*
	 * Checking Reset button on event listing and verifying reset button working
	 */
	@Test(groups = { "Regression" }, description = VERIFY_RESET_BUTTON_FUNCTIONALITY_ON_EVENT_LISTING)
	public void verifyResetBtnOnEventListing() {
		logger.log(Status.PASS, VERIFY_RESET_BUTTON_FUNCTIONALITY_ON_EVENT_LISTING);
		DoctorDashBoardPageActions.clickOnAppListBtn();
		EventListingPageActions.clickOnEventBtn();
		EventListingPageActions.selectFrmdateInEvent(EventPageActions.getCurrentDate());
		EventListingPageActions.selectTodateInEvent(EventPageActions.getCurrentDate());
		EventListingPageActions.selectType("By Doctor");
		EventListingPageActions.selectCategroy("In Office");
		EventListingPageActions.verifyResetBtnWorking();
		CommonPageActions.verifyPageTitle(EVENTLISTING_PAGE_TITLE);

	}
}
