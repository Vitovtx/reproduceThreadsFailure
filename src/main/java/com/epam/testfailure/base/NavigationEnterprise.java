package com.epam.testfailure.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.annotation.QAComponent;

/**
 * Utility class which exposes some commonly performed navigation tasks.
 */
@QAComponent("navigationEnterprise")
public class NavigationEnterprise
{
	@Autowired
	protected BaseWebDriver driver;

	/**
	 * Redirects the browser back to the home page.
	 *
	 * @param urlKey - URL key in properties
	 */
	public void goHome()
	{
		driver.goToURL("https://ya.ru/");
	}
}
