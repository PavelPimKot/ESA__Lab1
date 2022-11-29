package beans.service.impl;

import beans.repository.AdminRepository;
import beans.service.AdminService;
import entities.Admin;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class AdminServiceImpl implements AdminService {
    @EJB
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAdminByLoginAndPassword(String login, String password) {
        return adminRepository.findAdminByLoginAndPassword(login, password);
    }
}
