package activity1;



public class Activity1 {

    public static void main(String[] args) {
        activity1.Car toyota = new Car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";

        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }
}


