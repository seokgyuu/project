package himedia.dvd.services;

import java.util.List;

import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

public interface UserService {
    boolean join(UserVo vo); // �쉶�썝 媛��엯
    UserVo login(String email);
    UserVo login(String email, String password); // 濡쒓렇�씤
    List<UserVo> getAllUsers();
    boolean isAuthenticated(HttpServletRequest request); // �씤利� 泥댄겕 硫붿꽌�뱶

    UserVo getUserByEmail(String email);
    boolean updateUser(UserVo vo);;
}
