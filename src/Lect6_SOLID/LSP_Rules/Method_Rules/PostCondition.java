package Lect6_SOLID.LSP_Rules.Method_Rules;


// Subclass can stregthen the condition but not weaken it


class Car{
    protected int speed ;

    public Car(){
        speed = 0;
    }
    public void accelerate(){
        System.out.println("Accelerating");
        speed += 20;
    }

    public void brake(){
        System.out.println("Brake applied");
        speed -= 20;
    }

}


class EVCar extends Car{
    private int charge;

    EVCar(){
        super();
        charge = 0;
    }
    public void brake(){
        System.out.println("Brake applied");
        speed -= 20;
        charge += 20;

    }
    public int getCharge(){
        return this.charge;
    }
}
public class PostCondition {
    public static void main(String[] args) {
        Car car = new EVCar();

        car.accelerate();
        car.accelerate();
        car.brake();
        System.out.println(((EVCar) car).getCharge());
    }
}
