package sk.it;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    private static final String URL = "http://itsovy.sk:5000/data";

    public static void main(String[] args) {
        JSONObject json = null;
        try {
            json = new JSONObject(IOUtils.toString(new URL(URL), StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONArray array = new JSONArray();
        if (json != null) {
            array = json.getJSONArray("world_x");
        }

        JSONObject object;
        City city;
        ArrayList<City> cities = new ArrayList<>();
        for (int i=0; i<array.length(); i++) {
            object = array.getJSONObject(i);
            city = new City(object.getInt("pop"), object.getString("code"), object.getString("district"), object.getString("name"));
            cities.add(city);
        }

        System.out.println("\n=====>>> PREDICATE USING CLASS <<<=====\n");
        FromNetherlands<City> fn = new FromNetherlands<>();
        cities.stream().filter(fn).forEach(System.out::println);

        System.out.println("\n=====>>> PREDICATE USING LAMBDA EXPRESSION <<<=====\n");
        Predicate<City> fnLbd = cityLbd -> cityLbd.getPop() > 100000;
        cities.stream().filter(fnLbd).forEach(System.out::println);
    }
}