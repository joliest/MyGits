package com.tracker;

import javax.servlet.http.*;

public interface Module {
	void setHttpRequest(HttpServletRequest request);
	HttpServletRequest getHttpRequest();
}
