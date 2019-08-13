package DecoratorDesignPattern;

public class Mozzarella extends ToppingDecorator{
	public Mozzarella(Pizza newPizza)  {
		super(newPizza);
		System.out.println("Adding Mozzarella ");
	}
	
	public String getDescription() {
		return this.tempPizza.getDescription() + ", Mozzarella";
	}
	
	public double getCost() {
		return tempPizza.getCost() + .50;
	}
}
