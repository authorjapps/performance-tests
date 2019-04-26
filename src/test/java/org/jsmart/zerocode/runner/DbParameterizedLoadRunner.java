package org.jsmart.zerocode.runner;

import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.jsmart.zerocode.utils.DbIdPicker;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Arrays.asList;

/**
 * This runner loads the "ids" from the DB and then, fires the parallel tests
 * Issue : https://github.com/authorjapps/zerocode/issues/233
 *
 * Note-
 * This is only for suggestion.
 * But feel free to bring up your own flavour of this runner
 */
public class DbParameterizedLoadRunner extends ZeroCodeLoadRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbParameterizedLoadRunner.class);

    public DbParameterizedLoadRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
        fetchDbIds();
    }

    private void fetchDbIds() {
        String fetchIdsSql = "select ID from CUSTOMER where SALARY < 60000";
        LOGGER.info("\nFetching all IDs from the DB......................................\n\n" + fetchIdsSql);

        // -------------------------------------------------
        // Connect to your DB via JDBC and execute your SQL
        // here and assign the IDs into a list e.g. "ids".
        //
        // Assume the below IDs (CUST-100, ... ) are from DB
        // -------------------------------------------------

        DbIdPicker.ids = asList( "SINGAHV3033", "SINGAHV3034");
        LOGGER.info("\n......................................done.\n\n");
    }
}
