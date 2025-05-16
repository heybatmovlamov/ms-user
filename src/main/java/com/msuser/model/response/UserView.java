package com.msuser.model.response;

import com.msuser.model.enums.UserRole;
import com.msuser.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserView {

    private Long id;
    private String username;
    private String email;
    private UserRole role;
    private UserStatus status;
    private String password;
}
