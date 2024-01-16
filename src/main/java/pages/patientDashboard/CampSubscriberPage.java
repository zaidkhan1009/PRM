package pages.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

import java.util.List;

public class CampSubscriberPage extends BaseClass{
    
    //WebElement of camp subscriber add
    @FindBy(xpath ="//h1[text()='Camp Subscriber(s)']")
    private WebElement headerPage;
    @FindBy(xpath = "//strong[contains(text(),'Creation Date :')]/span")
    private WebElement creationDate;
    @FindBy(xpath = "//span[contains(text(),'Camp Info')]")
    private WebElement campInfo;
    @FindBy(xpath = "//li[@ng-if='listHideShow']//span[@class='cmnicons nxt-mdl']")
    private WebElement nextBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons cncl']")
    private WebElement cancelBtn;
    @FindBy(xpath = "//b[text()='Type']/../following-sibling::span")
    private WebElement type;
    @FindBy(xpath = "//label[contains(text(),'Region')]")
    private WebElement regionHeader;
    @FindBy(id = "region")
    private WebElement regionDropDown;
    @FindBy(xpath = "//label[contains(text(),'Zone')]")
    private WebElement zoneHeader;
    @FindBy(id = "zone")
    private WebElement zoneDropDown;
    @FindBy(xpath = "//label[contains(text(),'Campaign')]")
    private WebElement campaignHeader;
    @FindBy(id = "campaign")
    private WebElement campaignDropDown;
    @FindBy(xpath = "//label[contains(text(),'Source')]")
    private WebElement sourceHeader;
    @FindBy(id = "source")
    private WebElement sourceDropDown;
    @FindBy(xpath = "//label[contains(text(),'Sub-Source')]")
    private WebElement subSourceHeader;
    @FindBy(id = "subSource")
    private WebElement subSourceTextField;
    @FindBy(xpath = "//div[text()='Select Region']")
    private WebElement selectRegionErr;
    @FindBy(xpath = "//div[text()='Select Zone']")
    private WebElement selectZoneErr;
    @FindBy(xpath = "//div[text()='Select Campaign']")
    private WebElement selectCampaignErr;
    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement selectSubscriberSourceErr;
    @FindBy(xpath = "//div[text()='Enter sub-source']")
    private WebElement enterSubSourceErr;
    //WebElement camp Add page
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons aprsv']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[contains(@class,'sideNavigation')]//span[@class='cmnicons rst']")
    private WebElement resetBtn;
    @FindBy(xpath = "//b[text()='Region']/../following-sibling::span")
    private WebElement region;
    @FindBy(xpath = "//b[text()='Zone']/../following-sibling::span")
    private WebElement zone;
    @FindBy(xpath = "//b[text()='Campaign']/../following-sibling::span")
    private WebElement campaign;
    @FindBy(xpath = "//b[text()='Source']/../following-sibling::span")
    private WebElement source;
    @FindBy(xpath = "//b[text()='Sub-Source']/../following-sibling::span")
    private WebElement subSource;
    //WebElement New Subscriber
    @FindBy(xpath = "//span[text()='New Subscriber']")
    private WebElement newSubscriberHeader;
    @FindBy(xpath = "//label[text()='Name']")
    private WebElement headerName;
    @FindBy(id="name")
    private WebElement name;
    @FindBy(xpath = "//label[text()='Gender']")
    private WebElement headerGender;
    @FindBy(id = "campSubs-gender-male")
    private WebElement male;
    @FindBy(xpath = "//label[text()='Male']")
    private WebElement maleText;
    @FindBy(id = "campSubs-gender-female")
    private WebElement female;
    @FindBy(xpath = "//label[text()='Female']")
    private WebElement femaleText;
    @FindBy(id = "campSubs-gender-other")
    private WebElement other;
    @FindBy(xpath = "//label[text()='Other']")
    private WebElement otherText;
    @FindBy(xpath = "//label[text()='DOB']")
    private WebElement headerDob;
    @FindBy(id="subs_dob")
    private WebElement dob;
    @FindBy(xpath = "//label[text()='Age']")
    private WebElement headerAge;
    @FindBy(id = "subs_dob_age")
    private WebElement age;
    @FindBy(xpath = "//label[text()='Email']")
    private WebElement headerEmail;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(xpath = "//label[text()='Mobile']")
    private WebElement headerMobile;
    @FindBy(id = "mobile")
    private WebElement mobile;
    @FindBy(id = "callCheckBox")
    private WebElement callCheckBox;
    @FindBy(xpath="//label[text()='Call']")
    private WebElement callText;
    @FindBy(id = "smsCheckBox")
    private WebElement smsCheckBox;
    @FindBy(xpath = "//label[text()='SMS']")
    private WebElement smsText;
    @FindBy(id = "emailCheckBox")
    private WebElement emailCheckBox;
    @FindBy(xpath = "//input/following-sibling::label[text()='Email']")
    private WebElement emailText;
    @FindBy(xpath = "//i[text()='Add File(s)']/preceding-sibling::span/span[@class='cmnicons ccAdd']")
    private WebElement addFilesBtn;
    @FindBy(xpath = "//span[text()='Finding(s)']")
    private WebElement headerFindings;
    @FindBy(xpath = "//b[contains(text(),'Interest Level')] ")
    private WebElement interestLevel;
    @FindBy(id = "campSubs-intrstLevel-Low")
    private WebElement intrstLevelLow;
    @FindBy(xpath = "//label[text()='Low'] ")
    private WebElement intrstLevelLowText;
    @FindBy(id = "campSubs-intrstLevel-Medium")
    private WebElement intrstLevelMedium;
    @FindBy(xpath = "//label[text()='Medium'] ")
    private WebElement intrstLevelMediumText;
    @FindBy(id = "campSubs-intrstLevel-High")
    private WebElement intrstLevelHigh;
    @FindBy(xpath = "//label[text()='Low'] ")
    private WebElement intrstLevelHighText;
    @FindBy(xpath = "//div[@class='enq_btns ng-scope']/span")
    private List<WebElement> findingsBox;
    @FindBy(xpath = "//label[@class='ng-binding']")
    private List<WebElement> intrestLeval;
    @FindBy(xpath = "//input[@class='ng-scope']")
    private List<WebElement> otherInfo;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save;
    @FindBy(xpath = "//textarea[@id='notes']")
    private WebElement note;
    @FindBy(xpath = "//span[text()='Membership(s)']")
    private WebElement membershipHeader;
    @FindBy(xpath = "//label[text()='Membership']")
    private WebElement membershipDrpDwnHeader;
    @FindBy(xpath = "//div[@class='multiselect-parent btn-group dropdown-multiselect']")
    private WebElement membershipDropDown;
    @FindBy(xpath = "//button[contains(text(),'Select Membership')]")
    private WebElement selectMembershipBtn;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    private WebElement searchBoxMembership;
    @FindBy(xpath = "//a[contains(text(),'Dental Health Plan 2.0  (550.00)')]/span")
    private WebElement dentalHealthPlan2;
    @FindBy(xpath = "//a[contains(text(),'Dental Health Plan - 3500  (560.00)')]/span")
    private WebElement dentalHealthPlan3;
    //WebElement of payment  mode
    @FindBy(xpath = "//label[text()='Payment Modes']")
    private WebElement headerPaymentMode;
    @FindBy(xpath = "//label[text()='Cash']/preceding-sibling::input[@value='Cash']")
    private WebElement cash;
    @FindBy(xpath = "//label[text()='Cheque']/preceding-sibling::input[@value='Cheque']")
    private WebElement cheque;
    @FindBy(xpath = "//label[text()='NetBanking']/preceding-sibling::input[@value='NetBanking']")
    private WebElement netBanking;
    @FindBy(xpath = "//label[text()='Wallet']/preceding-sibling::input[@value='Wallet']")
    private WebElement wallet;
    @FindBy(xpath = "//label[text()='Card']/preceding-sibling::input[@value='Card']")
    private WebElement card;
    @FindBy(xpath = "//label[text()='Amount']")
    private WebElement amountHeader;
    @FindBy(id = "amount")
    private WebElement amount;
    @FindBy(xpath = "//label[text()='Type']")
    private WebElement subType;
    @FindBy(id = "type")
    private WebElement subTypeDropDown;
    @FindBy(xpath = "//div[contains(@class,'error')]")
    private List<WebElement> errorMsg;
    //camp subscriber add page input listing
    @FindBy(xpath = "//th[text()='Name/Patient Id']")
    private WebElement namePatientId;
    @FindBy(xpath = "//th[text()='Mobile/Email']")
    private WebElement mobileEmail;
    @FindBy(xpath = "//th[text()='Findings']")
    private WebElement findings;
    @FindBy(xpath = "//th[text()='Membership(s)']")
    private WebElement memberships;
    @FindBy(xpath = "//th[text()='Payment Mode']")
    private WebElement paymentMode;
    @FindBy(xpath = "//th[text()='Amount']")
    private WebElement amountTabular;
    @FindBy(xpath = "//th[text()='Action']")
    private WebElement action;
    @FindBy(xpath = "//table[@id='campSubs']/tbody/tr")
    private List<WebElement> rowCampSubs;
    //WebElement of the view modal
    @FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
    private WebElement modalCloseBtn;
    @FindBy(xpath = "//h4[text()='Details']")
    private WebElement details;
    @FindBy(xpath = "//span[contains(text(),'Created Date')]/..")
    private WebElement createdDateView;
    @FindBy(xpath = "//div[contains(text(),'Personal Info')]")
    private WebElement personalInfo;
    @FindBy(xpath = "//b[text()='Name']/../following-sibling::span")
    private WebElement subNameView;
    @FindBy(xpath = "//b[text()='Mobile']/../following-sibling::span")
    private WebElement subMobileView;
    @FindBy(xpath = "//b[text()='Email']/../following-sibling::span")
    private WebElement subEmailView;
    @FindBy(xpath = "//b[text()='Gender']/../following-sibling::span")
    private WebElement subGenderView;
    @FindBy(xpath = "//b[text()='Age']/../following-sibling::span")
    private WebElement subAgeView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]")
    private WebElement campInfoView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Type']/../following-sibling::span")
    private WebElement subTypeView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Region']/../following-sibling::span")
    private WebElement subRegionView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Zone']/../following-sibling::span")
    private WebElement subZoneView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Campaign']/../following-sibling::span")
    private WebElement subCampaignView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Source']/../following-sibling::span")
    private WebElement subSourceView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Sub-Source']/../following-sibling::span")
    private WebElement subSubSourceView;
    @FindBy(xpath = "//div[contains(text(),'Camp Info')]/following-sibling::div//b[text()='Findings']/../following-sibling::div")
    private WebElement subFindingsView;
    @FindBy(xpath= "//label[contains(text(),'Primary Enquiry')]")
    private WebElement PrimaryEnquiry;
    @FindBy(xpath= "//span[contains(text(),'Braces')]")
    private WebElement Braces; 
    @FindBy(xpath= "//label[@for='alltooth']")
    private WebElement allTeeth; 
    @FindBy(xpath="//label[@for='secondary_Enq']")
    private WebElement SecondaryEnquiry;
    @FindBy(xpath="//*[@ng-click='selectMatch($index)']")
    private WebElement dropDown;
    
	public WebElement getdropDown() {
		return dropDown; 
	}
	public WebElement getPrimaryEnquiry() {
		return PrimaryEnquiry; 
	}
	public WebElement getSecondaryEnquiry() {
		return SecondaryEnquiry;
	}
	public WebElement getAllTeeth() {
		return allTeeth;
	}
	public List<WebElement> getintrestLeval() {
		return intrestLeval;
	}
	public List<WebElement> getotherInfo() {
		return otherInfo;
	}
	public WebElement getsave() {
		return save;
	}
	public WebElement getnote() {
		return note;
	}
	///
	public WebElement getHeaderPage() {
		return headerPage;
	}
	public WebElement getCreationDate() {
		return creationDate;
	}
	public WebElement getCampInfo() {
		return campInfo;
	}
	public WebElement getNextBtn() {
		return nextBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getRegionHeader() {
		return regionHeader;
	}
	public WebElement getRegionDropDown() {
		return regionDropDown;
	}
	public WebElement getZoneHeader() {
		return zoneHeader;
	}
	public WebElement getZoneDropDown() {
		return zoneDropDown;
	}
	public WebElement getCampaignHeader() {
		return campaignHeader;
	}
	public WebElement getCampaignDropDown() {
		return campaignDropDown;
	}
	public WebElement getSourceHeader() {
		return sourceHeader;
	}
	public WebElement getSourceDropDown() {
		return sourceDropDown;
	}
	public WebElement getSubSourceHeader() {
		return subSourceHeader;
	}
	public WebElement getSubSourceTextField() {
		return subSourceTextField;
	}
	public WebElement getSelectRegionErr() {
		return selectRegionErr;
	}
	public WebElement getSelectZoneErr() {
		return selectZoneErr;
	}
	public WebElement getSelectCampaignErr() {
		return selectCampaignErr;
	}
	public WebElement getSelectSubscriberSourceErr() {
		return selectSubscriberSourceErr;
	}
	public WebElement getEnterSubSourceErr() {
		return enterSubSourceErr;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getRegion() {
		return region;
	}
	public WebElement getZone() {
		return zone;
	}
	public WebElement getCampaign() {
		return campaign;
	}
	public WebElement getSource() {
		return source;
	}
	public WebElement getSubSource() {
		return subSource;
	}
	public WebElement getNewSubscriberHeader() {
		return newSubscriberHeader;
	}
	public WebElement getHeaderName() {
		return headerName;
	}
	public WebElement getName() {
		return name;
	}
	public WebElement getHeaderGender() {
		return headerGender;
	}
	public WebElement getMale() {
		return male;
	}
	public WebElement getMaleText() {
		return maleText;
	}
	public WebElement getFemale() {
		return female;
	}
	public WebElement getFemaleText() {
		return femaleText;
	}
	public WebElement getOther() {
		return other;
	}
	public WebElement getOtherText() {
		return otherText;
	}
	public WebElement getHeaderDob() {
		return headerDob;
	}
	public WebElement getDob() {
		return dob;
	}
	public WebElement getHeaderAge() {
		return headerAge;
	}
	public WebElement getAge() {
		return age;
	}
	public WebElement getHeaderEmail() {
		return headerEmail;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getHeaderMobile() {
		return headerMobile;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getCallCheckBox() {
		return callCheckBox;
	}
	public WebElement getCallText() {
		return callText;
	}
	public WebElement getSmsCheckBox() {
		return smsCheckBox;
	}
	public WebElement getSmsText() {
		return smsText;
	}
	public WebElement getEmailCheckBox() {
		return emailCheckBox;
	}
	public WebElement getEmailText() {
		return emailText;
	}
	public WebElement getAddFilesBtn() {
		return addFilesBtn;
	}
	public WebElement getHeaderFindings() {
		return headerFindings;
	}
	public WebElement getInterestLevel() {
		return interestLevel;
	}
	public WebElement getIntrstLevelLow() {
		return intrstLevelLow;
	}
	public WebElement getIntrstLevelLowText() {
		return intrstLevelLowText;
	}
	public WebElement getIntrstLevelMedium() {
		return intrstLevelMedium;
	}
	public WebElement getIntrstLevelMediumText() {
		return intrstLevelMediumText;
	}
	public WebElement getIntrstLevelHigh() {
		return intrstLevelHigh;
	}
	public WebElement getIntrstLevelHighText() {
		return intrstLevelHighText;
	}
	public List<WebElement> getFindingsBox() {
		return findingsBox;
	}
	public WebElement getMembershipHeader() {
		return membershipHeader;
	}
	public WebElement getMembershipDrpDwnHeader() {
		return membershipDrpDwnHeader;
	}
	public WebElement getMembershipDropDown() {
		return membershipDropDown;
	}
	public WebElement getSelectMembershipBtn() {
		return selectMembershipBtn;
	}
	public WebElement getSearchBoxMembership() {
		return searchBoxMembership;
	}
	public WebElement getDentalHealthPlan2() {
		return dentalHealthPlan2;
	}
	public WebElement getDentalHealthPlan3() {
		return dentalHealthPlan3;
	}
	public WebElement getHeaderPaymentMode() {
		return headerPaymentMode;
	}
	public WebElement getCash() {
		return cash;
	}
	public WebElement getCheque() {
		return cheque;
	}
	public WebElement getNetBanking() {
		return netBanking;
	}
	public WebElement getWallet() {
		return wallet;
	}
	public WebElement getCard() {
		return card;
	}
	public WebElement getAmountHeader() {
		return amountHeader;
	}
	public WebElement getAmount() {
		return amount;
	}
	public WebElement getSubType() {
		return subType;
	}
	public WebElement getSubTypeDropDown() {
		return subTypeDropDown;
	}
	public List<WebElement> getErrorMsg() {
		return errorMsg;
	}
	public WebElement getNamePatientId() {
		return namePatientId;
	}
	public WebElement getMobileEmail() {
		return mobileEmail;
	}
	public WebElement getFindings() {
		return findings;
	}
	public WebElement getMemberships() {
		return memberships;
	}
	public WebElement getPaymentMode() {
		return paymentMode;
	}
	public WebElement getAmountTabular() {
		return amountTabular;
	}
	public WebElement getAction() {
		return action;
	}
	public List<WebElement> getRowCampSubs() {
		return rowCampSubs;
	}
	public WebElement getModalCloseBtn() {
		return modalCloseBtn;
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getCreatedDateView() {
		return createdDateView;
	}
	public WebElement getPersonalInfo() {
		return personalInfo;
	}
	public WebElement getSubNameView() {
		return subNameView;
	}
	public WebElement getSubMobileView() {
		return subMobileView;
	}
	public WebElement getSubEmailView() {
		return subEmailView;
	}
	public WebElement getSubGenderView() {
		return subGenderView;
	}
	public WebElement getSubAgeView() {
		return subAgeView;
	}
	public WebElement getCampInfoView() {
		return campInfoView;
	}
	public WebElement getSubTypeView() {
		return subTypeView;
	}
	public WebElement getSubRegionView() {
		return subRegionView;
	}
	public WebElement getSubZoneView() {
		return subZoneView;
	}
	public WebElement getSubCampaignView() {
		return subCampaignView;
	}
	public WebElement getSubSourceView() {
		return subSourceView;
	}
	public WebElement getSubSubSourceView() {
		return subSubSourceView;
	}
	public WebElement getSubFindingsView() {
		return subFindingsView;
	}




    
}
