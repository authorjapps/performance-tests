package org.jsmart.zerocode.samplesjunit5.loadjupiter.simpleload;

import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.domain.TestMappings;
import org.jsmart.zerocode.jupiter.extension.ZeroCodeParallelExtension;
import org.jsmart.zerocode.samplesjunit5.jupiter.JUnit5Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ZeroCodeParallelExtension.class})
public class JUnit5LoadTest {

    @Test
    @DisplayName("Test parallel load for X and Y scenarios")
    @LoadWith("load_generation.properties")
    @TestMappings({
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testX"),
            @TestMapping(testClass = JUnit5Test.class, testMethod = "testY")
    })
    public void testLoad() {
        // This space remains empty
    }

}