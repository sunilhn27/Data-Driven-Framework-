package Listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Core.Core;

public class ListnerClass extends Core implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Test Got Finished");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Test Got Starts");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Got Failed");
		String testname = arg0.getName();

		System.out.println(testname);
		try {
			getscreenshot(testname);
			System.out.println("Successfully Captured Screen Shot");
			r.attachScreenshot(
					"F:\\Selenium The Grand Final\\DataDrivenFrameWork\\src\\main\\resources\\"+"screenshot" + testname + ".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Got Skipped");

	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Got Started");

	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Got Successed");

	}

}
