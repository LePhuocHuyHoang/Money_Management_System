package com.hon.keycloak.service.Impl;

import com.hon.keycloak.log.logger;
import com.hon.keycloak.entity.income;
import com.hon.keycloak.repository.incomeRepository;
import com.hon.keycloak.service.incomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class incomeServiceImp implements incomeService {
    private final incomeRepository incomeRepository;
    @Autowired
    public incomeServiceImp(incomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }
    public List<income> getAllIncome(){
        return incomeRepository
                .findAll();
    }

    @Override
    public income saveIncome(income income) {
        incomeRepository.save(income);
        return income;
    }

    @Override
    public Object getIncome(BigInteger incomeId) {
        return incomeRepository
                .findById(incomeId)
                .orElse(null);
    }

    @Override
    public List<income> getIncomeNotDeleted() {
        return incomeRepository.findIncomeNotDeleted();
    }
    @Override
    public income updateIncome(BigInteger incomeId, Map<String, String> formData) {
        income existingIncome = incomeRepository.findById(incomeId).orElse(null);
        if (existingIncome != null) {   //Kiểm tra đối tượng có tồn tại
            String dateTimeStr = formData.get("date_time");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateTime = dateFormat.parse(dateTimeStr);
                existingIncome.setDate_time(dateTime);
                String status = formData.get("status");
                existingIncome.setStatus(status);
                return incomeRepository.save(existingIncome);
            } catch (ParseException e) {
                // Xử lý lỗi khi không thể chuyển đổi chuỗi thành ngày tháng
                logger.error("Can Change String To Date");
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
//