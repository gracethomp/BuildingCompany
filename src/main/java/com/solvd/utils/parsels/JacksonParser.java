package com.solvd.utils.parsels;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Main;
import com.solvd.models.jackson.Department;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JacksonParser {
    private static final Logger LOGGER = Logger.getLogger(JacksonParser.class);

    public static void doParse() throws IOException {
        System.out.println();
        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/filesToParse/department.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Department department = objectMapper.readValue(jsonData, Department.class);

        LOGGER.info(department);
    }
}
