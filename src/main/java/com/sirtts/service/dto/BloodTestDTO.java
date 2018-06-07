package com.sirtts.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the BloodTest entity.
 */
public class BloodTestDTO implements Serializable {

    private String id;

    @NotNull
    private String userid;

    private Double hydroxyprogesterone17;

    private Double hydroxyvitaminD25;

    private Double acetoacetate;

    private Double acidity;

    private Double alcohol;

    private Double ammonia;

    private Double amylase;

    private Double ascorbicAcid;

    private Double bicarbonate;

    private Double bilirubin;

    private Double bloodVolume;

    private Double calcium;

    private Double carbonDioxidePressure;

    private Double carbonMonoxide;

    private Double cD4CellCount;

    private Double ceruloplasmin;

    private Double chloride;

    private Double completeBloodCellCount;

    private Double copper;

    private Double creatineKinase;

    private Double creatineKinaseIsoenzymes;

    private Double creatinine;

    private Double electrolytes;

    private Double erythrocyteSedimentationRate;

    private Double glucose;

    private Double hematocrit;

    private Double hemoglobin;

    private Double iron;

    private Double ironBindingCapacity;

    private Double lactate;

    private Double lacticDehydrogenase;

    private Double lead;

    private Double lipase;

    private Double zinc;

    private Double lipidsCholesterol;

    private Double lipidsTriglycerides;

    private Double magnesium;

    private Double meanCorpuscularHemoglobin;

    private Double meanCorpuscularHemoglobinConcentration;

    private Double meanCorpuscularVolume;

    private Double osmolality;

    private Double oxygenPressure;

    private Double oxygenSaturation;

    private Double phosphataseProstatic;

    private Double phosphatase;

    private Double phosphorus;

    private Double plateletCount;

    private Double potassium;

    private Double prostateSpecificAntigen;

    private Double proteinsTotal;

    private Double proteinsAlbumin;

    private Double proteinsGlobulin;

    private Double prothrombin;

    private Double pyruvicAcid;

    private Double redBloodCellCount;

    private Double sodium;

    private Double thyroidStimulatingHormone;

    private Double transaminaseAlanine;

    private Double transaminaseAspartate;

    private Double ureaNitrogen;

    private Double bUNCreatinineRatio;

    private Double uricAcid;

    private Double vitaminA;

    private Double wBC;

    private Double whiteBloodCellCount;

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

    public Double getHydroxyprogesterone17() {
        return hydroxyprogesterone17;
    }

    public void setHydroxyprogesterone17(Double hydroxyprogesterone17) {
        this.hydroxyprogesterone17 = hydroxyprogesterone17;
    }

    public Double getHydroxyvitaminD25() {
        return hydroxyvitaminD25;
    }

    public void setHydroxyvitaminD25(Double hydroxyvitaminD25) {
        this.hydroxyvitaminD25 = hydroxyvitaminD25;
    }

    public Double getAcetoacetate() {
        return acetoacetate;
    }

    public void setAcetoacetate(Double acetoacetate) {
        this.acetoacetate = acetoacetate;
    }

    public Double getAcidity() {
        return acidity;
    }

    public void setAcidity(Double acidity) {
        this.acidity = acidity;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public Double getAmmonia() {
        return ammonia;
    }

    public void setAmmonia(Double ammonia) {
        this.ammonia = ammonia;
    }

    public Double getAmylase() {
        return amylase;
    }

    public void setAmylase(Double amylase) {
        this.amylase = amylase;
    }

    public Double getAscorbicAcid() {
        return ascorbicAcid;
    }

    public void setAscorbicAcid(Double ascorbicAcid) {
        this.ascorbicAcid = ascorbicAcid;
    }

    public Double getBicarbonate() {
        return bicarbonate;
    }

    public void setBicarbonate(Double bicarbonate) {
        this.bicarbonate = bicarbonate;
    }

    public Double getBilirubin() {
        return bilirubin;
    }

    public void setBilirubin(Double bilirubin) {
        this.bilirubin = bilirubin;
    }

    public Double getBloodVolume() {
        return bloodVolume;
    }

    public void setBloodVolume(Double bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getCarbonDioxidePressure() {
        return carbonDioxidePressure;
    }

    public void setCarbonDioxidePressure(Double carbonDioxidePressure) {
        this.carbonDioxidePressure = carbonDioxidePressure;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getcD4CellCount() {
        return cD4CellCount;
    }

    public void setcD4CellCount(Double cD4CellCount) {
        this.cD4CellCount = cD4CellCount;
    }

    public Double getCeruloplasmin() {
        return ceruloplasmin;
    }

    public void setCeruloplasmin(Double ceruloplasmin) {
        this.ceruloplasmin = ceruloplasmin;
    }

    public Double getChloride() {
        return chloride;
    }

    public void setChloride(Double chloride) {
        this.chloride = chloride;
    }

    public Double getCompleteBloodCellCount() {
        return completeBloodCellCount;
    }

    public void setCompleteBloodCellCount(Double completeBloodCellCount) {
        this.completeBloodCellCount = completeBloodCellCount;
    }

    public Double getCopper() {
        return copper;
    }

    public void setCopper(Double copper) {
        this.copper = copper;
    }

    public Double getCreatineKinase() {
        return creatineKinase;
    }

    public void setCreatineKinase(Double creatineKinase) {
        this.creatineKinase = creatineKinase;
    }

    public Double getCreatineKinaseIsoenzymes() {
        return creatineKinaseIsoenzymes;
    }

    public void setCreatineKinaseIsoenzymes(Double creatineKinaseIsoenzymes) {
        this.creatineKinaseIsoenzymes = creatineKinaseIsoenzymes;
    }

    public Double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(Double creatinine) {
        this.creatinine = creatinine;
    }

    public Double getElectrolytes() {
        return electrolytes;
    }

    public void setElectrolytes(Double electrolytes) {
        this.electrolytes = electrolytes;
    }

    public Double getErythrocyteSedimentationRate() {
        return erythrocyteSedimentationRate;
    }

    public void setErythrocyteSedimentationRate(Double erythrocyteSedimentationRate) {
        this.erythrocyteSedimentationRate = erythrocyteSedimentationRate;
    }

    public Double getGlucose() {
        return glucose;
    }

    public void setGlucose(Double glucose) {
        this.glucose = glucose;
    }

    public Double getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(Double hematocrit) {
        this.hematocrit = hematocrit;
    }

    public Double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getIronBindingCapacity() {
        return ironBindingCapacity;
    }

    public void setIronBindingCapacity(Double ironBindingCapacity) {
        this.ironBindingCapacity = ironBindingCapacity;
    }

    public Double getLactate() {
        return lactate;
    }

    public void setLactate(Double lactate) {
        this.lactate = lactate;
    }

    public Double getLacticDehydrogenase() {
        return lacticDehydrogenase;
    }

    public void setLacticDehydrogenase(Double lacticDehydrogenase) {
        this.lacticDehydrogenase = lacticDehydrogenase;
    }

    public Double getLead() {
        return lead;
    }

    public void setLead(Double lead) {
        this.lead = lead;
    }

    public Double getLipase() {
        return lipase;
    }

    public void setLipase(Double lipase) {
        this.lipase = lipase;
    }

    public Double getZinc() {
        return zinc;
    }

    public void setZinc(Double zinc) {
        this.zinc = zinc;
    }

    public Double getLipidsCholesterol() {
        return lipidsCholesterol;
    }

    public void setLipidsCholesterol(Double lipidsCholesterol) {
        this.lipidsCholesterol = lipidsCholesterol;
    }

    public Double getLipidsTriglycerides() {
        return lipidsTriglycerides;
    }

    public void setLipidsTriglycerides(Double lipidsTriglycerides) {
        this.lipidsTriglycerides = lipidsTriglycerides;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getMeanCorpuscularHemoglobin() {
        return meanCorpuscularHemoglobin;
    }

    public void setMeanCorpuscularHemoglobin(Double meanCorpuscularHemoglobin) {
        this.meanCorpuscularHemoglobin = meanCorpuscularHemoglobin;
    }

    public Double getMeanCorpuscularHemoglobinConcentration() {
        return meanCorpuscularHemoglobinConcentration;
    }

    public void setMeanCorpuscularHemoglobinConcentration(Double meanCorpuscularHemoglobinConcentration) {
        this.meanCorpuscularHemoglobinConcentration = meanCorpuscularHemoglobinConcentration;
    }

    public Double getMeanCorpuscularVolume() {
        return meanCorpuscularVolume;
    }

    public void setMeanCorpuscularVolume(Double meanCorpuscularVolume) {
        this.meanCorpuscularVolume = meanCorpuscularVolume;
    }

    public Double getOsmolality() {
        return osmolality;
    }

    public void setOsmolality(Double osmolality) {
        this.osmolality = osmolality;
    }

    public Double getOxygenPressure() {
        return oxygenPressure;
    }

    public void setOxygenPressure(Double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public Double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(Double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Double getPhosphataseProstatic() {
        return phosphataseProstatic;
    }

    public void setPhosphataseProstatic(Double phosphataseProstatic) {
        this.phosphataseProstatic = phosphataseProstatic;
    }

    public Double getPhosphatase() {
        return phosphatase;
    }

    public void setPhosphatase(Double phosphatase) {
        this.phosphatase = phosphatase;
    }

    public Double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Double getPlateletCount() {
        return plateletCount;
    }

    public void setPlateletCount(Double plateletCount) {
        this.plateletCount = plateletCount;
    }

    public Double getPotassium() {
        return potassium;
    }

    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    public Double getProstateSpecificAntigen() {
        return prostateSpecificAntigen;
    }

    public void setProstateSpecificAntigen(Double prostateSpecificAntigen) {
        this.prostateSpecificAntigen = prostateSpecificAntigen;
    }

    public Double getProteinsTotal() {
        return proteinsTotal;
    }

    public void setProteinsTotal(Double proteinsTotal) {
        this.proteinsTotal = proteinsTotal;
    }

    public Double getProteinsAlbumin() {
        return proteinsAlbumin;
    }

    public void setProteinsAlbumin(Double proteinsAlbumin) {
        this.proteinsAlbumin = proteinsAlbumin;
    }

    public Double getProteinsGlobulin() {
        return proteinsGlobulin;
    }

    public void setProteinsGlobulin(Double proteinsGlobulin) {
        this.proteinsGlobulin = proteinsGlobulin;
    }

    public Double getProthrombin() {
        return prothrombin;
    }

    public void setProthrombin(Double prothrombin) {
        this.prothrombin = prothrombin;
    }

    public Double getPyruvicAcid() {
        return pyruvicAcid;
    }

    public void setPyruvicAcid(Double pyruvicAcid) {
        this.pyruvicAcid = pyruvicAcid;
    }

    public Double getRedBloodCellCount() {
        return redBloodCellCount;
    }

    public void setRedBloodCellCount(Double redBloodCellCount) {
        this.redBloodCellCount = redBloodCellCount;
    }

    public Double getSodium() {
        return sodium;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public Double getThyroidStimulatingHormone() {
        return thyroidStimulatingHormone;
    }

    public void setThyroidStimulatingHormone(Double thyroidStimulatingHormone) {
        this.thyroidStimulatingHormone = thyroidStimulatingHormone;
    }

    public Double getTransaminaseAlanine() {
        return transaminaseAlanine;
    }

    public void setTransaminaseAlanine(Double transaminaseAlanine) {
        this.transaminaseAlanine = transaminaseAlanine;
    }

    public Double getTransaminaseAspartate() {
        return transaminaseAspartate;
    }

    public void setTransaminaseAspartate(Double transaminaseAspartate) {
        this.transaminaseAspartate = transaminaseAspartate;
    }

    public Double getUreaNitrogen() {
        return ureaNitrogen;
    }

    public void setUreaNitrogen(Double ureaNitrogen) {
        this.ureaNitrogen = ureaNitrogen;
    }

    public Double getbUNCreatinineRatio() {
        return bUNCreatinineRatio;
    }

    public void setbUNCreatinineRatio(Double bUNCreatinineRatio) {
        this.bUNCreatinineRatio = bUNCreatinineRatio;
    }

    public Double getUricAcid() {
        return uricAcid;
    }

    public void setUricAcid(Double uricAcid) {
        this.uricAcid = uricAcid;
    }

    public Double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(Double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public Double getwBC() {
        return wBC;
    }

    public void setwBC(Double wBC) {
        this.wBC = wBC;
    }

    public Double getWhiteBloodCellCount() {
        return whiteBloodCellCount;
    }

    public void setWhiteBloodCellCount(Double whiteBloodCellCount) {
        this.whiteBloodCellCount = whiteBloodCellCount;
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

        BloodTestDTO bloodTestDTO = (BloodTestDTO) o;
        if(bloodTestDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bloodTestDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BloodTestDTO{" +
            "id=" + getId() +
            ", userid='" + getUserid() + "'" +
            ", hydroxyprogesterone17=" + getHydroxyprogesterone17() +
            ", hydroxyvitaminD25=" + getHydroxyvitaminD25() +
            ", acetoacetate=" + getAcetoacetate() +
            ", acidity=" + getAcidity() +
            ", alcohol=" + getAlcohol() +
            ", ammonia=" + getAmmonia() +
            ", amylase=" + getAmylase() +
            ", ascorbicAcid=" + getAscorbicAcid() +
            ", bicarbonate=" + getBicarbonate() +
            ", bilirubin=" + getBilirubin() +
            ", bloodVolume=" + getBloodVolume() +
            ", calcium=" + getCalcium() +
            ", carbonDioxidePressure=" + getCarbonDioxidePressure() +
            ", carbonMonoxide=" + getCarbonMonoxide() +
            ", cD4CellCount=" + getcD4CellCount() +
            ", ceruloplasmin=" + getCeruloplasmin() +
            ", chloride=" + getChloride() +
            ", completeBloodCellCount=" + getCompleteBloodCellCount() +
            ", copper=" + getCopper() +
            ", creatineKinase=" + getCreatineKinase() +
            ", creatineKinaseIsoenzymes=" + getCreatineKinaseIsoenzymes() +
            ", creatinine=" + getCreatinine() +
            ", electrolytes=" + getElectrolytes() +
            ", erythrocyteSedimentationRate=" + getErythrocyteSedimentationRate() +
            ", glucose=" + getGlucose() +
            ", hematocrit=" + getHematocrit() +
            ", hemoglobin=" + getHemoglobin() +
            ", iron=" + getIron() +
            ", ironBindingCapacity=" + getIronBindingCapacity() +
            ", lactate=" + getLactate() +
            ", lacticDehydrogenase=" + getLacticDehydrogenase() +
            ", lead=" + getLead() +
            ", lipase=" + getLipase() +
            ", zinc=" + getZinc() +
            ", lipidsCholesterol=" + getLipidsCholesterol() +
            ", lipidsTriglycerides=" + getLipidsTriglycerides() +
            ", magnesium=" + getMagnesium() +
            ", meanCorpuscularHemoglobin=" + getMeanCorpuscularHemoglobin() +
            ", meanCorpuscularHemoglobinConcentration=" + getMeanCorpuscularHemoglobinConcentration() +
            ", meanCorpuscularVolume=" + getMeanCorpuscularVolume() +
            ", osmolality=" + getOsmolality() +
            ", oxygenPressure=" + getOxygenPressure() +
            ", oxygenSaturation=" + getOxygenSaturation() +
            ", phosphataseProstatic=" + getPhosphataseProstatic() +
            ", phosphatase=" + getPhosphatase() +
            ", phosphorus=" + getPhosphorus() +
            ", plateletCount=" + getPlateletCount() +
            ", potassium=" + getPotassium() +
            ", prostateSpecificAntigen=" + getProstateSpecificAntigen() +
            ", proteinsTotal=" + getProteinsTotal() +
            ", proteinsAlbumin=" + getProteinsAlbumin() +
            ", proteinsGlobulin=" + getProteinsGlobulin() +
            ", prothrombin=" + getProthrombin() +
            ", pyruvicAcid=" + getPyruvicAcid() +
            ", redBloodCellCount=" + getRedBloodCellCount() +
            ", sodium=" + getSodium() +
            ", thyroidStimulatingHormone=" + getThyroidStimulatingHormone() +
            ", transaminaseAlanine=" + getTransaminaseAlanine() +
            ", transaminaseAspartate=" + getTransaminaseAspartate() +
            ", ureaNitrogen=" + getUreaNitrogen() +
            ", bUNCreatinineRatio=" + getbUNCreatinineRatio() +
            ", uricAcid=" + getUricAcid() +
            ", vitaminA=" + getVitaminA() +
            ", wBC=" + getwBC() +
            ", whiteBloodCellCount=" + getWhiteBloodCellCount() +
            ", measurmentdate='" + getMeasurmentdate() + "'" +
            "}";
    }
}
