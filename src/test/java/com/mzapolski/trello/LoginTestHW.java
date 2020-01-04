package com.mzapolski.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  if(isAvatarPresentOnHeader()){
    logout();
  }
}

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("tests.mzapolski@gmail.com", "QAtesting");
    pause(2000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }
  @Test
  public void testLogInWithAtlassianAcc2() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("tests.mzapolski@gmail.com", "QAtesting");
    pause(2000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }

 // @Test(enabled = false)
  //public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
    //clickLoginLink();
    //fillLoginFormAtlassianAcc("mariazapolski", "123");
    //pause(2000);
    //Assert.assertTrue(isErrorPresent());
    //Assert.assertTrue
      //      (!isAvatarPresentOnHeader());
  //}

  //@Test(enabled = false)
  //public void testLogInOldAcc() throws InterruptedException {
    //clickLoginLink();
    //fillLoginFormOldAcc("tests.mzapolski@gmail.com", "123");
    //confirmLogin();
    //Assert.assertTrue
      //      (isAvatarPresentOnHeader());
  //}


}
