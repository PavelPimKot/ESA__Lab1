package beans.repository.impl;

import beans.repository.AdminRepository;
import entities.Admin;

import java.util.List;

public class AdminRepositoryImpl extends AbstractRepository implements AdminRepository {
    @Override
    public List<Admin> findAdminByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select admin from Admin admin where admin.isDeleted = false and admin.login = :login and admin.password = :password ",
                Admin.class).setParameter("login", login).setParameter("password", password).getResultList();
    }
}
