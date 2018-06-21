package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A VsRespiratoryRate.
 */
@Document(collection = "vs_respiratory_rate")
public class VsRespiratoryRate extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @NotNull
    @Field("bpm")
    private Double bpm;

    @NotNull
    @Field("measurmentdate")
    private LocalDateTime measurmentdate;

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

    public VsRespiratoryRate userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getBpm() {
        return bpm;
    }

    public VsRespiratoryRate bpm(Double bpm) {
        this.bpm = bpm;
        return this;
    }

    public void setBpm(Double bpm) {
        this.bpm = bpm;
    }

    public LocalDateTime getMeasurmentdate() {
        return measurmentdate;
    }

    public VsRespiratoryRate measurmentdate(LocalDateTime measurmentdate) {
        this.measurmentdate = measurmentdate;
        return this;
    }

    public void setMeasurmentdate(LocalDateTime measurmentdate) {
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
        VsRespiratoryRate vsRespiratoryRate = (VsRespiratoryRate) o;
        if (vsRespiratoryRate.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsRespiratoryRate.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsRespiratoryRate{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", bpm=" + getBpm() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
