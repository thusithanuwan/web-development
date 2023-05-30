package lk.ijse.dep10.fileupload;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*! Enable File Uploading (if file comes in multipart form data by default spring does not read , so we have to enable that ) */
    /* ! After we enable that we have to give temporary location to store chunks, coming from request body  */

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String osTempDir = System.getProperty("java.io.tmpdir");
//        registration.setMultipartConfig(new MultipartConfigElement(osTempDir, 10 * 1024 * 1024, 20 * 1024 * 1024, 25 ));
        registration.setMultipartConfig(new MultipartConfigElement(osTempDir));
    }

}
