package com.test.file;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
public class FileWriter {
    private static final String OUTPUT_TXT = "./output.txt";

    public static void writeFile(final List<String> resultList) {
        if (!isEmpty(resultList)) {
            log.info("File will be generated at {}", OUTPUT_TXT);
            try {
                Files.write(Paths.get(OUTPUT_TXT), resultList, defaultCharset());
            } catch (Exception e) {
                log.error("Error while writing the file ", e);
            }
            log.info("File processed successfully");
        }

    }
}
