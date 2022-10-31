package Driver;

import Transport.Transport;

public abstract class Driver <T extends Transport> {
    private String fullName;
    private boolean havingLicense;
    private int drivingExperience;
    protected T drivenTransport;

    public Driver(String fullName, boolean havingLicense, int drivingExperience) {
        if (fullName != null && !fullName.isBlank()) {
            this.fullName = fullName;
        } else {
            System.out.println("Нужно указать фамилию, имя, отчество");
        }

        if (havingLicense) {
            this.havingLicense = true;
        } else {
            throw new IllegalArgumentException("Водителю требуется наличие водительского удостоверения");
        }

        setDrivingExperience(drivingExperience);
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHavingLicense() {
        return havingLicense;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public T getDrivenTransport() {
        return drivenTransport;
    }


    public void setHavingLicense(boolean havingLicense) {
        this.havingLicense = havingLicense;
    }

    public void setDrivingExperience(int drivingExperience) {
        if (drivingExperience > 0 && drivingExperience < 100) {
            this.drivingExperience = drivingExperience;
        } else {
            this.drivingExperience = 0;
        }
    }

    public void setDrivenTransport(T drivenTransport) {
        if (drivenTransport != null) {
            this.drivenTransport = drivenTransport;
        }
    }

    public abstract void startDriving();

    public abstract void stopDriving();

    public abstract void refillTransport();
}
