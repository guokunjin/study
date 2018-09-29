package com.gkj.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestServlet.class);

    private static final long serialVersionUID = -4012838481920999524L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");

        LOGGER.info(String.format("receive query: %s", query));

        String result = "welcome to my server. It's a POST request.";
        if (null != query && !query.trim().equals("")) {
            result = query + ", " + result;
        }
        LOGGER.info(String.format("response is: %s", result));

        response.getWriter().print(result);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");

        LOGGER.info(String.format("receive query: %s", query));

        String result = "welcome to my server. It's a GET request.";
        if (null != query && !query.trim().equals("")) {
            result = query + ", " + result;
        }
        LOGGER.info(String.format("response is: %s", result));

        response.getWriter().print(result);
    }
}
