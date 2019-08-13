package DecoratorDesignPattern;

public class TomatoSauce extends ToppingDecorator{
	public TomatoSauce(Pizza newPizza)  {
		super(newPizza);
		System.out.println("Adding Tomato Sauce ");
	}
	
	public String getDescription() {
		return this.tempPizza.getDescription() + ", Tomato Sauce";
	}
	
	public double getCost() {
		return tempPizza.getCost() + .40;
	}
}
