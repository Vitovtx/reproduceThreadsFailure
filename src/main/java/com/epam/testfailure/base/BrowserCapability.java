package com.epam.testfailure.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapability extends DesiredCapabilities
{

	public BrowserCapability(BrowserCapabilityBuilder builder)
	{
		super();
		super.merge(builder.desiredCapabilities);
	}

	public static class BrowserCapabilityBuilder
	{
		private DesiredCapabilities desiredCapabilities;
		private final String driverType;

		public BrowserCapabilityBuilder(String driverType)
		{
			this.driverType = driverType.split("\\.")[3].toUpperCase();
		}

		public BrowserCapabilityBuilder setDefaultCapabilities()
		{
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities
					.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			switch (driverType)
			{
				case "CHROME":
					desiredCapabilities = DesiredCapabilities.chrome();
					return this;
				default:
					throw new RuntimeException(
							"Could not find the DesiredCapabilities for driver type" + driverType);
			}
		}

		public BrowserCapabilityBuilder setDownloadingDocuments(String outputDirPath)
		{
			switch (driverType)
			{
				case "CHROME":
					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<>();
					HashMap<String, Object> plugin = new HashMap<>();
					plugin.put("enabled", false);
					plugin.put("name", "Chrome PDF Viewer");
					prefs.put("profile.default_content_settings.popups", 0);
					prefs.put("download.default_directory", outputDirPath);
					prefs.put("plugins.plugins_list", Collections.singletonList(plugin));
					options.addArguments("--disable-popup-blocking");
					options.addArguments("--disable-extensions");
					options.addArguments("--test-type");
					options.addArguments("start-maximized");
					options.setExperimentalOption("prefs", prefs);
					desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
					return this;
				default:
					throw new RuntimeException(
							"The document downloading functionality isn't implemented for " + driverType);
			}
		}

		public BrowserCapability build()
		{
			return new BrowserCapability(this);
		}
	}

}
