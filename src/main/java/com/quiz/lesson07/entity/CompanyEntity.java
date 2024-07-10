package com.quiz.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "company")
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyEntity {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String business;
	private String scale;
	private int headcount;
	
	@Column(name = "createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name = "updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
