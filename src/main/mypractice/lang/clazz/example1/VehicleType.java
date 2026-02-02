package main.mypractice.lang.clazz.example1;

public enum VehicleType {

    CAR(Car.class),
    SUBWAY(Subway.class);

    // 클래스 정보를 인스턴스 변수로 가지고 있도록
    private final Class<? extends Engine> clazz;

    VehicleType(Class<? extends Engine> clazz) {
        this.clazz = clazz;
    }

    public Class makeInstance() {
        return clazz;
    }

    /*
    CAR("CAR"){
        @Override
        public Class makeInstance() throws ClassNotFoundException {
            return Class.forName("lang.clazz.mypractice.Car");
        }
    },
    SUBWAY("SUBWAY"){
        @Override
        public Class makeInstance() throws ClassNotFoundException {
            return Class.forName("lang.clazz.mypractice.Subway");
        }
    };

    private final String typeName;

    VehicleType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public abstract Class makeInstance() throws ClassNotFoundException;
*/

}
