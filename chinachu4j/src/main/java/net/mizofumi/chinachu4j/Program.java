package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Program {

    String id;
    String category;
    String title;
    String subTitle;
    String fullTitle;
    String detail;
    String episode;
    long start;
    long end;
    int seconds;
    String[] flags;
    Channel channel;

    public Program(String id, String category, String title, String subTitle, String fullTitle, String detail,
                   String episode, long start, long end, int seconds, String[] flags, Channel channel) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.subTitle = subTitle;
        this.fullTitle = fullTitle;
        this.detail = detail;
        this.episode = episode;
        this.start = start;
        this.end = end;
        this.seconds = seconds;
        this.flags = flags;
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getDetail() {
        return detail;
    }

    public String getEpisode() {
        return episode;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int getSeconds() {
        return seconds;
    }

    public String[] getFlags() {
        return flags;
    }

    public Channel getChannel() {
        return channel;
    }

}
