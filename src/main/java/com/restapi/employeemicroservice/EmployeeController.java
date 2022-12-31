package com.restapi.employeemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getMsg/{userName}")
    public String getGreetings(@PathVariable String userName){
        Date date = new Date();
        String greeting = null;

        SimpleDateFormat time = new SimpleDateFormat("hh:mm aa");
        String currentTime = time.format(date);

        SimpleDateFormat hour = new SimpleDateFormat("hh");
        SimpleDateFormat ampm = new SimpleDateFormat("aa");
        int hh = Integer.parseInt(hour.format(date));
        String aa = ampm.format(date);

        if ((hh >= 4 && hh < 12) && (aa.equals("AM"))) {
            greeting = "Good Morning ";
        }
        else if ((hh >= 12 || hh < 4) && (aa.equals("PM"))) {
            greeting = "Good Afternoon ";
        }
        else if ((hh >= 4 && hh < 8) && (aa.equals("PM"))) {
            greeting = "Good Evening";
        }
        else if ((hh >= 8 || hh < 4) && (aa.equals("PM")) || (hh >= 8 || hh < 4) && (aa.equals("AM"))) {
            greeting = "Good Night";
        }
        return greeting + " " + userName + "\nTime : " + currentTime;
    }

    @PostMapping("/createemployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/findallemployee")
    public List<Employee> getAllEmployee() {
        // 1st approach without cache
        return employeeRepository.findAll();

        // 2nd approach with cache
        /*return new ArrayList<>(CacheManager.cache.values());*/
    }

    // Pending
    @GetMapping("/findemployeesalarygreaterthan")
    public List<Employee> findEmployeeSalaryGreaterThan(){
        return employeeRepository.findEmployeeSalaryGreaterThan();
    }

    @GetMapping("/findemployeebyid/{empId}")
    public String findEmployeeById(@PathVariable int empId){
          Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isPresent())
            // Here ".get()" method is use to get specific output, its optional
            return employee.get().toString();
        else
            return "Employee with id : " + empId + " is not available ! ! !";

    }

    @GetMapping("/highestsalaryemployee")
    public List<Employee> highestSalaryEmployee(){

        return employeeRepository.getHighestSalaryEmployee();
    }

    @GetMapping("/lowestsalaryemployee")
    public List<Employee> lowestSalaryEmployee(){

        return employeeRepository.getHighestSalaryEmployee();
    }

    @PutMapping("/updateemployee/{empId}")
    public String updateEmployee(@PathVariable int empId, @RequestBody Employee employee){

        Optional<Employee> oldEmployee = employeeRepository.findById(empId);
        if(oldEmployee.isPresent()){
            // This type of update is called as "Transformation"
            oldEmployee.get().setEmpName(employee.getEmpName());
            oldEmployee.get().setEmpSalary(employee.getEmpSalary());
            return employeeRepository.save(oldEmployee.get()).toString();

            /* This is not recommended, it will update all fields
            and if record not present, it will create new record*/
            // return employeeRepository.save(employee).toString();
        }
        else {
            return "Employee with id : " + empId + " is not available ! ! !";
        }
    }

    @DeleteMapping("/deleteemployee/{empId}")
    public ResponseEntity deleteEmployee(@PathVariable int empId){
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isPresent()){
            employeeRepository.deleteById(empId);
            return ResponseEntity.accepted().build();
            //return "Employee with id : " + empId + " is deleted successfully ! ! !";
        }
        else {
            return ResponseEntity.notFound().build();
            //return "Employee with id : " + empId + " is not available ! ! !";
        }
    }
}
