package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Organization;
import ntu.edu.nhom13.repositories.OrganizationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Integer id) {
        return organizationRepository.findById(id);
    }

    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Integer id) {
        organizationRepository.deleteById(id);
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }
}
