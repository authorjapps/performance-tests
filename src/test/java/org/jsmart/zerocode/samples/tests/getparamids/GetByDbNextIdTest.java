package org.jsmart.zerocode.samples.tests.getparamids;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("screening_service_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class GetByDbNextIdTest {

    @Test
    @JsonTestCase("load_tests/get_with_database_ids/get_details_by_next_db_custid.json")
    public void testGetDetailsByNextDbId() throws Exception {

    }

}
