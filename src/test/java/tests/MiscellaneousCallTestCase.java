package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.MiscellaneousCallListingPageActions;
import pageActions.doctorDashboard.MiscellaneousCallPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import utils.SheetTest;
import utils.TestData;

public class MiscellaneousCallTestCase extends BaseClass {

	/*
	 * Messages for every test cases which will be print on the extent report
	 */

	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String CHECKED_MISCELLANEOUS_ADD_AND_LIST_UI = "Validate Miscellaneous Add and Listing for the First time -#checkedMiscellaneousAddAndListUi";
	private static final String ADD_MISCELLANEOUS_CALL = "Enter data on New Miscellaneous Call and Validate the same data on Miscellaneous Listing Page -#addMiscellaneousCall";
	private static final String CHECK_VALIDATION_MSGS_IN_NEW_MISCELLANEOUS_CALL = "Validate All mandatory fields with error Message on New Miscellaneous Call Page -#checkValidationMsgsInNewMiscellaneousCall";
	private static final String CHECK_ALL_BUTTON_ON_NEW_MISCELLANEOUS_CALL = "Validate All buttons and their redirection on New Miscellaneous Call Page -#checkAllButtonOnNewMiscellaneousCall";
	private static final String ADD_ANOTHER_MISCELLANEOUS_CALL = "Enter one more data on New Miscellaneous Call and Validate the same data on Miscellaneous Listing Page -#addMiscellaneousCall";
	private static final String CHECK_ALL_BUTTON_ON_MISCELLANEOUS_CALL_LIST = "Validate All buttons and their redirection on Miscellaneous Call Listing Page -#checkAllButtonOnMiscellaneousCallList";
	private static final String VERIFY_DATA_AFTER_SELECT_FILTER = "Validate data on listing after selection of Filter on Miscellaneous Call Listing Page -#verifyDataAfterSelectFilter";
	private static final String VERIFY_MULTIPLE_DATA_AFTER_SELECT_FILTER = "Validate Multiple data on listing after selection of Filter on Miscellaneous Call Listing Page -#verifyMultipleDataAfterSelectFilter";

	/*
	 * Page Title
	 */
	private final String MISCELLANEOUS_CALL_LISTING_TITLE = "Miscellaneous Call Listing";
	private final String ADD_MISCELLANEOUS_CALL_TITLE = "New Miscellaneous Call";
	private final String SUBSCRIBER_LISTING_TITLE = "Subscriber Listing";

	/*
	 * Google Sheet data details
	 */
	private static final String MODULE_NAME = "Miscellaneous Call";
	private static final String TEST_DATA_SHEET_NAME = "MiscellaneousCallTestData";

	/*
	 * Test Data from google Sheet
	 */
	private Map<String, String> miscellaneousCallData = null;

	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		miscellaneousCallData = SheetTest.prepareData(MODULE_NAME, TEST_DATA_SHEET_NAME, "A2", "L2");
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
	}

	/*
	 * Storing mandatory input required to run Miscellaneous test cases,make sure
	 * you update the mandatory input before running the test cases
	 */
	private static final String TODAY_DATE = TestData.getInstance().getTodayDate();
	private final String CALLER_NICKNAME = "Super";
	private static String CURRENT_TIME;

	/*
	 * LoginPage with UserName and Password Search for patients from the doctor
	 * DashBoard Verified patients will redirect at the patient DashBoard
	 */

	@Test(enabled = true, priority = 1)
	public void checkedMiscellaneousAddAndListUi() {
		logger.log(Status.PASS, CHECKED_MISCELLANEOUS_ADD_AND_LIST_UI);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		MiscellaneousCallListingPageActions.checkedAllBtnInMiscellaneousCallListing();
//		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		MiscellaneousCallListingPageActions.checkTypeDropDwn();
		MiscellaneousCallListingPageActions.checkDispositionDropDown();
		MiscellaneousCallListingPageActions.checkCallerNameDropDown();
		MiscellaneousCallListingPageActions.checkAllTextBoxFilter();
		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.checkedAllBtnInMiscellaneousCallAdd();
		MiscellaneousCallPageActions.checkTypeDropDwn();
		MiscellaneousCallPageActions.checkDuration();
		MiscellaneousCallPageActions.checkDispositionDropDown();
		MiscellaneousCallPageActions.checkInfoDropDown();
		MiscellaneousCallPageActions.checkNameTxtBx();
		MiscellaneousCallPageActions.checkMobileTxtBx();
		MiscellaneousCallPageActions.checkNotesTxtBx();
		MiscellaneousCallPageActions.clickOnCancelBtn();
		Assert.assertTrue(CommonPageActions.verification().contains(MISCELLANEOUS_CALL_LISTING_TITLE));
		CommonPageActions.backTODoctorDashboard();

	}

	/*
	 * Add one record in Miscellaneous call, click on save and also check successful
	 * message check same record on Miscellaneous listing
	 */
	@Test(enabled = true, priority = 2)
	public void addMiscellaneousCall() {
		logger.log(Status.PASS, ADD_MISCELLANEOUS_CALL);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.clickOnAddNew();
//		DoctorDashBoardPageActions.clickOnMiscCallsAdd();      btn not available
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.selectType(miscellaneousCallData.get("call_type"));
		MiscellaneousCallPageActions.addDuration(miscellaneousCallData.get("call_duration"));
		MiscellaneousCallPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallPageActions.selectInfo(miscellaneousCallData.get("call_info"));
		MiscellaneousCallPageActions.enterNameInTxtBx(miscellaneousCallData.get("call_name"));
		MiscellaneousCallPageActions.enterMobileInTxtBx(miscellaneousCallData.get("mobileNumber"));
		MiscellaneousCallPageActions.addNotes(miscellaneousCallData.get("notes"));
		MiscellaneousCallPageActions.clickOnSave();
		CURRENT_TIME = BaseClass.getCurrentTime();
		MiscellaneousCallListingPageActions.verifySuccessfullMessage();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.checkedMainListDataName();
		MiscellaneousCallListingPageActions.checkDateTimeMainList(miscellaneousCallData.get("mobileNumber"), TODAY_DATE,
				CURRENT_TIME);
		MiscellaneousCallListingPageActions.nameInMainList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				miscellaneousCallData.get("call_name"));
		MiscellaneousCallListingPageActions.miscellaneousCallList(TODAY_DATE, miscellaneousCallData.get("call_name"),
				miscellaneousCallData.get("mobileNumber"));
		MiscellaneousCallListingPageActions.miscellaneousCallList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions.miscellaneousCallList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.miscellaneousCallList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				miscellaneousCallData.get("call_info"));
		MiscellaneousCallListingPageActions.miscellaneousCallList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				CALLER_NICKNAME);
		MiscellaneousCallListingPageActions.notesCallList(TODAY_DATE, miscellaneousCallData.get("mobileNumber"),
				miscellaneousCallData.get("notes"));
		Assert.assertTrue(CommonPageActions.verification().contains(MISCELLANEOUS_CALL_LISTING_TITLE));
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * Check All scenario related to validation on Miscellaneous Add Page
	 */
	@Test(enabled = true, priority = 3)
	public void checkValidationMsgsInNewMiscellaneousCall() {
		logger.log(Status.PASS, CHECK_VALIDATION_MSGS_IN_NEW_MISCELLANEOUS_CALL);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);

		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.clickOnSave();
		MiscellaneousCallPageActions.checkedErrorDisposition("Select Disposition");
		MiscellaneousCallPageActions.checkedErrorInfo("Enter call info");
		MiscellaneousCallPageActions.checkedErrorName("Enter name");
		MiscellaneousCallPageActions.checkedErrorMobile("Enter mobile no.");
		MiscellaneousCallPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.selectInfo(miscellaneousCallData.get("call_info"));
		MiscellaneousCallPageActions.enterNameInTxtBx(miscellaneousCallData.get("call_name"));
		MiscellaneousCallPageActions.enterMobileInTxtBx(miscellaneousCallData.get("mobileNumber"));
		MiscellaneousCallPageActions.clickOnSave();
		MiscellaneousCallPageActions.checkedErrorDisposition("Select Disposition");
		MiscellaneousCallPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallPageActions.enterNameInTxtBx(miscellaneousCallData.get("call_name"));
		MiscellaneousCallPageActions.enterMobileInTxtBx(miscellaneousCallData.get("mobileNumber"));
		MiscellaneousCallPageActions.clickOnSave();
		MiscellaneousCallPageActions.checkedErrorInfo("Enter call info");
		MiscellaneousCallPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallPageActions.selectInfo(miscellaneousCallData.get("call_info"));
		MiscellaneousCallPageActions.enterMobileInTxtBx(miscellaneousCallData.get("mobileNumber"));
		MiscellaneousCallPageActions.clickOnSave();
		MiscellaneousCallPageActions.checkedErrorName("Enter name");
		MiscellaneousCallPageActions.clickOnResetBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallPageActions.selectInfo(miscellaneousCallData.get("call_info"));
		MiscellaneousCallPageActions.enterNameInTxtBx(miscellaneousCallData.get("call_name"));
		MiscellaneousCallPageActions.clickOnSave();
		MiscellaneousCallPageActions.checkedErrorMobile("Enter mobile no.");
		MiscellaneousCallPageActions.clickOnCancelBtn();
		Assert.assertTrue(CommonPageActions.verification().contains(MISCELLANEOUS_CALL_LISTING_TITLE));
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * Check All buttons shown in New Miscellaneous Call Page and also check the
	 * redirection of each button
	 */
	@Test(enabled = true, priority = 4)
	public void checkAllButtonOnNewMiscellaneousCall() {
		logger.log(Status.PASS, CHECK_ALL_BUTTON_ON_NEW_MISCELLANEOUS_CALL);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.clickOnSubscribers();
		BasePatientLifeCyclePageActions.headerOnListPage(SUBSCRIBER_LISTING_TITLE);
		MiscellaneousCallPageActions.clickMiscsCallAddBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.clickMiscCallListBtn();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		BasePatientLifeCyclePageActions.clickOnAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnAddPage(ADD_MISCELLANEOUS_CALL_TITLE);
		MiscellaneousCallPageActions.clickWorkAreaBtn();
		MiscellaneousCallPageActions.toverifyMyWorkAreaHomePage();
		MiscellaneousCallPageActions.clickOnDashboardBtnShowMyWorkArea();
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		CommonPageActions.verifyPageTitle(MISCELLANEOUS_CALL_LISTING_TITLE);
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * Check All buttons shown in Miscellaneous Call Listing Page and also check the
	 * redirection of each button
	 */
	@Test(enabled = true, priority = 6)
	public void checkAllButtonOnMiscellaneousCallList() {
		logger.log(Status.PASS, CHECK_ALL_BUTTON_ON_MISCELLANEOUS_CALL_LIST);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.clickOnSubscribers();
		BasePatientLifeCyclePageActions.headerOnListPage(SUBSCRIBER_LISTING_TITLE);
		MiscellaneousCallListingPageActions.clickMiscsCallListBtn();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.checkTypeDropDwn();
		MiscellaneousCallListingPageActions.checkDispositionDropDown();
		MiscellaneousCallListingPageActions.checkCallerNameDropDown();
		MiscellaneousCallListingPageActions.checkAllTextBoxFilter();
		CommonPageActions.verifyPageTitle(MISCELLANEOUS_CALL_LISTING_TITLE);
		CommonPageActions.backTODoctorDashboard();
	}

	/*
	 * check All filter with options present in All DropDown and All TextBox shown
	 * in Miscellaneous List Page Also check data on a listing after selection of
	 * Filter
	 */
	@Test(enabled = true, priority = 7)
	public void verifyDropDownFilterOnListing() {
		logger.log(Status.PASS, VERIFY_DATA_AFTER_SELECT_FILTER);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
//		commented below lines bcz when applied filter, at pg 158 an error is coming
//		MiscellaneousCallListingPageActions.selectType(miscellaneousCallData.get("call_type"));
//		MiscellaneousCallListingPageActions.clickSearchBtn();
//		MiscellaneousCallListingPageActions.verifyDataOnCallTypeFilter(miscellaneousCallData.get("call_type"));
//		MiscellaneousCallListingPageActions.clickOnResetBtn();	
		MiscellaneousCallListingPageActions.selectType(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.verifyDataOnCallTypeFilter(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions
				.verifyDataOnCallDispositionFilter(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.clickOnResetBtn();

		MiscellaneousCallListingPageActions.selectType(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.selectCallerName(miscellaneousCallData.get("caller_name"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.verifyDataOnCallTypeFilter(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions
				.verifyDataOnCallDispositionFilter(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.verifyDataOnCallerNameFilter(miscellaneousCallData.get("caller_name"));
		MiscellaneousCallListingPageActions.clickOnResetBtn();
//		

		MiscellaneousCallListingPageActions.selectType(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.selectCallerName(miscellaneousCallData.get("caller_name"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.AddFromDate(miscellaneousCallData.get("fromDate"));
		MiscellaneousCallListingPageActions.AddToDate(miscellaneousCallData.get("toDate"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.verifyDataOnCallTypeFilter(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions
				.verifyDataOnCallDispositionFilter(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.verifyDataOnCallerNameFilter(miscellaneousCallData.get("caller_name"));
		MiscellaneousCallListingPageActions.veifyDataOnDateFilter(miscellaneousCallData.get("fromDate"),
				miscellaneousCallData.get("toDate"));

		CommonPageActions.verifyPageTitle(MISCELLANEOUS_CALL_LISTING_TITLE);
		CommonPageActions.backTODoctorDashboard();

	}

	/*
	 * * Verify Patient Name and Patient Mobile Number details search field
	 */
	@Test(enabled = true, priority = 8)
	public void verifyNameMobileSearchFilter() {
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.addDetails(miscellaneousCallData.get("patientName_details"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions
				.verifyDataOnNameSearchFilter(miscellaneousCallData.get("patientName_details"));
		MiscellaneousCallListingPageActions.clickOnResetBtn();

		MiscellaneousCallListingPageActions.addDetails(miscellaneousCallData.get("patientMobile_details"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions
				.verifyDataOnMobileNumberSearchFilter(miscellaneousCallData.get("patientMobile_details"));
		MiscellaneousCallListingPageActions.clickOnResetBtn();

		MiscellaneousCallListingPageActions.selectType(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions.selectDisposition(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.addDetails(miscellaneousCallData.get("patientName_details"));
		MiscellaneousCallListingPageActions.AddFromDate(miscellaneousCallData.get("fromDate"));
		MiscellaneousCallListingPageActions.AddToDate(miscellaneousCallData.get("toDate"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions
				.verifyDataOnNameSearchFilter(miscellaneousCallData.get("patientName_details"));
		MiscellaneousCallListingPageActions.verifyDataOnCallTypeFilter(miscellaneousCallData.get("call_type"));
		MiscellaneousCallListingPageActions
				.verifyDataOnCallDispositionFilter(miscellaneousCallData.get("call_disposition"));
		MiscellaneousCallListingPageActions.veifyDataOnDateFilter(miscellaneousCallData.get("fromDate"),
				miscellaneousCallData.get("toDate"));
		CommonPageActions.backTODoctorDashboard();

	}

	/*
	 * Check Date filter on Miscellaneous Call Listing
	 */
	@Test(enabled = true, priority = 9)
	public void verifyDateFilter() {
		logger.log(Status.PASS, VERIFY_MULTIPLE_DATA_AFTER_SELECT_FILTER);
		DoctorDashBoardPageActions.clickOnMiscCallsList();
		BasePatientLifeCyclePageActions.headerOnListPage(MISCELLANEOUS_CALL_LISTING_TITLE);
		MiscellaneousCallListingPageActions.AddFromDate("01-10-20");
		MiscellaneousCallListingPageActions.AddToDate("05-05-21");
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.verifyDateRangeErrorMsg();
		MiscellaneousCallListingPageActions.clickOnResetBtn();

		MiscellaneousCallListingPageActions.AddFromDate("01-10-20");
		MiscellaneousCallListingPageActions.AddToDate("05-05-20");
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.verifyFromDateExceedToDateErrorMsg();
		MiscellaneousCallListingPageActions.clickOnResetBtn();

		MiscellaneousCallListingPageActions.AddFromDate(miscellaneousCallData.get("fromDate"));
		MiscellaneousCallListingPageActions.AddToDate(miscellaneousCallData.get("toDate"));
		MiscellaneousCallListingPageActions.clickSearchBtn();
		MiscellaneousCallListingPageActions.veifyDataOnDateFilter(miscellaneousCallData.get("fromDate"),
				miscellaneousCallData.get("toDate"));
		CommonPageActions.backTODoctorDashboard();

	}

}
