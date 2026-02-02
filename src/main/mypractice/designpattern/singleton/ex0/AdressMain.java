package main.mypractice.designpattern.singleton.ex0;

public class AdressMain {
    public static void main(String[] args) {

        SingletonNetworkClient networkClient = SingletonNetworkClient.getInstance();

        networkClient.setAddress(AddressData.SERVER_2);

    }
}
