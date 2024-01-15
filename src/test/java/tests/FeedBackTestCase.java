package tests;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.FeedbackAddPageActions;
import pageActions.doctorDashboard.FeedbackListingPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.AppointmentsListPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.OralExamsPageActions;
import pageActions.patientDashboard.TreatmentPlanListingPageActions;
import pageActions.patientDashboard.TreatmentPlansPageActions;
import pageActions.patientDashboard.WorkDoneHistoryPageActions;
import pageActions.patientDashboard.WorksDonePageActions;
import utils.ConfigReader;
import utils.SheetTest;
import utils.TestData;

import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class FeedBackTestCase extends BaseClass {
    
    /**
     * Please update the input before executing the test cases
     */
    private static final String TODAY_DATE = TestData.getInstance().getTodayDate();
    private static final String TODAY_DATE_FULL_YEAR = TestData.getInstance().getTodayDateFullYear();
    
    
    /**
     * Messages used to print at extent report
     */
    private static final String STARTED_SCRIPTS = "@@ Test scripts has been started here @@";
    private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed here@@";
    private static final String CREATING_TREATMENT ="Added treatment for the patient and completed the work done for the same patient :-creatingTreatment";
    private static final String DOCTOR_FEEDBACK_ADD_UI_FEEDBACK_LISTING ="Validated feedback add page UI for first time and feed back listing :-doctorFeedbackAddUiFeedbackListing";
    private static final String BEHAVIOUR_FEEDBACK_ADD_UI_PAGE ="Validated Behavior of feedback Add ui page :-behaviourFeedbackAddUiPage";
    private static final String DOCTOR_ADDED_FEEDBACK ="Added feed back by the doctor and validated All mandatory data at feedback listing and feedback listing view modal :-doctorAddedFeedback";
    private static final String EDIT_FEED_BACK ="Edit the feedback from the feedback listing and changes the input and updated input checked at the both feedback listing and feedback view modal :-editFeedBack";

    /*
     * Google Sheet Details
     */
    
    
    Map<String ,String> feedbackTestScriptData=null;
    
    @BeforeClass(alwaysRun = true)
	public void testSetup() {
        feedbackTestScriptData=SheetTest.prepareData("Feedback", "FeedbackTestData", "A2", "G2");
        CommonPageActions.selectClinicFrmHeader(feedbackTestScriptData.get("clinic_name"));
		DoctorDashBoardPageActions.clickonAppointmentAdd();

        CommonPageActions.enterMobileNo(feedbackTestScriptData.get("patient_mobileNumber"));
        CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

        CommonPageActions.clickOnPatient(feedbackTestScriptData.get("patient_mobileNumber"),feedbackTestScriptData.get("patient_name"));
        PatientDashboardPageActions.hideDueWarningPopup();
	}

    

    /**
     * Added treatment for the patient
     * checked Appointment is available or not for the patient within 24 hr
     * started the treatment and completed All work done of the patient
     * Now checked feedback Add button should be available at Appointment listing after work done completed
     */
//    @Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled = true,priority = 1)
    @Test(enabled = true,priority = 1)
    public void creatingTreatment(){
        logger.log(Status.PASS, CREATING_TREATMENT);
        PatientDashboardPageActions.clickOnTreatmentPlanAddBtn();
        BasePatientLifeCyclePageActions.clickOnAlert();
        OralExamsPageActions.clickOnTeethImage("Adult", "24");
        TreatmentPlansPageActions.verifySeletecdTeethOnPopup("24");
        TreatmentPlansPageActions.clickOnConsultationXRays();
        TreatmentPlansPageActions.clickOnTreatments(feedbackTestScriptData.get("treatment_shortName"));
        TreatmentPlansPageActions.saveTreatment();
        BasePatientLifeCyclePageActions.clickOnDashBoard();
        BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
        TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
        /*Checking start button and booking appointment for appearing start btn in doctor*/
        TreatmentPlanListingPageActions.checkStartBtnNotPresent(TODAY_DATE);
        BasePatientLifeCyclePageActions.clickOnDashBoard();
        BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnAppList();
        AppointmentsListPageActions.appointmentAvailable();
        BasePatientLifeCyclePageActions.clickOnDashBoard();
        BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnAppAdd();
        AppointmentAddPageActions.selectDoctorFromDropdown(feedbackTestScriptData.get("doctor_name"));
        AppointmentAddPageActions.clickOnSaveBtn();
        BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnTreatmentPlanListBtn();
        TreatmentPlanListingPageActions.verifyDatesTreatmentPlanList();
        TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
        TreatmentPlanListingPageActions.checkedWithoutTreatmentStart();
        TreatmentPlanListingPageActions.selectTreatmentInTreatmentListPage(feedbackTestScriptData.get("treatment_fullName"));
        TreatmentPlanListingPageActions.clickOnStartBtn(TODAY_DATE);
        WorksDonePageActions.checkedTreatmentStartMsgDisplayed();
        
        WorksDonePageActions.selectDoctor(feedbackTestScriptData.get("treatment_fullName"), feedbackTestScriptData.get("doctor_name"));
        WorksDonePageActions.selectTime(feedbackTestScriptData.get("treatment_fullName"), "30");
        WorksDonePageActions.enterRemarks(feedbackTestScriptData.get("treatment_fullName"), "Change to complete");
//        WorksDonePageActions.selectStages(feedbackTestScriptData.get("treatment_fullName"), "Completed");          trt have single stage that's why already selected and disabled
        WorksDonePageActions.clickOnAdd(feedbackTestScriptData.get("treatment_fullName"));
        
        WorkDoneHistoryPageActions.checkDateTreatment(feedbackTestScriptData.get("treatment_fullName"), TODAY_DATE);
        WorkDoneHistoryPageActions.checkSourceNo(feedbackTestScriptData.get("treatment_fullName"), "24");
        WorkDoneHistoryPageActions.checkedStatusTreatment(feedbackTestScriptData.get("treatment_fullName"), "Completed");
        WorkDoneHistoryPageActions.followUpBtn(feedbackTestScriptData.get("treatment_fullName"));
//        WorkDoneHistoryPageActions.reTreatBtn(feedbackTestScriptData.get("treatment_fullName"));                 retreat btn not available for single stage trt
        WorkDoneHistoryPageActions.checkDataName(feedbackTestScriptData.get("treatment_fullName"));
        WorkDoneHistoryPageActions.modifiedDate(feedbackTestScriptData.get("treatment_fullName"), TODAY_DATE);
        WorkDoneHistoryPageActions.checkDoctorTreated(feedbackTestScriptData.get("treatment_fullName"), feedbackTestScriptData.get("doctor_name"));
        WorkDoneHistoryPageActions.checkedClinic(feedbackTestScriptData.get("treatment_fullName"), feedbackTestScriptData.get("clinic_name"));
        WorkDoneHistoryPageActions.checkSpentTime(feedbackTestScriptData.get("treatment_fullName"), "30");
        WorkDoneHistoryPageActions.checkStageTreatment(feedbackTestScriptData.get("treatment_fullName"), "Completed");
        WorkDoneHistoryPageActions.checkedRemarks(feedbackTestScriptData.get("treatment_fullName"), "Change to complete");
        WorkDoneHistoryPageActions.checkedInvoiceListBtn();
        WorkDoneHistoryPageActions.checkLabWorkOrderBtn();
        WorkDoneHistoryPageActions.checkedPrintBtn();
        BasePatientLifeCyclePageActions.verifyAddNewBtn();
        BasePatientLifeCyclePageActions.dashBoardBtnVerify();
        BasePatientLifeCyclePageActions.clickOnAddNewBtn();
        BasePatientLifeCyclePageActions.noRecordMsgDisplayed();
        WorksDonePageActions.checkLabWorkOrderBtn();
        WorksDonePageActions.checkedInvoiceListBtn();
        WorksDonePageActions.checkedHistoryBtn();
        BasePatientLifeCyclePageActions.dashBoardBtnVerify();
        WorksDonePageActions.checkedPrintBtnNotPresent();
        WorksDonePageActions.checkedAddAllBtnNotPresent();
        BasePatientLifeCyclePageActions.clickOnDashBoard();
        PatientDashboardPageActions.hideDueWarningPopup();
        PatientDashboardPageActions.clickOnAppList();
        AppointmentsListPageActions.checkFeedbackBtn(TODAY_DATE);
        Assert.assertTrue(CommonPageActions.verification().contains("Appointment/Event Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoardCommon();
    }

    /**
     * validated feedback Add ui page all web element
     * validated feedback listing page  All web element
     */
    @Test(groups = {"Regression"},enabled = true,priority = 2)
    public void doctorFeedbackAddUiFeedbackListing(){
        logger.log(Status.PASS, DOCTOR_FEEDBACK_ADD_UI_FEEDBACK_LISTING);
        PatientDashboardPageActions.hideDueWarningPopup();
        PatientDashboardPageActions.clickOnAppList();
        AppointmentsListPageActions.checkFeedbackBtn(TODAY_DATE);
        AppointmentsListPageActions.clickOnFeedbackBtn(TODAY_DATE);
        FeedbackAddPageActions.checkFeedBackHeader("Add Feedback");
        FeedbackAddPageActions.verifyPatientName(feedbackTestScriptData.get("patient_name"));
        FeedbackAddPageActions.checkSaveBtn();
        FeedbackAddPageActions.checkResetBtn();
        FeedbackAddPageActions.checkCancelBtn();
        FeedbackAddPageActions.checkDashboardBtn();
        FeedbackAddPageActions.topSectionFeedbackHeader();
        FeedbackAddPageActions.feedBackDateDisplayed();
        FeedbackAddPageActions.feedBackSerialNumberDisplayed();
        FeedbackAddPageActions.feedBackAddFilesDisplayed();
        FeedbackAddPageActions.bottomSectionFeedbackHeader();
        FeedbackAddPageActions.feedbackType("Patient Feedback");
        FeedbackAddPageActions.checkMessageRating();
        FeedbackAddPageActions.rateCount();
        CommonPageActions.backTODoctorDashboard();
        DoctorDashBoardPageActions.clickFeedBackListing();
        FeedbackListingPageActions.feedbackListingHeader("Feedback Listing");
        FeedbackListingPageActions.feedbackTypeDropDown("Select Type");
        FeedbackListingPageActions.feedbackSearchType("Select Search By");
        FeedbackListingPageActions.doctorDropDown("Select Doctor");
        FeedbackListingPageActions.detailsFields();
        FeedbackListingPageActions.dateFilter();
        FeedbackListingPageActions.createdRadioBtn();
        FeedbackListingPageActions.submittedRadioBtn();
        FeedbackListingPageActions.searchBtn();
        FeedbackListingPageActions.resetBtn();
        FeedbackListingPageActions.noRecordFoundDisplayed();
        Assert.assertTrue(CommonPageActions.verification().contains("Feedback Listing"));
        CommonPageActions.backTODoctorDashboard();
    }

    /**
     * validated feedback date for first time
     * validated serial number is mandatory fields
     * validated file upload is mandatory for rate 1 to 6.
     * validated All web element for rating 1 to 10.
     * validated reset functionality
     * validated cancel functionality
     */
    @Test(groups = {"Sanity","Regression"},enabled = true,priority = 3)
    public void behaviourFeedbackAddUiPage(){
        logger.log(Status.PASS, BEHAVIOUR_FEEDBACK_ADD_UI_PAGE);
        CommonPageActions.selectClinicFrmHeader(feedbackTestScriptData.get("clinic_name"));
        DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();

//        AppointmentsLisitngPageActions.selectDoctorFRmDrpDwn(feedbackTestScriptData.get("doctor_name"));
        AppointmentsLisitngPageActions.clickFeedbackBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackAddPageActions.feedbackDate(TODAY_DATE_FULL_YEAR);
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.serialMandatoryFields();
        FeedbackAddPageActions.enterSerialNumber("12345");
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.toastMsgQuestions();
        FeedbackAddPageActions.selectRating(1);
        FeedbackAddPageActions.options_rating_1();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(2);
        FeedbackAddPageActions.options_rating_2();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(3);
        FeedbackAddPageActions.options_rating_3();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(4);
        FeedbackAddPageActions.options_rating_4();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(5);
        FeedbackAddPageActions.options_rating_5();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(6);
        FeedbackAddPageActions.options_rating_6();
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.selectRating(7);
        FeedbackAddPageActions.options_rating_7();
        FeedbackAddPageActions.selectRating(8);
        FeedbackAddPageActions.options_rating_8();
        FeedbackAddPageActions.selectRating(9);
        FeedbackAddPageActions.options_rating_9();
        FeedbackAddPageActions.selectRating(10);
        FeedbackAddPageActions.options_rating_10();
        FeedbackAddPageActions.resetfeedBackAdd();
        FeedbackAddPageActions.deSelectRating();
        FeedbackAddPageActions.feedbackSerialNumber("");
        FeedbackAddPageActions.cancelfeedBackAdd();
        BaseClass.softAssert().assertAll();
        Assert.assertEquals(CommonPageActions.verification(),"Appointment/Event Listing");
        CommonPageActions.backTODoctorDashboard();
    }
//
//    /**
//     * validated file Attachment functionality
//     * validated Added feedback with input
//     * checked all data at the feedback listing and feedback listing view modal
//     * After adding the feedback checked at the appointment listing feedback button should be disable
//     */
    @Test(groups = {"Functional","Regression"},enabled = true,priority = 4)
    public void doctorAddedFeedback(){
        logger.log(Status.PASS, DOCTOR_ADDED_FEEDBACK);
        CommonPageActions.selectClinicFrmHeader(feedbackTestScriptData.get("clinic_name"));
        
        DoctorDashBoardPageActions.clickOnAppListBtn();
		AppointmentsLisitngPageActions.clickOnLastPage();

//        AppointmentsLisitngPageActions.selectDoctorFRmDrpDwn(feedbackTestScriptData.get("doctor_name"));
        AppointmentsLisitngPageActions.clickFeedbackBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackAddPageActions.feedbackDate(TODAY_DATE_FULL_YEAR);
        FeedbackAddPageActions.enterSerialNumber("12345");
        FeedbackAddPageActions.selectRating(1);
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackAddPageActions.fileUploadToastMsg();
        FeedbackAddPageActions.uploadFeedbackFiles(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FeedbackAddPageActions.removeAttachedFile();
        FeedbackAddPageActions.closeFileRemove();
        FeedbackAddPageActions.removeAttachedFile();
        FeedbackAddPageActions.yesFileRemove();
        FeedbackAddPageActions.feedBackAddFilesDisplayed();
        FeedbackAddPageActions.uploadFeedbackFiles(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FeedbackAddPageActions.selectDentistInteractionRate_1();
        FeedbackAddPageActions.addFeedbackNotes_rate_1("testing feedback");
        FeedbackAddPageActions.savefeedBackAdd();
        
        //test failing here bcz feedback listing is not available
        FeedbackListingPageActions.feedbackListingColumnName();
        FeedbackListingPageActions.patientName_PatientId(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.feedbackType(feedbackTestScriptData.get("patient_name"),"Patient Feedback");
        FeedbackListingPageActions.feedbackDate(feedbackTestScriptData.get("patient_name"),TODAY_DATE_FULL_YEAR);
        FeedbackListingPageActions.mobileNumber(feedbackTestScriptData.get("patient_name"),feedbackTestScriptData.get("patient_mobileNumber"));
        FeedbackListingPageActions.emailId(feedbackTestScriptData.get("patient_name"),"NA");
        FeedbackListingPageActions.submittedBy(feedbackTestScriptData.get("patient_name"),feedbackTestScriptData.get("doctor_nickName"));
        FeedbackListingPageActions.fileAttached(feedbackTestScriptData.get("patient_name"),"File1");
        FeedbackListingPageActions.feedbackViewBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.feedbackEditBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.clickFeedbackViewBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.headerFeedbackView("Feedback Details");
        FeedbackListingPageActions.patientNameInView(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.checkFeedbackDetailsHeader();
        FeedbackListingPageActions.clinicNameFeedbackView(feedbackTestScriptData.get("clinic_name"));
        FeedbackListingPageActions.emailIdFeedbackView("NA");
        FeedbackListingPageActions.mobileNoFeedbackView(feedbackTestScriptData.get("patient_mobileNumber"));
        FeedbackListingPageActions.addressFeedbackView("");
        FeedbackListingPageActions.submittionDateFeedbackView(TODAY_DATE);
        FeedbackListingPageActions.serialNoFeedbackView("12345");
        FeedbackListingPageActions.feedbackTypeInView("Patient Feedback");
        FeedbackListingPageActions.ratingFeedbackViewModal("1");
        FeedbackListingPageActions.reasonFeedbackViewModal("Dentist Interaction");
        FeedbackListingPageActions.remarkFeedbackViewModal("testing feedback");
        FeedbackListingPageActions.closeFeedBackViewModal();
        FeedbackListingPageActions.clickOnDashboard();
        DoctorDashBoardPageActions.clickOnAppListBtn();
        AppointmentsLisitngPageActions.selectDoctorFRmDrpDwn(feedbackTestScriptData.get("doctor_name"));
        AppointmentsLisitngPageActions.checkFeedbackBtnDisable(TODAY_DATE);
        Assert.assertEquals(CommonPageActions.verification(),"Feedback Listing");
        CommonPageActions.backTODoctorDashboard();
    }

//    /**
//     * validated edit scenario
//     * changes the input from edit and updated input checked at the feedback listing and feedback view modal
//     */
    @Test(groups = {"Functional","Regression"},enabled = true,priority = 5)
    public void editFeedBack(){
        logger.log(Status.PASS, EDIT_FEED_BACK);
        DoctorDashBoardPageActions.clickFeedBackListing();
        FeedbackListingPageActions.clickFeedbackEditBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackAddPageActions.checkFeedBackHeader("Edit Feedback");
        FeedbackAddPageActions.feedbackDate(TODAY_DATE);
        FeedbackAddPageActions.feedbackSerialNumber("12345");
        FeedbackAddPageActions.feedBackAddFilesDisplayed();
        FeedbackAddPageActions.editedFileFeedbackListing("File1");
        FeedbackAddPageActions.feedbackType("Patient Feedback");
        FeedbackAddPageActions.ratingSelected(1);
        FeedbackAddPageActions.enterSerialNumber("23456");
        FeedbackAddPageActions.selectRating(9);
        FeedbackAddPageActions.addFeedbackNotes_rate_9("updated feedback remarks");
        FeedbackAddPageActions.savefeedBackAdd();
        FeedbackListingPageActions.feedbackListingColumnName();
        FeedbackListingPageActions.patientName_PatientId(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.feedbackType(feedbackTestScriptData.get("patient_name"),"Patient Feedback");
        FeedbackListingPageActions.feedbackDate(feedbackTestScriptData.get("patient_name"),TODAY_DATE);
        FeedbackListingPageActions.mobileNumber(feedbackTestScriptData.get("patient_name"),feedbackTestScriptData.get("patient_mobileNumber"));
        FeedbackListingPageActions.emailId(feedbackTestScriptData.get("patient_name"),"NA");
        FeedbackListingPageActions.submittedBy(feedbackTestScriptData.get("patient_name"),feedbackTestScriptData.get("doctor_nickName"));
        FeedbackListingPageActions.fileAttached(feedbackTestScriptData.get("patient_name"),"File1");
        FeedbackListingPageActions.feedbackViewBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.feedbackEditBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.clickFeedbackViewBtn(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.headerFeedbackView("Feedback Details");
        FeedbackListingPageActions.patientNameInView(feedbackTestScriptData.get("patient_name"));
        FeedbackListingPageActions.checkFeedbackDetailsHeader();
        FeedbackListingPageActions.clinicNameFeedbackView(feedbackTestScriptData.get("clinic_name"));
        FeedbackListingPageActions.emailIdFeedbackView("NA");
        FeedbackListingPageActions.mobileNoFeedbackView(feedbackTestScriptData.get("patient_mobileNumber"));
        FeedbackListingPageActions.addressFeedbackView("");
        FeedbackListingPageActions.submittionDateFeedbackView(TODAY_DATE);
        FeedbackListingPageActions.serialNoFeedbackView("23456");
        FeedbackListingPageActions.feedbackTypeInView("Patient Feedback");
        FeedbackListingPageActions.ratingFeedbackViewModal("9");
        FeedbackListingPageActions.reasonFeedbackViewModal("NA");
        FeedbackListingPageActions.remarkFeedbackViewModal("NA");
        FeedbackListingPageActions.closeFeedBackViewModal();
        Assert.assertEquals(CommonPageActions.verification(),"Feedback Listing");
        CommonPageActions.backTODoctorDashboard();
    }
}
