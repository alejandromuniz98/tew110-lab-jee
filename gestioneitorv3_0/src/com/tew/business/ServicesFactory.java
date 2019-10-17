package com.tew.business;

import impl.tew.business.SimpleLoginService;

public interface ServicesFactory {
	
	AlumnosService createAlumnosService();
	LoginService createLoginService();
}
