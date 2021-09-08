package com.ccon.chap.rest;

import com.ccon.chap.configurations.JpaConfiguration;
import com.ccon.chap.dto.ValCursDto;
import com.ccon.chap.service.valcurs.ValCursService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestOperations;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfiguration.class)
@WebAppConfiguration
public class ValCursAPITest {
    private final String LOGIN = "CharArtPav";
    private final String PASSWORD = "user1";
    private final String BASIC_URI = "http://Localhost:8080/converter/api/valcurs";

    private final String TEST_GET_ID = "{\"write_id\":50,\"currency_id\":\"R01775\",\"currency_numcode\":756,\"currency_charcode\":\"CHF\",\"currency_nominal\":10,\"currency_name\":\"Swiss Franc\",\"currency_value\":\"19.2455\",\"currency_date\":\"2002-05-02\"}";
    private final String TEST_GET_NAME = "[{\"write_id\":1,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.0102\",\"currency_date\":\"2002-03-02\"},{\"write_id\":18,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.6906\",\"currency_date\":\"2002-04-02\"},{\"write_id\":35,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.8391\",\"currency_date\":\"2002-05-02\"}]";
    private final String TEST_GET_LAST_ENTITY = "{\"write_id\":54,\"currency_id\":\"R01011\",\"currency_numcode\":1136,\"currency_charcode\":\"AНD\",\"currency_nominal\":1,\"currency_name\":\"Моя валюта\",\"currency_value\":\"100.01\",\"currency_date\":\"2021-08-27\"}";
    private final String TEST_GET_CURRENCY_ID = "[{\"write_id\":1,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.0102\",\"currency_date\":\"2002-03-02\"},{\"write_id\":18,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.6906\",\"currency_date\":\"2002-04-02\"},{\"write_id\":35,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.8391\",\"currency_date\":\"2002-05-02\"}]";
    private final String TEST_GET_NUM_CODE = "[{\"write_id\":1,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.0102\",\"currency_date\":\"2002-03-02\"},{\"write_id\":18,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.6906\",\"currency_date\":\"2002-04-02\"},{\"write_id\":35,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.8391\",\"currency_date\":\"2002-05-02\"}]";
    private final String TEST_GET_DATE = "[{\"write_id\":1,\"currency_id\":\"R01010\",\"currency_numcode\":36,\"currency_charcode\":\"AUD\",\"currency_nominal\":1,\"currency_name\":\"Australian Dollar\",\"currency_value\":\"16.0102\",\"currency_date\":\"2002-03-02\"},{\"write_id\":2,\"currency_id\":\"R01035\",\"currency_numcode\":826,\"currency_charcode\":\"GBP\",\"currency_nominal\":1,\"currency_name\":\"Pound Sterling of the United Kingdom\",\"currency_value\":\"43.8254\",\"currency_date\":\"2002-03-02\"},{\"write_id\":3,\"currency_id\":\"R01090\",\"currency_numcode\":974,\"currency_charcode\":\"BYR\",\"currency_nominal\":1000,\"currency_name\":\"Belarusian Rubles\",\"currency_value\":\"18.4290\",\"currency_date\":\"2002-03-02\"},{\"write_id\":4,\"currency_id\":\"R01215\",\"currency_numcode\":208,\"currency_charcode\":\"DKK\",\"currency_nominal\":10,\"currency_name\":\"Danish Crowns\",\"currency_value\":\"36.1010\",\"currency_date\":\"2002-03-02\"},{\"write_id\":5,\"currency_id\":\"R01235\",\"currency_numcode\":840,\"currency_charcode\":\"USD\",\"currency_nominal\":1,\"currency_name\":\"US Dollar\",\"currency_value\":\"30.9436\",\"currency_date\":\"2002-03-02\"},{\"write_id\":6,\"currency_id\":\"R01239\",\"currency_numcode\":978,\"currency_charcode\":\"EUR\",\"currency_nominal\":1,\"currency_name\":\"Euro\",\"currency_value\":\"26.8343\",\"currency_date\":\"2002-03-02\"},{\"write_id\":7,\"currency_id\":\"R01310\",\"currency_numcode\":352,\"currency_charcode\":\"ISK\",\"currency_nominal\":100,\"currency_name\":\"Icelandic Crowns\",\"currency_value\":\"30.7958\",\"currency_date\":\"2002-03-02\"},{\"write_id\":8,\"currency_id\":\"R01335\",\"currency_numcode\":398,\"currency_charcode\":\"KZT\",\"currency_nominal\":100,\"currency_name\":\"Kazakhstani Tenge\",\"currency_value\":\"20.3393\",\"currency_date\":\"2002-03-02\"},{\"write_id\":9,\"currency_id\":\"R01350\",\"currency_numcode\":124,\"currency_charcode\":\"CAD\",\"currency_nominal\":1,\"currency_name\":\"Canadian Dollar\",\"currency_value\":\"19.3240\",\"currency_date\":\"2002-03-02\"},{\"write_id\":10,\"currency_id\":\"R01535\",\"currency_numcode\":578,\"currency_charcode\":\"NOK\",\"currency_nominal\":10,\"currency_name\":\"Norwegian Crowns\",\"currency_value\":\"34.7853\",\"currency_date\":\"2002-03-02\"},{\"write_id\":11,\"currency_id\":\"R01589\",\"currency_numcode\":960,\"currency_charcode\":\"XDR\",\"currency_nominal\":1,\"currency_name\":\"SDR (Special drawing rights)\",\"currency_value\":\"38.4205\",\"currency_date\":\"2002-03-02\"},{\"write_id\":12,\"currency_id\":\"R01625\",\"currency_numcode\":702,\"currency_charcode\":\"SGD\",\"currency_nominal\":1,\"currency_name\":\"Singapore Dollar\",\"currency_value\":\"16.8878\",\"currency_date\":\"2002-03-02\"},{\"write_id\":13,\"currency_id\":\"R01700\",\"currency_numcode\":792,\"currency_charcode\":\"TRL\",\"currency_nominal\":1000000,\"currency_name\":\"Turkish Lira\",\"currency_value\":\"22.2616\",\"currency_date\":\"2002-03-02\"},{\"write_id\":14,\"currency_id\":\"R01720\",\"currency_numcode\":980,\"currency_charcode\":\"UAH\",\"currency_nominal\":10,\"currency_name\":\"Ukrainian hryvnias\",\"currency_value\":\"58.1090\",\"currency_date\":\"2002-03-02\"},{\"write_id\":15,\"currency_id\":\"R01770\",\"currency_numcode\":752,\"currency_charcode\":\"SEK\",\"currency_nominal\":10,\"currency_name\":\"Swedish Crowns\",\"currency_value\":\"29.5924\",\"currency_date\":\"2002-03-02\"},{\"write_id\":16,\"currency_id\":\"R01775\",\"currency_numcode\":756,\"currency_charcode\":\"CHF\",\"currency_nominal\":10,\"currency_name\":\"Swiss Franc\",\"currency_value\":\"18.1861\",\"currency_date\":\"2002-03-02\"},{\"write_id\":17,\"currency_id\":\"R01820\",\"currency_numcode\":392,\"currency_charcode\":\"JPY\",\"currency_nominal\":100,\"currency_name\":\"Japanese Yen\",\"currency_value\":\"23.1527\",\"currency_date\":\"2002-03-02\"}]";


    private final RestOperations restOperations;
    private final ValCursService valCursService;

    @Autowired
    public ValCursAPITest(RestOperations restOperations, ValCursService valCursService) {
        this.restOperations = restOperations;
        this.valCursService = valCursService;
    }

    @Test
    void findByAll() {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void findById() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/50", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_ID, responseEntity.getBody(), true);
    }

    @Test
    void findByName() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/?name=Australian Dollar", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_NAME, responseEntity.getBody(), true);
    }

    @Test
    void findByLastEntry() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/last", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_LAST_ENTITY, responseEntity.getBody(), true);
    }

    @Test
    void findByCurrencyId() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/CurrencyId?currencyId=R01010", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_CURRENCY_ID, responseEntity.getBody(), true);
    }

    @Test
    void findByNumCode() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/NumCode?numCode=36", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_NUM_CODE, responseEntity.getBody(), true);
    }

    @Test
    void findByDate() throws JSONException {
        ResponseEntity<String> responseEntity = restOperations.getForEntity(BASIC_URI + "/ByDate?date=2002-03-02", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JSONAssert.assertEquals(TEST_GET_DATE, responseEntity.getBody(), true);
    }

    @Test
    void update() throws JSONException {
        ValCursDto valCursDto = new ValCursDto();
        valCursDto.setCurrency_id("R01111");
        valCursDto.setCurrency_numcode((short) 1101);
        valCursDto.setCurrency_charcode("AHD");
        valCursDto.setCurrency_nominal(0);
        valCursDto.setCurrency_name("My currency");
        valCursDto.setCurrency_value("100.00");
        restOperations.put(BASIC_URI + "/53?date=2021-09-08", new HttpEntity<>(valCursDto, getHeaders()), String.class);
        assertEquals(valCursDto.getCurrency_name(), valCursService.findValCursDtoByWriteId(53L).getCurrency_name());
    }

    @Test
    void creat() {
        ValCursDto valCursDto = new ValCursDto();
        valCursDto.setCurrency_id("R00000");
        valCursDto.setCurrency_numcode((short) 1);
        valCursDto.setCurrency_charcode("AAA");
        valCursDto.setCurrency_nominal(0);
        valCursDto.setCurrency_name("MyValute");
        valCursDto.setCurrency_value("10000.00");
        restOperations.postForEntity(BASIC_URI + "/", new HttpEntity<>(valCursDto, getHeaders()), String.class);
        assertEquals(valCursDto.getCurrency_id(), valCursService.getLastEntry().getCurrency_id());
    }

    private HttpHeaders getHeaders() {
        String auth = LOGIN + ":" + PASSWORD;
        byte[] encoded = Base64.getEncoder().encode(auth.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Basic " + new String(encoded));
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return headers;
    }
}
