package main.Class;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class InterestTest {
	   private Type type;
	   private double inputPrinciple;
	   private double inputRateOfInterest;
	   private double inputTime;
	   private double expectedResult;
	   private SimpleInterest simple;
	   private CompoundInterest compound;
	   private ConstructionCost costofhouse;
	   private String material;
	   private int area;
	   private double expected;
	   @Before
	   public void initialize() {
	     simple =new SimpleInterest();
	     compound =new CompoundInterest();
	    
	   }

		
	   public InterestTest(Type type,double inputPrinciple,double inputRateOfInterest,double inputTime, double expectedResult) {
		  this.type=type;
	      this.inputPrinciple = inputPrinciple;
	      this.inputRateOfInterest=inputRateOfInterest;
	      this.inputTime= inputTime;
	      this.expectedResult = expectedResult;
	   }
	
	   enum Type{compound,simple,costofhouse};
	   @Parameterized.Parameters
	   public static Collection interestinputs() {
	      return Arrays.asList(new Object[][] {
	         { Type.compound ,10000, 5 , 10.25 , 6288.946267774416},
	         { Type.compound , 1200 , 2, 5.4 , 133.0992000000001 },
	         { Type.simple , 10000 , 1, 10 , 1000 },
	         { Type.simple , 2000 , 3, 6 , 360.0 },
	       
	        
	      });
	   }

	   
	   @Test
	   public void testInterest() {
		  Assume.assumeTrue(type == Type.compound);
	      assertEquals(expectedResult, compound.calculateCompoundInterest(inputPrinciple,inputRateOfInterest,inputTime),-1);
	   }
	   @Test
	   public void testInterest1() {
		  Assume.assumeTrue(type == Type.simple);
	      assertEquals(expectedResult, simple.calculateSimpleInterest(inputPrinciple,inputRateOfInterest,inputTime),-1);
	   }
	  @Test
	   public void cost() {
		  ConstructionCost s=new ConstructionCost();
		 
	      assertEquals(156000, s.calculatingConstructionCost("standard",130),0);
	      assertEquals(195000, s.calculatingConstructionCost("above standard",130),0);
	      assertEquals(234000, s.calculatingConstructionCost("high standard",130),0);
	      assertEquals(325000, s.calculatingConstructionCost("high standard and automated",130),0);
	   }
}
