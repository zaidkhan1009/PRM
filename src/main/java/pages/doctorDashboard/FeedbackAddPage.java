package pages.doctorDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.awt.*;

public class FeedbackAddPage {

    /*
     * WebElement of the Add Feedback Page
     */
	
    @FindBy(xpath = "//h1[contains(@class,'pull-left ng-binding')]")
    private WebElement addPageHeader;
    @FindBy(xpath = "//span[@class='mdl-hdr-text ng-binding']")
    private WebElement patientName;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons aprsv']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons rst']")
    private WebElement resetBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons cncl']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons dashB']")
    private WebElement dashBoardBtn;
    @FindBy(xpath = "//div[contains(text(),'Info')]")
    private WebElement sectionTitleTop;
    @FindBy(xpath = "//div[contains(text(),'Feedback Questions')]")
    private WebElement sectionTitle;
    @FindBy(xpath = "//label[text()='Feedback Date']/following-sibling::input[@id='feedbackDt']")
    private WebElement feedBackDate;
    @FindBy(xpath = "//label[text()='Serial No.']/following-sibling::input[@id='serial']")
    private WebElement serialNumber;
    @FindBy(xpath = "//span[@class='cmnicons ccAdd']/../following-sibling::span[text()='Add File(s)']")
    private WebElement addFilesBtn;
    @FindBy(xpath = "//span[@class='pull-right']")
    private WebElement feedbackType;
    @FindBy(xpath = "//label[text()='How likely are you to recommend Clove to your friends / family?']")
    private WebElement feedbackRate;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope detractors']/label[text()='1']")
    private WebElement rate_1;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope detractors']/label[text()='2']")
    private WebElement rate_2;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope detractors']/label[text()='3']")
    private WebElement rate_3;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope detractors']/label[text()='4']")
    private WebElement rate_4;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope detractors']/label[text()='5']")
    private WebElement rate_5;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope passives']/label[text()='6']")
    private WebElement rate_6;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope passives']/label[text()='7']")
    private WebElement rate_7;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope passives']/label[text()='8']")
    private WebElement rate_8;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope promotors']/label[text()='9']")
    private WebElement rate_9;
    @FindBy(xpath = "//li[@class='mrgnSet rating_smiley ng-scope promotors']/label[text()='10']")
    private WebElement rate_10;
    @FindBy(xpath = "//div[text()='Not Likely']/../label[text()='1']")
    private WebElement notLikelyText;
    @FindBy(xpath = "//div[text()='Very Likely']/../label[text()='10']")
    private WebElement veryLikelyText;
    @FindBy(xpath = "//div[text()='Enter Serial No.!']")
    private WebElement mandatorySerialNumber;
    /*web element for rating one*/
    @FindBy(xpath = "//span[text()='Please answer any question to submit!']")
    private WebElement toastMessage;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']//label[text()='Waiting Time']")
    private WebElement waitingTime_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_1;
    @FindBy(xpath = "//div[@id='reasons_for_rating_1']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_1;
    /*web element for rating two*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']//label[text()='Waiting Time']")
    private WebElement waitingTime_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_2;
    @FindBy(xpath = "//div[@id='reasons_for_rating_2']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_2;
    /*web element for rating three*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']//label[text()='Waiting Time']")
    private WebElement waitingTime_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_3;
    @FindBy(xpath = "//div[@id='reasons_for_rating_3']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_3;
    /*web element for rating four*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']//label[text()='Waiting Time']")
    private WebElement waitingTime_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_4;
    @FindBy(xpath = "//div[@id='reasons_for_rating_4']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_4;
    /*web element for rating five*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']//label[text()='Waiting Time']")
    private WebElement waitingTime_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_5;
    @FindBy(xpath = "//div[@id='reasons_for_rating_5']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_5;
    /*web element for rating 6*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']/preceding-sibling::span[text()='What can be improved on?']")
    private WebElement improvementText_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']//label[text()='Prices and Offers']")
    private WebElement pricesAndOffers_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']//label[text()='Waiting Time']")
    private WebElement waitingTime_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_6;
    @FindBy(xpath = "//div[@id='reasons_for_rating_6']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_6;
    /*web element for rating 7*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']/preceding-sibling::span[text()='What could be done better?']")
    private WebElement improvementText_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']//label[text()='Prices and Offers']")
    private WebElement rightCharges_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']//label[text()='Preventive Measures Explained']")
    private WebElement preventiveMeasuresExplained_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_7;
    @FindBy(xpath = "//div[@id='reasons_for_rating_7']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_7;
    /*web element for rating 8*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']/preceding-sibling::span[text()='What could be done better?']")
    private WebElement improvementText_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']//label[text()='Dentist Interaction']")
    private WebElement dentistInteraction_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']//label[text()='Treatment Quality']")
    private WebElement treatmentQuality_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']//label[text()='Prices and Offers']")
    private WebElement rightCharges_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']//label[text()='Preventive Measures Explained']")
    private WebElement preventiveMeasuresExplained_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']//label[text()='Hygiene & Cleanliness']")
    private WebElement hygieneCleanliness_8;
    @FindBy(xpath = "//div[@id='reasons_for_rating_8']/following-sibling::span/textarea[@placeholder='» Would you like to give more feedback']")
    private WebElement feedbacktextField_8;
    /*Web element for rating 9*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_9']/preceding-sibling::span[text()='Pleased to have served you. Would you like to give any compliments?']")
    private WebElement improvementText_9;
    @FindBy(xpath = "//div[@id='reasons_for_rating_9']/following-sibling::span/textarea[@placeholder='» Write your compliments here']")
    private WebElement feedbacktextField_9;
    /*web element for rating 10*/
    @FindBy(xpath = "//div[@id='reasons_for_rating_10']/preceding-sibling::span[text()='Pleased to have served you. Would you like to give any compliments?']")
    private WebElement improvementText_10;
    @FindBy(xpath = "//div[@id='reasons_for_rating_10']/following-sibling::span/textarea[@placeholder='» Write your compliments here']")
    private WebElement feedbacktextField_10;
    @FindBy(xpath = "//span[text()='Please upload the supporting document!']")
    private WebElement uploadFileToastMsg;
    @FindBy(xpath = "//i[@class='fa fa-times']")
    private WebElement fileRemoveBtn;
    @FindBy(xpath = "//p[text()='Do you want to delete this file?']/../following-sibling::div//span[@class='cmnicons yes-mdl']")
    private WebElement yesRemoveBtn;
    @FindBy(xpath = "//p[text()='Do you want to delete this file?']/../following-sibling::div//span[@class='cmnicons cncl-mdl']")
    private WebElement noRemoveBtn;
	public WebElement getAddPageHeader() {
		return addPageHeader;
	}
	public WebElement getPatientName() {
		return patientName;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}
	public WebElement getSectionTitleTop() {
		return sectionTitleTop;
	}
	public WebElement getSectionTitle() {
		return sectionTitle;
	}
	public WebElement getFeedBackDate() {
		return feedBackDate;
	}
	public WebElement getSerialNumber() {
		return serialNumber;
	}
	public WebElement getAddFilesBtn() {
		return addFilesBtn;
	}
	public WebElement getFeedbackType() {
		return feedbackType;
	}
	public WebElement getFeedbackRate() {
		return feedbackRate;
	}
	public WebElement getRate_1() {
		return rate_1;
	}
	public WebElement getRate_2() {
		return rate_2;
	}
	public WebElement getRate_3() {
		return rate_3;
	}
	public WebElement getRate_4() {
		return rate_4;
	}
	public WebElement getRate_5() {
		return rate_5;
	}
	public WebElement getRate_6() {
		return rate_6;
	}
	public WebElement getRate_7() {
		return rate_7;
	}
	public WebElement getRate_8() {
		return rate_8;
	}
	public WebElement getRate_9() {
		return rate_9;
	}
	public WebElement getRate_10() {
		return rate_10;
	}
	public WebElement getNotLikelyText() {
		return notLikelyText;
	}
	public WebElement getVeryLikelyText() {
		return veryLikelyText;
	}
	public WebElement getMandatorySerialNumber() {
		return mandatorySerialNumber;
	}
	public WebElement getToastMessage() {
		return toastMessage;
	}
	public WebElement getImprovementText_1() {
		return improvementText_1;
	}
	public WebElement getDentistInteraction_1() {
		return dentistInteraction_1;
	}
	public WebElement getTreatmentQuality_1() {
		return treatmentQuality_1;
	}
	public WebElement getPricesAndOffers_1() {
		return pricesAndOffers_1;
	}
	public WebElement getWaitingTime_1() {
		return waitingTime_1;
	}
	public WebElement getHygieneCleanliness_1() {
		return hygieneCleanliness_1;
	}
	public WebElement getFeedbacktextField_1() {
		return feedbacktextField_1;
	}
	public WebElement getImprovementText_2() {
		return improvementText_2;
	}
	public WebElement getDentistInteraction_2() {
		return dentistInteraction_2;
	}
	public WebElement getTreatmentQuality_2() {
		return treatmentQuality_2;
	}
	public WebElement getPricesAndOffers_2() {
		return pricesAndOffers_2;
	}
	public WebElement getWaitingTime_2() {
		return waitingTime_2;
	}
	public WebElement getHygieneCleanliness_2() {
		return hygieneCleanliness_2;
	}
	public WebElement getFeedbacktextField_2() {
		return feedbacktextField_2;
	}
	public WebElement getImprovementText_3() {
		return improvementText_3;
	}
	public WebElement getDentistInteraction_3() {
		return dentistInteraction_3;
	}
	public WebElement getTreatmentQuality_3() {
		return treatmentQuality_3;
	}
	public WebElement getPricesAndOffers_3() {
		return pricesAndOffers_3;
	}
	public WebElement getWaitingTime_3() {
		return waitingTime_3;
	}
	public WebElement getHygieneCleanliness_3() {
		return hygieneCleanliness_3;
	}
	public WebElement getFeedbacktextField_3() {
		return feedbacktextField_3;
	}
	public WebElement getImprovementText_4() {
		return improvementText_4;
	}
	public WebElement getDentistInteraction_4() {
		return dentistInteraction_4;
	}
	public WebElement getTreatmentQuality_4() {
		return treatmentQuality_4;
	}
	public WebElement getPricesAndOffers_4() {
		return pricesAndOffers_4;
	}
	public WebElement getWaitingTime_4() {
		return waitingTime_4;
	}
	public WebElement getHygieneCleanliness_4() {
		return hygieneCleanliness_4;
	}
	public WebElement getFeedbacktextField_4() {
		return feedbacktextField_4;
	}
	public WebElement getImprovementText_5() {
		return improvementText_5;
	}
	public WebElement getDentistInteraction_5() {
		return dentistInteraction_5;
	}
	public WebElement getTreatmentQuality_5() {
		return treatmentQuality_5;
	}
	public WebElement getPricesAndOffers_5() {
		return pricesAndOffers_5;
	}
	public WebElement getWaitingTime_5() {
		return waitingTime_5;
	}
	public WebElement getHygieneCleanliness_5() {
		return hygieneCleanliness_5;
	}
	public WebElement getFeedbacktextField_5() {
		return feedbacktextField_5;
	}
	public WebElement getImprovementText_6() {
		return improvementText_6;
	}
	public WebElement getDentistInteraction_6() {
		return dentistInteraction_6;
	}
	public WebElement getTreatmentQuality_6() {
		return treatmentQuality_6;
	}
	public WebElement getPricesAndOffers_6() {
		return pricesAndOffers_6;
	}
	public WebElement getWaitingTime_6() {
		return waitingTime_6;
	}
	public WebElement getHygieneCleanliness_6() {
		return hygieneCleanliness_6;
	}
	public WebElement getFeedbacktextField_6() {
		return feedbacktextField_6;
	}
	public WebElement getImprovementText_7() {
		return improvementText_7;
	}
	public WebElement getDentistInteraction_7() {
		return dentistInteraction_7;
	}
	public WebElement getTreatmentQuality_7() {
		return treatmentQuality_7;
	}
	public WebElement getRightCharges_7() {
		return rightCharges_7;
	}
	public WebElement getPreventiveMeasuresExplained_7() {
		return preventiveMeasuresExplained_7;
	}
	public WebElement getHygieneCleanliness_7() {
		return hygieneCleanliness_7;
	}
	public WebElement getFeedbacktextField_7() {
		return feedbacktextField_7;
	}
	public WebElement getImprovementText_8() {
		return improvementText_8;
	}
	public WebElement getDentistInteraction_8() {
		return dentistInteraction_8;
	}
	public WebElement getTreatmentQuality_8() {
		return treatmentQuality_8;
	}
	public WebElement getRightCharges_8() {
		return rightCharges_8;
	}
	public WebElement getPreventiveMeasuresExplained_8() {
		return preventiveMeasuresExplained_8;
	}
	public WebElement getHygieneCleanliness_8() {
		return hygieneCleanliness_8;
	}
	public WebElement getFeedbacktextField_8() {
		return feedbacktextField_8;
	}
	public WebElement getImprovementText_9() {
		return improvementText_9;
	}
	public WebElement getFeedbacktextField_9() {
		return feedbacktextField_9;
	}
	public WebElement getImprovementText_10() {
		return improvementText_10;
	}
	public WebElement getFeedbacktextField_10() {
		return feedbacktextField_10;
	}
	public WebElement getUploadFileToastMsg() {
		return uploadFileToastMsg;
	}
	public WebElement getFileRemoveBtn() {
		return fileRemoveBtn;
	}
	public WebElement getYesRemoveBtn() {
		return yesRemoveBtn;
	}
	public WebElement getNoRemoveBtn() {
		return noRemoveBtn;
	}
}
