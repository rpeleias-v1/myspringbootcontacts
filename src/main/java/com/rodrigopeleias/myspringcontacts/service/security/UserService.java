package com.rodrigopeleias.myspringcontacts.service.security;

import com.rodrigopeleias.myspringcontacts.domain.User;

public interface UserService {

    User findByEmail(String email);
}
