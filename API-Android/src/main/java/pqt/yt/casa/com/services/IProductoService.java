package pqt.yt.casa.com.services;

import java.util.List;

import pqt.yt.casa.com.entitys.Producto;

public interface IProductoService {

	public List<Producto> listarProductos();
	
	public void guardar (Producto producto);
	
	public Producto buscarPorID(Long id);
	
	public void Editar (Long id);
	
	public void eliminar(Long id);
	
	
}
