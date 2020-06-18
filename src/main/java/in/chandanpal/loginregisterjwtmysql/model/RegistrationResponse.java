package in.chandanpal.loginregisterjwtmysql.model;

import java.io.Serializable;

public class RegistrationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private long userId;
	
	public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }
	
    public RegistrationResponse()
    {

    }

    public RegistrationResponse(long userId) {
        this.setUserId(userId);
    }

    
}
