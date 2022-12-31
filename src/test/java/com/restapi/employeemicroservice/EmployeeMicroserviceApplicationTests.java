package com.restapi.employeemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class EmployeeMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	/*@Test
	@DisplayName("Greeting message . . .")
	public void getGreetingsTest() throws URISyntaxException {
		System.out.println("Test started for : getGreetingsTest()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/getMsg/Akhilesh";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test getGreetingsTest() ended.");
	}*/

	/*@Test
	@DisplayName("Create employee . . .")
	public void createEmployee() throws Exception {
		System.out.println("Test started for : createEmployee()");
		Employee employee = new Employee();
		employee.setEmpId(6);
		employee.setEmpName("Anurag");
		employee.setEmpSalary(10000);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/createemployee";
		URI uri = new URI(url);
		ResponseEntity<Employee> response = restTemplate
				.postForEntity(uri, employee, Employee.class);
		System.out.println(response.toString());
		System.out.println("Test createEmployee() ended.");
	}*/


	/*@Test
	@DisplayName("Find employee with id . . .")
	public void findEmployeeById() throws URISyntaxException {
		System.out.println("Test started for : getEmployeeById()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/findemployeebyid/5";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test getEmployeeById() ended.");
	}*/

	/*@Test
	@DisplayName("Find highest salaried employee . . .")
	public void highestSalaryEmployee() throws URISyntaxException {
		System.out.println("Test started for : highestSalaryEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/highestsalaryemployee";
		URI uri = new URI(url);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test highestSalaryEmployee() ended.");
	}*/

	/*@Test
	@DisplayName("Employee deleted . . .")
	public void deleteEmployee() throws URISyntaxException {
		System.out.println("Test started for : deleteEmployee()");
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "http://localhost:8080/deleteemployee/8";
		URI uri1 = new URI(url1);
		restTemplate.delete(uri1);
		String url2 = "http://localhost:8080/findemployeebyid/8";
		URI uri2 = new URI(url2);
		ResponseEntity<String> response = restTemplate.getForEntity(uri2, String.class);
		Assertions.assertNotEquals(200, response.getStatusCodeValue());
		System.out.println(response.toString());
		System.out.println("Test deleteEmployee() ended . . .");
	}*/
}