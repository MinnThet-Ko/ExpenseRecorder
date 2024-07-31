package com.er.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher {
	
	@Id
	@Column(name = "voucher_id")
	private String voucherID;
	
	private String voucherDescription;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date voucherDate;
	
	private long voucherAmount;
	

}
