package net.mizofumi.chinachu4j;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class Chinachu4J {

    ChinachuHttp chinachuHttp;
    String baseURL;
    BasicAuthenticator basicAuthenticator;

    public Chinachu4J(String baseURL) {
        this.baseURL = baseURL;
    }

    public Chinachu4J(String baseURL, BasicAuthenticator basicAuthenticator) {
        this.baseURL = baseURL;
        this.basicAuthenticator = basicAuthenticator;
        chinachuHttp = new ChinachuHttp(basicAuthenticator);
    }

    public Program[] getNowChannelSchedule() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException {
        String channelSchedule = chinachuHttp.getServer(baseURL + "schedule/broadcasting.json");
        JSONArray jprogram = new JSONArray(channelSchedule);
        Program[] programs = new Program[jprogram.length()];
        for (int i = 0; i < jprogram.length(); i++)
            programs[i] = getProgram(jprogram.getJSONObject(i));
        return programs;
    }

    public Program getProgram(String programId) throws NoSuchAlgorithmException, KeyManagementException, IOException, JSONException {
        String program = chinachuHttp.getServer(baseURL + "program/" + programId + ".json");
        return getProgram(new JSONObject(program));
    }

    public Program[] getChannelSchedule(String channelId) throws NoSuchAlgorithmException, KeyManagementException, IOException, JSONException {
        String channelSchedule = chinachuHttp.getServer(baseURL + "schedule/" + channelId + "/programs.json");
        JSONArray jprogram = new JSONArray(channelSchedule);
        Program[] programs = new Program[jprogram.length()];
        for(int i = 0; i < jprogram.length(); i++)
            programs[i] = getProgram(jprogram.getJSONObject(i));
        return programs;
    }

    public Program[] getAllSchedule() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String allSchedule = chinachuHttp.getServer(baseURL + "schedule/programs.json");
        JSONArray jAll = new JSONArray(allSchedule);
        Program[] allPrograms = new Program[jAll.length()];
        for(int i = 0; i < jAll.length(); i++)
            allPrograms[i] = getProgram(jAll.getJSONObject(i));
        return allPrograms;
    }

    public Program[] searchProgram(String query) throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        Program[] allSchedule = getAllSchedule();
        ArrayList<Program> array = new ArrayList<Program>();
        for(Program p : allSchedule){
            if (p.getFullTitle().contains(query))
                array.add(p);
        }
        return (Program[])array.toArray(new Program[0]);
    }

    public String[] getChannelList() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        JSONArray channelJson = new JSONArray(chinachuHttp.getServer(baseURL + "schedule/broadcasting.json"));
        String[] channelList = new String[channelJson.length()];
        for(int i = 0; i < channelJson.length(); i++){
            channelList[i] = channelJson.getJSONObject(i).getJSONObject("channel").getString("name") + ","
                    + channelJson.getJSONObject(i).getJSONObject("channel").getString("id");
        }
        return channelList;
    }

    public Reserve[] getReserves() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String reserves = chinachuHttp.getServer(baseURL + "reserves.json");
        JSONArray jreserves = new JSONArray(reserves);
        Reserve[] reserve = new Reserve[jreserves.length()];
        for(int i = 0; i < jreserves.length(); i++)
            reserve[i] = getReserve(jreserves.getJSONObject(i));
        return reserve;
    }

    public Reserve getReserve(String programid) throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String reserves = chinachuHttp.getServer(baseURL + "reserves/" + programid + ".json");
        return getReserve(new JSONObject(reserves));
    }

    public Recording[] getRecordings() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String recording = chinachuHttp.getServer(baseURL + "recording.json");
        JSONArray jrecording = new JSONArray(recording);
        Recording[] recordings = new Recording[jrecording.length()];
        for(int i = 0; i < jrecording.length(); i++)
            recordings[i] = getRecording(jrecording.getJSONObject(i));
        return recordings;
    }

    public Recording getRecording(String programid) throws NoSuchAlgorithmException, KeyManagementException, IOException, JSONException {
        String recording = chinachuHttp.getServer(baseURL + "recording/" + programid + ".json");
        return getRecording(new JSONObject(recording));
    }

    /*
    public Bitmap getRecordingImage(String id, String size) throws KeyManagementException, NoSuchAlgorithmException, IOException{
        if(id == null)
            return null;
        if(size == null)
            size = "320x180";
        String result =  getServer(baseURL + "recording/" + id + "/preview.txt" + "?size=" + size);
        if(result.startsWith("data:image/jpeg;base64,"))
            result = result.substring(23);
        byte[] decodedString = Base64.decode(result, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
    */

    public Recorded[] getRecorded() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String recorded = chinachuHttp.getServer(baseURL + "recorded.json");
        JSONArray jrecorded = new JSONArray(recorded);
        Recorded[] _recorded = new Recorded[jrecorded.length()];
        for(int i = 0; i < jrecorded.length(); i++)
            _recorded[i] = getRecorded(jrecorded.getJSONObject(i));
        return _recorded;
    }

    public Recorded getRecorded(String programid) throws NoSuchAlgorithmException, KeyManagementException, IOException, JSONException {
        String recorded = chinachuHttp.getServer(baseURL + "recorded/" + programid + ".json");
        return getRecorded(new JSONObject(recorded));
    }

    /*
    public Bitmap getRecordedImage(String id, int pos, String size) throws KeyManagementException, NoSuchAlgorithmException, IOException{
        if(id == null)
            return null;
        if(pos == -1)
            pos = 7;
        if(size == null)
            size = "320x180";
        String result = getServer(baseURL + "recorded/" + id + "/preview.txt" + "?pos=" + pos + "&size=" + size);
        if(result.startsWith("data:image/jpeg;base64,"))
            result = result.substring(23);
        byte[] decodedString = Base64.decode(result, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
    */

    public String getNonEncRecordingMovie(String programId){
        return getIncludeUserPass() + "recording/" + programId + "/watch.m2ts?f=mpegts&c:v=copy&c:a=copy";
    }

    // type: m2ts, f4v, flv, webm, asf
    public String getEncRecordingMovie(String programId, String type, String[] params){
        String base = getIncludeUserPass() + "recording/" + programId + "/watch." + type + "?";
        return getIncludeEncParams(base, params);
    }

    public String getNonEncRecordedMovie(String programId){
        return getIncludeUserPass() + "recorded/" + programId + "/watch.m2ts?f=mpegts&c:v=copy&c:a=copy";
    }

    // type: m2ts, f4v, flv, webm, asf
    public String getEncRecordedMovie(String programId, String type, String[] params){
        String base = getIncludeUserPass() + "recorded/" + programId + "/watch." + type + "?";
        return getIncludeEncParams(base, params);
    }

    public Rule[] getRules() throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String rule = chinachuHttp.getServer(baseURL + "rules.json");
        JSONArray jrule = new JSONArray(rule);
        Rule[] rules = new Rule[jrule.length()];
        for(int i = 0; i < jrule.length(); i++)
            rules[i] = getRule(jrule.getJSONObject(i));
        return rules;
    }

    public Rule getRules(String num) throws KeyManagementException, NoSuchAlgorithmException, IOException, JSONException{
        String rule = chinachuHttp.getServer(baseURL + "rules/"+num+".json");
        return getRule(new JSONObject(rule));
    }

    private String getIncludeUserPass(){
        String includeURL = null;
        if(baseURL.startsWith("https://")) {
            includeURL = baseURL.substring(8);
            includeURL = "https://" + basicAuthenticator.getUsername() + ":"
                    + basicAuthenticator.getPassword() + "@" + includeURL;
        }else if(baseURL.startsWith("http://")) {
            includeURL = baseURL.substring(7);
            includeURL = "http://" + basicAuthenticator.getUsername() + ":"
                    + basicAuthenticator.getPassword() + "@" + includeURL;
        }
        return includeURL;
    }

    private String getIncludeEncParams(String base, String[] params){
        if(params[0] != null)
            base += "f=" + params[0] + "&";
        if(params[1] != null)
            base += "c:v=" + params[1] + "&";
        if(params[2] != null)
            base += "c:a=" + params[2] + "&";
        if(params[3] != null)
            base += "b:v=" + params[3] + "&";
        if(params[4] != null)
            base += "b:a=" + params[4] + "&";
        if(params[5] != null)
            base += "s=" + params[5] + "&";
        if(params[6] != null)
            base += "r=" + params[6] + "&";
        return base.substring(0, base.length() - 1);
    }

    protected Program getProgram(JSONObject obj) throws JSONException{
        String id, category, title, subTitle, fullTitle, detail, episode;
        long start, end;
        int seconds;
        String[] flags;
        Channel channel;
        id = obj.getString("id");
        category = obj.getString("category");
        title = obj.getString("title");
        subTitle = obj.getString("subTitle");
        fullTitle = obj.getString("fullTitle");
        detail = obj.getString("detail");
        episode = obj.getString("episode");
        start = obj.getLong("start");
        end = obj.getLong("end");
        seconds = obj.getInt("seconds");

        JSONArray flagArray = obj.getJSONArray("flags");
        flags = new String[flagArray.length()];
        for(int ii = 0; ii < flagArray.length(); ii++)
            flags[ii] = flagArray.getString(ii);

        JSONObject ch = obj.getJSONObject("channel");
        channel = new Channel(ch.getInt("n"), ch.getString("type"), ch.getString("channel"), ch.getString("name"),
                ch.getString("id"), ch.getInt("sid"));

        Program program = new Program(id, category, title, subTitle, fullTitle, detail, episode, start, end, seconds,
                flags, channel);
        return program;
    }

    private Reserve getReserve(JSONObject obj) throws JSONException{
        Program program = getProgram(obj);

        boolean exists_isManualReserved = obj.isNull("isManualReserved");
        boolean exists_isConflict = obj.isNull("isConflict");
        boolean exists_recordedFormat = obj.isNull("recordedFormat");
        boolean exists_isSkip = obj.isNull("isSkip");

        boolean isManualReserved, isConflict, isSkip;
        String recordedFormat;
        if(exists_isManualReserved)
            isManualReserved = false;
        else
            isManualReserved = obj.getBoolean("isManualReserved");

        if(exists_isConflict)
            isConflict = false;
        else
            isConflict = obj.getBoolean("isConflict");

        if(exists_recordedFormat)
            recordedFormat = null;
        else
            recordedFormat = obj.getString("recordedFormat");

        if(exists_isSkip)
            isSkip = false;
        else
            isSkip = obj.getBoolean("isSkip");

        Reserve reserve = new Reserve(program, isManualReserved, isConflict, recordedFormat, isSkip);
        return reserve;
    }

    private Recorded getRecorded(JSONObject obj) throws JSONException{
        Program program = getProgram(obj);
        Tuner tuner = getTuner(obj.getJSONObject("tuner"));

        boolean exists_isManualReserved = obj.isNull("isManualReserved");
        boolean exists_isConflict = obj.isNull("isConflict");
        boolean exists_recordedFormat = obj.isNull("recordedFormat");
        boolean exists_isRemoved = obj.isNull("isRemoved");

        boolean isManualReserved, isConflict,isRemoved;
        String recordedFormat;
        if(exists_isManualReserved)
            isManualReserved = false;
        else
            isManualReserved = obj.getBoolean("isManualReserved");

        if(exists_isConflict)
            isConflict = false;
        else
            isConflict = obj.getBoolean("isConflict");

        if(exists_recordedFormat)
            recordedFormat = null;
        else
            recordedFormat = obj.getString("recordedFormat");

        if (exists_isRemoved){
            isRemoved = false;
        }else {
            isRemoved = obj.getBoolean("isRemoved");
        }

        boolean isSigTerm = obj.getBoolean("isSigTerm");
        String recorded = obj.getString("recorded");
        String command = obj.getString("command");

        Recorded _recorded = new Recorded(program, isManualReserved, isConflict, recordedFormat, isSigTerm, tuner, recorded, command,isRemoved);
        return _recorded;
    }

    private Recording getRecording(JSONObject obj) throws JSONException {
        Recording recording = new Recording();
        Program program = getProgram(obj);
        Tuner tuner = getTuner(obj.getJSONObject("tuner"));
        recording.setProgram(program);
        recording.setTuner(tuner);
        if (!obj.isNull("isManualReserved"))
            recording.setIsManualReserved(obj.getBoolean("isManualReserved"));
        recording.setIsSigTerm(obj.getBoolean("isSigTerm"));
        recording.setCommand(obj.getString("command"));
        recording.setRecorded(obj.getString("recorded"));
        recording.setPid(obj.getInt("pid"));
        return recording;
    }

    private Tuner getTuner(JSONObject obj) throws JSONException{
        String name = obj.getString("name");
        boolean isScrambling = obj.getBoolean("isScrambling");
        JSONArray typesArray = obj.getJSONArray("types");
        String[] types = new String[typesArray.length()];
        for(int i = 0; i < typesArray.length(); i++)
            types[i] = typesArray.getString(i);
        String command = obj.getString("command");
        int n = obj.getInt("n");

        Tuner tuner = new Tuner(name, isScrambling, types, command, n);
        return tuner;
    }

    private Rule getRule(JSONObject obj) throws JSONException{
        String[] types, categories, channels, ignore_channels, reserve_flags, ignore_flags;
        int start, end, min, max;
        String[] reserve_titles, ignore_titles, reserve_descriptions, ignore_descriptions;
        String recorded_format;
        boolean isDisabled;

        boolean exists_types = obj.isNull("types");
        boolean exists_categories = obj.isNull("categories");
        boolean exists_channels = obj.isNull("channels");
        boolean exists_ignore_channels = obj.isNull("ignore_channels");
        boolean exists_reserve_flags = obj.isNull("reserve_flags");
        boolean exists_ignore_flags = obj.isNull("ignore_flags");
        boolean exists_hour = obj.isNull("hour");
        boolean exists_duration = obj.isNull("duration");
        boolean exists_reserve_titles = obj.isNull("reserve_titles");
        boolean exists_ignore_titles = obj.isNull("ignore_titles");
        boolean exists_reserve_descriptions = obj.isNull("reserve_descriptions");
        boolean exists_ignore_descriptions = obj.isNull("ignore_descriptions");
        boolean exists_recorded_format = obj.isNull("recorded_format");
        boolean exists_isDisabled = obj.isNull("isDisabled");

        if(exists_types)
            types = new String[0];
        else{
            JSONArray array = obj.getJSONArray("types");
            types = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                types[i] = array.getString(i);
        }

        if(exists_categories)
            categories = new String[0];
        else{
            JSONArray array = obj.getJSONArray("categories");
            categories = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                categories[i] = array.getString(i);
        }

        if(exists_channels)
            channels = new String[0];
        else{
            JSONArray array = obj.getJSONArray("channels");
            channels = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                channels[i] = array.getString(i);
        }

        if(exists_ignore_channels)
            ignore_channels = new String[0];
        else{
            JSONArray array = obj.getJSONArray("ignore_channels");
            ignore_channels = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                ignore_channels[i] = array.getString(i);
        }

        if(exists_reserve_flags)
            reserve_flags = new String[0];
        else{
            JSONArray array = obj.getJSONArray("reserve_flags");
            reserve_flags = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                reserve_flags[i] = array.getString(i);
        }

        if(exists_ignore_flags)
            ignore_flags = new String[0];
        else{
            JSONArray array = obj.getJSONArray("ignore_flags");
            ignore_flags = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                ignore_flags[i] = array.getString(i);
        }

        if(exists_hour){
            start = -1;
            end = -1;
        }else{
            JSONObject o = obj.getJSONObject("hour");
            boolean exists_start = o.isNull("start");
            boolean exists_end = o.isNull("end");
            if(exists_start)
                start = -1;
            else
                start = o.getInt("start");
            if(exists_end)
                end = -1;
            else
                end = o.getInt("end");
        }

        if(exists_duration){
            min = -1;
            max = -1;
        }else{
            JSONObject o = obj.getJSONObject("duration");
            boolean exists_min = o.isNull("min");
            boolean exists_max = o.isNull("max");
            if(exists_min)
                min = -1;
            else
                min = o.getInt("min");
            if(exists_max)
                max = -1;
            else
                max = o.getInt("max");
        }

        if(exists_reserve_titles)
            reserve_titles = new String[0];
        else{
            JSONArray array = obj.getJSONArray("reserve_titles");
            reserve_titles = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                reserve_titles[i] = array.getString(i);
        }

        if(exists_ignore_titles)
            ignore_titles = new String[0];
        else{
            JSONArray array = obj.getJSONArray("ignore_titles");
            ignore_titles = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                ignore_titles[i] = array.getString(i);
        }

        if(exists_reserve_descriptions)
            reserve_descriptions = new String[0];
        else{
            JSONArray array = obj.getJSONArray("reserve_descriptions");
            reserve_descriptions = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                reserve_descriptions[i] = array.getString(i);
        }

        if(exists_ignore_descriptions)
            ignore_descriptions = new String[0];
        else{
            JSONArray array = obj.getJSONArray("ignore_descriptions");
            ignore_descriptions = new String[array.length()];
            for(int i = 0; i < array.length(); i++)
                ignore_descriptions[i] = array.getString(i);
        }

        if(exists_recorded_format)
            recorded_format = null;
        else
            recorded_format = obj.getString("recorded_format");

        if(exists_isDisabled)
            isDisabled = false;
        else
            isDisabled = obj.getBoolean("isDisabled");

        Rule rule = new Rule(types, categories, channels, ignore_channels, reserve_flags, ignore_flags, start, end, min, max,
                reserve_titles, ignore_titles, reserve_descriptions, ignore_descriptions, recorded_format, isDisabled);
        return rule;
    }

}
