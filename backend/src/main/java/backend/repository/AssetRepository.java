package backend.repository;

import backend.model.Asset;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
}
