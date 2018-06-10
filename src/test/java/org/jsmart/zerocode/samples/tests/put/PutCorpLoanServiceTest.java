package org.jsmart.zerocode.samples.tests.put;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.UseHttpClient;
import org.jsmart.zerocode.core.httpclient.ssl.SslTrustHttpClient;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("corploan_server_host.properties")
@UseHttpClient(SslTrustHttpClient.class)
@RunWith(ZeroCodeUnitRunner.class)
public class PutCorpLoanServiceTest {

    @Test
    @JsonTestCase("load_tests/put/amend_put_and_get_existing_loan.json")
    public void testPutAmendExistingLoan() throws Exception {

    }
}
