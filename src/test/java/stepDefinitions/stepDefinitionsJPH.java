package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

    @Then("Kullanici donen response'un content type degerinin {string} oldugunu dogrular")
    public void kullanici_donen_response_un_content_type_degerinin_oldugunu_dogrular(String expContentType) {
        Assertions.assertEquals(expContentType,response.getContentType());
    }

    @Then("Kullanici donen response degerini JsonPath olarak kaydeder")
    public void kullanici_donen_response_degerini_json_path_olarak_kaydeder() {
        resJp = response.jsonPath();
    }

    @Then("Kullanici donen response icindeki {string} degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_response_icindeki_degerinin_oldugunu_kontrol_eder(String expKey, String expValue) {
        assertEquals(expValue,resJp.getString(expKey));
    }

    @Then("Kullanici PUT request yapmak icin {string},{string},{int} {int} degerleri ile reqBody hazirlar")
    public void kullanici_put_request_yapmak_icin_degerleri_ile_req_body_hazirlar(String title, String body, Integer userId , Integer id) {
        reqBody = new JSONObject();
        reqBody.put("title",title);
        reqBody.put("body",body);
        reqBody.put("userId",userId);
        reqBody.put("id",id);

    }

    @Then("Kullanici PUT request yaparak response degerini kaydeder")
    public void kullanici_put_request_yaparak_response_degerini_kaydeder() {
        response = RestAssured.given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
    }
}
