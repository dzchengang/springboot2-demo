package com.sdstc.config;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

public class MobileLoginToken extends AbstractAuthenticationToken{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	protected static final Logger logger = LoggerFactory.getLogger(MobileLoginToken.class);
	
	//这里的 principal 指的是 手机号码（未认证的时候）
    private final Object principal;

    public MobileLoginToken(Object principal) {
    	super((Collection)null);
        this.principal = principal;
        super.setAuthenticated(false);
    }
    
	public MobileLoginToken(Collection<? extends GrantedAuthority> authorities, Object principal) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

	
	
	/**
	 * 不允许在此处更改验证状态
	 */
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}

}
