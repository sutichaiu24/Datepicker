import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('www.calculatestuff.com/miscellaneous/age-calculator')

WebUI.click(findTestObject('txt_DateOfBirth'))

WebUI.delay(2)

CustomKeywords.'framework.component.handleDatepicker'(findTestObject('datePicker'), DobDate, DobMonth, DobYear)

WebUI.delay(2)

WebUI.click(findTestObject('txt_AgeatDate'))

CustomKeywords.'framework.component.handleDatepicker'(findTestObject('datePicker'), AaDDate, AaDMonth, AaDYear)

WebUI.click(findTestObject('btn_submit'))

WebUI.delay(4)

WebUI.verifyElementText(findTestObject('txt_Age'), ExpectAge)

WebUI.verifyElementText(findTestObject('txt_AgeInMonths'), ExpectMonth)

WebUI.verifyElementText(findTestObject('txt_AgeinWeeks'), ExpectWeek)

WebUI.verifyElementText(findTestObject('txt_AgeInDays'), ExpectDay)

WebUI.closeBrowser()

