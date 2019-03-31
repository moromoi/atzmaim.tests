package im.atzma.model;

import java.util.Objects;

public class ProfileData {
    private String time;
    private String cName;
    private String procedure;
    private String comment;

    private  int indexTime;
    private  String chooseLetter;
    private  int indexClient;
    private  int indexService;
    private  int indexProcedure;
    private String note;

    public ProfileData(int indexTime, String chooseLetter, int indexClient, int indexService, int indexProcedure, String note) {
        this.time = null;
        this.cName = null;
        this.procedure = null;
        this.comment = null;
        this.indexTime = indexTime;
        this.chooseLetter = chooseLetter;
        this.indexClient = indexClient;
        this.indexService = indexService;
        this.indexProcedure = indexProcedure;
        this.note = note;
    }

    public ProfileData(String time, String cName, String procedure, String comment) {
        this.time = time;
        this.cName = cName;
        this.procedure = procedure;
        this.comment = comment;
        this.indexTime = 0;
        this.chooseLetter = null;
        this.indexClient = 0;
        this.indexService = 0;
        this.indexProcedure = 0;
    }

    public String getComment() { return comment; }
    public String getNote() { return note; }
    public int getIndexTime() {
        return indexTime;
    }
    public String getChooseLetter() {
        return chooseLetter;
    }
    public int getIndexClient() {
        return indexClient;
    }
    public int getIndexService() {
        return indexService;
    }
    public int getIndexProcedure() { return indexProcedure; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileData that = (ProfileData) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(procedure, that.procedure) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, cName, procedure, comment);
    }

    @Override
    public String toString() {
        return "ProfileData{" +
                "time='" + time + '\'' +
                ", cName='" + cName + '\'' +
                ", procedure='" + procedure + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

}
