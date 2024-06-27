package ec.edu.ups.pweb.business;

import java.util.List;

import ec.edu.ups.pweb.dao.CarroDAO;
import ec.edu.ups.pweb.model.Carro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarros implements GestionCarrosLocal, GestionCarrosRemoto{

	@Inject
	private CarroDAO daoCarro;

	@Override
	public void guardarCarros(Carro carro) {
		// TODO Auto-generated method stub
		Carro car = daoCarro.read(carro.getPlaca());
		if (car != null){
			daoCarro.update(carro);
		}else {
			daoCarro.insert(carro);
		}
		
	}

	@Override
	public void actualizarCarro(Carro carro) throws Exception {
		// TODO Auto-generated method stub
		Carro car = daoCarro.read(carro.getPlaca());
		if (car != null){
			daoCarro.update(carro);
		}else {
			throw new Exception("Carro no existe");
		}
	}

	@Override
	public Carro getCarroPorPlaca(String placa) throws Exception {
		// TODO Auto-generated method stub
		Carro car = daoCarro.read(placa);
		if(car != null) {
			return daoCarro.getCarroPorPlaca(placa);
		}else {
			throw new Exception("Carro no existe");
		}
	}

	@Override
	public void borrarCarro(String placa) {
		// TODO Auto-generated method stub
		daoCarro.delete(placa);
	}

	@Override
	public List<Carro> getCarros() {
		// TODO Auto-generated method stub
		return daoCarro.getList();
	}
	
}
