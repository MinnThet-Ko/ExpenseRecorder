package com.er.models;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "account_vouchers",
	joinColumns = @JoinColumn(name = "voucher_id"),
	inverseJoinColumns = @JoinColumn(name = "account_id"))
	private Account account;
	
	

}
