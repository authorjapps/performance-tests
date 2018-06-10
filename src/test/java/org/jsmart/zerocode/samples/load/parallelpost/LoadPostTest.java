package org.jsmart.zerocode.samples.load.parallelpost;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.jsmart.zerocode.samples.tests.post.PostCorpLoanServiceTest;
import org.junit.runner.RunWith;

@LoadWith("load_generation.properties")
@TestMapping(testClass = PostCorpLoanServiceTest.class, testMethod = "testPostNewLoan_crudOperations")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadPostTest {

}