package GroupingConcept;

import org.testng.annotations.Test;

public class ClassB {
	@Test(groups="Smoke")
	public void M1() {
		System.out.println("Class B---------M1");
	}
	
   @Test(groups="Snaity")
	public void M2() {
		System.out.println("Class B---------M2");
	}
   
   
   @Test(groups="Functional")
   public void M3() {
	System.out.println("Class B---------M3");
}
   

   @Test(groups="Functional,Regression,Sanity")
   public void M4() {
	System.out.println("Class B---------M4");
}
   

  @Test(groups= {"Regression","smoke"})
  public void M5() {
	System.out.println("Class B---------M5");
}
  
  
  @Test(groups="Regression")
  public void M6() {
	System.out.println("Class B---------M6");
}
  @Test(groups="window.Smoke")
  public void M7() {
	System.out.println("Class B---------M7");
}
  @Test(groups="window.Smoke")
  public void M8() {
	System.out.println("Class B---------M8");
}
  @Test(groups="window.Sanity")
  public void M9() {
	System.out.println("Class B---------M9");
}
  @Test(groups="linux.Sanity")
  public void M10() {
	System.out.println("Class B---------M10");
}


}
