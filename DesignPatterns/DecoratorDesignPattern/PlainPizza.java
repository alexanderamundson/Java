package DecoratorDesignPattern;
// Every Pizza made will start as a PlainPizza

public class PlainPizza implements Pizza {
 
	public String getDescription() {
		return "Plain dough";	
	}

	public double getCost() {
		System.out.println("Cost of Plain Dough: " + 4.00);
		return 4.00;
	}
 
}