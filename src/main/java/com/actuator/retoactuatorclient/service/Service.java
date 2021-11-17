/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.actuator.retoactuatorclient.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Manuel
 */
@Component
@Endpoint(id = "estados")
public class Service {

    Logger logger = LoggerFactory.getLogger(Service.class);

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8888/";
    String urlFinal = "actuator/status/";

    public String setToOpen() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "open", String.class);
        logger.info("Estado: open");
        return response.getBody();
    }

    public String setToHalfOpen() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "half-open", String.class);
        logger.info("Estado: half-open");
        return response.getBody();
    }

    public String setToClose() {
        String fooResourceUrl = url + urlFinal;
        ResponseEntity<String> response = restTemplate.postForEntity(URI.create(fooResourceUrl), "close", String.class);
        logger.info("Estado: close");
        return response.getBody();
    }
}
