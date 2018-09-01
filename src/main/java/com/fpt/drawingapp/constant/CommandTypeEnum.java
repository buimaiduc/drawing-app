package com.fpt.drawingapp.constant;

public enum  CommandTypeEnum {
    UNKNOWN("unknown"),
    C("C"),
    L("L"),
    R("R"),
    B("B"),
    Q("Q");

    private final String logicName;

    CommandTypeEnum(String logicName) {
        this.logicName = logicName;
    }

    public static CommandTypeEnum fromValue(final String value) {
        for (final CommandTypeEnum t : values()) {
            if (t.logicName.equals(value.toUpperCase())) {
                return t;
            }
        }
        return UNKNOWN;
    }

    public String getLogicName() {
        return logicName;
    }
}
