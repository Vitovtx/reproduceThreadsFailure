package com.epam.testfailure.base;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.epam.testfailure.base.annotation.QAComponent;


@QAComponent("webDriver")
public class BaseWebDriver
{
	private RemoteWebDriver remoteDriver;
	private EventFiringWebDriver wrappedDriver;

	{
		Runtime.getRuntime().addShutdownHook(new Thread(() ->
				wrappedDriver.quit()));
	}

	@PostConstruct
	public void init() throws Exception
	{
		Class<?> retrievedClass = Class.forName("org.openqa.selenium.chrome.ChromeDriver");
		if (retrievedClass.getSuperclass().equals(RemoteWebDriver.class))
		{
			BrowserCapability browserCapability = new BrowserCapability.BrowserCapabilityBuilder("org.openqa.selenium.chrome.ChromeDriver")
					.setDefaultCapabilities()
					.build();
			remoteDriver = (RemoteWebDriver) retrievedClass.getDeclaredConstructor(Capabilities.class)
					.newInstance(browserCapability);
			wrappedDriver = new EventFiringWebDriver(remoteDriver);
			wrappedDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			wrappedDriver.manage().window().maximize();
		}
		else
		{
			throw new IllegalArgumentException("driverType must extends RemoteWebDriver");
		}
	}

	public void goToURL(String url)
	{
		wrappedDriver.navigate().to(url);
	}
}
