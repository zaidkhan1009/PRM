package pageActions.doctorDashboard;

import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.FeedbackAddPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.awt.*;

public class FeedbackAddPageActions extends BaseClass {

	static FeedbackAddPage feedbackPage = PageFactory.initElements(driver, FeedbackAddPage.class);
	
    public static void selectDentistInteractionRate_1(){
        BaseClass.waitForElementToBeClickable(feedbackPage.getDentistInteraction_1());
        driver.findElement(By.xpath("//div[@id='reasons_for_rating_1']//label[text()='Dentist Interaction']/..")).click();
    }

    public static void removeAttachedFile(){
    	BaseClass.waitForElementToBeClickable(feedbackPage.getFileRemoveBtn());
        try {
            Thread.sleep(1500);
            feedbackPage.getFileRemoveBtn().click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeFileRemove(){
    	BaseClass.waitForElementToBeClickable(feedbackPage.getNoRemoveBtn());
        feedbackPage.getNoRemoveBtn().click();
    }

    public static void yesFileRemove(){
    	BaseClass.waitForElementToBeClickable(feedbackPage.getYesRemoveBtn());
        try {
            feedbackPage.getYesRemoveBtn().click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*checking the rating of the feedback*/
    public static void rateCount(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getRate_1())&&checkedWebElementDisplayed(feedbackPage.getRate_2())&&checkedWebElementDisplayed(feedbackPage.getRate_3())&&checkedWebElementDisplayed(feedbackPage.getRate_4())&&checkedWebElementDisplayed(feedbackPage.getRate_5())
        &&checkedWebElementDisplayed(feedbackPage.getRate_6())&&checkedWebElementDisplayed(feedbackPage.getRate_7())&&checkedWebElementDisplayed(feedbackPage.getRate_8())&&checkedWebElementDisplayed(feedbackPage.getRate_9())&&checkedWebElementDisplayed(feedbackPage.getRate_10())&&checkedWebElementDisplayed(feedbackPage.getNotLikelyText())&&checkedWebElementDisplayed(feedbackPage.getVeryLikelyText()));
    }

    /*Checking the rate message*/
    public static void checkMessageRating(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getFeedbackRate()));
    }

    /*checking the header of the page*/
    public static void checkFeedBackHeader(String expected){
    	BaseClass.waitForSpinnerToDisappear();
        Assert.assertEquals(feedbackPage.getAddPageHeader().getText(), expected);
    }

    /*checking the patient name and patient id is not null*/
    public static void verifyPatientName(String patient) {
    	BaseClass.waitForPageLoad();
    	BaseClass.waitForElementToBeClickable(feedbackPage.getPatientName());
        String str = feedbackPage.getPatientName().getText();
        String[] split = str.split(" : ");
        boolean flag = split[0].contains(patient) && !(split[1].equals("NA") || split[1].equals("Null"));
        Assert.assertTrue(flag);
    }

    /*checking save button at add feedback button*/
    public static void checkSaveBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getSaveBtn()));
    }

    public static void savefeedBackAdd(){
    	BaseClass.waitForPageLoad();
        try {
            Thread.sleep(4000);
            feedbackPage.getSaveBtn().click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void checkResetBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getResetBtn()));
    }

    public static void resetfeedBackAdd(){
    	BaseClass.waitForPageLoad();
        try {
            feedbackPage.getResetBtn().click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void checkCancelBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getCancelBtn()));
    }

    public static void cancelfeedBackAdd(){
    	BaseClass.waitForPageLoad();
        feedbackPage.getCancelBtn().click();
    }

    public static void checkDashboardBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getDashBoardBtn()));
    }

    public static void clickDashBoard(){
    	BaseClass.waitForPageLoad();
        feedbackPage.getDashBoardBtn().click();
    }

    /*checking the top header text*/
    public static void topSectionFeedbackHeader(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackPage.getSectionTitleTop().isDisplayed());
    }

    /*checking the bottom header text*/
    public static void bottomSectionFeedbackHeader(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackPage.getSectionTitle().isDisplayed());
    }

    /*checking the bottom header text*/
    public static void feedbackType(String feedback_Type){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackPage.getFeedbackType().getText().trim().contains(feedback_Type));
    }

    /*checking feedback date web element displayed at feedback Add page*/
    public static void feedBackDateDisplayed(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getFeedBackDate()));
    }

    /*checking feedback serial number web element displayed at feedback Add page*/
    public static void feedBackSerialNumberDisplayed(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getSerialNumber())&&feedbackPage.getSerialNumber().getAttribute("placeholder").contains("serial no."));
    }

    /*checking feedback serial number web element displayed at feedback Add page*/
    public static void feedBackAddFilesDisplayed(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getAddFilesBtn()));
    }

    public static void feedbackDate(String expected){
        try {
            Thread.sleep(8000);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('feedbackDt').value;");
            String str = (String) obj;
            System.out.println("Date is : "+str);
            System.out.println("expected :"+expected);
            Assert.assertTrue(str.contains(expected));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void serialMandatoryFields(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getMandatorySerialNumber()));
    }

    public static void enterSerialNumber(String serialNo){
    	BaseClass.waitForPageLoad();
        feedbackPage.getSerialNumber().clear();
        feedbackPage.getSerialNumber().sendKeys(serialNo);
    }

    public static void toastMsgQuestions(){
    	BaseClass.waitForPageLoad();
        try {
            Thread.sleep(1000);
            Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getToastMessage()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectRating(int rateFeedback){
    	BaseClass.waitForPageLoad();
        WebElement[] array = {feedbackPage.getRate_1(), feedbackPage.getRate_2(), feedbackPage.getRate_3(), feedbackPage.getRate_4(), feedbackPage.getRate_5(), feedbackPage.getRate_6(), feedbackPage.getRate_7(), feedbackPage.getRate_8(), feedbackPage.getRate_9(), feedbackPage.getRate_10()};
        for(int i=1;array.length>=i;i++){
            if (i==rateFeedback){
                array[i-1].click();
                break;
            }else{
                continue;
            }
        }
    }

    public static void options_rating_1(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_1())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_1())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_1())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_1())
        &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_1())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_1())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_1()));
    }

    public static void options_rating_2(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_2())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_2())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_2())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_2())
                &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_2())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_2())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_2()));
    }
    public static void options_rating_3(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_3())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_3())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_3())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_3())
                &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_3())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_3())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_3()));
    }
    public static void options_rating_4(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_4())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_4())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_4())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_4())
                &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_4())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_4())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_4()));
    }
    public static void options_rating_5(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_5())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_5())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_5())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_5())
                &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_5())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_5())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_5()));
    }
    public static void options_rating_6(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_6())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_6())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_6())&&checkedWebElementDisplayed(feedbackPage.getPricesAndOffers_6())
                &&checkedWebElementDisplayed(feedbackPage.getWaitingTime_6())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_6())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_6()));
    }

    public static void options_rating_7(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_7())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_7())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_7())&&checkedWebElementDisplayed(feedbackPage.getRightCharges_7())
                &&checkedWebElementDisplayed(feedbackPage.getPreventiveMeasuresExplained_7())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_7())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_7()));
    }

    public static void options_rating_8(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_8())&&checkedWebElementDisplayed(feedbackPage.getDentistInteraction_8())&&checkedWebElementDisplayed(feedbackPage.getTreatmentQuality_8())&&checkedWebElementDisplayed(feedbackPage.getRightCharges_8())
                &&checkedWebElementDisplayed(feedbackPage.getPreventiveMeasuresExplained_8())&&checkedWebElementDisplayed(feedbackPage.getHygieneCleanliness_8())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_8()));
    }
    public static void options_rating_9(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_9())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_9()));
    }
    public static void options_rating_10(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackPage.getImprovementText_10())&&checkedWebElementDisplayed(feedbackPage.getFeedbacktextField_10()));
    }
    public static void fileUploadToastMsg(){
        try {
            Thread.sleep(1000);
            BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(feedbackPage.getUploadFileToastMsg()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deSelectRating(){
    	BaseClass.waitForPageLoad();
        WebElement[] array = {feedbackPage.getRate_1(), feedbackPage.getRate_2(), feedbackPage.getRate_3(), feedbackPage.getRate_4(), feedbackPage.getRate_5(), feedbackPage.getRate_6(), feedbackPage.getRate_7(), feedbackPage.getRate_8(), feedbackPage.getRate_9(), feedbackPage.getRate_10()};
        for(int i=0;array.length>i;i++){
                Assert.assertTrue(!array[i].getAttribute("class").contains("active"));
        }
    }

    public static void ratingSelected(int rate){
    	BaseClass.waitForPageLoad();
        WebElement[] array = {feedbackPage.getRate_1(), feedbackPage.getRate_2(), feedbackPage.getRate_3(), feedbackPage.getRate_4(), feedbackPage.getRate_5(), feedbackPage.getRate_6(), feedbackPage.getRate_7(), feedbackPage.getRate_8(), feedbackPage.getRate_9(), feedbackPage.getRate_10()};
        for(int i=1;array.length>i;i++){
            if(i==rate){
                Assert.assertTrue(array[i-1].getAttribute("class").contains("active"));
                break;
            }
           continue;
        }
    }

    public static void feedbackSerialNumber(String expected){
        try {
            Thread.sleep(8000);
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('serial').value;");
            String str = (String) obj;
            Assert.assertEquals(str,expected);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void uploadFeedbackFiles(String path){
    	BaseClass.waitForPageLoad();
        try {
            feedbackPage.getAddFilesBtn().click();
            Thread.sleep(4000);
            BaseClass.uploadFile(path);
            Thread.sleep(4000);
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addFeedbackNotes_rate_1(String notes){
    	BaseClass.waitForElementToBeClickable(feedbackPage.getFeedbacktextField_1());
        feedbackPage.getFeedbacktextField_1().sendKeys(notes);
    }

    public static void addFeedbackNotes_rate_9(String notes){
    	BaseClass.waitForElementToBeClickable(feedbackPage.getFeedbacktextField_9());
        feedbackPage.getFeedbacktextField_9().sendKeys(notes);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void editedFileFeedbackListing(String fileName){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(driver.findElement(By.xpath("//a[contains(@href,'"+fileName+"')]"))));
    }

    /*checking WebElement present*/
    private static boolean checkedWebElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }
}
