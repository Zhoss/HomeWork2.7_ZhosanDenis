package Transport;

public class Bus extends Transport implements Competing {

    public enum SeatQuantity {
        ESPECIALLY_SMALL("до 10 мест"),
        SMALL("до 25 мест"),
        AVERAGE("40-50 мест"),
        LARGE("60-80 мест"),
        EXTRA_LARGE("100-120 мест");

        public static void identifySeatQuantity(Bus bus) {
            if (bus.getSeatQuantity() != null) {
                System.out.println("Количество мест в автобусе " + bus.getBrand() + " " + bus.getModel() + " - " + bus.getSeatQuantity().getSeatQuantityString());
            } else {
                System.out.println("Данных по автобусу недостаточно");
            }
        }

        private String seatQuantityString;

        SeatQuantity(String seatQuantityString) {
            if (seatQuantityString != null && !seatQuantityString.isEmpty() && !seatQuantityString.isBlank()) {
                this.seatQuantityString = seatQuantityString;
            }
        }

        public String getSeatQuantityString() {
            return seatQuantityString;
        }
    }

    private SeatQuantity seatQuantity;

    public Bus(String brand, String model, double engineVolume, SeatQuantity seatQuantity) {
        super(brand, model, engineVolume);
        if (seatQuantity != null) {
            this.seatQuantity = seatQuantity;
        }
    }

    public SeatQuantity getSeatQuantity() {
        return seatQuantity;
    }

    @Override
    public void startDriving() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " стартует");
    }

    @Override
    public void finishDriving() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " останавливается");
    }

    @Override
    public void pitStop() {
        finishDriving();
        System.out.println("Заменяются колеса, заливается топливо");
        startDriving();
    }

    @Override
    public void bestLapTime() {
        System.out.println("Лучшее время круга автобуса " + getBrand() + " " + getModel() + " k сек");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость автобуса " + getBrand() + " " + getModel() + " k км/ч");
    }

    @Override
    public boolean passedDiagnostics() {
        return false;
    }

    @Override
    public String toString() {
        return "Автобус " + getBrand() +
                ", модель - " + getModel() +
                ", объем двигателя - " + getEngineVolume() + " л";
    }
}
