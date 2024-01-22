package tests;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import org.apache.commons.math3.primes.Primes;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pageActions.patientDashboard.CampSubscriberPageActions;

public class CampSubscriberTestCase extends BaseClass {

	private static final String NAVIGATE_SUBSCRIBER_LISTING = "@@ Test scripts has been started here @@";
	private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";

	@BeforeMethod
	public void testSetup() {
		DoctorDashBoardPageActions.clickCampSubscriberList();
		DoctorDashBoardPageActions.clickCampSubscriberAdd();

	}

	@Test(priority = 1)
	public void campInfoPage() {

		CampSubscriberPageActions.headerPage();
		CampSubscriberPageActions.creationDate();
		CampSubscriberPageActions.checkedNextBtn();
		CampSubscriberPageActions.checkedCancelBtn();
		CampSubscriberPageActions.headerCampInfo();
		// CampSubscriberPageActions.subscriberType();
		// [Sumit, 9-Jan-24] : Commented the code since field is not available now
		CampSubscriberPageActions.regionDropDown();
		CampSubscriberPageActions.zoneDropDown();
		CampSubscriberPageActions.campaignDropDown();
		CampSubscriberPageActions.sourceDropDown();
		CampSubscriberPageActions.subSourceTextFields();
		Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(priority = 2)
	public void errorMessageCampInfo() {
		/*
		 * CampSubscriberPageActions.selectCampaign("Others");
		 * CampSubscriberPageActions.selectSource("Other-NA");
		 * CampSubscriberPageActions.enterSubSource("Sub-source");
		 * CampSubscriberPageActions.clickNextBtn();
		 * CampSubscriberPageActions.selectRegionErr();
		 * CampSubscriberPageActions.selectZoneErr();
		 * BaseClass.refreshPageAndWaitTillGettingActive();
		 * CampSubscriberPageActions.selectRegion("Maharashtra");
		 * CampSubscriberPageActions.selectSource("Other-NA");
		 * CampSubscriberPageActions.enterSubSource("Sub-source");
		 * CampSubscriberPageActions.clickNextBtn();
		 * CampSubscriberPageActions.selectCampaignErr();
		 * BaseClass.refreshPageAndWaitTillGettingActive();
		 * CampSubscriberPageActions.selectRegion("Maharashtra");
		 * CampSubscriberPageActions.selectCampaign("Others");
		 * CampSubscriberPageActions.enterSubSource("Sub-source");
		 * CampSubscriberPageActions.clickNextBtn();
		 * BaseClass.refreshPageAndWaitTillGettingActive();
		 */
		CampSubscriberPageActions.selectRegion("Maharashtra");
		CampSubscriberPageActions.selectCampaign("Others");
		CampSubscriberPageActions.selectSource("Other-NA");
		CampSubscriberPageActions.clickNextBtn();
		CampSubscriberPageActions.enterSubSourceErr();
		CampSubscriberPageActions.clickCancelBtn();
		Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
	}

	@Test(priority = 3)
	public void campSubsAddPage() {
		CampSubscriberPageActions.selectRegion("Maharashtra");
		CampSubscriberPageActions.selectCampaign("Others");
		CampSubscriberPageActions.selectSource("Other-NA");
		CampSubscriberPageActions.enterSubSource("Sub-source");
		CampSubscriberPageActions.clickNextBtn();
		CampSubscriberPageActions.headerPage();
		CampSubscriberPageActions.creationDate();
		CampSubscriberPageActions.checkedSaveBtn();
		CampSubscriberPageActions.checkedResetBtn();
		CampSubscriberPageActions.checkedCancelBtn();
		CampSubscriberPageActions.headerCampInfo();
		CampSubscriberPageActions.openCloseCampInfo();
//		CampSubscriberPageActions.subscriberType();// This Filed removed
		CampSubscriberPageActions.selectedRegion("Maharashtra");
		CampSubscriberPageActions.selectedZone("Pune");
		CampSubscriberPageActions.selectedCampaign("Others");
		CampSubscriberPageActions.selectedSource("Other-NA");
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
//		CampSubscriberPageActions.enquiryDetails("Braces","High","Brand","Implant","Medium");
		
//		CampSubscriberPageActions.interestLevel();// This filed remove 
//		CampSubscriberPageActions.checkedFindings();// This Filed Remove
//		CampSubscriberPageActions.findingBox("Braces");// Removed
//		CampSubscriberPageActions.findingBox("Fluoride application & Scaling");
//		CampSubscriberPageActions.findingBox("Filling/RCT");
//		CampSubscriberPageActions.findingBox("Implant");
//    	CampSubscriberPageActions.findingBox("Prostho");
//		BaseClass.scrollPage(500);//
//		CampSubscriberPageActions.headerMembership();// Removed
//		CampSubscriberPageActions.membershipDropDown();// Remove
//		CampSubscriberPageActions.enterTrtSearchBox("Dental Health Plan 2.0  (550.00)");// Remove
//		CampSubscriberPageActions.selectMembershipTrt(); // Removed
//		BaseClass.scrollPage(500);// Removed
//		CampSubscriberPageActions.paymentMode();// Removed
//		CampSubscriberPageActions.cashMode();// Removed
//		CampSubscriberPageActions.chequeMode();// Removed
//		CampSubscriberPageActions.netBankingMode();// Removed
//		CampSubscriberPageActions.cardMode();// Removed
//		CampSubscriberPageActions.walletMode();// Removed
		Assert.assertTrue(CommonPageActions.verification().contains("Camp Subscriber"));
		CommonPageActions.backTODoctorDashboard();
	}

	@Test(priority = 4)
	public void mandatoryFieldsSubsAdd() {
		CampSubscriberPageActions.selectRegion("Maharashtra");
		CampSubscriberPageActions.selectCampaign("Others");
		CampSubscriberPageActions.selectSource("Other-NA");
		CampSubscriberPageActions.enterSubSource("Sub-source");
		CampSubscriberPageActions.clickNextBtn();
		CampSubscriberPageActions.enterAge("16");
		CampSubscriberPageActions.enterMobile("1111111111");
		CampSubscriberPageActions.clickSaveBtn();
		CampSubscriberPageActions.error("Select gender");
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
//		CampSubscriberPageActions.enterMobile("0");
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
	public void newSubscriber() {
		CampSubscriberPageActions.selectRegion("Maharashtra");
		CampSubscriberPageActions.selectCampaign("Others");
		CampSubscriberPageActions.selectSource("Other-NA");
		CampSubscriberPageActions.enterSubSource("Sub-source32");
		CampSubscriberPageActions.clickNextBtn();
		CampSubscriberPageActions.headerNewSubscriber();
		 
//		CampSubscriberPageActions.enquiryDetails("Braces","High","Brand","Implant","Medium");

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
