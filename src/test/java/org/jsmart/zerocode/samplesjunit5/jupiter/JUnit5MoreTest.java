package org.jsmart.zerocode.samplesjunit5.jupiter;

import org.jsmart.zerocode.samplesjunit5.jupiter.extension.ExtensionA;
import org.jsmart.zerocode.samplesjunit5.jupiter.extension.ExtensionB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({ExtensionA.class, ExtensionB.class})
public class JUnit5MoreTest {

    @Test
    public void testZ() throws InterruptedException {
        Thread.sleep(1000);
        out.println("*JUnit5 ---> testZ()");
        assertTrue(2 == 2); //jupiter assertion
    }

}