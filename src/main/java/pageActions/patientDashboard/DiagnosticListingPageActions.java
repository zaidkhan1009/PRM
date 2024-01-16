package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.DiagnosticListingPage;
import utils.TestData;
public class DiagnosticListingPageActions extends BaseClass {
	
	static DiagnosticListingPage diagnosticListingPage = PageFactory.initElements(driver, DiagnosticListingPage.class);

	/*checking the column name at diagnosis listing page*/
	public static void checkedDataName() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticListingPage.getCategoryDiagnosticsList());
		Assert.assertTrue(checkedElementDisplayed(diagnosticListingPage.getCategoryDiagnosticsList()) && checkedElementDisplayed(diagnosticListingPage.getInvestigation())
				&& checkedElementDisplayed(diagnosticListingPage.getCreatedByDiagnosticsList()) && checkedElementDisplayed(diagnosticListingPage.getNotesDiagnosticsList()));
	}

	/*checking the column name at diagnosis listing page at view modal*/
	public static void checkedDataNameViewPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticListingPage.getCategoryViewPop());
		Assert.assertTrue(checkedElementDisplayed(diagnosticListingPage.getCategoryViewPop()) && checkedElementDisplayed(diagnosticListingPage.getInvestigationViewPop())
				&& checkedElementDisplayed(diagnosticListingPage.getCreatedByViewPop()) && checkedElementDisplayed(diagnosticListingPage.getNotesViewPop()));
	}

	/*checking the diagnosis at diagnosis listing page*/
	public static void checkedDiagnosisMainList(String diagnosis) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath(
				"//table[@class='table wordbreak']//following-sibling::tbody//td[text()='" + diagnosis + "']"))));
	}

	/*checking the investigation name at diagnosis listing page*/
	public static void investigationMainList(String diagnosis,String InvestigationName){
		BaseClass.waitForPageLoad();
		if(diagnosis.equalsIgnoreCase("IOPAR")){
			Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[@class='btmCls ng-binding' and text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'DiagnoTeethCs ioparInListTeeth')]")).getText().equalsIgnoreCase(InvestigationName));
		}else{
				Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[@class = 'btmCls ng-binding' and text()='"+diagnosis+"']/following-sibling::td//div[contains(text(),'"+InvestigationName+"')]")).getText().equalsIgnoreCase(InvestigationName));
		}
	}

	/*checking the created by name at diagnosis listing page*/
	public static void createdByMainList(String diagnosis,String createdBy){
		BaseClass.waitForPageLoad();
		if(diagnosis.equalsIgnoreCase("IOPAR")){
			Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'ioparInListcrtdBy')]")).getText().equalsIgnoreCase(createdBy));
		}else{
			Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'created')]")).getText().equalsIgnoreCase(createdBy));
		}
	}

	/*checking the notes at the diagnosis listing page*/
	public static void notesByMainList(String diagnosis,String notes) {
		BaseClass.waitForPageLoad();
		if (diagnosis.equalsIgnoreCase("IOPAR")) {
			Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[text()='" + diagnosis + "']/following-sibling::td//div[contains(@class,'ioparInListNotes')]")).getText().equalsIgnoreCase(notes));
		} else {
			Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table wordbreak']//following-sibling::tbody//td[text()='" + diagnosis + "']/following-sibling::td//div[contains(@class,'notes-xs-area DiagnoTeethCs')]")).getText().equalsIgnoreCase(notes));
		}
	}

	/*checking the patient name and patient id is not null in Diagnostic View modal*/
	public static void verifyPatientNameInView(String patientName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(diagnosticListingPage.getUserName());
		String str = diagnosticListingPage.getUserName().getText();
		System.out.println("PatientName "+str);
		String[] split = str.split(" : ");
		boolean flag = split[0].contains(patientName) && !(split[1].trim().equals("NA") || split[1].trim().equals("Null"));
		Assert.assertTrue(flag);
	}
	
	/*checking Diagnostic Add date on View modal*/
	public static void verifyDateInView() {
		    BaseClass.waitForSpinnerToDisappear();
			WebElement web = driver.findElement(By.xpath("(//span[contains(@class,'compViewPopUpResponsive ')])[2]"));
			String fullDate =  web.getText().split(":")[1];
			String actualDate = fullDate.trim();
			String expectedDate = TestData.getInstance().getTodayDate().trim();
			Assert.assertTrue(expectedDate.equals(actualDate));
	}
		
	/*checking the diagnosis name at diagnosis listing page at view modal*/
	public static void checkDiagnosisViewPopup(String diagnosis) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver
				.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='" + diagnosis + "']"))));
	}

	/*checking the investigation at diagnosis listing page at view modal*/
	public static void investigationView(String diagnosis,String InvestigationName){
		BaseClass.waitForPageLoad();
		if(diagnosis.equalsIgnoreCase("IOPAR")){
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[@class='ng-binding' and text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'DiagnoTeethCs ioparInListTeeth')]")).getText().equalsIgnoreCase(InvestigationName));
		}else{	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[@class='ng-binding' and text()='"+diagnosis+"']/following-sibling::td//div[contains(text(),'"+InvestigationName+"')]")).getText().equalsIgnoreCase(InvestigationName));
			}
//			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'investigation')]")).getText().equalsIgnoreCase(InvestigationName));
		
	}

	/*checking the created by name at diagnosis listing page at view modal*/
	public static void createdByView(String diagnosis,String createdBy){
		BaseClass.waitForPageLoad();
		if(diagnosis.equalsIgnoreCase("IOPAR")){
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'ioparInListcrtdBy')]")).getText().equalsIgnoreCase(createdBy));
		}else{
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'created-wrp-list')]")).getText().equalsIgnoreCase(createdBy));
		}
	}

	/*checking the notes at diagnosis listing page at view modal*/
	public static void notesView(String diagnosis,String notes){
		BaseClass.waitForPageLoad();
		if(diagnosis.equalsIgnoreCase("IOPAR")){
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'ioparInListNotes')]")).getText().equalsIgnoreCase(notes));
		}else{
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='diglistviewmbody']//td[text()='"+diagnosis+"']/following-sibling::td//div[contains(@class,'notes-xs-area DiagnoTeethCs')]")).getText().equalsIgnoreCase(notes));
		}
	}

	/*checking webelement present at the webpage*/
	private static boolean checkedElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
