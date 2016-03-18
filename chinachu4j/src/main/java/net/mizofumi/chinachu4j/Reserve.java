package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Reserve {

    Program program;
    boolean isManualReserved;
    boolean isConflict;
    String recordedFormat;
    boolean isSkip;

    public Reserve(Program program, boolean isManualReserved, boolean isConflict, String recordedFormat, boolean isSkip) {
        this.program = program;
        this.isManualReserved = isManualReserved;
        this.isConflict = isConflict;
        this.recordedFormat = recordedFormat;
        this.isSkip = isSkip;
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

    public boolean isSkip() {
        return isSkip;
    }

}
