package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.impl.UserDaoImpl;
import com.hibernate.entity.User;

public class Demo {
	
	public static void main(String[] args) {
//		SessionFactorytest();
//		Userregistertest();
		SXT_UserTest();
		}
//	�����û�
	public static void Userregistertest(){
		try {
			User user = new User();
			user.setUname("11111");
			user.setUpassword("12345");
			user.setUemail("12345@qq.com");
			user.setUimage("upload/1.jpg");
			boolean flag = new UserDaoImpl().user_register(user);
			System.out.println(flag);
		} catch (Exception e) {
			System.out.println("���ݿ����, [�û�ע��] ʧ��");
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
//	����sessionFactory
	public static void SessionFactorytest(){
			try {
				SessionFactory factory = new Configuration().configure().buildSessionFactory();
				System.out.println(factory.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
//	SXT ����
	public static void SXT_UserTest(){
		User userinfo = new User();
		userinfo.setUname("SXT");
		userinfo.setUpassword("110");
		userinfo.setUemail("110@qq.com");
		userinfo.setUimage("uoload/110.jpg");
		
//		��ȡconfiguration
		Configuration cfg = new Configuration();
//		��ȡhibernate�����ļ�,û��ָ���Ļ���Ĭ��srcĿ¼�µ�hibernate.cfg.xml
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(userinfo);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	
	
	
}
