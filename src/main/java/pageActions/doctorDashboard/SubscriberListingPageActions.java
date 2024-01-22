package pageActions.doctorDashboard;

import base.BaseClass;
import pages.doctorDashboard.Login;
import pages.doctorDashboard.SubscriberListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubscriberListingPageActions extends BaseClass {
    
	static Login Login = PageFactory.initElements(driver, Login.class);
	static SubscriberListingPage subscriberListingPage = PageFactory.initElements(driver, SubscriberListingPage.class);
	
    
    public static void headerSubscriberListing(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getHeaderSubscriberListing()));
    }
    public static void newSubscriberAddBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getNewSubscriberAddBtn()));
    }
    public static void appointmentAddBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAppointmentAddBtn()));
    }
    public static void complaintAddBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getComplaintAddBtn()));
    }
    public static void complaintsListingBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getComplaintsListingBtn()));
    }
    public static void dropCallBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getDropCallBtn()));
    }
    public static void assignBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAssignBtn()));
    }
    public static void importBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getImportBtn()));
    }
    public static void csvFmtBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getCsvFmtBtn()));
    }
    public static void miscCallsListBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getMiscCallsListBtn()));
    }
    public static void miscCallsAddBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getMiscCallsAddBtn()));
    }
    public static void dashBoardBtn(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getDashBoardBtn()));
    }
    public static void regionDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getRegion());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getRegion())&&BaseClass.firstSelectedOption(subscriberListingPage.getRegion()).contains(firstOption));
    }
    public static void assigneeDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getAssignee());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAssignee()));
//        &&BaseClass.firstSelectedOption(subscriberListingPage.getAssignee()).contains(firstOption)
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAssignee())&&BaseClass.firstSelectedOption(subscriberListingPage.getAssignee()).contains(firstOption));
    }
    public static void stageDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getStage());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getStage())&&BaseClass.firstSelectedOption(subscriberListingPage.getStage()).contains(firstOption));
    }
    public static void details(){
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getDetails());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getDetails())&&subscriberListingPage.getDetails().getAttribute("placeholder").contains("details"));
    }
    public static void fromDate(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getFromDate());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getFromDate())&&subscriberListingPage.getFromDate().getAttribute("placeholder").contains("from (dd-mm-yy)"));
    }
    public static void toDate(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getToDate());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getToDate())&&subscriberListingPage.getToDate().getAttribute("placeholder").contains("to (dd-mm-yy)"));
    }
    public static void stage_Creation_Updation(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getStageRbtn());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getStageRbtn())&&checkedWebElementDisplayed(subscriberListingPage.getCreatedRbtn())&&checkedWebElementDisplayed(subscriberListingPage.getUpdatedRbtn()));
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getStageRbtn());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getStageRbtn())&&checkedWebElementDisplayed(subscriberListingPage.getStageRbtn())&&checkedWebElementDisplayed(subscriberListingPage.getUpdatedRbtn()));
    }
    public static void searchBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getSearchBtn());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getSearchBtn()));
    }
    public static void advanceSearchBtn(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(5000);
            BaseClass.waitForElementToBeClickable(subscriberListingPage.getAdvanceBtn());
            Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAdvanceBtn()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void resetBtn(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getResetBtn());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getResetBtn()));
    }
    public static void openAdvanceFilter(){
        BaseClass.waitForPageLoad();
        BaseClass.executeScript(subscriberListingPage.getAdvanceBtn());
    }
    public static void typeDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getType());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getType())&&BaseClass.firstSelectedOption(subscriberListingPage.getType()).contains(firstOption));
    }
    public static void sourceDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getSource());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getSource())&&BaseClass.firstSelectedOption(subscriberListingPage.getSource()).contains(firstOption));
    }

    public static void sourceDropDown(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getSource());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getSource()));
        }

    public static void subSource(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getSubsource());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getSubsource())&&subscriberListingPage.getSubsource().getAttribute("placeholder").contains("sub-source"));
    }
    public static void ageing(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getAge());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getAge())&&subscriberListingPage.getAge().getAttribute("placeholder").contains("age in day(s)"));
    }
    public static void leadTypeDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getLeadType());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getLeadType())&&BaseClass.firstSelectedOption(subscriberListingPage.getLeadType()).contains(firstOption));
    }
    public static void campaignDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getCampaign());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getCampaign())&&BaseClass.firstSelectedOption(subscriberListingPage.getCampaign()).contains(firstOption));
    }
    public static void findingDropDown(String firstOption){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getFinding());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getFinding())&&BaseClass.firstSelectedOption(subscriberListingPage.getFinding()).contains(firstOption));
    }
    public static void noRecordFound(){
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getNoRecordFound());
        Assert.assertTrue(checkedWebElementDisplayed(subscriberListingPage.getNoRecordFound()));
    }
    public static void clickSubscriberAddBtn(){
        BaseClass.waitForElementToBeClickable(subscriberListingPage.getNewSubscriberAddBtn());
        subscriberListingPage.getNewSubscriberAddBtn().click();
    }
    private static boolean checkedWebElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }
}
