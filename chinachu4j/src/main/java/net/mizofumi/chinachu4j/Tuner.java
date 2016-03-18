package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Tuner {

    String name;
    boolean isScrambling;
    String[] types;
    String command;
    int n;

    public Tuner(String name, boolean isScrambling, String[] types, String command, int n) {
        this.name = name;
        this.isScrambling = isScrambling;
        this.types = types;
        this.command = command;
        this.n = n;
    }

    public String getName() {
        return name;
    }

    public boolean isScrambling() {
        return isScrambling;
    }

    public String[] getTypes() {
        return types;
    }

    public String getCommand() {
        return command;
    }

    public int getN() {
        return n;
    }

}
