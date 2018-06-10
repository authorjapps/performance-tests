package org.jsmart.zerocode.samples.load.samplejunit;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeMultiLoadRunner;
import org.jsmart.zerocode.samples.tests.get.GetScreeningServiceTest;
import org.jsmart.zerocode.samples.tests.post.PostCorpLoanServiceTest;
import org.jsmart.zerocode.samples.tests.put.PutCorpLoanServiceTest;
import org.junit.runner.RunWith;

/**
 * Each test mapping here is equivalent to one user, that means there are 3 concurrent users below
 * invoking their respective user operations as:
 *         User-1)POST,GET
 *         User-2)PUT,GET
 *         User-3)GET
 * Note-
 * All 3 users are running in parallel which resembles the production like scenario where each user
 * doing different jobs.
 *
 * You can keep feeding/adding as many tests by using @TestMapping(TestClassName.class, "testMethodName")
 *
 * Please set "number.of.threads" >= "number of test mappings(= 3 here in this example)" giving chance for
 * each user scenario to get executed at least once. It's not illegal to set less.
 *
 * If you set more(e.g. number.of.threads=6 or 9, 10 in this case), then the user scenarios will get executed
 * more and more times in parallel until all the threads are used up.
 *
 */
@LoadWith("load_generation.properties")
@TestMapping(testClass = PostCorpLoanServiceTest.class, testMethod = "testPostNewLoan_crudOperations")
@TestMapping(testClass = PutCorpLoanServiceTest.class, testMethod = "testPutAmendExistingLoan")
@TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal")
@RunWith(ZeroCodeMultiLoadRunner.class)
public class JunitParallelMultiScenarioTest {

}
