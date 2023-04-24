package com.healthdeclaration.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EntityScan
public class HealthDeclaration {
    private Integer id;
    private String fullName;
    private int yearBirthday;
    private String gender;
    private String nationality;
    private String identification;
    private String vehicle;
    private String numberPlate;
    private String numberSeat;
    private LocalDate startDate;
    private int startDay;
    private int startMonth;
    private int startYear;
    private LocalDate endDate;
    private int endDay;
    private int endMonth;
    private int endYear;
    private String infoWithin14days;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;
    private List<String> symptomsWithin14days;
    private String fever;
    private String cough;
    private String shortnessOfBreath;
    private String soreThroat;
    private List<String> historyExposuresWithin14days;
    private String visit;
    private String closeContact;

    public HealthDeclaration() {
    }

    public HealthDeclaration(Integer id, String fullName, int yearBirthday, String gender, String nationality, String identification, String vehicle, String numberPlate, String numberSeat, LocalDate startDate, int startDay, int startMonth, int startYear, LocalDate endDate, int endDay, int endMonth, int endYear, String infoWithin14days, String city, String district, String ward, String address, String phone, String email, List<String> symptomsWithin14days, String fever, String cough, String shortnessOfBreath, String soreThroat, List<String> historyExposuresWithin14days, String visit, String closeContact) {
        this.id = id;
        this.fullName = fullName;
        this.yearBirthday = yearBirthday;
        this.gender = gender;
        this.nationality = nationality;
        this.identification = identification;
        this.vehicle = vehicle;
        this.numberPlate = numberPlate;
        this.numberSeat = numberSeat;
        this.startDate = startDate;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDate = endDate;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.infoWithin14days = infoWithin14days;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptomsWithin14days = symptomsWithin14days;
        this.fever = fever;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.historyExposuresWithin14days = historyExposuresWithin14days;
        this.visit = visit;
        this.closeContact = closeContact;
    }
}
