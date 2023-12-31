package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorksDonePage {

	@FindBy(xpath = "//form//a[contains(@href,'invoiceList')]")
	private WebElement invoiceListBtn;
	@FindBy(xpath = "//a//i[contains(text(),'Collect Adv')]")
	private WebElement collectAdvanceBtn;
	@FindBy(xpath = "//a//i[contains(text(),'Collect Pay')]")
	private WebElement collectPaymentBtn;
	@FindBy(xpath = "//span[@class='indicator_txt pull-right mrgn-right-20 ng-binding ng-scope']")
	private WebElement workDoneStage;
	@FindBy(xpath = "//form//a[contains(@href,'wdHistoryList')]")
	private WebElement historyBtn;
	@FindBy(xpath = "//span[contains(@class,'wdNameInfIcon ')]")
	private WebElement userName;
	@FindBy(xpath = "//span[contains(text(),'Selected treatment(s) Workdone started successfully')]")
	private WebElement successTreatmentStartMsg;
	@FindBy(xpath = "//i[text()='Add All']")
	private WebElement addAllBtn;
	@FindBy(xpath = "//i[text()='Print']")
	private WebElement printBtn;
	@FindBy(xpath = "//span[contains(@class,'clnsnametxt ng-binding')]")
	private List<WebElement> treatmentStartedDate;
	@FindBy(xpath = "//span[contains(@class,'clnsnametxt ng-binding')]/following-sibling::span[contains(@class,'dis-inline')]")
	private List<WebElement> treatments;
	@FindBy(id = "Doctor")
	private WebElement doctorDrpDwn;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement appointmentCloseBtn;
	@FindBy(xpath = "//span[text()='Action can not be completed as the Lab WO for 1 treatment(s) is in draft mode']")
    private WebElement ActionMsg;
	@FindBy(id="reason")
	private WebElement reasonDrpDwn;
	@FindBy(xpath="//span[@class='cmnicons sv-mdl']")
	private WebElement reasonSaveBtn;
	@FindBy(xpath = "//span[@class='cmnicons labadd']")
	private WebElement labWorkOrderAddBtn;
	@FindBy(id = "Progress")
	private WebElement progressDropDown;
	@FindBy(xpath = "//label[@for='upper']")
	private WebElement upperArchLbl;
	@FindBy(xpath = "//input[@id='upper']")
	private WebElement upperArchInputTxt;
	@FindBy(xpath = "//label[@for='lower']")
	private WebElement lowerArchLbl;
	@FindBy(xpath = "//input[@id='lower']")
	private WebElement lowerArchInputTxt;
	@FindBy(xpath = "//div[@class='alert ng-isolate-scope alert-success alert-dismissable']")
	private WebElement workDoneSuccAlrtMsg;
	
	/*LWO Btn in WorkDone  */
	@FindBy(xpath="//span[@class='cmnicons labadd']")
	private WebElement lwoBtnWorkDone;

	public WebElement getInvoiceListBtn() {
		return invoiceListBtn;
	}

	public WebElement getCollectAdvanceBtn() {
		return collectAdvanceBtn;
	}

	public WebElement getCollectPaymentBtn() {
		return collectPaymentBtn;
	}

	public WebElement getWorkDoneStage() {
		return workDoneStage;
	}

	public WebElement getHistoryBtn() {
		return historyBtn;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getSuccessTreatmentStartMsg() {
		return successTreatmentStartMsg;
	}

	public WebElement getAddAllBtn() {
		return addAllBtn;
	}

	public WebElement getPrintBtn() {
		return printBtn;
	}

	public List<WebElement> getTreatmentStartedDate() {
		return treatmentStartedDate;
	}

	public List<WebElement> getTreatments() {
		return treatments;
	}

	public WebElement getDoctorDrpDwn() {
		return doctorDrpDwn;
	}

	public WebElement getAppointmentCloseBtn() {
		return appointmentCloseBtn;
	}

	public WebElement getActionMsg() {
		return ActionMsg;
	}

	public WebElement getReasonDrpDwn() {
		return reasonDrpDwn;
	}

	public WebElement getReasonSaveBtn() {
		return reasonSaveBtn;
	}

	public WebElement getLabWorkOrderAddBtn() {
		return labWorkOrderAddBtn;
	}

	public WebElement getProgressDropDown() {
		return progressDropDown;
	}

	public WebElement getUpperArchLbl() {
		return upperArchLbl;
	}

	public WebElement getUpperArchInputTxt() {
		return upperArchInputTxt;
	}

	public WebElement getLowerArchLbl() {
		return lowerArchLbl;
	}

	public WebElement getLowerArchInputTxt() {
		return lowerArchInputTxt;
	}

	public WebElement getWorkDoneSuccAlrtMsg() {
		return workDoneSuccAlrtMsg;
	}

	public WebElement getLwoBtnWorkDone() {
		return lwoBtnWorkDone;
	}

	
}
