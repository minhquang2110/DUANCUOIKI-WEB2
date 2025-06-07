package ntu.edu.nhom13.mapper;

import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.Scientist;

public class ScientMapper {

        // ... các fields và getters/setters giữ nguyên

		public static ScientistDTO fromEntity(Scientist scientist) {
		    ScientistDTO dto = new ScientistDTO();
	
		    dto.setId(scientist.getId());  // <-- thêm dòng này
	
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
	
		    dto.setImageUrl(null);
	
		    return dto;
		}

        public static Scientist toEntity(ScientistDTO dto, Scientist scientist) {
            // Nếu scientist null thì tạo mới
            if (scientist == null) {
                scientist = new Scientist();
            }
            scientist.setFullName(dto.getFullName());
            scientist.setEmail(dto.getEmail());
            scientist.setGender(dto.getGender());
            scientist.setBirthYear(dto.getBirthYear());
            scientist.setAddress(dto.getAddress());
            scientist.setPhoneNumber(dto.getPhone());
            scientist.setMajor(dto.getMajor());
            scientist.setSubMajor(dto.getSubMajor());
            scientist.setTeachingSpecialty(dto.getTeachingSpecialty());

            // TODO: với các field phức tạp như degree, rank, title,... bạn cần fetch entity tương ứng theo tên hoặc id trước khi set
            // ví dụ:
            // Degree degreeEntity = degreeService.findByName(dto.getDegree());
            // scientist.setDegree(degreeEntity);

            // Tạm thời set null hoặc xử lý sau:
            scientist.setDegree(null);
            scientist.setRank(null);
            scientist.setTitle(null);
            scientist.setResearchField(null);
            scientist.setOrganization(null);
            scientist.setLanguageLevel(null);

            // Xử lý imageUrl nếu cần

            return scientist;
        }

    }


