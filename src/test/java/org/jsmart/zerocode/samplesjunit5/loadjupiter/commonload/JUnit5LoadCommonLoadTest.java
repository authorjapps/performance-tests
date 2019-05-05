package org.jsmart.zerocode.samplesjunit5.loadjupiter.commonload;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.jupiter.extension.ParallelLoadExtension;
import org.jsmart.zerocode.samplesjunit5.jupiter.JUnit5MoreTest;
import org.jsmart.zerocode.samplesjunit5.jupiter.JUnit5Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * How the load is generated?
 * Ans:
 * testLoad_xy() - Runs all the tests annotated with '@TestMapping' in parallel - as per @LoadWith properties
 * testLoad_xyz() - Runs all the tests annotated with '@TestMapping' in parallel - as per @LoadWith properties
 *
 * Note:
 * Both cases use a common load properties i.e. "load_generation.properties" - Annotated on Class level
 *
 * testLoad_xy(), testLoad_xyz() - Runs in sequence.
 * That means it once the first load scenario finishes, the next one triggers.
 * This is usual behaviour of the Test-Suite run. This is setup as a Suite setup,
 * which means you don't need another Suite-Runner to
 */

@LoadWith("load_generation.properties")
@ExtendWith({ParallelLoadExtension.class})
public class JUnit5LoadCommonLoadTest {

    @Test
    @DisplayName("testing parallel load for X and Y scenarios")
    @TestMappings({
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testX"),
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testY")
    })
    public void testLoad_xy() {
        // This space remains empty
    }

    @Test
    @DisplayName("testing parallel load for X, Y and Z scenarios")
    @TestMappings({
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testX"),
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testY"),
            @TestMapping(testClass = JUnit5MoreTest.class, testMethod = "testZ")
    })
    public void testLoad_xyz() {
        // This space remains empty
    }

}