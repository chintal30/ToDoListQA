package ambyint.ToDoList.TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/ambyint/ToDoList/features"},
        glue = {"ambyint.ToDoList.stepDefinitions"},
        tags = "@low",
        plugin={"html:reports/SparkActimePlugin.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class BaseTest extends AbstractTestNGCucumberTests {

}
