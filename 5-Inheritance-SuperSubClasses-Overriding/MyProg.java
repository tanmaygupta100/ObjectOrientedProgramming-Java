import wheelsFX.users.Frame.Frame;

/**
 * Main program class meant for collecting and running the entire program.
 *
 * @author Tanmay Gupta
 * @version 1.0 , June 25th, 2023
 * @see wheelsFX.users.Frame.Frame
 */

public class MyProg
{

    /**
     * Main static class that instantiates and references all the classes in this package.
     * The cars in each package also have their locations on the screen shifted here.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //Car
        Car car = new Car(); // Creates an instance for the "Car" superclass
            car.makeBody(200, -25); // These 3 lines set the new locations to place the methods' outputs in.
            car.makeBackWheels(200, -25);
            car.makeFrontWheel(200,-25);


        //Extending Car pt.1
        CarTrailer cartrailer = new CarTrailer(); // Creates an instance for the "carTrailer" subclass
            cartrailer.makeTrailerBody(200,175);
            cartrailer.redrawCar(200,175);
            cartrailer.makeTrailerWheels(200,175);

        //Extending Car pt.2
        CarRocketAndGrillGuard carAddons = new CarRocketAndGrillGuard(); // Creates an instance for the "CarRocketAndGrillGuard" subclass
            carAddons.redrawCar(200, 375);
            carAddons.rocket(200, 375);
            carAddons.grillGuard(200,375);


        Frame.createFrame(); // Builds the window. Always the last thing in the main.
    }
}

/*
RUN OUTPUT:
3 cars laid out in a column in the frame window.
The first car on the top is the car itself from the "Car" superclass.
The second car in the middle is the car with a trailer on the back from the "CarTrailer" subclass.
The third car at the bottom is the car with a rocket and grill-guard from the "CarRocketAndGrillGuard" subclass.
 */
