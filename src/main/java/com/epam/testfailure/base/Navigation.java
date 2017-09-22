package com.epam.testfailure.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.testfailure.base.annotation.QAComponent;


@QAComponent("navigation")
public class Navigation
{
	@Autowired
	protected BaseWebDriver driver;

	public void goHome()
	{
		driver.goToURL("https://ya.ru/");
	}
}
