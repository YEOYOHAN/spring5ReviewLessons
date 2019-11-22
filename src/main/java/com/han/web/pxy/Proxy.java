package com.han.web.pxy;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component("pxy")
public class Proxy {
	public String string(Object param) {
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	public int integer(String t) {
		//Function<String, Integer> f= s->Integer.parseInt(s);
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(t);
	}
	public boolean equal(String t, String u) {
		//BiPredicate<String, String> f = (t, u)->t.equals(u);
		BiPredicate<String, String> f = String :: equals;
		return f.test(t, u);
	}
	public void printer(String s) {
		Consumer<String> c = System.out::print;
		c.accept(s);
	}
	public int random(int i, int o) {
	      BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
	    return p.apply(i, o);
	}
}
