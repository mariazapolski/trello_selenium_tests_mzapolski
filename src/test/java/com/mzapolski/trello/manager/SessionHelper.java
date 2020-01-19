package com.mzapolski.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    HeaderHelper header = new HeaderHelper(wd);
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
      type(By.id("user"), user);
      pause(5000);
      click(By.id("login"));
      click(By.id("login"));
      Thread.sleep(5000);
      type(By.cssSelector("input[id=password]"), pwd);
      click(By.id("login"));
    }

    public void confirmLogin() {
          click(By.id("login"));
    }

    public void fillLoginFormOldAcc(String userName, String password) {
      type(By.id("user"), userName);
      type(By.id("password"), password);
    }

    public void clickLoginLink(){

      click(By.cssSelector("[href='/login']"));
    }

    public void loginWhithBothAccs() throws InterruptedException {

      type(By.id("user"), "tests.mzapolski@gmail.com");
      Thread.sleep(10000);
      if(wd.findElement(By.id("password")).isDisplayed()){
        type(By.id("password"), "QAtesting");
      }
      click(By.id("login"));

      if (isElementPresent(By.id("login-submit"))){
        click(By.id("login"));

        type(By.id("password"), "QAtesting");
        click(By.id("login"));
      }
    }
    public void clickLogoutButton() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public boolean isAvatarPresentOnHeader() {
      return isElementPresent
              (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void logout() {
      header.clickOnAvatar();
      clickLogoutButton();
    }

    public void loginAtlassianAcc() throws InterruptedException {
      clickLoginLink();
      fillLoginFormAtlassianAcc("tests.mzapolski@gmail.com", "QAtesting");
      pause(20000);

    }
}
