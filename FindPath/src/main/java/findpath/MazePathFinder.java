package findpath;

import java.awt.Point;
import java.util.*;

public class MazePathFinder {
    private final char[][] maze;
    private final int rows, cols;
    private Point start, target;

    public MazePathFinder(char[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        findStartAndTarget();
    }

    private void findStartAndTarget() {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++) {
                if (maze[r][c] == 'S') start = new Point(r, c);
                if (maze[r][c] == 'X') target = new Point(r, c);
            }
        if (start == null || target == null)
            throw new IllegalArgumentException("Maze must contain exactly one 'S' and one 'X'");
    }

    public String findPath() {
        Queue<Point> queue = new LinkedList<>();
        Map<Point, Point> cameFrom = new HashMap<>();
        Map<Point, Character> moveFrom = new HashMap<>();
        queue.add(start);
        cameFrom.put(start, null);

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        char[] moves = {'u','d','l','r'};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.equals(target)) break;

            for (int i = 0; i < 4; i++) {
                int nr = current.x + dirs[i][0];
                int nc = current.y + dirs[i][1];
                Point next = new Point(nr, nc);

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        maze[nr][nc] != '#' && !cameFrom.containsKey(next)) {
                    queue.add(next);
                    cameFrom.put(next, current);
                    moveFrom.put(next, moves[i]);
                }
            }
        }

        if (!cameFrom.containsKey(target)) throw new RuntimeException("No path found");

        // reconstruct path
        StringBuilder path = new StringBuilder();
        for (Point p = target; !p.equals(start); p = cameFrom.get(p))
            path.insert(0, moveFrom.get(p));
        return path.toString();
    }
}
