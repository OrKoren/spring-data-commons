/*
 * Copyright (c) 2011 by the original author(s).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.authentication;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Class used to provide credentials for username/password authentication
 * 
 * @author Thomas Risberg
 * @author Oliver Gierke
 */
public class UserCredentials {

	private final String username;
	private final String password;

	public UserCredentials() {
		this(null, null);
	}

	/**
	 * Creates a new {@link UserCredentials} instance from the given username and password. Empty {@link String}s provided
	 * will be treated like no username or password set.
	 * 
	 * @param username
	 * @param password
	 */
	public UserCredentials(String username, String password) {
		this.username = StringUtils.hasText(username) ? username : null;
		this.password = StringUtils.hasText(password) ? password : null;
	}

	/**
	 * Get the username to use for authentication.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get the password to use for authentication.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (obj == null || !getClass().equals(obj.getClass())) {
			return false;
		}

		UserCredentials that = (UserCredentials) obj;

		return ObjectUtils.nullSafeEquals(this.username, that.username)
				&& ObjectUtils.nullSafeEquals(this.password, that.password);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		int result = 17;

		result += 31 * ObjectUtils.nullSafeHashCode(username);
		result += 31 * ObjectUtils.nullSafeHashCode(password);

		return result;
	}
}
