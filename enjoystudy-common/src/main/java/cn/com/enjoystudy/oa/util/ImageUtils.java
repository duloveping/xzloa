package cn.com.enjoystudy.oa.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class ImageUtils {
    private static final Logger LOGGER = Logger.getLogger(ImageUtils.class);

    /**
     * 给图片添加水印、可设置水印图片旋转角度
     *
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath  目标图片路径
     * @param degree 水印图片旋转角度
     * @param width 宽度(与左相比)
     * @param height 高度(与顶相比)
     * @param clarity 透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkImageByIcon(String logoText, String iconPath, String srcImgPath, String targerPath,
                                            Integer degree, Integer width, Integer height, float clarity) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            System.out.println("width:" + srcImg.getWidth(null));
            System.out.println("height:" + srcImg.getHeight(null));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 得到Image对象。
            Image img = imgIcon.getImage();
            float alpha = clarity; // 透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 表示水印图片的位置
            //          g.drawImage(img, width, height, null);
            g.drawImage(img, srcImg.getWidth(null) - img.getWidth(null), srcImg.getHeight(null) - img.getHeight(null), null);

            //          g.drawString(logoText, srcImg.getWidth(null) - img.getWidth(null), srcImg.getHeight(null) - img.getHeight(null));

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印图片完成!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 给图片添加水印、可设置水印图片旋转角度
     *
     * @param logoText 印文字
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     * @param width   宽度(与左相比)
     * @param height 高度(与顶相比)
     * @param clarity 透明度(小于1的数)越接近0越透明
     */
    public static void waterMarkByText(String logoText, String srcImgPath, String targerPath, Integer degree, Integer width, Integer height, Float clarity) {
        // 主图片的路径
        InputStream is = null;
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            // 设置颜色
            g.setColor(Color.red);
            // 设置 Font
            g.setFont(new Font("宋体", Font.BOLD, 30));
            float alpha = clarity;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y) .
            g.drawString(logoText, width, height);
            g.dispose();
            os = new FileOutputStream(targerPath);
            // 生成图片
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("添加水印文字完成!");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
            try {
                if (null != os) {
                    os.close();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 图片缩放(图片等比例缩放为指定大小，空白部分以白色填充)
     *
     * @param srcPath 源图片路径
     * @param destPath 缩放后图片路径
     */
    public static void zoomImage(String srcPath, String destPath, int destHeight, int destWidth) {
        BufferedImage srcBufferedImage = null;
        BufferedImage destBufferedImage = null;
        try {
            srcBufferedImage = ImageIO.read(new File(srcPath));
            int imgWidth = destWidth;
            int imgHeight = destHeight;
            int srcWidth = srcBufferedImage.getWidth();
            int srcHeight = srcBufferedImage.getHeight();
            if (srcHeight >= srcWidth) {
                imgWidth = (int) Math.round(((destHeight * 1.0 / srcHeight) * srcWidth));
            } else {
                imgHeight = (int) Math.round(((destWidth * 1.0 / srcWidth) * srcHeight));
            }
            destBufferedImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = destBufferedImage.createGraphics();
            graphics2D.setBackground(Color.WHITE);
            graphics2D.clearRect(0, 0, destWidth, destHeight);
            graphics2D.drawImage(srcBufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH), (destWidth / 2) - (imgWidth / 2), (destHeight / 2) - (imgHeight / 2), null);
            graphics2D.dispose();
            ImageIO.write(destBufferedImage, "JPEG", new File(destPath));
            destBufferedImage.flush();
            srcBufferedImage.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (null != destBufferedImage) { destBufferedImage.flush(); }
            if (null != srcBufferedImage) { srcBufferedImage.flush(); }
        }
    }

    /**
     * 将图按比例缩小
     * @param source
     * @param targetW
     * @param targetH
     * @return
     */
    public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
        // targetW，targetH分别表示目标长和宽
        int type = source.getType();
        BufferedImage target = null;
        double sx = (double) targetW / source.getWidth();
        double sy = (double) targetH / source.getHeight();
        // 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放则将下面的if else语句注释即可
//		if (sx > sy) {
//			sx = sy;
//			targetW = (int) (sx * source.getWidth());
//		} else {
//			sy = sx;
//			targetH = (int) (sy * source.getHeight());
//		}
        if (type == BufferedImage.TYPE_CUSTOM) { // handmade
            ColorModel cm = source.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else
            target = new BufferedImage(targetW, targetH, type);
        Graphics2D g = target.createGraphics();
        // smoother than exlax:
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        return target;
    }

    public static void saveImageAsJpg(String from, String to) throws Exception {
        File toFile = new File(to);
        File fromFile = new File(from);
        saveImageAsJpg(fromFile, toFile);
    }

    public static void saveImageAsJpg(File from, File to) throws Exception {
        saveImageAsJpg(from, to, 0, 0);
    }

    public static void saveImageAsJpg(File from, File to, int width, int height) throws Exception {

        if (from != null) {
            if (from.isFile()) {
                String name = from.getName();
                String imgType = "JPEG";
                if (name.toLowerCase().endsWith(".png")) {
                    imgType = "PNG";
                } else if (name.toLowerCase().endsWith(".jpg")) {
                    imgType = "JPG";
                } else if (name.toLowerCase().endsWith(".jpeg")) {
                    imgType = "JPEG";
                } else if (name.toLowerCase().endsWith(".gif")) {
                    imgType = "GIF";
                } else if (name.toLowerCase().endsWith(".bmp")) {
                    imgType = "BMP";
                } else {
                    imgType = "JPEG";
                }

                BufferedImage srcImage = ImageIO.read(from);
                if (width == 0 && height == 0) {
                    int w = srcImage.getWidth() / 2;
                    int h = srcImage.getHeight() / 2;
                    if (w > 0 || h > 0) {
                        srcImage = resize(srcImage, w, h);
                    }
                } else {
                    srcImage = resize(srcImage, width, height);
                }
                ImageIO.write(srcImage, imgType, to);
            }
        }
    }

    public static void saveImageAsJpg(String from, String to, int width, int height) throws Exception {
        File toFile = new File(to);
        File fromFile = new File(from);
        saveImageAsJpg(fromFile, toFile, width, height);
    }

    public static void copy(String path, InputStream is) throws IOException {
        OutputStream os = null;
        try {
            File file = new File(path);
            byte[] bytes = IOUtils.toByteArray(is);
            os = new FileOutputStream(file);
            IOUtils.write(bytes, os);
        } finally {
            if (os != null) {
                os.flush();
                os.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    public static void copy(InputStream is, OutputStream os) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        try {
            copy(bis, bos);
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.flush();
                os.close();
            }

        }
    }
    public static void copy(BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
        try {
            IOUtils.copy(bis, bos);
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.flush();
                bos.close();
            }
        }
    }
}
