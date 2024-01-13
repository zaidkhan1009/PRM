package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class BasePatientLifeCyclePage {
	

	/*WebElements which is common at the patient dashboard*/
	@FindBy(xpath = "//div[@id='wrapper']//i[contains(text(),'No Record Found')]")
	private WebElement NoRecordFoundMsg;
	@FindBy(xpath = "//span[contains(@class,'left-nav')]")
	private WebElement openLeftNavigationBtn;
	@FindBy(xpath = "//div[contains(@class,'left-nav')]")
	private WebElement closeLeftNavigationBtn;
	@FindBy(xpath = "//b[text()='Oral Exams']")
	private WebElement oralExam;
	@FindBy(xpath = "//b[text()='Diagnostics']")
	private WebElement Diagnostics;
	@FindBy(xpath = "//b[text()='Treatments']")
	private WebElement Treatments;
	@FindBy(xpath = "//b[text()='Works Done']")
	private WebElement WorksDone;
	@FindBy(id = "prescriptionList")
	private WebElement Prescriptions;
	@FindBy(id = "filesList")
	private WebElement filesList;
	@FindBy(id = "invoicesList")
	private WebElement invoicesList;
	@FindBy(xpath = "//a[@id='patientDashboardBtn']")
	private WebElement DashboardBtn;

	@FindBy(xpath = "//span[@class='cmnicons dashB']")
	private WebElement commonDashboardBtn;
	
	public WebElement getCommonDashboardBtn() {
		return commonDashboardBtn;
	}
	@FindBy(xpath = "(//span[@class='cmnicons dashB'])[2]")
	private WebElement DashboardBtnReceipt;
	@FindBy(xpath = "//i[text()='Add New']")
	private WebElement AddNewBtn;
	@FindBy(xpath = "//b[text()='Add New']")
	private WebElement AddNewBtnOldUi;
//	@FindBy(xpath = "//div[@class='alertwrp']")
	@FindBy(className = "alertButt")
	private WebElement alert;
	@FindBy(xpath = "//div[@id='patientAlert'][contains(@style,'right: -1px')]")
	private List <WebElement> alertBody;
	@FindBy(css = "nav[class='navmenu navmenu-default navmenu-fixed-left']")
	public WebElement leftNavigationCloseBtnOldUi;
	@FindBy(xpath = "//h1[contains(@class,'pull-left')]")
	private WebElement listPageHeader;
	@FindBy(xpath = "//h1[contains(@class,'pull-left')]")
	private WebElement addPageHeader;
	@FindBy(xpath = "//h4[contains(@class,'modal-title')]")
	private WebElement viewPopupHeader;
	@FindBy(xpath = "//span[contains(@class,'mdl-hdr-text')]")
	private WebElement userName;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement closeBtnViewPop;
	@FindBy(xpath = "(//div[@class='fnt_avgR dateClnc']/span)[1]")
	private WebElement getDate;
	
	
	public WebElement getNoRecordFoundMsg() {
		return NoRecordFoundMsg;
	}
	public WebElement getOpenLeftNavigationBtn() {
		return openLeftNavigationBtn;
	}
	public WebElement getCloseLeftNavigationBtn() {
		return closeLeftNavigationBtn;
	}
	public WebElement getOralExam() {
		return oralExam;
	}
	public WebElement getDiagnostics() {
		return Diagnostics;
	}
	public WebElement getTreatments() {
		return Treatments;
	}
	public WebElement getWorksDone() {
		return WorksDone;
	}
	public WebElement getPrescriptions() {
		return Prescriptions;
	}
	public WebElement getFilesList() {
		return filesList;
	}
	public WebElement getInvoicesList() {
		return invoicesList;
	}
	public WebElement getDashboardBtn() {
		return DashboardBtn;
	}
	public WebElement getDashboardBtnReceipt() {
		return DashboardBtnReceipt;
	}
	public WebElement getAddNewBtn() {
		return AddNewBtn;
	}
	public WebElement getAddNewBtnOldUi() {
		return AddNewBtnOldUi;
	}
	public WebElement getAlert() {
		return alert;
	}
	public List<WebElement> getAlertBody() {
		return alertBody;
	}
	public WebElement getLeftNavigationCloseBtnOldUi() {
		return leftNavigationCloseBtnOldUi;
	}
	public WebElement getListPageHeader() {
		return listPageHeader;
	}
	public WebElement getAddPageHeader() {
		return addPageHeader;
	}
	public WebElement getViewPopupHeader() {
		return viewPopupHeader;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getCloseBtnViewPop() {
		return closeBtnViewPop;
	}
	public WebElement getGetDate() {
		return getDate;
	}


	

}
