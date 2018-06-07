package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DentistVisit.
 */
@Document(collection = "dentist_visit")
public class DentistVisit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("userid")
    private String userid;

    @Field("teethcleaning")
    private Boolean teethcleaning;

    @Field("whitening")
    private Boolean whitening;

    @Field("restoration")
    private Boolean restoration;

    @Field("crowns")
    private Boolean crowns;

    @Field("bridges")
    private Boolean bridges;

    @Field("braces")
    private Boolean braces;

    @Field("endodontictherapy")
    private Boolean endodontictherapy;

    @Field("periodontaltherapy")
    private Boolean periodontaltherapy;

    @Field("extraction")
    private Boolean extraction;

    @Field("oralsurgery")
    private Boolean oralsurgery;

    @Field("notes")
    private String notes;

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

    public DentistVisit userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Boolean isTeethcleaning() {
        return teethcleaning;
    }

    public DentistVisit teethcleaning(Boolean teethcleaning) {
        this.teethcleaning = teethcleaning;
        return this;
    }

    public void setTeethcleaning(Boolean teethcleaning) {
        this.teethcleaning = teethcleaning;
    }

    public Boolean isWhitening() {
        return whitening;
    }

    public DentistVisit whitening(Boolean whitening) {
        this.whitening = whitening;
        return this;
    }

    public void setWhitening(Boolean whitening) {
        this.whitening = whitening;
    }

    public Boolean isRestoration() {
        return restoration;
    }

    public DentistVisit restoration(Boolean restoration) {
        this.restoration = restoration;
        return this;
    }

    public void setRestoration(Boolean restoration) {
        this.restoration = restoration;
    }

    public Boolean isCrowns() {
        return crowns;
    }

    public DentistVisit crowns(Boolean crowns) {
        this.crowns = crowns;
        return this;
    }

    public void setCrowns(Boolean crowns) {
        this.crowns = crowns;
    }

    public Boolean isBridges() {
        return bridges;
    }

    public DentistVisit bridges(Boolean bridges) {
        this.bridges = bridges;
        return this;
    }

    public void setBridges(Boolean bridges) {
        this.bridges = bridges;
    }

    public Boolean isBraces() {
        return braces;
    }

    public DentistVisit braces(Boolean braces) {
        this.braces = braces;
        return this;
    }

    public void setBraces(Boolean braces) {
        this.braces = braces;
    }

    public Boolean isEndodontictherapy() {
        return endodontictherapy;
    }

    public DentistVisit endodontictherapy(Boolean endodontictherapy) {
        this.endodontictherapy = endodontictherapy;
        return this;
    }

    public void setEndodontictherapy(Boolean endodontictherapy) {
        this.endodontictherapy = endodontictherapy;
    }

    public Boolean isPeriodontaltherapy() {
        return periodontaltherapy;
    }

    public DentistVisit periodontaltherapy(Boolean periodontaltherapy) {
        this.periodontaltherapy = periodontaltherapy;
        return this;
    }

    public void setPeriodontaltherapy(Boolean periodontaltherapy) {
        this.periodontaltherapy = periodontaltherapy;
    }

    public Boolean isExtraction() {
        return extraction;
    }

    public DentistVisit extraction(Boolean extraction) {
        this.extraction = extraction;
        return this;
    }

    public void setExtraction(Boolean extraction) {
        this.extraction = extraction;
    }

    public Boolean isOralsurgery() {
        return oralsurgery;
    }

    public DentistVisit oralsurgery(Boolean oralsurgery) {
        this.oralsurgery = oralsurgery;
        return this;
    }

    public void setOralsurgery(Boolean oralsurgery) {
        this.oralsurgery = oralsurgery;
    }

    public String getNotes() {
        return notes;
    }

    public DentistVisit notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getMeasurmentdate() {
        return measurmentdate;
    }

    public DentistVisit measurmentdate(LocalDate measurmentdate) {
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
        DentistVisit dentistVisit = (DentistVisit) o;
        if (dentistVisit.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dentistVisit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DentistVisit{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", teethcleaning='" + isTeethcleaning() + "'" +
            ", whitening='" + isWhitening() + "'" +
            ", restoration='" + isRestoration() + "'" +
            ", crowns='" + isCrowns() + "'" +
            ", bridges='" + isBridges() + "'" +
            ", braces='" + isBraces() + "'" +
            ", endodontictherapy='" + isEndodontictherapy() + "'" +
            ", periodontaltherapy='" + isPeriodontaltherapy() + "'" +
            ", extraction='" + isExtraction() + "'" +
            ", oralsurgery='" + isOralsurgery() + "'" +
            ", notes='" + getNotes() + "'" +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
