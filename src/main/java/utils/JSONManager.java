package utils;

import models.UserModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONManager {
    public static void saveJSONData(UserModel userModel) throws IOException, ParseException {
        String fileUrl="./src/test/resources/users.json";
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader(fileUrl));

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",userModel.getFirstname());
        jsonObject.put("lastName",userModel.getLastname());
        jsonObject.put("email",userModel.getEmail());
        jsonObject.put("password",userModel.getPassword());
        jsonObject.put("phoneNumber",userModel.getPhonenumber());
        jsonObject.put("address",userModel.getAddress());

        jsonArray.add(jsonObject);

        FileWriter fileWriter=new FileWriter(fileUrl);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();

    }
}
