package pageActions.patientDashboard;

import base.BaseClass;
import pages.patientDashboard.CovidAppointmentNewUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CovidAppointmentNewUIPageActions extends BaseClass {
    
	static CovidAppointmentNewUI covidAppointmentNewUI = PageFactory.initElements(driver, CovidAppointmentNewUI.class);
	
    //Reusable function
    //closing the covid form modal
    public static void closeCovidForm() {
        BaseClass.waitForPageLoad();
        try {
            BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCancelCovidFormBtn());
            covidAppointmentNewUI.getCancelCovidFormBtn().click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeCovidFormPD() {
        BaseClass.waitForPageLoad();
        try {
            BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCancelCovidFormBtnPD());
            covidAppointmentNewUI.getCancelCovidFormBtnPD().click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void saveCovidForm() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getSaveCovidFormBtn());
        covidAppointmentNewUI.getSaveCovidFormBtn().click();
    }
    
    public static void saveCovidFormPD() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getSaveCovidFormBtnPD());
        covidAppointmentNewUI.getSaveCovidFormBtnPD().click();
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForPageLoad();
    }

    //checking patient name and patient id
    public static void patientNameCovidForm(String patient) {
    	BaseClass.waitForPageLoad();
    	BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getHeaderCovidForm());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getHeaderCovidForm()) && covidAppointmentNewUI.getPatientName().getText().contains(patient) && !(covidAppointmentNewUI.getPatientMobile().getText().contains("NA") || covidAppointmentNewUI.getPatientMobile().getText().contains("null")));
    }
    
    public static void patientNameCovidFormPD(String patient) {
    	BaseClass.waitForPageLoad();
    	BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getHeaderCovidFormPD());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getHeaderCovidFormPD()) && covidAppointmentNewUI.getPatientName().getText().contains(patient) && !(covidAppointmentNewUI.getPatientMobile().getText().contains("NA") || covidAppointmentNewUI.getPatientMobile().getText().contains("null")));
    }

    //checking action button
    public static void checkActionsNewPatient() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCancelCovidFormBtn());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCancelCovidFormBtn()) && checkedWebElementDisplayed(covidAppointmentNewUI.getSaveCovidFormBtn()));
    }

    //check all mandatory question of the covid form
    public static void question_1() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_1());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_1()) && checkedWebElementDisplayed(covidAppointmentNewUI.getHighFever()) && checkedWebElementDisplayed(covidAppointmentNewUI.getDifficultyBreathing()) && checkedWebElementDisplayed(covidAppointmentNewUI.getCoughSoreThroat()) && checkedWebElementDisplayed(covidAppointmentNewUI.getSneezingRunningNose()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoneOfThem()));
    }

    public static void question_2() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_2());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_2()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_2()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_2()));
    }

    public static void question_3() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_3());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_1()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_3()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_3()));
    }

    public static void question_4() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_4());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_4()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_4()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_4()));
    }

    public static void question_5() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_5());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_5()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_5()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_5()));
    }

    public static void question_6() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_6());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_6()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_6()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_6()));
    }

    public static void question_7() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_7());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_7()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_7()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_7()));
    }

    public static void question_8() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_8());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_8()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_8()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_8()));
    }

    public static void question_9() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_9());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_9()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYesBtnCovidQue_9()) && checkedWebElementDisplayed(covidAppointmentNewUI.getNoBtnCovidQue_9()));
    }

    public static void question_10() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_10());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_10()) && checkedWebElementDisplayed(covidAppointmentNewUI.getTextFieldsCovidQue_10()));
    }

    public static void question_11() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_11());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_11()) && checkedWebElementDisplayed(covidAppointmentNewUI.getTextFieldsCovidQue_11()));
    }

    public static void question_12() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getCovidQue_12());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getCovidQue_12()) && checkedWebElementDisplayed(covidAppointmentNewUI.getGreenBtnCovidQue_12()) && checkedWebElementDisplayed(covidAppointmentNewUI.getYellowBtnCovidQue_12()) && checkedWebElementDisplayed(covidAppointmentNewUI.getRedBtnCovidQue_12()));
    }

    public static void remarksTextFields() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getRemarksTextFields());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getRemarksTextFields()) && checkedWebElementDisplayed(covidAppointmentNewUI.getMaxCarMsg()));
    }

    //selecting the options
    public static void yesOption(int count) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getYesBtnCovidQue_2());
        switch (count) {
            case 3:
                covidAppointmentNewUI.getYesBtnCovidQue_3().click();
                break;
            case 2:
                covidAppointmentNewUI.getYesBtnCovidQue_2().click();
                break;
            case 4:
                covidAppointmentNewUI.getYesBtnCovidQue_4().click();
                break;
            case 5:
                covidAppointmentNewUI.getYesBtnCovidQue_5().click();
                break;
            case 6:
                covidAppointmentNewUI.getYesBtnCovidQue_6().click();
                break;
            case 7:
                covidAppointmentNewUI.getYesBtnCovidQue_7().click();
                break;
            case 8:
                covidAppointmentNewUI.getYesBtnCovidQue_8().click();
                break;
            case 9:
                covidAppointmentNewUI.getYesBtnCovidQue_9().click();
                break;
        }
    }

    public static void noOption(int count) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getNoBtnCovidQue_2());
        switch (count) {
            case 3:
                covidAppointmentNewUI.getNoBtnCovidQue_3().click();
                break;
            case 2:
                covidAppointmentNewUI.getNoBtnCovidQue_2().click();
                break;
            case 4:
                covidAppointmentNewUI.getNoBtnCovidQue_4().click();
                break;
            case 5:
                covidAppointmentNewUI.getNoBtnCovidQue_5().click();
                break;
            case 6:
                covidAppointmentNewUI.getNoBtnCovidQue_6().click();
                break;
            case 7:
                covidAppointmentNewUI.getNoBtnCovidQue_7().click();
                break;
            case 8:
                covidAppointmentNewUI.getNoBtnCovidQue_8().click();
                break;
            case 9:
                covidAppointmentNewUI.getNoBtnCovidQue_9().click();
                break;
        }
    }

    public static void noOptionSelected(int count) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getNoBtnCovidQue_2());
        switch (count) {
            case 2:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_2().getAttribute("class").contains("active"));
                break;
            case 3:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_3().getAttribute("class").contains("active"));
                break;
            case 4:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_4().getAttribute("class").contains("active"));
                break;
            case 5:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_5().getAttribute("class").contains("active"));
                break;
            case 6:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_6().getAttribute("class").contains("active"));
                break;
            case 7:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_7().getAttribute("class").contains("active"));
                break;
            case 8:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_8().getAttribute("class").contains("active"));
                break;
            case 9:
                Assert.assertTrue(covidAppointmentNewUI.getNoBtnCovidQue_9().getAttribute("class").contains("active"));
                break;
        }
    }

    public static void errorMsgDisplayed() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getErrorMsg());
        Assert.assertTrue(checkedWebElementDisplayed(covidAppointmentNewUI.getErrorMsg()));
    }

    public static void selectFirstQuestion(String symptoms) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getHighFever());
        switch (symptoms) {
            case "High Fever":
                BaseClass.executeScript(covidAppointmentNewUI.getHighFever());
                break;
            case "Difficulty in Breathing":
                BaseClass.executeScript(covidAppointmentNewUI.getDifficultyBreathing());
                break;
            case "Cough / Sore Throat":
                BaseClass.executeScript(covidAppointmentNewUI.getCoughSoreThroat());
                break;
            case "Sneezing / Running Nose":
                BaseClass.executeScript(covidAppointmentNewUI.getSneezingRunningNose());
                break;
            case "None of Them":
                BaseClass.executeScript(covidAppointmentNewUI.getNoneOfThem());
                break;
        }
    }

    public static void selectedFirstQuestion(String symptoms) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getHighFever());
        switch (symptoms) {
            case "High Fever":
                Assert.assertTrue(covidAppointmentNewUI.getHighFever().getAttribute("class").contains("active"));
                break;
            case "Difficulty in Breathing":
                Assert.assertTrue(covidAppointmentNewUI.getDifficultyBreathing().getAttribute("class").contains("active"));
                break;
            case "Cough / Sore Throat":
                Assert.assertTrue(covidAppointmentNewUI.getCoughSoreThroat().getAttribute("class").contains("active"));
                break;
            case "Sneezing / Running Nose":
                Assert.assertTrue(covidAppointmentNewUI.getSneezingRunningNose().getAttribute("class").contains("active"));
                break;
            case "None of Them":
                Assert.assertTrue(covidAppointmentNewUI.getNoneOfThem().getAttribute("class").contains("active"));
                break;
        }
    }

    public static void greenFlag() {
        Assert.assertTrue(covidAppointmentNewUI.getLowProbability().getAttribute("class").contains("active"));
    }

    public static void patientTemperature() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_10());
        String temperature = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidAppointmentNewUI.getTextFieldsCovidQue_10());
        Assert.assertTrue(temperature.isEmpty());
    }

    public static void patientOximeter() {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_11());
        String oximeter = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidAppointmentNewUI.getTextFieldsCovidQue_11());
        Assert.assertTrue(oximeter.isEmpty());
    }

    public static void setPatientTemperature(String temperature) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_10());
        covidAppointmentNewUI.getTextFieldsCovidQue_10().clear();
        covidAppointmentNewUI.getTextFieldsCovidQue_10().sendKeys(temperature);
    }

    public static void setPatientOximeter(String oximeter) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_11());
        covidAppointmentNewUI.getTextFieldsCovidQue_11().clear();
        covidAppointmentNewUI.getTextFieldsCovidQue_11().sendKeys(oximeter);
    }

    public static void checkPatientTemperature(String temp) {
    	BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_10());
        String temperature = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidAppointmentNewUI.getTextFieldsCovidQue_10());
        Assert.assertEquals(temperature, temp);
    }

    public static void checkPatientOximeter(String oximeter) {
        BaseClass.waitForElementToBeClickable(covidAppointmentNewUI.getTextFieldsCovidQue_11());
        String ximeterLevel = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidAppointmentNewUI.getTextFieldsCovidQue_11());
        Assert.assertEquals(ximeterLevel, oximeter);
    }

    private static boolean checkedWebElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }
}
