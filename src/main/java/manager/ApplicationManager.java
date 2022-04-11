package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    CarHelper car;

    public void init(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        helperUser = new HelperUser(wd);
        car = new CarHelper(wd);

    }
    public void stop(){

        wd.quit();
    }

    public HelperUser user() {
        return helperUser;
    }
    public CarHelper car() {
        return car;
    }
}