package tests;
//import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (app.user().isLogOutPresent()){
            app.user().logout();
            //logger.info("Test needs logout");

        }
    }

   //@Test
  // public void loginSuccess() {
//      //open Login form
//      WebElement loginItem = wd.findElement(By.xpath("//*[text()=' Log in ']"));
//      loginItem.click();
//
//      //fill email
//      WebElement emailInput = wd.findElement(By.cssSelector("#email"));
//      emailInput.click();
//      emailInput.clear();
//      emailInput.sendKeys("tanya1702@gmail.com");
//
//      //fill password
//      WebElement passwordInput = wd.findElement(By.cssSelector("#password"));
//      passwordInput.click();
//      passwordInput.clear();
//      passwordInput.sendKeys("Tanya1702$");
//
//      //click button Login
//      wd.findElement(By.cssSelector("button[type='submit']")).click();
//
//      //Assert
//      Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Delete account']")).size() > 0);
//
   @Test
       public void loginSuccess() {
//       logger.info("Start test LoginSuccess");
//       logger.info("The test starts with data [noa@gmail.com] & [Nnoa12345$]" );
//
//       app.user().openLoginForm();
//       logger.info("opened form");
//       app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
//       logger.info("fill form");
//       app.user().submit();
//       app.user().pause(1000);
//       Assert.assertEquals(app.user().checkMessage(),"Logged in success");
//       logger.info("Test passed");

       app.user().openLoginForm();
       app.user().fillLoginForm("tanya1702@gmail.com","Tanya1702$");
       app.user().submit();
       app.user().pause(1000);
       Assert.assertEquals(app.user().checkMessage(),"Logged in success");

   }
    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("tanya1702@gmail.com").withPassword("Tanya1702$");

        app.user().openLoginForm();
        app.user().fillLoginForm(user);
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
    }
//    @Test (dataProvider = "dataLoginCSV",dataProviderClass = MyDataProvider.class)
//    public void loginSuccessModelCSV(User user) {
//        logger.info("Test start with user -->" + user.toString());
//
//        app.user().openLoginForm();
//        app.user().fillLoginForm(user);
//        app.user().submit();
//        app.user().pause(1000);
//        Assert.assertEquals(app.user().checkMessage(), "Logged in success");
//    }
        @Test//(dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
   public void loginSuccessNew(String email,String password) {
       app.user().openLoginForm();
       app.user().fillLoginForm(email,password);
       app.user().submit();
       app.user().pause(1000);
       Assert.assertEquals(app.user().checkMessage(),"Logged in success");

   }
    @AfterMethod
    public void postCondition(){
     app.user().submitOkButton();
    }
  }
