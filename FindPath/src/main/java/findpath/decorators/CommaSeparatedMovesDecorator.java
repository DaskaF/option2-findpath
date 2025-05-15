package findpath.decorators;

import java.util.Arrays;

public class CommaSeparatedMovesDecorator {
    public static String decorate(String input) {
        return String.join(",", input.split(""));
    }
}
