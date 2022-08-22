package springcourse;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispetcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {       //для коф с помощью кода наследуем этот класс(он заменяет файл web xml при wml конфиг)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};             //путь к классу спринг конфига
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};              //маст хэв эта штука
    }
}
