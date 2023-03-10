package qa_automation_;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.undo.CannotRedoException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class qa_automation_testing {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rami\\Desktop\\chromedriver.win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://127.0.0.1:5500/index.html");

		List<WebElement> TheStudant = driver.findElements(By.tagName("option"));

		int TotalNumberStudant = TheStudant.size();
		System.out.println(TotalNumberStudant);

		for (int i = 0; i < TotalNumberStudant; i++) {

			if (i % 2 == 0) {
				TheStudant.get(i).click();
				System.out.println("a      " + TheStudant.get(i).getText());
				driver.findElement(By.id("remove")).click();
			} else {
				System.out.println("b      " + TheStudant.get(i).getText());

			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"selectNow\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"selectNow\"]")).click();
		Date cDate = new Date();
		String AcualDate = cDate.toString().replace(":", "-");
		System.out.println(AcualDate);
		TakesScreenshot src = ((TakesScreenshot) driver);
		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File(".//Screenshot/" + AcualDate + ".png");
		FileUtils.copyFile(SrcFile, Dest);

	}

}
