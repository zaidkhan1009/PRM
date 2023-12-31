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
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.ChiefComplaintAddPageActions;
import pageActions.patientDashboard.ChiefComplaintListingPageActions;
import pageActions.patientDashboard.OralExamListingPageActions;
import pageActions.patientDashboard.OralExamsPageActions;

public class OralExamsTestCase extends BaseClass{
	
	/*input data for validation*/
//	private static final String PATIENT_NAME= TestData.getInstance().getInputData("oral_exam_patient_name");
//	private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("oral_exam_patient_mobile");
//	private static final String DOCTOR_NIK_NAME = TestData.getInstance().getInputData("oral_exam_doctor_nikName");
//	private static final String CLINIC_NAME = TestData.getInstance().getInputData("oral_exam_clinic_name");

	/*---------------Messages for Extent Reports-------------------*/
	private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
	private static final String VERIFY_UI_ORAL_EXAM_ADD = "Validated oral Exam Add page UI Page on first time navigation - #verifyUIOralExamAdd";
	private static final String VERIFY_ORAL_EXAM_LIST_UI_WITHOUT_ORAL_EXAM = "Validated Oral Exam List UI Without OralExam - #verifyOralExamListUIWithoutOralExam";
	private static final String VERIFY_WEB_ELEMENT_ON_TEETH_POPUP = "Validated UI of teeth popup after clicking on teeth image - #verifyWebElementOnTeethPopup";
	private static final String BEHAVIOUR_CHIEF_COMPLAINT_ON_ORAL_EXAM = "Validated chief complaints behaviour with oral exam - #behaviourChiefComplaintOnOralExam";
	private static final String TEETH_BEHAVIOUR_ORAL_EXAM_ADD = "Validated teeth functionality on oral Add page - #teethBehaviourOralExamAdd";
	private static final String BEHAVIOR_OF_TISSUE_FOR_SINGLE_TEETH = "Validated behavior Of Tissue For Single Teeth - #behaviorOfTissueForSingleTeeth";
	private static final String ADD_ORAL_EXAM_SINGLE_TEETH = "Validated add Oral Exam for Single Teeth - #addOralExamSingleTeeth";
	private static final String ORAL_EXAM_OF_MULTIPLE_TEETH = "Validated add Oral Exam for multiple Teeth - #addOralExamOfMultipleTeeth";
	private static final String ORAL_EXAM_EDIT_INPUT_LIST = " Validated oral Exam Edit from Input List - #oralExamEditInputList";
	Map<String, String> patntOralExamData = null;



	@Test(enabled = true, priority = 1)
	public void verifyUIOralExamAdd() {
		logger.log(Status.PASS, VERIFY_UI_ORAL_EXAM_ADD);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		OralExamsPageActions.verifyUiOralExamPage();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		OralExamsPageActions.verifyUiOralExamPage();
		BasePatientLifeCyclePageActions.verifyPatientName(patntOralExamData.get("patient_name"));
		BasePatientLifeCyclePageActions.headerOnAddPage("Oral Exams");
		OralExamsPageActions.verifyAdultsTeeths();
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.verifyPedoTeeths();
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.verifyMixedTeeths();
		OralExamsPageActions.clickOnTissue();
		OralExamsPageActions.verifyWebElementInSoftTissue();
		OralExamsPageActions.clickOnHardTissue();
		OralExamsPageActions.verifyWebElementInHardTissue();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exams"));
	}

	@Test(enabled = true, priority = 2)
	public void verifyOralExamListUIWithoutOralExam() {
		logger.log(Status.PASS, VERIFY_ORAL_EXAM_LIST_UI_WITHOUT_ORAL_EXAM);
		PatientDashboardPageActions.clickOnOralExamList();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
		BasePatientLifeCyclePageActions.openCloseLeftNavigator();
		BasePatientLifeCyclePageActions.dashBoardBtnVerify();
		BasePatientLifeCyclePageActions.verifyAddNewBtn();
		BasePatientLifeCyclePageActions.headerOnListPage("Oral Exam Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(patntOralExamData.get("patient_name"));
		/* Only For First Time Traversing */
//		BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exam Listing"));
	}

	@Test(enabled = true, priority = 3)
	public void verifyWebElementOnTeethPopup() {
		logger.log(Status.PASS, VERIFY_WEB_ELEMENT_ON_TEETH_POPUP);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.selectMultipleTeeth("Mixed", "18");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "22");
		OralExamsPageActions.clickOnTeethImage("Mixed", "21");
		OralExamsPageActions.clickOnYes();
		OralExamsPageActions.verifySelectedTeethOnPopup("18", 1);
		OralExamsPageActions.verifySelectedTeethOnPopup("22", 2);
		OralExamsPageActions.verifySelectedTeethOnPopup("21", 3);
		OralExamsPageActions.verifyTitleOfPopup("mixed", "Tooth Site & Perio");
		OralExamsPageActions.clickOnBuccal();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnDistal();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnMesial();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnOcclusal();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnPalatal();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnAllSurface();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.clickOnPerio();
		OralExamsPageActions.verifyProvisinals();
		OralExamsPageActions.verifyIoparBtn();
		OralExamsPageActions.clickOnIOPARBtn();
		OralExamsPageActions.verifyIOPARNotes();
		OralExamsPageActions.verifyToothObservationRemark();
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.verifyTitleOfPopup("mixed", "Soft Tissue");
		OralExamsPageActions.clickOnLip();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnCheek();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnTongue();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnFloorOfMouth();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnPalate();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnGingiva();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnVestibule();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnFrenum();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnSalivaryGland();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.clickOnLymphNodes();
		OralExamsPageActions.verifySoftProvisinals();
		OralExamsPageActions.verifyToothObservationRemark();
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.verifyTitleOfPopup("mixed", "Hard Tissue");
		OralExamsPageActions.clickOnMandibularAngle();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnMandibularBody();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnMaxillaryTuberosity();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnPosteriorMaxilla();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnPreMaxilla();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnMaxillarySinus();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnMandibularSymphysis();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.clickOnTMJoint();
		OralExamsPageActions.verifyHardProvisionals();
		OralExamsPageActions.verifyToothObservationRemark();
		OralExamsPageActions.clickOnCloseBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exams"));
	}

	@Test(enabled = true, priority = 4)
	public void behaviourChiefComplaintOnOralExam() {
		logger.log(Status.PASS, BEHAVIOUR_CHIEF_COMPLAINT_ON_ORAL_EXAM);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnchiefComplaintsAddBtn();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Plaque");
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Bad Breath");
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Bleeding Gums");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
//		BasePatientLifeCyclePageActions.verifyDates();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Plaque");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Bad Breath");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Bleeding Gums");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Plaque");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Bad Breath");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Bleeding Gums");
		OralExamsPageActions.clickOnEditOfChiefComplaint();
		BasePatientLifeCyclePageActions.clickOnAlert();
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Teeth Grinding");
		ChiefComplaintAddPageActions.clickOnChiefComplaint("Chewing Difficulty");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
//		BasePatientLifeCyclePageActions.verifyDates();
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Plaque");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Bad Breath");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Bleeding Gums");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Teeth Grinding");
		ChiefComplaintListingPageActions.chiefComplaintInMainList("Chewing Difficulty");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Plaque");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Bad Breath");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Bleeding Gums");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Teeth Grinding");
		OralExamsPageActions.checkedChiefComplaintsOnOralExam("Chewing Difficulty");
		OralExamsPageActions.removeChiefComplaintsOnOralExam("Plaque");
		OralExamsPageActions.checkedDeletedChiefComplaints("Plaque");
		OralExamsPageActions.removeChiefComplaintsOnOralExam("Teeth Grinding");
		OralExamsPageActions.checkedDeletedChiefComplaints("Teeth Grinding");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnChiefComplaintlistBtn();
//		BasePatientLifeCyclePageActions.verifyDates();
		ChiefComplaintListingPageActions.deletedChiefComplaintInMainList("Plaque");
		ChiefComplaintListingPageActions.deletedChiefComplaintInMainList("Teeth Grinding");
		BasePatientLifeCyclePageActions.clickViewBtn(patntOralExamData.get("clinicLocation"));
//		ChiefComplaintListingPageActions.verifyDateInView();
		ChiefComplaintListingPageActions.dataNameInView();
		ChiefComplaintListingPageActions.deletedChiefComplaintInView("Plaque");
		ChiefComplaintListingPageActions.deletedChiefComplaintInView("Teeth Grinding");
		ChiefComplaintListingPageActions.checkedChiefComplaintInView("Bad Breath");
		ChiefComplaintListingPageActions.checkedChiefComplaintInView("Bleeding Gums");
		ChiefComplaintListingPageActions.checkedChiefComplaintInView("Chewing Difficulty");
//		ChiefComplaintListingPageActions.userNameInView("Bad Breath", patntOralExamData.get("doctorNickName"));
		ChiefComplaintListingPageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Chief Complaint Listing"));
	}

	@Test(enabled = true, priority = 5)
	public void teethBehaviourOralExamAdd() {
		logger.log(Status.PASS, TEETH_BEHAVIOUR_ORAL_EXAM_ADD);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnAllTeeth();
		OralExamsPageActions.allTeethButtonSelected();
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.clickOnAdult();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnAllTeeth();
		OralExamsPageActions.allTeethButtonSelected();
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnAllTeeth();
		OralExamsPageActions.allTeethButtonSelected();
		OralExamsPageActions.clickOnAdult();
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.allTeethButtonDeselected();
		OralExamsPageActions.clickOnAdult();
		OralExamsPageActions.selectMultipleTeeth("Adult", "27");
		OralExamsPageActions.selectMultipleTeeth("Adult", "28");
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.selectedInRespective("Mixed", "27");
		OralExamsPageActions.selectedInRespective("Mixed", "28");
		OralExamsPageActions.clickOnAdult();
		OralExamsPageActions.selectedInRespective("Adult", "27");
		OralExamsPageActions.selectedInRespective("Adult", "28");
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.selectMultipleTeeth("Pedo", "64");
		OralExamsPageActions.selectMultipleTeeth("Pedo", "65");
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.deSelectedInRespective("Mixed", "27");
		OralExamsPageActions.deSelectedInRespective("Mixed", "28");
		OralExamsPageActions.selectedInRespective("Mixed", "64");
		OralExamsPageActions.selectedInRespective("Mixed", "65");
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.selectedInRespective("Pedo", "64");
		OralExamsPageActions.selectedInRespective("Pedo", "65");
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.selectedInRespective("Mixed", "64");
		OralExamsPageActions.selectedInRespective("Mixed", "65");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "11");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "12");
		OralExamsPageActions.clickOnAdult();
		OralExamsPageActions.selectedInRespective("Adult", "11");
		OralExamsPageActions.selectedInRespective("Adult", "12");
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.deSelectedInRespective("Mixed", "64");
		OralExamsPageActions.deSelectedInRespective("Mixed", "65");
		OralExamsPageActions.selectedInRespective("Mixed", "11");
		OralExamsPageActions.selectedInRespective("Mixed", "12");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "61");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "62");
		OralExamsPageActions.clickOnPedo();
		OralExamsPageActions.selectedInRespective("Pedo", "61");
		OralExamsPageActions.selectedInRespective("Pedo", "62");
		OralExamsPageActions.clickOnMixed();
		OralExamsPageActions.selectedInRespective("Mixed", "61");
		OralExamsPageActions.selectedInRespective("Mixed", "62");
		OralExamsPageActions.deSelectedInRespective("Mixed", "11");
		OralExamsPageActions.deSelectedInRespective("Mixed", "12");
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exams"));
	}

	@Test(enabled = true, priority = 6)
	public void behaviorOfTissueForSingleTeeth() {
		logger.log(Status.PASS, BEHAVIOR_OF_TISSUE_FOR_SINGLE_TEETH);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "24");
		OralExamsPageActions.verifySelectedTeethOnPopup("24", 1);
		OralExamsPageActions.clickOnBuccal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Buccal");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnDistal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Distal");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnMesial();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Mesial");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnOcclusal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Occlusal");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnPalatal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Palatal");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnAllSurface();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("All Surface");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnPerio();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.verifyProvisinalIsSelected("Perio");
		OralExamsPageActions.selectedToothAndSiteProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.clickOnLip();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Lip");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnCheek();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Cheek");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnTongue();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Tongue");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnFloorOfMouth();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Floor of Mouth");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnPalate();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Palate");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnGingiva();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Gingiva");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnVestibule();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Vestibule");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnFrenum();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Frenum");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnSalivaryGland();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Salivary Gland");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnLymphNodes();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfSoftTissue("Lymph Nodes");
		OralExamsPageActions.selectedSoftTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.clickOnMandibularAngle();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Mandibular Angle");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnMandibularBody();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Mandibular Body");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnMaxillaryTuberosity();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Maxillary Tuberosity");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnPosteriorMaxilla();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Posterior Maxilla");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnPreMaxilla();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Pre-Maxilla");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnMaxillarySinus();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Maxillary Sinus");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnMandibularSymphysis();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("Mandibular Symphysis");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnTMJoint();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.provisionalIsSelectedOfHardTissue("TM Joint");
		OralExamsPageActions.selectedHardTissueProvisionalDisplayedBelow();
		OralExamsPageActions.clickOnCloseBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exams"));
	}

	@Test(enabled = true, priority = 7)
	public void addOralExamSingleTeeth() {
		logger.log(Status.PASS, ADD_ORAL_EXAM_SINGLE_TEETH);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Adult", "47");
		OralExamsPageActions.verifySelectedTeethOnPopup("47", 1);
		OralExamsPageActions.clickOnBuccal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.clickOnDistal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.clickOnLip();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.clickOnCheek();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.clickOnPreMaxilla();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.clickOnMaxillarySinus();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.enterOralExamNotes("it for testing");
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.verifyInputListWebElement();
		OralExamsPageActions.verifyProvisinalsInputList("47", 6);
		OralExamsPageActions.verifyNoteInputList("47", "it for testing");
		OralExamsPageActions.verifyActionBtnOfTeethNo("47");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnOralExamList();
//		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.headerOnListPage("Oral Exam Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(patntOralExamData.get("patient_name"));
		BasePatientLifeCyclePageActions.actionBtnMainList(patntOralExamData.get("clinicLocation"));
		OralExamListingPageActions.checkedDataName();
		OralExamListingPageActions.verifyProvisinalsSingleTeethOralExamList("47", 6);
//		OralExamListingPageActions.verifyCreatedByInOralExamList("47",patntOralExamData.get("doctorNickName"));
		OralExamListingPageActions.verifyNoteOralExamList("47", "it for testing");
		BasePatientLifeCyclePageActions.clickViewBtn(patntOralExamData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.headerViewPopup("Oral Exam View");
		OralExamListingPageActions.checkedViewDataName();
		OralExamListingPageActions.oralExamViewPopup("47", 6);
//		OralExamListingPageActions.createdByOralExamViewPopup("47",patntOralExamData.get("doctorNickName"));
		OralExamListingPageActions.noteOralExamViewPopup("47", "it for testing");
		BasePatientLifeCyclePageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exam Listing"));
	}

	@Test(enabled = true, priority = 8)
	public void addOralExamOfMultipleTeeth() {
		logger.log(Status.PASS, ORAL_EXAM_OF_MULTIPLE_TEETH);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.selectMultipleTeeth("Mixed", "44");
		OralExamsPageActions.selectMultipleTeeth("Mixed", "45");
		OralExamsPageActions.clickOnTeethImage("Mixed", "45");
		OralExamsPageActions.clickOnBuccal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.clickOnDistal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.clickOnLip();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.clickOnCheek();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.clickOnPreMaxilla();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.clickOnMaxillarySinus();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.enterOralExamNotes("it for testing");
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.verifyInputListWebElement();
		OralExamsPageActions.provisinalsInputListOfMultipleTeeth("44", "45", 6);
		OralExamsPageActions.verifyNoteInputList("44", "it for testing");
		OralExamsPageActions.verifyActionBtnOfTeethNo("44");
		BasePatientLifeCyclePageActions.clickOnDashBoard();
		BasePatientLifeCyclePageActions.clickOnAlert();
		PatientDashboardPageActions.clickOnOralExamList();
//		BasePatientLifeCyclePageActions.verifyDates();
		BasePatientLifeCyclePageActions.headerOnListPage("Oral Exam Listing");
		BasePatientLifeCyclePageActions.verifyPatientName(patntOralExamData.get("patient_name"));
		BasePatientLifeCyclePageActions.actionBtnMainList(patntOralExamData.get("clinicLocation"));
		OralExamListingPageActions.checkedDataName();
		OralExamListingPageActions.verifyProvisinalsMultipleTeethOralExamList("44", "45", 6);
		OralExamListingPageActions.verifyNoteOralExamList("44", "it for testing");
		OralExamListingPageActions.verifyCreatedByInOralExamList("44",patntOralExamData.get("doctorNickName"));
		BasePatientLifeCyclePageActions.clickViewBtn(patntOralExamData.get("clinicLocation"));
		BasePatientLifeCyclePageActions.headerViewPopup("Oral Exam View");
		OralExamListingPageActions.checkedViewDataName();
		OralExamListingPageActions.oralExamViewPopup("44", 6);
		OralExamListingPageActions.createdByOralExamViewPopup("44", patntOralExamData.get("doctorNickName"));
		OralExamListingPageActions.noteOralExamViewPopup("44", "it for testing");
		BasePatientLifeCyclePageActions.closeViewPopup();
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exam Listing"));
	}

	@Test(enabled = true, priority = 9)
	public void oralExamEditInputList() {
		logger.log(Status.PASS, ORAL_EXAM_EDIT_INPUT_LIST);
		PatientDashboardPageActions.clickOnOralExamAdd();
		BasePatientLifeCyclePageActions.clickOnAlert();
		OralExamsPageActions.clickOnTeethImage("Mixed", "41");
		OralExamsPageActions.clickOnBuccal();
		OralExamsPageActions.clickOnToothSiteAndPerioProvisinals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.clickOnEditBtnTeethNo("41");
		OralExamsPageActions.selectedAfterClickOnEdit("Mixed", "41");
		OralExamsPageActions.clickOnTeethImage("Mixed", "41");
		OralExamsPageActions.removeToothSiteProvisionals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.alertMsgOnNotSelectProvisional();
		OralExamsPageActions.clickOnCloseBtn();
		OralExamsPageActions.clickOnTeethImage("Mixed", "42");
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.clickOnCheek();
		OralExamsPageActions.clickOnSoftTissueProvisinals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.clickOnEditBtnTeethNo("42");
		OralExamsPageActions.selectedAfterClickOnEdit("Mixed", "42");
		OralExamsPageActions.clickOnTeethImage("Mixed", "42");
		OralExamsPageActions.clickOnSoftTissueOnPopup();
		OralExamsPageActions.removeSoftTissueProvisionals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.alertMsgOnNotSelectProvisional();
		OralExamsPageActions.clickOnCloseBtn();
		OralExamsPageActions.clickOnTeethImage("Mixed", "43");
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.clickOnMandibularAngle();
		OralExamsPageActions.clickOnHardTissueProvisinals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.clickOnEditBtnTeethNo("43");
		OralExamsPageActions.selectedAfterClickOnEdit("Mixed", "43");
		OralExamsPageActions.clickOnTeethImage("Mixed", "43");
		OralExamsPageActions.clickOnHardTissueInPopup();
		OralExamsPageActions.removeHardTissueProvisionals();
		OralExamsPageActions.clickOnSaveBtn();
		OralExamsPageActions.alertMsgOnNotSelectProvisional();
		OralExamsPageActions.clickOnCloseBtn();
		OralExamsPageActions.verifyProvisinalsInputList("41", 1);
		OralExamsPageActions.verifyProvisinalsInputList("42", 1);
		OralExamsPageActions.verifyProvisinalsInputList("43", 1);
		Assert.assertTrue(CommonPageActions.verification().contains("Oral Exams"));
		CommonPageActions.softAssert().assertAll();
	}
}
