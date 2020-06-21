package in.chandanpal.loginregisterjwtmysql.model;

import java.io.Serializable;
import java.util.Date;

public class AuthenticationResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String jwt;
	private Date expDate;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public Date getExpDate()
    {
        return expDate;
    }

    public void setExpDate(Date expDate)
    {
        this.expDate = expDate;
    }
}
