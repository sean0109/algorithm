package main.mypractice.designpattern.singleton.ex0;

public enum AddressData {
    SERVER_1("http://server1.com"),
    SERVER_2("http://server2.com"),
    SERVER_3("http://server3.com");

    private final String address;

    AddressData(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
