package root.respositories;

import org.springframework.data.repository.CrudRepository;
import root.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {
}
