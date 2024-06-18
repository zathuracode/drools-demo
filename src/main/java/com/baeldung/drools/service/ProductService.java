package com.baeldung.drools.service;

import org.kie.api.runtime.KieSession;

import com.baeldung.drools.config.DroolsBeanFactory;
import com.baeldung.drools.model.Product;

public class ProductService {

    private KieSession kieSession = new DroolsBeanFactory().getKieSession();

    public Product applyLabelToProduct(Product product){
        try {
            kieSession.insert(product);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        System.out.println(product.getLabel());
        return product;

    }

}
