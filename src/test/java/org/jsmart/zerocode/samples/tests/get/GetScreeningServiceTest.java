package org.jsmart.zerocode.samples.tests.get;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("screening_service_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class GetScreeningServiceTest {

    @Test
    @JsonTestCase("load_tests/get/get_screening_details_by_custid.json")
    public void testGetScreeningLocalAndGlobal() throws Exception {

    }

}
