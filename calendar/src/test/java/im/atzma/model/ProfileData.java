package im.atzma.model;

import java.util.Objects;

public class ProfileData {
    private String time;
    private String cName;
    private String procedure;

    private  int indexTime;
    private  String chooseLetter;
    private  int indexClient;
    private  int indexService;
    private  int indexProcedure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileData that = (ProfileData) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(cName, that.cName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, cName);
    }

    @Override
    public String toString() {
        return "ProfileData{" +
                "time='" + time + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }

    public ProfileData(String time, String cName) {
        this.time = time;
        this.cName = cName;
        this.indexTime = 0;
        this.chooseLetter = null;
        this.indexClient = 0;
        this.indexService = 0;
        this.indexProcedure = 0;
    }

    public ProfileData(int indexTime, String chooseLetter, int indexClient, int indexService, int indexProcedure) {
        this.time = null;
        this.cName = null;
        this.indexTime = indexTime;
        this.chooseLetter = chooseLetter;
        this.indexClient = indexClient;
        this.indexService = indexService;
        this.indexProcedure = indexProcedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcName() {
        return cName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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

    public int getIndexProcedure() {
        return indexProcedure;
    }
}
