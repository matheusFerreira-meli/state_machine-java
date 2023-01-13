package com.example.statemachinejava.config;

import com.example.statemachinejava.domain.PaymentEvent;
import com.example.statemachinejava.domain.PaymentState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

import static com.example.statemachinejava.domain.PaymentState.paymentStates;

@Configuration
@EnableStateMachine
@Slf4j
public class StateMachineConfig extends StateMachineConfigurerAdapter<PaymentState, PaymentEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<PaymentState, PaymentEvent> states) throws Exception {
        states.withStates()
                .initial(PaymentState.NEW)
//                .states(EnumSet.allOf(PaymentState.class))
                .states(paymentStates())
                .end(PaymentState.AUTH)
                .end(PaymentState.PRE_AUTH_ERROR)
                .end(PaymentState.AUTH_ERROR);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<PaymentState, PaymentEvent> transitions) throws Exception {
        transitions.withExternal()
                .source(PaymentState.NEW)
                .target(PaymentState.NEW)
                .event(PaymentEvent.PRE_AUTHORIZE)
                .and()
                .withExternal()
                .source(PaymentState.PRE_AUTH)
                .target(PaymentState.PRE_AUTH)
                .event(PaymentEvent.PRE_AUTH_APPROVED);
    }
}
