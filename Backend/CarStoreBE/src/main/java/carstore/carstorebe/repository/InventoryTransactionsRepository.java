package carstore.carstorebe.repository;

import carstore.carstorebe.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventoryTransactionsRepository extends JpaRepository<InventoryTransaction, Integer>, JpaSpecificationExecutor<InventoryTransaction> {

}