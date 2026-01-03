package com.ajik.infrastrucure.db.repository.entity;

import com.ajik.common.enums.EducationLevel;
import com.ajik.common.enums.EmploymentType;
import com.ajik.common.enums.GraduationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_seeker_resume")
@Comment("구직자의 이력서")
public class JobSeekerResume {
    @Comment("ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Int로 변환이 필요할 수도 있지만 테이블 통일성을 생각하여 그냥 Long처리

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @Comment("이력서 제목")
    @Column(name = "title", nullable = false)
    private String title;

    @Comment("간단한 소개")
    @Column(name = "content", nullable = false ,columnDefinition = "TEXT")
    private String content;

    @Comment("경력사항")
    @Column(name = "experiences",columnDefinition = "jsonb")
    private List<ExperienceDetail> experiences;

    @Comment("학력")
    @Column(name="educations",columnDefinition = "jsonb")
    private List<Education> educations;



    @Getter @Setter
    public static class ExperienceDetail {
        private Long companyId;
        private String companyName;
        private String role;
        private String position;
        private String duty;
        private EmploymentType employmentType;
        private int startYear;
        private int startMonth;
        private Integer endYear; //재직중일 경우 null
        private Integer endMonth;
        private boolean isCurrent;

        private List<ProjectDetail> projects = new ArrayList<>();

        // 현재 날짜를 반영한 경력 계산 로직
        public int getTotalMonths() {
            int currentYear = java.time.LocalDate.now().getYear();
            int currentMonth = java.time.LocalDate.now().getMonthValue();

            if (isCurrent || endYear == null) {
                return (currentYear - startYear) * 12 + (currentMonth - startMonth);
            }
            return (endYear - startYear) * 12 + (endMonth - startMonth);
        }
    }

    @Getter @Setter
    @NoArgsConstructor
    public static class EducationDetail {
        private String schoolName;      // 학교명
        private String major;           // 전공 (고졸의 경우 생략 가능)
        private EducationLevel level;   // 학력 구분 (고교, 대학, 석사 등)
        private GraduationStatus status; // 졸업 상태 (졸업, 중퇴, 수료 등)

        private int startYear;          // 입학 연도
        private Integer endYear;        // 졸업 연도 (Integer로 하여 재학 중 대응)
    }

}
