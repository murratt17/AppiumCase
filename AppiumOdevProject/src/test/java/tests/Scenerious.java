package tests;


import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Scenerious extends BaseClass {
	
	@Test
	//clicks the chrome image and test "say hello" demo 
	public void test1() throws InterruptedException, IOException
	{
		
		
		System.out.println("----- Test1 Started -----");
		
		//retrives datas from excel to write in "enter  your name here" textbox 
		XSSFRow row2= excelReaderAccordingToRow(0);	
		XSSFCell cell1 = row2.getCell(1);
		XSSFCell cell2 = row2.getCell(2);
	    String name= cell1.getStringCellValue() + "  " +  cell2.getStringCellValue();



		MobileElement chromeButton = (MobileElement) ad.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
		chromeButton.click();

		Thread.sleep(2000);
		ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Say Hello Demo\"]/android.view.View[2]/android.widget.EditText")).clear();
		ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Say Hello Demo\"]/android.view.View[2]/android.widget.EditText")).sendKeys(name);
		ad.findElement(By.xpath("//android.widget.Spinner[@content-desc=\"Volvo\"]\r\n")).click(); //  clicks volvo and changes it to Mercedes
		Thread.sleep(2000);

		ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]\r\n"
				+ "")).click();

		Thread.sleep(2000);

		ad.findElement(MobileBy.AccessibilityId("Send me your name!")).click();

		Thread.sleep(2000);

		//if  this is my saying hello pages is displayed , test passes
		boolean result = ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Hello: MURAT GUVEN\"]/android.view.View[4]\r\n")).isDisplayed();
		Assert.assertTrue(result);
		System.out.println("----- Test1 Passed -----.");

	}

	@Test
	//test User Register part
	public void test2() throws InterruptedException, IOException

	{
		System.out.println("----- Test2 Started -----");
		
		//retrives datas from excel to write in "enter  your name here" textbox 
		XSSFRow row2= excelReaderAccordingToRow(1);	
		XSSFCell cell1 = row2.getCell(1);
		XSSFCell cell2 = row2.getCell(2);
		XSSFCell cell3 = row2.getCell(3);
		XSSFCell cell4 = row2.getCell(4);


		ad.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();

		Thread.sleep(2000);
		ad.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(cell1.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(cell2.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys(cell3.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
		ad.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys(cell4.getStringCellValue());
	
		scrollAndClick("Ruby");
		Thread.sleep(2000);
		
		ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]")).click();

	
		Thread.sleep(2000);

		ad.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
		
		Thread.sleep(2000);
		ad.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
		Thread.sleep(2000);
		
		boolean result = ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
		Assert.assertTrue(result);

		System.out.println("----- Test2 Passed -----");
		
	}
	
	@Test
	public void test4() throws InterruptedException, IOException

	{
		System.out.println("----- Test4 Started -----");
		
		

		ad.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		Thread.sleep(1000);
		ad.findElement(By.id("io.selendroid.testapp:id/spinner_webdriver_test_data")).click();

		Thread.sleep(1000);

		
		ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[10]").click();
		Thread.sleep(1000);

		ad.findElementByXPath("//android.view.View[@content-desc=\"I'm a normal link\"]").click();
		
		Thread.sleep(1000);

		boolean result = ad.findElement(By.xpath("//android.view.View[@content-desc=\"XHTML Might Be The Future\"]")).isDisplayed();

		Assert.assertTrue(result);


		
		
		System.out.println("----- Test4 Finished -----");

	}

	@Test
	//tests the "press to throw unhandled exception part
	public void test3() throws IOException, InterruptedException

	{
		System.out.println("----- Test3 Started -----");

		XSSFRow row3= excelReaderAccordingToRow(2);	
		XSSFCell cell1 = row3.getCell(1);
		XSSFCell cell2 = row3.getCell(2);
		XSSFCell cell3= row3.getCell(3);
		XSSFCell cell4= row3.getCell(4);


		//retrieves the datas from excel which is under test/resources
	    String text = cell1.getStringCellValue() + "  " +  
	                  cell2.getStringCellValue() + "  " + 
	    		      cell3.getStringCellValue() + "  " + 
	                  cell4.getStringCellValue();

	    boolean condition = false;
	    try
	    {
	    	ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText[2]")).sendKeys(text);
	    	
	    }
	    catch(Exception e)
	    {
	    	condition = true;
	    }
	    Assert.assertTrue(condition, "Must throw exception and stop the appliacation");
	    System.out.println("----- Test3 Passed -----");

	}

	// scrolls until element is visible
	public void scrollAndClick(String visibleText)
	{
	     ad.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	     
	}
	   
}


