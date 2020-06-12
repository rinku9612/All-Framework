package com.api.apiConfig;

public class ApiPath {

	public static final class APIPath{
		public static final String GET_ALL_USERS="api/users?page=2";
		public static final String GET_SINGLE_USER="api/users/2";
		public static final String GET_SINGLE_USER_NOT_FOUND="api/users/175";
		public static final String GET_LIST_RESOURCE="api/unknown";
		public static final String GET_SINGLE_RESOURCE="api/unknown/2";
		public static final String POST_CREATE_USER="api/users";
		public static final String PUT_UPDATE_USER="api/users/2";
		public static final String PATCH_UPDATE_USER="/api/users/2";
		public static final String DELETE_USER="api/users/2";
		public static final String POST_REGISTER_USER="api/register";
		public static final String POST_LOGIN_USER="api/login";
		public static final String GET_DELAYED_RESPONSE="/api/users?delay=3";
				
	}
}
