package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class RegistrationsTests {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        //browser+https
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");


    }}
