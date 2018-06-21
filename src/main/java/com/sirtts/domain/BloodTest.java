package com.sirtts.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A BloodTest.
 */
@Document(collection = "blood_test")
public class BloodTest extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("userid")
    private String userid;

    @Field("hydroxyprogesterone_17")
    private Double hydroxyprogesterone17;

    @Field("hydroxyvitamin_d_25")
    private Double hydroxyvitaminD25;

    @Field("acetoacetate")
    private Double acetoacetate;

    @Field("acidity")
    private Double acidity;

    @Field("alcohol")
    private Double alcohol;

    @Field("ammonia")
    private Double ammonia;

    @Field("amylase")
    private Double amylase;

    @Field("ascorbic_acid")
    private Double ascorbicAcid;

    @Field("bicarbonate")
    private Double bicarbonate;

    @Field("bilirubin")
    private Double bilirubin;

    @Field("blood_volume")
    private Double bloodVolume;

    @Field("calcium")
    private Double calcium;

    @Field("carbon_dioxide_pressure")
    private Double carbonDioxidePressure;

    @Field("carbon_monoxide")
    private Double carbonMonoxide;

    @Field("c_d_4_cell_count")
    private Double cD4CellCount;

    @Field("ceruloplasmin")
    private Double ceruloplasmin;

    @Field("chloride")
    private Double chloride;

    @Field("complete_blood_cell_count")
    private Double completeBloodCellCount;

    @Field("copper")
    private Double copper;

    @Field("creatine_kinase")
    private Double creatineKinase;

    @Field("creatine_kinase_isoenzymes")
    private Double creatineKinaseIsoenzymes;

    @Field("creatinine")
    private Double creatinine;

    @Field("electrolytes")
    private Double electrolytes;

    @Field("erythrocyte_sedimentation_rate")
    private Double erythrocyteSedimentationRate;

    @Field("glucose")
    private Double glucose;

    @Field("hematocrit")
    private Double hematocrit;

    @Field("hemoglobin")
    private Double hemoglobin;

    @Field("iron")
    private Double iron;

    @Field("iron_binding_capacity")
    private Double ironBindingCapacity;

    @Field("lactate")
    private Double lactate;

    @Field("lactic_dehydrogenase")
    private Double lacticDehydrogenase;

    @Field("lead")
    private Double lead;

    @Field("lipase")
    private Double lipase;

    @Field("zinc")
    private Double zinc;

    @Field("lipids_cholesterol")
    private Double lipidsCholesterol;

    @Field("lipids_triglycerides")
    private Double lipidsTriglycerides;

    @Field("magnesium")
    private Double magnesium;

    @Field("mean_corpuscular_hemoglobin")
    private Double meanCorpuscularHemoglobin;

    @Field("mean_corpuscular_hemoglobin_concentration")
    private Double meanCorpuscularHemoglobinConcentration;

    @Field("mean_corpuscular_volume")
    private Double meanCorpuscularVolume;

    @Field("osmolality")
    private Double osmolality;

    @Field("oxygen_pressure")
    private Double oxygenPressure;

    @Field("oxygen_saturation")
    private Double oxygenSaturation;

    @Field("phosphatase_prostatic")
    private Double phosphataseProstatic;

    @Field("phosphatase")
    private Double phosphatase;

    @Field("phosphorus")
    private Double phosphorus;

    @Field("platelet_count")
    private Double plateletCount;

    @Field("potassium")
    private Double potassium;

    @Field("prostate_specific_antigen")
    private Double prostateSpecificAntigen;

    @Field("proteins_total")
    private Double proteinsTotal;

    @Field("proteins_albumin")
    private Double proteinsAlbumin;

    @Field("proteins_globulin")
    private Double proteinsGlobulin;

    @Field("prothrombin")
    private Double prothrombin;

    @Field("pyruvic_acid")
    private Double pyruvicAcid;

    @Field("red_blood_cell_count")
    private Double redBloodCellCount;

    @Field("sodium")
    private Double sodium;

    @Field("thyroid_stimulating_hormone")
    private Double thyroidStimulatingHormone;

    @Field("transaminase_alanine")
    private Double transaminaseAlanine;

    @Field("transaminase_aspartate")
    private Double transaminaseAspartate;

    @Field("urea_nitrogen")
    private Double ureaNitrogen;

    @Field("b_un_creatinine_ratio")
    private Double bUNCreatinineRatio;

    @Field("uric_acid")
    private Double uricAcid;

    @Field("vitamin_a")
    private Double vitaminA;

    @Field("w_bc")
    private Double wBC;

    @Field("white_blood_cell_count")
    private Double whiteBloodCellCount;

    @NotNull
    @Field("measurmentdate")
    private ZonedDateTime measurmentdate;

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

    public BloodTest userid(String userid) {
        this.userid = userid;
        return this;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getHydroxyprogesterone17() {
        return hydroxyprogesterone17;
    }

    public BloodTest hydroxyprogesterone17(Double hydroxyprogesterone17) {
        this.hydroxyprogesterone17 = hydroxyprogesterone17;
        return this;
    }

    public void setHydroxyprogesterone17(Double hydroxyprogesterone17) {
        this.hydroxyprogesterone17 = hydroxyprogesterone17;
    }

    public Double getHydroxyvitaminD25() {
        return hydroxyvitaminD25;
    }

    public BloodTest hydroxyvitaminD25(Double hydroxyvitaminD25) {
        this.hydroxyvitaminD25 = hydroxyvitaminD25;
        return this;
    }

    public void setHydroxyvitaminD25(Double hydroxyvitaminD25) {
        this.hydroxyvitaminD25 = hydroxyvitaminD25;
    }

    public Double getAcetoacetate() {
        return acetoacetate;
    }

    public BloodTest acetoacetate(Double acetoacetate) {
        this.acetoacetate = acetoacetate;
        return this;
    }

    public void setAcetoacetate(Double acetoacetate) {
        this.acetoacetate = acetoacetate;
    }

    public Double getAcidity() {
        return acidity;
    }

    public BloodTest acidity(Double acidity) {
        this.acidity = acidity;
        return this;
    }

    public void setAcidity(Double acidity) {
        this.acidity = acidity;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public BloodTest alcohol(Double alcohol) {
        this.alcohol = alcohol;
        return this;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    public Double getAmmonia() {
        return ammonia;
    }

    public BloodTest ammonia(Double ammonia) {
        this.ammonia = ammonia;
        return this;
    }

    public void setAmmonia(Double ammonia) {
        this.ammonia = ammonia;
    }

    public Double getAmylase() {
        return amylase;
    }

    public BloodTest amylase(Double amylase) {
        this.amylase = amylase;
        return this;
    }

    public void setAmylase(Double amylase) {
        this.amylase = amylase;
    }

    public Double getAscorbicAcid() {
        return ascorbicAcid;
    }

    public BloodTest ascorbicAcid(Double ascorbicAcid) {
        this.ascorbicAcid = ascorbicAcid;
        return this;
    }

    public void setAscorbicAcid(Double ascorbicAcid) {
        this.ascorbicAcid = ascorbicAcid;
    }

    public Double getBicarbonate() {
        return bicarbonate;
    }

    public BloodTest bicarbonate(Double bicarbonate) {
        this.bicarbonate = bicarbonate;
        return this;
    }

    public void setBicarbonate(Double bicarbonate) {
        this.bicarbonate = bicarbonate;
    }

    public Double getBilirubin() {
        return bilirubin;
    }

    public BloodTest bilirubin(Double bilirubin) {
        this.bilirubin = bilirubin;
        return this;
    }

    public void setBilirubin(Double bilirubin) {
        this.bilirubin = bilirubin;
    }

    public Double getBloodVolume() {
        return bloodVolume;
    }

    public BloodTest bloodVolume(Double bloodVolume) {
        this.bloodVolume = bloodVolume;
        return this;
    }

    public void setBloodVolume(Double bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public Double getCalcium() {
        return calcium;
    }

    public BloodTest calcium(Double calcium) {
        this.calcium = calcium;
        return this;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getCarbonDioxidePressure() {
        return carbonDioxidePressure;
    }

    public BloodTest carbonDioxidePressure(Double carbonDioxidePressure) {
        this.carbonDioxidePressure = carbonDioxidePressure;
        return this;
    }

    public void setCarbonDioxidePressure(Double carbonDioxidePressure) {
        this.carbonDioxidePressure = carbonDioxidePressure;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public BloodTest carbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
        return this;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getcD4CellCount() {
        return cD4CellCount;
    }

    public BloodTest cD4CellCount(Double cD4CellCount) {
        this.cD4CellCount = cD4CellCount;
        return this;
    }

    public void setcD4CellCount(Double cD4CellCount) {
        this.cD4CellCount = cD4CellCount;
    }

    public Double getCeruloplasmin() {
        return ceruloplasmin;
    }

    public BloodTest ceruloplasmin(Double ceruloplasmin) {
        this.ceruloplasmin = ceruloplasmin;
        return this;
    }

    public void setCeruloplasmin(Double ceruloplasmin) {
        this.ceruloplasmin = ceruloplasmin;
    }

    public Double getChloride() {
        return chloride;
    }

    public BloodTest chloride(Double chloride) {
        this.chloride = chloride;
        return this;
    }

    public void setChloride(Double chloride) {
        this.chloride = chloride;
    }

    public Double getCompleteBloodCellCount() {
        return completeBloodCellCount;
    }

    public BloodTest completeBloodCellCount(Double completeBloodCellCount) {
        this.completeBloodCellCount = completeBloodCellCount;
        return this;
    }

    public void setCompleteBloodCellCount(Double completeBloodCellCount) {
        this.completeBloodCellCount = completeBloodCellCount;
    }

    public Double getCopper() {
        return copper;
    }

    public BloodTest copper(Double copper) {
        this.copper = copper;
        return this;
    }

    public void setCopper(Double copper) {
        this.copper = copper;
    }

    public Double getCreatineKinase() {
        return creatineKinase;
    }

    public BloodTest creatineKinase(Double creatineKinase) {
        this.creatineKinase = creatineKinase;
        return this;
    }

    public void setCreatineKinase(Double creatineKinase) {
        this.creatineKinase = creatineKinase;
    }

    public Double getCreatineKinaseIsoenzymes() {
        return creatineKinaseIsoenzymes;
    }

    public BloodTest creatineKinaseIsoenzymes(Double creatineKinaseIsoenzymes) {
        this.creatineKinaseIsoenzymes = creatineKinaseIsoenzymes;
        return this;
    }

    public void setCreatineKinaseIsoenzymes(Double creatineKinaseIsoenzymes) {
        this.creatineKinaseIsoenzymes = creatineKinaseIsoenzymes;
    }

    public Double getCreatinine() {
        return creatinine;
    }

    public BloodTest creatinine(Double creatinine) {
        this.creatinine = creatinine;
        return this;
    }

    public void setCreatinine(Double creatinine) {
        this.creatinine = creatinine;
    }

    public Double getElectrolytes() {
        return electrolytes;
    }

    public BloodTest electrolytes(Double electrolytes) {
        this.electrolytes = electrolytes;
        return this;
    }

    public void setElectrolytes(Double electrolytes) {
        this.electrolytes = electrolytes;
    }

    public Double getErythrocyteSedimentationRate() {
        return erythrocyteSedimentationRate;
    }

    public BloodTest erythrocyteSedimentationRate(Double erythrocyteSedimentationRate) {
        this.erythrocyteSedimentationRate = erythrocyteSedimentationRate;
        return this;
    }

    public void setErythrocyteSedimentationRate(Double erythrocyteSedimentationRate) {
        this.erythrocyteSedimentationRate = erythrocyteSedimentationRate;
    }

    public Double getGlucose() {
        return glucose;
    }

    public BloodTest glucose(Double glucose) {
        this.glucose = glucose;
        return this;
    }

    public void setGlucose(Double glucose) {
        this.glucose = glucose;
    }

    public Double getHematocrit() {
        return hematocrit;
    }

    public BloodTest hematocrit(Double hematocrit) {
        this.hematocrit = hematocrit;
        return this;
    }

    public void setHematocrit(Double hematocrit) {
        this.hematocrit = hematocrit;
    }

    public Double getHemoglobin() {
        return hemoglobin;
    }

    public BloodTest hemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
        return this;
    }

    public void setHemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public Double getIron() {
        return iron;
    }

    public BloodTest iron(Double iron) {
        this.iron = iron;
        return this;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getIronBindingCapacity() {
        return ironBindingCapacity;
    }

    public BloodTest ironBindingCapacity(Double ironBindingCapacity) {
        this.ironBindingCapacity = ironBindingCapacity;
        return this;
    }

    public void setIronBindingCapacity(Double ironBindingCapacity) {
        this.ironBindingCapacity = ironBindingCapacity;
    }

    public Double getLactate() {
        return lactate;
    }

    public BloodTest lactate(Double lactate) {
        this.lactate = lactate;
        return this;
    }

    public void setLactate(Double lactate) {
        this.lactate = lactate;
    }

    public Double getLacticDehydrogenase() {
        return lacticDehydrogenase;
    }

    public BloodTest lacticDehydrogenase(Double lacticDehydrogenase) {
        this.lacticDehydrogenase = lacticDehydrogenase;
        return this;
    }

    public void setLacticDehydrogenase(Double lacticDehydrogenase) {
        this.lacticDehydrogenase = lacticDehydrogenase;
    }

    public Double getLead() {
        return lead;
    }

    public BloodTest lead(Double lead) {
        this.lead = lead;
        return this;
    }

    public void setLead(Double lead) {
        this.lead = lead;
    }

    public Double getLipase() {
        return lipase;
    }

    public BloodTest lipase(Double lipase) {
        this.lipase = lipase;
        return this;
    }

    public void setLipase(Double lipase) {
        this.lipase = lipase;
    }

    public Double getZinc() {
        return zinc;
    }

    public BloodTest zinc(Double zinc) {
        this.zinc = zinc;
        return this;
    }

    public void setZinc(Double zinc) {
        this.zinc = zinc;
    }

    public Double getLipidsCholesterol() {
        return lipidsCholesterol;
    }

    public BloodTest lipidsCholesterol(Double lipidsCholesterol) {
        this.lipidsCholesterol = lipidsCholesterol;
        return this;
    }

    public void setLipidsCholesterol(Double lipidsCholesterol) {
        this.lipidsCholesterol = lipidsCholesterol;
    }

    public Double getLipidsTriglycerides() {
        return lipidsTriglycerides;
    }

    public BloodTest lipidsTriglycerides(Double lipidsTriglycerides) {
        this.lipidsTriglycerides = lipidsTriglycerides;
        return this;
    }

    public void setLipidsTriglycerides(Double lipidsTriglycerides) {
        this.lipidsTriglycerides = lipidsTriglycerides;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public BloodTest magnesium(Double magnesium) {
        this.magnesium = magnesium;
        return this;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getMeanCorpuscularHemoglobin() {
        return meanCorpuscularHemoglobin;
    }

    public BloodTest meanCorpuscularHemoglobin(Double meanCorpuscularHemoglobin) {
        this.meanCorpuscularHemoglobin = meanCorpuscularHemoglobin;
        return this;
    }

    public void setMeanCorpuscularHemoglobin(Double meanCorpuscularHemoglobin) {
        this.meanCorpuscularHemoglobin = meanCorpuscularHemoglobin;
    }

    public Double getMeanCorpuscularHemoglobinConcentration() {
        return meanCorpuscularHemoglobinConcentration;
    }

    public BloodTest meanCorpuscularHemoglobinConcentration(Double meanCorpuscularHemoglobinConcentration) {
        this.meanCorpuscularHemoglobinConcentration = meanCorpuscularHemoglobinConcentration;
        return this;
    }

    public void setMeanCorpuscularHemoglobinConcentration(Double meanCorpuscularHemoglobinConcentration) {
        this.meanCorpuscularHemoglobinConcentration = meanCorpuscularHemoglobinConcentration;
    }

    public Double getMeanCorpuscularVolume() {
        return meanCorpuscularVolume;
    }

    public BloodTest meanCorpuscularVolume(Double meanCorpuscularVolume) {
        this.meanCorpuscularVolume = meanCorpuscularVolume;
        return this;
    }

    public void setMeanCorpuscularVolume(Double meanCorpuscularVolume) {
        this.meanCorpuscularVolume = meanCorpuscularVolume;
    }

    public Double getOsmolality() {
        return osmolality;
    }

    public BloodTest osmolality(Double osmolality) {
        this.osmolality = osmolality;
        return this;
    }

    public void setOsmolality(Double osmolality) {
        this.osmolality = osmolality;
    }

    public Double getOxygenPressure() {
        return oxygenPressure;
    }

    public BloodTest oxygenPressure(Double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
        return this;
    }

    public void setOxygenPressure(Double oxygenPressure) {
        this.oxygenPressure = oxygenPressure;
    }

    public Double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public BloodTest oxygenSaturation(Double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
        return this;
    }

    public void setOxygenSaturation(Double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public Double getPhosphataseProstatic() {
        return phosphataseProstatic;
    }

    public BloodTest phosphataseProstatic(Double phosphataseProstatic) {
        this.phosphataseProstatic = phosphataseProstatic;
        return this;
    }

    public void setPhosphataseProstatic(Double phosphataseProstatic) {
        this.phosphataseProstatic = phosphataseProstatic;
    }

    public Double getPhosphatase() {
        return phosphatase;
    }

    public BloodTest phosphatase(Double phosphatase) {
        this.phosphatase = phosphatase;
        return this;
    }

    public void setPhosphatase(Double phosphatase) {
        this.phosphatase = phosphatase;
    }

    public Double getPhosphorus() {
        return phosphorus;
    }

    public BloodTest phosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
        return this;
    }

    public void setPhosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Double getPlateletCount() {
        return plateletCount;
    }

    public BloodTest plateletCount(Double plateletCount) {
        this.plateletCount = plateletCount;
        return this;
    }

    public void setPlateletCount(Double plateletCount) {
        this.plateletCount = plateletCount;
    }

    public Double getPotassium() {
        return potassium;
    }

    public BloodTest potassium(Double potassium) {
        this.potassium = potassium;
        return this;
    }

    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    public Double getProstateSpecificAntigen() {
        return prostateSpecificAntigen;
    }

    public BloodTest prostateSpecificAntigen(Double prostateSpecificAntigen) {
        this.prostateSpecificAntigen = prostateSpecificAntigen;
        return this;
    }

    public void setProstateSpecificAntigen(Double prostateSpecificAntigen) {
        this.prostateSpecificAntigen = prostateSpecificAntigen;
    }

    public Double getProteinsTotal() {
        return proteinsTotal;
    }

    public BloodTest proteinsTotal(Double proteinsTotal) {
        this.proteinsTotal = proteinsTotal;
        return this;
    }

    public void setProteinsTotal(Double proteinsTotal) {
        this.proteinsTotal = proteinsTotal;
    }

    public Double getProteinsAlbumin() {
        return proteinsAlbumin;
    }

    public BloodTest proteinsAlbumin(Double proteinsAlbumin) {
        this.proteinsAlbumin = proteinsAlbumin;
        return this;
    }

    public void setProteinsAlbumin(Double proteinsAlbumin) {
        this.proteinsAlbumin = proteinsAlbumin;
    }

    public Double getProteinsGlobulin() {
        return proteinsGlobulin;
    }

    public BloodTest proteinsGlobulin(Double proteinsGlobulin) {
        this.proteinsGlobulin = proteinsGlobulin;
        return this;
    }

    public void setProteinsGlobulin(Double proteinsGlobulin) {
        this.proteinsGlobulin = proteinsGlobulin;
    }

    public Double getProthrombin() {
        return prothrombin;
    }

    public BloodTest prothrombin(Double prothrombin) {
        this.prothrombin = prothrombin;
        return this;
    }

    public void setProthrombin(Double prothrombin) {
        this.prothrombin = prothrombin;
    }

    public Double getPyruvicAcid() {
        return pyruvicAcid;
    }

    public BloodTest pyruvicAcid(Double pyruvicAcid) {
        this.pyruvicAcid = pyruvicAcid;
        return this;
    }

    public void setPyruvicAcid(Double pyruvicAcid) {
        this.pyruvicAcid = pyruvicAcid;
    }

    public Double getRedBloodCellCount() {
        return redBloodCellCount;
    }

    public BloodTest redBloodCellCount(Double redBloodCellCount) {
        this.redBloodCellCount = redBloodCellCount;
        return this;
    }

    public void setRedBloodCellCount(Double redBloodCellCount) {
        this.redBloodCellCount = redBloodCellCount;
    }

    public Double getSodium() {
        return sodium;
    }

    public BloodTest sodium(Double sodium) {
        this.sodium = sodium;
        return this;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public Double getThyroidStimulatingHormone() {
        return thyroidStimulatingHormone;
    }

    public BloodTest thyroidStimulatingHormone(Double thyroidStimulatingHormone) {
        this.thyroidStimulatingHormone = thyroidStimulatingHormone;
        return this;
    }

    public void setThyroidStimulatingHormone(Double thyroidStimulatingHormone) {
        this.thyroidStimulatingHormone = thyroidStimulatingHormone;
    }

    public Double getTransaminaseAlanine() {
        return transaminaseAlanine;
    }

    public BloodTest transaminaseAlanine(Double transaminaseAlanine) {
        this.transaminaseAlanine = transaminaseAlanine;
        return this;
    }

    public void setTransaminaseAlanine(Double transaminaseAlanine) {
        this.transaminaseAlanine = transaminaseAlanine;
    }

    public Double getTransaminaseAspartate() {
        return transaminaseAspartate;
    }

    public BloodTest transaminaseAspartate(Double transaminaseAspartate) {
        this.transaminaseAspartate = transaminaseAspartate;
        return this;
    }

    public void setTransaminaseAspartate(Double transaminaseAspartate) {
        this.transaminaseAspartate = transaminaseAspartate;
    }

    public Double getUreaNitrogen() {
        return ureaNitrogen;
    }

    public BloodTest ureaNitrogen(Double ureaNitrogen) {
        this.ureaNitrogen = ureaNitrogen;
        return this;
    }

    public void setUreaNitrogen(Double ureaNitrogen) {
        this.ureaNitrogen = ureaNitrogen;
    }

    public Double getbUNCreatinineRatio() {
        return bUNCreatinineRatio;
    }

    public BloodTest bUNCreatinineRatio(Double bUNCreatinineRatio) {
        this.bUNCreatinineRatio = bUNCreatinineRatio;
        return this;
    }

    public void setbUNCreatinineRatio(Double bUNCreatinineRatio) {
        this.bUNCreatinineRatio = bUNCreatinineRatio;
    }

    public Double getUricAcid() {
        return uricAcid;
    }

    public BloodTest uricAcid(Double uricAcid) {
        this.uricAcid = uricAcid;
        return this;
    }

    public void setUricAcid(Double uricAcid) {
        this.uricAcid = uricAcid;
    }

    public Double getVitaminA() {
        return vitaminA;
    }

    public BloodTest vitaminA(Double vitaminA) {
        this.vitaminA = vitaminA;
        return this;
    }

    public void setVitaminA(Double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public Double getwBC() {
        return wBC;
    }

    public BloodTest wBC(Double wBC) {
        this.wBC = wBC;
        return this;
    }

    public void setwBC(Double wBC) {
        this.wBC = wBC;
    }

    public Double getWhiteBloodCellCount() {
        return whiteBloodCellCount;
    }

    public BloodTest whiteBloodCellCount(Double whiteBloodCellCount) {
        this.whiteBloodCellCount = whiteBloodCellCount;
        return this;
    }

    public void setWhiteBloodCellCount(Double whiteBloodCellCount) {
        this.whiteBloodCellCount = whiteBloodCellCount;
    }

    public ZonedDateTime getMeasurmentdate() {
        return measurmentdate;
    }

    public BloodTest measurmentdate(ZonedDateTime measurmentdate) {
        this.measurmentdate = measurmentdate;
        return this;
    }

    public void setMeasurmentdate(ZonedDateTime measurmentdate) {
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
        BloodTest bloodTest = (BloodTest) o;
        if (bloodTest.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bloodTest.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BloodTest{" +
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
