package it.unibo.mvc;

import java.util.List;

/**
 *Controller should be used to fulfill to standard output operation in a MVC pattern
 */
public interface Controller {

    /**
     * This method shall set the next string to print
     * @param newLine
     * @throws NullpointerException if {@code newLine} is null
     */
    void setLine(String newLine);

    /**
     * 
     * @return the next string to print
     */
    String getLine();

    /**
     * 
     * @return the history of the printed Strings
     */
    List<String> getHistoryLine();

    /**
     * This method print the string previously setted
     */
    void printString();
}
