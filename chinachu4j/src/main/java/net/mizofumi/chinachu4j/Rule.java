package net.mizofumi.chinachu4j;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Rule {
    int index;
    String[] types;
    String[] categories;
    String[] channels;
    String[] ignore_channels;
    String[] reserve_flags;
    String[] ignore_flags;
    int start;
    int end;
    int min;
    int max;

    String[] reserve_titles;
    String[] ignore_titles;
    String[] reserve_descriptions;
    String[] ignore_descriptions;
    String recorded_format;
    boolean isDisabled;

    public Rule() {
    }

    public Rule(String[] types, String[] categories, String[] channels, String[] ignore_channels,
                String[] reserve_flags, String[] ignore_flags,
                int start, int end, int min, int max, String[] reserve_titles, String[] ignore_titles,
                String[] reserve_descriptions, String[] ignore_descriptions, String recorded_format, boolean isDisabled){
        this.types = types;
        this.categories = categories;
        this.channels = channels;
        this.ignore_channels = ignore_channels;
        this.reserve_flags = reserve_flags;
        this.ignore_flags = ignore_flags;
        this.start = start;
        this.end = end;
        this.min = min;
        this.max = max;
        this.reserve_titles = reserve_titles;
        this.ignore_titles = ignore_titles;
        this.reserve_descriptions = reserve_descriptions;
        this.ignore_descriptions = ignore_descriptions;
        this.recorded_format = recorded_format;
        this.isDisabled = isDisabled;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String[] getChannels() {
        return channels;
    }

    public void setChannels(String[] channels) {
        this.channels = channels;
    }

    public String[] getIgnore_channels() {
        return ignore_channels;
    }

    public void setIgnore_channels(String[] ignore_channels) {
        this.ignore_channels = ignore_channels;
    }

    public String[] getReserve_flags() {
        return reserve_flags;
    }

    public void setReserve_flags(String[] reserve_flags) {
        this.reserve_flags = reserve_flags;
    }

    public String[] getIgnore_flags() {
        return ignore_flags;
    }

    public void setIgnore_flags(String[] ignore_flags) {
        this.ignore_flags = ignore_flags;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String[] getReserve_titles() {
        return reserve_titles;
    }

    public void setReserve_titles(String[] reserve_titles) {
        this.reserve_titles = reserve_titles;
    }

    public String[] getIgnore_titles() {
        return ignore_titles;
    }

    public void setIgnore_titles(String[] ignore_titles) {
        this.ignore_titles = ignore_titles;
    }

    public String[] getReserve_descriptions() {
        return reserve_descriptions;
    }

    public void setReserve_descriptions(String[] reserve_descriptions) {
        this.reserve_descriptions = reserve_descriptions;
    }

    public String[] getIgnore_descriptions() {
        return ignore_descriptions;
    }

    public void setIgnore_descriptions(String[] ignore_descriptions) {
        this.ignore_descriptions = ignore_descriptions;
    }

    public String getRecorded_format() {
        return recorded_format;
    }

    public void setRecorded_format(String recorded_format) {
        this.recorded_format = recorded_format;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(boolean isDisabled) {
        this.isDisabled = isDisabled;
    }
}
