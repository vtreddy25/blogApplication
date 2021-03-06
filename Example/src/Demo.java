import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		
		List<Student> list=new ArrayList<>();
		list.add(new Student(101,"Thirupathi","Maths"));
		list.add(new Student(102,"Sunil","Physics"));
		list.add(new Student(103,"Bharat","Maths"));
		list.add(new Student(104,"Sindhu","Physics"));
		list.add(new Student(10,"Ashok","Physics"));
		
		Map<String, List<Student>> subjectList=list.stream().collect(Collectors.groupingBy(Student::getSubject,Collectors.toList()));

		subjectList.entrySet().forEach(e->System.out.println(e.getKey()+"  "+e.setValue(list).size()));
		
         list.stream().forEach(e->System.out.println(e.getName()));
         
         System.out.println("Maths Student only");
         
         list.stream().filter(e->e.getSubject().equals("Maths")).forEach(e->System.out.println(e.getName()));
         
         
      
         
      
         
         
        
         }
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
	}

}
