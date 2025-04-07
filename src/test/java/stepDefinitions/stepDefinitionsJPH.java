package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class stepDefinitionsJPH {

    String url = "";
    Response response;
    JsonPath resJp;
    JSONObject reqBody;

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String configBaseUrl) {
        url += ConfigReader.getProperty(configBaseUrl);
    }

    @Then("Kullanici path parametresi olarak {string} tanimlar")
    public void kullanici_path_parametresi_olarak_tanimlar(String pathParams) {
        url = url + "/" + pathParams;
    }

    @Then("Kullanici verilen EndPointe bir GET request yapar ve Header degerlerini kaydeder")
    public void kullanici_verilen_end_pointe_bir_get_request_yapar_ve_header_degerlerini_kaydeder() {
        response = given().when().get(url);
    }

    @Then("Kullanici donen response'un durum kodunun {int} oldugunu dogrular")
    public void kullanici_donen_response_un_durum_kodunun_oldugunu_dogrular(Integer expStatusCode) {
        Assertions.assertEquals(expStatusCode,response.getStatusCode());
    }
}
