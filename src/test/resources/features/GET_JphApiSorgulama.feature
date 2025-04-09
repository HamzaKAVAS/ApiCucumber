Feature: JPHApiSorgulama

    # https://jsonplaceholder.typicode.com/posts/44 endpointine
    # bir GET request gonderdigimizde donen response'un
    # status code'unun 200 olduğunu,
    # content type degerinin "application/json; charset=utf-8 " ve
    # "title" degerinin "optio dolor molestias sit" oldugunu test edin

  Scenario: JPHGETRequest

    Given Kullanici "JPHUrl" adresine gider
    Then Kullanici path parametresi olarak "posts/44" tanimlar
    Then Kullanici verilen EndPointe bir GET request yapar ve Header degerlerini kaydeder
    Then Kullanici donen response'un durum kodunun 200 oldugunu dogrular
    Then Kullanici donen response'un content type degerinin "application/json; charset=utf-8" oldugunu dogrular
    Then Kullanici donen response degerini JsonPath olarak kaydeder
    Then Kullanici donen response icindeki "title" degerinin "optio dolor molestias sit" oldugunu kontrol eder

    #    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir
    #    POST request yolladigimizda donen response'un
    #    status kodunun 200, content type'inin "application/json; charset=utf-8",
    #    Connection header degerinin "keep-alive"
    #    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

    #   Request Body                      Expected Data :
    #   {                                     {
    #    "title": "Ahmet",                      "title": "Ahmet",
    #    "body": "Merhaba",                     "body": "Merhaba",
    #    "userId": 10,                          "userId": 10,
    #    "id": 70                               "id": 70
    #   }

  Scenario: PUT Request

    Given Kullanici "JPHUrl" adresine gider
    Then Kullanici path parametresi olarak "posts/70" tanimlar
    Then Kullanici PUT request yapmak icin "Ahmet","Merhaba",10 70 degerleri ile reqBody hazirlar
    Then Kullanici PUT request yaparak response degerini kaydeder
    Then Kullanici donen response'un durum kodunun 200 oldugunu dogrular
    Then Kullanici donen response'un content type degerinin "application/json; charset=utf-8" oldugunu dogrular
    Then Kullanici "Connection" header degerinin "keep-alive" oldugunu test eder
    Then Kullanici donen response degerini JsonPath olarak kaydeder
    Then Kullanici userid degerinin 10 oldugunu test eder
    Then Kullanici id degerinin 70 oldugunu test eder
    Then Kullanici response "title" degerinin "Ahmet" oldugunu test eder
    Then Kullanici response "body" degerinin "Merhaba" oldugunu test eder
