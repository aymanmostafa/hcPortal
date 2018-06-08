package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A MenstrualCycle.
 */
@Document(collection = "menstrual_cycle")
public class MenstrualCycle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @NotNull
    @Field("start_date")
    private LocalDate startDate;

    @NotNull
    @Field("end_date")
    private LocalDate endDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public MenstrualCycle userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public MenstrualCycle startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public MenstrualCycle endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenstrualCycle menstrualCycle = (MenstrualCycle) o;
        if (menstrualCycle.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), menstrualCycle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MenstrualCycle{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}
