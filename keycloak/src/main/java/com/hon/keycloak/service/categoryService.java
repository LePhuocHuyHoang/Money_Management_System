package com.hon.keycloak.service;

import com.hon.keycloak.model.category;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface categoryService {
    List<category> getAllCategory();
    category saveCategory(category category);

    Object getCategory(BigInteger categoryId);

    void deleteCategory(BigInteger categoryId);

    category updateCategory(BigInteger categoryId, Map<String, String> formData);
}
//