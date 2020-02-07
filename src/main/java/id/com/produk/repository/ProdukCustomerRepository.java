package id.com.produk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import id.com.produk.entity.ProdukCustomer;

public interface ProdukCustomerRepository extends CrudRepository<ProdukCustomer, Long> {

	@Query(value = "SELECT ca.id, cus.nama, cus.alamat, pro.nama_produk, pro.harga, ca.created_at, ca.updated_at FROM "
			+ "customer cus INNER JOIN cart ca ON cus.id = ca.customer_id "
			+ "INNER JOIN produk pro ON pro.id = ca.produk_id WHERE cus.id= :customer_id ", nativeQuery = true)
	List<ProdukCustomer> findProdukCustomerByCustomerId(@Param("customer_id") int customerId);

}
