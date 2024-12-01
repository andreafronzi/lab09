package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Controller should be used to fulfill the standard output operation in a MVC pattern.
 */
public final class SimpleController implements Controller {

    private String nextLine;
    private final List<String> history;

    /**
     * 0-argoument constructor.
     */
    public SimpleController() {
        this.history = new ArrayList<>();
    }

    /**
     * @return the history of the previous printed lines.
     */
    @Override
    public List<String> getHistoryLine() {
        return Collections.unmodifiableList(this.history);
    }

    /**
     * @return the next line which will be printed.
     */
    @Override
    public String getLine() {
        return this.nextLine;
    }

    /**
     * This method print the {@code String} previously setted.
     */
    @Override
    public void printString() {
        if (Objects.isNull(this.nextLine)) {
            throw new IllegalStateException();
        }
        System.out.println(this.nextLine); // NOPMD: allowed in exercises
        this.history.add(this.nextLine);
    }

    /**
     * @param newLine the new Line which will be print.
     */
    @Override
    public void setLine(final String newLine) {
        Objects.requireNonNull(newLine);
        this.nextLine = newLine;
    }
}
