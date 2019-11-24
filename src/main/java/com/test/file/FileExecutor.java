package com.test.file;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class FileExecutor {

    private Path path;
    private int threadCount;
    private ExecutorService executorService;

    public FileExecutor(Path path, int threadCount) {
        this.path = path;
        this.threadCount = threadCount;
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }


    public Optional<List<String>> execute() throws Exception {
        log.info("Input file path {}", path);
        log.info("Input threadCount {}", threadCount);

        List<String> resultList = new ArrayList<>();

        Files.lines(path).forEach(i -> {
            Future<String> futureTask = executorService.submit(() -> FileEncryptor.cipher(i, 3));
            try {
                resultList.add(futureTask.get(5, SECONDS));
            } catch (InterruptedException e) {
                log.error("Error while processing request ", e);
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                log.error("Error while processing request ", e);
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                log.error("Error while processing request ", e);
                throw new RuntimeException(e);
            }
        });

        return Optional.of(resultList);
    }


}
