package backingbean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import bean.User;
import service.UserDaoInterfaceService;

@Named
@SessionScoped
public class Login implements Serializable {

	@Inject
	UserDaoInterfaceService userDaoInterfaceService;

	private int id;
	private String userName;
	private String password;

	private String errorMessage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;

	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

	public String sendToIndexScreenActionLogin() throws SQLException {
		User user = new User();
		user = userDaoInterfaceService.selectUser(getUserName(), getPassword());

		if (user.getUserName() != null) {
			return "/index.xhtml";
		}

		setErrorMessage("ログインできません");
		return "/login.xhtml";
	}

}
