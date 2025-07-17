package carstore.carstorebe.repository;

import carstore.carstorebe.model.InventoryTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventoryTransactionsRepository extends JpaRepository<InventoryTransactions, Integer>, JpaSpecificationExecutor<InventoryTransactions> {

}