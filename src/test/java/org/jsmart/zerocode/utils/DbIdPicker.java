package org.jsmart.zerocode.utils;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Arrays.asList;

public class DbIdPicker {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbIdPicker.class);

    private static boolean alreadyFetched;
    private static int nextId = 0;
    private static List<String> ids = new ArrayList<>();

    public String nextId(){
        if(!alreadyFetched){

            fetchDbIds();

            alreadyFetched = true;
        }

        if(nextId >= ids.size()){
            nextId = 0;
        }

        return ids.get(nextId++);
    }

    private void fetchDbIds() {
        String fetchIdsSql = "select ID from CUSTOMER where SALARY < 60000";
        LOGGER.info("Fetching all IDs from DB" + fetchIdsSql);

        // -------------------------------------------------
        // Connect to your DB via JDBC and execute your SQL
        // here and assign the IDs into a list e.g. "ids".
        //
        // Assume the below IDs (CUST-100, ... ) are from DB
        // -------------------------------------------------

        ids = asList( "SINGAHV3033", "SINGAHV3034");
    }
}
