package com.mervyn.parkinglot;


import java.util.HashMap;

public class ParkingLot {
    private static int DEFAULT_SIZE = 100;
    private int size;

    private HashMap<Ticket, Car> parkingPlace;

    public ParkingLot() {
        this.size = DEFAULT_SIZE;
        this.parkingPlace = new HashMap<>(size);
    }

    public ParkingLot(int size) {
        this.size = size;
        this.parkingPlace = new HashMap<>(size);
    }

    public Ticket park(Car car) {
        // 1.判断停车场是否有足够的位置
        if (parkingPlace.size() >= size) {
            return null;
        }
        Ticket ticket = new Ticket();
        parkingPlace.put(ticket, car);
        return ticket;
    }

    public Car pick(Ticket ticket){
        return parkingPlace.remove(ticket);
    }
}
