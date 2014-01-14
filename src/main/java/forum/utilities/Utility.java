package forum.utilities;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import forum.beans.User;

public class Utility {

	public void profilePicChecker(User user) {

		if (user.getUsersInfo().getProfilePic() == null) {
			// TODO put to properties
			user.getUsersInfo().setProfilePic("/default_images/no image.jpg");
		} else {
			// TODO put to properties
			String targetPath = ServletActionContext.getServletContext()
					.getRealPath("");

			File dummyFile = new File(targetPath, user.getUsersInfo()
					.getProfilePic());

			// TODO put to properties
			if (!dummyFile.exists()) {
				user.getUsersInfo().setProfilePic(
						"/default_images/no image.jpg");
			}
		}

	}

	public String newLineParser(String content) {

		String[] tokens = content.trim().split("\n");

		StringBuffer sBuff = new StringBuffer();

		for (String token : tokens) {
			token = "<div>" + token + "</div>";
			sBuff.append(token);
		}

		return tokens.toString();
	}
	
	public String htmlTagParser(String content) {
		return null;
	}
	
	public String descriptionShortener(String description) {
		// description should be 50 words
		
		if(description.length() > 50 ) {
			return null;
		} else {
			return description;
		}
	}

}
