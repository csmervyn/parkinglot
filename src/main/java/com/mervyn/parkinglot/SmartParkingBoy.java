package com.mervyn.parkinglot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmartParkingBoy implements Parking {

    private PriorityQueue<ParkingLot> parkingLotPriorityQueue;
    private Map<Ticket, ParkingLot> parkingLotMap;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLotPriorityQueue = new PriorityQueue<>(new ParkingLotComparator());
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


    private class ParkingLotComparator implements Comparator<ParkingLot> {
        @Override
        public int compare(ParkingLot o1, ParkingLot o2) {
            return o2.emptyCount() - o1.emptyCount();
        }
    }
}
