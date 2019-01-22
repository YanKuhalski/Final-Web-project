package com.epam.webapp.repository;

import java.util.Map;
import java.util.Set;

public class QueryHelper {

    public String makeAddQuery(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int mapSize = map.size();
        stringBuilder.append(" (");
        Set<String> keys = map.keySet();
        int number = 0;
        for (String key : keys) {
            stringBuilder.append(key);
            if (mapSize - 1 > number) {
                stringBuilder.append(",");
                number++;
            }
        }
        stringBuilder.append(") values (");
        for (int i = 0; i < mapSize; i++) {
            stringBuilder.append("?");
            if (mapSize - 1 > i) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(");");
        return stringBuilder.toString();
    }

    public String makeUpdateQuery(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int mapSize = map.size();
        Set<String> keys = map.keySet();
        int number = 0;
        for (String key : keys) {
            stringBuilder.append(key + "=?");
            if (mapSize - 1 > number) {
                stringBuilder.append(",");
                number++;
            }
        }
        stringBuilder.append(" where id = ?");
        return stringBuilder.toString();
    }
}
