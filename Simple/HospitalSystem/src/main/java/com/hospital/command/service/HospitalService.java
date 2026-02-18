package com.hospital.command.service;

public class HospitalService {
    public int admitPanel(int patientId,int wardNo){
        System.out.println("Patient "+patientId+" admitted to ward "+wardNo);
        return 1;
    }

    public int calculateBill(int days,int dailyCharge){
        int amount=days*dailyCharge;
        System.out.println("Total bill : "+amount);
        return amount;
    }

    public int medicineDosage(int age,int baseDose){
        int dosage=(age<12)? baseDose/2 :baseDose;
        System.out.println("prescribed dosage : "+dosage);
        return dosage;
    }
}
