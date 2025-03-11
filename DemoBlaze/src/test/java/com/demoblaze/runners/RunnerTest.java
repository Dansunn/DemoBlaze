package com.demoblaze.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/01_Signup.feature",
                "src/test/resources/features/02_Login & Logout.feature",
                "src/test/resources/features/03_Product.feature",
                "src/test/resources/features/04_Contact.feature",
                "src/test/resources/features/05_NavigationPage.feature",
        },
        glue = {
                "com.demoblaze.hooks",
                "com.demoblaze.steps",
        },
        plugin = {
                "pretty", "html:target/cucumber-reporting/reports.html",
                "json:target/cucumber-reporting/reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        tags = ""
)

public class RunnerTest extends AbstractTestNGCucumberTests{

}
