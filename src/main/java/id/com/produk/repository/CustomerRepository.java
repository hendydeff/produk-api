package id.com.produk.repository;

import org.springframework.data.repository.CrudRepository;

import id.com.produk.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
