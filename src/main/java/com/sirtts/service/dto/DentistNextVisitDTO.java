package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DentistNextVisit entity.
 */
public class DentistNextVisitDTO implements Serializable {

    private String id;

    @NotNull
    private String userid;

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

        DentistNextVisitDTO dentistNextVisitDTO = (DentistNextVisitDTO) o;
        if(dentistNextVisitDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dentistNextVisitDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DentistNextVisitDTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
