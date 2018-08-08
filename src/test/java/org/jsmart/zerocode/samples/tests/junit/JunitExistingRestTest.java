package org.jsmart.zerocode.samples.tests.junit;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hamcrest.CoreMatchers;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(ZeroCodeUnitRunner.class)
public class JunitExistingRestTest {

    @Test
    public void testGitHubGetApi() throws IOException, InterruptedException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.github.com//users/octocat");

        // - - - - - - - - - - - - - - - - - - - - - - - - -
        // Add known delay to reflect "responseDelay" value
        // in the CSV report at least more than this number.
        // - - - - - - - - - - - - - - - - - - - - - - - - -
        Thread.sleep(1000);

        HttpResponse response = httpClient.execute(request);
        final String responseBodyActual = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
        System.out.println("### response: \n" + responseBodyActual);

        assertThat(response.getStatusLine().getStatusCode(), CoreMatchers.is(200));
        assertThat(responseBodyActual, CoreMatchers.containsString("\"login\":\"octocat\""));

    }
}
