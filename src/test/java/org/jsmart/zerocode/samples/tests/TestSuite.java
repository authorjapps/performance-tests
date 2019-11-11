package org.jsmart.zerocode.samples.tests;

import org.jsmart.zerocode.samples.tests.get.GetScreeningServiceTest;
import org.jsmart.zerocode.samples.tests.post.PostCorpLoanServiceTest;
import org.jsmart.zerocode.samples.tests.put.PutCorpLoanServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses(
        {
                GetScreeningServiceTest.class,
                PostCorpLoanServiceTest.class,
                PutCorpLoanServiceTest.class
        }
)
@RunWith(Suite.class)
/* =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * Note:
 * This class is fed to the Maven SureFire plugin for parallel running of all tests for load generation.
 * In this kind of situation you don't need to use Zerocode. The
 *
 * 1) But if you use
 *    - @RunWith(ZeroCodeUnitRunner.class)
 *    on your Individual test classes(not the Suite class), then you get a nice CSV report at the
 *    'target' folder.
 *
 *    Then you can use this report to generate various throughput graphs/statistics etc for your
 *    project or business audience.
 *
 * 2) If you need to control your parallel run e.g. you want to fire 50 users in 50secs or
 *    100 users in 50 secs etc, then you need Zerocode runners which helps you to easily achieve this.
 *    - @RunWith(ZeroCodeLoadRunner.class)
 *    - @RunWith(ZeroCodeMultiLoadRunner.class)
 *
 *    Refer the examples in the 'src/test/java/org/jsmart/zerocode/samples/load' folder.
 * =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 */
public class TestSuite {

}
