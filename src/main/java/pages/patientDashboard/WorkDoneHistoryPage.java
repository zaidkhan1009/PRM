package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkDoneHistoryPage {

	@FindBy(xpath = "//i[text()='Print']")
	private WebElement print;
	@FindBy(xpath = "//span[contains(@class,'clnsnametxt ng-binding')]")
	private List<WebElement> treatmentStartedDate;
	@FindBy(xpath = "//span[contains(@class,'clnsnametxt ng-binding')]/following-sibling::span[contains(@class,'dis-inline')]")
	private List<WebElement> treatments;
	@FindBy(id="reason")
	private WebElement reasonDrpDwn;
	@FindBy(xpath="//span[@class='cmnicons sv-mdl']")
	private WebElement reasonSaveBtn;
	@FindBy(xpath="//i[text()='Add New']")
	private WebElement addNewBtn;
	@FindBy(xpath = "//span[@class='cmnicons labadd']")
	private WebElement labWorkOrderAddBtn;
	@FindBy(xpath = "//i[text()='Print']")
	private WebElement printBtn;
	@FindBy(xpath = "//form//a[contains(@href,'invoiceList')]")
	private WebElement invoiceListBtn;
	/**
	 * webelement of the follow modal
	 */
	@FindBy(xpath = "//h4[@class='modal-title popup-title']")
	private WebElement followUpModalHeader;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//span[@class='cmnicons sv-mdl']")
	private WebElement followUpSaveBtn;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//span[@class='cmnicons cncl-mdl']")
	private WebElement followUpModalCloseBtn;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//b[text()='Treatment Name']/../following-sibling::div")
	private WebElement treatmentFollowUpModal;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//b[text()='Source']/../following-sibling::div")
	private WebElement teethFollowUpModal;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//b[text()='Clinic Name']/../following-sibling::div")
	private WebElement clinicNameFollowUpModal;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//select[@id='Doctor']")
	private WebElement treatingDoctorFollowUp;
	@FindBy(xpath = "//form[@id='wdHistoryListFollowupModal']//select[@id='Time']")
	private WebElement timeSpentFollowup;
	@FindBy(xpath = "//label[text()='Treating Dentist']")
	private WebElement headerTreatingDentist;
	@FindBy(xpath = "//label[text()='Time Spent']")
	private WebElement headerTimeSpent;
	@FindBy(xpath = "//label[text()='Notes']")
	private WebElement headerNotesFollowup;
	@FindBy(id = "notes")
	private WebElement notesFollowUp;
	@FindBy(xpath = "//span[text()='768 characters left']")
	private WebElement maxCharLimitNotesMsg;
	@FindBy(xpath = "//textarea[@id='notes']/../..//div[text()='Enter Notes']")
	private WebElement errorMsgNote;
	/**
	 * webelement of the re-treat modal
	 */
	@FindBy(xpath = "//form[@id='retreatForm']//h4")
	private WebElement headerRetreatModal;
	@FindBy(xpath = "//form[@id='retreatForm']//span[@class='cmnicons sv-mdl']")
	private WebElement saveRetreatBtn;
	@FindBy(xpath = "//form[@id='retreatForm']//span[@class='cmnicons cncl-mdl']")
	private WebElement closeReTreatBtn;
	@FindBy(xpath = "//form[@id='retreatForm']//label[text()='Treating Dentist']")
	private WebElement HeaderTreatingDentistRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//select[@id='Doctor']")
	private WebElement treatingDentistRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//label[text()='Stage']")
	private WebElement headerStageRetreat;
	@FindBy(xpath = "//label[@for='Stage']/..//select[@data-ng-model='value']")
	private WebElement stageDrpDwnRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//label[text()='Reason']")
	private WebElement headrReasonRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//select[@id='reason']")
	private WebElement reasonDrpdwnRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//div[contains(@class,'error')]")
	private WebElement errorMssage;
	@FindBy(xpath = "//form[@id='retreatForm']//label[text()='Notes']")
	private WebElement headerNotesRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//textarea[@id='notes']")
	private WebElement notesRetreat;
	@FindBy(xpath = "//form[@id='retreatForm']//span[text()='768 characters left']")
	private WebElement maxCharMsgREtreat;
	public WebElement getPrint() {
		return print;
	}
	public List<WebElement> getTreatmentStartedDate() {
		return treatmentStartedDate;
	}
	public List<WebElement> getTreatments() {
		return treatments;
	}
	public WebElement getReasonDrpDwn() {
		return reasonDrpDwn;
	}
	public WebElement getReasonSaveBtn() {
		return reasonSaveBtn;
	}
	public WebElement getAddNewBtn() {
		return addNewBtn;
	}
	public WebElement getLabWorkOrderAddBtn() {
		return labWorkOrderAddBtn;
	}
	public WebElement getPrintBtn() {
		return printBtn;
	}
	public WebElement getInvoiceListBtn() {
		return invoiceListBtn;
	}
	public WebElement getFollowUpModalHeader() {
		return followUpModalHeader;
	}
	public WebElement getFollowUpSaveBtn() {
		return followUpSaveBtn;
	}
	public WebElement getFollowUpModalCloseBtn() {
		return followUpModalCloseBtn;
	}
	public WebElement getTreatmentFollowUpModal() {
		return treatmentFollowUpModal;
	}
	public WebElement getTeethFollowUpModal() {
		return teethFollowUpModal;
	}
	public WebElement getClinicNameFollowUpModal() {
		return clinicNameFollowUpModal;
	}
	public WebElement getTreatingDoctorFollowUp() {
		return treatingDoctorFollowUp;
	}
	public WebElement getTimeSpentFollowup() {
		return timeSpentFollowup;
	}
	public WebElement getHeaderTreatingDentist() {
		return headerTreatingDentist;
	}
	public WebElement getHeaderTimeSpent() {
		return headerTimeSpent;
	}
	public WebElement getHeaderNotesFollowup() {
		return headerNotesFollowup;
	}
	public WebElement getNotesFollowUp() {
		return notesFollowUp;
	}
	public WebElement getMaxCharLimitNotesMsg() {
		return maxCharLimitNotesMsg;
	}
	public WebElement getErrorMsgNote() {
		return errorMsgNote;
	}
	public WebElement getHeaderRetreatModal() {
		return headerRetreatModal;
	}
	public WebElement getSaveRetreatBtn() {
		return saveRetreatBtn;
	}
	public WebElement getCloseReTreatBtn() {
		return closeReTreatBtn;
	}
	public WebElement getHeaderTreatingDentistRetreat() {
		return HeaderTreatingDentistRetreat;
	}
	public WebElement getTreatingDentistRetreat() {
		return treatingDentistRetreat;
	}
	public WebElement getHeaderStageRetreat() {
		return headerStageRetreat;
	}
	public WebElement getStageDrpDwnRetreat() {
		return stageDrpDwnRetreat;
	}
	public WebElement getHeadrReasonRetreat() {
		return headrReasonRetreat;
	}
	public WebElement getReasonDrpdwnRetreat() {
		return reasonDrpdwnRetreat;
	}
	public WebElement getErrorMssage() {
		return errorMssage;
	}
	public WebElement getHeaderNotesRetreat() {
		return headerNotesRetreat;
	}
	public WebElement getNotesRetreat() {
		return notesRetreat;
	}
	public WebElement getMaxCharMsgREtreat() {
		return maxCharMsgREtreat;
	}


}
