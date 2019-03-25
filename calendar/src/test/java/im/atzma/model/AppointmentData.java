package im.atzma.model;

import java.util.Objects;

public class AppointmentData {
    private String comment;
    private String clientName;

    public AppointmentData(String comment, String clientName) {
        this.clientName = clientName;
        this.comment = comment;
    }

    public String getClientName() {
        return clientName;
    }

    public String getComment() {

        return comment;
    }

    @Override
    public String toString() {
        return "AppointmentData{" +
                "comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentData that = (AppointmentData) o;
        return Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
