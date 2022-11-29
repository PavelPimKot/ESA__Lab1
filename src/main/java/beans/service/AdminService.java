package beans.service;

import entities.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAdminByLoginAndPassword(String login, String password);
}
