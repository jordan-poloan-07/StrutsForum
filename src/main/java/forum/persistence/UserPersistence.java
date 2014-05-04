package forum.persistence;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import forum.beans.User;
import forum.beans.UsersInfo;

public class UserPersistence {

	public void registerUser(User user) {

		UsersInfo usersInfo = new UsersInfo();
		usersInfo.setDateJoined(new Date(System.currentTimeMillis()));
		usersInfo.setLastLogin(new Date(System.currentTimeMillis()));
		usersInfo.setTopicCount(0);
		usersInfo.setReplyCount(0);

		user.setUsersInfo(usersInfo);
		usersInfo.setUser(user);

		SessionManager.beginTransaction().save(user);

		SessionManager.commitTransaction();
	}

	public User verifyUser(User user) {

		User matchedUser = null;

		Query q = SessionManager
				.beginTransaction()
				.createQuery(
						"from User as u where ( u.username=:username or u.email=:email ) and u.password=:password");

		q.setProperties(user);

		matchedUser = (User) q.uniqueResult();

		SessionManager.commitTransaction();

		// now change the last login of matched user;
		// should use trigger instead of this

		if (matchedUser == null)
			return matchedUser; // no records return a null matchedUser

		matchedUser.getUsersInfo().setLastLogin(
				new Date(System.currentTimeMillis()));

		SessionManager.beginTransaction().saveOrUpdate(matchedUser);

		SessionManager.commitTransaction();

		return matchedUser;
	}

	public void addProfilePic(User user, String profilePic) {

		Session session = SessionManager.getSessionFactory().openSession();

		session.beginTransaction();

		user.getUsersInfo().setProfilePic(profilePic);

		session.update(user);

		session.getTransaction().commit();

		session.close();
	}

	public void updateUserTopicCount(User user) {

		Session session = SessionManager.getSessionFactory().openSession();

		session.beginTransaction();

		int topicCount = user.getUsersInfo().getTopicCount();
		user.getUsersInfo().setTopicCount(++topicCount);

		session.update(user);

		session.getTransaction().commit();

		session.close();
	}

	public void updateUserReplyCount(User user) {
		Session session = SessionManager.getSessionFactory().openSession();

		session.beginTransaction();

		int replyCount = user.getUsersInfo().getReplyCount();
		user.getUsersInfo().setReplyCount(++replyCount);

		session.update(user);

		session.getTransaction().commit();

		session.close();
	}
}
