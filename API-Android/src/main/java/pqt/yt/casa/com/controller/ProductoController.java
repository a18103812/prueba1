package pqt.yt.casa.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pqt.yt.casa.com.entitys.Producto;
import pqt.yt.casa.com.services.IProductoService;

@RestController
@RequestMapping(value = "/api/producto")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping(value = "/all")
	public List<Producto> getAll(){
		return productoService.listarProductos();
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		productoService.guardar(producto);
		return new ResponseEntity("guardado",HttpStatus.OK);
	}
	
	@PutMapping (value = "/update")
	public ResponseEntity<Producto> update(@RequestBody Producto producto){
		productoService.guardar(producto);
		return new ResponseEntity("editado",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Producto producto= productoService.buscarPorID(id);
		if (producto != null) {
			productoService.eliminar(id);
		}else {
			return new ResponseEntity("error",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("eliminado",HttpStatus.OK);
	}
	
	
	
	
}
