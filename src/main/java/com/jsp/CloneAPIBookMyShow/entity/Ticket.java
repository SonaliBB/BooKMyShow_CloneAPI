package com.jsp.CloneAPIBookMyShow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jsp.CloneAPIBookMyShow.enums.TicketStatus;

import lombok.Data;

@Entity
@Data
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long ticket_id;
private double total_price;

//TicketStatus
@Enumerated(EnumType.STRING)
private TicketStatus ticket_status; 
@ManyToOne
private Show show;

@OneToMany
private List<Booking> booking;

@ManyToOne
@JoinColumn
private Customer customer;



}
