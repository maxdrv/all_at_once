package root.respositories;

import org.springframework.data.repository.CrudRepository;
import root.model.Organization;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    List<Organization> findAll();

}
