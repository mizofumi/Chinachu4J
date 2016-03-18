package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Recorded {
    Program program;
    boolean isManualReserved;
    boolean isConflict;
    String recordedFormat;
    boolean isSitTerm;
    Tuner tuner;
    String recorded;
    String command;
    boolean isRemoved;

    public Recorded(Program program, boolean isManualReserved, boolean isConflict, String recordedFormat,
                    boolean isSitTerm, Tuner tuner, String recorded, String command, boolean isRemoved) {
        this.program = program;
        this.isManualReserved = isManualReserved;
        this.isConflict = isConflict;
        this.recordedFormat = recordedFormat;
        this.isSitTerm = isSitTerm;
        this.tuner = tuner;
        this.recorded = recorded;
        this.command = command;
        this.isRemoved = isRemoved;
    }

    public Program getProgram() {
        return program;
    }

    public boolean isManualReserved() {
        return isManualReserved;
    }

    public boolean isConflict() {
        return isConflict;
    }

    public String getRecordedFormat() {
        return recordedFormat;
    }

    public boolean isSitTerm() {
        return isSitTerm;
    }

    public Tuner getTuner() {
        return tuner;
    }

    public String getRecorded() {
        return recorded;
    }

    public String getCommand() {
        return command;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
