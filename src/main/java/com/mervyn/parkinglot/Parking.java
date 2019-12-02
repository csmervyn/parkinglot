package com.mervyn.parkinglot;

public interface Parking {
    Ticket park(Car car);

    Car pick(Ticket ticket);
}
