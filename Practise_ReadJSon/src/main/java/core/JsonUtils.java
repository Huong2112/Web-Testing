package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class JsonUtils {

    public static String[][] convertToTable(String pathName){
        ObjectMapper mapper = new ObjectMapper();
        String[][] table = null;
        try {
            List<Map<String, Object>> objects = mapper.readValue(new File(pathName),
                    mapper.getTypeFactory().constructCollectionType(List.class, Map.class));

            List<String> keys = new ArrayList<>();

            keys.addAll(objects.get(0).keySet());
            String[] columnNames = keys.toArray(new String[0]);
            table = new String[objects.size() ][columnNames.length];

            for (int i = 0; i < objects.size(); i++) {
                Map<String, Object> map = objects.get(i);
                for (int j = 0; j < columnNames.length; j++) {
                    table[i][j] = map.getOrDefault(columnNames[j], "").toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }

}
