package com.mervyn.parkinglot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class AbstractSmartParkingBoy implements Parking{

    private PriorityQueue<ParkingLot> parkingLotPriorityQueue;
    private Map<Ticket, ParkingLot> parkingLotMap;

    protected AbstractSmartParkingBoy(List<ParkingLot> parkingLots, Comparator<ParkingLot> comparator) {
        this.parkingLotPriorityQueue = new PriorityQueue<>(comparator);
        this.parkingLotPriorityQueue.addAll(parkingLots);
        this.parkingLotMap = new HashMap<>();
    }

    @Override
    public Ticket park(Car car) {
        if (parkingLotPriorityQueue.isEmpty()) {
            throw new ParkingLotException("停车场暂未初始化");
        }
        ParkingLot parkingLot = parkingLotPriorityQueue.poll();
        Ticket ticket = parkingLot.park(car);
        parkingLotMap.put(ticket, parkingLot);
        parkingLotPriorityQueue.add(parkingLot);
        return ticket;
    }

    @Override
    public Car pick(Ticket ticket) {
        if (parkingLotPriorityQueue.isEmpty()) {
            throw new ParkingLotException("停车场暂未初始化");
        }
        ParkingLot parkingLot = parkingLotMap.remove(ticket);
        if (parkingLot == null) {
            throw new ParkingLotException("无效凭证");
        }
        Car car = parkingLot.pick(ticket);
        parkingLotPriorityQueue.remove(parkingLot);
        parkingLotPriorityQueue.add(parkingLot);
        return car;
    }


}
