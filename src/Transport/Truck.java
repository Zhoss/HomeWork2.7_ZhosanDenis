package Transport;

public class Truck extends Transport implements Competing {

    public enum CarryingCapacity {
        N1("с полной массой до 3,5 тонн"),
        N2("с полной массой свыше 3,5 до 12 тонн"),
        N3("с полной массой свыше 12 тонн");

        public static void identifyCarryingCapacity(Truck truck) {
            if (truck.getCarryingCapacity() != null) {
                System.out.println("Грузоподъемность " + truck.getBrand() + " " + truck.getModel() + " - " + truck.getCarryingCapacity().getCarryingCapacityString());
            } else {
                System.out.println("Данных по грузовику недостаточно");
            }
        }

        private String carryingCapacityString;

        CarryingCapacity(String carryingCapacityString) {
            if (carryingCapacityString != null && !carryingCapacityString.isEmpty() && !carryingCapacityString.isBlank()) {
                this.carryingCapacityString = carryingCapacityString;
            }
        }

        public String getCarryingCapacityString() {
            return carryingCapacityString;
        }
    }

    private CarryingCapacity carryingCapacity;

    private final boolean haveDiagnostic;

    public Truck(String brand, String model, double engineVolume, CarryingCapacity carryingCapacity, boolean haveDiagnostic) {
        super(brand, model, engineVolume);
        if (carryingCapacity != null) {
            this.carryingCapacity = carryingCapacity;
        }
        this.haveDiagnostic = haveDiagnostic;
    }

    public CarryingCapacity getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public void startDriving() {
        System.out.println("Грузовик " + getBrand() + " " + getBrand() + " стартует");
    }

    @Override
    public void finishDriving() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " останавливается");
    }

    @Override
    public void pitStop() {
        finishDriving();
        System.out.println("Заменяются колеса, заливается топливо");
        startDriving();
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга грузовика " + getBrand() + " " + getModel() + " m сек");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость грузовика " + getBrand() + " " + getModel() + " m км/ч");
    }

    @Override
    public boolean passedDiagnostics() {
        return haveDiagnostic;
    }

    @Override
    public String toString() {
        return "Грузовик " + getBrand() +
                ", модель - " + getModel() +
                ", объем двигателя - " + getEngineVolume() + " л";
    }
}
