package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the MenstrualCycle entity.
 */
public class MenstrualCycleDTO implements Serializable {

    private String id;

    private String userid;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MenstrualCycleDTO menstrualCycleDTO = (MenstrualCycleDTO) o;
        if(menstrualCycleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), menstrualCycleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MenstrualCycleDTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}
