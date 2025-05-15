package runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.*;
import org.testng.annotations.*;
import utilities.GWD;

import java.time.LocalDateTime;

@CucumberOptions(features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class ExtentReportRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public void writeExtendReport() {
        ExtentService.getInstance().setSystemInfo("--------------------", "--------------------");
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Browser", GWD.threadBrowserName.get());
        ExtentService.getInstance().setSystemInfo("Execution Date", LocalDateTime.now().toString());
        ExtentService.getInstance().setSystemInfo("User Name", "Bug Fathers");
        ExtentService.getInstance().setSystemInfo("Team Name", "Team#4");
        ExtentService.getInstance().setSystemInfo("Application Name", "Magento Project");
        ExtentService.getInstance().setSystemInfo("Test Tag", "Extent Report Runner");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
    }
}