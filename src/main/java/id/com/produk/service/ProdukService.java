package id.com.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.com.produk.entity.Cart;
import id.com.produk.entity.Produk;
import id.com.produk.entity.ProdukCustomer;
import id.com.produk.repository.CartRepository;
import id.com.produk.repository.ProdukCustomerRepository;
import id.com.produk.repository.ProdukRepository;

@Service
public class ProdukService {

	@Autowired
	ProdukRepository produkRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProdukCustomerRepository produkCustomerRepository;

	public void saveCart(Cart cart) {
		cartRepository.save(cart);
	}

	public List<Produk> getProduks() {
		return produkRepository.findAllProduk();
	}

	public List<ProdukCustomer> getCartByCustomerId(int customerId) {
		return produkCustomerRepository.findProdukCustomerByCustomerId(customerId);
	}

}
