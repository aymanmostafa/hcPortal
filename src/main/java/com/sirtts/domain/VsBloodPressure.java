package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A VsBloodPressure.
 */
@Document(collection = "vs_blood_pressure")
public class VsBloodPressure extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @NotNull
    @Field("systolic")
    private Double systolic;

    @NotNull
    @Field("diastolic")
    private Double diastolic;

    @NotNull
    @Field("measurmentdate")
    private LocalDate measurmentdate;

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

    public VsBloodPressure userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getSystolic() {
        return systolic;
    }

    public VsBloodPressure systolic(Double systolic) {
        this.systolic = systolic;
        return this;
    }

    public void setSystolic(Double systolic) {
        this.systolic = systolic;
    }

    public Double getDiastolic() {
        return diastolic;
    }

    public VsBloodPressure diastolic(Double diastolic) {
        this.diastolic = diastolic;
        return this;
    }

    public void setDiastolic(Double diastolic) {
        this.diastolic = diastolic;
    }

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public VsBloodPressure measurmentdate(LocalDate measurmentdate) {
        this.measurmentdate = measurmentdate;
        return this;
    }

    public void setMeasurmentdate(LocalDate measurmentdate) {
        this.measurmentdate = measurmentdate;
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
        VsBloodPressure vsBloodPressure = (VsBloodPressure) o;
        if (vsBloodPressure.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsBloodPressure.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsBloodPressure{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", systolic=" + getSystolic() +
            ", diastolic=" + getDiastolic() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
