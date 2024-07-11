package himedia.dvd.repositories.dao;

import java.util.List;

import himedia.dvd.repositories.vo.UserVo;

public interface UserDao {
	List<UserVo> selectAllUsers();
    int insert(UserVo user);	//	�쉶�썝 媛��엯
    UserVo selectUserByEmail(String email);	//	以묐났 �씠硫붿씪	
    UserVo selectUserByEmailAndPassword(String email, String password);	//	濡쒓렇�씤�슜
    boolean update(UserVo user);
}
