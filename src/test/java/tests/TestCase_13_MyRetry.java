package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class TestCase_13_MyRetry implements IRetryAnalyzer {
 
  private int retryCount = 0;           //Note: TestCase 13 and 14 are referenced to each other
  private static final int maxRetryCount = 3;
 
  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}