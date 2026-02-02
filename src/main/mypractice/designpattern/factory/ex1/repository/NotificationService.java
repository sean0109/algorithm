package main.mypractice.designpattern.factory.ex1.repository;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;

public interface NotificationService {

    void send(SendDTO sendData) throws SendException;
}
