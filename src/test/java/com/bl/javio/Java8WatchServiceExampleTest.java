package com.bl.javio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Java8WatchServiceExampleTest {
    public static String HOME = System.getProperty("user.home");
    public static String PLAY_WITH_NIO = "TempPlay";

    @Test
    public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample (dir).processEvents();
    }
}