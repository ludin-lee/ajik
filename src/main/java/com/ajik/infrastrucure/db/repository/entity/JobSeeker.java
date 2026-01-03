package com.ajik.infrastrucure.db.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "job_seeker")
@Comment("구직자")
public class JobSeeker {

    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("이메일")
    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Comment("패스워드")
    @Column(name = "password", nullable = false)
    private String password;

    @Comment("이름")
    @Column(name = "name" , nullable = false)
    private String name;

    @Comment("연락처")
    @Column(name = "phone_number" , nullable = false)
    private String phoneNumber;

    @Comment("활성화 여부")
    @Column(name = "is_active" , nullable = false)
    private boolean isActive;
}
