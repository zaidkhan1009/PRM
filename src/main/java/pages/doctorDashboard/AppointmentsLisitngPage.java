package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class AppointmentsLisitngPage {

	@FindBy(xpath ="//th[contains(text(),'Patient Name')]") //changed the xpath from "//th[text()='Patient Name']")   
	private WebElement patientName;
	@FindBy(xpath = "//th[text()='Patient Id']")
	private WebElement patientId;
	@FindBy(xpath = "//th[text()='Type']")
	private WebElement type;
	@FindBy(xpath = "//th[text()='Doctor']")
	private WebElement doctor;
	@FindBy(xpath = "//th[text()='Clinic']")
	private WebElement clinic;
	@FindBy(xpath = "//th[text()='Action']")
	private WebElement actionBtn;
	@FindBy(xpath ="//input[@id='search_option_mainClinic']")  // changed the xpath from "//input[@id='serach_option']")
	public WebElement docDropDoownBtn;
	@FindBy(id = "fromDate")
	private WebElement fromDateTxt;
	@FindBy(xpath = "//button[contains(@ng-click,'fromDate')]")
	private WebElement fromDateCalenderIcon;
	@FindBy(id = "toDate")
	private WebElement toDateTxt;
	@FindBy(xpath = "//button[contains(@ng-click,'toDate')]")
	private WebElement toDateCalenderIcon;
	@FindBy(id ="category")  // changed the xpath from "type")
	private WebElement appTypeDrpDwn;
	@FindBy(xpath = "//i[text()='Search']/preceding-sibling::span")
	private WebElement searchBtn;
	@FindBy(xpath = "(//a[@class='next'])[1]")
	private WebElement nextBtn;
	@FindBy(xpath = "//body[contains(@data-ng-class,'fbDesign')]")
	private WebElement Alert;
	// .......................................
	@FindBy(xpath ="//td[contains(@class,'text-left revisionBlock ng-scope')]") // changed the xpath from "//td[contains(@class,'dateTDwdth')]")
	private List<WebElement> timeSlotApp;
	@FindBy(xpath = "//span[contains(text(),'Tentative')]")
	private List<WebElement> tentative;
	@FindBy(xpath = "//span[contains(text(),'Confirmed')]")
	private List<WebElement> Confirmed;
	@FindBy(xpath = "//div[contains(@data-ng-click,'viewApp')]//span[@class='actn-icn view']")
	private List<WebElement> viewBtn;
	@FindBy(xpath = "//div[contains(@data-ng-click,'editApp')]//span[@class='actn-icn edit']")
	private List<WebElement> editBtn;
	@FindBy(id = "dashBoardFBList")
	private List<WebElement> feedbackBtn;
	@FindBy(xpath = "//div[contains(@data-ng-click,'confirmApp')]//span[@class='actn-icn delete']")
	private List<WebElement> deleteBtn;
	@FindBy(xpath = "//div[contains(@data-ng-click,'confirmApp')]//span[@class='actn-icn noShow']")
	private List<WebElement> noShowBtn;
	@FindBy(xpath = "//i[@class='ng-binding'][text()='No Record Found!']") // changed the xpath from "//table[@id='clinicApptAllListTable']//td[contains(text(),'No records found')]")
	public WebElement noRecordFoundMsg;
	@FindBy(id = "reason")
	private WebElement noShowVisibleText;
	// ......................After clicking on view view Btn Elements.....
	@FindBy(xpath = "//div[contains(text(),'Appointment')] ")
	private WebElement headerView;
	@FindBy(xpath = "//b[text()='Patient Id']/../following-sibling::div")
	private WebElement patientIdView;
	@FindBy(xpath = "//b[text()='Patient Name']/../following-sibling::div")
	private WebElement patientNameView;
	@FindBy(xpath = "//b[text()='Email Id']/../following-sibling::div")
	private WebElement emailIdView;
	@FindBy(xpath = "//b[text()='Mobile Number']/../following-sibling::div")
	private WebElement mobileNumView;
	@FindBy(xpath = "//b[text()='Clinic Name']/../following-sibling::div")
	private WebElement clinicNameView;
	@FindBy(xpath = "//b[text()='Date-Time']/../following-sibling::div")
	private WebElement DateOfAppView;
	@FindBy(xpath = "//b[text()='Duration']/../following-sibling::div")
	private WebElement durationView;
	@FindBy(xpath = "//b[text()='Doctor']/../following-sibling::div")
	private WebElement DoctorView;
	@FindBy(xpath = "//b[text()='Operatory']/../following-sibling::div")
	private WebElement operatoriesView;
	@FindBy(xpath = "//b[text()='Room']/../following-sibling::div")
	private WebElement roomsView;
	@FindBy(xpath = "//b[text()='Referral']/../following-sibling::div")
	private WebElement referralView;
	@FindBy(xpath = "//b[text()='Referral Notes']/../following-sibling::div")
	private WebElement referralDetailsView;
	@FindBy(xpath = "//b[text()='Source']/../following-sibling::div")
	private WebElement sourceView;
	@FindBy(xpath = "//b[text()='Chief Complaint']/../following-sibling::div")
	private WebElement chiefComplaintView;
	@FindBy(xpath = "//b[text()='Notes']/../following-sibling::div")
	private WebElement notesView;
	@FindBy(className = "fancybox-iframe")
	private WebElement frameView;
	@FindBy(id = "reason")
	private WebElement reasonOfDelApp;
	@FindBy(xpath = "//button[@class='close']/span[contains(@class,'cncl')]")
	private WebElement noBtn;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement yesForDeleteBtn;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement yesForNoShowBtn;
	@FindBy(xpath = "//div[@class='clearfix alertMessage'][contains(.,'Appointment deleted successfully')]")
	private WebElement deleteSuccessMsg;
	@FindBy(xpath = "//table[@id='appLis']//span[contains(@data-ng-click,'gotoPatientDashboard')]")
	private List<WebElement> patientDashboardCall;
	@FindBy(xpath = "(//a[@class='first']/i[contains(@class,'double-left')])[1]")
	private WebElement firstButton;
	@FindBy(id = "status")
	private WebElement apptStatusDropdownList;
	@FindBy(xpath = "//span[text()='New']")
	private List<WebElement> newStatus;
	@FindBy(xpath = "//span[text()='Follow On']")
	private List<WebElement> followOnStatus;
	@FindBy(xpath = "//span[text()='No Show']")
	private List<WebElement> noShowStatus;
	@FindBy(xpath = "//span[text()='ChkIN']") // [umar: 4-Jan-24] changed the xpath from "//span[text()='Checked In']")
	private List<WebElement> checkinStatus;
	@FindBy(xpath = "//span[text()='Expired']")
	private List<WebElement> expiredStatus;
	@FindBy(xpath = "//span[text()='Repeat']")
	private List<WebElement> repeatOnStatus;
	@FindBy(xpath = "//span[@class='actn-icn noShow']")
	private List<WebElement> dashboardNoShowIcon;
	@FindBy(id = "dashboardViewIconExpired")
	private List<WebElement> dashboardIconExpired;
	@FindBy(xpath = "//span[@class='dashboardViewIconExpired']")
	private List<WebElement> expired;
	@FindBy(id = "dashboardViewIconCheckIn")
	private List<WebElement> dashboardIconCheckIn;
	@FindBy(xpath = "//h4[text()='Are you sure you want to delete this appointment?']")
	private WebElement textOnDelete;
	@FindBy(xpath = "//div[text()='Select reason']")
	private WebElement reasonErrorMsg;
	@FindBy(xpath="//span[@class='actn-icn edit']/../../../div[1]")
	private WebElement viewAction;
//    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
//    private WebElement viewFrame;
	@FindBy(id = "tentative")
	private WebElement tentativeHeaderView;
	
	@FindBy(xpath = "//button[@class='close']")
	private WebElement closeViewModal;
	
	@FindBy(xpath = "//div[@class='clearfix topPagination pagingUI ng-scope']//a[@class='last']")
	private WebElement lastPage;

	/*
	 * Getters for the locators
	 */

	public WebElement getViewAction() {
		return viewAction;
	}
	public WebElement getPatientName() {
		return patientName;
	}

	public WebElement getPatientId() {
		return patientId;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getDoctor() {
		return doctor;
	}

	public WebElement getClinic() {
		return clinic;
	}

	public WebElement getActionBtn() {
		return actionBtn;
	}

	public WebElement getDocDropDoownBtn() {
		return docDropDoownBtn;
	}

	public WebElement getFromDateTxt() {
		return fromDateTxt;
	}

	public WebElement getFromDateCalenderIcon() {
		return fromDateCalenderIcon;
	}

	public WebElement getToDateTxt() {
		return toDateTxt;
	}

	public WebElement getToDateCalenderIcon() {
		return toDateCalenderIcon;
	}

	public WebElement getAppTypeDrpDwn() {
		return appTypeDrpDwn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getAlert() {
		return Alert;
	}

	public List<WebElement> getTimeSlotApp() {
		return timeSlotApp;
	}

	public List<WebElement> getTentative() {
		return tentative;
	}

	public List<WebElement> getConfirmed() {
		return Confirmed;
	}

	public List<WebElement> getViewBtn() {
		return viewBtn;
	}

	public List<WebElement> getEditBtn() {
		return editBtn;
	}

	public List<WebElement> getFeedbackBtn() {
		return feedbackBtn;
	}

	public List<WebElement> getDeleteBtn() {
		return deleteBtn;
	}

	public List<WebElement> getNoShowBtn() {
		return noShowBtn;
	}

	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}

	public WebElement getNoShowVisibleText() {
		return noShowVisibleText;
	}

	public WebElement getHeaderView() {
		return headerView;
	}

	public WebElement getPatientIdView() {
		return patientIdView;
	}

	public WebElement getPatientNameView() {
		return patientNameView;
	}

	public WebElement getEmailIdView() {
		return emailIdView;
	}

	public WebElement getMobileNumView() {
		return mobileNumView;
	}

	public WebElement getClinicNameView() {
		return clinicNameView;
	}

	public WebElement getDateOfAppView() {
		return DateOfAppView;
	}

	public WebElement getDurationView() {
		return durationView;
	}

	public WebElement getDoctorView() {
		return DoctorView;
	}

	public WebElement getOperatoriesView() {
		return operatoriesView;
	}

	public WebElement getRoomsView() {
		return roomsView;
	}

	public WebElement getReferralView() {
		return referralView;
	}

	public WebElement getReferralDetailsView() {
		return referralDetailsView;
	}

	public WebElement getSourceView() {
		return sourceView;
	}

	public WebElement getChiefComplaintView() {
		return chiefComplaintView;
	}

	public WebElement getNotesView() {
		return notesView;
	}

	public WebElement getFrameView() {
		return frameView;
	}

	public WebElement getReasonOfDelApp() {
		return reasonOfDelApp;
	}

	public WebElement getNoBtn() {
		return noBtn;
	}

	public WebElement getYesForDeleteBtn() {
		return yesForDeleteBtn;
	}

	public WebElement getYesForNoShowBtn() {
		return yesForNoShowBtn;
	}

	public WebElement getDeleteSuccessMsg() {
		return deleteSuccessMsg;
	}

	public List<WebElement> getPatientDashboardCall() {
		return patientDashboardCall;
	}

	public WebElement getFirstButton() {
		return firstButton;
	}

	public WebElement getApptStatusDropdownList() {
		return apptStatusDropdownList;
	}

	public List<WebElement> getNewStatus() {
		return newStatus;
	}

	public List<WebElement> getFollowOnStatus() {
		return followOnStatus;
	}

	public List<WebElement> getNoShowStatus() {
		return noShowStatus;
	}

	public List<WebElement> getCheckinStatus() {
		return checkinStatus;
	}

	public List<WebElement> getExpiredStatus() {
		return expiredStatus;
	}

	public List<WebElement> getRepeatOnStatus() {
		return repeatOnStatus;
	}

	public List<WebElement> getDashboardNoShowIcon() {
		return dashboardNoShowIcon;
	}

	public List<WebElement> getDashboardIconExpired() {
		return dashboardIconExpired;
	}

	public List<WebElement> getExpired() {
		return expired;
	}

	public List<WebElement> getDashboardIconCheckIn() {
		return dashboardIconCheckIn;
	}

	public WebElement getTextOnDelete() {
		return textOnDelete;
	}

	public WebElement getReasonErrorMsg() {
		return reasonErrorMsg;
	}

	public WebElement getTentativeHeaderView() {
		return tentativeHeaderView;
	}

	public WebElement getCloseViewModal() {
		return closeViewModal;
	}

	public WebElement getLastPage() {
		return lastPage;
	}

}
