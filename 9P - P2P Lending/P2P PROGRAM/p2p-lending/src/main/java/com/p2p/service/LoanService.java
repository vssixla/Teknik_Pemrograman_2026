package com.p2p.service;

import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {

    // Logger untuk mencatat aktivitas sistem (info, warn, error)
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // =========================
        // VALIDASI BORROWER
        // =========================
        // Memastikan borrower sudah lolos KYC sebelum mengajukan loan
        validateBorrower(borrower);

        // =========================
        // VALIDASI AMOUNT
        // =========================
        // Memastikan jumlah pinjaman valid (> 0)
        validateAmount(amount);

        // =========================
        // CREATE LOAN OBJECT
        // =========================
        // Membuat objek loan baru dengan status awal PENDING
        Loan loan = new Loan();

        // =========================
        // CREDIT SCORING
        // =========================
        // Menentukan apakah loan disetujui atau ditolak
        if (borrower.hasGoodCredit()) {

            // Logging informasi jika loan disetujui
            logger.info("Loan approved for borrower with score: {}", borrower.getCreditScore());

            // Mengubah status loan menjadi APPROVED
            loan.approve();

        } else {

            // Logging peringatan jika loan ditolak karena skor rendah
            logger.warn("Loan rejected. Credit score too low: {}", borrower.getCreditScore());

            // Mengubah status loan menjadi REJECTED
            loan.reject();
        }

        // Mengembalikan hasil loan
        return loan;
    }

    // =========================
    // METHOD VALIDASI BORROWER
    // =========================
    // Mengecek apakah borrower sudah terverifikasi (KYC)
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {

            // Logging error jika borrower belum verified
            logger.error("Loan creation failed: borrower not verified");

            // Melempar exception untuk menghentikan proses
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    // =========================
    // METHOD VALIDASI AMOUNT
    // =========================
    // Mengecek apakah amount > 0
    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {

            // Logging error jika amount tidak valid
            logger.error("Invalid loan amount: {}", amount);

            // Melempar exception jika tidak valid
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}