package com.test.file;


import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.exists;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class InputValidator {

    static FileExecutor validate(String[] args) {
        log.info("Argument size is {}", args.length);
        // command line parameter
        if (args.length != 2) {
            log.info("Invalid command line, exactly two argument required");
            throw new RuntimeException("Invalid command line, exactly two argument required. 1 - Input file name && 2 - Thread count");
        }
        if (!hasText(args[0])) {
            log.info("Invalid command line, fully qualified file path required");
            throw new RuntimeException("Invalid command line, fully qualified file path required");
        }
        if (!hasText(args[1])) {
            log.info("Invalid command line, number of threads required");
            throw new RuntimeException("Invalid command line, number of threads required");
        }
        final int threadCount = Integer.parseInt(args[1]);
        if (threadCount < 1) {
            log.info("Invalid command line, number of threads count must be greater than 0");
            throw new RuntimeException("Invalid command line, number of threads count must be greater than 0");
        }
        Path path = Paths.get(args[0]);
        if (!exists(path)) {
            log.info("Invalid command line, File not found at location {}", path);
            throw new RuntimeException("Invalid command line, File not found at location {}" + path);
        }
        return new FileExecutor(path, threadCount);
    }

}
