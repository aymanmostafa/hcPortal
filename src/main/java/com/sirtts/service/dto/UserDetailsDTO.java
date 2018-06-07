package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import com.sirtts.domain.enumeration.Gender;
import com.sirtts.domain.enumeration.Ethnicity;

/**
 * A DTO for the UserDetails entity.
 */
public class UserDetailsDTO implements Serializable {

    private String id;

    @NotNull
    private Integer userid;

    @Size(max = 20)
    private String activationkey;

    @Size(max = 20)
    private String resetkey;

    private Gender gender;

    private LocalDate birthdate;

    private Ethnicity ethnicity;

    @Size(max = 50)
    private String maritalStatus;

    private Boolean isDoctor;

    private LocalDate resetdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey;
    }

    public String getResetkey() {
        return resetkey;
    }

    public void setResetkey(String resetkey) {
        this.resetkey = resetkey;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean isIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public LocalDate getResetdate() {
        return resetdate;
    }

    public void setResetdate(LocalDate resetdate) {
        this.resetdate = resetdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDetailsDTO userDetailsDTO = (UserDetailsDTO) o;
        if(userDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" +
            "id=" + getId() +
            ", userid=" + getUserid() +
            ", activationkey='" + getActivationkey() + "'" +
            ", resetkey='" + getResetkey() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", ethnicity='" + getEthnicity() + "'" +
            ", maritalStatus='" + getMaritalStatus() + "'" +
            ", isDoctor='" + isIsDoctor() + "'" +
            ", resetdate='" + getResetdate() + "'" +
            "}";
    }
}
