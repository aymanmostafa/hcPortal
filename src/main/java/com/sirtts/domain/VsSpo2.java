package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A VsSpo2.
 */
@Document(collection = "vs_spo_2")
public class VsSpo2 extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @NotNull
    @Field("percent")
    private Double percent;

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

    public VsSpo2 userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getPercent() {
        return percent;
    }

    public VsSpo2 percent(Double percent) {
        this.percent = percent;
        return this;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public VsSpo2 measurmentdate(LocalDate measurmentdate) {
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
        VsSpo2 vsSpo2 = (VsSpo2) o;
        if (vsSpo2.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vsSpo2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VsSpo2{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", percent=" + getPercent() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
