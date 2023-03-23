//package com.prateek.models;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity@Data@AllArgsConstructor@NoArgsConstructor
//public class RepeatEvent {
//
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Event event;
//	private LocalDateTime repetitionStartDate;
//	private LocalDateTime repetitionEndDate;
//	private String repeatEvery;
//	
//	
//}
