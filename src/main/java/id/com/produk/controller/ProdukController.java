package id.com.produk.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.com.produk.entity.Cart;
import id.com.produk.service.ProdukService;

@RestController
@RequestMapping("/api")
public class ProdukController {

	@Autowired
	ProdukService produkService;

	@PostMapping("/produks")
	public ResponseEntity<?> getProduks() {
		HashMap<String, Object> response = new HashMap<>();
		response.put("status", true);
		response.put("data", produkService.getProduks());

		return ResponseEntity.ok(response);
	}

	@PostMapping("/cart")
	public ResponseEntity<?> postCart(@Valid @RequestBody Map<String, Object> param) {
		String[] mandatory = { "produk_id", "customer_id" };
		for (String key : mandatory) {
			if (Objects.isNull(param.get(key))) {

				HashMap<String, Object> response = new HashMap<>();
				response.put("status", false);
				response.put("message", key + " harus diisi");
				return ResponseEntity.ok().body(response);

			}
		}

		int produkId = Integer.parseInt(param.get("produk_id").toString());
		int customerId = Integer.parseInt(param.get("customer_id").toString());

		Cart cart = new Cart();
		cart.setProdukId(produkId);
		cart.setCustomerId(customerId);
		cart.setCreatedAt(Instant.now());
		cart.setUpdatedAt(Instant.now());
		produkService.saveCart(cart);

		HashMap<String, Object> response = new HashMap<>();
		response.put("status", true);
		response.put("message", "Berhasil menambahkan produk ke cart");
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/carts")
	public ResponseEntity<?> getCarts(@Valid @RequestBody Map<String, Object> param) {
		String[] mandatory = { "customer_id" };
		for (String key : mandatory) {
			if (Objects.isNull(param.get(key))) {

				HashMap<String, Object> response = new HashMap<>();
				response.put("status", false);
				response.put("message", key + " harus diisi");
				return ResponseEntity.ok().body(response);

			}
		}

		int customerId = Integer.parseInt(param.get("customer_id").toString());

		HashMap<String, Object> response = new HashMap<>();
		response.put("status", true);
		response.put("data", produkService.getCartByCustomerId(customerId));

		return ResponseEntity.ok(response);
	}

}
