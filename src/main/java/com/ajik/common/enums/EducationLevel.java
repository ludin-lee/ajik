package com.ajik.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EducationLevel implements EnumType {
    HIGH_SCHOOL("고등학교"),
    COLLEGE("전문대학"),
    UNIVERSITY("대학교"),
    MASTER("석사"),
    DOCTOR("박사"),
    OTHER("기타");

    private final String literal;
    @Override public String literal() { return literal; }
}