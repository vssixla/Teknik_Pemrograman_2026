package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act & Assert
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {

        // =====================================================
        // SCENARIO:
        // Borrower valid
        // Amount pinjaman bernilai 0 atau negatif
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(0);

        // =========================
        // Act & Assert
        // =========================
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {

        // =====================================================
        // SCENARIO:
        // Borrower sudah terverifikasi
        // Credit score memenuhi threshold (≥ 600)
        // Maka sistem harus menyetujui loan
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action)
        // =========================
        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert (Expected Result)
        // =========================
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {

        // =====================================================
        // SCENARIO:
        // Borrower sudah terverifikasi
        // Credit score di bawah threshold (< 600)
        // Maka sistem harus menolak loan
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================

        // Borrower verified dengan credit score rendah
        Borrower borrower = new Borrower(true, 500);

        // Service loan
        LoanService loanService = new LoanService();

        // Amount valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action)
        // =========================

        Loan loan = loanService.createLoan(borrower, amount);

        // =========================
        // Assert (Expected Result)
        // =========================

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}