import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;



public class streams {
	@Test
	public void regular() {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Manish");
		names.add("Malika");
		names.add("Miish");
		names.add("Aman");
		names.add("Sunil");
		names.add("kamal");
		int count = 0;
		for(int i=0;i<names.size();i++) {
			String actualname = names.get(i);
			if(actualname.startsWith("M")&& actualname.endsWith("h")) {
				count++;
			}
		}
		System.out.println(count);
	}
	@Test
	public void stream() {
		ArrayList<String> snames = new ArrayList<String>(); 
		snames.add("Aman");
		snames.add("Ankit");
		snames.add("Anas");
		snames.add("Anshul");
		snames.add("Armaan");
		
//		Long ss=snames.stream().filter(sn->sn.startsWith("A")).count();
//		System.out.println(ss);
		Long fn = Stream.of("Aman","Ankit","Anshul","Armaan").filter(ssn->{
			ssn.startsWith("A");
			return false;
		}
		).count();
		System.out.println(fn);
		
//		snames.stream().filter(sn->sn.length()>4).forEach(sn->System.out.println(sn));
		snames.stream().filter(sn->sn.length()>4).limit(1).forEach(sn->System.out.println(sn));
	}

@Test	
public void streammap() {
	//print the name starts with M in UPPERCASE
//	Stream.of("Manish","Manan","Malik","Aman").filter(n->n.startsWith("M")).map(n->n.toUpperCase()).forEach(n->System.out.println(n));
	List<String> cranes = Arrays.asList("RSTS","RTG","RMG","MHC","Goliath");
	cranes.stream().filter(c->c.startsWith("R")).sorted().map(c->c.toUpperCase());
	List<String> dCranes = Arrays.asList("Dumper","Dozer","Mtc","DTower","Dozer");
	dCranes.stream().filter(c->c.startsWith("D")).sorted().map(c->c.toUpperCase());
	Stream<String> mergestream = Stream.concat(cranes.stream(), dCranes.stream());
//	mergestream.sorted().forEach(ms->System.out.println(ms));
	boolean match = mergestream.anyMatch(m->m.equalsIgnoreCase("GSU"));
	System.out.println(match);
	Assert.assertTrue(match);
	
}

@Test
public void streamcollect() {
	
//	List<String>cars = Stream.of("Buggati","AHondaCity","ARange","Amaze").filter(c->c.startsWith("A")).sorted().map(c->c.toUpperCase()).collect(Collectors.toList());
//	System.out.println(cars.get(0));

//	 numbers[] = {"Buggati","AHondaCity","ARange","Amaze"};
List<Integer> num = Arrays.asList(3,2,2,7,5,1,9,7);
 
	//print the unique no from given array 
	// sort the array
	num.stream().distinct().forEach(n->System.out.println(n));
	num.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(num.get(2));
}

}
