package com.mervyn.parkinglot;


import java.util.HashMap;

public class ParkingLot {
    private String name;
    private static int DEFAULT_SIZE = 100;
    private int size;

    private HashMap<Ticket, Car> parkingPlace;

    public ParkingLot() {
        this("",DEFAULT_SIZE);
    }

    public ParkingLot(int size) {
        this("",size);
    }

    public ParkingLot(String name, int size) {
        this.name = name;
        this.size = size;
        this.parkingPlace = new HashMap<>(size);
    }

    public ParkingLot(String name) {
        this(name,DEFAULT_SIZE);
    }

    public Ticket park(Car car) {
        // 1.判断停车场是否有足够的位置
        if (parkingPlace.size() >= size) {
            //return null;
            throw new ParkingLotException("停车失败");
        }
        Ticket ticket = new Ticket();
        parkingPlace.put(ticket, car);
        return ticket;
    }

    public boolean isFull(){
        return parkingPlace.size() == size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car pick(Ticket ticket){
        Car car = parkingPlace.remove(ticket);
        if (car == null){
            throw new ParkingLotException("无效凭证");
        }
        return car;
    }
}
