<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="navigation-bar">
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="/">Helping Hands</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler">
                <i class="fa fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggler">
                <ul class="navbar-nav ml-auto">
                	
                	<sec:authorize access="hasRole('DONOR')">
                    <li class="nav-item">
                        <a class="nav-link" href="/donor/">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/donor/make-donation" >Make a Donation</a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('RECEIVER')">
                    <li class="nav-item">
                        <a class="nav-link" href="/receiver/">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/receiver/panding-donation">Panding Donation</a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/">Admin</a>
                    </li>
                    </sec:authorize>
                    
                    <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/receiver/panding-donation">Panding Donation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/donor/make-donation" >Make a Donation</a>
                    </li>
                    </sec:authorize>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="/about-us">About Us</a>
                    </li>
                    
					<sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                    </sec:authorize>
                    
                </ul>
            </div>
        </div>
    </nav>
</div>