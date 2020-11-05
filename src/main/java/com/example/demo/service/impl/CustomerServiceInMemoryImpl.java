package com.example.demo.service.impl;

import com.example.demo.model.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceInMemoryImpl implements CustomerService {
    // хранить кастомеров будем в коллекции
    // для хранения в БД, колллекция не нужна, вместо нее нужно создать репозиторий
    private Map<Integer, CustomerDTO> persist = new HashMap<>();

    @Override
    public void addCustomer(int id, String name) {
        // в случае совпадения id, кастомер перезапишется
        persist.put(id, new CustomerDTO(id, name));
    }

    @Override
    public CustomerDTO getCustomer(int id) {
        return persist.get(id);
    }
}
