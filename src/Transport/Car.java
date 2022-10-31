package Transport;

public class Car extends Transport implements Competing {

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP_TRUCK("Пикап"),
        WAGON("Фугон"),
        MINIVAN("Минивэн");

        public static void identifyBodyType(Car car) {
            if (car.getBodyType() != null) {
                System.out.println("Автомобиль " + car.getBrand() + " " + car.getModel() + " - " + car.getBodyType().getBodyTypeString());
            } else {
                System.out.println("Данных по автомобилю недостаточно");
            }
        }

        private String bodyTypeString;

        BodyType(String bodyType) {
            if (bodyType != null && !bodyType.isEmpty() && !bodyType.isBlank()) {
                this.bodyTypeString = bodyType;
            }
        }

        public String getBodyTypeString() {
            return bodyTypeString;
        }
    }

    private BodyType bodyType;

    private final boolean haveDiagnostic;

    public Car(String brand, String model, double engineVolume, BodyType bodyType, boolean haveDiagnostic) {
        super(brand, model, engineVolume);
        if (bodyType != null) {
            this.bodyType = bodyType;
        }

        this.haveDiagnostic = haveDiagnostic;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public boolean isHaveDiagnostic() {
        return haveDiagnostic;
    }

    @Override
    public void startDriving() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " стартует");
    }

    @Override
    public void finishDriving() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " останавливается");
    }

    @Override
    public void pitStop() {
        finishDriving();
        System.out.println("Заменяются колеса, заливается топливо");
        startDriving();
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга автомобиля " + getBrand() + " " + getModel() + " n сек");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость автомобиля " + getBrand() + " " + getModel() + " n км/ч");
    }

    @Override
    public boolean passedDiagnostics() {
        return haveDiagnostic;
    }

    @Override
    public String toString() {
        return "Автомобиль " + getBrand() +
                ", модель - " + getModel() +
                ", объем двигателя - " + getEngineVolume() + " л";
    }
}
