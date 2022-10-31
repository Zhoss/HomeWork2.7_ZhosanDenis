import Driver.DriverB;
import Driver.DriverC;
import Driver.DriverD;
import Transport.Bus;
import Transport.Car;
import Transport.Transport;
import Transport.Truck;

public class Main {
    public static void main(String[] args) {
        Data userA = new Data("John_999", "sgjih_jjhfjwe333", "sgjih_333");
        Data.checkAuthorization(userA);
        System.out.println("");

        Car subaru = new Car("Subaru", "Impreza", 2.0, Car.BodyType.SEDAN, true);
        Car mitsubishi = new Car("Mitsubishi", "Lancer", 2.5, null, true);
        Car citroen = new Car("Citroen", "C4", 2.2, Car.BodyType.HATCHBACK, true);
        Car ford = new Car("Ford", "Escort", 1.8, Car.BodyType.MINIVAN, true);
//        System.out.println(mitsubishi);
//        Car.BodyType.identifyBodyType(mitsubishi);
//        Car.BodyType.identifyBodyType(ford);
//        subaru.pitStop();
//        System.out.println("");

        Truck kamaz = new Truck("КАМАЗ", "4350-9", 12.0, Truck.CarryingCapacity.N2, true);
        Truck tatra = new Truck("Tatra", "T-138", 11.5, Truck.CarryingCapacity.N1, true);
        Truck iveco = new Truck("IVECO", "Iveco", 12.9, Truck.CarryingCapacity.N3, true);
        Truck ginaf = new Truck("Ginaf", "Rally Power", 11.7, null, true);
//        System.out.println(kamaz);
//        Truck.CarryingCapacity.identifyCarryingCapacity(iveco);
//        Truck.CarryingCapacity.identifyCarryingCapacity(ginaf);
//        tatra.bestLapTime();
//        System.out.println("");

        Bus man = new Bus("Man", "Lion’s City C", 9.0, Bus.SeatQuantity.SMALL);
        Bus volvo = new Bus("Volvo", "7900", 7.4, Bus.SeatQuantity.LARGE);
        Bus liaz = new Bus("ЛиАЗ", "5256.58", 6.7, Bus.SeatQuantity.EXTRA_LARGE);
        Bus hyundai = new Bus("Hyundai", "Aero Town", 7.5, null);
//        System.out.println(liaz);
//        Bus.SeatQuantity.identifySeatQuantity(man);
//        Bus.SeatQuantity.identifySeatQuantity(hyundai);
//        hyundai.maxSpeed();

        Transport[] garage = new Transport[]{subaru, mitsubishi, citroen, ford, kamaz, tatra, iveco, ginaf, man, volvo, liaz, hyundai};
        checkDiagnostics(garage);

        DriverB denis = new DriverB("Жосан Денис Сергеевич", true, 8);
        DriverC dmitriy = new DriverC("Василенко Дмитрий Петрович", true, 6);
        DriverD nicolai = new DriverD("Ткаченко Николай Александрович", true, 12);

//        System.out.println(nicolai.getDriverLicense().getLicenceType());

//        denis.setDrivenTransport(subaru);
//        denis.startDriving();
//        denis.drive();
//        dmitriy.setDrivenTransport(iveco);
//        dmitriy.drive();
//        nicolai.setDrivenTransport(man);
//        nicolai.drive();
    }

    public static void checkTransport(Transport[] transports) {
        for (Transport transport : transports) {
            if (transport.passedDiagnostics() && (transport.getClass() == Car.class || transport.getClass() == Truck.class)) {
                System.out.println("Транспорт " + transport.getBrand() + " " + transport.getModel() + " прошел диагностику");
            } else if (transport.getClass() == Bus.class) {
                System.out.println("Автобусу " + transport.getBrand() + " " + transport.getModel() + " не требуется диагностика");
            } else {
                throw new IllegalArgumentException("Транспортному средству " + transport.getBrand() + " " + transport.getModel() + " необходимо произвести диагностику");
            }
        }
    }

    public static void checkDiagnostics(Transport[] transports) {
        try {
            checkTransport(transports);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}