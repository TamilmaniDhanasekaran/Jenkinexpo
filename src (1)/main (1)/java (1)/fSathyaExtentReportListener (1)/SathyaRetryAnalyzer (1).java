package fSathyaExtentReportListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Code to ReRun the Failed Test Case Using IRetryAnalyzer TestNG Listener
public class SathyaRetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retrylimit = 2; //Failed Test Case will Run two Times 

	public boolean retry(ITestResult result)  //Overridden Method
	{
		if(counter < retrylimit)
		{
			counter++;
			return true;
		}
		
			return false;
	}

}
