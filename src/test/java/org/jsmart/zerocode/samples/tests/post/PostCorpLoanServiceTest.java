package org.jsmart.zerocode.samples.tests.post;

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
public class PostCorpLoanServiceTest {


    @Test
    @JsonTestCase("load_tests/post/create_post_and_get_new_loan.json")
    public void testPostNewLoan_crudOperations() throws Exception {

    }

}
