package fSathyaExtentReportListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//Code to ReRun the Failed Test Case at Run Time Using IAnnotationTransformer TestNG Listener
public class SathyaRuntimeLogic implements IAnnotationTransformer 
{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotation.setRetryAnalyzer(SathyaRetryAnalyzer.class); //Overridden Method
	}

}
