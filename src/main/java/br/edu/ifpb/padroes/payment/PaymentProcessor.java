package br.edu.ifpb.padroes.payment;

import br.edu.ifpb.padroes.domain.Property;

public abstract class PaymentProcessor implements PaymentProcessorHandler {

    private PaymentProcessorHandler next;

    @Override
    public PaymentProcessorHandler setNext(PaymentProcessorHandler paymentProcessorHandler){
        this.next = paymentProcessorHandler;
        return this.next;
    }

    public void nextPayment(Property property){
        if(this.next != null)
            this.next.process(property);
    }
}
