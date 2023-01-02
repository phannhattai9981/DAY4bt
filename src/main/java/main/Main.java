package main;

import configuration.JPAConfig;
import entity.CustomerEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);

    public static void main(String[] args) {
        createNewCustomer();

        List<CustomerEntity> listCus = (List<CustomerEntity>) customerRepository.findAll();
        for (CustomerEntity customerEntity : listCus) {
            System.out.println(customerEntity.toString());
        }
//        //Find by ID, chỉ ra 1 kết quả nên k dùng foreach và sout nó ra luôn
        System.out.println("Find by ID " + customerRepository.findById(1));

        List<CustomerEntity> listCusName = (List<CustomerEntity>) customerRepository.findByName("Nhat Tai");
        for (CustomerEntity customerEntity : listCusName) {
            System.out.println("find by Name:" + customerEntity.toString());
        }

        List<CustomerEntity> listCusPhoneorEmail = (List<CustomerEntity>) customerRepository.findByPhoneOrEmail("0901967812", "phannhattai14071996@mgmail.com");
        for (CustomerEntity customerEntity : listCusPhoneorEmail) {
            System.out.println("find by PhoneorEmail: " + customerEntity.toString());
        }

        List<CustomerEntity> listCusAgeAndSex = (List<CustomerEntity>) customerRepository.getCustomerByAgeAndSex();
        for (CustomerEntity customerEntity : listCusAgeAndSex) {
            System.out.println(customerEntity.toString());
        }


    }

    private static void createNewCustomer() {
        CustomerEntity cus = new CustomerEntity();
        cus.setName("Nhat Tai");
        cus.setBirthdate(LocalDate.parse("1996-07-14"));
        cus.setSex("men");
        cus.setEmail("phannhattai14071996@mgmail.com");
        cus.setPhone("0901967812");
        cus.setAddress("Dak Lak");
        CustomerEntity result = customerRepository.save(cus);

        CustomerEntity cus1 = new CustomerEntity();
        cus1.setName("Thanh Tam");
        cus1.setBirthdate(LocalDate.parse("1998-01-11"));
        cus1.setSex("men");
        cus1.setEmail("thanhtam@mgmail.com");
        cus1.setPhone("09000000000");
        cus1.setAddress("Dak Lak");
        CustomerEntity result1 = customerRepository.save(cus1);

        CustomerEntity cus2 = new CustomerEntity();
        cus2.setName("Tien Phung");
        cus2.setBirthdate(LocalDate.parse("1997-01-01"));
        cus2.setSex("men");
        cus2.setEmail("tienphung@mgmail.com");
        cus2.setPhone("09011111111");
        cus2.setAddress("da nang");
        CustomerEntity result2 = customerRepository.save(cus2);


    }
}