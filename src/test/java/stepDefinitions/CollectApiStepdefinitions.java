package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ConfigReader;

public class CollectApiStepdefinitions {

    String url = "";
    Response response;

    @Given("kullanici sorgu icin {string} adresine gider")
    public void kullanici_sorgu_icin_adresine_gider(String configBaseUrl) {
        url += ConfigReader.getProperty(configBaseUrl);
    }

    @Then("kullanici sorgu icin pathparametresi olarak {string} girer")
    public void kullanici_sorgu_icin_pathparametresi_olarak_girer(String pathParams) {
        url = url + "/" + pathParams;
    }

    @Then("kullanici query parametresi olark il degerine {string} ilce degerine {string} girer")
    public void kullanici_query_parametresi_olark_il_degerine_ilce_degerine_girer(String il, String ilce) {
        url = url + "?il=" + il + "&ilce=" + ilce;
    }

    @Then("kullanici gereki header degerleri ile bir GET request yapar")
    public void kullanici_gereki_header_degerleri_ile_bir_get_request_yapar() {
        response = RestAssured.given().header("authorization", ConfigReader.getProperty("CollectApiKey")).when().get(url);
    }

    @Then("kullanici donen response degerini yazdrir")
    public void kullanici_donen_response_degerini_yazdrir() {
        response.prettyPrint();
    }
}
