package testcase.basicclass.retry;


import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
//Method2:We need to use IAnnotationTransformer interface in the RetryListener(concreate class)
//And use the transform method with annotaion,testclass,testConstructor,testMethod arguments
//use that annotation variable and call the method setRetryAnalyzer (package_name.class_name.class)
//Here -->Package name is testcase.basicclass.retry
//Here --->Class name is RetryFailedTests.class -->Logic of retry is written in the class
//For run -->To create a testng.xml file and 
//After suite tag add the <Listeners></Listeners>
//add the tag <listener class-name="testcase.basicclass.retry.RetryListener"></listener>
//The Structure will be
//<listeners>
//<listener class-name="testcase.basicclass.retry.RetryListener"></listener>
//</listeners>
public class RetryListener implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation) {
		annotation.setRetryAnalyzer(testcase.basicclass.retry.RetryFailedTests.class);
	}
}
