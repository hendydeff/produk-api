package id.com.produk;

import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import id.com.produk.entity.Customer;
import id.com.produk.entity.Produk;
import id.com.produk.repository.CustomerRepository;
import id.com.produk.repository.ProdukRepository;

@SpringBootApplication
public class ProdukApiApplication {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProdukRepository produkRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProdukApiApplication.class, args);
	}
	
	@PostConstruct
	public void runScript() {
		Customer customer = new Customer();
		customer.setNama("Hendiawan");
		customer.setAlamat("Jakarta Barat");
		customer.setCreatedAt(Instant.now());
		customer.setUpdatedAt(Instant.now());
		customerRepository.save(customer);
		
		Produk produk = new Produk();
		produk.setNamaProduk("Buku Tulis");
		produk.setHarga(5000);
		produk.setCreatedAt(Instant.now());
		produk.setUpdatedAt(Instant.now());
		produkRepository.save(produk);
		
		produk = new Produk();
		produk.setNamaProduk("Penggaris");
		produk.setHarga(5500);
		produk.setCreatedAt(Instant.now());
		produk.setUpdatedAt(Instant.now());
		produkRepository.save(produk);
		
		produk = new Produk();
		produk.setNamaProduk("Pencil");
		produk.setHarga(2500);
		produk.setCreatedAt(Instant.now());
		produk.setUpdatedAt(Instant.now());
		
		produk = new Produk();
		produk.setNamaProduk("Penghapus");
		produk.setHarga(1500);
		produk.setCreatedAt(Instant.now());
		produk.setUpdatedAt(Instant.now());
		produkRepository.save(produk);
	}

}
