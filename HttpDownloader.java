package com.download;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HttpDownloader {
 
    public static void main(String[] args) throws Exception{
    	
    	System.setProperty("webdriver.ie.driver", "G:\\selenium\\drivers\\IEDriverServer.exe");
    	WebDriver driver = new InternetExplorerDriver();
    	driver.get("https://subscene.com/subtitles/game-of-thrones-sixth-season/english/1321235");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	Thread.sleep(25000);
    	new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='download']/a")));
    	WebElement link = driver.findElement(By.xpath("//*[@class='download']/a"));
    	
    	System.out.println("Link is : " + link.getAttribute("href"));
        String fileURL = link.getAttribute("href");
        String saveDir = "G:\\selenium\\testDownload";
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
