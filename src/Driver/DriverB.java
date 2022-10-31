package Driver;

import Transport.Car;

public class DriverB extends Driver<Car> {

    private final DriverLicense driverLicense = DriverLicense.LICENSE_B;

    public DriverB(String fullName, boolean havingLicense, int drivingExperience) {
        super(fullName, havingLicense, drivingExperience);
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    @Override
    public void startDriving() {
        System.out.print("Водитель " + getFullName() + " начинает движение на автомобиле. ");
        drivenTransport.startDriving();
    }

    @Override
    public void stopDriving() {
        System.out.print("Водитель " + getFullName() + " останавливает автомобиль. ");
        drivenTransport.finishDriving();
    }

    @Override
    public void refillTransport() {
        System.out.println("Водитель " + getFullName() + " заправляет автомобиль");
    }

    public void drive() {
        System.out.println("Водитель " + getFullName() + " управляет " + drivenTransport.getBrand() + " " + drivenTransport.getModel() + " и будет участвовать в заезде");
    }
}
