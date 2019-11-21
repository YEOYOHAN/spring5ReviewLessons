package com.han.web.usr;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
	
	private String uid, uname, upw, tel, upoint, age, loc, gender,
	email, bookmark, lolblack, futblack;
}
