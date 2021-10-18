package com.lalit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {

    @Autowired
    private TShirtRepository tshirtRepo;

    public List<TShirt> listAll(String color, String gender, String size) {
        if (color != null && gender != null && size != null) {
            return tshirtRepo.search(color, gender, size);
        }
        return tshirtRepo.findAll();
    }
}
