package com.demo.myfileupload.controller;


import com.demo.myfileupload.entity.FileOtherDetails;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.catalina.connector.Response;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
public class ConversionController {

    @GetMapping("/conversion/json2csv")
    public void  convertJSONTOCSV(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String req = "[ {\n  \"item\" : \"No. 9 Sprockets\",\n  \"quantity\" : 12,\n  \"unitPrice\" : 1.23\n}, {\n  \"item\" : \"Widget (10mm)\",\n  \"quantity\" : 4,\n  \"unitPrice\" : 3.45\n} ]"
                ;

        JsonNode jsonTree = new ObjectMapper().readTree(req);
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        String value =csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValueAsString(jsonTree);
        System.out.println(value);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + "json2scv.csv" + "\""));
        response.setContentType("application/octet-stream");
        InputStream targetStream = new ByteArrayInputStream(value.getBytes());
        FileCopyUtils.copy(targetStream, response.getOutputStream());
    }
}
