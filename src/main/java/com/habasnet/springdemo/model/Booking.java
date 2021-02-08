package com.habasnet.springdemo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private long    id;
	@NotNull
	private String 	packageName;
	private int 	numberOfAdults;
	private int 	numberOfChildren;
	@NotNull( message = "Name cannot be empty")
	@Size(min = 3, max = 20)
	private String  fullName;
	@NotNull( message = "Email cannot be empty")
	@Email(message = "Email should be valid")
	private String 	email;
	private String 	address;
	@Length(min = 9, max = 10)
	@Pattern(regexp = "^\\+?\\d.{0,3}\\s?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}?", message = "Enter valid phone number")
	private String  phoneNumber;
	private String 	country;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate 	arrivalDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate 	departureDate;
	private String 	airlines;
	private String 	flightNo;
	private String  message;
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
}
