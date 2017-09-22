package com.epam.testfailure.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

public class MainCliRunner
{
	public static void main(String[] args) throws IOException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		RuntimeOptions runtimeOptions = new RuntimeOptions(generateCucumberRunParams());
		ResourceLoader resourceLoader = new MultiLoader(classLoader);
		ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
		Runtime runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
		runtime.run();
	}

	public static List<String> generateCucumberRunParams()
	{
		List<String> cucumberParams = new ArrayList<>();
		cucumberParams.add("--plugin");
		cucumberParams.add("com.epam.reportportal.cucumber.ScenarioReporter");
		cucumberParams.add("--glue");
		cucumberParams.add("com.epam.testfailure");
		cucumberParams.add("classpath:com/epam/testfailure/");
		return cucumberParams;
	}
}
