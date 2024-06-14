package manager.service;

import manager.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private List<Customer> customers = new ArrayList<>();

    public CustomerService() {
        customers.add(new Customer(1, "John", "john@codegym.vn", "Ha Noi"));
        customers.add(new Customer(2, "Bill", "bill@codegym.vn", "Hai Phong"));
        customers.add(new Customer(3, "Alex", "alex@codegym.vn", "Sai Gon"));
        customers.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijing"));
        customers.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.add(new Customer(6, "Rose", "rose@codegym.vn", "NewYork"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.set(i, customer);
                return;
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
