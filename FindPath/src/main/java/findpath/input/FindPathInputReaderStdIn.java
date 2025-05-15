package findpath.input;

import findpath.input.AbstractFindPathInputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {
    @Override
    public char[][] readMaze() {
        Scanner sc = new Scanner(System.in);
        List<char[]> rows = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            rows.add(line.toCharArray());
        }
        return rows.toArray(new char[0][]);
    }
}
