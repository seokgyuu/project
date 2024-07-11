package himedia.dvd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.dvd.repositories.dao.UserDao;
import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean join(UserVo vo) {
        if (userDao.selectUserByEmail(vo.getEmail()) != null) {
            return false; // 以묐났 �씠硫붿씪 議댁옱
        }
        return userDao.insert(vo) == 1;
    }

    @Override
    public UserVo login(String email) {
        UserVo userVo = userDao.selectUserByEmail(email);
        System.out.println("Service UserVo:" + userVo);
        return userVo;
    }

    @Override
    public UserVo login(String email, String password) {
        return userDao.selectUserByEmailAndPassword(email, password);
    }

    @Override
    public boolean isAuthenticated(HttpServletRequest request) {
        // �꽭�뀡�쓣 �넻�빐�꽌 �궗�슜�옄 �씤利� �긽�깭 泥댄겕
        HttpSession session = request.getSession(false);

        if (session != null) { // �씤利앺뻽�쓣 媛��뒫�꽦�씠 �엳�떎
            UserVo authUser = (UserVo) session.getAttribute("authUser");
            return authUser != null;
        }
        return false;
    }

    @Override
	public List<UserVo> getAllUsers() {
		List<UserVo> list = userDao.selectAllUsers();
		return list;
	}
    
    @Override
    public UserVo getUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    public boolean updateUser(UserVo vo) {
        return userDao.update(vo);
    }
	


	

	



}
