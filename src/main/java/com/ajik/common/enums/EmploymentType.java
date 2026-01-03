package com.ajik.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum EmploymentType implements EnumType {
    FULL_TIME("정규직"),
    CONTRACT("계약직"),
    PART_TIME("파트타임/알바"),
    TEMPORARY("파견/대행"),
    DAILY("일용직"),
    FREELANCER("프리랜서");

    private final String literal;

    @Override
    public String literal() { return literal; }
}