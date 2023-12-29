package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class ChiefComplaintAddPage {
	

	/*WebElement of the chief complaint Add page*/
	@FindBy(xpath = "//div[contains(@class,'sideNavigation')]//i[contains(text(),'Oral Exam +')]")
	private WebElement oralExamBtn;
	@FindBy(xpath = "//span[contains(text(),'Chief Complaint added successfully!')]")
	private WebElement successMsg;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesOnDelete;
	@FindBy(xpath = "//div[@class='modal-body ccAddEditModal']//h4[text()='Location']")
	private WebElement location;
	@FindBy(id = "intensitySecPopUp")
	private WebElement intensity;
	@FindBy(id = "period")
	private WebElement period;
	@FindBy(id = "ccRemark")
	private WebElement notes;
	@FindBy(xpath = "//span[contains(@class,'maxillary')]")
	private WebElement maxillary;
	@FindBy(xpath = "//span[contains(@class,'mandibular')]")
	private WebElement mandibular;
	@FindBy(css = "button[aria-label='Save']")
	private WebElement saveBtn;
	@FindBy(css = "button[aria-label='Close']")
	private WebElement closeBtn;
	@FindBy(xpath = "//div[@class='posteriorAntrrior']//a[contains(@data-ng-if,'Posterior')]")
	private List<WebElement> locations;
	@FindBy(className = "Severe")
	private WebElement severe;
	@FindBy(className = "Moderate")
	private WebElement moderate;
	@FindBy(className = "Mild")
	private WebElement mild;
	@FindBy(xpath = "//div[@class='spetrr']//h5[text()='Month(s)']/following-sibling::a[@class='periodScrollUp']")
	private WebElement monthSliderUp;
	@FindBy(xpath = "//div[@class='spetrr']//h5[text()='Day(s)']/following-sibling::a[@class='periodScrollUp']")
	private WebElement daySliderUp;
	@FindBy(xpath = "//div[@class='maxiMandiSectn']/following-sibling::div//span[text()='Right']")
	private WebElement right;
	@FindBy(xpath = "//div[@class='maxiMandiSectn']/following-sibling::div//span[text()='Left']")
	private WebElement left;
	@FindBy(xpath = "//div[@class='spetrr']//h5[text()='Month(s)']")
	private WebElement month;
	@FindBy(xpath = "//div[@class='spetrr']//h5[text()='Day(s)']")
	private WebElement day;
	@FindBy(xpath = "//span[contains(text(),'30')]")
	private WebElement dayInMonth;
	@FindBy(xpath = "//span[contains(text(),'12')]")
	private WebElement monthInYear;
	@FindBy(xpath = "//th[text()='Chief Complaint']")
	private WebElement chiefComplaintInputList;
	@FindBy(xpath = "//th[text()='Location']")
	private WebElement locationInputList;
	@FindBy(xpath = "//th[text()='Intensity']")
	private WebElement intensityInputList;
	@FindBy(xpath = "//th[text()='Period']")
	private WebElement periodInputList;
	@FindBy(xpath = "//th[text()='Notes']")
	private WebElement notesInputList;
	@FindBy(xpath = "//th[text()='Action']")
	private WebElement actionInputList;
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement chiefCmpltPopUp;
	@FindBy(xpath = "//div[@class='alert ng-isolate-scope alert-success alert-dismissable']")
	private WebElement successAlert;
	
	
	
	public WebElement getOralExamBtn() {
		return oralExamBtn;
	}
	public WebElement getSuccessMsg() {
		return successMsg;
	}
	public WebElement getYesOnDelete() {
		return yesOnDelete;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getIntensity() {
		return intensity;
	}
	public WebElement getPeriod() {
		return period;
	}
	public WebElement getNotes() {
		return notes;
	}
	public WebElement getMaxillary() {
		return maxillary;
	}
	public WebElement getMandibular() {
		return mandibular;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCloseBtn() {
		return closeBtn;
	}
	public List<WebElement> getLocations() {
		return locations;
	}
	public WebElement getSevere() {
		return severe;
	}
	public WebElement getModerate() {
		return moderate;
	}
	public WebElement getMild() {
		return mild;
	}
	public WebElement getMonthSliderUp() {
		return monthSliderUp;
	}
	public WebElement getDaySliderUp() {
		return daySliderUp;
	}
	public WebElement getRight() {
		return right;
	}
	public WebElement getLeft() {
		return left;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getDay() {
		return day;
	}
	public WebElement getDayInMonth() {
		return dayInMonth;
	}
	public WebElement getMonthInYear() {
		return monthInYear;
	}
	public WebElement getChiefComplaintInputList() {
		return chiefComplaintInputList;
	}
	public WebElement getLocationInputList() {
		return locationInputList;
	}
	public WebElement getIntensityInputList() {
		return intensityInputList;
	}
	public WebElement getPeriodInputList() {
		return periodInputList;
	}
	public WebElement getNotesInputList() {
		return notesInputList;
	}
	public WebElement getActionInputList() {
		return actionInputList;
	}
	public WebElement getChiefCmpltPopUp() {
		return chiefCmpltPopUp;
	}
	public WebElement getSuccessAlert() {
		return successAlert;
	}
	

	

}