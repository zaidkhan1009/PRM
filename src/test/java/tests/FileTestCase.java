package tests;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pageActions.doctorDashboard.AppointmentsLisitngPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pageActions.patientDashboard.BasePatientLifeCyclePageActions;
import pageActions.patientDashboard.FileListingPageActions;
import pageActions.patientDashboard.FilesPageActions;
import utils.ConfigReader;
import utils.TestData;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class FileTestCase extends BaseClass {
    
    //storing Input Data need to validate the Scenario
    private static final String PATIENT_NAME= TestData.getInstance().getInputData("file_patient_name");
    private static final String MOBILE_NUMBER = TestData.getInstance().getInputData("file_patient_mobile");
    private static final String CLINIC_NAME = TestData.getInstance().getInputData("file_clinic_name");

    /*-------------------Message for extent report----------------------*/
    private static final String SCRIPTS_STARTED_MSG = "@@ Test scripts has been started here @@";
    private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";
    private static final String FILE_ADD_PAGE = "Checked All webElement at file add page before File upload - #fileAddPage";
    private static final String FILE_LIST_PAGE = "Checked All webElement at file listing page before File upload - #fileListPage";
    private static final String INVALID_INPUT_ERROR = "Validated All mandatory fields with error Message - #invalidInputError";
    private static final String UPLOAD_FILE = "Uploaded single file and checked at both file add and file Listing - #uploadFile";
    private static final String ADDED_MULTIPLE_FILES = "Uploaded multiples files and checked at both file add and file Listing - #addedMultipleFiles";
    private static final String CHECK_TITLE_SCENARIO = "Validated All title related scenario - #checkTitleScenerio";
    private static final String EDIT_FILE = "Validated All edit related scenario - #editFile";
    private static final String DELETED_FILE_LISTING = "Validated All delete related scenerio - #deletedFileListing";
    private static final String RESET_CANCEL_FUNCTIONALITY ="Checked functionality of reset and cancel button - #resetCancelFunctionality";

    

    @Test(groups = {"Sanity","Regression"},enabled = true,priority = 1)
    //checked All fields and text when we redirects to file add page for first time
    public void fileAddPage(){
        logger.log(Status.PASS, FILE_ADD_PAGE);
        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
		DoctorDashBoardPageActions.clickonAppointmentAdd();
		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
		CommonPageActions.clickOnSearchBtn();
		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();

		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();
		
		BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.headerPage("Files");
        FilesPageActions.verifyPatientName(PATIENT_NAME);
        BasePatientLifeCyclePageActions.openCloseLeftNavigator();
        BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
        BasePatientLifeCyclePageActions.closeLeftNavigator();
     //   BasePatientLifeCyclePageActions.clickOnLeftNavigatorCloseBtnOldUi();
        FilesPageActions.categoryDropDownWebelemet();
        FilesPageActions.fileTitleWebElementCheckBoxNotSelected();
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.notesWebElement();
        FilesPageActions.fileUploadBtnDisplayed();
        FilesPageActions.saveBtnDisplayed();
        FilesPageActions.resetBtnDisplayed();
        FilesPageActions.cancelBtnDisplayed();
        BasePatientLifeCyclePageActions.dashBoardBtnVerify();
        Assert.assertTrue(CommonPageActions.verification().contains("Files"));
        BasePatientLifeCyclePageActions.clickOnDashBoard();
    }

    @Test(groups = {"Sanity","Regression"},enabled = true,priority = 2)
    //checked all WebElement at file listing without any file Add
    public void fileListPage(){
        logger.log(Status.PASS, FILE_LIST_PAGE);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();
		
        PatientDashboardPageActions.clickOnFilesList();
        BasePatientLifeCyclePageActions.openCloseLeftNavigator();
        BasePatientLifeCyclePageActions.webElementOfLeftNavigator();
        BasePatientLifeCyclePageActions.closeLeftNavigator();
        FileListingPageActions.oralExamTabSelected();
        FileListingPageActions.fileDateFilter();
        FileListingPageActions.noRecordMessageDisplayed();
        FileListingPageActions.pastDocsTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        FileListingPageActions.verifyPatientName(PATIENT_NAME);
        BasePatientLifeCyclePageActions.verifyAddNewBtnOldUi();
        BasePatientLifeCyclePageActions.dashBoardBtnVerify();
        FileListingPageActions.clickPastDocsTab();
        FileListingPageActions.pastDocsTabSelected();
        FileListingPageActions.oralExamTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        FileListingPageActions.noRecordMessageDisplayed();
        FileListingPageActions.clickXRayTab();
        FileListingPageActions.xRaysTabSelected();
        FileListingPageActions.oralExamTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        FileListingPageActions.pastDocsTabNotSelected();
        FileListingPageActions.noRecordMessageDisplayed();
        FileListingPageActions.clickProfileTab();
        FileListingPageActions.profileTabSelected();
        FileListingPageActions.oralExamTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.pastDocsTabNotSelected();
        FileListingPageActions.noRecordMessageDisplayed();
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BasePatientLifeCyclePageActions.clickOnDashBoard();
    }

    @Test(groups = {"Sanity","Functional","Regression"},enabled = true,priority = 3)
    //validating error message without inputs
    public void invalidInputError(){
        logger.log(Status.PASS, INVALID_INPUT_ERROR);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.clickSaveBtn();
        FilesPageActions.checkedErrorCategory("Select category");
        FilesPageActions.selectCategory("Oral Images");
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.clickSaveBtn();
        FilesPageActions.checkedErrorTitle("Enter file title");
        FilesPageActions.enterTitleFile("fileTest");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.errorMsgFileNotSelected();
        Assert.assertTrue(CommonPageActions.verification().contains("Files"));
        BasePatientLifeCyclePageActions.clickOnDashBoard();
    }

    @Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled = true,priority = 4)
    //Added single files together and validated at File listing
    public void uploadFile(){
        logger.log(Status.PASS, UPLOAD_FILE);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.headerPage("Files");
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FilesPageActions.checkDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.checkVisibletoPatientFileAddPage("File1.jpg");
        FilesPageActions.checkedImagefileAddPage("File1.jpg");
        FilesPageActions.selectCategory("Oral Images");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.checkFileAddedDate("File1");
        FileListingPageActions.checkedFileEditBtn("File1");
        FileListingPageActions.checkedFileDownloadBtn("File1");
        FileListingPageActions.checkedFileDeleteBtn("File1");
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.oralExamTabSelected();
        FileListingPageActions.pastDocsTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        FileListingPageActions.clickPastDocsTab();
        FileListingPageActions.noRecordMessageDisplayed();
        FileListingPageActions.clickXRayTab();
        FileListingPageActions.noRecordMessageDisplayed();
        FileListingPageActions.clickProfileTab();
        FileListingPageActions.noRecordMessageDisplayed();
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoard();
    }

    @Test(groups = {"Smoke","Sanity","Functional","Regression"},enabled = true,priority = 5)
    //Added multiple files together and validated at File listing
    public void addedMultipleFiles() {
        logger.log(Status.PASS, ADDED_MULTIPLE_FILES);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        //Added File and deleted from input list at File Add Page
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FilesPageActions.checkDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.checkedImagefileAddPage("File1.jpg");
        FilesPageActions.clickDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.checkedDeletedFileAddPage("File1.jpg");
        //uploading multiple Files together for a patient
        FilesPageActions.uploadMultipleFiles(System.getProperty("user.dir")+"\\PatientFiles\\File2.jpg",System.getProperty("user.dir")+"\\PatientFiles\\File3.jpg");
        FilesPageActions.checkDeleteBtnFileAddPage("File2.jpg");
        FilesPageActions.checkDeleteBtnFileAddPage("File3.jpg");
        FilesPageActions.checkedImagefileAddPage("File2.jpg");
        FilesPageActions.clickVisibletoPatientBtnFileAddPage("File2.jpg");
        FilesPageActions.checkedImagefileAddPage("File3.jpg");
        FilesPageActions.selectCategory("Past Docs");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.checkFileAddedDate("File2");
        FileListingPageActions.checkedFileVisibleToPatientIcon("File2");
        FileListingPageActions.checkFileAddedDate("File3");
        FileListingPageActions.checkedFileEditBtn("File2");
        FileListingPageActions.checkedFileEditBtn("File3");
        FileListingPageActions.checkedFileDownloadBtn("File2");
        FileListingPageActions.checkedFileDownloadBtn("File3");
        FileListingPageActions.checkedFileDeleteBtn("File2");
        FileListingPageActions.checkedFileDeleteBtn("File3");
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.pastDocsTabSelected();
        FileListingPageActions.oralExamTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoard();

}

    @Test(groups = {"Functional","Regression"},enabled = true,priority = 6)
    //uploaded multiple file together and passed a title then title should be same for every File at file listing page.
    public void checkTitleScenerio() {
        logger.log(Status.PASS, CHECK_TITLE_SCENARIO);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.uploadMultipleFiles(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg",System.getProperty("user.dir")+"\\PatientFiles\\File2.jpg");
     //   FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
      //  FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File2.jpg");
      //  FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File3.jpg");
        FilesPageActions.selectCategory("X-Rays");
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.enterTitleFile("Image");
        FilesPageActions.enterNotes("it is for testing");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.multipleFilesRenameAddedDate("Image",2);
        FileListingPageActions.multipleFilesRenameEditBtn("Image",2);
        FileListingPageActions.multipleFilesRenameDownloadBtn("Image",2);
        FileListingPageActions.multipleFilesRenameDeleteBtn("Image",2);
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoard();

    }

    @Test(groups = {"Functional","Regression"},enabled = true,priority = 7)
    //Edited file from listing and validated All scenario related to edit.
    public void editFile(){
        logger.log(Status.PASS, EDIT_FILE);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();
		BasePatientLifeCyclePageActions.clickOnAlert();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FilesPageActions.selectCategory("Profile");
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.enterTitleFile("Image");
        FilesPageActions.enterNotes("it is for testing");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.checkFileAddedDate("Image");
        FileListingPageActions.checkedFileEditBtn("Image");
        FileListingPageActions.checkedFileDownloadBtn("Image");
        FileListingPageActions.checkedFileDeleteBtn("Image");
        FileListingPageActions.clickFileEditBtn("Image");
        FilesPageActions.getFirstSelectOptions("Profile");
        FilesPageActions.getFileName("Image");
        FilesPageActions.fileTitleWebElementCheckBoxSelected();
        FilesPageActions.editCheckDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.editCheckImageFileAddPage("File1.jpg");
        FilesPageActions.selectCategory("Past Docs");
        FilesPageActions.enterTitleFile("Image2");
        FilesPageActions.clickVisibletoPatientBtnForEditFileAddPage("File1.jpg");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
  //      FileListingPageActions.clickPastDocsTab();
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.checkFileAddedDate("Image2");
        FileListingPageActions.checkedFileVisibleToPatientIcon("Image2");
        FileListingPageActions.checkedFileEditBtn("Image2");
        FileListingPageActions.checkedFileDownloadBtn("Image2");
        FileListingPageActions.checkedFileDeleteBtn("Image2");
        FileListingPageActions.pastDocsTabSelected();
        FileListingPageActions.oralExamTabNotSelected();
        FileListingPageActions.xRaysTabNotSelected();
        FileListingPageActions.profileTabNotSelected();
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoard();

    }

    @Test(groups = {"Functional","Regression"},enabled = true,priority = 8)
    //Deleting file from file listing  and edited file and deleted from file Add page
    public void deletedFileListing(){
        logger.log(Status.PASS, DELETED_FILE_LISTING);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File4.jpg");
        FilesPageActions.selectCategory("Profile"); 
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.enterTitleFile("Image");
        FilesPageActions.enterNotes("it is for testing");
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.openFile("Image");
        FileListingPageActions.checkHeaderFileListPopup("Image");
        FileListingPageActions.checkFileAddedDateFileListPopup();
        FileListingPageActions.notesFileListPopup("it is for testing");
        FileListingPageActions.actionsBtnFileListPopup();
        FileListingPageActions.closeFileListPopup();
        FileListingPageActions.clickFileEditBtn("Image");
        FilesPageActions.uploadFileNotPresent();
        FilesPageActions.editDeleteFileAddPage("File4.jpg");
        FilesPageActions.fileDeleted("File4.jpg");
        FilesPageActions.fileUploadBtnDisplayed();
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File5.jpg");
        FilesPageActions.enterTitleFile("New File");
        FilesPageActions.checkDeleteBtnFileAddPage("File5.jpg");
        FilesPageActions.checkedImagefileAddPage("File5.jpg");
        FilesPageActions.uploadFileNotPresent();
        FilesPageActions.clickSaveBtn();
        FilesPageActions.successfullyMessage();
        FileListingPageActions.clickProfileTab();
        FileListingPageActions.deletedFileListing("Image");
        FileListingPageActions.checkFileAddedDate("New File");
        FileListingPageActions.checkedFileEditBtn("New File");
        FileListingPageActions.checkedFileDownloadBtn("New File");
        FileListingPageActions.checkedFileDeleteBtn("New File");
        FileListingPageActions.checkedFileAddedDateInDropdown();
        FileListingPageActions.clickFileDeleteBtn("New File");
        FileListingPageActions.deletePopupWebElement();
        FileListingPageActions.clickNoButton();
        FileListingPageActions.clickFileDeleteBtn("New File");
        FileListingPageActions.clickYesButton();
        FileListingPageActions.deletedFileListing("New File");
        Assert.assertTrue(CommonPageActions.verification().contains("File Listing"));
        BaseClass.softAssert().assertAll();
        BasePatientLifeCyclePageActions.clickOnDashBoard();

    }

    @Test(groups = {"Functional","Regression"},enabled = true,priority = 9)
    //Checked functionality of reset and cancel button
    public void resetCancelFunctionality(){
        logger.log(Status.PASS, RESET_CANCEL_FUNCTIONALITY);
//        CommonPageActions.selectClinicFrmHeader("Hinjewadi");
//		DoctorDashBoardPageActions.clickonAppointmentAdd();
//		CommonPageActions.enterMobileNo(MOBILE_NUMBER);
//		CommonPageActions.clickOnSearchBtn();
//		AppointmentsLisitngPageActions.clickOnLastPagePatientListing();
//
//		CommonPageActions.clickOnPatient(MOBILE_NUMBER,PATIENT_NAME);
		PatientDashboardPageActions.hideDueWarningPopup();

        PatientDashboardPageActions.clickOnFilesAdd();
        FilesPageActions.singleFileUploadBtn(System.getProperty("user.dir")+"\\PatientFiles\\File1.jpg");
        FilesPageActions.checkDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.checkedImagefileAddPage("File1.jpg");
        FilesPageActions.selectCategory("Oral Images");
        FilesPageActions.checkFileNameCheckbox();
        FilesPageActions.enterTitleFile("testing-Title");
        FilesPageActions.enterNotes("notes testing");
        FilesPageActions.clickResetBtn();
        FilesPageActions.getFirstSelectOptions("Select Category");
        FilesPageActions.fileTitleWebElementCheckBoxNotSelected();
        FilesPageActions.getFileName("");
        FilesPageActions.getFileNotes("");
        FilesPageActions.fileUploadBtnDisplayed();
        FilesPageActions.checkDeleteBtnFileAddPage("File1.jpg");
        FilesPageActions.checkedImagefileAddPage("File1.jpg");
        FilesPageActions.clickCancelBtn();
        CommonPageActions.verification().contains("Patient Dashboard");
        BasePatientLifeCyclePageActions.clickOnAlert();
        PatientDashboardPageActions.clickOnFilesAdd();
        CommonPageActions.verification().contains("Files");
        BasePatientLifeCyclePageActions.clickOnDashBoard();

    }
}
