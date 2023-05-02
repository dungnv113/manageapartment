//package com.dung.manageapartment.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "bill_utility")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class BillUtility {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "bill_id")
//    private Bill bill;
//
//    @ManyToOne
//    @JoinColumn(name = "utility_id")
//    private Utility utility;
//
//    private int number;
//
//
//
//    // Other fields and methods
//}