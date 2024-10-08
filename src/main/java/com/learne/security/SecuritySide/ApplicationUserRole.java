package com.learne.security.SecuritySide;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.learne.security.SecuritySide.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE )),
    ADMIN_TRAINING(Sets.newHashSet(COURSE_READ,  STUDENT_READ ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }
}
