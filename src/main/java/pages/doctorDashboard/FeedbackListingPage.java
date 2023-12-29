package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeedbackListingPage {

    @FindBy(xpath = "//h1[@class='btmTitle pull-left headTxt ng-binding']")
    private WebElement headerFeedBackListing;
    @FindBy(xpath = "//span[@class='cmnicons dashB']")
    private WebElement doctorDashBoardBtn;
    @FindBy(id="Type")
    private WebElement feedBackType;
    @FindBy(id="Search By")
    private WebElement searchBy;
    @FindBy(id="Doctor")
    private WebElement doctorDropDown;
    @FindBy(id="details")
    private WebElement details;
    @FindBy(id="fromDate")
    private WebElement fromDate;
    @FindBy(id="toDate")
    private WebElement toDate;
    @FindBy(xpath = "//label[text()='Created']")
    private WebElement created;
    @FindBy(xpath = "//label[text()='Created']")
    private WebElement submitted;
    @FindBy(xpath = "//span[@class='cmnicons srch']/../following-sibling::i[text()='Search']")
    private WebElement searchBtn;
    @FindBy(xpath = "//span[@class='cmnicons rst']/../following-sibling::i[text()='Reset']")
    private WebElement resetBtn;
    @FindBy(xpath = "//i[text()='No Record Found!']")
    private WebElement noRecordFound;
    @FindBy(xpath = "//span[text()='Sub./Cr. Date']")
    private WebElement sub_Created_date;
    @FindBy(xpath = "//span[text()='Type']")
    private WebElement type;
    @FindBy(xpath = "//span[text()='Patient Name / Id']")
    private WebElement patient_Name_Id;
    @FindBy(xpath = "//span[text()='Mobile']")
    private WebElement mobile;
    @FindBy(xpath = "//span[text()='Email']")
    private WebElement email;
    @FindBy(xpath = "//span[text()='Submitted By']")
    private WebElement submittedBy;
    @FindBy(xpath = "//span[text()='Attachment']")
    private WebElement attachment;
    @FindBy(xpath = "//span[text()='Action']")
    private WebElement action;
    /*feedback view modal web element*/
    @FindBy(xpath = "//h4[contains(@class,'compViewPopUpResponsive')]")
    private WebElement headerFeedbackViewModal;
    @FindBy(xpath = "//span[contains(@class,'compViewPopUpResponsive text-left')]")
    private WebElement patientName_PatientId;
    @FindBy(xpath = "//span[contains(@class,'cmnicons cncl-mdl')]")
    private WebElement closeBtnInView;
    @FindBy(xpath = "//h4[text()='Feedback Details']")
    private WebElement feedbackDetailsInView;
    @FindBy(xpath = "//b[text()='Facility']/../following-sibling::div")
    private WebElement clinicNameInView;
    @FindBy(xpath = "//b[text()='Email']/../following-sibling::div")
    private WebElement emailIdInView;
    @FindBy(xpath = "//b[text()='Phone']/../following-sibling::div")
    private WebElement mobileInView;
    @FindBy(xpath = "//b[text()='Address']/../following-sibling::div")
    private WebElement addressInView;
    @FindBy(xpath = "//b[text()='Submission Date']/../following-sibling::div")
    private WebElement submissionDateInView;
    @FindBy(xpath = "//b[text()='Serial No']/../following-sibling::div")
    private WebElement serialNoInView;
    @FindBy(xpath = "//h4[contains(text(),'Feedback Questions')]/span[contains(text(),'Feedback Type:')]/strong")
    private WebElement feedbackTypeInViewModal;
    @FindBy(xpath = "//b[text()='How likely are you to recommend Clove to your friends / family?']")
    private WebElement ratingHeaderInView;
    @FindBy(xpath = "//strong[contains(text(),'Rating:')]/..")
    private WebElement ratingInView;
    @FindBy(xpath = "//strong[contains(text(),'Reasons:')]/..")
    private WebElement reasonInView;
    @FindBy(xpath = "//strong[contains(text(),'Remarks:')]/..")
    private WebElement remarkInView;
	public WebElement getHeaderFeedBackListing() {
		return headerFeedBackListing;
	}
	public WebElement getDoctorDashBoardBtn() {
		return doctorDashBoardBtn;
	}
	public WebElement getFeedBackType() {
		return feedBackType;
	}
	public WebElement getSearchBy() {
		return searchBy;
	}
	public WebElement getDoctorDropDown() {
		return doctorDropDown;
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public WebElement getToDate() {
		return toDate;
	}
	public WebElement getCreated() {
		return created;
	}
	public WebElement getSubmitted() {
		return submitted;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getNoRecordFound() {
		return noRecordFound;
	}
	public WebElement getSub_Created_date() {
		return sub_Created_date;
	}
	public WebElement getType() {
		return type;
	}
	public WebElement getPatient_Name_Id() {
		return patient_Name_Id;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getSubmittedBy() {
		return submittedBy;
	}
	public WebElement getAttachment() {
		return attachment;
	}
	public WebElement getAction() {
		return action;
	}
	public WebElement getHeaderFeedbackViewModal() {
		return headerFeedbackViewModal;
	}
	public WebElement getPatientName_PatientId() {
		return patientName_PatientId;
	}
	public WebElement getCloseBtnInView() {
		return closeBtnInView;
	}
	public WebElement getFeedbackDetailsInView() {
		return feedbackDetailsInView;
	}
	public WebElement getClinicNameInView() {
		return clinicNameInView;
	}
	public WebElement getEmailIdInView() {
		return emailIdInView;
	}
	public WebElement getMobileInView() {
		return mobileInView;
	}
	public WebElement getAddressInView() {
		return addressInView;
	}
	public WebElement getSubmissionDateInView() {
		return submissionDateInView;
	}
	public WebElement getSerialNoInView() {
		return serialNoInView;
	}
	public WebElement getFeedbackTypeInViewModal() {
		return feedbackTypeInViewModal;
	}
	public WebElement getRatingHeaderInView() {
		return ratingHeaderInView;
	}
	public WebElement getRatingInView() {
		return ratingInView;
	}
	public WebElement getReasonInView() {
		return reasonInView;
	}
	public WebElement getRemarkInView() {
		return remarkInView;
	}

}
