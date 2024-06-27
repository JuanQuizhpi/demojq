package ec.edu.ups.pweb.business;


import java.util.List;

import ec.edu.ups.pweb.model.Carro;
import jakarta.ejb.Local;

@Local
public interface GestionCarrosLocal {

	public void guardarCarros(Carro carro);
	public void actualizarCarro(Carro carro) throws Exception;
	public Carro getCarroPorPlaca(String placa) throws Exception;
	public void borrarCarro(String placa);
	public List<Carro> getCarros();
}
