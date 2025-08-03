package com.zpasthapana.pojo;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CasteReport {
    private Integer departmentId; // represents designationId
    private String departmentName; // represents designationName
    private String category;
    private Integer approvedPosts;
    private Integer workingPosts;
    private Integer vacancies;
    private String reservationPercent;
    private Integer approvedOrphanPosts;
    private Integer workingOrphanPosts;
    private Integer orphanVacancies;
    private Integer disabledWorkingPosts;
}