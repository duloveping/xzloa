package cn.com.enjoystudy.oa.webapps;

import cn.com.enjoystudy.oa.util.ImageUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UploadController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    private static final String[] dirs = {"image", "flash", "media", "file"};
    private static final String[] images = { "gif", "jpg", "jpeg", "png", "bmp" };
    private static final String[] flashes = { "swf", "flv" };
    private static final String[] medias = { "swf", "flv", "mp3", "mp4", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb" };
    private static final String[] files = { "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "et", "wps", "dps", "txt", "xz", "zip", "bzip2", "rar", "tar", "gz", "gzip", "bz2", "7z" };
    private static final String UPLOAD_FILE_TYPE_IMAGE = "image";
    private static final String UPLOAD_FILE_TYPE_FLASH = "flash";
    private static final String UPLOAD_FILE_TYPE_MEDIA = "media";
    private static final String UPLOAD_FILE_TYPE_FILE = "file";
    private static final long UPLOAD_MAX_SIZE_IMAGE = 5L * 1024L * 1024L;
    private static final long UPLOAD_MAX_SIZE_FLASH = 50L * 1024L * 1024L;
    private static final long UPLOAD_MAX_SIZE_MEDIA = 1024L * 1024L * 1024L;
    private static final long UPLOAD_MAX_SIZE_FILE = 50L * 1024L * 1024L;

    public JSONObject image(MultipartFile file) {
        return upload(file, UPLOAD_FILE_TYPE_IMAGE);
    }

    public JSONObject flash(MultipartFile file) {
        return upload(file, UPLOAD_FILE_TYPE_FLASH);
    }

    public JSONObject media(MultipartFile file) {
        return upload(file, UPLOAD_FILE_TYPE_MEDIA);
    }

    public JSONObject file(MultipartFile file) {
        return upload(file, UPLOAD_FILE_TYPE_FILE);
    }

    public JSONObject upload(MultipartFile file, String dir) {
        JSONObject json = new JSONObject();
        boolean state = false;
        String info = "\u5931\u8d25";

        String ext = FilenameUtils.getExtension(file.getOriginalFilename());

        Calendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        StringBuilder filePath = new StringBuilder();
        filePath.append("/uploads");
        filePath.append("/" + dir);
        filePath.append("/" + year);
        filePath.append("/" + month);
        filePath.append("/" + date);

        StringBuilder fileName = new StringBuilder();
        fileName.append(hour);
        fileName.append(minute);
        fileName.append(second);
        fileName.append(RandomStringUtils.randomNumeric(10) + "." + ext);

        long size = file.getSize();

        if (Arrays.<String> asList(dirs).contains(dir)) {
            boolean flag = false;
            if (dir.equalsIgnoreCase(UPLOAD_FILE_TYPE_IMAGE)) {
                if (UPLOAD_MAX_SIZE_IMAGE >= size) {
                    flag = true;
                } else {
                    info = "超出图片最大允许上传的大小";
                }
            } else if (dir.equalsIgnoreCase(UPLOAD_FILE_TYPE_FLASH)) {
                if (UPLOAD_MAX_SIZE_FLASH >= size) {
                    flag = true;
                } else {
                    info = "超出FLASH最大允许上传的大小";
                }

            } else if (dir.equalsIgnoreCase(UPLOAD_FILE_TYPE_MEDIA)) {
                if (UPLOAD_MAX_SIZE_MEDIA >= size) {
                    flag = true;
                } else {
                    info = "超出媒体最大允许上传的大小";
                }
            } else if (dir.equalsIgnoreCase(UPLOAD_FILE_TYPE_FILE)) {
                if (UPLOAD_MAX_SIZE_FILE >= size) {
                    flag = true;
                } else {
                    info = "超出文件最大允许上传的大小";
                }
            }

            if (flag) {
                boolean status = false;
                if (UPLOAD_FILE_TYPE_IMAGE.equals(dir)) {
                    if (Arrays.<String> asList(images).contains(ext)) {
                        status = true;
                    } else {
                        info = "允许上传图片的扩展名为：" + StringUtils.join(images, "，") + "。";
                    }
                } else if (UPLOAD_FILE_TYPE_FLASH.equals(dir)) {
                    if (Arrays.<String> asList(flashes).contains(ext)) {
                        status = true;
                    } else {
                        info = "允许上传FLASH的扩展名为：" + StringUtils.join(flashes, "，") + "。";
                    }
                } else if (UPLOAD_FILE_TYPE_MEDIA.equals(dir)) {
                    if (Arrays.<String> asList(medias).contains(ext)) {
                        status = true;
                    } else {
                        info = "允许上传媒体的扩展名为：" + StringUtils.join(medias, "，") + "。";
                    }
                } else if (UPLOAD_FILE_TYPE_FILE.equals(dir)) {
                    if (Arrays.<String> asList(files).contains(ext)) {
                        status = true;
                    } else {
                        info = "允许上传文件的扩展名为：" + StringUtils.join(files, "，") + "。";
                    }
                }

                if (status) {
                    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
                    ServletContext sc = wac.getServletContext();
                    String real = sc.getRealPath("/") + StringUtils.replace(filePath.toString(), "/", File.separator);
                    File newfile = new File(real);
                    if (!newfile.exists()) {
                        newfile.mkdirs();
                    }

                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        is = file.getInputStream();
                        File bigFile = new File(newfile, fileName.toString());
                        os = new FileOutputStream(bigFile);
                        IOUtils.copy(is, os);

                        if (UPLOAD_FILE_TYPE_IMAGE.equals(dir)) {
                            StringBuilder middle = new StringBuilder();
                            middle.append(hour);
                            middle.append(minute);
                            middle.append(second);
                            middle.append(RandomStringUtils.randomNumeric(10) + "." + ext);

                            StringBuilder small = new StringBuilder();
                            small.append(hour);
                            small.append(minute);
                            small.append(second);
                            small.append(RandomStringUtils.randomNumeric(10) + "." + ext);

                            StringBuilder thumb = new StringBuilder();
                            thumb.append(hour);
                            thumb.append(minute);
                            thumb.append(second);
                            thumb.append(RandomStringUtils.randomNumeric(10) + "." + ext);

                            try {
                                File middleFile = new File(newfile, middle.toString());
                                ImageUtils.saveImageAsJpg(bigFile, middleFile);

                                File smallFile = new File(newfile, small.toString());
                                ImageUtils.saveImageAsJpg(middleFile, smallFile);

                                File thumbFile = new File(newfile, thumb.toString());
                                ImageUtils.saveImageAsJpg(bigFile, thumbFile, 60, 60);

                                json.put("large", filePath + "/" + fileName.toString());
                                json.put("middle", filePath + "/" + middle);
                                json.put("small", filePath + "/" + small);
                                json.put("thumb", filePath + "/" + thumb);
                            } catch (Exception e) {
                                logger.error(e.getMessage(), e);
                            }
                        } else {
                            json.put("url", filePath + "/" + fileName.toString());

                        }

                        json.put("size", size);
                        json.put("contentType", FilenameUtils.getExtension(file.getOriginalFilename()));
                        json.put("fileName", file.getOriginalFilename());
                        json.put("dir", dir);
                        state = true;
                        info = "\u6210\u529f";
                    } catch (IOException e) {
                        info = "上传出错了。";
                        logger.error(e.getMessage(), e);
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                            if (os != null) {
                                os.flush();
                                os.close();
                            }
                        } catch (IOException e) {
                            info = "上传出错了。";
                            logger.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }

        json.put("state", state);
        json.put("info", info);
        return json;
    }

    @ResponseBody
    @RequestMapping("upload-image")
    public JSONObject uploadImage(MultipartFile file) {
        return image(file);
    }

    @ResponseBody
    @RequestMapping("upload-flash")
    public JSONObject uploadFlash(MultipartFile file) {
        return flash(file);
    }

    @ResponseBody
    @RequestMapping("upload-media")
    public JSONObject uploadMedia(MultipartFile file) {
        return media(file);
    }

    @ResponseBody
    @RequestMapping("upload-file")
    public JSONObject uploadFile(MultipartFile file) {
        return file(file);
    }

    @ResponseBody
    @RequestMapping("upload-utils")
    public JSONObject uploadUtils(MultipartFile file, @RequestParam("dir") String dir) {
        return upload(file, dir);
    }

    @RequestMapping("download")
    public void download(@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath,
            HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath(filePath);
        File file = new File(realPath);
        if (file.exists()) {
            try {
                long fileSize = FileUtils.sizeOf(file);

                // 以流的形式下载文件
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                try {
                    String filename = new String(fileName.getBytes("GBK"), "ISO8859-1");

                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fis.close();
                    response.reset();
                    response.addHeader("content-disposition", "attachment;filename=" + filename);
                    response.addHeader("content-length", "" + fileSize);
                    response.setCharacterEncoding("utf-8");
                    OutputStream os = new BufferedOutputStream(response.getOutputStream());
                    response.setContentType(new MimetypesFileTypeMap().getContentType(file));
                    os.write(buffer);
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            } catch (FileNotFoundException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}

