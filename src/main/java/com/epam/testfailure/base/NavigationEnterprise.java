package com.epam.testfailure.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.annotation.QAComponent;


@QAComponent("navigationEnterprise")
public class NavigationEnterprise
{
	@Autowired
	protected BaseWebDriver driver;

	public void goHome()
	{
		driver.goToURL("https://ya.ru/");
	}
}
