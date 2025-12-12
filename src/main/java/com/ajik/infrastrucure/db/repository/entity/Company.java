package com.ajik.infrastrucure.db.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "company")
@Comment("회사")
public class Company {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("회사 이름")
    @Column(name = "company_name" , nullable = false)
    private String companyName;

    @Comment("사업자 번호")
    @Column(name = "business_number", unique = true, nullable = false)
    private String businessNumber;


    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<CompanyAdmin> companyAdmins;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<JobPosting> jobPostings;

    //TODO : 프로필 사진, 사무실 위치, 사진, 복지, 태그 정보 추가
}
