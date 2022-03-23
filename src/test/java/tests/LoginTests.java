package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

   @Test
   public void loginSuccess() {
      //open Login form
      WebElement loginItem = wd.findElement(By.xpath("//*[text()=' Log in ']"));
      loginItem.click();

      //fill email
      WebElement emailInput = wd.findElement(By.cssSelector("#email"));
      emailInput.click();
      emailInput.clear();
      emailInput.sendKeys("tanya1702@gmail.com");

      //fill password
      WebElement passwordInput = wd.findElement(By.cssSelector("#password"));
      passwordInput.click();
      passwordInput.clear();
      passwordInput.sendKeys("Tanya1702$");

      //click button Login
      wd.findElement(By.cssSelector("button[type='submit']")).click();

      //Assert
      Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Delete account']")).size() > 0);


   }

  @Test
   public void loginSuccessNew()  {
      //OPEN login form
      click(By.xpath("//*[text()=' Log in ']"));
      //fill email
      type(By.cssSelector("#email"), "tanya1702@gmail.com");
      //fill password
      type(By.cssSelector("#password"), "Tanya1702$");
      //click button login
      click(By.cssSelector("button[type='submit']"));

      Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Delete account']")));
   }

  }
