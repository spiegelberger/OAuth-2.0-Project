package com.spiegelberger.legacyusersservice.service;

import com.spiegelberger.legacyusersservice.response.UserRest;

public interface UsersService {
   UserRest getUserDetails(String userName, String password);
   UserRest getUserDetails(String userName);
}
