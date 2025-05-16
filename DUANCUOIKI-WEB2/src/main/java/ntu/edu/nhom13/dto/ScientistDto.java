package ntu.edu.nhom13.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScientistDto {
    private Long id;
    private Long accountId;
    private String fullName;
    private String gender;
    private Long birthYear;
    private String image;
    private String address;
    private String phoneNumber;
    private String email;
    private Long degreeId;
    private Long rankId;
    private Long titleId;
    private Long fieldId;
    private Long organizationId;
    private Long languageLevelId;
    private String major;
    private String subMajor;
    private String teachingSpecialty;
}
