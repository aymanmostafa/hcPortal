package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A VsHeartRate.
 */
@Document(collection = "vs_heart_rate")
public class VsHeartRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("userid")
    private String userid;

    @NotNull
    @Field("bpm")
    private Double bpm;

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

    public VsHeartRate userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getBpm() {
        return bpm;
    }

    public VsHeartRate bpm(Double bpm) {
        this.bpm = bpm;
        return this;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public VsHeartRate measurmentdate(LocalDate measurmentdate) {
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
        VsHeartRate vsHeartRate = (VsHeartRate) o;
        if (vsHeartRate.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsHeartRate.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsHeartRate{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", bpm=" + getBpm() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
