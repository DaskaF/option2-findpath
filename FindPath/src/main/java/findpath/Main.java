package findpath;

import findpath.decorators.CommaSeparatedMovesDecorator;
import findpath.input.AbstractFindPathInputReader;
import findpath.input.FindPathInputReaderFile;
import findpath.input.FindPathInputReaderStdIn;

public class Main {
    public static void main(String[] args) {
        AbstractFindPathInputReader reader;
        if (args.length > 0) {
            reader = new FindPathInputReaderFile(args[0]);
        } else {
            reader = new FindPathInputReaderStdIn();
        }
        MazePathFinder solver = new MazePathFinder(reader.readMaze());
        System.out.println(CommaSeparatedMovesDecorator.decorate(solver.findPath()));
    }
}