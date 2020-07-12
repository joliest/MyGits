package com.miforum.services;

import com.miforum.components.Component;

public interface Service {
	void add();
	void modify(int id, String changes);
	void remove(int id);
	boolean isValid(Component component);
}
