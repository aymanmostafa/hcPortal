package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DentistNextVisit.
 */
@Document(collection = "dentist_next_visit")
public class DentistNextVisit extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

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

    public DentistNextVisit userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public DentistNextVisit measurmentdate(LocalDate measurmentdate) {
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
        DentistNextVisit dentistNextVisit = (DentistNextVisit) o;
        if (dentistNextVisit.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dentistNextVisit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DentistNextVisit{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
