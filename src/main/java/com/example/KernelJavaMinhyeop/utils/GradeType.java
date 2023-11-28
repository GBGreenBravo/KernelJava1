package com.example.KernelJavaMinhyeop.utils;

public enum GradeType {
    AB_TYPE(0, "A/B/C"),
    SABCDF_TYPE(1, "S/A/B/C/D/F"),
    PF_TYPE(2, "P/F");

    private final int typeCode;
    private final String typeDescription;

    GradeType(int typeCode, String typeDescription) {
        this.typeCode = typeCode;
        this.typeDescription = typeDescription;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
