package com.p2p.domain;

public class Loan {

    // Status loan
    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    private Status status;

    // Default status
    public Loan() {
        this.status = Status.PENDING;
    }

    // Setter
    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter
    public Status getStatus() {
        return status;
    }

    // DOMAIN BEHAVIOR
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }
}