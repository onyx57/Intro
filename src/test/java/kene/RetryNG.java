package kene;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryNG implements IRetryAnalyzer {

    int count = 0;     // how many times we've retried
    int maxTry = 1;    // maximum retry count

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxTry) {
            count++;
            return true;  // re-run the test
        }
        return false;     // do not re-run
    }
}
