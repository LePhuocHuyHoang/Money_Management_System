package com.hon.keycloak.service;


import com.hon.keycloak.model.outcome;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface outcomeService {
    List<outcome> getAllOutcome();
    outcome saveOutcome(outcome outcome);

    Object getOutcome(BigInteger outcomeId);

    void deleteOutcome(BigInteger outcomeId);

    outcome updateOutcome(BigInteger outcomeId, Map<String, String> formData);
}
//