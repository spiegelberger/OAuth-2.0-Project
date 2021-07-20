package com.spiegelberger.oauth.keycloak;


public class VerifyPasswordResponse {
    private boolean result;
 
    public VerifyPasswordResponse(boolean result) {
		this.result = result;
	}
    
    public VerifyPasswordResponse() {}

	public boolean getResult() {
        return result;
    }
 
    public void setResult(boolean result) {
        this.result = result;
    }
 
    
}
