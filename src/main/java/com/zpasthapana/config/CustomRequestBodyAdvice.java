package com.zpasthapana.config;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.UserRepo;
import com.zpasthapana.util.JwtTokenUtil;

@ControllerAdvice
public class CustomRequestBodyAdvice implements RequestBodyAdvice {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		if (body instanceof UIPageRequest) {
			String userEmail = jwtTokenUtil
					.getUsernameFromToken(inputMessage.getHeaders().get("authorization").get(0).substring(7));
			Optional<User> user = userRepo.findByUserName(userEmail);
			UIPageRequest question = (UIPageRequest) body;
			if (user.isPresent()) {
				User us = user.get();
				question.setTalukaId(us.getTalukaID() > 0 ? us.getTalukaID() : null);
				if (question.getDevisionId() == null || question.getDevisionId() <= 0) {
					question.setDevisionId(us.getDivisionID() > 0 ? us.getDivisionID() : null);
				}
				if (question.getDepartmentId() == null || question.getDepartmentId() <= 0) {
					question.setDepartmentId(us.getDepartmentID() > 0 ? us.getDepartmentID() : null);
				}
				question.setZpId(us.getZillaParishadID() > 0 ? us.getZillaParishadID() : null);
				question.setProperOfficeID(us.getProperOfficeID() > 0 ? us.getProperOfficeID() : null);
			}
			return question;
		}
		return body;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		return body;
	}
}