package com.ajik.infrastrucure.db.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "job_posting")
@Comment("구인 공고글")
public class JobPosting {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("구인 공고글 제목")
    @Column(name="title",nullable = false)
    private String title;

    //TODO : 포지션 관리를 위해 추후 테이블 분리 필요
    @Comment("포지션 종류")
    @Column(name="job_type",nullable = false)
    private String jobType;

    @Comment("포지션, 회사 프로덕트 관련 설명")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="description",nullable = false)
    private List<String> description;

    @Comment("주요업무")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="job_summary",nullable = false)
    private List<String> jobSummary;

    @Comment("자격요건")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="requirements",nullable = false)
    private List<String> requirements;

    @Comment("우대사항")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="preferred_qualifications")
    private List<String> preferredQualifications;

    @Comment("채용 전형")
    @Lob
    @Column(name="recruitment_process")
    private String recruitmentProcess;

    @Comment("급여 , null일 경우 회사내규에 따름")
    @Column(name="salary",nullable = false)
    private Long salary;

    @Comment("근무지 주소")
    @Column(name="location",nullable = false)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
