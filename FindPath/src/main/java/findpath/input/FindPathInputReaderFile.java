package findpath.input;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private final String filename;

    public FindPathInputReaderFile(String filename) {
        this.filename = filename;
    }

    @Override
    public char[][] readMaze() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            return lines.stream().map(String::toCharArray).toArray(char[][]::new);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }
}
