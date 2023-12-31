package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.patientDashboard.CampSubscriberPageActions;

public class CampSubscriberTestCase extends BaseClass{

    private static final String NAVIGATE_SUBSCRIBER_LISTING = "@@ Test scripts has been started here @@";
    private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";


    @Test(priority = 1)
    public void campInfoPage(){
        CampSubscriberPageActions.headerPage();
        CampSubscriberPageActions.creationDate();
        CampSubscriberPageActions.checkedNextBtn();
        CampSubscriberPageActions.checkedCancelBtn();
        CampSubscriberPageActions.headerCampInfo();
        CampSubscriberPageActions.subscriberType();
        CampSubscriberPageActions.regionDropDown();
        CampSubscriberPageActions.zoneDropDown();
        CampSubscriberPageActions.campaignDropDown();
        CampSubscriberPageActions.sourceDropDown();
        CampSubscriberPageActions.subSourceTextFields();
        Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
    }

    @Test(priority = 2)
    public void errorMessageCampInfo(){
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.enterSubSource("Sub-source");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.selectRegionErr();
        CampSubscriberPageActions.selectZoneErr();
        driver.navigate().refresh();
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.enterSubSource("Sub-source");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.selectCampaignErr();
        driver.navigate().refresh();
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.enterSubSource("Sub-source");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.selectSubscriberSourceErr();
        driver.navigate().refresh();
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.enterSubSourceErr();
        CampSubscriberPageActions.clickCancelBtn();
        Assert.assertTrue(CommonPageActions.verification().contains("Doctor Dashboard"));
    }

    @Test(priority = 3)
    public void campSubsAddPage(){
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.enterSubSource("Sub-source");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.headerPage();
        CampSubscriberPageActions.creationDate();
        CampSubscriberPageActions.checkedSaveBtn();
        CampSubscriberPageActions.checkedResetBtn();
        CampSubscriberPageActions.checkedCancelBtn();
        CampSubscriberPageActions.headerCampInfo();
        CampSubscriberPageActions.openCloseCampInfo();
        CampSubscriberPageActions.subscriberType();
        CampSubscriberPageActions.selectedRegion("Maharashtra");
        CampSubscriberPageActions.selectedZone("Pune");
        CampSubscriberPageActions.selectedCampaign("CSR");
        CampSubscriberPageActions.selectedSource("Facebook");
        CampSubscriberPageActions.selectedSubSource("Sub-source");
        CampSubscriberPageActions.openCloseCampInfo();
        CampSubscriberPageActions.headerNewSubscriber();
        CampSubscriberPageActions.nameTextFields();
        CampSubscriberPageActions.genderRadio();
        CampSubscriberPageActions.dobTextFields();
        CampSubscriberPageActions.ageTextFields();
        CampSubscriberPageActions.emailTextFields();
        CampSubscriberPageActions.mobileTextFields();
        CampSubscriberPageActions.notifications();
        CampSubscriberPageActions.enterEmail("dental@gmail.com");
        CampSubscriberPageActions.notificationsSelected();
        CampSubscriberPageActions.fileUploadBtn();
        CampSubscriberPageActions.interestLevel();
        CampSubscriberPageActions.checkedFindings();
        CampSubscriberPageActions.findingBox("Braces");
        CampSubscriberPageActions.findingBox("Fluoride application & Scaling");
        CampSubscriberPageActions.findingBox("Filling/RCT");
        CampSubscriberPageActions.findingBox("Implant");
        CampSubscriberPageActions.findingBox("Prostho");
        BaseClass.scrollPage(500);
        CampSubscriberPageActions.headerMembership();
        CampSubscriberPageActions.membershipDropDown();
        CampSubscriberPageActions.enterTrtSearchBox("Dental Health Plan 2.0  (550.00)");
        CampSubscriberPageActions.selectMembershipTrt();
        BaseClass.scrollPage(500);
        CampSubscriberPageActions.paymentMode();
        CampSubscriberPageActions.cashMode();
        CampSubscriberPageActions.chequeMode();
        CampSubscriberPageActions.netBankingMode();
        CampSubscriberPageActions.cardMode();
        CampSubscriberPageActions.walletMode();
        Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
    }

    @Test(priority = 4)
    public void mandatoryFieldsSubsAdd(){
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.enterSubSource("Sub-source");
        CampSubscriberPageActions.clickNextBtn();
        CampSubscriberPageActions.enterAge("16");
        CampSubscriberPageActions.enterMobile("1111111111");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter Subscriber's Name");
        CampSubscriberPageActions.clickResetBtn();
        CampSubscriberPageActions.enterName("Camp Test");
        CampSubscriberPageActions.enterMobile("1111111111");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter Valid Age");
        CampSubscriberPageActions.clickResetBtn();
        CampSubscriberPageActions.enterName("Camp Test");
        CampSubscriberPageActions.enterMobile("1111111111");
        CampSubscriberPageActions.enterAge("12");
        CampSubscriberPageActions.enterEmail("abc");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter valid email address!");
        CampSubscriberPageActions.clickResetBtn();
        CampSubscriberPageActions.enterName("Camp Test");
        CampSubscriberPageActions.enterAge("12");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter Mobile No.");
        CampSubscriberPageActions.clickResetBtn();
        CampSubscriberPageActions.enterName("Camp Test");
        CampSubscriberPageActions.enterAge("12");
        CampSubscriberPageActions.enterMobile("0");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter Valid Mobile No.");
        CampSubscriberPageActions.clickResetBtn();
        CampSubscriberPageActions.enterName("Camp Test");
        CampSubscriberPageActions.enterAge("12");
        CampSubscriberPageActions.enterMobile("1234");
        CampSubscriberPageActions.clickSaveBtn();
        CampSubscriberPageActions.error("Enter 10 Digit Mobile No.");
        Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
    }

    @Test(priority = 5)
    public void newSubscriber(){
        CampSubscriberPageActions.selectRegion("Maharashtra");
        CampSubscriberPageActions.selectCampaign("CSR");
        CampSubscriberPageActions.selectSource("Facebook");
        CampSubscriberPageActions.enterSubSource("Sub-source32");
        CampSubscriberPageActions.clickNextBtn();
//        CampSubscriberPageActions.enterName("test21345");
//        CampSubscriberPageActions.enterAge("16");
//        CampSubscriberPageActions.enterMobile("1111111111");
//        CampSubscriberPageActions.clickSaveBtn();
        BaseClass.scrollPage(700);
        CampSubscriberPageActions.inputListColumn();
        CampSubscriberPageActions.nameInputList("test21345");
        CampSubscriberPageActions.mobileEmailInput("1111111111","NA");
        CampSubscriberPageActions.findingsInput("NA");
        CampSubscriberPageActions.membershipInput("NA");
        CampSubscriberPageActions.paymentModeInput("NA");
        CampSubscriberPageActions.amountInput("NA");
        CampSubscriberPageActions.viewInput();
//        CampSubscriberPageActions.editInput();
//        CampSubscriberPageActions.deleteInput();
        CampSubscriberPageActions.openView("test21345");
        CampSubscriberPageActions.headerViewModal();
        CampSubscriberPageActions.creationDateView();
        CampSubscriberPageActions.nameSubView("test21345");
        CampSubscriberPageActions.mobileSubView("1111111111");
        CampSubscriberPageActions.emailSubView("NA");
        CampSubscriberPageActions.genderSubView("Male");
        CampSubscriberPageActions.ageSubView("16");
        CampSubscriberPageActions.typeSubView("Outbound");
        CampSubscriberPageActions.regionSubView("Maharashtra");
        CampSubscriberPageActions.zoneSubView("Pune");
        CampSubscriberPageActions.campaignSubView("CSR");
        CampSubscriberPageActions.sourceSubView("Facebook");
        CampSubscriberPageActions.subSourceSubView("Sub-source32");
        CampSubscriberPageActions.findingsSubView("NA");
        CampSubscriberPageActions.closeViewModal();
        Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
    }

}
