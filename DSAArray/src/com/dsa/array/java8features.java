package com.dsa.array;

import com.dsa.array.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class java8features {

	public static void main(String[] args) {
		List<Employee> empList=Arrays.asList(
				new Employee(101,"bharat","cse",35000),
				new Employee(102,"ashok","cse",30000),
				new Employee(103,"akhil","ece",40000),
				new Employee(104,"vtr","cse",50000),
				new Employee(105,"raghava","ece",20000),
				new Employee(106,"dinesh","eee",60000)
				);
		Map<String,List<Employee>> deptgrouplist=
				empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()));
	     deptgrouplist.entrySet().forEach(entry->
	               System.out.println(entry.getKey()+"-----"+entry.getValue())
	    		 );
	     
	      Map<String,Long> countDept= empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
	
	      countDept.entrySet().forEach(entry->
	             System.out.println(entry.getKey()+"---"+entry.getValue())
	    		  );
	      
	      deptgrouplist.entrySet().forEach(entry->
          System.out.println(entry.getKey()+"-----"+entry.getValue().stream()
        		  .max(Comparator.comparing(Employee::getSalary)).map(emp->emp.getSalary()))
		 );
	      
	      deptgrouplist.entrySet().forEach(entry->
          System.out.println(entry.getKey()+"-----"+entry.getValue().stream()
        		  .min(Comparator.comparing(Employee::getSalary)).map(emp->emp.getSalary()))
		 );
	      

	}

}


