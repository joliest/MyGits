package com.tracker;

import javax.servlet.http.*;

public interface Module {
	int createId();
	void setHttpRequest(HttpServletRequest request);
	HttpServletRequest getHttpRequest();
}
