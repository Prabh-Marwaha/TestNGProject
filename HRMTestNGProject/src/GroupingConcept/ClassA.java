package GroupingConcept;

import org.testng.annotations.Test;

public class ClassA {
	@Test(groups="Smoke")
	public void M1() {
		System.out.println("Class A---------M1");
	}
	
   @Test(groups="Snaity")
	public void M2() {
		System.out.println("Class A---------M2");
	}
   
   
   @Test(groups="Functional")
   public void M3() {
	System.out.println("Class A---------M3");
}
   

   @Test(groups="Functional,Regression,Sanity")
   public void M4() {
	System.out.println("Class A---------M4");
}
   

  @Test(groups= {"Regression","Smoke"})
  public void M5() {
	System.out.println("Class A---------M5");
}
  
  
  @Test(groups="Regression")
  public void M6() {
	System.out.println("Class A---------M6");
	
}
//  @Test(groups="window.Smoke")
//  public void M7() {
//	System.out.println("Class A---------M7");
//}
  
//  @Test(groups="window.Smoke")
//  public void M8() {
//	System.out.println("Class A---------M8");
//}
  
//  @Test(groups="window.Sanity")
//  public void M9() {
//	System.out.println("Class A---------M9");
//}
 


}
