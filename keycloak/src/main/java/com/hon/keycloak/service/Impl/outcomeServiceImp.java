package com.hon.keycloak.service.Impl;

import com.hon.keycloak.log.Log;
import com.hon.keycloak.model.income;
import com.hon.keycloak.model.outcome;
import com.hon.keycloak.repository.outcomeRepository;
import com.hon.keycloak.service.outcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class outcomeServiceImp implements outcomeService {
    private final outcomeRepository outcomeRepository;

    @Autowired
    public outcomeServiceImp(outcomeRepository outcomeRepository) {
        this.outcomeRepository = outcomeRepository;
    }

    public List<outcome> getAllOutcome() {
        return outcomeRepository
                .findAll();
    }

    @Override
    public outcome saveOutcome(outcome outcome) {
        outcomeRepository.save(outcome);
        return outcome;
    }

    @Override
    public Object getOutcome(BigInteger outcomeId) {
        return outcomeRepository
                .findById(outcomeId)
                .orElse(null);
    }

    @Override
    public void deleteOutcome(BigInteger outcomeId) {
        outcomeRepository.deleteById(outcomeId);
    }

    @Override
    public outcome updateOutcome(BigInteger outcomeId, Map<String, String> formData) {
        outcome existingOutcome = outcomeRepository.findById(outcomeId).orElse(null);
        if (existingOutcome != null) { //Kiểm tra đối tượng có tồn tại
            String dateTimeStr = formData.get("date_time");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateTime = dateFormat.parse(dateTimeStr);
                existingOutcome.setDate_time(dateTime);
                return outcomeRepository.save(existingOutcome);
            } catch (ParseException e) {
                // Xử lý lỗi khi không thể chuyển đổi chuỗi thành ngày tháng
                Log.error("Can Change String To Date");
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
//