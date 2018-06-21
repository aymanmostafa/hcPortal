package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A VsBodyTemperature.
 */
@Document(collection = "vs_body_temperature")
public class VsBodyTemperature extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @NotNull
    @Field("celsius")
    private Double celsius;

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

    public VsBodyTemperature userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getCelsius() {
        return celsius;
    }

    public VsBodyTemperature celsius(Double celsius) {
        this.celsius = celsius;
        return this;
    }

    public void setCelsius(Double celsius) {
        this.celsius = celsius;
    }

    public LocalDateTime getMeasurmentdate() {
        return measurmentdate;
    }

    public VsBodyTemperature measurmentdate(LocalDateTime measurmentdate) {
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
        VsBodyTemperature vsBodyTemperature = (VsBodyTemperature) o;
        if (vsBodyTemperature.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsBodyTemperature.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsBodyTemperature{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", celsius=" + getCelsius() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
