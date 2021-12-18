package br.edu.ifpb.padroes.payment;

import br.edu.ifpb.padroes.domain.Property;
import br.edu.ifpb.padroes.payment.processors.GovernmentTaxesPayment;
import br.edu.ifpb.padroes.payment.processors.PropertyPayment;
import br.edu.ifpb.padroes.payment.processors.RealEstatePayment;

public class PaymentService {

    public void pay(Property sale) {
        PaymentProcessor governmentTaxesPayment = new GovernmentTaxesPayment();
        PaymentProcessor realEstatePayment = new RealEstatePayment();
        PaymentProcessor propertyPayment = new PropertyPayment();
        
        PaymentProcessor paymentChain = governmentTaxesPayment;
        paymentChain.setNext(realEstatePayment).setNext(propertyPayment);
        paymentChain.process(sale);
    }

}
