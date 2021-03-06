package com.esgi.ModuleAnnotations.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.jar.JarFile;

@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
public @interface PluginView {
	enum ViewType {
		   LEFT, CENTER, RIGHT
	}
	ViewType viewType();
	boolean isStyleInherit() default true;
}
