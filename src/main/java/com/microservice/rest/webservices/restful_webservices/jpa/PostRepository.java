package com.microservice.rest.webservices.restful_webservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.rest.webservices.restful_webservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
