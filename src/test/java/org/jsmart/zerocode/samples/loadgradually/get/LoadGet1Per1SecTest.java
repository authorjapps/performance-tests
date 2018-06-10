package org.jsmart.zerocode.samples.loadgradually.get;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.jsmart.zerocode.samples.tests.get.GetScreeningServiceTest;
import org.junit.runner.RunWith;

@LoadWith("load_generation_1per1sec.properties")
@TestMapping(testClass = GetScreeningServiceTest.class, testMethod = "testGetScreeningLocalAndGlobal")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadGet1Per1SecTest {

}