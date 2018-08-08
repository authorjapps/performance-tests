package org.jsmart.zerocode.samples.load.samplemore;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeMultiLoadRunner;
import org.jsmart.zerocode.samples.tests.get.GetScreeningServiceTest;
import org.jsmart.zerocode.samples.tests.post.PostCorpLoanServiceTest;
import org.jsmart.zerocode.samples.tests.put.PutCorpLoanServiceTest;
import org.junit.runner.RunWith;

/**
 * What's new in ZeroCodeMultiLoadRunner.class ?
 * ---------------------------------------------
 * While running with "ZeroCodeMultiLoadRunner.class", each test mapping here is equivalent to one user,
 * that means there are 3 concurrent users below invoking their respective user operations as:
 *         User-1) POST,GET
 *         User-2) PUT,GET
 *         User-3) GET
 *         User-N) so on
 *
 * Note :
 * ------
 * All 3 users are running in parallel which resembles the production like scenario where each user
 * doing different jobs.
 *
 * You can keep feeding/adding as many tests by using @TestMapping(TestClassName.class, "testMethodName")
 *
 * Please make sure you set "number.of.threads" >= "number of test mappings(= 3 here)" giving chance for
 * each scenario to get executed at least once.
 *
 */
@LoadWith("load_generation.properties")
@TestMappings({
        @TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal"),
        @TestMapping(testClass = PostCorpLoanServiceTest.class, testMethod = "testPostNewLoan_crudOperations"),
        @TestMapping(testClass = PutCorpLoanServiceTest.class, testMethod = "testPutAmendExistingLoan")
})
@RunWith(ZeroCodeMultiLoadRunner.class)
public class LoadMultipleGroupAnnotationTest {

}
