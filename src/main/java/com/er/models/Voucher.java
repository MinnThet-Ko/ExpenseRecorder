package com.er.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Voucher {
	
	@Id
	private String voucherID;
	
	@Column
	private String voucherDescription;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date voucherDate;
	
	@Column
	private long voucherAmount;
	
	@Column
	private String accountID;
}
