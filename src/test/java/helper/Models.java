package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "65b8db617b7d7264677ca0aa");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint){
        String fname = "Michio Maulamirza ";
        String lname = "Nugraha";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", fname);
        payload.put("lastName", lname);
        payload.put("email", email);
        setupHeaders();

        String finalEndpoint = endpoint + "/create";
        return request.body(payload.toString()).when().post(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id){
        setupHeaders();

        String fname = "Michio Maulamirza";
        String lname = "Nugraha yang baru";
        String email = generateRandomEmail();

        JSONObject payload = new JSONObject();
        payload.put("firstName", fname);
        payload.put("lastName", lname);
        payload.put("email", email);

        String finalEndpoint = endpoint + "/" + user_id;

        return request.body(payload.toString()).when().put(finalEndpoint);
    }

    public static Response deleteUser(String endpoint, String user_id){
        setupHeaders();

        String finalEndpoint = endpoint + "/" + user_id;
        System.out.println(finalEndpoint);
        return request.when().delete(finalEndpoint);
    }


}
