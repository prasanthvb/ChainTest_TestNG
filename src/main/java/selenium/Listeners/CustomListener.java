package selenium.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.chaintest.plugins.ChainTestListener;
import selenium.Base.BaseClass;
import selenium.Utils.TestUtil;

public class CustomListener extends BaseClass implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ChainTestListener.log("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ChainTestListener.embed(TestUtil.getscreenBase64(getDriver()), "image/png");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
