package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.sirtts.domain.enumeration.Gender;

import com.sirtts.domain.enumeration.Ethnicity;

/**
 * A UserDetails.
 */
@Document(collection = "user_details")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("userid")
    private Integer userid;

    @Size(max = 20)
    @Field("activationkey")
    private String activationkey;

    @Size(max = 20)
    @Field("resetkey")
    private String resetkey;

    @Field("gender")
    private Gender gender;

    @Field("birthdate")
    private LocalDate birthdate;

    @Field("ethnicity")
    private Ethnicity ethnicity;

    @Size(max = 50)
    @Field("marital_status")
    private String maritalStatus;

    @Field("is_doctor")
    private Boolean isDoctor;

    @Field("resetdate")
    private LocalDate resetdate;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public UserDetails userid(Integer userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public UserDetails activationkey(String activationkey) {
        this.activationkey = activationkey;
        return this;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey;
    }

    public String getResetkey() {
        return resetkey;
    }

    public UserDetails resetkey(String resetkey) {
        this.resetkey = resetkey;
        return this;
    }

    public void setResetkey(String resetkey) {
        this.resetkey = resetkey;
    }

    public Gender getGender() {
        return gender;
    }

    public UserDetails gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public UserDetails birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public UserDetails ethnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public UserDetails maritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean isIsDoctor() {
        return isDoctor;
    }

    public UserDetails isDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
        return this;
    }

    public void setIsDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public LocalDate getResetdate() {
        return resetdate;
    }

    public UserDetails resetdate(LocalDate resetdate) {
        this.resetdate = resetdate;
        return this;
    }

    public void setResetdate(LocalDate resetdate) {
        this.resetdate = resetdate;
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
        UserDetails userDetails = (UserDetails) o;
        if (userDetails.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userDetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserDetails{" +
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
