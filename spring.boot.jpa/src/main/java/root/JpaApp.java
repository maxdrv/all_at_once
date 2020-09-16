package root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import root.model.Organization;
import root.model.Service;
import root.respositories.OrganizationRepository;
import root.respositories.ServiceRepository;

import java.util.Collections;

@SpringBootApplication
public class JpaApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaApp.class);

        OrganizationRepository repository = context.getBean(OrganizationRepository.class);
        ServiceRepository services = context.getBean(ServiceRepository.class);

        Service service = new Service();
        service.setName("service with name");

        services.save(service);

        Organization organization = new Organization();
        organization.setName("organization name");
        organization.setServiceList(Collections.singletonList(service));

        repository.save(organization);

    }
}
