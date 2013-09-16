package org.apache.shiro.web.faces.functions;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;

/**
 * Provides a collection of functions that can be used in EL expressions
 * 
 * @since 1.3
 */
public final class ELFunctions {

	/**
	 * Returns {@code true} if the current Subject has all of the specified roles, {@code false} otherwise.
	 * 
	 * @param commaDelimitedRoleNames
	 *            the comma delimited application-specific role identifiers to check (usually role ids or role names).
	 * @return true if the current Subject has all the roles, false otherwise.
	 * @see {@link Subject#hasAllRoles(java.util.Collection)

	 */
	public static boolean hasAllRoles(final String commaDelimitedRoleNames) {

		final Subject subject = SecurityUtils.getSubject();

		final Set<String> roleNameSet = StringUtils.splitToSet(commaDelimitedRoleNames, String.valueOf(StringUtils.DEFAULT_DELIMITER_CHAR));

		return subject.hasAllRoles(roleNameSet);

	}

	/**
	 * @param commaDelimitedRoleNames
	 * @return
	 */
	public static boolean hasAnyRoles(final String commaDelimitedRoleNames) {

		boolean hasAnyRole = false;

		final Subject subject = SecurityUtils.getSubject();

		if (CollectionUtils.isEmpty(subject.getPrincipals())) {
			return false;
		}

		// Iterate through roles and check to see if the user has one of the
		// roles
		final String[] roleNames = StringUtils.split(commaDelimitedRoleNames);
		for (final String roleName : roleNames) {
			if (subject.hasRole(roleName)) {
				hasAnyRole = true;
				break;
			}
		}

		return hasAnyRole;

	}

	/**
	 * @param roleName
	 * @return
	 * @see {@link Subject#hasRole(String)}
	 */
	public static boolean hasRole(final String roleName) {

		final Subject subject = SecurityUtils.getSubject();

		return subject.hasRole(roleName);

	}

	/**
	 * @return
	 * @see {@link Subject#isAuthenticated()}
	 */
	public static boolean isAuthenticated() {

		final Subject subject = SecurityUtils.getSubject();

		return subject.isAuthenticated();

	}

	/**
	 * Inversion of {@link #isUser()}
	 * 
	 * @return
	 */
	public static boolean isGuest() {

		final Subject subject = SecurityUtils.getSubject();

		return CollectionUtils.isEmpty(subject.getPrincipals());

	}

	/**
	 * @param permission
	 * @return
	 * @see {@link Subject#isPermitted(String)}
	 */
	public static boolean isPermitted(final String permission) {

		final Subject subject = SecurityUtils.getSubject();

		return subject.isPermitted(permission);

	}

	/**
	 * @param commaDelimitedPermissions
	 * @return
	 * @see {@link Subject#isPermittedAll(java.util.Collection)}
	 */
	public static boolean isPermittedAll(final String commaDelimitedPermissions) {

		final Subject subject = SecurityUtils.getSubject();

		return subject.isPermittedAll(StringUtils.split(commaDelimitedPermissions));

	}

	/**
	 * @param commaDelimitedPermissions
	 * @return
	 */
	public static boolean isPermittedAny(final String commaDelimitedPermissions) {

		boolean hasAnyPermission = false;

		final Subject subject = SecurityUtils.getSubject();

		if (CollectionUtils.isEmpty(subject.getPrincipals())) {
			return false;
		}

		// Iterate through permissions and check to see if the user has one
		// of the permissions
		final String[] permissions = StringUtils.split(commaDelimitedPermissions);
		for (final String permission : permissions) {
			if (subject.isPermitted(permission)) {
				hasAnyPermission = true;
				break;
			}
		}

		return hasAnyPermission;

	}

	/**
	 * @return
	 * @see {@link Subject#isRemembered()}
	 */
	public static boolean isRemembered() {

		final Subject subject = SecurityUtils.getSubject();

		return subject.isRemembered();

	}

	/**
	 * @return
	 * @see {@link Subject#isRunAs()}
	 */
	public static boolean isRunAs() {

		final Subject subject = SecurityUtils.getSubject();

		return subject.isRunAs();

	}

	/**
	 * Checks if the current Subject has any principals set either through login or rememberMe
	 * 
	 * @return
	 */
	public static boolean isUser() {

		final Subject subject = SecurityUtils.getSubject();

		return !CollectionUtils.isEmpty(subject.getPrincipals());

	}

	/**
	 * Inversion of {@link Subject#isPermitted(String)}
	 * 
	 * @param permission
	 * @return
	 */
	public static boolean lacksPermission(final String permission) {

		final Subject subject = SecurityUtils.getSubject();

		return !subject.isPermitted(permission);

	}

	/**
	 * Inversion of {@link Subject#hasRole(String)}
	 * 
	 * @param roleName
	 * @return
	 */
	public static boolean lacksRole(final String roleName) {

		final Subject subject = SecurityUtils.getSubject();

		return !subject.hasRole(roleName);

	}

	/**
	 * Inversion of {@link #isAuthenticated()}
	 * 
	 * @return
	 */
	public static boolean notAuthenticated() {

		final Subject subject = SecurityUtils.getSubject();

		return !subject.isAuthenticated();

	}

	/**
	 * prevent instantiation
	 */
	private ELFunctions() {
	}

}
