package com.techeva.cakefactory.basket;

import org.springframework.stereotype.Controller;

import javax.servlet.*;
import java.io.IOException;

@Controller
public class BasketTotalMappingFilter implements Filter {

    private final Basket basket;

    public BasketTotalMappingFilter(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.print("The basket total is: "+ this.basket.getTotalItems());
        request.setAttribute("basketTotal", this.basket.getTotalItems());
        chain.doFilter(request, response);
    }
}
