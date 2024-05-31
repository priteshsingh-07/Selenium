package com.crm.listnersCode;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DWSListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("onTestSucess");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
	    System.out.println("onTestFailure");	
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("onTestFailedWithButWithisSucessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("onFinish");
	}
}
