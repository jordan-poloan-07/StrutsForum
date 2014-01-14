package forum.actions;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import forum.beans.User;
import forum.persistence.UserPersistence;

public class ProfileAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2161922098557797274L;

	private File profPic;
	private String profPicContentType;
	private String profPicFileName;

	private Map<String, Object> session;

	public String input() {
		return INPUT;
	}

	public String submit() {

		UserPersistence up = new UserPersistence();
		
		// TODO put to properties
		User currentUser = up.verifyUser((User) session
				.get("user"));

		if (currentUser == null)
			return ERROR;

		// TODO put to properties
		String theFolderName = "/fileUploaded";

		String targetPath = ServletActionContext.getServletContext()
				.getRealPath("");

		String profilePic = theFolderName + "/" + profPicFileName;
		
		File file = new File(targetPath, profilePic);

		try {
			FileUtils.copyFile(profPic, file);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		up.addProfilePic(currentUser, profilePic);

		// now save the modified user to session
		// TODO put to properties
		session.put("user", currentUser);

		return SUCCESS;
	}

	public File getProfPic() {
		return profPic;
	}

	public void setProfPic(File profPic) {
		this.profPic = profPic;
	}

	public String getProfPicContentType() {
		return profPicContentType;
	}

	public void setProfPicContentType(String profPicContentType) {
		this.profPicContentType = profPicContentType;
	}

	public String getProfPicFileName() {
		return profPicFileName;
	}

	public void setProfPicFileName(String profPicFileName) {
		this.profPicFileName = profPicFileName;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

}
