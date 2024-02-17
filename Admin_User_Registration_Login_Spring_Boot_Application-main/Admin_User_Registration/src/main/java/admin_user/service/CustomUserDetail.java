package admin_user.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import admin_user.model.User;

public class CustomUserDetail implements UserDetails {

	private User user;

	public CustomUserDetail(User user) {
		this.user = user;
	}

	/*
	 * GrantedAuthority is an interface that represents an authority granted to an
	 * authentication object.
	 */
	/*
	 * () -> user.getRole(), which is used to dynamically retrieve the user's role.
	 * However, there is a mistake in this implementation.
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(() -> user.getRole());
	}

	public String getFullname() {
		return user.getFullname();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
