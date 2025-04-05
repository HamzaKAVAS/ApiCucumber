package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
}
