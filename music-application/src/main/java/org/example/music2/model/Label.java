package org.example.music2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Label {
    @Id
    @JsonProperty("Label Id")
    private int labelId;
    @JsonProperty("Label Name")
    private String labelName;
    @JsonProperty("Date Established")
    private LocalDate dateEstablished;

    public Label(int labelId, String labelName, LocalDate dateEstablished) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.dateEstablished = dateEstablished;
    }

    public Label() {
    }

    public int getLabelId() {
        return labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public LocalDate getDateEstablished() {
        return dateEstablished;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setDateEstablished(LocalDate dateEstablished) {
        this.dateEstablished = dateEstablished;
    }
}
