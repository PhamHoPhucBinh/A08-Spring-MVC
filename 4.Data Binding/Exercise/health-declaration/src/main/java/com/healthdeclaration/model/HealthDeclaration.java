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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearBirthday() {
        return yearBirthday;
    }

    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(String numberSeat) {
        this.numberSeat = numberSeat;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getInfoWithin14days() {
        return infoWithin14days;
    }

    public void setInfoWithin14days(String infoWithin14days) {
        this.infoWithin14days = infoWithin14days;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSymptomsWithin14days() {
        return symptomsWithin14days;
    }

    public void setSymptomsWithin14days(List<String> symptomsWithin14days) {
        this.symptomsWithin14days = symptomsWithin14days;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(String shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public String getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(String soreThroat) {
        this.soreThroat = soreThroat;
    }

    public List<String> getHistoryExposuresWithin14days() {
        return historyExposuresWithin14days;
    }

    public void setHistoryExposuresWithin14days(List<String> historyExposuresWithin14days) {
        this.historyExposuresWithin14days = historyExposuresWithin14days;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getCloseContact() {
        return closeContact;
    }

    public void setCloseContact(String closeContact) {
        this.closeContact = closeContact;
    }
}
