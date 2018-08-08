package org.jsmart.zerocode.samples.tests.junit;

import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ZeroCodeUnitRunner.class)
public class JunitExistingTest {
    static int a = 2;
    static int b = 3;

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 1st run passes, but subsequent run fails,  this is deliberate
    // to see the failures reflect in the CSV report
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Test
    public void testAddTwoNumbers_firstPassThenFail() {
        int sum = a + b;
        assertThat(sum, is(5));

        a++;
        b++;
    }
}
