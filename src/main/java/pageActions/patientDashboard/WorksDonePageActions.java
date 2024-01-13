package pageActions.patientDashboard;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pages.patientDashboard.WorksDonePage;

public class WorksDonePageActions extends BaseClass{
	
	static WorksDonePage worksDonePage = PageFactory.initElements(driver, WorksDonePage.class);

	public static void closeAppoitmentPopup() {
		BaseClass.waitForPageLoad();
		if(worksDonePage.getAppointmentCloseBtn().isDisplayed()){
			try {
				BaseClass.hoverOnElement(worksDonePage.getAppointmentCloseBtn());
				worksDonePage.getAppointmentCloseBtn().click();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void checkedTreatmentStartMsgDisplayed() {
		    BaseClass.waitForElementVisibility(worksDonePage.getSuccessTreatmentStartMsg(),4000);
			BaseClass.softAssert().assertTrue(checkedElementDisplayed(worksDonePage.getSuccessTreatmentStartMsg()));
			BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Selected treatment(s) Workdone started successfully')]")));
	}

	public static void checkedInvoiceListBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(worksDonePage.getInvoiceListBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getInvoiceListBtn()));
	}

	public static void checkedCollectAdvanceBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(worksDonePage.getCollectAdvanceBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getCollectAdvanceBtn()));
	}
	
	public static void checkedCollectPaymentBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(worksDonePage.getCollectPaymentBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getCollectPaymentBtn()));
	}
	
	public static void checkLabWorkOrderBtn(){
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(worksDonePage.getLabWorkOrderAddBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getLabWorkOrderAddBtn()));
	}
	public static void clickInvoiceListBtn() {
		try {
			Thread.sleep(2000);
			BaseClass.waitForElementToBeClickable(worksDonePage.getInvoiceListBtn());
			worksDonePage.getInvoiceListBtn().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkedHistoryBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(worksDonePage.getHistoryBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getHistoryBtn()));
	}

	public static void checkedAddAllBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(worksDonePage.getAddAllBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getAddAllBtn()));
	}

	public static void checkedAddAllBtnNotPresent() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElements(By.xpath("//i[text()='Add All']")).size()==0);
	}

	public static void checkedPrintBtn() {
		BaseClass.WaitTillElementIsPresent(worksDonePage.getPrintBtn());
		Assert.assertTrue(checkedElementDisplayed(worksDonePage.getPrintBtn()));
	}

	public static void checkedPrintBtnNotPresent() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//i[text()='Print']/..")).getAttribute("class").contains("hide"));
	}

	public static void checkProgressDropDown(String treatment){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedElementDisplayed(driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../..//select[@data-ng-model='value']"))));
	}
	
	public static void clickWorkDoneHistory() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(worksDonePage.getHistoryBtn(), 4000);
		worksDonePage.getHistoryBtn().click();
		BaseClass.waitForSpinnerToDisappear();
}
	
	
//	public static void clickWorkDoneHistory() {
//		try {
//			BaseClass.waitForPageLoad();
//			BaseClass.waitForElementToBeClickable(worksDonePage.getHistoryBtn());
//			worksDonePage.getHistoryBtn().click();
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void checkedUserName(String patientName) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(worksDonePage.getUserName());
		String str = worksDonePage.getUserName().getText();
		String[] split = str.split(" : ");
		boolean flag = split[0].contains(patientName) && !(split[1].equals("NA") || split[1].equals("Null"));
		Assert.assertTrue(flag);
	}

	public static void checkDateTreatment(String treatment, String todayDate) {
		BaseClass.waitForPageLoad();
		for (int i = 0; worksDonePage.getTreatmentStartedDate().size() > i; i++) {
			if (worksDonePage.getTreatments().get(i).getText().trim().contains(treatment)) {
				Assert.assertTrue(worksDonePage.getTreatmentStartedDate().get(i).getText().trim().contains(todayDate)
						&& worksDonePage.getTreatments().get(i).getText().trim().contains(treatment));
				break;
			} else {
				continue;
			}
		}
	}

	public static void checkSourceNo(String treatment, String source) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../..//span[text()='Source']/following-sibling::span[@class='toothNoCont ng-binding']"));
		Assert.assertTrue(web.getText().trim().contains(source));
	}
	
	public static void checkedStatusTreatment(String treatment, String status) {
		List<WebElement> web = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../..//span[contains(@class,'indicator_txt')]"));
		for (int i = 0; web.size() > i; i++) {
			if (web.get(i).getText().trim().contains(status)) {
				Select sel = new Select(driver.findElement(
						By.xpath("//span[contains(text(),'"+treatment+"')]/../..//select[@data-ng-model='value']")));
				if (status.equals("Started")) {
					Assert.assertTrue(web.get(i).getText().trim().contains(status)
							&& sel.getFirstSelectedOption().getText().trim().contains("Select Progress"));
				} else {
					Assert.assertTrue(web.get(i).getText().trim().contains(status)
							&& sel.getFirstSelectedOption().getText().trim().contains(status));
				}
				break;
			} else {
				continue;
			}
		}
	}
	
	public boolean checkTreatmentStagePresentAndEnable(WebElement trtmntStage) {
		boolean isStageEnabled = false;
				if(trtmntStage.isEnabled()) {
					isStageEnabled = true;
				}
		return isStageEnabled;
	}
	
	public static int getAlignerCount(WebElement stagWebElement) {
		int totalStages;
		String totalStageswithPara = stagWebElement.getText().split("\\(")[1];
		totalStages = Integer.parseInt(totalStageswithPara.split(" ")[0]);
		return totalStages;
	}
	
//	public boolean checkTreatmentStagePresentAndEnable(String treatmentPlan,String treatmentStage) {
//		boolean isStageEnabled = false;
//		WebElement stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'"+treatmentPlan+"')]/following::div[@class='custom-combo-new']//child::select"));
//		List<WebElement> treatmentOptions = ((PCDriver) driver).getDropdwnOptions(stagedrpDwn);
//		for(WebElement trtmntStage:treatmentOptions) {
//			if(trtmntStage.getText().trim().contains(treatmentStage.trim())){
//				if(trtmntStage.isEnabled()) {
//					isStageEnabled = true;
//				}
//			}
//		}
//		return isStageEnabled;
//	}
	
	public static void checkPlan(String treatmentPlan){
		   BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForElementVisibility(worksDonePage.getInvoiceListBtn(), 4000);
		    WebElement stagedrpDwn;
		    List<WebElement> treatmentOptions;
		    boolean stageIsEnabled =true;
		    String stageName="";
	        stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'" + treatmentPlan + "')]/following::div[@class='custom-combo-new']//child::select"));
	     	treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
		   
		            for (int i=1;i<treatmentOptions.size();i++) {
		            		stageName = treatmentOptions.get(i).getText().trim();
		            		System.out.println("The value of i"+i);
		            		  System.out.println("Stage Name"+" "+stageName);
		            		  stageIsEnabled = treatmentOptions.get(i).isEnabled();
	        		         System.out.println("Stage is"+stageIsEnabled);            	
	}
	}
	
	public static void verifyUIAndaddWorkDoneForAlignerTreatment(String treatmentPlan, String archType, String clinicalNotes) {
	    BaseClass.waitForSpinnerToDisappear();
	    BaseClass.waitForElementVisibility(worksDonePage.getInvoiceListBtn(), 4000);
	    WebElement stagedrpDwn;
	    List<WebElement> treatmentOptions;
	    boolean stageIsEnabled =true;
	    int memoryIndex =1;
		String stageName = "";
        stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'" + treatmentPlan + "')]/following::div[@class='custom-combo-new']//child::select"));
     	treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
	    switch (archType) {
	        case "Single":
	            for (int i=memoryIndex;i<treatmentOptions.size();i++) {
	            	try {
	            		 stageIsEnabled = treatmentOptions.get(memoryIndex).isEnabled();
	            	}
	            	  catch (StaleElementReferenceException e) {
	                  	 stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'" + treatmentPlan + "')]/following::div[@class='custom-combo-new']//child::select"));
	                	 treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
	                  }
	            	stageName = treatmentOptions.get(memoryIndex).getText().trim();
	                if (stageIsEnabled) {
	                    if ((stageName.matches(".*[0-9].*") && stageName.contains("left"))) {
	                        try {
	                        	BaseClass.selectFromDropDownByIndex(stagedrpDwn, memoryIndex);
	                            WebElement alignerElement =  treatmentOptions.get(memoryIndex);
	                            BaseClass.waitForElementVisibility(worksDonePage.getLowerArchLbl(), 4000);
	                            int totalStages = getAlignerCount(alignerElement);
	                            String halfStageString = Integer.toString((totalStages / 2));
	                            worksDonePage.getLowerArchInputTxt().clear();
	                            worksDonePage.getLowerArchInputTxt().sendKeys(halfStageString);
	                            selectDoctor(treatmentPlan, "Sup Head");
	                            selectTime(treatmentPlan, "15");
	                            enterRemarks(treatmentPlan, clinicalNotes);
	                            clickOnAdd(treatmentPlan);
	                            memoryIndex++;
	   	                	    addWorkDoneForAligner(treatmentPlan, Integer.toString(totalStages).trim(),memoryIndex);  
	   	                	    break;
	                        } catch (StaleElementReferenceException e) {
	   	                  	 stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'" + treatmentPlan + "')]/following::div[@class='custom-combo-new']//child::select"));
		                	 treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
		                  }
	                    } else {
	                            try {
	                                BaseClass.selectFromDropDownByIndex(stagedrpDwn, memoryIndex);
	                                memoryIndex++;
	                                selectDoctor(treatmentPlan, "Sup Head");
	                                selectTime(treatmentPlan, "15");
	                                enterRemarks(treatmentPlan, clinicalNotes);
	                                clickOnAdd(treatmentPlan);
	                                closeAppoitmentPopup();             
	                            }   catch (Exception e) {
	                                System.err.println("Error occurred while processing stage: " + stageName);
	                                e.printStackTrace();                                
	                            }    
	                    }                }
	            }
	    }
	}
	
	public static void addWorkDoneForAligner(String treatmntPlan, String totalStages, int memoryCount) {
		boolean isStageEnabled = true;
		String latestStageName = null;
		WebElement stagedrpDwn;
		List<WebElement> treatmentOptions;
			stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'"+treatmntPlan+"')]/following::div[@class='custom-combo-new']//child::select"));
			treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
			latestStageName = treatmentOptions.get(memoryCount).getText();
			if(latestStageName.contains("left")) {
				WebElement alignerElement =  treatmentOptions.get(memoryCount);
	        	  int newTotalStages = getAlignerCount(alignerElement);
	        	  clickOnEdit(treatmntPlan);
                  String totStageString = Integer.toString((newTotalStages));
                  worksDonePage.getLowerArchInputTxt().clear();
                  worksDonePage.getLowerArchInputTxt().sendKeys(totStageString);
			}	
			try {
				isStageEnabled = treatmentOptions.get(memoryCount).isEnabled();
				System.out.println(isStageEnabled);
			}catch (StaleElementReferenceException e) {
	             stagedrpDwn = driver.findElement(By.xpath("//span[contains(text(),'" + treatmntPlan + "')]/following::div[@class='custom-combo-new']//child::select"));
	           	 treatmentOptions = BaseClass.getDropdwnOptions(stagedrpDwn);
	             }
			latestStageName = treatmentOptions.get(memoryCount).getText();
			BaseClass.selectFromDropDownByIndex(stagedrpDwn, memoryCount);
			selectDoctor(treatmntPlan,"Sup Head");
			selectTime(treatmntPlan,"15");
			enterRemarks(treatmntPlan,"AlignerStageWorkDoneAdded");
			clickOnAdd(treatmntPlan);
			memoryCount++;      
			if(memoryCount != treatmentOptions.size()) {
			addWorkDoneForAligner(treatmntPlan,totalStages,memoryCount);
			}
	}

	public static void selectStages(String treatment, String stage) {
		BaseClass.waitForPageLoad();
		
		WebElement web = driver
				.findElement(By.xpath("//span[contains(text(),'" + treatment + "')]/../..//select[@data-ng-model='value']"));
		BaseClass.selectFromDropDownByVisibleText(web, stage);
	}

	public static void checkSuspededBtn(String treatment) {
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../..//span[@class='actn-icn suspend']"));
		for (int i = 0; web.size() > i; i++) {
			Assert.assertTrue(checkedElementDisplayed(web.get(i)));
		}
	}

	public static void checkDataName(String treatment) {
		BaseClass.waitForPageLoad();
		List<WebElement> dateTime = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Date/Time']"));
		List<WebElement> trtDentist = driver.findElements(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//th[text()='Trt. Dentist/Specialist']"));
		List<WebElement> clinicName = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Clinic Name']"));
		List<WebElement> time = driver.findElements(By
				.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Time']"));
		List<WebElement> trtStage = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Trt. Stage']"));
		List<WebElement> notes = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[contains(text(),'Clinical Notes')]"));
		List<WebElement> action = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//th[text()='Action']"));
		for (int i = 0; dateTime.size() > i; i++) {
			Assert.assertTrue(checkedElementDisplayed(dateTime.get(i)) && checkedElementDisplayed(trtDentist.get(i))
					&& checkedElementDisplayed(clinicName.get(i)) && checkedElementDisplayed(time.get(i))
					&& checkedElementDisplayed(trtStage.get(i)) && checkedElementDisplayed(notes.get(i))
					&& checkedElementDisplayed(action.get(i)));
		}
	}

	public static void checkBox(String treatment) {
		List<WebElement> web = driver.findElements(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//label[text()='Check']"));
		for (int i = 0; web.size() > i; i++) {
			Assert.assertTrue(checkedElementDisplayed(web.get(i)));
		}
	}

	public static void modifiedDate(String treatment, String todayDate) {
		List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//span[@class='legendOriginal legendOrgNoMrg ng-binding']"));
		for (int i = 0; web.size() > i; i++) {
			Assert.assertTrue(web.get(i).getText().trim().contains(todayDate));
		}
	}

	public static void checkDoctorTreated(String treatment, String doctor) {
		BaseClass.waitForPageLoad();
		
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment+ "')]/../../following-sibling::div//select[@id='Doctor']/../div"));
		Assert.assertTrue(web.getText().trim().equalsIgnoreCase(doctor));
	}

	public static void checkDoctorSelected(String treatment, String doctor) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//select[@id='Doctor']"));
		BaseClass.waitForElementVisibility(web, 4000);
		Select sel = new Select(web);
		Assert.assertTrue(sel.getFirstSelectedOption().getText().trim().equalsIgnoreCase(doctor));
	}

	public static void selectDoctor(String treatment, String doctor) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		WebElement web = driver.findElement(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//select[@id='Doctor']"));
		Select sel = new Select(web);
		if (sel.getFirstSelectedOption().getText().trim().equalsIgnoreCase(doctor)) {
			Assert.assertTrue(sel.getFirstSelectedOption().getText().trim().equalsIgnoreCase(doctor));
		} else {
			BaseClass.selectFromDropDownByVisibleText(web, doctor);
		}
	}

	public static void checkedClinic(String treatment, String clinic) {
		BaseClass.waitForPageLoad();
		List<WebElement> webElements = driver.findElements(
		By.xpath("//span[contains(text(),'" + treatment + "')]"));
		for (int i = 1;i<=webElements.size();i++) {
			String text = driver.findElement(By.xpath("(//span[contains(text(),'"+treatment+"')])["+i+"]/../../..//td[@class='ng-binding'][1]")).getText().trim();
			Assert.assertEquals(clinic, text);
		}
	}

	public static void checkTimeSelected(String treatment, String timeSlotSelected) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//select[@id='time']"));
		Select sel = new Select(web);
		Assert.assertTrue(sel.getFirstSelectedOption().getText().trim().contains(timeSlotSelected));
	}

	public static void checkSpentTime(String treatment, String spentTime) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//div[contains(@ng-hide,'worklogData.timeSpentEdit')]"));
		Assert.assertTrue(web.getText().trim().contains(spentTime));
	}

	public static void selectTime(String treatment, String timeSlotSelected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToDisappear(By.xpath("//div[@class='modal overlay show']"));
		WebElement web = driver.findElement(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//select[@id='time']"));
		BaseClass.selectFromDropDownByVisibleText(web, timeSlotSelected);
	}

	public static void checkedRemarks(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div//textarea"));
		Assert.assertTrue(web.getAttribute("maxlength").contains("768")
				&& web.getAttribute("placeholder").contains("no remarks"));
	}

	public static void enterRemarks(String treatment, String remarks) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(
				By.xpath("//span[contains(text(),'" + treatment + "')]/following::textarea[@data-ng-model ='workLogList.remarks']"));
		web.sendKeys(remarks);
	}

	public static void checkRemarksWorkDoneAddPage(String treatment, String remarks){
		BaseClass.waitForPageLoad();
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+treatment+"')]/../../following-sibling::div//tr//div[contains(@class,'notesWorkDone')]")).getText().contains(remarks));
	}

	public static void checkedAddButton(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//span[@class='actn-icn add']"));
		Assert.assertTrue(checkedElementDisplayed(web));
	}
	public static void workDoneAddBtnRedCovidPatient(String treatment) {
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//span[@class='actn-icn add']"));
		Assert.assertEquals(web.size(),0);
	}
	
	public static void clickOnAdd(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//span[@class='actn-icn add']"));
			web.click();
			BaseClass.waitForSpinnerToDisappear(); 		
	}


	public static void checkStatus(String treatment, String status) {
		BaseClass.waitForPageLoad();
		List<WebElement> webElements = driver.findElements(
				By.xpath("//span[contains(text(),'" + treatment + "')]/../../following-sibling::div/table/tbody/tr"));
		for (int i = 1; webElements.size() > i; i++) {
			int j = i + 1;
			

			WebElement web = driver.findElement(
					By.xpath("//span[contains(text(),'"+treatment+"')]/../../following-sibling::div/table/tbody/tr[" + j
							+ "]/td[6]"));
			Assert.assertTrue(web.getText().trim().contains(status));
			break;
		}
	}

	public static void checkedRemarks(String treatment, String remarks) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../following-sibling::div//div[@class='notesWorkDone ng-binding']"));
		Assert.assertTrue(web.getText().trim().equalsIgnoreCase(remarks));
	}

	public static void checkEdit(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../../..//following-sibling::span[@class='actn-icn edit']"));
		Assert.assertTrue(checkedElementDisplayed(web));
	}
	
	public static void clickOnEdit(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement edit = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../..//following-sibling::span[@class='actn-icn edit']"));
	  edit.click();
	}
	
	public static void clickOnSaveAlignerPulledIn(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement save = driver.findElement(By.xpath("//span[contains(text(),'" + treatment
				+ "')]/../..//following-sibling::span[@class='actn-icn save']"));
		save.click();
	}
	
	public static void verifyLWOActionMessage(){
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(3000);
            BaseClass.softAssert().assertTrue(checkedElementDisplayed(worksDonePage.getActionMsg()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	
	
	public static void clickSuspendBtn(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/../following-sibling::div//span[@class='actn-icn suspend']"));
		ele.click();
	}

	/*Select the Reason after click on ReTreat button from Reason Dropdown field*/
	public static void selectRequire(String reasonValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.selectFromDropDownByVisibleText(worksDonePage.getReasonDrpDwn(), reasonValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void clickSaveBtnOnReasonPopUp() {
		BaseClass.waitForPageLoad();
		worksDonePage.getReasonSaveBtn().click();
	}
	

	public static void clickLWOBtnWD() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(worksDonePage.getLwoBtnWorkDone());
		try {
			Thread.sleep(7000);
			Assert.assertTrue(checkedElementDisplayed(worksDonePage.getLwoBtnWorkDone()));
			worksDonePage.getLwoBtnWorkDone().click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean checkedElementDisplayed(WebElement element) {
		return (element.isDisplayed());
	}
	
	//new method created by shrey sharma to collect payment using collectPay btn on Work done add page bcz of implementation of criteria to complete payment before completing the trt
	public static void completePaymentToCompleteTrt() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele = driver.findElement(By.xpath("//a[@data-ng-click='redirectRcptType($event)']"));
		System.out.println("Payment collect : "+ele.getText().trim());
		if(ele.getText().trim().contains("Collect Pay")) {
		
		BaseClass.WaitTillElementIsPresent(worksDonePage.getCollectPaymentBtn());
		worksDonePage.getCollectPaymentBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		NewReceiptPageActions.addingReceiptEqualRemainingAmount();
		NewReceiptPageActions.clickSaveBtn();
		
		BasePatientLifeCyclePageActions.clickOnDashBoardReceiptPage();
		BasePatientLifeCyclePageActions.clickOnAlert();

		PatientDashboardPageActions.clickOnWorkDoneAdd();
		}
		else
			System.out.println("Payment already collected");
		
	}

}
