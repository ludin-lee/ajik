package com.ajik.infrastrucure.db.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "company_admin")
@SQLDelete(sql = "UPDATE company_admin SET deleted_at = now() WHERE id = ?")
@Comment("채용담당자")
public class CompanyAdmin  extends BaseEntity{
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
}
