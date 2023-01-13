package com.example.statemachinejava.domain;

import java.util.Set;

import static java.util.Set.of;

public enum PaymentState {
    NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR;

    public static Set<PaymentState> paymentStates() {
        return of(
            NEW, PRE_AUTH, PRE_AUTH_ERROR, AUTH, AUTH_ERROR
        );
    }
}
