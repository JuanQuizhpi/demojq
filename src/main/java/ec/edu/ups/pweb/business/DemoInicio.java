package ec.edu.ups.pweb.business;

import java.util.List;

import ec.edu.ups.pweb.dao.CarroDAO;
import ec.edu.ups.pweb.model.Carro;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DemoInicio {

	@Inject
	private CarroDAO daoCarro;
	
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando......");
			
		
	}
}
