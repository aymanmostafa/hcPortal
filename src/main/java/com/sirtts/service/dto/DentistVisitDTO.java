package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DentistVisit entity.
 */
public class DentistVisitDTO implements Serializable {

    private String id;

    @NotNull
    private String userid;

    private Boolean teethcleaning;

    private Boolean whitening;

    private Boolean restoration;

    private Boolean crowns;

    private Boolean bridges;

    private Boolean braces;

    private Boolean endodontictherapy;

    private Boolean periodontaltherapy;

    private Boolean extraction;

    private Boolean oralsurgery;

    private String notes;

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

    public Boolean isTeethcleaning() {
        return teethcleaning;
    }

    public void setTeethcleaning(Boolean teethcleaning) {
        this.teethcleaning = teethcleaning;
    }

    public Boolean isWhitening() {
        return whitening;
    }

    public void setWhitening(Boolean whitening) {
        this.whitening = whitening;
    }

    public Boolean isRestoration() {
        return restoration;
    }

    public void setRestoration(Boolean restoration) {
        this.restoration = restoration;
    }

    public Boolean isCrowns() {
        return crowns;
    }

    public void setCrowns(Boolean crowns) {
        this.crowns = crowns;
    }

    public Boolean isBridges() {
        return bridges;
    }

    public void setBridges(Boolean bridges) {
        this.bridges = bridges;
    }

    public Boolean isBraces() {
        return braces;
    }

    public void setBraces(Boolean braces) {
        this.braces = braces;
    }

    public Boolean isEndodontictherapy() {
        return endodontictherapy;
    }

    public void setEndodontictherapy(Boolean endodontictherapy) {
        this.endodontictherapy = endodontictherapy;
    }

    public Boolean isPeriodontaltherapy() {
        return periodontaltherapy;
    }

    public void setPeriodontaltherapy(Boolean periodontaltherapy) {
        this.periodontaltherapy = periodontaltherapy;
    }

    public Boolean isExtraction() {
        return extraction;
    }

    public void setExtraction(Boolean extraction) {
        this.extraction = extraction;
    }

    public Boolean isOralsurgery() {
        return oralsurgery;
    }

    public void setOralsurgery(Boolean oralsurgery) {
        this.oralsurgery = oralsurgery;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

        DentistVisitDTO dentistVisitDTO = (DentistVisitDTO) o;
        if(dentistVisitDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dentistVisitDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DentistVisitDTO{" +
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
