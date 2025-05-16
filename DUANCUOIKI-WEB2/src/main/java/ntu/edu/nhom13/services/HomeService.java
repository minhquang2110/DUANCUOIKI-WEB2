package ntu.edu.nhom13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntu.edu.nhom13.entity.ScientistEntity;
import ntu.edu.nhom13.repositories.HomeRepo;

@Service
public class HomeService{
	@Autowired
	private HomeRepo homeRepo ;
	
	public List<ScientistEntity> sci() {
	    return 	homeRepo.findAll();
	}
}