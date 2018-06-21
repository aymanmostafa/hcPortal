package com.sirtts.service.dto;


import java.time.LocalDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the VsRespiratoryRate entity.
 */
public class VsRespiratoryRateDTO implements Serializable {

    private String id;

    private String userid;

    @NotNull
    private Double bpm;

    @NotNull
    private LocalDateTime measurmentdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getBpm() {
        return bpm;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public LocalDateTime getMeasurmentdate() {
        return measurmentdate;
    }

    public void setMeasurmentdate(LocalDateTime measurmentdate) {
        this.measurmentdate = measurmentdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VsRespiratoryRateDTO vsRespiratoryRateDTO = (VsRespiratoryRateDTO) o;
        if(vsRespiratoryRateDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsRespiratoryRateDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsRespiratoryRateDTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", bpm=" + getBpm() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
