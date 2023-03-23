package com.prateek.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportingManager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long managerId;
	@OneToOne
	private Employee employee;
	@OneToMany(mappedBy = "directReportee")@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
}
