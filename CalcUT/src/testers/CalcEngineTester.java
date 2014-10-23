package testers;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class CalcEngineTester {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public static void main(String[] args){
		
		Set<String> set = new LinkedHashSet<String>();

		set.add( "Chocoloate" );

		set.add( "Vanilla" );

		set.add( "Strawberry" );

		set.forEach(System.out::println);
		
	}

}
