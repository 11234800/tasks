package project1.service.impl;

import project1.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUsername(String username) {
        if (username.length() < 3)
            return false;
        return true;
    }
}
