package com.atsustudio.EdSpringREST.Enums;

public enum TaskStatus {
    PENDING((byte) 0),
    IN_PROCESS((byte) 1),
    SUSPENDED((byte) 2),
    FAILED((byte) 3),
    DELETED((byte) 4),
    COMPLETED((byte) 5);

    private byte value;

    TaskStatus(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

}

