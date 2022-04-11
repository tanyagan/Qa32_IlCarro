package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationsTests extends  TestBase{

    @BeforeMethod
    public void preCondition(){

        if (app.user().isLogOutPresent()){
            app.user().logout();

        }
    }
    @Test
    public void registrationSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println();

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Tali","Gan","avgust_19"+index+"@gmail.com","Avgust19$");
       // app.user().checkPolicy();
        app.user().checkPolicyXy();
        app.user().submit();
        //app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");
        }
    @Test
    public void registrationSuccessNewModel(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withEmail("Tali")
                .withLastName("Gan")
                .withEmail("avgust_19"+index+"@gmail.com")
                .withPassword("Avgust19$");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        // app.user().checkPolicy();
        app.user().checkPolicyXy();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(),"You are logged in success");
    }

    @Test
    public void registrationWrongPasswordModel(){

       User user = new User()
                .withEmail("Tali")
                .withLastName("Gan")
                .withEmail("avgust_19@gmail.com")
                .withPassword("Av5445");

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        app.user().checkPolicy();
        app.user().submit();
        //error + button not active
        Assert.assertTrue(app.user().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.user().isErrorPasswordDisplayedFormat());
        Assert.assertFalse(app.user().isYallaButtonNoActive());
        Assert.assertTrue(app.user().isYallaButtonNotClickable());
    
    }
    @AfterMethod
    public void postCondition(){
        app.user().submitOkButton();
        }
   // WebDriver wd;

//   // @BeforeMethod
//   // public void init() {
//        //browser+https
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wd.navigate().to("https://ilcarro.xyz/");


    }
