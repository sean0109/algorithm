package main.mypractice.lang.object.example2plus;

public enum TypeData {
    GOLD(30),
    SILVER(20);

    private final int rate;

    TypeData(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
