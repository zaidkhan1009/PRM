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

public class LabWorkOrderListingTestCase1 extends BaseClass{

	
	
	/*
	 * Storing mandatory input required to run LWO test cases,make sure you
	 * update the mandatory input before running the test cases
	 *
	 */
	private static final String TRT_FILE_PATH = TestData.getInstance().getInputData("treatment_plan_file_path");
	private static final String FILE_PATH = TestData.getInstance().getInputData("lab_work_order1_file_path");
	private static final String SHEET = TestData.getInstance().getInputData("lab_work_order1_file_sheet_name");
	private static final String TRT_SHEET = TestData.getInstance().getInputData("treatment_plan_file_sheet_name");
	private static final String PATIENT_NAME= TestData.getInstance().getInputData("lab_work_order1_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("lab_work_order1_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("lab_work_order1_doctor_name");
	private static final String DOCTOR_FIRST_NAME = TestData.getInstance().getInputData("lab_work_order1_doctor_first_name");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("lab_work_order1_clinic_name");
	private static final String INSTANCE = TestData.getInstance().getInputData("lab_work_order1_instance");
	private static final String TODAY_DATE=TestData.getInstance().getTodayDate();
	private static final String START_DATE_TIME=TestData.getInstance().getFewMinuteBackFromCurrentDateTime();
	private static final String END_DATE_TIME=TestData.getInstance().getFewMinuteAfterFromCurrentDateTime();

	/*
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG  = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS  = "@@ Test script has been completed @@";
	private static final String CHECKED_LAB_WORK_ORDER_LIST_UI = "Validate Lab Work Order List for the First time -#CheckedLabWorkOrderListUi";
	private static final String CHECK_LAB_WORK_ORDER_AFTER_TREATMENT_START = "Checked LWO after we start Treatment on all screen View and listing -#checkLabWorkOrderAfterTreatmentStart";
	private static final String CHECK_LAB_WORK_ORDER_ON_EDIT_AFTER_TREATMENT_START = "Checked LWO on Edit after we start Treatment -#CheckLabWorkOrderOnEditAfterTreatmentStart";
	private static final String CHECK_AFTER_ENTER_DATA_IN_LAB_WORK_ORDER_EDIT_PAGE = "Enter data in LWO edit screen and Checked on List and View Screen -#checkAfterEnterDataInLabWorkOrderEditPage";
	private static final String CLICK_SUBMITTED_TO_LAB_OF_ABOVE_LAB_WORK_ORDER = "Clicked Above LWO as Submitted to Lab and Checked On View and list -#clickSubmittedToLabOfAboveLabWorkOrder";
	private static final String COMPLETE_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS = "Completed Trt from WorkDone And Check status on List and View of LWO -#completeTrtAndCheckLWOStatus";
	private static final String COMPLETE_PAYMENT_AND_CHECK_LAB_WORK_ORDER_STATUS = "Completed Payment from Invoice And Check status on List and View of LWO -#completePaymentAndCheckLWOStatus";
	private static final String RETREAT_ABOVE_COMPLETE_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS = "ReTreat Above Completed Trt from WorkDone And Check status on List and View of LWO -#reTreatAboveCompleteTrtAndCheckLWOStatus";
	private static final String COMPLETE_ABOVE_RETREAT_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS = "Completed Above ReTreat Trt from WorkDone And Check status on List and View of LWO -#CompleteAboveReTreatTrtAndCheckLWOStatus";

	/*
     * Module and Sheet Name for getting Data from Google sheet
     */
    final String MODULE_NAME="LWO";
    final String GOOGLE_SHEET_NAME="LWOTestData";
    final String Product_SALE_PAGE_TITLE="Product Sales";
    
    /*
	 * Google Sheet Test Data in Map
	 */
	private Map<String,String>addLWOInDraftMode=SheetTest.prepareData(MODULE_NAME, GOOGLE_SHEET_NAME, "A2", "AB2");
	private Map<String,String> addLWOInSubmittedToLabMode=null;
	private Map<String,String> addLWOInPaymentCompletedMode=null;
	private Map<String,String> addLWOInTreatmentCompletedMode=null;
	private Map<String,String> addLWOInPayableToLabMode=null;
	private Map<String,String> addLWOInPayable=null;
	private Map<String,String> addLWOInPaymentResubmitted=null;
	private Map<String,String> addLWOInPaymentTrtComplete=null;
	private Map<String,String> addLWOInPaymentTrtCompleted=null;
	private Map<String,String> addTrtForCrown=null;
	private Map<String,String> addTrtForCrownPFM=null;
	private Map<String,String> addTrtForCrownFullMetal=null;
	private Map<String,String> addTrtForCrownMetal=null;
	
	@Test(groups = {"Sanity","Regression"},enabled= true, priority = 1)
	public void checkedLabWorkOrderListUi() {
		logger.log(Status.PASS, CHECKED_LAB_WORK_ORDER_LIST_UI);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));

		/*
		 * Start LWO enable Trt.
		 * check msg when we complete the Trt from Workdone when LWO have status as Draft
		 * check LWO listing and view screen after Trt start
		 */
	}
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=2)
	public void checkLabWorkOrderAfterTreatmentStart() {
		logger.log(Status.PASS, CHECK_LAB_WORK_ORDER_AFTER_TREATMENT_START);
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(DOCTOR_NAME);
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.clickOnTeethImage("Adult",addLWOInDraftMode.get("source"));
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup(addLWOInDraftMode.get("source"));
		TreatmentPlansPageActions.clickOnCrowns();
		TreatmentPlansPageActions.clickOnSearchField(addLWOInDraftMode.get("plan_short_name"));
		TreatmentPlansPageActions.clickOnTreatments(addLWOInDraftMode.get("plan_short_name"));
		TreatmentPlansPageActions.saveTreatment();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(addLWOInDraftMode.get("plan_full_name"));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE); 
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectTime(addLWOInDraftMode.get("plan_full_name"), "15");
		WorksDonePageActions.enterRemarks(addLWOInDraftMode.get("plan_full_name"), "Change to complete");
		WorksDonePageActions.selectStages(addLWOInDraftMode.get("plan_full_name"), "Cementation");
		WorksDonePageActions.clickOnAdd(addLWOInDraftMode.get("plan_full_name"));
		WorksDonePageActions.verifyLWOActionMessage();
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		LabWorkOrderListingPageActions.checkClinicNameMainList(addLWOInDraftMode.get("source"),CLINIC_NAME);
		LabWorkOrderListingPageActions.checkLabNameMainList(addLWOInDraftMode.get("source"), addLWOInDraftMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkDateMainList(addLWOInDraftMode.get("source"),TODAY_DATE );
		LabWorkOrderListingPageActions.checkOrderTypeMainList(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("order_type"));
		LabWorkOrderListingPageActions.checkLabWorkOrderNo(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkWorkDetailsMainlist(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("work_details"));
		LabWorkOrderListingPageActions.checkSourceMainList(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.checkDoctorMainList(addLWOInDraftMode.get("source"),DOCTOR_FIRST_NAME);
		LabWorkOrderListingPageActions.checkItemSentMainList(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("revision"),addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.checkedViewDataName();
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyPatientNameView(PATIENT_NAME);
		LabWorkOrderListingPageActions.verifyLabWorkOrderNoView();
		LabWorkOrderListingPageActions.verifyDateTimeInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkLabNameViewList(addLWOInDraftMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkOrderTypeViewList(addLWOInDraftMode.get("order_type"));
		LabWorkOrderListingPageActions.checkWorkDetailViewList(addLWOInDraftMode.get("work_details"));
		LabWorkOrderListingPageActions.checkOtherInfoViewList(addLWOInDraftMode.get("other_info"));
		LabWorkOrderListingPageActions.checkSourceViewList(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.checkItemSentViewList(addLWOInDraftMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkRequireViewList(addLWOInDraftMode.get("require"));
		LabWorkOrderListingPageActions.checkShadeViewList(addLWOInDraftMode.get("shade"),addLWOInDraftMode.get("shade_option"));
		LabWorkOrderListingPageActions.checkStainsInternalViewList(addLWOInDraftMode.get("stains_internal"));
		LabWorkOrderListingPageActions.checkStainsExternalViewList(addLWOInDraftMode.get("stains_external"));
		LabWorkOrderListingPageActions.checkTranslucencyViewList(addLWOInDraftMode.get("translucency"));
		LabWorkOrderListingPageActions.checkTextureViewList(addLWOInDraftMode.get("texture"));
		LabWorkOrderListingPageActions.checkConfigurationsViewList(addLWOInDraftMode.get("configurations"),addLWOInDraftMode.get("configurations_opt"));
		LabWorkOrderListingPageActions.checkSurfaceDetailsViewList("NA","NA");
		LabWorkOrderListingPageActions.checkNotesViewList(addLWOInDraftMode.get("notes"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyTreatmentNameView(addLWOInDraftMode.get("plan_short_name"),1);
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * check LWO edit page after Trt start
	 * check all button shown on LWO edit page
	 */
	@Test(groups = {"Functional","Regression"},enabled=true, priority=3)
	public void CheckLabWorkOrderOnEditAfterTreatmentStart() {
		logger.log(Status.PASS, CHECK_LAB_WORK_ORDER_ON_EDIT_AFTER_TREATMENT_START);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		LabWorkOrderListingPageActions.clickOnEdit(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.verifyHeaderOfPage("Lab Work Order Edit");
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		LabWorkOrderEditPageActions.checkedAllFieldsInWorkDetailPanel();
		LabWorkOrderEditPageActions.clinicName(CLINIC_NAME);
		LabWorkOrderEditPageActions.source(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.labWorkOrderNo();
		LabWorkOrderEditPageActions.checkLabDropDwn(INSTANCE);
		LabWorkOrderEditPageActions.checkOrderType(addLWOInDraftMode.get("order_type"));
		LabWorkOrderEditPageActions.checkWorkDetails(addLWOInDraftMode.get("work_details"));
		LabWorkOrderEditPageActions.checkOtherInfo(addLWOInSubmittedToLabMode.get("other_info"));
		LabWorkOrderEditPageActions.checkItemSendDrpDwn();
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.checkedAllFieldsInAdditionalDetailPanel();
		LabWorkOrderEditPageActions.checkRequireDropDwn();
		LabWorkOrderEditPageActions.checkStainsInternalDropDwn();
		LabWorkOrderEditPageActions.checkStainsExternalDropDwn();
		LabWorkOrderEditPageActions.checkedTranslucencyTextureAndNotes();
		LabWorkOrderEditPageActions.clickOnBuccal();
		LabWorkOrderEditPageActions.verifyProvisinals();
		LabWorkOrderEditPageActions.clickOnDistal();
		LabWorkOrderEditPageActions.verifyProvisinals();
		LabWorkOrderEditPageActions.clickOnMesial();
		LabWorkOrderEditPageActions.verifyProvisinals();
		LabWorkOrderEditPageActions.clickOnMesial();
		LabWorkOrderEditPageActions.verifyProvisinals();
		LabWorkOrderEditPageActions.checkedActionButtonInEdit();
		LabWorkOrderEditPageActions.clickOnCancelBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * Enter data into all fields shown in LWO edit Page
	 * check all data in LWO listing and View Screen after data added
	 * click on save as Draft.
	 */
	@Test(groups = {"Functional","Regression"},enabled=true, priority=4)
	public void checkAfterEnterDataInLabWorkOrderEditPage() {
		logger.log(Status.PASS, CHECK_AFTER_ENTER_DATA_IN_LAB_WORK_ORDER_EDIT_PAGE);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		LabWorkOrderListingPageActions.clickOnEdit(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.verifyHeaderOfPage("Lab Work Order Edit");
		LabWorkOrderEditPageActions.selectLab(addLWOInSubmittedToLabMode.get("lab_name"));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.selectItemsSend(addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderEditPageActions.selectItemsSend(addLWOInPaymentCompletedMode.get("item_sent"));
		LabWorkOrderEditPageActions.addFile(System.getProperty("user.dir")+"\\PatientFiles\\"+addLWOInSubmittedToLabMode.get("attach_name"));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.selectRequire(addLWOInSubmittedToLabMode.get("require"));
		LabWorkOrderEditPageActions.selectShade(addLWOInSubmittedToLabMode.get("shade"));
		LabWorkOrderEditPageActions.selectShadeOptionFromDrpDwn(addLWOInSubmittedToLabMode.get("shade_option"));
		LabWorkOrderEditPageActions.selectStainsInternal(addLWOInSubmittedToLabMode.get("stains_internal"));
		LabWorkOrderEditPageActions.selectStainsExternal(addLWOInSubmittedToLabMode.get("stains_external"));
		LabWorkOrderEditPageActions.addTransluency(addLWOInSubmittedToLabMode.get("translucency"));
		LabWorkOrderEditPageActions.addTexture(addLWOInSubmittedToLabMode.get("texture"));
		LabWorkOrderEditPageActions.selectConfigurations(addLWOInSubmittedToLabMode.get("configurations"), addLWOInSubmittedToLabMode.get("configurations_opt"));
		LabWorkOrderEditPageActions.clickOnBuccal();
		LabWorkOrderEditPageActions.clickOnToothSiteAndPerioProvisinals();
		LabWorkOrderEditPageActions.verifyProvisinalIsSelected("Buccal");
		LabWorkOrderEditPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		LabWorkOrderEditPageActions.clickOnDistal();
		LabWorkOrderEditPageActions.clickOnToothSiteAndPerioProvisinals();
		LabWorkOrderEditPageActions.verifyProvisinalIsSelected("Distal");
		LabWorkOrderEditPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		LabWorkOrderEditPageActions.clickOnMesial();
		LabWorkOrderEditPageActions.clickOnToothSiteAndPerioProvisinals();
		LabWorkOrderEditPageActions.verifyProvisinalIsSelected("Mesial");
		LabWorkOrderEditPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		LabWorkOrderEditPageActions.clickOnLingual();
		LabWorkOrderEditPageActions.clickOnToothSiteAndPerioProvisinals();
		LabWorkOrderEditPageActions.verifyProvisinalIsSelected("Lingual");
		LabWorkOrderEditPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		LabWorkOrderEditPageActions.enterNotes(addLWOInSubmittedToLabMode.get("notes"));
		LabWorkOrderEditPageActions.clickSaveAsDraft();
		LabWorkOrderListingPageActions.verifySuccessfullMessage();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkLabNameMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkItemSentMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkLabNameViewList(addLWOInSubmittedToLabMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkItemSentViewList(addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkItemSentViewList(addLWOInPaymentCompletedMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkRequireViewList(addLWOInSubmittedToLabMode.get("require"));
		LabWorkOrderListingPageActions.checkShadeViewList(addLWOInSubmittedToLabMode.get("shade"), addLWOInSubmittedToLabMode.get("shade_option"));
		LabWorkOrderListingPageActions.checkStainsInternalViewList(addLWOInSubmittedToLabMode.get("stains_internal"));
		LabWorkOrderListingPageActions.checkStainsExternalViewList(addLWOInSubmittedToLabMode.get("stains_external"));
		LabWorkOrderListingPageActions.checkTranslucencyViewList(addLWOInSubmittedToLabMode.get("translucency"));
		LabWorkOrderListingPageActions.checkTextureViewList(addLWOInSubmittedToLabMode.get("texture"));
		LabWorkOrderListingPageActions.checkConfigurationsViewList(addLWOInSubmittedToLabMode.get("configurations"), addLWOInSubmittedToLabMode.get("configurations_opt"));
		LabWorkOrderListingPageActions.checkSurfaceDetailsViewList("Buccal","Chamfer");
		LabWorkOrderListingPageActions.checkSurfaceDetailsViewList("Distal","Chamfer");
		LabWorkOrderListingPageActions.checkSurfaceDetailsViewList("Mesial","Chamfer");
		LabWorkOrderListingPageActions.checkSurfaceDetailsViewList("Lingual","Chamfer");
		LabWorkOrderListingPageActions.checkNotesViewList(addLWOInSubmittedToLabMode.get("notes"));
		LabWorkOrderListingPageActions.checkAttachmentViewList(addLWOInSubmittedToLabMode.get("attach_name"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * Get all data from LWO edit page that have added above
	 * Click on Submitted to Lab
	 * Check status and LWO no. should not be Null or NA on LWO listing and view screen
	 * Check button in LWO listing page and also check successful msg shown in LWO listing page
	 * Check Revision detail in LWO View Screen
	 * Edit data and again Click on Submitted to Lab, check new Revision is entered.
	 * Also check InActive Revision
	 * Again check edited data in LWO listing and View Screen
	 */
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=5)
	public void clickSubmittedToLabOfAboveLabWorkOrder() {
		logger.log(Status.PASS, CLICK_SUBMITTED_TO_LAB_OF_ABOVE_LAB_WORK_ORDER);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.clickOnEdit(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.verifyHeaderOfPage("Lab Work Order Edit");
		LabWorkOrderEditPageActions.getLabDrpDwn(addLWOInSubmittedToLabMode.get("lab_name"));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.getItemsSendDrpDwn(addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderEditPageActions.getItemsSendDrpDwn(addLWOInPaymentCompletedMode.get("item_sent"));
		LabWorkOrderEditPageActions.getFile(addLWOInSubmittedToLabMode.get("attach_name"));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.getRequireDrpDwn(addLWOInSubmittedToLabMode.get("require"));
		LabWorkOrderEditPageActions.getShadeOptionDrpDwn(addLWOInSubmittedToLabMode.get("shade_option"));
		LabWorkOrderEditPageActions.getStainsInternalDrpDwn(addLWOInSubmittedToLabMode.get("stains_internal"));
		LabWorkOrderEditPageActions.getStainsExternalDrpDwn(addLWOInSubmittedToLabMode.get("stains_external"));
		LabWorkOrderEditPageActions.getTranslucency(addLWOInSubmittedToLabMode.get("translucency"));
		LabWorkOrderEditPageActions.getTexture(addLWOInSubmittedToLabMode.get("texture"));
		LabWorkOrderEditPageActions.getNotes(addLWOInSubmittedToLabMode.get("notes"));
		LabWorkOrderEditPageActions.clickSubmittedToLab();
		LabWorkOrderListingPageActions.verifySuccessfullMessage();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkLabWorkOrderNo(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.checkPrintBtn(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyLabWorkOrderNoView();
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkedRevisionDetailsDataNameView();
		LabWorkOrderListingPageActions.checkRevisionNoViewList(addLWOInDraftMode.get("revision"));
		LabWorkOrderListingPageActions.verifyRevisionDateInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		LabWorkOrderListingPageActions.clickOnEdit(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.verifyHeaderOfPage("Lab Work Order Edit");
		LabWorkOrderEditPageActions.deleteFile(addLWOInSubmittedToLabMode.get("attach_name"));
		LabWorkOrderEditPageActions.clickOnYesDelete();
		LabWorkOrderEditPageActions.selectLab(addLWOInPaymentCompletedMode.get("lab_name"));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.selectItemsSend(addLWOInPaymentCompletedMode.get("item_sent"));
		LabWorkOrderEditPageActions.addUpdateReason(addLWOInDraftMode.get("updation_reason"));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.selectRequire(addLWOInPaymentCompletedMode.get("require"));
		LabWorkOrderEditPageActions.selectShade(addLWOInDraftMode.get("shade"));
		LabWorkOrderEditPageActions.addTransluency(addLWOInPaymentCompletedMode.get("translucency"));
		LabWorkOrderEditPageActions.selectConfigurations(addLWOInPaymentCompletedMode.get("configurations"), addLWOInPaymentCompletedMode.get("configurations_opt"));
		LabWorkOrderEditPageActions.enterNotes(addLWOInPaymentCompletedMode.get("notes"));
		LabWorkOrderEditPageActions.clickSubmittedToLab();
		LabWorkOrderListingPageActions.verifySuccessfullMessage();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkLabNameMainList(addLWOInDraftMode.get("source"),addLWOInPaymentCompletedMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkInActiveEntry(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("revision"),"LWO Updated");
		LabWorkOrderListingPageActions.checkInActiveRevisionReasonMainList(addLWOInDraftMode.get("source"), addLWOInDraftMode.get("revision"), addLWOInSubmittedToLabMode.get("reason"));
		LabWorkOrderListingPageActions.checkInActiveViewBtn(addLWOInDraftMode.get("source"),addLWOInDraftMode.get("revision"));
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkItemSentMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("revision"), addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkLabNameViewList(addLWOInPaymentCompletedMode.get("lab_name"));
		LabWorkOrderListingPageActions.checkUpdationReasonViewList(addLWOInDraftMode.get("updation_reason"));
		LabWorkOrderListingPageActions.checkRequireViewList(addLWOInPaymentCompletedMode.get("require"));
		LabWorkOrderListingPageActions.checkShadeViewList(addLWOInPaymentCompletedMode.get("shade"), addLWOInPaymentCompletedMode.get("shade_option"));
		LabWorkOrderListingPageActions.checkTranslucencyViewList(addLWOInPaymentCompletedMode.get("translucency"));
		LabWorkOrderListingPageActions.checkConfigurationsViewList(addLWOInPaymentCompletedMode.get("configurations"), addLWOInPaymentCompletedMode.get("configurations_opt"));
		LabWorkOrderListingPageActions.checkNotesViewList(addLWOInPaymentCompletedMode.get("notes"));
		LabWorkOrderListingPageActions.checkRevisionNoViewList(addLWOInSubmittedToLabMode.get("revision_no"));
		LabWorkOrderListingPageActions.verifyRevisionDateInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInSubmittedToLabMode.get("status"));
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * Partially Complete Trt from WorkDone and check LWO status in LWO listing and View Screen
	 * Fully Completed Trt from WorkDone and check LWO status In LWO listing and View Screen
	 */
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=6)
	public void completeTrtAndCheckLWOStatus() {
		logger.log(Status.PASS, COMPLETE_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectTime(addLWOInDraftMode.get("plan_Full_Name"), "15");
		WorksDonePageActions.enterRemarks(addLWOInDraftMode.get("plan_Full_Name"), "it is for testing");
		WorksDonePageActions.selectStages(addLWOInDraftMode.get("plan_Full_Name"), "In-Progress");
		WorksDonePageActions.clickOnAdd(addLWOInDraftMode.get("plan_Full_Name"));
		WorksDonePageActions.closeAppoitmentPopup();
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("revision"),addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyDateTimeInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickViewScreenClose();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectTime(addLWOInDraftMode.get("plan_Full_Name"), "15");
		WorksDonePageActions.enterRemarks(addLWOInDraftMode.get("plan_Full_Name"), "Change to complete");
		WorksDonePageActions.selectStages(addLWOInDraftMode.get("plan_Full_Name"), "Cementation");
		WorksDonePageActions.clickOnAdd(addLWOInDraftMode.get("plan_Full_Name"));
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("revision"),addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"),addLWOInTreatmentCompletedMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyDateTimeInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInTreatmentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInTreatmentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInTreatmentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * Take full payment of that Trt and check LWO status in LWO listing and View Screen
	 * Also check status of LWO should show as Payable
	 */
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=7)
	public void completePaymentAndCheckLWOStatus() {
		logger.log(Status.PASS, COMPLETE_PAYMENT_AND_CHECK_LAB_WORK_ORDER_STATUS);
		BasePatientLifeCyclePageActions.clickOnAlert();
	/*	PatientDashboardPageActions.clickOnInvoiceList();
		invoiceListingPage.headerPage("Invoice Listing");
//		invoiceListingPage.clickInvoicePaymentBtn();
//		newReceiptPage.headerNewReceipt("New Receipt");
//		newReceiptPage.collectByTreamentNewReceipts(ReadExcelData.readExcelData(FILE_PATH, SHEET, 19, 2), 1090);
//		newReceiptPage.selectPaymentMode("Cash");
//		newReceiptPage.saveNewReceipts();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert(); */
		PatientDashboardPageActions.clickOnLabWorkOrderAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("revision"),addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"),addLWOInPayableToLabMode.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.verifyDateTimeInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInTreatmentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPayable.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInTreatmentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPayable.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInPayableToLabMode.get("status"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * From WorkDone Retreat the Trt which is completed above and check the LWO status on LWO listing and View screen
	 * check one ReWork button should also shown
	 * check InActive Revision list
	 * check Reason on listing and View Screen and status should shown as Payable Resubmitted
	 */
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=8)
	public void reTreatAboveCompleteTrtAndCheckLWOStatus() {
		logger.log(Status.PASS, RETREAT_ABOVE_COMPLETE_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneHistory();
		BasePatientLifeCyclePageActions.headerOnAddPage("Work Done History");
		WorkDoneHistoryPageActions.clickReTreatBtn(addLWOInDraftMode.get("source"));
		WorkDoneHistoryPageActions.selectRequire("Re-infection.");
		WorkDoneHistoryPageActions.clickSaveBtnOnReasonPopUp();
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.clickOnViewAtTimeForRework(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkSourceViewList(addLWOInDraftMode.get("source"), "ReTreated");
		LabWorkOrderListingPageActions.clickViewScreenClose();
		LabWorkOrderListingPageActions.clickOnRework(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.verifyHeaderOfReWorkPage("Lab Work Order Re-work");
		BasePatientLifeCyclePageActions.verifyPatientName(PATIENT_NAME);
		LabWorkOrderEditPageActions.checkedAllFieldsInWorkDetailPanel();
		LabWorkOrderEditPageActions.clinicName(CLINIC_NAME);
		LabWorkOrderEditPageActions.source(addLWOInDraftMode.get("source"));
		LabWorkOrderEditPageActions.labWorkOrderNo();
		LabWorkOrderEditPageActions.checkLabForReWork();
		LabWorkOrderEditPageActions.checkOrderType(addLWOInDraftMode.get("order_type"));
		LabWorkOrderEditPageActions.checkWorkDetails(addLWOInDraftMode.get("work_details"));
		LabWorkOrderEditPageActions.checkOtherInfo(addLWOInSubmittedToLabMode.get("other_info"));
		LabWorkOrderEditPageActions.checkItemSendDrpDwn();
		LabWorkOrderEditPageActions.addUpdateReason(addLWOInSubmittedToLabMode.get("updation_reason"));
		LabWorkOrderEditPageActions.checkedAdditionalDetailPanel();
		LabWorkOrderEditPageActions.getRequireDrpDwn(addLWOInPaymentCompletedMode.get("require"));
		LabWorkOrderEditPageActions.getStainsInternalDrpDwn(addLWOInSubmittedToLabMode.get("stains_internal"));
		LabWorkOrderEditPageActions.getStainsExternalDrpDwn(addLWOInSubmittedToLabMode.get("stains_external"));
		LabWorkOrderEditPageActions.getTranslucency(addLWOInPaymentCompletedMode.get("translucency"));
		LabWorkOrderEditPageActions.getTexture(addLWOInSubmittedToLabMode.get("texture"));
		LabWorkOrderEditPageActions.getNotes(addLWOInPaymentCompletedMode.get("notes"));
		LabWorkOrderEditPageActions.clickOnItemSend();
		LabWorkOrderEditPageActions.selectItemsSend(addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderEditPageActions.selectItemsSend(addLWOInTreatmentCompletedMode.get("item_sent"));
		LabWorkOrderEditPageActions.addFile(System.getProperty("user.dir")+"\\PatientFiles\\"+addLWOInPaymentCompletedMode.get("attach_name"));
		LabWorkOrderEditPageActions.selectRequire(addLWOInTreatmentCompletedMode.get("require"));
		LabWorkOrderEditPageActions.addTransluency(addLWOInTreatmentCompletedMode.get("translucency"));
		LabWorkOrderEditPageActions.addTexture(addLWOInPaymentCompletedMode.get("texture"));
		LabWorkOrderEditPageActions.enterNotes(addLWOInTreatmentCompletedMode.get("notes"));
		LabWorkOrderEditPageActions.clickSubmittedToLab();
		LabWorkOrderListingPageActions.verifySuccessfullMessageForRework();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkInActiveEntry(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("revision"),addLWOInPaymentCompletedMode.get("reason"));
		LabWorkOrderListingPageActions.checkInActiveRevisionReasonMainListForRework(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("revision"),addLWOInPaymentCompletedMode.get("reason"));
		LabWorkOrderListingPageActions.checkInActiveViewBtnForRework(addLWOInDraftMode.get("source"),addLWOInSubmittedToLabMode.get("revision"));
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkItemSentMainList(addLWOInDraftMode.get("source"), addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkItemSentMainList(addLWOInDraftMode.get("source"), addLWOInTreatmentCompletedMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"), addLWOInPaymentCompletedMode.get("revision"), addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"), addLWOInPaymentResubmitted.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkItemSentViewList(addLWOInSubmittedToLabMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkItemSentViewList(addLWOInTreatmentCompletedMode.get("item_sent"));
		LabWorkOrderListingPageActions.checkUpdationReasonViewList(addLWOInSubmittedToLabMode.get("updation_reason"));
		LabWorkOrderListingPageActions.checkRequireViewList(addLWOInTreatmentCompletedMode.get("require"));
		LabWorkOrderListingPageActions.checkTranslucencyViewList(addLWOInTreatmentCompletedMode.get("translucency"));
		LabWorkOrderListingPageActions.checkTextureViewList(addLWOInPaymentCompletedMode.get("texture"));
		LabWorkOrderListingPageActions.checkNotesViewList(addLWOInTreatmentCompletedMode.get("notes"));
		LabWorkOrderListingPageActions.checkAttachmentViewList(addLWOInPaymentCompletedMode.get("attach_name"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInTreatmentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPayable.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentResubmitted.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInTreatmentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPayable.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentResubmitted.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionNoViewList(addLWOInPaymentCompletedMode.get("revision_no"));
		LabWorkOrderListingPageActions.verifyRevisionDateInView(START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInPaymentResubmitted.get("status"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}

	/*
	 * Completed the retreated Trt and check status on LWO listing and View Screen
	 * Check in view current status shown as Payable Trt Completed
	 */
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled=true, priority=9)
	public void CompleteAboveReTreatTrtAndCheckLWOStatus() {
		logger.log(Status.PASS, COMPLETE_ABOVE_RETREAT_TRT_AND_CHECK_LAB_WORK_ORDER_STATUS);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.selectTime(addLWOInDraftMode.get("plan_Full_Name"), "15");
		WorksDonePageActions.enterRemarks(addLWOInDraftMode.get("plan_Full_Name"), "Complete Trt after ReTreat");
		WorksDonePageActions.selectStages(addLWOInDraftMode.get("plan_Full_Name"), "Cementation");
		WorksDonePageActions.clickOnAdd(addLWOInDraftMode.get("plan_Full_Name"));
		WorksDonePageActions.clickLWOBtnWD();
		BasePatientLifeCyclePageActions.headerOnAddPage("Lab Work Order Listing");
		LabWorkOrderListingPageActions.checkDateTimeMainList(addLWOInDraftMode.get("source"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkRevisionReasonMainList(addLWOInDraftMode.get("source"),addLWOInPaymentCompletedMode.get("revision"),addLWOInDraftMode.get("reason"));
		LabWorkOrderListingPageActions.checkStatusDateMainList(addLWOInDraftMode.get("source"),addLWOInPaymentTrtComplete.get("status"), START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkPrintBtn(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.clickOnView(addLWOInDraftMode.get("source"));
		LabWorkOrderListingPageActions.verifyHeaderInView("Lab Work Order");
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInDraftMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInSubmittedToLabMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInTreatmentCompletedMode.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPayable.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentResubmitted.get("status"));
		LabWorkOrderListingPageActions.checkStatusEnableInView(addLWOInPaymentTrtCompleted.get("status"));
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInDraftMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInSubmittedToLabMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInTreatmentCompletedMode.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPayable.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentResubmitted.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.verifyStatusInView(addLWOInPaymentTrtCompleted.get("status"),START_DATE_TIME, END_DATE_TIME);
		LabWorkOrderListingPageActions.checkCurrentStatusViewList(addLWOInPaymentTrtComplete.get("status"));
		LabWorkOrderListingPageActions.clickViewScreenClose();
		Assert.assertTrue(CommonPageActions.verification().contains("Lab Work Order Listing"));
	}
}
