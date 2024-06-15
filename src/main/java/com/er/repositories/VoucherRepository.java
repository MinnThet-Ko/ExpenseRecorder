package com.er.repositories;

import com.er.models.Voucher;

public interface VoucherRepository {
	public boolean insertVoucher(Voucher voucher);
	public boolean updateVoucher(Voucher voucher);
	public boolean deleteVoucher(String voucherID);
}
