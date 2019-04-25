package org.jsmart.zerocode.samples.load.parallelparametized;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.jsmart.zerocode.samples.tests.getparamids.GetByDbNextIdTest;
import org.junit.runner.RunWith;

@LoadWith("load_generation.properties")
@TestMapping(testClass = GetByDbNextIdTest.class, testMethod = "testGetDetailsByNextDbId")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadDbParameterizedGetTest {

}