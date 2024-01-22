package tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.DiagnosticListingPageActions;
import pageActions.patientDashboard.DiagnosticTestsPageActions;
import utils.SheetTest;
import utils.TestData;

public class DiagnosticTestsTestCase extends BaseClass {

	/*Mandatory inputs required before execution report*/
	private static final String PATIENT_NAME= TestData.getInstance().getInputData("diagnostic_test_patient_name");
	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("diagnostic_test_patient_mobile");
	private static final String DOCTOR_NAME = TestData.getInstance().getInputData("diagnostic_test_doctor_name");
	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("diagnostic_test_doctor_nikName");
	private static final String CLINIC_NAME = TestData.getInstance().getInputData("diagnostic_test_clinic_name");


	/*-----------------------Messages for Extent Report---------------------------------*/
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String CHECKED_DIAGNOSTICS_ADD_UI = "Validating the Diagnosis Add page and Diagnosis listing page for first time without any diagnosis - #checkedDiagnosticsAddUi";
	private static final String ADD_DIAGNOSTICS = "Validating the Diagnosis Add page and Diagnosis listing page after adding a diagnosis - #addDiagnostics";
	Map<String, String> patntDiagnosticData = null;

	@BeforeTest
	public void testSetup() {	
		patntDiagnosticData = SheetTest.prepareData("DiagnosticData","Diagnostic","A2","E2");
	}

	
	@Test(groups = {"Regression"},priority = 1)
	public void checkedDiagnosticsAddUi() {
		logger.log(Status.PASS, CHECKED_DIAGNOSTICS_ADD_UI);
		CommonPageActions.backTODoctorDashboard();
		//DoctorDashBoardPageActions.doctorDashboardHomePage();
		CommonPageActions.selectClinicFrmHeader(patntDiagnosticData.get("clinicLocation"));
		CommonPageActions.enterMobileNo(patntDiagnosticData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntDiagnosticData.get("patient_mobile"),patntDiagnosticData.get("patient_name"));
		PatientDashboardPageActions.clickOnDiagnosticsTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.verifyPatientName(patntDiagnosticData.get("patient_name"));
		BasePatientLifeCyclePageActions.headerOnAddPage("Diagnostic Tests");
		DiagnosticTestsPageActions.checked_Trt_oralExam_file_Btn();
		DiagnosticTestsPageActions.checkedDiagnosisBox();
		/*-----------------iopar Ui------------------------*/
		DiagnosticTestsPageActions.clickIopar();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> IOPAR");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedAdultSelected();
		DiagnosticTestsPageActions.checkedAdultTeeths();
		DiagnosticTestsPageActions.clickPedo();
		DiagnosticTestsPageActions.checkedPedoSelected();
		DiagnosticTestsPageActions.checkedPedoTeeths();
		DiagnosticTestsPageActions.clickMixed();
		DiagnosticTestsPageActions.checkedMixedSelected();
		DiagnosticTestsPageActions.checkedMixedTeeths();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*----------------Imaging ui--------------*/
		DiagnosticTestsPageActions.clickImaging();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> Imaging");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedImagingDiagnosis();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*--------------Blood ui-------------------*/
		DiagnosticTestsPageActions.clickBlood();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> Blood");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedBloodDiagnosis();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*---------------Urine ui-----------------*/
		DiagnosticTestsPageActions.clickUrine();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> Urine");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedUrineDiagnosis();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*----------------Bio-chemical ui------------*/
		DiagnosticTestsPageActions.clickBiochemicalButton();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> Biochemical");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedBioChemicalDiagnosis();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*---------------Markers ui------------------*/
		DiagnosticTestsPageActions.clickMarkersButton();
		DiagnosticTestsPageActions.checkedDiagnosisHeader("Diagnosis >> Markers");
		DiagnosticTestsPageActions.checked_Save_Close_Notes();
		DiagnosticTestsPageActions.checkedMarkersDiagnosis();
		DiagnosticTestsPageActions.closeDiagnosisPopup();
		/*--------------Diagnosis listing----------------*/
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnDiagnosticsTestList();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnListPage("Diagnostic Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(patntDiagnosticData.get("patient_name"));
		/* First Time Only */
//		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Diagnostic Listing"));
		CommonPageActions.backTODoctorDashboard();
	}

	/*Added Diagnosis for the IOPAR and Imaging
	* checked same added diagnosis at input list
	* checked the same diagnosis at the Diagnosis listing and diagnosis listing view*/
	
	@Test(groups = {"Smoke","Sanity","Functional","Regression"},priority = 2)
	public void addDiagnostics() {
		logger.log(Status.PASS, ADD_DIAGNOSTICS);

		CommonPageActions.selectClinicFrmHeader(patntDiagnosticData.get("clinicLocation"));
		CommonPageActions.enterMobileNo(patntDiagnosticData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntDiagnosticData.get("patient_mobile"),patntDiagnosticData.get("patient_name"));

		PatientDashboardPageActions.clickOnDiagnosticsTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		/*-------------------adding iopar---------------*/
		DiagnosticTestsPageActions.clickIopar();
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.withoutIoparAlert();
		DiagnosticTestsPageActions.selectTeeth("adult", "32");
		DiagnosticTestsPageActions.enterDiagnosisNotes("iopar testing");
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.checkedSuccessAlert();
		/*-------------------adding imaging------------*/
		DiagnosticTestsPageActions.clickImaging();
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.withoutDiagnosisAlert();
		DiagnosticTestsPageActions.selectDiagnosis("OPG");
		DiagnosticTestsPageActions.enterDiagnosisNotes("Imaging testing");
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.checkedSuccessAlert();
		/*-------------------checked iopar in inputlist-------*/
		DiagnosticTestsPageActions.checkedDiagnosisInputListData();
		DiagnosticTestsPageActions.checkedCategory("IOPAR");
		DiagnosticTestsPageActions.checkedInvestigation("IOPAR", "32");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("IOPAR", "32");
		DiagnosticTestsPageActions.notesDiagnosisInputList("IOPAR", "32", "iopar testing");
		DiagnosticTestsPageActions.checkedDeleteBtnInputlist("IOPAR");
		DiagnosticTestsPageActions.checkedEditBtnInputlist("IOPAR");
		/*-------------------checked imaging in inputlist-----*/
		DiagnosticTestsPageActions.checkedCategory("Imaging");
		DiagnosticTestsPageActions.checkedInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.notesDiagnosisInputList("Imaging", "OPG", "Imaging testing");
		DiagnosticTestsPageActions.checkedDeleteBtnInputlist("Imaging");
		DiagnosticTestsPageActions.checkedEditBtnInputlist("Imaging");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnDiagnosticsTestList();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.verifyPatientName(patntDiagnosticData.get("patient_name"));
		DiagnosticListingPageActions.checkedDataName();
		DiagnosticListingPageActions.checkedDiagnosisMainList("Imaging");
		DiagnosticListingPageActions.investigationMainList("Imaging", "OPG");
		DiagnosticListingPageActions.createdByMainList("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesByMainList("Imaging", "Imaging testing");
		DiagnosticListingPageActions.checkedDiagnosisMainList("IOPAR");
		DiagnosticListingPageActions.investigationMainList("IOPAR", "32");
		DiagnosticListingPageActions.createdByMainList("IOPAR", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesByMainList("IOPAR", "iopar testing");
		BasePatientLifeCyclePageActions.clickViewBtn(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.headerViewPopup("Diagnostics View");
		DiagnosticListingPageActions.checkedDataNameViewPopup();
		DiagnosticListingPageActions.verifyPatientNameInView(patntDiagnosticData.get("patient_name"));		
		DiagnosticListingPageActions.verifyDateInView();
		DiagnosticListingPageActions.checkDiagnosisViewPopup("Imaging");
		DiagnosticListingPageActions.investigationView("Imaging", "OPG");
		DiagnosticListingPageActions.createdByView("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesView("Imaging", "Imaging testing");
		DiagnosticListingPageActions.checkDiagnosisViewPopup("IOPAR");
		DiagnosticListingPageActions.investigationView("IOPAR", "32");
		DiagnosticListingPageActions.createdByView("IOPAR", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesView("IOPAR", "iopar testing");
		BasePatientLifeCyclePageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Diagnostic Listing"));
		BaseClass.softAssert().assertAll();
		CommonPageActions.backTODoctorDashboard();
	}

	/*Added Diagnosis for the IOPAR and Imaging
	* checked same added diagnosis at input list
	* checked the same diagnosis at the Diagnosis listing and diagnosis listing view*/
	
	@Test(groups = {"Functional","Regression"},priority = 3)
	public void editDiagnostics() {
		logger.log(Status.PASS, ADD_DIAGNOSTICS);
		CommonPageActions.selectClinicFrmHeader(patntDiagnosticData.get("clinicLocation"));
		CommonPageActions.enterMobileNo(patntDiagnosticData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntDiagnosticData.get("patient_mobile"),patntDiagnosticData.get("patient_name"));
		PatientDashboardPageActions.clickOnDiagnosticsTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		DiagnosticTestsPageActions.clickEditBtnInputlist("Imaging");
		DiagnosticTestsPageActions.checkSelectedInvestigation("OPG");
		DiagnosticTestsPageActions.verifyEnteredDiagnosisNotes();
		DiagnosticTestsPageActions.selectDiagnosis("CBCT");
		DiagnosticTestsPageActions.enterDiagnosisNotes(" CBCT Notes");
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.checkedUpdateSuccessAlert();
		/*-------------------checked Imaging in Input list-------*/
		DiagnosticTestsPageActions.checkedDiagnosisInputListData();
		DiagnosticTestsPageActions.checkedCategory("Imaging");
		DiagnosticTestsPageActions.checkedInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.checkedInvestigation("Imaging", "CBCT");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("Imaging", "CBCT");
		DiagnosticTestsPageActions.notesDiagnosisInputList("Imaging", "OPG", "Imaging testing CBCT Notes");
		DiagnosticTestsPageActions.checkedDeleteBtnInputlist("Imaging");
		DiagnosticTestsPageActions.checkedEditBtnInputlist("Imaging");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		/*-------------------checked Imaging in Main list-------*/
		PatientDashboardPageActions.clickOnDiagnosticsTestList();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.verifyPatientName(patntDiagnosticData.get("patient_name"));
		DiagnosticListingPageActions.checkedDataName();
		DiagnosticListingPageActions.checkedDiagnosisMainList("Imaging");
		DiagnosticListingPageActions.investigationMainList("Imaging", "OPG");
		DiagnosticListingPageActions.investigationMainList("Imaging", "CBCT");
		DiagnosticListingPageActions.createdByMainList("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesByMainList("Imaging", "Imaging testing CBCT Notes");
		BasePatientLifeCyclePageActions.clickViewBtn(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.headerViewPopup("Diagnostics View");
		DiagnosticListingPageActions.checkedDataNameViewPopup();
		DiagnosticListingPageActions.verifyPatientNameInView(patntDiagnosticData.get("patient_name"));
		DiagnosticListingPageActions.verifyDateInView();
		DiagnosticListingPageActions.checkDiagnosisViewPopup("Imaging");
		DiagnosticListingPageActions.investigationView("Imaging", "OPG");
		DiagnosticListingPageActions.investigationView("Imaging", "CBCT");
		DiagnosticListingPageActions.createdByView("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesView("Imaging", "Imaging testing CBCT Notes");
		BasePatientLifeCyclePageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Diagnostic Listing"));
		BaseClass.softAssert().assertAll();
		CommonPageActions.backTODoctorDashboard();
	}
	
	/*Deleted Diagnosis for the IOPAR and Imaging
	* checked same added diagnosis at input list
	* checked the same diagnosis at the Diagnosis listing and diagnosis listing view*/
	
	@Test(groups = {"Functional","Regression"},priority = 4)
	public void deleteDiagnostics() {
		logger.log(Status.PASS, ADD_DIAGNOSTICS);
		CommonPageActions.backTODoctorDashboard();
		CommonPageActions.selectClinicFrmHeader(patntDiagnosticData.get("clinicLocation"));
		CommonPageActions.enterMobileNo(patntDiagnosticData.get("patient_mobile"));
		CommonPageActions.clickOnSearchBtn();
		CommonPageActions.clickOnPatient(patntDiagnosticData.get("patient_mobile"),patntDiagnosticData.get("patient_name"));
		PatientDashboardPageActions.clickOnDiagnosticsTestAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		DiagnosticTestsPageActions.clickEditBtnInputlist("Imaging");
		DiagnosticTestsPageActions.checkSelectedInvestigation("OPG");
		DiagnosticTestsPageActions.verifyEnteredDiagnosisNotes();
		DiagnosticTestsPageActions.selectDiagnosis("CBCT");
		DiagnosticTestsPageActions.enterDiagnosisNotes(" CBCT Notes");
		DiagnosticTestsPageActions.saveDiagnosis();
		DiagnosticTestsPageActions.checkedUpdateSuccessAlert();
		/*-------------------checked Imaging in Input list-------*/
		DiagnosticTestsPageActions.checkedDiagnosisInputListData();
		DiagnosticTestsPageActions.checkedCategory("Imaging");
		DiagnosticTestsPageActions.checkedInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.checkedInvestigation("Imaging", "CBCT");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("Imaging", "OPG");
		DiagnosticTestsPageActions.checkedDeleteWithInvestigation("Imaging", "CBCT");
		DiagnosticTestsPageActions.notesDiagnosisInputList("Imaging", "OPG", "Imaging testing CBCT Notes");
		DiagnosticTestsPageActions.checkedDeleteBtnInputlist("Imaging");
		DiagnosticTestsPageActions.checkedEditBtnInputlist("Imaging");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		/*-------------------checked Imaging in Main list-------*/
		PatientDashboardPageActions.clickOnDiagnosticsTestList();
		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.actionBtnMainList(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.verifyPatientName(patntDiagnosticData.get("patient_name"));
		DiagnosticListingPageActions.checkedDataName();
		DiagnosticListingPageActions.checkedDiagnosisMainList("Imaging");
		DiagnosticListingPageActions.investigationMainList("Imaging", "OPG");
		DiagnosticListingPageActions.investigationMainList("Imaging", "CBCT");
		DiagnosticListingPageActions.createdByMainList("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesByMainList("Imaging", "Imaging testing CBCT Notes");
		BasePatientLifeCyclePageActions.clickViewBtn(patntDiagnosticData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.headerViewPopup("Diagnostics View");
		DiagnosticListingPageActions.checkedDataNameViewPopup();
		DiagnosticListingPageActions.verifyPatientNameInView(patntDiagnosticData.get("patient_name"));
		DiagnosticListingPageActions.verifyDateInView();
		DiagnosticListingPageActions.checkDiagnosisViewPopup("Imaging");
		DiagnosticListingPageActions.investigationView("Imaging", "OPG");
		DiagnosticListingPageActions.investigationView("Imaging", "CBCT");
		DiagnosticListingPageActions.createdByView("Imaging", patntDiagnosticData.get("doctorNickName"));
		DiagnosticListingPageActions.notesView("Imaging", "Imaging testing CBCT Notes");
		BasePatientLifeCyclePageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Diagnostic Listing"));
		BaseClass.softAssert().assertAll();
		CommonPageActions.backTODoctorDashboard();
	}
}
