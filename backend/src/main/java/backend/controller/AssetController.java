package backend.controller;

import backend.model.Asset;
import backend.repository.AssetRepository;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/assets")
public class AssetController {

    private final AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Get
    public List<Asset> getAllAssets() {
        return (List<Asset>) assetRepository.findAll();
    }

    @Post
    public Asset addAsset(@Body Asset asset) {
        asset.setAssetCreation(java.time.LocalDateTime.now());
        asset.setAssetUpdation(java.time.LocalDateTime.now());
        return assetRepository.save(asset);
    }

    @Put("/{id}")
    public Asset updateAsset(@PathVariable Long id, @Body Asset asset) {
        asset.setAssetId(id);
        asset.setAssetUpdation(java.time.LocalDateTime.now());
        return assetRepository.update(asset);
    }

    @Delete("/{id}")
    public void deleteAsset(@PathVariable Long id) {
        assetRepository.deleteById(id);
    }
}
