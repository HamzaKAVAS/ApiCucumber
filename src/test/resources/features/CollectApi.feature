Feature: Collect API Request

    # curl --request GET \
    #--url 'https://api.collectapi.com/health/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara' \
    #--header 'authorization: apikey 2ecC1yGMUbcPi9V1YuXKJ5:2TLu6uoUy3ZDCvIS2xIsOu' \
    #--header 'content-type: application/json'

  Scenario: Nobetci Eczaneler
    Given kullanici sorgu icin "CollectApiUrl" adresine gider
    Then kullanici sorgu icin pathparametresi olarak "health/dutyPharmacy" girer
    Then kullanici query parametresi olark il degerine "ankara" ilce degerine "mamak" girer
    Then kullanici gereki header degerleri ile bir GET request yapar
    Then kullanici donen response degerini yazdrir
