package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Recording {

    Program program;
    boolean isManualReserved;
    boolean isSigTerm;
    Tuner tuner;
    String recorded;
    String command;
    int pid;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public boolean isManualReserved() {
        return isManualReserved;
    }

    public void setIsManualReserved(boolean isManualReserved) {
        this.isManualReserved = isManualReserved;
    }

    public boolean isSigTerm() {
        return isSigTerm;
    }

    public void setIsSigTerm(boolean isSigTerm) {
        this.isSigTerm = isSigTerm;
    }

    public Tuner getTuner() {
        return tuner;
    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public String getRecorded() {
        return recorded;
    }

    public void setRecorded(String recorded) {
        this.recorded = recorded;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

}
