package it.unibo.mvc;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class ControllerImpl implements Controller {
    
    private String nextLine;
    private final List<String> history;

    public ControllerImpl(){
        this.history = new ArrayList<>();        
    }

    @Override
    public List<String> getHistoryLine() {
        return this.history;
    }

    @Override
    public String getLine() {
        return this.nextLine;
    }

    @Override
    public void printString() {
        System.out.println(this.nextLine);
        this.history.add(this.nextLine);
        
    }

    @Override
    public void setLine(String newLine) {
        Objects.requireNonNull(newLine);
        this.nextLine = newLine;
    }

    

}
