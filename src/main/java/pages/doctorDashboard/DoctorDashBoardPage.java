package pages.doctorDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class DoctorDashBoardPage {

	@FindBy(xpath ="//a[@src='images/clove-logo.png'])")
	private WebElement clovelogo;
	
	@FindBy(id ="dashBoardScheduler")
	private WebElement scheduler;
	
	@FindBy(id ="dashBoardAppointmentAdd")
	private WebElement AppAddBtn;
	
	@FindBy(id ="mainDashboard")
	private WebElement Dashboard;
	
	@FindBy(id ="dashBoardScheduler")
	private WebElement dhBdSc;
	
	@FindBy(id ="saveMessage") //changed from class ='clearfix saveMessage' to id
	private WebElement successMsg;
	
	@FindBy(id ="dashBoardAppointment")
	private WebElement AppListBtn;
	
	@FindBy(id ="dashBoardPatientsAdd")
	private WebElement patientAdd;
	
	@FindBy(xpath ="//div[@id='customLoading'][not(contains(@style,'none'))]")
	public WebElement customOverlay;
	
	@FindBy(id="dashBoardMiscList")
	public WebElement miscCallsListBtn;
	
	@FindBy(id="dashBoardMiscAdd")
	public WebElement miscCallsAddBtn;
	
	@FindBy(id="dashBoardFBList")
	private WebElement feedbackListing;
	
	@FindBy(id ="dashBoardSubscriberList")
	private WebElement subscriberBtn;
	
	@FindBy(xpath = "//span[@class='cmnicons ccAdd']") //changed the locator from id ="dashBoardCampSubsList")
	private WebElement dashBoardCampSubs;
	
	@FindBy(id="dashBoardProducts")
	private WebElement dashboardProductSale;
	
	@FindBy(id="dashBoardCampSubsList")
	private WebElement campSubscriberListing;
	
	public WebElement getClovelogo() {
		return clovelogo;
	}
	public WebElement getScheduler() {
		return scheduler;
	}
	public WebElement getAppAddBtn() {
		return AppAddBtn;
	}
	public WebElement getDashboard() {
		return Dashboard;
	}
	public WebElement getDhBdSc() {
		return dhBdSc;
	}
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	public WebElement getAppListBtn() {
		return AppListBtn;
	}
	public WebElement getPatientAdd() {
		return patientAdd;
	}
	public WebElement getCustomOverlay() {
		return customOverlay;
	}
	public WebElement getMiscCallsListBtn() {
		return miscCallsListBtn;
	}
	public WebElement getMiscCallsAddBtn() {
		return miscCallsAddBtn;
	}
	public WebElement getFeedbackListing() {
		return feedbackListing;
	}
	public WebElement getSubscriberBtn() {
		return subscriberBtn;
	}
	public WebElement getDashBoardCampSubs() {
		return dashBoardCampSubs;
	}
	public WebElement getDashboardProductSale() {
		return dashboardProductSale;
	}
	public WebElement getCampSubscriberListing() {
		return campSubscriberListing;
	} 

}
