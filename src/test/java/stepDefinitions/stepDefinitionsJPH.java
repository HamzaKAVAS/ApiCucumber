package stepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

public class stepDefinitionsJPH {

    String url = "";
    Response response;
    JsonPath resJp;
    JSONObject reqBody;

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String configBaseUrl) {
        url += ConfigReader.getProperty(configBaseUrl);
    }
}
