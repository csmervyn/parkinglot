package com.mervyn.parkinglot;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmartParkingBoy extends AbstractSmartParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots,new ParkingLotComparator());
    }

    static class ParkingLotComparator implements Comparator<ParkingLot> {
        @Override
        public int compare(ParkingLot o1, ParkingLot o2) {
            return o2.emptyCount() - o1.emptyCount();
        }
    }
}
