package pageActions.doctorDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.FeedbackListingPage;
import java.util.List;

/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class FeedbackListingPageActions extends BaseClass {

	static FeedbackListingPage feedbackListPage= PageFactory.initElements(driver, FeedbackListingPage.class);
	
    public static void clickOnDashboard(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        feedbackListPage.getDoctorDashBoardBtn().click();
        BaseClass.waitForSpinnerToDisappear();
        
    }
    public static void headerFeedbackView(String header){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getHeaderFeedbackViewModal().getText().trim(),header);
    }

    public static void patientNameInView(String patientName){
    	BaseClass.waitForPageLoad();
        String str = feedbackListPage.getPatientName_PatientId().getText();
        String[] split = str.split(":");
        Assert.assertTrue(split[0].trim().contains(patientName)&&(!split[1].contains("")||!split[1].contains("NA")));
    }

    public static void checkFeedbackDetailsHeader(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getFeedbackDetailsInView())&&checkedWebElementDisplayed(feedbackListPage.getRatingHeaderInView()));
    }

    public static void clinicNameFeedbackView(String clinic){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getClinicNameInView().getText().trim(),clinic);
    }

    public static void emailIdFeedbackView(String email){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getClinicNameInView().getText().trim(),email);
    }

    public static void addressFeedbackView(String address){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getAddressInView().getText().trim(),address);
    }

    public static void submittionDateFeedbackView(String submitDate){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getSubmissionDateInView().getText().trim(),submitDate);
    }

    public static void serialNoFeedbackView(String serialNo){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getSerialNoInView().getText().trim(),serialNo);
    }

    public static void feedbackTypeInView(String feedBackType){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getFeedbackTypeInViewModal().getText(),feedBackType);
    }

    public static void mobileNoFeedbackView(String Mobile){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getMobileInView().getText().trim(),feedbackListPage.getMobile());
    }

    public static void ratingFeedbackViewModal(String rating){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackListPage.getRatingInView().getText().contains(rating));
    }

    public static void reasonFeedbackViewModal(String reason){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackListPage.getReasonInView().getText().contains(reason));
    }

    public static void remarkFeedbackViewModal(String remark){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(feedbackListPage.getRemarkInView().getText().contains(remark));
    }

    public static void closeFeedBackViewModal(){
    	BaseClass.waitForPageLoad();
    	BaseClass.waitForSpinnerToDisappear();
        feedbackListPage.getCloseBtnInView().click();
        BaseClass.waitForSpinnerToDisappear();
        
    }

    public static void feedbackListingColumnName() {
    	BaseClass.waitForPageLoad();
    	BaseClass.waitForSpinnerToDisappear();
            Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getSub_Created_date()) && checkedWebElementDisplayed(feedbackListPage.getType()) && checkedWebElementDisplayed(feedbackListPage.getPatient_Name_Id()) && checkedWebElementDisplayed(feedbackListPage.getMobile())
                    && checkedWebElementDisplayed(feedbackListPage.getEmail()) && checkedWebElementDisplayed(feedbackListPage.getSubmittedBy()) && checkedWebElementDisplayed(feedbackListPage.getAttachment()) && checkedWebElementDisplayed(feedbackListPage.getAction()));
     
    }

    public static void patientName_PatientId(String patientName){
    	BaseClass.waitForPageLoad();
        String str = driver.findElement(By.xpath("//span[contains(text(),'"+patientName+"')]/..")).getText();
        String[] split = str.split("\\R");
        Assert.assertTrue(split[0].trim().contains(patientName)&&!split[1].contains("NA"));
    }

    public static void feedbackType(String patientName,String feedbackType){
    	BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + patientName + "')]/../../preceding-sibling::td"));
        for(int i=0;web.size()>i;i++){
            if(i==1){
                Assert.assertEquals(web.get(i).getText(),feedbackType);
                break;
            }else{
                continue;
            }
        }
    }

    public static void mobileNumber(String patientName,String Mobile){
    	BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + patientName + "')]/../../following-sibling::td"));
        for(int i=0;web.size()>i;i++){
            if(i==0){
                Assert.assertEquals(web.get(i).getText(),feedbackListPage.getMobile());
                break;
            }else{
                continue;
            }
        }
    }

    public static void emailId(String patientName,String email){
    	BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + patientName + "')]/../../following-sibling::td"));
        for(int i=0;web.size()>i;i++){
            if(i==1){
                Assert.assertEquals(web.get(i).getText(),email);
                break;
            }else{
                continue;
            }
        }
    }

    public static void submittedBy(String patientName,String submittedBy){
    	BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + patientName + "')]/../../following-sibling::td"));
        for(int i=2;web.size()>i;i++){
            if(i==1){
                Assert.assertEquals(web.get(i).getText(),submittedBy);
                break;
            }else{
                continue;
            }
        }
    }

    public static void fileAttached(String patientName,String filename){
    	BaseClass.waitForPageLoad();
        WebElement web = driver.findElement(By.xpath(" //span[contains(text(),'" + patientName + "')]/../../following-sibling::td/a[contains(@href,'" + filename + "')]"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }

    public static void feedbackViewBtn(String patientName){
    	BaseClass.waitForPageLoad();
        WebElement web=driver.findElement(By.xpath(" //span[contains(text(),'" + patientName + "')]/../../following-sibling::td//span[@class='actn-icn view']"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }

    public static void clickFeedbackViewBtn(String patientName){
    	BaseClass.waitForPageLoad();
        try {
            WebElement web=driver.findElement(By.xpath(" //span[contains(text(),'" + patientName + "')]/../../following-sibling::td//span[@class='actn-icn view']"));
            web.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void feedbackEditBtn(String patientName){
    	BaseClass.waitForPageLoad();
        WebElement web=driver.findElement(By.xpath(" //span[contains(text(),'" + patientName + "')]/../../following-sibling::td//span[@class='actn-icn edit']"));
        Assert.assertTrue(checkedWebElementDisplayed(web));
    }

    public static void clickFeedbackEditBtn(String patientName){
    	BaseClass.waitForPageLoad();
        try {
            WebElement web=driver.findElement(By.xpath(" //span[contains(text(),'" + patientName + "')]/../../following-sibling::td//span[@class='actn-icn edit']"));
            web.click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void feedbackDate(String patientName,String feedbackDate){
    	BaseClass.waitForPageLoad();
        List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + patientName + "')]/../../preceding-sibling::td"));
        for(int i=0;web.size()>i;i++){
            if(i==0){
                Assert.assertTrue(web.get(i).getText().contains(feedbackDate));
                break;
            }else{
                continue;
            }
        }
    }

    public static void feedbackListingHeader(String header){
    	BaseClass.waitForPageLoad();
        Assert.assertEquals(feedbackListPage.getHeaderFeedBackListing().getText().trim(),header);
    }

    public static void feedbackTypeDropDown(String defaultFeedbackType) {
    	BaseClass.waitForPageLoad();
        boolean flag1, flag2, match = false;
        flag1 = checkedWebElementDisplayed(feedbackListPage.getFeedBackType()) && BaseClass.firstSelectedOption(feedbackListPage.getFeedBackType()).contains(defaultFeedbackType);
        String[] exp = {"Select Type", "First Visit", "Patient Feedback","Post Treatment"};
        Select select = new Select(feedbackListPage.getFeedBackType());
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            for (int i = 0; i < exp.length; i++) {
                if (flag2 = we.getText().equals(exp[i])) {
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }

    public static void feedbackSearchType(String defaultFeedbackType) {
        BaseClass.waitForPageLoad();
        boolean flag1, flag2, match = false;
        flag1 = checkedWebElementDisplayed(feedbackListPage.getSearchBy()) && BaseClass.firstSelectedOption(feedbackListPage.getSearchBy()).contains(defaultFeedbackType);
        String[] exp = {"Select Search By", "Doctors", "Patient"};
        Select select = new Select(feedbackListPage.getSearchBy());
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            for (int i = 0; i < exp.length; i++) {
                if (flag2 = we.getText().equals(exp[i])) {
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }

    public static void doctorDropDown(String firtstOption){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getDoctorDropDown()));
    }

    public static void detailsFields(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getDetails())&&feedbackListPage.getDetails().getAttribute("placeholder").contains("» name/email/mobile"));
    }

    public static void dateFilter(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getFromDate())&&feedbackListPage.getFromDate().getAttribute("placeholder").contains("» from (dd-mm-yy)")&&checkedWebElementDisplayed(feedbackListPage.getToDate())&&feedbackListPage.getToDate().getAttribute("placeholder").contains("» to (dd-mm-yy)"));
    }

    public static void createdRadioBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getCreated())&&!feedbackListPage.getCreated().isSelected());
    }
    public static void submittedRadioBtn(){
    	BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getSubmitted())&&!feedbackListPage.getSubmitted().isSelected());
    }
    public static void searchBtn(){
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getSearchBtn()));
    }
    public static void resetBtn(){
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getResetBtn()));
    }
    public static void noRecordFoundDisplayed(){
        Assert.assertTrue(checkedWebElementDisplayed(feedbackListPage.getNoRecordFound()));
    }
    private static boolean checkedWebElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }
}
