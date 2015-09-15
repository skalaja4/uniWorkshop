package eu.unicorneducation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.helpers.ModelTransformer;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EmployeeRESTModel;

@RestController
@RequestMapping("/rest")
public class NasRestController {

	@Autowired
	EmployeeFacade empFacade;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public EmployeeRESTModel getStudent(@PathVariable String id) {
		EmployeeModel emp = empFacade.readByID(id);

		return ModelTransformer.employeeModelToEmployeeRESTModel(emp);
	}

}
