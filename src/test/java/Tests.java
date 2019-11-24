import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Tests {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteRunAllTests.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()){
            System.out.println("Tests were successful");
        } else {
            System.out.println("Not all tests were successful");
        }
    }
}
