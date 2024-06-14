package manager.service;

import manager.models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void addCustomer(Customer customer);
    void updateCustomer(int id , Customer customer);
    void deleteCustomer(int id);
    Customer findById(int id);
}
