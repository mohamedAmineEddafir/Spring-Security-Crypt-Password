package com.learne.security.SecuritySide;

public enum ApplicationUserPermission {
    // it for role Admin
    STUDENT_READ("student: read"),
    STUDENT_WRITE("student: write"),
    COURSE_READ("course: read"),
    COURSE_WRITE("course: write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}