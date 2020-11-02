package Testway.test.Testway.test.cucumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunction {
	
	// Use webdriver methods
		webdriverFuction wdfunction = new webdriverFuction();
	// Read Excel file
		 public XSSFSheet ReadExcelFile(String strExcelFilePath)
		 {
			 
			 File file =null;
			 XSSFWorkbook workbook = null;
			 try
			 {
				 file = new File(strExcelFilePath);
			 
			 //
				 FileInputStream fis = null;
			 
					 try {
						 fis = new FileInputStream(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					
					try {
						workbook = new XSSFWorkbook(fis);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
			 catch(Exception e)
			 {
				System.out.println("Problem in reading the global declaration file");
				globalDeclaration.errorOccured=true;
			 }
			
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			return sheet;
		 } // public XSSFSheet ReadExcelFile(String strExcelFilePath)
		 
		 //------------------------------------------------------------------
		 
		// method to click clickCookieOKButton
		 public void clickCookieOKButton(WebDriver driver)
		 {
			 
			 try
			 {
				List<WebElement> allbutton = driver.findElements(By.tagName("button"));
				
				for(WebElement btn:allbutton)
				{
					String strbtnText = btn.getText();
					if(strbtnText.equals("OK"))
					{
						btn.click();
						break;
					}
				}
				 
			 }
			 catch(Exception e)
			 {
				 System.out.println("");
			 }
		 }//public void clickCookieOKButton()
		 //------------------------------------------------------------------
		 
		 public Boolean pageVerification(String actualPageTitle, String expectedPageTitle)
		 {
			 Boolean pageVerificationSuccessful = false;
		 
			 try
			 {
			 			 
				 if(actualPageTitle.contains(expectedPageTitle))
				 {
					 pageVerificationSuccessful = true;
				 }
				 else
				 {
					 pageVerificationSuccessful = false;
				 }
			 }
			 catch(Exception e)
			 {
				 pageVerificationSuccessful = false;
			 }
			 return pageVerificationSuccessful;
		 }
		 //-------------------------------------------------------------------------------
		 public void ErrorOccuredStatement()
			{
				System.out.println(" Test case execution is not completed successfully");
				wdfunction.releaseResources();
				System.exit(1);
			}


}//class

