package pageActions.patientDashboard;

import base.BaseClass;
import pages.patientDashboard.CampSubscriberPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CampSubscriberPageActions extends BaseClass {
    
	static CampSubscriberPage campSubscriberPage = PageFactory.initElements(driver, CampSubscriberPage.class);

	
    //Reusable functions of the camp add page
    public static void headerPage(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getHeaderPage());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getHeaderPage()));
    }

    //Creation date Camp Subscriber(s)
    public static void creationDate(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCreationDate());
        String createdDate = campSubscriberPage.getCreationDate().getText().trim();
        LocalDate localDate=LocalDate.now();
        String date2 = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Assert.assertEquals(createdDate,date2);
    }

    //Checking the next button and clicking on Next button
    public static void checkedNextBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getNextBtn());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getNextBtn()));
    }
    public static void clickNextBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getNextBtn());
        campSubscriberPage.getNextBtn().click();
    }

    //Checking the cancel button and clicking on the cancel Button
    public static void checkedCancelBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCancelBtn());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getCancelBtn()));
    }
    public static void clickCancelBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCancelBtn());
        campSubscriberPage.getCancelBtn().click();
    }

    //Checking the cancel button and clicking on the cancel Button
    public static void checkedResetBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getResetBtn());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getResetBtn()));
    }
    public static void clickResetBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getResetBtn());
        BaseClass.executeScript(campSubscriberPage.getResetBtn());
    }

    //Checking the cancel button and clicking on the cancel Button
    public static void checkedSaveBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSaveBtn());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getSaveBtn()));
    }
    public static void clickSaveBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSaveBtn());
        BaseClass.executeScript(campSubscriberPage.getSaveBtn());
    }

    //Checking Camp Info header
    public static void headerCampInfo(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCampInfo());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getCampInfo()));
    }
    public static void openCloseCampInfo(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCampInfo());
        campSubscriberPage.getCampInfo().click();
    }

    //Checking Type header and options selected
    public static void subscriberType(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getType());
        Assert.assertEquals(campSubscriberPage.getType().getText().trim(),"Outbound");
    }

    //Checking Region header,Dropdown,options and first options selected
    public static void regionDropDown() {
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getRegionDropDown());
        boolean flag1, flag2, match = false;
        flag1 = checkedWebElementDisplayed(campSubscriberPage.getRegionHeader()) && checkedWebElementDisplayed(campSubscriberPage.getRegionDropDown()) && BaseClass.firstSelectedOption(campSubscriberPage.getRegionDropDown()).contains("Select Region");
        String[] arr = {"Select Region", "Gujarat", "Maharashtra", "Rajasthan"};
        Select sel = new Select(campSubscriberPage.getRegionDropDown());
        List<WebElement> options = sel.getOptions();
        for (String we : arr) {
            for (int i = 0; i < options.size(); i++) {
                if (flag2 = we.equals(options.get(i).getText().trim())){
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }
    public static void selectRegion(String region){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getRegionDropDown());
        BaseClass.selectFromDropDownByVisibleText(campSubscriberPage.getRegionDropDown(),region);
    }

    //Checking the Zone
    public static void zoneDropDown(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getZoneHeader());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getZoneDropDown())&&checkedWebElementDisplayed(campSubscriberPage.getZoneHeader()));
    }

    //Checking the campaign header,dropdown,options and first options selected
    public static void campaignDropDown() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCampaignDropDown());
        boolean flag1, flag2, match = false;
        flag1 = checkedWebElementDisplayed(campSubscriberPage.getCampaignDropDown()) && BaseClass.firstSelectedOption(campSubscriberPage.getCampaignDropDown()).contains("Select Campaign")&&checkedWebElementDisplayed(campSubscriberPage.getCampaignHeader());
        String[] exp = {"Select Campaign", "Aatman", "Braces","CRM","CSR","Digital","Generic Dental","Implant","International Patients","Kids Campaign","Other","Practo","Pratapa Rao","Preventive Oral Health","Ritika Singh","Smile Makeover","Special Day Offer","TTYD"};
        Select select = new Select(campSubscriberPage.getCampaignDropDown());
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            for (int i = 0; i < exp.length; i++) {
                if (flag2 = we.getText().trim().equals(exp[i])) {
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }
    public static void selectCampaign(String campaign){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCampaignDropDown());
        BaseClass.selectFromDropDownByVisibleText(campSubscriberPage.getCampaignDropDown(),campaign);
    }

    //Checking the source header,dropdown,options and first options selected
    public static void sourceDropDown() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSourceDropDown());
        boolean flag1, flag2, match = false;
        flag1 = checkedWebElementDisplayed(campSubscriberPage.getSourceDropDown()) && BaseClass.firstSelectedOption(campSubscriberPage.getSourceDropDown()).contains("Select Source")&&checkedWebElementDisplayed(campSubscriberPage.getSourceHeader());
        String[] exp = {"Select Source", "Ad-Newspaper", "Ad-Radio","Branding","Camp-CSR","Camp-Market","CDOP-Corporate","CDOP-Coupon/Leaflet","CDOP-Retail","CDOP-RWA","CDOP-School","Chat","Direct Email","Existing Patient","Facebook","Google","In-App","In-Clinic","Just Dial","Nearbuy Deals","Other","Practo","SEM","SMS","Walk-In","Website","Yahoo"};
        Select select = new Select(campSubscriberPage.getSourceDropDown());
        List<WebElement> options = select.getOptions();
        for (WebElement we : options) {
            for (int i = 0; i < exp.length; i++) {
                if (flag2 = we.getText().trim().equals(exp[i])) {
                    match = flag1 && flag2;
                }
            }
            Assert.assertTrue(match);
        }
    }
    public static void selectSource(String source){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSourceDropDown());
        BaseClass.selectFromDropDownByVisibleText(campSubscriberPage.getSourceDropDown(),source);
    }

    //Checking Sub-source text fields
    public static void subSourceTextFields(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSubSourceTextField());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getSubSourceHeader())&&checkedWebElementDisplayed(campSubscriberPage.getSubSourceTextField())&&campSubscriberPage.getSubSourceTextField().getAttribute("placeholder").contains("sub source"));
    }
    public static void enterSubSource(String subSource){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSubSourceTextField());
        campSubscriberPage.getSubSourceTextField().sendKeys(subSource);
    }

    //Mandatory error message
    public static void selectRegionErr(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSelectRegionErr());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getSelectRegionErr()));
    }
    public static void selectZoneErr(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSelectZoneErr());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getSelectZoneErr()));
    }
    public static void selectCampaignErr(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSelectCampaignErr());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getSelectCampaignErr()));
    }
    public static void selectSubscriberSourceErr(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSelectSubscriberSourceErr());
        Assert.assertTrue(campSubscriberPage.getSelectSubscriberSourceErr().getText().contains("Select Subscriber's Source"));
    }
    public static void enterSubSourceErr(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getEnterSubSourceErr());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getEnterSubSourceErr()));
    }

    //Checking Camp info data after selection
    public static void selectedRegion(String selected_Region){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getRegion());
        Assert.assertEquals(campSubscriberPage.getRegion().getText().trim(),selected_Region);
    }
    public static void selectedZone(String selected_Zone){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getZone());
        Assert.assertEquals(campSubscriberPage.getZone().getText().trim(),selected_Zone);
    }
    public static void selectedCampaign(String selected_Campaign){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCampaign());
        Assert.assertEquals(campSubscriberPage.getCampaign().getText().trim(),selected_Campaign);
    }
    public static void selectedSource(String selected_Source){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSource());
        Assert.assertEquals(campSubscriberPage.getSource().getText().trim(),selected_Source);
    }
    public static void selectedSubSource(String selected_SubSource){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getSubSource());
        Assert.assertEquals(campSubscriberPage.getSubSource().getText().trim(),selected_SubSource);
    }

    //new subscriber WebElement
    public static void headerNewSubscriber(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getNewSubscriberHeader());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getNewSubscriberHeader()));
    }

    //name WebElement and method
    public static void nameTextFields(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getName());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getName())&&checkedWebElementDisplayed(campSubscriberPage.getHeaderName())&&campSubscriberPage.getName().getAttribute("placeholder").contains("name"));
    }
    public static void enterName(String nameSub){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getName());
        campSubscriberPage.getName().clear();
        campSubscriberPage.getName().sendKeys(nameSub);
    }

    //Gender WebElement
    public static void genderRadio(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getHeaderGender())&&checkedWebElementDisplayed(campSubscriberPage.getMaleText())&&campSubscriberPage.getMale().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getFemaleText())&&!campSubscriberPage.getFemale().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getOtherText())&&!campSubscriberPage.getOther().isSelected());
    }
    public static void selectFemale(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getFemale());
        campSubscriberPage.getFemale().click();
    }
    public static void selectOther(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getOther());
        campSubscriberPage.getOther().click();
    }

    //Dob textFields
    public static void dobTextFields(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getDob());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getDob())&&checkedWebElementDisplayed(campSubscriberPage.getHeaderDob())&&campSubscriberPage.getDob().getAttribute("placeholder").contains("dd-mm-yyyy"));
    }
    public static void enterDob(String dobSubs){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getDob());
        campSubscriberPage.getDob().sendKeys(dobSubs);
    }

    //Age TextFields
    public static void ageTextFields(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getAge());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getAge())&&checkedWebElementDisplayed(campSubscriberPage.getHeaderAge())&&campSubscriberPage.getAge().getAttribute("placeholder").contains("age"));
    }
    public static void enterAge(String ageSubs){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getAge());
        campSubscriberPage.getAge().sendKeys(ageSubs);
    }

    //Email WebElement
    public static void emailTextFields(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getEmail());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getEmail())&&checkedWebElementDisplayed(campSubscriberPage.getHeaderEmail())&&campSubscriberPage.getEmail().getAttribute("placeholder").contains("email"));
    }
    public static void enterEmail(String emailSub){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getEmail());
        campSubscriberPage.getEmail().clear();
        campSubscriberPage.getEmail().sendKeys(emailSub);
    }
    //Mobile WebElement
    public static void mobileTextFields(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getMobile())&&checkedWebElementDisplayed(campSubscriberPage.getHeaderMobile())&&campSubscriberPage.getMobile().getAttribute("placeholder").contains("enter 10 digit mobile no"));
    }
    public static void enterMobile(String mobileSub){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getMobile());
        campSubscriberPage.getMobile().clear();
        campSubscriberPage.getMobile().sendKeys(mobileSub);
    }
    public static void notifications(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(campSubscriberPage.getCallCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getCallText())&&campSubscriberPage.getSmsCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getSmsText())
        &&!campSubscriberPage.getEmailCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getEmailText()));
    }
    public static void notificationsSelected(){
        BaseClass.waitForPageLoad();
        try {
            campSubscriberPage.getHeaderEmail().click();
            Thread.sleep(2000);
            Assert.assertTrue(campSubscriberPage.getCallCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getCallText())&&campSubscriberPage.getSmsCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getSmsText())
                    &&campSubscriberPage.getEmailCheckBox().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getEmailText()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //File upload webElement
    public static void fileUploadBtn(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getAddFilesBtn());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getAddFilesBtn()));
    }
    public static void uploadFiles(String filePath){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getAddFilesBtn());
        try {
            BaseClass.uploadFile(filePath);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //Subscriber interest level
    public static void interestLevel(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getInterestLevel());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getInterestLevel())&&!campSubscriberPage.getIntrstLevelLow().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getIntrstLevelLowText())
                &&!campSubscriberPage.getIntrstLevelMedium().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getIntrstLevelMediumText())
                &&!campSubscriberPage.getIntrstLevelHigh().isSelected()&&checkedWebElementDisplayed(campSubscriberPage.getIntrstLevelHighText()));
    }
    public static void lowInterest(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getIntrstLevelLow());
        campSubscriberPage.getIntrstLevelLow().click();
    }
    public static void mediumInterest(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getIntrstLevelMedium());
        campSubscriberPage.getIntrstLevelMedium().click();
    }public static void highInterest(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getIntrstLevelHigh());
        campSubscriberPage.getIntrstLevelHigh().click();
    }

    //checking Findings Header
    public static void checkedFindings(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getHeaderFindings());
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getHeaderFindings()));
    }
    public static void findingBox(String findingsSub){
        BaseClass.visibilityOfListLocated(campSubscriberPage.getFindingsBox());
        int count = campSubscriberPage.getFindingsBox().size();
        for (int i=0;i<count;i++){
            if(campSubscriberPage.getFindingsBox().get(i).getText().trim().contains(findingsSub)){
                Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getFindingsBox().get(i)));
            }else{
                continue;
            }
        }
    }

    //Membership WebElement
    public static void headerMembership(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getMembershipHeader())&&checkedWebElementDisplayed(campSubscriberPage.getMembershipDrpDwnHeader()));
    }
    public static void membershipDropDown(){
        BaseClass.waitForPageLoad();
        campSubscriberPage.getMembershipDropDown().click();
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getMembershipDropDown())&&checkedWebElementDisplayed(campSubscriberPage.getSearchBoxMembership())&&checkedWebElementDisplayed(campSubscriberPage.getDentalHealthPlan2())&&checkedWebElementDisplayed(campSubscriberPage.getDentalHealthPlan3()));
    }
    public static void enterTrtSearchBox(String trt){
        BaseClass.waitForPageLoad();
        campSubscriberPage.getSearchBoxMembership().sendKeys(trt);
    }
    public static void selectMembershipTrt(){
        BaseClass.waitForPageLoad();
        campSubscriberPage.getDentalHealthPlan2().click();
    }
    //WebElement of payment modes
    public static void paymentMode(){
        BaseClass.waitForPageLoad();
        Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getHeaderPaymentMode())&&checkedWebElementDisplayed(campSubscriberPage.getAmountHeader()));
    }
    //cash mode option validation
    public static void cashMode(){
        BaseClass.waitForPageLoad();
        if(!campSubscriberPage.getCash().isSelected()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BaseClass.executeScript(campSubscriberPage.getCash());
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('1').value;");
            String str = (String) obj;
            Assert.assertTrue(!(str==null));
        }else{
            Assert.fail();
        }
    }
    //Cheque mode option validation
    public static void chequeMode(){
        BaseClass.waitForPageLoad();
        if(!campSubscriberPage.getCheque().isSelected()){
            BaseClass.executeScript(campSubscriberPage.getCheque());
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('3').value;");
            String str = (String) obj;
            Assert.assertTrue(!(str==null));
        }else{
            Assert.fail();
        }
    }
    //NetBanking mode option validation
    public static void netBankingMode(){
        BaseClass.waitForPageLoad();
        if(!campSubscriberPage.getNetBanking().isSelected()){
            BaseClass.executeScript(campSubscriberPage.getNetBanking());
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('4').value;");
            String str = (String) obj;
            Assert.assertTrue(!(str==null));
        }else{
            Assert.fail();
        }
    }
    //card mode option validation
    public static void cardMode(){
        BaseClass.waitForPageLoad();
        if(!campSubscriberPage.getCard().isSelected()){
            BaseClass.executeScript(campSubscriberPage.getCard());
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('3').value;");
            String str = (String) obj;
            Assert.assertTrue(!(str==null));
            boolean flag1, flag2, match = false;
            flag1 = checkedWebElementDisplayed(campSubscriberPage.getSubType()) && checkedWebElementDisplayed(campSubscriberPage.getSubTypeDropDown()) && BaseClass.firstSelectedOption(campSubscriberPage.getSubTypeDropDown()).contains("Select Type");
            String[] arr = {"Card", "Bajaj Finance", "EMI", "Liquiloan"};
            Select sel = new Select(campSubscriberPage.getSubTypeDropDown());
            List<WebElement> options = sel.getOptions();
            for (String we : arr) {
                for (int i = 0; i < options.size(); i++) {
                    if (flag2 = we.equals(options.get(i).getText().trim())){
                        match = flag1 && flag2;
                    }
                }
                Assert.assertTrue(match);
            }
        }else{
            Assert.fail();
        }
    }
    //Wallet mode option validation
    public static void walletMode(){
        BaseClass.waitForPageLoad();
        if(!campSubscriberPage.getWallet().isSelected()){
            BaseClass.executeScript(campSubscriberPage.getWallet());
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            Object obj = javascriptExecutor.executeScript("return document.getElementById('6').value;");
            String str = (String) obj;
            Assert.assertTrue(!(str==null));
            boolean flag1, flag2, match = false;
            flag1 = checkedWebElementDisplayed(campSubscriberPage.getSubType()) && checkedWebElementDisplayed(campSubscriberPage.getSubTypeDropDown()) && BaseClass.firstSelectedOption(campSubscriberPage.getSubTypeDropDown()).contains("Select Type");
            String[] arr = {"PayTm", "Clove Voucher", "UPI", "Clove DHP Card","Religare Insurance"};
            Select sel = new Select(campSubscriberPage.getSubTypeDropDown());
            List<WebElement> options = sel.getOptions();
            for (String we : arr) {
                for (int i = 0; i < options.size(); i++) {
                    if (flag2 = we.equals(options.get(i).getText().trim())){
                        match = flag1 && flag2;
                    }
                }
                Assert.assertTrue(match);
            }
        }else{
            Assert.fail();
        }
    }
    //validation of mandatory fields
    public static void error(String error_msg){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getErrorMsg().getText().trim(),error_msg);
    }
    //validating data in input listing
    public static void inputListColumn(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(5000);
            Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getNamePatientId())&&checkedWebElementDisplayed(campSubscriberPage.getMobileEmail())&&checkedWebElementDisplayed(campSubscriberPage.getFindings())
                    &&checkedWebElementDisplayed(campSubscriberPage.getMemberships())&&checkedWebElementDisplayed(campSubscriberPage.getPaymentMode())&&checkedWebElementDisplayed(campSubscriberPage.getAmountTabular())&&checkedWebElementDisplayed(campSubscriberPage.getAction()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void nameInputList(String nameInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String name_PatientId = cells.get(0).getText();
            String[] split = name_PatientId.split("\\R");
            Assert.assertTrue(split[0].trim().equalsIgnoreCase(nameInput)&&split[1].trim().equalsIgnoreCase("NA"));
        }
    }
    public static void mobileEmailInput(String mobileInput,String emailInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String mobile_Email = cells.get(1).getText();
            String[] split = mobile_Email.split("\\R");
            Assert.assertTrue(split[0].trim().equalsIgnoreCase(mobileInput)&&split[1].trim().equalsIgnoreCase(emailInput));
        }
    }
    public static void findingsInput(String findingInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String findings = cells.get(2).getText();
            Assert.assertTrue(findings.trim().equalsIgnoreCase(findingInput));
        }
    }
    public static void membershipInput(String membershipInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String membership = cells.get(3).getText();
            Assert.assertTrue(membership.trim().equalsIgnoreCase(membershipInput));
        }
    }
    public static void paymentModeInput(String paymentModeInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String paymentMode = cells.get(4).getText();
            Assert.assertTrue(paymentMode.trim().equalsIgnoreCase(paymentModeInput));
        }
    }
    public static void amountInput(String amountInput) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String amount = cells.get(5).getText();
            Assert.assertTrue(amount.trim().equalsIgnoreCase(amountInput));
        }
    }
    public static void viewInput() {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            WebElement viewBtn = cells.get(6).findElement(By.xpath("div//span[@class='actn-icn view']"));
            Assert.assertTrue(checkedWebElementDisplayed(viewBtn));
        }
    }
    public static void openView(String subscriber) {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String subs = cells.get(0).getText().trim().split("\\R")[0].trim();
            WebElement view = driver.findElement(By.xpath("//span[contains(text(),'"+subs+"')]/../../following-sibling::td//span[@class='actn-icn view']"));
            System.out.println(subs+"====");
            Assert.assertTrue(checkedWebElementDisplayed(view));
            if(subs.equalsIgnoreCase(subscriber)){
                view.click();
            }else {
                Assert.fail();
            }
        }
    }
    public static void editInput() {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            WebElement editBtn = cells.get(6).findElement(By.xpath("div//span[@class='actn-icn edit']"));
            Assert.assertTrue(checkedWebElementDisplayed(editBtn));
        }
    }

    public static void deleteInput() {
        BaseClass.waitForPageLoad();
        for (WebElement row : campSubscriberPage.getRowCampSubs()) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            WebElement deleteBtn = cells.get(6).findElement(By.xpath("div//span[@class='actn-icn delete']"));
            Assert.assertTrue(checkedWebElementDisplayed(deleteBtn));
        }
    }
    public static void closeViewModal(){
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getModalCloseBtn());
        campSubscriberPage.getModalCloseBtn().click();
    }
    //creation date and function in view modal
    //personal details
    public static void headerViewModal(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(8000);
            Assert.assertTrue(checkedWebElementDisplayed(campSubscriberPage.getDetails())&&checkedWebElementDisplayed(campSubscriberPage.getPersonalInfo())&&checkedWebElementDisplayed(campSubscriberPage.getCampInfoView()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void creationDateView(){
        BaseClass.waitForElementToBeClickable(campSubscriberPage.getCreatedDateView());
        String[] createdDate = campSubscriberPage.getCreatedDateView().getText().trim().split(":");
        LocalDate localDate=LocalDate.now();
        String date2 = localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Assert.assertEquals(createdDate[1].trim(),date2);
    }
    public static void nameSubView(String nameView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubNameView().getText().trim(),nameView);
    }
    public static void mobileSubView(String mobileView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubMobileView().getText().trim(),mobileView);
    }
    public static void emailSubView(String emailView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubEmailView().getText().trim(),emailView);
    }
    public static void genderSubView(String genderView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubGenderView().getText().trim(),genderView);
    }
    public static void ageSubView(String ageView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubAgeView().getText().trim(),ageView);
    }
    //camp info details
    public static void typeSubView(String typeView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubTypeView().getText().trim(),typeView);
    }
    public static void regionSubView(String regionView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubRegionView().getText().trim(),regionView);
    }
    public static void zoneSubView(String zoneView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubZoneView().getText().trim(),zoneView);
    }
    public static void campaignSubView(String campaignView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubCampaignView().getText().trim(),campaignView);
    }
    public static void sourceSubView(String nameView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubSourceView().getText().trim(),nameView);
    }
    public static void subSourceSubView(String subSourceView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubSubSourceView().getText().trim(),subSourceView);
    }
    public static void findingsSubView(String findingsView){
        BaseClass.waitForPageLoad();
        Assert.assertEquals(campSubscriberPage.getSubFindingsView().getText().trim(),findingsView);
    }

    private static boolean checkedWebElementDisplayed(WebElement webElement){
        return (webElement.isDisplayed());
    }
}
