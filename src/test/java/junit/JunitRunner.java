package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculadoraTest.class,ParametrosTest.class,AssertsTest.class})
public class JunitRunner {
}
