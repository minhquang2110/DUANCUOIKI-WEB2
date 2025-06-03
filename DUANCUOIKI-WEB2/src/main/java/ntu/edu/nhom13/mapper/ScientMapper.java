package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.Scientist;

public class ScientMapper {

        // ... các fields và getters/setters giữ nguyên

        public static ScientistDTO fromEntity(Scientist scientist) {
            ScientistDTO dto = new ScientistDTO();

            dto.setFullName(scientist.getFullName());
            dto.setEmail(scientist.getEmail());
            dto.setGender(scientist.getGender());
            dto.setBirthYear(scientist.getBirthYear());
            dto.setAddress(scientist.getAddress());
            dto.setPhone(scientist.getPhoneNumber());
            dto.setMajor(scientist.getMajor());
            dto.setSubMajor(scientist.getSubMajor());
            dto.setTeachingSpecialty(scientist.getTeachingSpecialty());

            dto.setDegree(scientist.getDegree() != null ? scientist.getDegree().getName() : null);
            dto.setRank(scientist.getRank() != null ? scientist.getRank().getName() : null);
            dto.setTitle(scientist.getTitle() != null ? scientist.getTitle().getName() : null);
            dto.setResearchField(scientist.getResearchField() != null ? scientist.getResearchField().getName() : null);
            dto.setOrganization(scientist.getOrganization() != null ? scientist.getOrganization().getName() : null);
            dto.setLanguageLevel(scientist.getLanguageLevel() != null ? scientist.getLanguageLevel().getName() : null);

            dto.setImageUrl(null); // Không map được từ entity → xử lý riêng ở controller nếu cần

            return dto;
        }
    }


