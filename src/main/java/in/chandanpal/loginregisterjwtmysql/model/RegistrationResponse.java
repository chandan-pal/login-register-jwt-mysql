package in.chandanpal.loginregisterjwtmysql.model;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userId;
	
	public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }
	
    public RegistrationResponse()
    {

    }

    public RegistrationResponse(String userId) {
        this.setUserId(userId);
    }

    
}
