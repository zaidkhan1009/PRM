package tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
import pageActions.patientDashboard.LabWorkOrderEditPageActions;
import pageActions.patientDashboard.LabWorkOrderListingPageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.SheetTest;
import utils.TestData;

public class TreatmentPlansTestCase2 extends BaseClass{

	/*please give the input before the execution of test cases and date format should be "dd-MM-yy" */
//	private static final String FILE_PATH = TestData.getInstance().getInputData("treatment_plan_file_path");
//	private static final String SHEET = TestData.getInstance().getInputData("treatment_plan_file_sheet_name");
	private static final String TODAY_DATE = TestData.getInstance().getTodayDate();
//	private static final String PATIENT_NAME= TestData.getInstance().getInputData("treatment_plan_patient_name");
//	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("treatment_plan_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("treatment_plan_doctor_name");
//	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("treatment_plan_doctor_nikName");
//	private static final String CLINIC_NAME = TestData.getInstance().getInputData("treatment_plan_clinic_name");

	/*Messages for the extent report*/

	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
//	private static final String CREATE_ORAL_EXAM_SINGLE_TEETH = "Validated add oral Exam for single teeth and checked in findings - #createOralExamSingleTeeth";
//	private static final String CREATE_ORAL_EXAM_MULTIPLE_TEETH = "Validated add oral Exam for multiple teeth and checked in findings - #createOralExamMultipleTeeth";
//	private static final String START_TREATMENT_FROM_FINDINGS = "Validated Add Treatment By selecting findings and check in main list and view - #addTreatmentFromFindings";
	private static final String FUNCTIONALITY_OF_START_BTN = "Checking the functionality of discount coupon - #functionalityOfStartBtn";
	private static final String FUNCTIONALITY_OF_COPY_BTN = "Validated functionality of copy Btn - #functionalityOfCopyBtn";
	private static final String FUNCTIONALITY_OF_DISCOUNT = "Checking the functionality of discount coupon - #functionalityOfDiscount";
	private static final String ADDING_TREATMENT_CHECK_IN_INPUT ="Validated Treatment After adding in input list";
	Map<String, String> patntTrtmntPlanData = null;
	
	@BeforeClass(alwaysRun = true)
	public void testSetup() {
		patntTrtmntPlanData = SheetTest.prepareData("Treatment&Plan","TreatmentPlans","A1","Z");
		CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(patntTrtmntPlanData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(patntTrtmntPlanData.get("patient_mobile"),patntTrtmntPlanData.get("patient_name"));
		PatientDashboardPageActions.hideDueWarningPopup();
	}

	@Test(enabled=true,description = "Add Treatment in the Listing",priority=1)
	public void addingTreatmentCheckInInputAndMainList() {
		logger.log(Status.PASS, ADDING_TREATMENT_CHECK_IN_INPUT);
		
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
		TreatmentPlansPageActions.startCheckBoxInputListNotPresent();
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

	@Test(enabled = true,description = "Check The Functionality of Start Button",priority = 2)
	public void functionalityOfStartBtn() {
		logger.log(Status.PASS, FUNCTIONALITY_OF_START_BTN);
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.appointmentAvailable();
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
//		TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE);
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppAdd();
		AppointmentAddPageActions.selectDoctorFromDropdown(DOCTOR_NAME);
		AppointmentAddPageActions.clickOnSaveBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnAppList();
		AppointmentsListPageActions.appointmentAdded();
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}
	
	/*ORAL EXAM NOW PART OF PATIENT DASHBOARD*/

//	@Test(enabled = true,priority = 2)
//	public void createOralExamSingleTeeth() {
//		logger.log(Status.PASS, CREATE_ORAL_EXAM_SINGLE_TEETH);
//		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		OralExamsPageActions.clickOnTeethImage("Adult", "23");
//		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("23");
//		TreatmentPlansPageActions.clickOnOralExamBtn();
//		// ------
//		OralExamsPageActions.clickOnBuccal();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		OralExamsPageActions.clickOnSoftTissueOnPopup();
//		TreatmentPlansPageActions.clickOnLip();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		OralExamsPageActions.clickOnHardTissueInPopup();
//		OralExamsPageActions.clickOnMandibularBody();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		OralExamsPageActions.enterOralExamNotes("it is for testig");
//		TreatmentPlansPageActions.clickOnSaveOralBtn();
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		TreatmentPlansPageActions.closeTreatmentPopup();
//		TreatmentPlansPageActions.clickOnFindingsBtn();
//		TreatmentPlansPageActions.verifyToothOnFinding("23");
//		TreatmentPlansPageActions.verifyTissuesInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 1));
//		TreatmentPlansPageActions.verifyTissuesInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 1));
//		TreatmentPlansPageActions.verifyTissuesInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 1));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("23", ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		TreatmentPlansPageActions.verifySelectBtn("23");
//		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plans"));
//	}

//	@Test(enabled = true,priority = 3)
//	public void createOralExamMultipleTeeth() {
//		logger.log(Status.PASS, CREATE_ORAL_EXAM_MULTIPLE_TEETH);
//		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		TreatmentPlansPageActions.clickOnNewTeethBtn();
//		OralExamsPageActions.selectMultipleTeeth("Mixed", "18");
//		OralExamsPageActions.selectMultipleTeeth("Mixed", "22");
//		OralExamsPageActions.selectMultipleTeeth("Mixed", "21");
//		OralExamsPageActions.clickOnTeethImage("Mixed", "21");
//		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("18");
//		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("22");
//		TreatmentPlansPageActions.verifySeletecdTeethOnPopup("21");
//		TreatmentPlansPageActions.clickOnOralExamBtn();
//		// ----------
//		TreatmentPlansPageActions.clickOnBuccalForMultipleTeeth();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		OralExamsPageActions.clickOnSoftTissueOnPopup();
//		TreatmentPlansPageActions.clickOnLip();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		OralExamsPageActions.clickOnHardTissueInPopup();
//		OralExamsPageActions.clickOnMandibularBody();
//		TreatmentPlansPageActions.clickOnProvisionals(ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		OralExamsPageActions.enterOralExamNotes("it is for testig");
//		TreatmentPlansPageActions.clickOnSaveOralBtn();
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		TreatmentPlansPageActions.verifySelectedProvisinalsIntreatmentPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		TreatmentPlansPageActions.closeTreatmentPopup();
//		TreatmentPlansPageActions.clickOnFindingsBtn();
//		TreatmentPlansPageActions.verifyToothOnFinding("18");
//		TreatmentPlansPageActions.verifyTissuesInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 1));
//		TreatmentPlansPageActions.verifyTissuesInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 1));
//		TreatmentPlansPageActions.verifyTissuesInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 1));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 11, 2));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 12, 2));
//		TreatmentPlansPageActions.verifyProvisionalsInFinding("18", ReadExcelData.readExcelData(FILE_PATH, SHEET, 13, 2));
//		TreatmentPlansPageActions.verifySelectBtn("18");
//		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plans"));
//	}

//	@Test(enabled = true,priority = 4, dependsOnMethods = { "createOralExamSingleTeeth","createOralExamMultipleTeeth" })
//	public void addTreatmentFromFindings() {
//		logger.log(Status.PASS, START_TREATMENT_FROM_FINDINGS);
//		PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		TreatmentPlansPageActions.selectTeethInFindings("23");
//		TreatmentPlansPageActions.selectTeethInFindings("18");
//		TreatmentPlansPageActions.clickOnCreatebtn();
//		TreatmentPlansPageActions.clickOnConsultationXRays();
//		TreatmentPlansPageActions.clickOnTreatments(ReadExcelData.readExcelData(FILE_PATH, SHEET, 1, 1));
//		TreatmentPlansPageActions.clickOnTreatments(ReadExcelData.readExcelData(FILE_PATH, SHEET, 2, 1));
//		TreatmentPlansPageActions.saveTreatment();
//		TreatmentPlansPageActions.selectedTreamentInIputList(ReadExcelData.readExcelData(FILE_PATH, SHEET, 1, 2));
//		TreatmentPlansPageActions.selectedTreamentInIputList(ReadExcelData.readExcelData(FILE_PATH, SHEET, 1, 2));
//		// -checking treatment plan listing -------------
//		BasePatientLifeCyclePageActions.clickOnDashBoard();
//		BasePatientLifeCyclePageActions.clickOnAlert();
//		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
//		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
//		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(ReadExcelData.readExcelData(FILE_PATH, SHEET, 1, 2),ReadExcelData.readExcelData(FILE_PATH, SHEET, 1,3));
//		TreatmentPlanListingPageActions.selectedTreatmentInTreatmentList(ReadExcelData.readExcelData(FILE_PATH, SHEET, 2, 2),ReadExcelData.readExcelData(FILE_PATH, SHEET, 2,3));
//		// ---------checking respective actions Btn& Please pass current date in format
//		// of "dd-MM-YY"
//		TreatmentPlanListingPageActions.verifyCopyBtn(TODAY_DATE);
//		// TreatmentPlanListingPageActions.verifyStartBtn(todayDate);
//		TreatmentPlanListingPageActions.verifyMarkBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.verifyViewBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.verifyEditBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.verifyDeleteBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.verifyPrintBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
//		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 1, 2));
//		TreatmentPlanListingPageActions.verifyTreatmentInViewPopup(ReadExcelData.readExcelData(FILE_PATH, SHEET, 2, 2));
//		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
//		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
//	}

//   @Test(enabled = true,priority = 3,description = "Check the Discount Functionality",dependsOnMethods = "addingTreatmentCheckInInputAndMainList")
	   @Test(enabled = true,priority = 3,description = "Check the Discount Functionality")
	public void functionalityOfDiscount() {
		logger.log(Status.PASS, FUNCTIONALITY_OF_DISCOUNT);
		
		PatientDashboardPageActions.hideDueWarningPopup();
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.intiallyBothPriceSameDiscount(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlansPageActions.discountInPercentage(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlansPageActions.enterDiscountValue(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), "20");
		TreatmentPlansPageActions.checkFunctionalityOfPercentageDis(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"), 20);
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlansPageActions.verifyMsgWithoutCoupon();
		TreatmentPlansPageActions.couponBasis(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyCouponImpactInMainList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.couponDiscountInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		TreatmentPlanListingPageActions.clickOnEditBtn(TODAY_DATE);
		TreatmentPlansPageActions.discountInAmount(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlansPageActions.enterDiscountValue(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"), "20");
		TreatmentPlansPageActions.checkFunctionalityOfAmountDis(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"), 20);
		TreatmentPlansPageActions.couponBasis(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlansPageActions.clickOnSaveBtnTreatmentInputList();
		TreatmentPlanListingPageActions.verifyCouponImpactInMainList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnViewBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.couponDiscountInViewPopup(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.clickOnCloseBtnViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}

//    @Test(enabled = true,priority = 4, dependsOnMethods = "addingTreatmentCheckInInputAndMainList")
	    @Test(enabled = true,priority = 4)
	public void functionalityOfCopyBtn() {
		logger.log(Status.PASS, FUNCTIONALITY_OF_COPY_BTN);
		PatientDashboardPageActions.hideDueWarningPopup();
		
		PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
		TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
		TreatmentPlanListingPageActions.clickOnCopyBtn(TODAY_DATE);
		TreatmentPlanListingPageActions.actionBtn();
		TreatmentPlanListingPageActions.afterCopyTreatmentInMainList(patntTrtmntPlanData.get("planGroup1_Plan1_FullName"));
		TreatmentPlanListingPageActions.afterCopyTreatmentInMainList(patntTrtmntPlanData.get("planGroup1_Plan2_FullName"));
		TreatmentPlanListingPageActions.afterCopyPlan();
		Assert.assertTrue(CommonPageActions.verification().contains("Treatment Plan Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
	}
}
