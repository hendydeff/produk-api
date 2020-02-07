package id.com.produk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import id.com.produk.entity.Produk;

public interface ProdukRepository extends CrudRepository<Produk, Long> {

	@Query(value = "SELECT * FROM produk", nativeQuery = true)
	List<Produk> findAllProduk();

}
