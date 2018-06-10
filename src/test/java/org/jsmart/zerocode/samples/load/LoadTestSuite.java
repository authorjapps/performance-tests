package org.jsmart.zerocode.samples.load;

import org.jsmart.zerocode.samples.load.parallelget.LoadGetTest;
import org.jsmart.zerocode.samples.load.parallelmulti.LoadMultipleGetPostPutTest;
import org.jsmart.zerocode.samples.load.parallelpost.LoadPostTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({

        LoadGetTest.class,
        LoadPostTest.class,
        LoadMultipleGetPostPutTest.class

})
@RunWith(Suite.class)
public class LoadTestSuite {

}
