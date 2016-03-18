package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class FIle {

    long dev;
    long ino;
    long mode;
    long uid;
    long gid;
    long rdev;
    long size;
    long blksize;
    long blocks;
    long atime;
    long mtime;
    long ctime;

    public long getDev() {
        return dev;
    }

    public long getIno() {
        return ino;
    }

    public long getMode() {
        return mode;
    }

    public long getUid() {
        return uid;
    }

    public long getGid() {
        return gid;
    }

    public long getRdev() {
        return rdev;
    }

    public long getSize() {
        return size;
    }

    public long getBlksize() {
        return blksize;
    }

    public long getBlocks() {
        return blocks;
    }

    public long getAtime() {
        return atime;
    }

    public long getMtime() {
        return mtime;
    }

    public long getCtime() {
        return ctime;
    }

}
