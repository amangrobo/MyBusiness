package com.grobo.mybusiness.models;

public class Customer {

    private String customerName;
    private String purchaseDate;
    private String purchaseLocation;
    private String customerPhone;

    private String customerNotes;

    private int khapraPrice;
    private int mangraPrice;
    private int koniaPrice;
    private int pillar12ftPrice;
    private int pillar10ftPrice;
    private int pillar8ftPrice;
    private int pillar3ftPrice;
    private int asbestos10ftPrice;
    private int asbestos8ftPrice;
    private int asbestos6ftPrice;

    private int khapraAmount;
    private int mangraAmount;
    private int koniaAmount;
    private int pillar12ftAmount;
    private int pillar10ftAmount;
    private int pillar8ftAmount;
    private int pillar3ftAmount;
    private int asbestos10ftAmount;
    private int asbestos8ftAmount;
    private int asbestos6ftAmount;

    private int labourTotal;
    private int transportTotal;
    private int otherTotal;
    private int discountTotal;
    private int paidTotal;

    private int totalAmount;
    private int leftAmount;

    public Customer(){}

    public Customer(String customerName, String purchaseDate, String purchaseLocation, String customerPhone, int totalAmount, int leftAmount){
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.purchaseLocation = purchaseLocation;
        this.customerPhone = customerPhone;
        this.totalAmount = totalAmount;
        this.leftAmount = leftAmount;
    }

    public Customer(String customerName, String purchaseDate, String purchaseLocation, String customerPhone, String customerNotes,
                    int khapraAmount, int khapraPrice, int mangraAmount, int mangraPrice, int koniaAmount, int koniaPrice,
                    int pillar12ftAmount, int pillar12ftPrice, int pillar10ftAmount, int pillar10ftPrice, int pillar8ftAmount, int pillar8ftPrice, int pillar3ftAmount, int pillar3ftPrice,
                    int asbestos10ftAmount, int asbestos10ftPrice, int asbestos8ftAmount, int asbestos8ftPrice, int asbestos6ftAmount, int asbestos6ftPrice,
                    int labourTotal, int transportTotal, int otherTotal, int discountTotal, int totalAmount, int paidTotal, int leftAmount){

        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.purchaseLocation = purchaseLocation;
        this.customerPhone = customerPhone;
        this.customerNotes = customerNotes;
        this.khapraAmount = khapraAmount;
        this.khapraPrice = khapraPrice;
        this.mangraAmount = mangraAmount;
        this.mangraPrice = mangraPrice;
        this.koniaAmount = koniaAmount;
        this.koniaPrice = koniaPrice;
        this.pillar12ftAmount = pillar12ftAmount;
        this.pillar12ftPrice = pillar12ftPrice;
        this.pillar10ftAmount = pillar10ftAmount;
        this.pillar10ftPrice = pillar10ftPrice;
        this.pillar8ftAmount = pillar8ftAmount;
        this.pillar8ftPrice = pillar8ftPrice;
        this.pillar3ftAmount = pillar3ftAmount;
        this.pillar3ftPrice = pillar3ftPrice;
        this.asbestos10ftAmount = asbestos10ftAmount;
        this.asbestos10ftPrice = asbestos10ftPrice;
        this.asbestos8ftAmount = asbestos8ftAmount;
        this.asbestos8ftPrice = asbestos8ftPrice;
        this.asbestos6ftAmount = asbestos6ftAmount;
        this.asbestos6ftPrice = asbestos6ftPrice;
        this.labourTotal = labourTotal;
        this.transportTotal = transportTotal;
        this.otherTotal = otherTotal;
        this.discountTotal = discountTotal;
        this.paidTotal = paidTotal;
        this.totalAmount = totalAmount;
        this.leftAmount = leftAmount;
    }

    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getPurchaseDate(){
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseLocation(){
        return purchaseLocation;
    }
    public void setPurchaseLocation(String purchaseLocation){
        this.purchaseLocation = purchaseLocation;
    }

    public String getCustomerPhone(){
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone){
        this.customerPhone = customerPhone;
    }

    public int getKhapraPrice(){
        return khapraPrice;
    }

    public int getAsbestos6ftAmount() {
        return asbestos6ftAmount;
    }

    public int getAsbestos6ftPrice() {
        return asbestos6ftPrice;
    }

    public int getAsbestos8ftAmount() {
        return asbestos8ftAmount;
    }

    public int getAsbestos8ftPrice() {
        return asbestos8ftPrice;
    }

    public int getAsbestos10ftAmount() {
        return asbestos10ftAmount;
    }

    public int getAsbestos10ftPrice() {
        return asbestos10ftPrice;
    }

    public int getDiscountTotal() {
        return discountTotal;
    }

    public int getKhapraAmount() {
        return khapraAmount;
    }

    public int getKoniaAmount() {
        return koniaAmount;
    }

    public int getKoniaPrice() {
        return koniaPrice;
    }

    public int getLabourTotal() {
        return labourTotal;
    }

    public int getMangraAmount() {
        return mangraAmount;
    }

    public int getMangraPrice() {
        return mangraPrice;
    }

    public int getOtherTotal() {
        return otherTotal;
    }

    public int getPillar3ftAmount() {
        return pillar3ftAmount;
    }

    public int getPillar3ftPrice() {
        return pillar3ftPrice;
    }

    public int getPillar8ftAmount() {
        return pillar8ftAmount;
    }

    public int getPillar8ftPrice() {
        return pillar8ftPrice;
    }

    public int getPillar10ftAmount() {
        return pillar10ftAmount;
    }

    public int getPillar10ftPrice() {
        return pillar10ftPrice;
    }

    public int getPillar12ftAmount() {
        return pillar12ftAmount;
    }

    public int getPillar12ftPrice() {
        return pillar12ftPrice;
    }

    public int getTransportTotal() {
        return transportTotal;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setKhapraPrice(int khapraPrice){
        this.khapraPrice = khapraPrice;
    }

    public void setAsbestos6ftAmount(int asbestos6ftAmount) {
        this.asbestos6ftAmount = asbestos6ftAmount;
    }

    public void setAsbestos6ftPrice(int asbestos6ftPrice) {
        this.asbestos6ftPrice = asbestos6ftPrice;
    }

    public void setAsbestos8ftAmount(int asbestos8ftAmount) {
        this.asbestos8ftAmount = asbestos8ftAmount;
    }

    public void setAsbestos8ftPrice(int asbestos8ftPrice) {
        this.asbestos8ftPrice = asbestos8ftPrice;
    }

    public void setAsbestos10ftAmount(int asbestos10ftAmount) {
        this.asbestos10ftAmount = asbestos10ftAmount;
    }

    public void setAsbestos10ftPrice(int asbestos10ftPrice) {
        this.asbestos10ftPrice = asbestos10ftPrice;
    }

    public void setDiscountTotal(int discountTotal) {
        this.discountTotal = discountTotal;
    }

    public void setKhapraAmount(int khapraAmount) {
        this.khapraAmount = khapraAmount;
    }

    public void setKoniaAmount(int koniaAmount) {
        this.koniaAmount = koniaAmount;
    }

    public void setKoniaPrice(int koniaPrice) {
        this.koniaPrice = koniaPrice;
    }

    public void setLabourTotal(int labourTotal) {
        this.labourTotal = labourTotal;
    }

    public void setMangraAmount(int mangraAmount) {
        this.mangraAmount = mangraAmount;
    }

    public void setMangraPrice(int mangraPrice) {
        this.mangraPrice = mangraPrice;
    }

    public void setOtherTotal(int otherTotal) {
        this.otherTotal = otherTotal;
    }

    public void setPillar3ftAmount(int pillar3ftAmount) {
        this.pillar3ftAmount = pillar3ftAmount;
    }

    public void setPillar3ftPrice(int pillar3ftPrice) {
        this.pillar3ftPrice = pillar3ftPrice;
    }

    public void setPillar8ftAmount(int pillar8ftAmount) {
        this.pillar8ftAmount = pillar8ftAmount;
    }

    public void setPillar8ftPrice(int pillar8ftPrice) {
        this.pillar8ftPrice = pillar8ftPrice;
    }

    public void setPillar10ftAmount(int pillar10ftAmount) {
        this.pillar10ftAmount = pillar10ftAmount;
    }

    public void setPillar10ftPrice(int pillar10ftPrice) {
        this.pillar10ftPrice = pillar10ftPrice;
    }

    public void setPillar12ftAmount(int pillar12ftAmount) {
        this.pillar12ftAmount = pillar12ftAmount;
    }

    public void setPillar12ftPrice(int pillar12ftPrice) {
        this.pillar12ftPrice = pillar12ftPrice;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTransportTotal(int transportTotal) {
        this.transportTotal = transportTotal;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
    }

    public int getLeftAmount() {
        return leftAmount;
    }

    public int getPaidTotal() {
        return paidTotal;
    }

    public void setLeftAmount(int leftAmount) {
        this.leftAmount = leftAmount;
    }

    public void setPaidTotal(int paidTotal) {
        this.paidTotal = paidTotal;
    }
}
