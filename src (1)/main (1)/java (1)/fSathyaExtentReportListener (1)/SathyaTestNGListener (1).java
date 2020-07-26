package fSathyaExtentReportListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import aSathyaBasement.Basement;

//Code to Implement ITestListener

public class SathyaTestNGListener extends Basement implements ITestListener
{
	
	//Overridden Method
	 public void onFinish(ITestContext arg0) 
	 { 	// After everything
		  
		  System.out.println("SATHYA MAVEN AUTOMATION COMPLETED...!!!");
	  }
	  
	//Overridden Method
	 public void onStart(ITestContext arg0) 
	 { 
		  // Before everything
	  
		  System.out.println("SATHYA MAVEN AUTOMATION BEGINS...!!!");
	  }

	//Overridden Method
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("SATHYA MAVEN TESTCASE IS SUCCESS " +result.getName()+ " ...!!!" );
	}
	
	//Overridden Method
	public void onTestStart(ITestResult result)
	{
		System.out.println("SATHYA MAVEN TESTCASE IS STARTED " + result.getName()+ " ...!!!");
	}
	
	//Overridden Method
	public void onTestFailure(ITestResult result)
	{
		System.out.println("SATHYA MAVEN TESTCASE IS FAILED " + result.getName()+ " ...!!!");
		failedTestCase(result.getMethod().getMethodName());
	}
	
	//Overridden Method
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("SATHYA MAVEN TESTCASE IS SKIPPED " +result.getName()+ " ...!!!");	
	}
	
}
