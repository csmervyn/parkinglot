package com.mervyn.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends AbstractSmartParkingBoy{

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots,new SuperParkingLotComparator());
    }


    static class SuperParkingLotComparator implements Comparator<ParkingLot> {
        @Override
        public int compare(ParkingLot o1, ParkingLot o2) {
            System.out.println("o2.vacancyRate(),o1.vacancyRate()" + o2.vacancyRate() + " : "+ o1.vacancyRate());
            return Double.compare(o2.vacancyRate(),o1.vacancyRate());
        }
    }
}
