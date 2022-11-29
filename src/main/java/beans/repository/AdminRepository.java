package beans.repository;

import entities.Admin;

import java.util.List;

public interface AdminRepository extends Repository{
    List<Admin> findAdminByLoginAndPassword(String login, String password);
}
