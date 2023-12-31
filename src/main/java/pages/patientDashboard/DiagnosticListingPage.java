package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiagnosticListingPage {
	
	/*webelements*/
	@FindBy(xpath = "//table[@class='table wordbreak']//th[text()='Category']")
	private WebElement categoryDiagnosticsList;
	@FindBy(xpath = "//table[@class='table wordbreak']//th[text()='Investigation']")
	private WebElement investigation;
	@FindBy(xpath = "//table[@class='table wordbreak']//th[text()='Created By']")
	private WebElement createdByDiagnosticsList;
	@FindBy(xpath = "//table[@class='table wordbreak']//th[text()='Notes']")
	private WebElement notesDiagnosticsList;
	
	/*Web Elements present in View Pop up */
	@FindBy(xpath = "//span[contains(@class,'compHistPadR')]")
	private WebElement userName;
	@FindBy(xpath = "//div[@id='diglistviewmbody']//th[text()='Category']")
	private WebElement categoryViewPop;
	@FindBy(xpath = "//div[@id='diglistviewmbody']//th[text()='Investigation']")
	private WebElement investigationViewPop;
	@FindBy(xpath = "//div[@id='diglistviewmbody']//th[text()='Created By']")
	private WebElement createdByViewPop;
	@FindBy(xpath = "//div[@id='diglistviewmbody']//th[text()='Notes']")
	private WebElement notesViewPop;
	
	
	public WebElement getCategoryDiagnosticsList() {
		return categoryDiagnosticsList;
	}
	public WebElement getInvestigation() {
		return investigation;
	}
	public WebElement getCreatedByDiagnosticsList() {
		return createdByDiagnosticsList;
	}
	public WebElement getNotesDiagnosticsList() {
		return notesDiagnosticsList;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getCategoryViewPop() {
		return categoryViewPop;
	}
	public WebElement getInvestigationViewPop() {
		return investigationViewPop;
	}
	public WebElement getCreatedByViewPop() {
		return createdByViewPop;
	}
	public WebElement getNotesViewPop() {
		return notesViewPop;
	}

	
	
}
