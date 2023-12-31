package tests;

import base.BaseClass;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.NewSubscriberPageActions;
import pageActions.doctorDashboard.SubscriberListingPageActions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriberListingTestCase extends BaseClass {
    

    private static final String NAVIGATE_SUBSCRIBER_LISTING = "@@ Test scripts has been started here @@";
    private static final String STATUS_OF_SCRIPTS = "@@ Test script has been completed @@";


    @Test(priority = 1)
    public void defaultWebElement(){
        SubscriberListingPageActions.headerSubscriberListing();
        SubscriberListingPageActions.newSubscriberAddBtn();
        SubscriberListingPageActions.appointmentAddBtn();
        SubscriberListingPageActions.complaintAddBtn();
        SubscriberListingPageActions.complaintsListingBtn();
        SubscriberListingPageActions.dropCallBtn();
        SubscriberListingPageActions.assignBtn();
        SubscriberListingPageActions.importBtn();
        SubscriberListingPageActions.csvFmtBtn();
        SubscriberListingPageActions.miscCallsAddBtn();
        SubscriberListingPageActions.miscCallsListBtn();
        SubscriberListingPageActions.dashBoardBtn();
        SubscriberListingPageActions.regionDropDown("Select Region");
        SubscriberListingPageActions.assigneeDropDown("Select Assignee");
        SubscriberListingPageActions.stageDropDown("Select Stage");
        SubscriberListingPageActions.details();
        SubscriberListingPageActions.fromDate();
        SubscriberListingPageActions.toDate();
        SubscriberListingPageActions.stage_Creation_Updation();
        SubscriberListingPageActions.searchBtn();
        SubscriberListingPageActions.advanceSearchBtn();
        SubscriberListingPageActions.resetBtn();
        SubscriberListingPageActions.openAdvanceFilter();
        SubscriberListingPageActions.typeDropDown("Select Type");
        SubscriberListingPageActions.sourceDropDown("Select Source");
        SubscriberListingPageActions.subSource();
        SubscriberListingPageActions.ageing();
        SubscriberListingPageActions.leadTypeDropDown("Select Lead Type");
        SubscriberListingPageActions.campaignDropDown("Select Campaign");
        SubscriberListingPageActions.findingDropDown("Select Finding");
        SubscriberListingPageActions.noRecordFound();
        Assert.assertTrue(CommonPageActions.verification().contains("Subscriber Listing"));
    }

    @Test(priority = 2)
    public void subscriberAddPage(){
        SubscriberListingPageActions.clickSubscriberAddBtn();
        NewSubscriberPageActions.nameTextField();
        NewSubscriberPageActions.genderRadioBtn();
        NewSubscriberPageActions.dobTextFields();
        NewSubscriberPageActions.emailIdTextFields();
        NewSubscriberPageActions.mobileTextFields();
        NewSubscriberPageActions.alternateContactNo();
        NewSubscriberPageActions.typeDropDown("Select Type");
        NewSubscriberPageActions.stageDropDown("New");
        NewSubscriberPageActions.campaignDropDown("Select Campaign");
        NewSubscriberPageActions.sourceDropDown("Select Source");
        NewSubscriberPageActions.subSourceTextFields();
        NewSubscriberPageActions.findingsDropDown();
        NewSubscriberPageActions.otherFindingTextFields();
        NewSubscriberPageActions.regionDropDown("Select Region");
        NewSubscriberPageActions.zoneDropDown("Select Zone");
        NewSubscriberPageActions.addFilesBtn();
        NewSubscriberPageActions.saveBtn();
        NewSubscriberPageActions.resetBtn();
        NewSubscriberPageActions.cancelBtn();
        Assert.assertTrue(CommonPageActions.verification().contains("New Subscriber"));
    }

}
