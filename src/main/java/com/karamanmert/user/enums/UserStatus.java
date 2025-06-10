package com.karamanmert.user.enums;

/**
 * @author karamanmert
 */
public enum UserStatus {
    ACTIVE("ACTIVE",1),
    INACTIVE("INACTIVE",2),
    DELETED("DELETED",3);

    private final String status;
    private final int code;

    UserStatus(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public static UserStatus fromCode(int code) {
        for (UserStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

    public static UserStatus fromStatus(String status) {
        for (UserStatus value : values()) {
            if (value.status.equalsIgnoreCase(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }

    public static UserStatus getMaxCodeUserStatus() {
        UserStatus maxStatus = null;
        int max = Integer.MIN_VALUE;

        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.code > max) {
                max = userStatus.code;
                maxStatus = userStatus;
            }
        }

        if (maxStatus == null) {
            throw new IllegalStateException("No UserStatus found");
        }

        return maxStatus;
    }
}
