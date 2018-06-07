package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the VsSpo2 entity.
 */
public class VsSpo2DTO implements Serializable {

    private String id;

    @NotNull
    private String userid;

    @NotNull
    private Double percent;

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

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
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

        VsSpo2DTO vsSpo2DTO = (VsSpo2DTO) o;
        if(vsSpo2DTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsSpo2DTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsSpo2DTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", percent=" + getPercent() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
