package com.localhost.Interface;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.DAOBean;

public interface IUserfunction {
		public boolean Cheack_user(DAOBean db);
		public boolean Insert_user(DAOBean db);
		public void update_re(String sql);
}

