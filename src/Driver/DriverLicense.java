package Driver;

public enum DriverLicense {
    LICENSE_B("Водительское удостоверение категории B"),
    LICENSE_C("Водительское удостоверение категории C"),
    LICENSE_D("Водительское удостоверение категории D");

    private String licenceType;

    DriverLicense(String licenceType) {
        if (licenceType != null && !licenceType.isEmpty() && !licenceType.isBlank()) {
            this.licenceType = licenceType;
        }
    }

    public String getLicenceType() {
        return licenceType;
    }
}
