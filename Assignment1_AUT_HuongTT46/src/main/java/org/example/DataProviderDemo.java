package org.example;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class ColorObject {

    private String color;
    private String value;

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }
}

public class DataProviderDemo {
    @DataProvider(name = "Color")
    public static Object[][] credentials(){
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("D:\\AUT_Demo\\Assignment1_AUT_HuongTT46\\src\\main\\java\\org\\example\\data.json")) {
            List<ColorObject> colorObjects = gson.fromJson(reader, new com.google.gson.reflect.TypeToken<List<ColorObject>>() {}.getType());
            Object[][] testData = new Object[colorObjects.size()][2];
            for (int i = 0; i < colorObjects.size(); i++) {
                ColorObject colorObject = colorObjects.get(i);
                testData[i][0] = colorObject.getColor();
                testData[i][1] = colorObject.getValue();
            }
            return testData;
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[][]{};
        }
    }
    @Test(dataProvider = "Color")
    public void test(String color, String value){
        System.out.println(color + " : " + value);
    }
}
