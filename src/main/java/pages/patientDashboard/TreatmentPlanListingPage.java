package pages.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.Float;

public class TreatmentPlanListingPage {

	@FindBy(xpath = "//h1[contains(@class,'btmTitle pull-left')]")
	private WebElement headerOfPage;
	@FindBy(xpath = "//div[contains(@class,'no_record_found_dir')]//i[text()='No Record Found!']")
	private WebElement noRecordMsg;
	@FindBy(xpath = "(//div[@class='fnt_avgR dateClnc']/span)[1]")
	private WebElement DateInTreatmentList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='WD']")
	private WebElement wdMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Source']")
	private WebElement sourceMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Unit Cost']")
	private WebElement unitCostMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Net Amt.']")
	private WebElement netAmtMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Cpn. Value ']")
	private WebElement cpnValueMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Amt. Pay.']")
	private WebElement amtPayMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Created By']")
	private WebElement createdByMainList;
	@FindBy(xpath = "//table[@id='treatmentlistingtable']//th[text()='Cpn. Basis']")
	private WebElement cpnBasisByMainList;

	// -------webelement of view popup in treatment listing-
	@FindBy(id = "myModalLabel")
	private WebElement headerViewPopup;
	@FindBy(xpath = "//h4[contains(text(),'Treatment Plan View')]/..//button[@class='close']")
	private WebElement closeBtnViewPopup;

	// ------webelement in doctor list popup
	@FindBy(id = "myModalLabel")
	private WebElement headerOfDoctorLsit;
	@FindBy(xpath = "//h4[@id='myModalLabel']/preceding-sibling::div//span[@class='cmnicons sv-mdl']")
	private WebElement saveBtnInDoctorList;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesBtnForDelete;
	@FindBy(xpath = "//span[contains(text(),'Treatment plan deleted successfully!')]")
	private WebElement deleteSuccessMsg;
	@FindBy(xpath = "//span[contains(text(),'Please select treatment(s) for starting Workdone')]")
	private WebElement selectTreatmentMessage;
	@FindBy(xpath = "//span[text()='Treatment(s) could not be started. Please update patient Covid-19 Declaration!']")
	private List<WebElement> covidUpdateAlert;
	@FindBy(xpath = "//span[@class='cmnicons ccAdd']")
	private WebElement addNewBtn;
	@FindBy(xpath = "//span[contains(text(),'Treatment plan copied successfully!')]")
	private WebElement copyPlanAlrtTxt;
	public WebElement getHeaderOfPage() {
		return headerOfPage;
	}
	public WebElement getNoRecordMsg() {
		return noRecordMsg;
	}
	public WebElement getDateInTreatmentList() {
		return DateInTreatmentList;
	}
	public WebElement getWdMainList() {
		return wdMainList;
	}
	public WebElement getSourceMainList() {
		return sourceMainList;
	}
	public WebElement getUnitCostMainList() {
		return unitCostMainList;
	}
	public WebElement getNetAmtMainList() {
		return netAmtMainList;
	}
	public WebElement getCpnValueMainList() {
		return cpnValueMainList;
	}
	public WebElement getAmtPayMainList() {
		return amtPayMainList;
	}
	public WebElement getCreatedByMainList() {
		return createdByMainList;
	}
	public WebElement getCpnBasisByMainList() {
		return cpnBasisByMainList;
	}
	public WebElement getHeaderViewPopup() {
		return headerViewPopup;
	}
	public WebElement getCloseBtnViewPopup() {
		return closeBtnViewPopup;
	}
	public WebElement getHeaderOfDoctorLsit() {
		return headerOfDoctorLsit;
	}
	public WebElement getSaveBtnInDoctorList() {
		return saveBtnInDoctorList;
	}
	public WebElement getYesBtnForDelete() {
		return yesBtnForDelete;
	}
	public WebElement getDeleteSuccessMsg() {
		return deleteSuccessMsg;
	}
	public WebElement getSelectTreatmentMessage() {
		return selectTreatmentMessage;
	}
	public List<WebElement> getCovidUpdateAlert() {
		return covidUpdateAlert;
	}
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getCopyPlanAlrtTxt() {
		return copyPlanAlrtTxt;
	}

	
	
}
