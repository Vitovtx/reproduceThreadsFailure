package com.epam.testfailure.base;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "com.epam.reportportal.cucumber.ScenarioReporter" },
		glue = { "com.epam.testfailure" },
		features = { "classpath:com/epam/testfailure/" }
)
public class MainJunitRunner
{
}