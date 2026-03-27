package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONManager {
    public static void saveJSONData(String firstName, String lastName, String email, String password, String phoneNumber, String address) throws IOException, ParseException {
        String fileUrl="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(fileUrl));

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",firstName);
        jsonObject.put("lastName",lastName);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        jsonObject.put("phoneNumber",phoneNumber);
        jsonObject.put("address",address);

        jsonArray.add(jsonObject);

        FileWriter fileWriter=new FileWriter(fileUrl);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

    }
}
