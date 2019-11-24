import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
// Combine and run all test classes
@SuiteClasses({ StudentTest.class, ModuleTest.class, CourseProgrammeTest.class })
public class SuiteRunAllTests {
    //empty class
}
