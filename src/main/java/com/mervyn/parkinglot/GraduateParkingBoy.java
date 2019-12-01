package com.mervyn.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraduateParkingBoy {

    private List<ParkingLot> parkingLots;
    private Map<Ticket,ParkingLot> parkingLotMap;

    public GraduateParkingBoy(int size) {
        init(size);
    }


    private void init(int size){
        parkingLots = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            parkingLots.add(new ParkingLot("park-" + i));
        }
        parkingLotMap = new HashMap<>();
    }

    public Ticket park(Car car){
        for (ParkingLot lot : parkingLots) {
            if (lot.isFull()){
                continue;
            }
            Ticket ticket = lot.park(car);
            parkingLotMap.put(ticket,lot);
            return ticket;
        }
        throw new ParkingLotException("所有停车场已满");
    }

    public String getParkNameByTicket(Ticket ticket){
        ParkingLot lot = parkingLotMap.get(ticket);
        if (lot == null){
            throw new ParkingLotException("无效凭证");
        }
        return lot.getName();
    }

    public Car pick(Ticket ticket) {
        ParkingLot lot = parkingLotMap.remove(ticket);
        if (lot == null){
            throw new ParkingLotException("无效凭证");
        }
        return lot.pick(ticket);
    }
}
