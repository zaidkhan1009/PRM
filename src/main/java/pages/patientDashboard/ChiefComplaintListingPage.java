package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * 
 * @author Ajit Yadav
 *
 */
public class ChiefComplaintListingPage {
	private static final String FIRST = "Maxillary Right Posterior";
	private static final String SECOND = "Maxillary Right Anterior";
	private static final String THIRD = "Maxillary Left Anterior";
	private static final String FOURTH = "Maxillary Left Posterior";
	private static final String FIFTH = "Mandibular Right Posterior";
	private static final String SIXTH = "Mandibular Right Anterior";
	private static final String SEVENTH = "Mandibular Left Posterior";
	private static final String EIGHT = "Mandibular Left Anterior";

	/*WebElement of the chief complaint listing*/

	@FindBy(xpath = "(//div[@class='fnt_avgR dateClnc']/span)[1]")
	private WebElement dateOnCCList;
	@FindBy(xpath = "(//i[text()='No Record Found!'])[1]")
	private WebElement noRecordFoundMsg;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Chief Complaint']")
	private WebElement chiefComplaintMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Location']")
	private WebElement locationMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Intensity']")
	private WebElement intensityMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Period']")
	private WebElement periodMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Notes']")
	private WebElement notesMainList;
	@FindBy(xpath = "//div[@class='dtNClncs orlExmDateNClnc']/following-sibling::div//th[text()='Created By']")
	private WebElement createdByMainList;
	@FindBy(xpath = "//span[@class='clnsnametxt ng-binding']")
	private WebElement chiefComplaintsDates;

	/*webElement of view popup*/
	@FindBy(xpath = "//h4[contains(text(),'Chief Complaint Details')]")
	private WebElement headerViewPopup;
	@FindBy(xpath = "//strong[@class='ng-binding']")
	private WebElement userNameViewCWebElement;
	@FindBy(xpath = "//h4[contains(text(),'Chief Complaint Details')]/following-sibling::span[contains(@class,'compViewPopUpResponsive ng-binding')]")
	private WebElement dateInView;
	@FindBy(xpath = "//div[@class='modal-body viewInfo']//th[text()='Chief Complaint']")
	private WebElement chiefComplaintsInView;
	@FindBy(xpath = "//div[@class='modal-body viewInfo']//th[text()='Location']")
	private WebElement locationInView;
	@FindBy(xpath = "//div[@class='modal-body viewInfo']//th[text()='Intensity']")
	private WebElement intensityInView;
	@FindBy(xpath = "//div[@class='modal-body viewInfo']//th[text()='Period']")
	private WebElement periodsInView;
	@FindBy(xpath = "//tbody[@data-ng-repeat='input in viewList']/..//th[text()='Created By']")
	private WebElement createdByInView;
	@FindBy(xpath = "//h4[contains(text(),'Chief Complaint Details')]/..//button[@class='close']")
	private WebElement closeViewbutton;
	
	
	public static String getFirst() {
		return FIRST;
	}
	public static String getSecond() {
		return SECOND;
	}
	public static String getThird() {
		return THIRD;
	}
	public static String getFourth() {
		return FOURTH;
	}
	public static String getFifth() {
		return FIFTH;
	}
	public static String getSixth() {
		return SIXTH;
	}
	public static String getSeventh() {
		return SEVENTH;
	}
	public static String getEight() {
		return EIGHT;
	}
	public WebElement getDateOnCCList() {
		return dateOnCCList;
	}
	public WebElement getNoRecordFoundMsg() {
		return noRecordFoundMsg;
	}
	public WebElement getChiefComplaintMainList() {
		return chiefComplaintMainList;
	}
	public WebElement getLocationMainList() {
		return locationMainList;
	}
	public WebElement getIntensityMainList() {
		return intensityMainList;
	}
	public WebElement getPeriodMainList() {
		return periodMainList;
	}
	public WebElement getNotesMainList() {
		return notesMainList;
	}
	public WebElement getCreatedByMainList() {
		return createdByMainList;
	}
	public WebElement getChiefComplaintsDates() {
		return chiefComplaintsDates;
	}
	public WebElement getHeaderViewPopup() {
		return headerViewPopup;
	}
	public WebElement getUserNameViewCWebElement() {
		return userNameViewCWebElement;
	}
	public WebElement getDateInView() {
		return dateInView;
	}
	public WebElement getChiefComplaintsInView() {
		return chiefComplaintsInView;
	}
	public WebElement getLocationInView() {
		return locationInView;
	}
	public WebElement getIntensityInView() {
		return intensityInView;
	}
	public WebElement getPeriodsInView() {
		return periodsInView;
	}
	public WebElement getCreatedByInView() {
		return createdByInView;
	}
	public WebElement getCloseViewbutton() {
		return closeViewbutton;
	}

	
	

}
