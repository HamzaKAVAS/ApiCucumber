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
