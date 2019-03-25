package im.atzma.model;

import java.util.Objects;

public class ProfileData {
    private String time;
    private String cName;
    private String procedure;

    private final int indexTime;
    private final String chooseLetter;
    private final int indexClient;
    private final int indexServece;
    private final int indexProcedure;

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

    @Override
    public String toString() {
        return "ProfileData{" +
                "time='" + time + '\'' +
                ", cName='" + cName + '\'' +
                ", procedure='" + procedure + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileData that = (ProfileData) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(cName, that.cName) &&
                Objects.equals(procedure, that.procedure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, cName, procedure);
    }

    public ProfileData(int indexTime, String chooseLetter, int indexClient, int indexServece, int indexProcedure) {
        this.indexTime = indexTime;
        this.chooseLetter = chooseLetter;
        this.indexClient = indexClient;
        this.indexServece = indexServece;
        this.indexProcedure = indexProcedure;
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

    public int getIndexServece() {
        return indexServece;
    }

    public int getIndexProcedure() {
        return indexProcedure;
    }
}
