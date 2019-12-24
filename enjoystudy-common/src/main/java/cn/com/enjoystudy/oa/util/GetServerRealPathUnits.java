package cn.com.enjoystudy.oa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class GetServerRealPathUnits {
    private static Logger logger = LoggerFactory.getLogger(GetServerRealPathUnits.class);

    public static String getPath(String subdirectory) {
        String realPath = "";
        File upload = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            upload = new File(path.getAbsolutePath(), subdirectory);
            if (!upload.exists()) {
                upload.mkdirs();
            }
            realPath = upload.getAbsolutePath();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
        return realPath;
    }
}

