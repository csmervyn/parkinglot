package com.mervyn.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraduateParkingBoy implements Parking{

    private List<ParkingLot> parkingLots;
    private Map<Ticket, ParkingLot> parkingLotMap;

    public GraduateParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLotMap = new HashMap<>();
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) {
        for (ParkingLot lot : parkingLots) {
            if (lot.isFull()) {
                continue;
            }
            Ticket ticket = lot.park(car);
            parkingLotMap.put(ticket, lot);
            return ticket;
        }
        throw new ParkingLotException("所有停车场已满");
    }

    @Override
    public Car pick(Ticket ticket) {
        ParkingLot lot = parkingLotMap.remove(ticket);
        if (lot == null) {
            throw new ParkingLotException("无效凭证");
        }
        return lot.pick(ticket);
    }
}
