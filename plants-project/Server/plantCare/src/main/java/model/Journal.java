package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Journal {

    @Id
    @JsonProperty("Journal Id")
    private int journalId;
    @Id
    @JsonProperty("Customer Id")
    private int customerId;
    @Id
    @JsonProperty("Plant Id")
    private int plantId;
    @JsonProperty("Entry Date")
    private LocalDate entryDate;

    public Journal(int journalId, int customerId, int plantId, LocalDate entryDate) {
        this.journalId = journalId;
        this.customerId = customerId;
        this.plantId = plantId;
        this.entryDate = entryDate;
    }

    public Journal() {
    }

    public int getJournalId() {
        return journalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPlantId() {
        return plantId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }


}
