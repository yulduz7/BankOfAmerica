package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {
    public static WebDriver driver;
    public static final String propertyPath="src/main/resources/configurations/configurations.properties";
    private static long implicitWait=Long.parseLong(ConfigReader.readProperty(propertyPath,"implicitWait"));
    private static String url= ConfigReader.readProperty(propertyPath,"url");

    public static void initializer(){
        String browser=ConfigReader.readProperty(propertyPath,"browser");
        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait,SECONDS);

        }
    }


