import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		List<String> list = new LinkedList<>();
		
		//list.add(101);
		list.add("Niti");
		
		//list.add(101);
		list.add("Niti");
		
		
		
		System.out.println("The list elements : " + list);
		
		
		List aList = new ArrayList();
		
		//list.add(101);
		list.add("Niti");
		
		aList.add(list);
		
		System.out.println("The list elements : " + aList);
		
		
		//Collections.sort(list);
		

	}

}
