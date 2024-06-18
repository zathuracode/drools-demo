package com.baeldung.drools.service;

import org.kie.api.runtime.KieSession;

import com.baeldung.drools.config.DroolsBeanFactory;
import com.baeldung.drools.model.Applicant;
import com.baeldung.drools.model.SuggestedRole;

public class ApplicantService {

    KieSession kieSession = new DroolsBeanFactory().getKieSession();

    public SuggestedRole suggestARoleForApplicant(Applicant applicant,SuggestedRole suggestedRole) {
        try {
            kieSession.insert(applicant);
            kieSession.setGlobal("suggestedRole", suggestedRole);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        System.out.println(suggestedRole.getRole());
        return  suggestedRole;

    }
}
