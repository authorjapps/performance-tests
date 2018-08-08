package org.jsmart.zerocode.samples.load.samplejunit;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.jsmart.zerocode.samples.tests.junit.JunitExistingRestTest;
import org.junit.runner.RunWith;

@LoadWith("load_generation.properties")
@TestMapping(testClass = JunitExistingRestTest.class, testMethod = "testGitHubGetApi")
@RunWith(ZeroCodeLoadRunner.class)
public class LoadExistingJUnitRestTest {

}