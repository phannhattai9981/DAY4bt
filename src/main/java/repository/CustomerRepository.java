package repository;

import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findByName(String name);


    List<CustomerEntity> findByPhoneOrEmail(String phone, String email);

    @Query(value = "SELECT * FROM CustomerEntity as c where DATEDIFF(CURDATE(), birthdate)/365 between 20 and 30 and sex = 'men'", nativeQuery = true)
    List<CustomerEntity> getCustomerByAgeAndSex();
}