package com.ajik.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GraduationStatus implements EnumType {
    GRADUATED("졸업"),
    EXPECTED("졸업예정"),
    COMPLETED("수료"),
    DROPOUT("중퇴"),
    ENROLLED("재학");

    private final String literal;
    @Override public String literal() { return literal; }
}