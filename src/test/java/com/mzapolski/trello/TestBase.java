package com.mzapolski.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
  static WebDriver wd;

  @BeforeSuite
  public void setUp(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get("https://trello.com/");
      }

  public boolean isElementPresent(By locator){
    return wd.findElements(locator).size()>0;
  }

  @AfterSuite
  public void tearDown(){
    wd.quit();
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }

  public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
    type(By.id("user"), user);
    pause(1000);
    //click(By.id("login"));
    //click(By.id("login"));
    type(By.id("password"), pwd);
   click(By.id("login"));
  }

  public void confirmLogin() {
    click(By.id("login"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillLoginFormOldAcc(String userName, String password) {
    type(By.id("user"), userName);
    type(By.id("password"), password);
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void clickLoginLink(){

    click(By.cssSelector("[href='/login']"));
  }

  public void loginWhithBothAccs() throws InterruptedException {

    type(By.id("user"), "tests.mzapolski@gmail.com");
    Thread.sleep(2000);
    if(wd.findElement(By.id("password")).isDisplayed()){
      type(By.id("password"), "QAtesting");
    }
    click(By.id("login"));

    if (isElementPresent(By.id("login-submit"))){
      click(By.id("login-submit"));

      type(By.id("password"), "QAtesting");
      click(By.id("login-submit"));
    }
  }

  public boolean isAvatarPresentOnHeader() {
    return isElementPresent
            (By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public void logout() {
    clickOnAvatar();
    clickLogoutButton();
  }

  public void loginAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("tests.mzapolski@gmail.com", "QAtesting");
    pause(2000);

  }

  public void clickLogoutButton() {
    click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
  }

  public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public boolean isErrorPresent() {
    return isElementPresent(By.id("error"));
  }
}
