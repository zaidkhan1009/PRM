package pageActions.patientDashboard;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.LabWorkOrderEditPage;

public class LabWorkOrderEditPageActions extends BaseClass {
	
	static LabWorkOrderEditPage labWorkOrderEditPage = PageFactory.initElements(driver, LabWorkOrderEditPage.class);

	
	/*--------Functions----------------*/

	/*checked LWO edit page and also work detail panel*/
	public static void checkedAllFieldsInWorkDetailPanel() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getWorkDetailsPanel()) && checkedWebElementDisplayed(labWorkOrderEditPage.getClinicNameInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getSourceInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getLabNoInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getLabInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getOrderTypeInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getWorkDetailsInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getOtherInfoInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getItemSendInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getAddfilesBtnInEdit()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Verify header of LWO edit page*/
	public static void verifyHeaderOfPage(String header) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(labWorkOrderEditPage.getHeaderOfPage());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(labWorkOrderEditPage.getHeaderOfPage().getText().contains(header));
	}

	/*Verify header of LWO ReWork page*/
	public static void verifyHeaderOfReWorkPage(String header) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(labWorkOrderEditPage.getHeaderOfReWorkPage());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(labWorkOrderEditPage.getHeaderOfReWorkPage().getText().contains(header));
	}

	/*Verify Work Details Panel*/
	public static void detailsPanel(String deatils) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(labWorkOrderEditPage.getWorkDetailsPanel().getText().contains(deatils));
	}

	/*checking clinic name in LWO Edit screen*/
	public static void clinicName(String clinicName) {
		BaseClass.waitForPageLoad();
		String str = labWorkOrderEditPage.getClinicNameInEdit().getText();
		String[] split = str.split(":");
		Assert.assertTrue(split[0].contains("Clinic Name"));
		Assert.assertEquals(split[1].trim(), clinicName);
	}

	/*checking source in LWO Edit screen */
	public static void source(String source) {
		BaseClass.waitForPageLoad();
		String str = labWorkOrderEditPage.getSourceInEdit().getText();
		String[] split = str.split(":");
		String actual_source=split[1].trim();
		Assert.assertTrue(split[0].contains("Source"));
		Assert.assertEquals(actual_source, source);
	}

	/*checking LWO No. in LWO Edit screen */
	public static void labWorkOrderNo() {
		BaseClass.waitForPageLoad();
		String str = labWorkOrderEditPage.getLabNoInEdit().getText();
		String[] split = str.split("-");
		try {
			String actual_lab=split[0].trim();
			boolean flag = actual_lab.contains("Lab Work Order No.:") && !(split[1].equals("NA") || split[1].equals("Null"));
			Assert.assertTrue(flag);
		}
		catch(ArrayIndexOutOfBoundsException object1) {
		}
	}

	/*checking lab Dropdown Edit screen */
	public static void checkLabDropDwn(String instanceName) {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(labWorkOrderEditPage.getLabDrpDwn());
		if(instanceName.equals("Prm2")) {
			String[] exp = { "Select Lab", "Dentcare - Ahemedabad", "Dentcare - Jaipur", "Dentcare - Pune", "Illusion Dental", "Jaipur ceramic lab","Sculpdent - Pune","Corona Dental Lab","Dentocraft","RR Dental Lab","Real Dental Lab","Shivam Dental Lab","Raj Laboratory","Pinkcity Ceramic Dental Lab"};
			Select select = new Select(labWorkOrderEditPage.getLabDrpDwn());
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				for (int i = 0; i < exp.length; i++) {
					if (flag2 = we.getText().equals(exp[i])) {
						match = flag1 && flag2;
					}
				}
				Assert.assertTrue(match);
			}
		}
		else {
			String[] exp = { "Select Lab", "Dentcare - Ahemedabad", "Dentcare - Jaipur", "Dentcare - Pune", "Illusion Dental", "Jaipur ceramic lab","Poona Dental Lab - Pune","Sculpdent - Pune","Dentocraft"};
			Select select = new Select(labWorkOrderEditPage.getLabDrpDwn());
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				for (int i = 0; i < exp.length; i++) {
					if (flag2 = we.getText().equals(exp[i])) {
						match = flag1 && flag2;
					}
				}
				Assert.assertTrue(match);
			}
		}
	}

	/*Select the lab from Lab dropdown field*/
	public static void selectLab(String labValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.selectFromDropDownByVisibleText(labWorkOrderEditPage.getLabDrpDwn(), labValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Get Lab from lab dropdown when we redirect from lab edit screen*/
	public static void getLabDrpDwn(String expectedLabName) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(labWorkOrderEditPage.getLabDrpDwn()).contains(expectedLabName));
	}

	/*checking Lab DropDown field on LWO ReWork Screen*/
	public static void checkLabForReWork() {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//select[@disabled='disabled']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	/*checking orderType field on Edit Screen*/
	public static void checkOrderType(String orderType) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getOrderTypeTxtBxInEdit());
		String ele = labWorkOrderEditPage.getOrderTypeTxtBxInEdit().getText();
		Assert.assertEquals(ele.trim(), orderType);
	}

	/*checking WorkDetails field on Edit Screen*/
	public static void checkWorkDetails(String workDetails) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getWorkDetailsTxtBxInEdit());
		String ele = labWorkOrderEditPage.getWorkDetailsTxtBxInEdit().getText();
		Assert.assertEquals(ele.trim(), workDetails);
	}

	/*checking OtherInfo field on Edit Screen*/
	public static void checkOtherInfo(String otherInfo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getOtherInfoTxtBxInEdit());
		String ele = labWorkOrderEditPage.getOtherInfoTxtBxInEdit().getText();
		Assert.assertEquals(ele.trim(), otherInfo);
	}

	/*checking ItemsSent field on Edit Screen*/
	public static void checkItemSendDrpDwn() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getItemSendInEdit())&& checkedWebElementDisplayed(labWorkOrderEditPage.getItemSendDrpDwn())
				&&labWorkOrderEditPage.getItemSendDrpDwn().getAttribute("tooltip").contains("Select Item"));
	}

	/*-- Click on Item Send DropDown--*/
	public static void clickOnItemSend() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			labWorkOrderEditPage.getItemSendDrpDwn().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Select the ItemsSent from ItemsSent dropdown field*/
	public static void selectItemsSend(String itemSendValue) {
		BaseClass.waitForPageLoad();
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multi-dropdown-Width')]//li//a//span[@class='ng-binding']"));
		System.out.println(list.size());

		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contains(itemSendValue)) {
				list.get(i).click();
				break;
			}
		}
	}

	/*Get Item Send from Item Send dropdown when we redirect from lab edit screen*/
	public static void getItemsSendDrpDwn(String itemSend) {
		BaseClass.waitForPageLoad();
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multi-dropdown-Width')]//li//a//span[@class='ng-binding']"));
		String ele;
		for(int i=0;i<list.size();i++) {

			if(list.get(i).getText().contains(itemSend)) {
				ele=list.get(i).getText();
				Assert.assertEquals(ele, itemSend);
				break;
			}
		}
	}
	
	/*Enter Updation Reason into Reason Textfields*/
	public static void addUpdateReason(String reason) {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getUpdateReasonTxtBx().clear();
		labWorkOrderEditPage.getUpdateReasonTxtBx().sendKeys(reason);
	}
	
	/*Attach single file from system*/
	public static void addFile(String path){
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getAddfilesBtnInEdit().click();
		try {
			labWorkOrderEditPage.getAddfilesBtnInEdit().click();
			Thread.sleep(2000);
			BaseClass.uploadFile(path);
			Thread.sleep(2000);
		} catch (AWTException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*Get a FileName shown on LWO Edit Screen*/
	public static void getFile(String fileName) {
		BaseClass.waitForPageLoad();
		String ele = driver.findElement(By.xpath("//span[text()='"+fileName+"']")).getText();
		Assert.assertEquals(ele, fileName);
	}

	/*Delete a File shown on LWO Edit Screen*/
	public static void deleteFile(String fileName) {
		BaseClass.waitForPageLoad();
		driver.findElement(By.xpath("//span[text()='"+fileName+"']/../a")).click();
	}

	/*Click on Yes after click on Delete button shown on File Name*/
	public static void clickOnYesDelete() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Do you want to delete this file?']")).isDisplayed());
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getYesOnDelete());
		labWorkOrderEditPage.getYesOnDelete().click();
	}

	/*checked Additional detail panel*/
	public static void checkedAdditionalDetailPanel() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getAdditionalDetailsPanel()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		labWorkOrderEditPage.getAdditionalDetailsPanel().click();
		BaseClass.scrollPage(350);
	}

	/*checked Additional detail panels all fields*/
	public static void checkedAllFieldsInAdditionalDetailPanel() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getRequireInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getShadeInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getClassicInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getThreeDInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getNaInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getStainsInternalInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getStainsExternalInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getTranslucencyInEdit()) &&
					checkedWebElementDisplayed(labWorkOrderEditPage.getTextureInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getConfigurationsInEdit())
					&& checkedWebElementDisplayed(labWorkOrderEditPage.getIndividualInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getSplintedJoinedInEdit())
					&& checkedWebElementDisplayed(labWorkOrderEditPage.getNotesInEdit()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*checking all option in Require Dropdown present in Additional details Panel*/
	public static void checkRequireDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(labWorkOrderEditPage.getRequireDrpDwn());
		String[] exp = { "Select Require", "Metal trial", "Bisque/Unglazed trial", "Final prosthesis"};
		Select select = new Select(labWorkOrderEditPage.getRequireDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*Select the Require from Require dropdown field*/
	public static void selectRequire(String requireValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			BaseClass.selectFromDropDownByVisibleText(labWorkOrderEditPage.getRequireDrpDwn(), requireValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Get Require from Require dropdown when we redirect from lab edit screen*/
	public static void getRequireDrpDwn(String expectedRequire) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(labWorkOrderEditPage.getRequireDrpDwn()).contains(expectedRequire));
	}

	/*Select Shade i.e either Classic,3D or NA */
	public static void selectShade(String shade) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//label[text()='"+shade+"']"));
		ele.click();
	}

	/*checking Shade Option Dropdown When we Select any Shade one dropdown gets open*/
	public static void checkShadeDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(labWorkOrderEditPage.getShadeDrpDwn());
		String[] exp = { "Select Shade", "A1", "A2", "A3", "A3.5", "A4","B1","B2","B3","B4","C1","C2","C3","C4","D2","D3","D4"};
		Select select = new Select(labWorkOrderEditPage.getShadeDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*Select the Shade Option Dropdown from Shade dropdown field*/
	public static void selectShadeOptionFromDrpDwn(String shadeValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			BaseClass.selectFromDropDownByVisibleText(labWorkOrderEditPage.getShadeDrpDwn(), shadeValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Get Shade Option from Shade option Dropdown when we redirect from lab edit screen*/
	public static void getShadeOptionDrpDwn(String expectedShade) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(labWorkOrderEditPage.getShadeDrpDwn()).contains(expectedShade));
	}

	/*checking all option in Stains Internal Dropdown present in Additional details Panel*/
	public static void checkStainsInternalDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(labWorkOrderEditPage.getStainsInternalDrpDwn());
		String[] exp = { "Select Stains Internal", "White Spots"};
		Select select = new Select(labWorkOrderEditPage.getStainsInternalDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*Select the Stains Internal from Stains Internal dropdown field*/
	public static void selectStainsInternal(String stainsInternalValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			BaseClass.selectFromDropDownByVisibleText(labWorkOrderEditPage.getStainsInternalDrpDwn(), stainsInternalValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Get Stains Internal from Stains Internal Dropdown when we redirect from lab edit screen*/
	public static void getStainsInternalDrpDwn(String expectedStainsInternal) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(labWorkOrderEditPage.getStainsInternalDrpDwn()).contains(expectedStainsInternal));
	}

	/*checking all option in Stains External Dropdown present in Additional details Panel*/
	public static void checkStainsExternalDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(labWorkOrderEditPage.getStainsExternalDrpDwn());
		String[] exp = { "Select Stains External", "Brown"};
		Select select = new Select(labWorkOrderEditPage.getStainsExternalDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*Select the Stains External from Stains External dropdown field*/
	public static void selectStainsExternal(String stainsExternalValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			BaseClass.selectFromDropDownByVisibleText(labWorkOrderEditPage.getStainsExternalDrpDwn(), stainsExternalValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/*Get Stains External from Stains External Dropdown when we redirect from lab edit screen*/
	public static void getStainsExternalDrpDwn(String expectedStainsExternal) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(labWorkOrderEditPage.getStainsExternalDrpDwn()).contains(expectedStainsExternal));
	}

	/*checking Translucency,texture and Notes Textfields present in Additional details Panel*/
	public static void checkedTranslucencyTextureAndNotes() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getTranslucencyTxtBx())&&labWorkOrderEditPage.getTranslucencyTxtBx().getAttribute("placeholder").contains("translucency")
				&& checkedWebElementDisplayed(labWorkOrderEditPage.getTextureTxtBx()) && labWorkOrderEditPage.getTextureTxtBx().getAttribute("placeholder").contains("texture")
				&& checkedWebElementDisplayed(labWorkOrderEditPage.getNotesTxtBx()) && labWorkOrderEditPage.getNotesTxtBx().getAttribute("placeholder").contains("notes"));
	}

	/*Enter data into Translucency Textfields*/
	public static void addTransluency(String transluency) {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getTranslucencyTxtBx().clear();
		labWorkOrderEditPage.getTranslucencyTxtBx().sendKeys(transluency);
	}

	/*Get Translucency from Translucency Textbox when we redirect from lab edit screen*/
	public static void getTranslucency(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getTranslucencyTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('address').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/*Enter data into texture Textfields*/
	public static void addTexture(String texture) {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getTextureTxtBx().clear();
		labWorkOrderEditPage.getTextureTxtBx().sendKeys(texture);
	}

	/*Get Texture from Texture Textbox when we redirect from lab edit screen*/
	public static void getTexture(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getTextureTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('texture').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	/*Select Configurations */
	public static void selectConfigurations(String configuration,String splitedOptions) {
		BaseClass.waitForPageLoad();
		if(configuration.equals("Individual"))
			labWorkOrderEditPage.getIndividualInEdit().click();
		else
		{
			labWorkOrderEditPage.getSplintedJoinedInEdit().click();
			WebElement ele = driver.findElement(By.xpath("//label[text()='"+splitedOptions+"']"));
			ele.click();
		}
	}

	/*-- Click on Buccal --*/
	public static void clickOnBuccal() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getBuccal());
			labWorkOrderEditPage.getBuccal().click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Click on Distal --*/
	public static void clickOnDistal() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getDistal());
		labWorkOrderEditPage.getDistal().click();
	}

	/*-- Click on Mesial --*/
	public static void clickOnMesial() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getMesial());
		labWorkOrderEditPage.getMesial().click();
	}

	/*-- Click on Lingual --*/
	public static void clickOnLingual() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getLingual());
		labWorkOrderEditPage.getLingual().click();
	}

	/*-- Checking on Provisinals --*/
	public static void verifyProvisinals() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(labWorkOrderEditPage.getProvisinals().size() > 0);
	}

	/*-- Select the Tooth Sites--*/
	public static void selectedToothAndSiteProvisionalDisplayedBelow() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 1 || labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 2
				|| labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 3 || labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 4
				|| labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 5 || labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 6
				|| labWorkOrderEditPage.getProvisionalRemoveBtnToothSite().size() == 7);
	}

	/*-- Click on Tooth Site and Perio Provisionals --*/
	public static void clickOnToothSiteAndPerioProvisinals() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='content'])[1]")).click();
		} catch (StaleElementReferenceException | InterruptedException e) {
			driver.findElement(By.xpath("(//div[@class='content'])[1]")).click();
		}
	}

	/*-- Verifying Provisinals is selected or not--*/
	public static void verifyProvisinalIsSelected(String name) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + name + "']/.."))
				.getAttribute("class").contains("selected"));
	}

	/*Enter data into Notes Textfields*/
	public static void enterNotes(String notes) {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getNotesTxtBx().clear();
		labWorkOrderEditPage.getNotesTxtBx().sendKeys(notes);
		BaseClass.scrollPage(350);
	}

	/*Get Notes from Notes Textbox when we redirect from lab edit screen*/
	public static void getNotes(String notes) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getNotesTxtBx());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('crownnotes').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, notes);
		BaseClass.scrollPage(350);
	}

	/*checking Save as Draft,Submitted to Lab,Cancel and reset button shown in LWO edit screen*/
	public static void checkedActionButtonInEdit() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderEditPage.getSaveAsDraftInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getSubmittedToLabInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getCancelInEdit()) && checkedWebElementDisplayed(labWorkOrderEditPage.getResetInEdit()));
	}

	/*Click the cancel button shown in LWO edit screen*/
	public static void clickOnCancelBtn() {
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getCancelInEdit());
		try {
			Thread.sleep(3000);
			labWorkOrderEditPage.getCancelInEdit().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*click button save as Draft button*/
	public static void clickSaveAsDraft() {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getSaveAsDraftInEdit().click();
	}

	/*click button Submitted to Lab button*/
	public static void clickSubmittedToLab() {
		BaseClass.waitForPageLoad();
		labWorkOrderEditPage.getSubmittedToLabInEdit().click();
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		try {
			List<WebElement> labChange = driver.findElements(By.xpath("//div[@class='col-md-12 modalConfirmTxt fnt_14'][contains(text(),'lab selected previously has been changed!')]"));
			boolean isLabChangeDisplayed = (labChange.get(0).isDisplayed());
			if (isLabChangeDisplayed) {
				WebElement yesBtnOnPopup = driver.findElement(By.xpath("//span[@class='cmnicons yes-mdl']"));
				BaseClass.waitForElementToBeClickable(yesBtnOnPopup);
				yesBtnOnPopup.click();
				BaseClass.waitForPageLoad();
				BaseClass.waitForSpinnerToDisappear();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Popup for Lab change when submit to lab handled");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Lab change popup hasn't appeared and handled");
		}
	}

	/*Click the reset button shown in LWO edit screen*/
	public static void clickOnResetBtn() {
		BaseClass.waitForElementToBeClickable(labWorkOrderEditPage.getResetInEdit());
		try {
			Thread.sleep(3000);
			labWorkOrderEditPage.getResetInEdit().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean checkedWebElementDisplayed(WebElement webelement) {
		return(webelement.isDisplayed());
	}
}
