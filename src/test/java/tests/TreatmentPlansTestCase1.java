package tests;

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
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.SheetTest;
import utils.TestData;

public class TreatmentPlansTestCase1 extends BaseClass{	

	/**
	 * Storing mandatory input required to run Treatment Plan test cases
	 * or please update the mandatory input before running the test cases
	 */
//	private static final String FILE_PATH = TestData.getInstance().getInputData("treatment_plan_file_path");
//	private static final String SHEET = TestData.getInstance().getInputData("treatment_plan_file_sheet_name");
	private static final String TODAY_DATE =TestData.getInstance().getTodayDate();
//	private static final String PATIENT_NAME= TestData.getInstance().getInputData("treatment_plan_patient_name");
//	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("treatment_plan_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("treatment_plan_doctor_name");
//	private static final String CLINIC_NAME = TestData.getInstance().getInputData("treatment_plan_clinic_name");

	/**
	 * Messages for every test cases which will be print on the extent report
	 */
	private static final String SCRIPTS_STARTED_MSG ="@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS ="@@ Test script has been completed @@";
	private static final String CHECK_UI_TREATMENT_PLAN_ADD_PAGE ="Validated Mandatory web element of treatment plan add Page - #checkUiTreatmentPlanAddPage";
	private static final String VERIFY_UI_OF_TEETH_FINDING_POPUP ="Validated Ui of teeth findings popup at treatment plan add page - #verifyUiOfTeethFindingPopup";
//	private static final String CHECKED_ORAL_EXAM_FROM_TREATMENT_POPUP ="Validated web element of oral exam in treatment plan Add page from teeth findings popup - #checkedOralExamFromTreatmentPopup";
	private static final String ADDING_TREATMENT_CHECK_IN_INPUT_AND_MAIN_LIST ="Validated Treatment After adding in input list,treatment list and treatment list view - #addingTreatmentCheckInInputAndMainList";
	private static final String VERIFY_VIEW_AND_EDIT_BTN ="Validated In View and In main list and After edit it reflect Everywhere - #verifyViewAndEditBtn";
	private static final String CHECK_FUNCTIONALITY_OF_INPUT_LIST_EDIT_BTN ="Validated functionality  of edit Btn in Input List - #checkEditInputList";
	private static final String CHECK_FUNCTIONALITY_OF_BOOK_BTN ="Validated funtionality of Book Btn - #checkFunctionalityOfBookBtn";
	private static final String CHECK_FUNTIONALITY_OF_PRINT_BTN ="Validated print Btn please verify where downloaded - #checkFuntionalityOfPrintBtn";
	private static final String CHECK_BEHAVIOUR_OF_SAVE_BTN_ON_INPUT_LIST ="Validated functionality Save btn in input list - #checkbehaviourOfSaveBtnOnInputList";
	private static final String CHECK_BEHAVIOUR_SELECTED_TREATMENT_TAB ="Validated functionality selected treatment tab - #checkBehaviourSelectedTreatmentTab";
	private static final String CHECK_ON_WORKDONE_PAGE_AFTER_TREATEMENT_START ="Validated workdone page after treatment starts- #checkOnWorkDonePageAfterTreatmentStart";
	private static final String VERIFY_DELETE_IN_TREATMENT_LIST ="Validated Delete Btn behaviour and Validated impact respectivily - #verifyDeleteInTreatmentList";

	Map<String, String> patntTrtmntPlanData = null;
	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		patntTrtmntPlanData = SheetTest.prepareData("Treatment&Plan","TreatmentPlans","A1","Z");
		
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(patntTrtmntPlanData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(patntTrtmntPlanData.get("patient_mobile"), patntTrtmntPlanData.get("patient_name"));
		PatientDashboardPageActions.hideDueWarningPopup();
		
	}



	/**
	 * loginPage with UserName and Password
	 * search for patients from the doctor dashboard
	 * verified patients will redirect at the patient dashboard
	 */
	
	@Test(groups = {"Regression","Functional"},enabled=true,description = "Verify UI of Treatment And Plans",priority=1)
	public void checkUiTreatmentPlanAddPage() {
		logger.log(Status.PASS, CHECK_UI_TREATMENT_PLAN_ADD_PAGE);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		TreatmentPlansPageActions.verifyHeader();
		TreatmentPlansPageActions.clickOnFindingsBtn();
//		TreatmentPlansPageActions.verifyNoRecordMsg();
		TreatmentPlansPageActions.verifyCreateBtnIsPresent();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		TreatmentPlansPageActions.clickOnNewTeethBtn();
		OralExamsPageActions.verifyAdultsTeeths();
		TreatmentPlansPageActions.allTeethByQuadrantAndByArchIsPresent();
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.verifyPedoTeeths();
		TreatmentPlansPageActions.allTeethAndByQuadrantIsPresent();
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.verifyMixedTeeths();
		TreatmentPlansPageActions.allTeethAndByQuadrantIsPresent();
//		TreatmentPlansPageActions.verifyProductAddBtnIsPresent();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyHeaderOfPage("Treatment Plan Listing");
       //TreatmentPlanListingPageActions.verifyNoRecordMsg();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
//		TreatmentPlansPageActions.verifyProductAddBtnIsPresent();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}
	
	/**
     * Check Teeth Findings All Plans Treatment Groups.
	 * Verification of plans based upon groups.
	 */

	@Test(groups = {"Regression","Functional"},enabled=true,description = "Verify UI of Teeth Finding Pop-up",priority=2)
	public void verifyUiOfTeethFindingPopup() {
		logger.log(Status.PASS, VERIFY_UI_OF_TEETH_FINDING_POPUP);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "43");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("43");
		TreatmentPlansPageActions.checkWebElementsOfPopup();
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnEndo();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnExtractions();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnMinorOralSurgery();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnProsthoExceptCrowns();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnCrowns();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnImplantCrowns();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnPerio();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnOrtho();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnAlignersLMB();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnAlignersOthers();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnImplantsAB();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnImplantsNobel();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnImplantOthers();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnBoneGraftAndMembranes();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnLasers();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnIpCDOPBank();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnMembership();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.clickOnOthers();
		TreatmentPlansPageActions.verifyTreatments();
		TreatmentPlansPageActions.closeTreatmentPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plans"));
	}
	
	/***This Test case is not in work as of now as Edit button is remove from Treatment Pop up Plan*/
	
//	@Test(enabled=false,priority=3)
//	public void checkedOralExamFromTreatmentPopup() {
//		logger.log(Status.PASS, CHECKED_ORAL_EXAM_FROM_TREATMENT_POPUP);
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		OralExamsPageActions.clickOnTeethImage("Adult", "24");
//		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
//		TreatmentPlansPageActions.clickOnOralExamBtn();
//		OralExamsPageActions.clickOnBuccal();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnDistal();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnMesial();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnOcclusal();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnPalatal();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnAllSurface();
//		TreatmentPlansPageActions.verifyProvisinals();
//		OralExamsPageActions.clickOnPerio();
//		TreatmentPlansPageActions.verifyProvisinals();
//		TreatmentPlansPageActions.verifyIoparBtn();
//		TreatmentPlansPageActions.clickOnIOPARBtn();
//		TreatmentPlansPageActions.verifyIOPARNotes();
//		OralExamsPageActions.verifyToothObservationRemark();
//		OralExamsPageActions.clickOnSoftTissueOnPopup();
//		TreatmentPlansPageActions.clickOnLip();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnCheek();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnTongue();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnFloorOfMouth();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnPalate();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnGingiva();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnVestibule();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnFrenum();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnSalivaryGland();
//		OralExamsPageActions.verifySoftProvisinals();
//		TreatmentPlansPageActions.clickOnLymphNodes();
//		OralExamsPageActions.verifySoftProvisinals();
//		OralExamsPageActions.verifyToothObservationRemark();
//		OralExamsPageActions.clickOnHardTissueInPopup();
//		OralExamsPageActions.clickOnMandibularAngle();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnMandibularBody();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnMaxillaryTuberosity();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnPosteriorMaxilla();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnPreMaxilla();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnMaxillarySinus();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnMandibularSymphysis();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.clickOnTMJoint();
//		OralExamsPageActions.verifyHardProvisionals();
//		OralExamsPageActions.verifyToothObservationRemark();
//		TreatmentPlansPageActions.clickOnCloseBtnOralExam();
//		TreatmentPlansPageActions.closeTreatmentPopup();
//		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plans"));
//	}

	@Test(groups = {"Smoke","Sanity","Regression","Functional"},enabled=true,description = "Add Treatment in the Listing & Verification of Listing Buttons",priority=2)
	public void addingTreatmentCheckInInputAndMainList() {
		logger.log(Status.PASS, ADDING_TREATMENT_CHECK_IN_INPUT_AND_MAIN_LIST);
		patntTrtmntPlanData = SheetTest.prepareData("Treatment&Plan","TreatmentPlans","A1","Z");
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan2"));
		TreatmentPlansPageActions.saveTreatment();
    	BasePatientLifeCyclePageActions.clickOnAlert();
    	TreatmentPlansPageActions.checkedInputListDataName();
    	TreatmentPlansPageActions.intiallyBothPriceSameDiscount(patntTrtmntPlanData.get("planGroup1_Plan1"));
    	TreatmentPlansPageActions.intiallyBothPriceSameDiscount(patntTrtmntPlanData.get("planGroup1_Plan2"));
		TreatmentPlansPageActions.checkEditSaveInputList("24");
		TreatmentPlansPageActions.checkDeleteInputList("24");
		//-------checking checkbox at input list and start button main list-------
		
//		TreatmentPlansPageActions.startCheckBoxInputListNotPresent(); 
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
//      TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE); 
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppList();
        AppointmentsListPageActions.appointmentAvailable();
		BasePatientLifeCyclePageActions.clickOnDashBoard(); 
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown("Mohit Raoo");
		AppointmentAddPageActions.selectReferralFromDropdown("Patient");
		AppointmentAddPageActions.referralDetails();
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan2"));
		//--checking in finding-----
		TreatmentPlansPageActions.clickOnFindingsBtn();
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan2"));
		TreatmentPlansPageActions.verifyNoRecordMsg();
		//-checking treatment plan listing -------------
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();//
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList(); 
		TreatmentPlanListingPageActions.checkedDataNameMainList();
		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"),patntTrtmntPlanData.get("companyName"));
		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"),patntTrtmntPlanData.get("companyName"));
		//---------checking respective actions Btn& Please pass current date in format of "dd-MM-YY"
		TreatmentPlanListingPageActions.verifyCopyBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyStartBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyMarkBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyEditBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyDeleteBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyPrintBtn(TODAY_DATE);
		//----------check treatment in treatment list view--------//
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.verifyHeaderInViewPopup("Treatment Plan View");
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}
	
//	@Test(groups = {"Regression","Functional"},enabled=true,priority=5,description = "Verify View Edit & Delete Single Treatment",dependsOnMethods="addingTreatmentCheckInInputAndMainList")
	@Test(groups = {"Regression","Functional"},enabled=true,priority=5,description = "Verify View Edit & Delete Single Treatment")
	public void verifyViewAndEditBtn() {
		logger.log(Status.PASS, VERIFY_VIEW_AND_EDIT_BTN);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		//---verify delete Btn and also delete the Treatment from input list
		TreatmentPlansPageActions.deleteTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlansPageActions.clickOnYesForDelete();
		TreatmentPlansPageActions.verifyDeleteSuccessMsg();
		TreatmentPlansPageActions.verifyAfterDelete(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		//--verify deleted treatment in treatment listing page and also in view PopUp
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();//
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}
	
//   @Test(groups = {"Regression","Functional","Sanity"},enabled=true,priority=6,description = "Verify Edit And Add New Treatment Along With Old",dependsOnMethods="verifyViewAndEditBtn")
	@Test(groups = {"Regression","Functional","Sanity"},enabled=true,priority=6,description = "Verify Edit And Add New Treatment Along With Old")
	public void checkEditInputList() {
		logger.log(Status.PASS, CHECK_FUNCTIONALITY_OF_INPUT_LIST_EDIT_BTN);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.clickOnEditBtnTreatmentInputList();
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan1"));
		TreatmentPlansPageActions.saveTreatment();
     	TreatmentPlansPageActions.verifyAfterDelete(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		//--checking in finding-----
		TreatmentPlansPageActions.clickOnFindingsBtn();
		TreatmentPlansPageActions.verifyAfterDelete(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlansPageActions.selectedTreamentInIputList(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		TreatmentPlansPageActions.verifyNoRecordMsg();
		//-checking treatment plan listing -------------
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"),patntTrtmntPlanData.get("companyName"));
		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"),patntTrtmntPlanData.get("companyName"));
		//--checking in view popup on treatment plan list--
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}
	
//	@Test(groups = {"Regression"},enabled=true,priority=7,description = "Mark The Treatment As Patient Preferred",dependsOnMethods="addingTreatmentCheckInInputAndMainList")
	@Test(groups = {"Regression"},enabled=true,priority=7,description = "Mark The Treatment As Patient Preferred")
	public void checkFunctionalityOfMarkBtn() {
		logger.log(Status.PASS, CHECK_FUNCTIONALITY_OF_BOOK_BTN);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnMarkBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyMarkedMsg();
		TreatmentPlanListingPageActions.verifyAfterMarked(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.verifyUnbookBtn(TODAY_DATE);
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
		BaseClass.softAssert().assertAll();
	}
	

	@Test(groups = {"Regression"},enabled=true,priority=8,description = "Check Functionality For Print Button",dependsOnMethods="addingTreatmentCheckInInputAndMainList")
	public void checkFunctionalityPrintBtn() {
		logger.log(Status.PASS, CHECK_FUNTIONALITY_OF_PRINT_BTN);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.clickOnPrintBtn(TODAY_DATE);
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}

	@Test(groups = {"Regression"},enabled=true,priority=9,description = "Behaviour of Selected Treatment Selction/Deselection")
	public void checkBehaviourSelectedTreatmentTab() {
		logger.log(Status.PASS, CHECK_BEHAVIOUR_SELECTED_TREATMENT_TAB);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "25");
		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("25");
		//----selecting treatment here
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup1_Plan2"));
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan1"));
		TreatmentPlansPageActions.clickOnTreatments(patntTrtmntPlanData.get("planGroup2_Plan2"));
		TreatmentPlansPageActions.clickOnSelectedTreatment();
		//---deselecting treatment from selected treatment tab
		TreatmentPlansPageActions.removeTreatmentFromSelectedTreatmentTab(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlansPageActions.removeTreatmentFromSelectedTreatmentTab(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlansPageActions.removeTreatmentFromSelectedTreatmentTab(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		TreatmentPlansPageActions.removeTreatmentFromSelectedTreatmentTab(patntTrtmntPlanData.get("planGroup2_Plan2_FullName"));
		//-----verify treatment is deselected from treatment groups
		TreatmentPlansPageActions.clickOnTreatmentGroups();
		TreatmentPlansPageActions.clickOnConsultationXRays();
		TreatmentPlansPageActions.deselectedTreatment(patntTrtmntPlanData.get("planGroup1_Plan1"));
		TreatmentPlansPageActions.deselectedTreatment(patntTrtmntPlanData.get("planGroup1_Plan2"));
		TreatmentPlansPageActions.clickOnPedo();
		TreatmentPlansPageActions.deselectedTreatment(patntTrtmntPlanData.get("planGroup2_Plan1"));
		TreatmentPlansPageActions.deselectedTreatment(patntTrtmntPlanData.get("planGroup2_Plan2"));
		TreatmentPlansPageActions.saveTreatmentWithMessage();
		TreatmentPlansPageActions.verifyWithoutTreatmentMsg();
		TreatmentPlansPageActions.closeTreatmentPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plans"));
	}

	@Test(groups = {"Regression","Sanity","Functional"},enabled=true,priority=10,dependsOnMethods="addingTreatmentCheckInInputAndMainList")
	public void checkBehaviourOfSaveBtnOnInputList() {
		logger.log(Status.PASS, CHECK_BEHAVIOUR_OF_SAVE_BTN_ON_INPUT_LIST);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
		/*--below is written for Admin loginPage -*/
	  /*TreatmentPlanListingPageActions.verifyHeaderOfDoctorListPopup();
		TreatmentPlanListingPageActions.selectDoctor("Amit Bhatia");
		TreatmentPlanListingPageActions.clickOnSaveBtnInDoctorList();*/
		Assert.assertTrue(CommonPageActions.verification().contains("Works Done"));
	}
	
	@Test(groups = {"Regression","Sanity","Functional"},enabled=true,priority=11)
	public void checkOnWorkDonePageAfterTreatmentStart() {
		logger.log(Status.PASS, CHECK_ON_WORKDONE_PAGE_AFTER_TREATEMENT_START);
		
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnWorkDoneAdd();
		BasePatientLifeCyclePageActions.headerOnAddPage("Works Done");
		WorksDonePageActions.checkDateTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkSourceNo(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "24");
		WorksDonePageActions.checkedStatusTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "Started");
		WorksDonePageActions.checkProgressDropDown(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkSuspededBtn(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkDataName(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkBox(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.modifiedDate(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorksDonePageActions.checkDoctorSelected(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), patntTrtmntPlanData.get("doctor"));
		WorksDonePageActions.checkedClinic(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), patntTrtmntPlanData.get("clinicLocation"));
		WorksDonePageActions.checkTimeSelected(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "Select Time");
		WorksDonePageActions.checkedRemarks(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorksDonePageActions.checkedAddButton(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		/*-------------workdone history check all data-----------------*/
		WorksDonePageActions.clickWorkDoneHistory();
		WorkDoneHistoryPageActions.checkedInvoiceListBtn();
		WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
		WorkDoneHistoryPageActions.checkedPrintBtn();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		WorkDoneHistoryPageActions.checkDateTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkSourceNo(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "24");
		WorkDoneHistoryPageActions.checkedStatusTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "In-Progress");
		WorkDoneHistoryPageActions.checkDataName(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		WorkDoneHistoryPageActions.modifiedDate(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), TODAY_DATE);
		WorkDoneHistoryPageActions.checkDoctorTreated(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), patntTrtmntPlanData.get("doctor"));
		WorkDoneHistoryPageActions.checkedClinic(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), patntTrtmntPlanData.get("clinicLocation"));
		WorkDoneHistoryPageActions.checkSpentTime(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "15");
		WorkDoneHistoryPageActions.checkStageTreatment(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "Started");
		WorkDoneHistoryPageActions.checkPrintButtonDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Work Done History"));
	}
	

	@Test(groups = {"Regression","Sanity","Functional"},enabled=true,priority=12,description = "Delete The Added Treatment And Verification",dependsOnMethods="addingTreatmentCheckInInputAndMainList")
	public void verifyDeleteInTreatmentList() {
		logger.log(Status.PASS, VERIFY_DELETE_IN_TREATMENT_LIST);
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.clickOnDeleteBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.clickOnYesBtnForDelete();
		TreatmentPlanListingPageActions.verifyDeleteSuccessMsg();
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.checkNotDeletedTreatment(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentList(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		TreatmentPlanListingPageActions.verifyViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyPrintBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.notDeletedTreatmentInView(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.verifyAfterDeleteInTreatmentListViewPopup(patntTrtmntPlanData.get("planGroup2_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
	}
}
