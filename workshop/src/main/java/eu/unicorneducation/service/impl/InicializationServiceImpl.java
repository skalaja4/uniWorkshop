package eu.unicorneducation.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.dao.InicializationDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.service.InicializationService;

@Component
public class InicializationServiceImpl implements InicializationService {

	@Autowired
	InicializationDAO dao;

	public void inicializateBranches(MultipartFile file) {
		List<Branch> list = new ArrayList<>();

		try {
			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(
					file.getInputStream()));
			for (CSVRecord r : parser) {
				list.add(new Branch(r.get(0), r.get(1), r.get(2), null));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void inicializateEmployees(MultipartFile file) {
		List<Employee> list = new ArrayList<>();

		try {
			CSVParser parser = CSVFormat.DEFAULT.parse(new InputStreamReader(file.getInputStream()));
			for (CSVRecord r : parser) {
				list.add(new Employee());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
