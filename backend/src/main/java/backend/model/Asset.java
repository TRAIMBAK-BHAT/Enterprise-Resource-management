package backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import io.micronaut.serde.annotation.Serdeable;

@Entity
@Serdeable
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetId;

    private String assetName;
    private String assetLocation;
    private Double assetValue;

    private LocalDateTime assetCreation;
    private LocalDateTime assetUpdation;

    private String assetType;
    private String assetCreatedBy;
    private String assetUpdatedBy;

    // Getters and Setters

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetLocation() {
        return assetLocation;
    }

    public void setAssetLocation(String assetLocation) {
        this.assetLocation = assetLocation;
    }

    public Double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(Double assetValue) {
        this.assetValue = assetValue;
    }

    public LocalDateTime getAssetCreation() {
        return assetCreation;
    }

    public void setAssetCreation(LocalDateTime assetCreation) {
        this.assetCreation = assetCreation;
    }

    public LocalDateTime getAssetUpdation() {
        return assetUpdation;
    }

    public void setAssetUpdation(LocalDateTime assetUpdation) {
        this.assetUpdation = assetUpdation;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetCreatedBy() {
        return assetCreatedBy;
    }

    public void setAssetCreatedBy(String assetCreatedBy) {
        this.assetCreatedBy = assetCreatedBy;
    }

    public String getAssetUpdatedBy() {
        return assetUpdatedBy;
    }

    public void setAssetUpdatedBy(String assetUpdatedBy) {
        this.assetUpdatedBy = assetUpdatedBy;
    }
}
