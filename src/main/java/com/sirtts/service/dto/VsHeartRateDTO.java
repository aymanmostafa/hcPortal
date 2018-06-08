package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the VsHeartRate entity.
 */
public class VsHeartRateDTO implements Serializable {

    private String id;

    private String userid;

    @NotNull
    private Double bpm;

    @NotNull
    private LocalDate measurmentdate;

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

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public void setMeasurmentdate(LocalDate measurmentdate) {
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

        VsHeartRateDTO vsHeartRateDTO = (VsHeartRateDTO) o;
        if(vsHeartRateDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsHeartRateDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsHeartRateDTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", bpm=" + getBpm() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
