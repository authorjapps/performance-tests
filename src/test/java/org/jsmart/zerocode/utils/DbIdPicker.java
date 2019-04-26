package org.jsmart.zerocode.utils;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbIdPicker {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbIdPicker.class);

    private static int nextId = 0;
    public static List<String> ids = new ArrayList<>();

    public String nextId() {
        if (ids.size() == 0) {
            return null;
        }

        if (nextId >= ids.size()) {
            nextId = 0;
        }

        return ids.get(nextId++);
    }
}
