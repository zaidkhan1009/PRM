package pageActions.patientDashboard;

import base.BaseClass;
import pages.patientDashboard.CovidDeclarationFormPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CovidDeclarationFormPageActions extends BaseClass {
    
	static CovidDeclarationFormPage covidDeclarationForm = PageFactory.initElements(driver, CovidDeclarationFormPage.class);


    
    //Reusable function
    //closing the covid form modal
    public static void closeCovidForm() {
        BaseClass.waitForPageLoad();
        try {
            BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCancelCovidFormBtn());
            covidDeclarationForm.getCancelCovidFormBtn().click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void saveCovidForm() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getSaveCovidFormBtn());
        covidDeclarationForm.getSaveCovidFormBtn().click();
    }

    //checking patient name and patient id
    public static void patientNameCovidForm(String patient) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getHeaderCovidForm());
        Assert.assertTrue(covidDeclarationForm.getHeaderCovidForm().getText().contains("Covid-19 Declaration") && covidDeclarationForm.getPatientName().getText().equalsIgnoreCase(patient) && !(covidDeclarationForm.getPatientId().getText().contains("NA") || covidDeclarationForm.getPatientId().getText().contains("null")));
    }

    //checking action button
    public void checkActionsNewPatient() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCancelCovidFormBtn());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCancelCovidFormBtn()) && checkedWebElementDisplayed(covidDeclarationForm.getSaveCovidFormBtn()));
    }

    //check all mandatory question of the covid form
    public void question_1() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_1());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_1()) && checkedWebElementDisplayed(covidDeclarationForm.getHighFever()) && checkedWebElementDisplayed(covidDeclarationForm.getDifficultyBreathing()) && checkedWebElementDisplayed(covidDeclarationForm.getCoughSoreThroat()) && checkedWebElementDisplayed(covidDeclarationForm.getSneezingRunningNose()) && checkedWebElementDisplayed(covidDeclarationForm.getNoneOfThem()));
    }

    public void question_2() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_2());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_2()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_2()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_2()));
    }

    public void question_3() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_3());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_1()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_3()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_3()));
    }

    public void question_4() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_4());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_4()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_4()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_4()));
    }

    public void question_5() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_5());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_5()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_5()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_5()));
    }

    public void question_6() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_6());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_6()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_6()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_6()));
    }

    public void question_7() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_7());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_7()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_7()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_7()));
    }

    public void question_8() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_8());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_8()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_8()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_8()));
    }

    public void question_9() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_9());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_9()) && checkedWebElementDisplayed(covidDeclarationForm.getYesBtnCovidQue_9()) && checkedWebElementDisplayed(covidDeclarationForm.getNoBtnCovidQue_9()));
    }

    public void question_10() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_10());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_10()) && checkedWebElementDisplayed(covidDeclarationForm.getTextFieldsCovidQue_10()));
    }

    public void question_11() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_11());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_11()) && checkedWebElementDisplayed(covidDeclarationForm.getTextFieldsCovidQue_11()));
    }

    public void question_12() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getCovidQue_12());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getCovidQue_12()) && checkedWebElementDisplayed(covidDeclarationForm.getGreenBtnCovidQue_12()) && checkedWebElementDisplayed(covidDeclarationForm.getYellowBtnCovidQue_12()) && checkedWebElementDisplayed(covidDeclarationForm.getRedBtnCovidQue_12()));
    }

    public void remarksTextFields() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getRemarksTextFields());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getRemarksTextFields()) && checkedWebElementDisplayed(covidDeclarationForm.getMaxCarMsg()));
    }

    //selecting the options
    public void yesOption(int count) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getYesBtnCovidQue_2());
        switch (count) {
            case 3:
                covidDeclarationForm.getYesBtnCovidQue_3().click();
                break;
            case 2:
                covidDeclarationForm.getYesBtnCovidQue_2().click();
                break;
            case 4:
                covidDeclarationForm.getYesBtnCovidQue_4().click();
                break;
            case 5:
                covidDeclarationForm.getYesBtnCovidQue_5().click();
                break;
            case 6:
                covidDeclarationForm.getYesBtnCovidQue_6().click();
                break;
            case 7:
                covidDeclarationForm.getYesBtnCovidQue_7().click();
                break;
            case 8:
                covidDeclarationForm.getYesBtnCovidQue_8().click();
                break;
            case 9:
                covidDeclarationForm.getYesBtnCovidQue_9().click();
                break;
        }
    }

    public void noOption(int count) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getNoBtnCovidQue_2());
        switch (count) {
            case 3:
                covidDeclarationForm.getNoBtnCovidQue_3().click();
                break;
            case 2:
                covidDeclarationForm.getNoBtnCovidQue_2().click();
                break;
            case 4:
                covidDeclarationForm.getNoBtnCovidQue_4().click();
                break;
            case 5:
                covidDeclarationForm.getNoBtnCovidQue_5().click();
                break;
            case 6:
                covidDeclarationForm.getNoBtnCovidQue_6().click();
                break;
            case 7:
                covidDeclarationForm.getNoBtnCovidQue_7().click();
                break;
            case 8:
                covidDeclarationForm.getNoBtnCovidQue_8().click();
                break;
            case 9:
                covidDeclarationForm.getNoBtnCovidQue_9().click();
                break;
        }
    }

    public static void noOptionSelected(int count) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getNoBtnCovidQue_2());
        switch (count) {
            case 2:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_2().getAttribute("class").contains("active"));
                break;
            case 3:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_3().getAttribute("class").contains("active"));
                break;
            case 4:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_4().getAttribute("class").contains("active"));
                break;
            case 5:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_5().getAttribute("class").contains("active"));
                break;
            case 6:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_6().getAttribute("class").contains("active"));
                break;
            case 7:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_7().getAttribute("class").contains("active"));
                break;
            case 8:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_8().getAttribute("class").contains("active"));
                break;
            case 9:
                Assert.assertTrue(covidDeclarationForm.getNoBtnCovidQue_9().getAttribute("class").contains("active"));
                break;
        }
    }

    public void errorMsgDisplayed() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getErrorMsg());
        Assert.assertTrue(checkedWebElementDisplayed(covidDeclarationForm.getErrorMsg()));
    }

    public void selectFirstQuestion(String symptoms) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getHighFever());
        switch (symptoms) {
            case "High Fever":
                BaseClass.executeScript(covidDeclarationForm.getHighFever());
                break;
            case "Difficulty in Breathing":
                BaseClass.executeScript(covidDeclarationForm.getDifficultyBreathing());
                break;
            case "Cough / Sore Throat":
                BaseClass.executeScript(covidDeclarationForm.getCoughSoreThroat());
                break;
            case "Sneezing / Running Nose":
                BaseClass.executeScript(covidDeclarationForm.getSneezingRunningNose());
                break;
            case "None of Them":
                BaseClass.executeScript(covidDeclarationForm.getNoneOfThem());
                break;
        }
    }

    public static void selectedFirstQuestion(String symptoms) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getHighFever());
        switch (symptoms) {
            case "High Fever":
                Assert.assertTrue(covidDeclarationForm.getHighFever().getAttribute("class").contains("active"));
                break;
            case "Difficulty in Breathing":
                Assert.assertTrue(covidDeclarationForm.getDifficultyBreathing().getAttribute("class").contains("active"));
                break;
            case "Cough / Sore Throat":
                Assert.assertTrue(covidDeclarationForm.getCoughSoreThroat().getAttribute("class").contains("active"));
                break;
            case "Sneezing / Running Nose":
                Assert.assertTrue(covidDeclarationForm.getSneezingRunningNose().getAttribute("class").contains("active"));
                break;
            case "None of Them":
                Assert.assertTrue(covidDeclarationForm.getNoneOfThem().getAttribute("class").contains("active"));
                break;
        }
    }

    public void greenFlag() {
        Assert.assertTrue(covidDeclarationForm.getLowProbability().isSelected());
    }

    public static void patientTemperature() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_10());
        String temperature = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidDeclarationForm.getTextFieldsCovidQue_10());
        Assert.assertTrue(temperature.isEmpty());
    }

    public static void patientOximeter() {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_11());
        String oximeter = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidDeclarationForm.getTextFieldsCovidQue_11());
        Assert.assertTrue(oximeter.isEmpty());
    }

    public static void setPatientTemperature(String temperature) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_10());
        covidDeclarationForm.getTextFieldsCovidQue_10().clear();
        covidDeclarationForm.getTextFieldsCovidQue_10().sendKeys(temperature);
    }

    public static void setPatientOximeter(String oximeter) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_11());
        covidDeclarationForm.getTextFieldsCovidQue_11().clear();
        covidDeclarationForm.getTextFieldsCovidQue_11().sendKeys(oximeter);
    }

    public static void checkPatientTemperature(String temp) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_10());
        String temperature = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidDeclarationForm.getTextFieldsCovidQue_10());
        Assert.assertEquals(temperature, temp);
    }

    public static void checkPatientOximeter(String oximeter) {
        BaseClass.waitForElementToBeClickable(covidDeclarationForm.getTextFieldsCovidQue_11());
        String ximeterLevel = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", covidDeclarationForm.getTextFieldsCovidQue_11());
        Assert.assertEquals(ximeterLevel, oximeter);
    }

    private boolean checkedWebElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }
}
