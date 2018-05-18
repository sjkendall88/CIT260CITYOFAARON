package byui260.aaron.model;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hotja
 */
public class CropData implements Serializable {
    
    private Integer year;
    private Integer population;
    private Integer acresOwned;
    private Integer cropYield;
    private Integer wheatInStore;
    private Integer newPeople;
    private Integer harvest;
    private Integer harvestAfterOffering;
    private Integer offering;
    private Integer offeringBushels;
    private Integer peopleFed;
    private Integer acresPlanted;
    private Integer numStarved;
    private Integer eatenByRats;
    private Integer wheatForPeople;

    public CropData(Integer year, Integer population, Integer acresOwned, Integer cropYield, Integer wheatInStore, Integer newPeople, Integer harvest, Integer harvestAfterOffering, Integer offering, Integer offeringBushels, Integer peopleFed, Integer acresPlanted, Integer numStarved, Integer eatenByRats, Integer wheatForPeople) {
    }
    
    

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(Integer acresOwned) {
        this.acresOwned = acresOwned;
    }

    public Integer getCropYield() {
        return cropYield;
    }

    public void setCropYield(Integer cropYield) {
        this.cropYield = cropYield;
    }

    public Integer getWheatInStore() {
        return wheatInStore;
    }

    public void setWheatInStore(Integer wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    public Integer getNewPeople() {
        return newPeople;
    }

    public void setNewPeople(Integer newPeople) {
        this.newPeople = newPeople;
    }

    public Integer getHarvest() {
        return harvest;
    }

    public void setHarvest(Integer harvest) {
        this.harvest = harvest;
    }

    public Integer getHarvestAfterOffering() {
        return harvestAfterOffering;
    }

    public void setHarvestAfterOffering(Integer harvestAfterOffering) {
        this.harvestAfterOffering = harvestAfterOffering;
    }

    public Integer getOffering() {
        return offering;
    }

    public void setOffering(Integer offering) {
        this.offering = offering;
    }

    public Integer getOfferingBushels() {
        return offeringBushels;
    }

    public void setOfferingBushels(Integer offeringBushels) {
        this.offeringBushels = offeringBushels;
    }

    public Integer getPeopleFed() {
        return peopleFed;
    }

    public void setPeopleFed(Integer peopleFed) {
        this.peopleFed = peopleFed;
    }

    public Integer getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(Integer acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public Integer getNumStarved() {
        return numStarved;
    }

    public void setNumStarved(Integer numStarved) {
        this.numStarved = numStarved;
    }

    public Integer getEatenByRats() {
        return eatenByRats;
    }

    public void setEatenByRats(Integer eatenByRats) {
        this.eatenByRats = eatenByRats;
    }

    public Integer getWheatForPeople() {
        return wheatForPeople;
    }

    public void setWheatForPeople(Integer wheatForPeople) {
        this.wheatForPeople = wheatForPeople;
    }
    
    
    
}
