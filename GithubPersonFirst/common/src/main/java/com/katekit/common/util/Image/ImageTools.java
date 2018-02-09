package com.katekit.common.util.Image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

import com.katekit.common.Constants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Tools for handler picture
 *
 * @author Ryan.Tang
 */
public final class ImageTools {

    /**
     * Transfer drawable to bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();

        Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
                : Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Bitmap to drawable
     *
     * @param bitmap
     * @return
     */
    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    /**
     * Input stream to bitmap
     *
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static Bitmap inputStreamToBitmap(InputStream inputStream)
            throws Exception {
        return BitmapFactory.decodeStream(inputStream);
    }

    /**
     * Byte transfer to bitmap
     *
     * @param byteArray
     * @return
     */
    public static Bitmap byteToBitmap(byte[] byteArray) {
        if (byteArray.length != 0) {
            return BitmapFactory
                    .decodeByteArray(byteArray, 0, byteArray.length);
        } else {
            return null;
        }
    }

    /**
     * Byte transfer to drawable
     *
     * @param byteArray
     * @return
     */
    public static Drawable byteToDrawable(byte[] byteArray) {
        ByteArrayInputStream ins = null;
        if (byteArray != null) {
            ins = new ByteArrayInputStream(byteArray);
        }
        return Drawable.createFromStream(ins, null);
    }

    /**
     * Bitmap transfer to bytes
     *
     * @param bm
     * @return
     */
    public static byte[] bitmapToBytes(Bitmap bm) {
        byte[] bytes = null;
        if (bm != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(CompressFormat.PNG, 100, baos);
            bytes = baos.toByteArray();
        }
        return bytes;
    }

    /**
     * Drawable transfer to bytes
     *
     * @param drawable
     * @return
     */
    public static byte[] drawableToBytes(Drawable drawable) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        byte[] bytes = bitmapToBytes(bitmap);
        ;
        return bytes;
    }

    /**
     * Base64 to byte[]
     //	 */
//	public static byte[] base64ToBytes(String base64) throws IOException {
//		byte[] bytes = Base64.decode(base64);
//		return bytes;
//	}
//
//	/**
//	 * Byte[] to base64
//	 */
//	public static String bytesTobase64(byte[] bytes) {
//		String base64 = Base64.encode(bytes);
//		return base64;
//	}

    /**
     * Create reflection images
     *
     * @param bitmap
     * @return
     */
    public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
        final int reflectionGap = 4;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, h / 2, w,
                h / 2, matrix, false);

        Bitmap bitmapWithReflection = Bitmap.createBitmap(w, (h + h / 2),
                Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmapWithReflection);
        canvas.drawBitmap(bitmap, 0, 0, null);
        Paint deafalutPaint = new Paint();
        canvas.drawRect(0, h, w, h + reflectionGap, deafalutPaint);

        canvas.drawBitmap(reflectionImage, 0, h + reflectionGap, null);

        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
                bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,
                0x00ffffff, TileMode.CLAMP);
        paint.setShader(shader);
        // Set the Transfer mode to be porter duff and destination in
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        // Draw a rectangle using the paint with our linear gradient
        canvas.drawRect(0, h, w, bitmapWithReflection.getHeight()
                + reflectionGap, paint);

        return bitmapWithReflection;
    }

    /**
     * Get rounded corner images
     *
     * @param bitmap
     * @param roundPx 5 10
     * @return
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap output = Bitmap.createBitmap(w, h, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, w, h);
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

    /**
     * Resize the bitmap
     *
     * @param bitmap
     * @param width
     * @param height
     * @return
     */
    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }

    /**
     * Resize the drawable
     *
     * @param drawable
     * @param w
     * @param h
     * @return
     */
    public static Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        float sx = ((float) w / width);
        float sy = ((float) h / height);
        matrix.postScale(sx, sy);
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return new BitmapDrawable(newbmp);
    }

    /**
     * Get images from SD card by path and the name of image
     *
     * @param photoName
     * @return
     */
    public static Bitmap getPhotoFromSDCard(String path, String photoName) {
        Bitmap photoBitmap = BitmapFactory.decodeFile(path + "/" + photoName + Constants.PHOTO_FILE_SUFFIX);
        if (photoBitmap == null) {
            return null;
        } else {
            return photoBitmap;
        }
    }

    /**
     * Check the SD card
     *
     * @return
     */
    public static boolean checkSDCardAvailable() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * Get image from SD card by path and the name of image
     *
     * @param path
     * @param photoName
     * @return
     */
    public static boolean findPhotoFromSDCard(String path, String photoName) {
        boolean flag = false;

        if (checkSDCardAvailable()) {
            File dir = new File(path);
            if (dir.exists()) {
                File folders = new File(path);
                File photoFile[] = folders.listFiles();
                for (int i = 0; i < photoFile.length; i++) {
                    String fileName = photoFile[i].getName().split("\\.")[0];
                    if (fileName.equals(photoName)) {
                        flag = true;
                    }
                }
            } else {
                flag = false;
            }
//			File file = new File(path + "/" + photoName  + ".jpg" );
//			if (file.exists()) {
//				flag = true;
//			}else {
//				flag = false;
//			}

        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * Save image to the SD card
     *
     * @param photoBitmap
     * @param photoName
     * @param path
     */
    public static void savePhotoToSDCard(Bitmap photoBitmap, String path, String photoName, CompressFormat format, int quality) {
        if (checkSDCardAvailable()) {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File photoFile = new File(path, photoName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(photoFile);
                if (photoBitmap != null) {
                    if (photoBitmap.compress(format, quality, fileOutputStream)) {
                        fileOutputStream.flush();
//						fileOutputStream.close();
                    }
                }
            } catch (FileNotFoundException e) {
                photoFile.delete();
                e.printStackTrace();
            } catch (IOException e) {
                photoFile.delete();
                e.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Delete the image from SD card
     *
     * @param path
     */
    public static void deleteAllPhoto(String path) {
        if (checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
        }
    }

    public static void deletePhotoAtPathAndName(String path, String fileName) {
        if (checkSDCardAvailable()) {
            File folder = new File(path);
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().split("\\.")[0].equals(fileName)) {
                    files[i].delete();
                }
            }
        }
    }

    /**
     * caculate the bitmap sampleSize
     *
     * @param options
     * @param rqsW
     * @param rqsH
     * @return
     */
    public final static int caculateInSampleSize(BitmapFactory.Options options, int rqsW, int rqsH) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (rqsW == 0 || rqsH == 0) return 1;
        if (height > rqsH || width > rqsW) {
            final int heightRatio = Math.round((float) height / (float) rqsH);
            final int widthRatio = Math.round((float) width / (float) rqsW);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    /**
     * 压缩指定路径的图片，并得到图片对象
     *
     * @param path
     * @param rqsW
     * @param rqsH
     * @return
     */
    public final static Bitmap compressBitmap(String path, int rqsW, int rqsH) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inSampleSize = caculateInSampleSize(options, rqsW, rqsH);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    /**
     * 强制压缩图片到指定的大小，如果图片的原始高度>原始宽度，则转成宽度值为新的高度值，高度为新的宽度值
     *
     * @param path
     * @param rqsW
     * @param rqsH
     * @return
     */
    public static Bitmap forceCompressBitmap(String path, int rqsW, int rqsH) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        if (options.outHeight < rqsH || options.outWidth < rqsW) {
            options.inSampleSize = 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path, options);
        } else {
            options.inSampleSize = caculateInSampleSize(options, rqsW, rqsH);
            options.inJustDecodeBounds = false;
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            Bitmap scaleBitmap;
            if (options.outHeight < options.outWidth) {
                scaleBitmap = zoomBitmap(bitmap, rqsH, rqsW);
            } else {
                scaleBitmap = zoomBitmap(bitmap, rqsW, rqsH);
            }
//			bitmap.recycle(); //回收bitmap，调用gc强制(Note：如果没有comment掉这2句，则从相册获取图片有时会抛异常。
//			System.gc();

            return scaleBitmap;
        }
    }

    /**
     * 压缩指定路径的图片，并得到图片对象
     *
     * @param path
     * @param sampleSize
     * @return
     */
    public final static Bitmap resizeBitmapFromFile(String path, int sampleSize) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDither = false;  //Disable Dithering mode
        options.inPreferredConfig = Config.RGB_565;
        options.inPurgeable = true;  //Tell to gc that whether it needs free memory, the Bitmap can be cleared
        options.inInputShareable = true;  //Which kind of reference will be used to recover the Bitmap data after being clear, when it will be used in the future
        BitmapFactory.decodeFile(path, options);
        int requestWidth = options.outWidth / sampleSize;
        int requestHeight = options.outHeight / sampleSize;
        options.inSampleSize = sampleSize; // inSampleSize 生效的是对 取临近 sampleSize 的2的次方的值，譬如sampleSize=5，经过options获取到的是缩小4倍的图
        options.inJustDecodeBounds = false;
        // 再缩小到指定的倍数
        Bitmap bitmap = BitmapFactory.decodeFile(path, options);
//        Bitmap scaleBitmap = zoomBitmap(bitmap, requestWidth, requestHeight);
//        bitmap.recycle(); //回收bitmap，调用gc强制
//        System.gc();
        return bitmap;
    }
    
    /*
     * @param src 原图片
	 * 
	 * @param fileName 图片名称
	 * 
	 * @param watermark 要打的水印的图片
	 * 
	 * @param title 要打的水印文字
	 * 
	 * @return Bitmap 打好水印的图片
	 */

    public static Bitmap createWarterMarkBitmap(Bitmap src,
                                                Bitmap waterMark, String title) {
        if (src == null) {
            return null;
        }

        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();

        Paint paint = new Paint();
        // 创建新的和src一样大小的图
        Bitmap newBitmap = Bitmap.createBitmap(srcWidth, srcHeight,
                Config.ARGB_8888);
        // 吧创建的位图作为画板
        Canvas cv = new Canvas(newBitmap);
        // 在 0，0 处开始画入src
        cv.drawBitmap(src, 0, 0, paint);

        // 图片水印
        if (waterMark != null) {
            int waterWidth = waterMark.getWidth();
            int waterHeight = waterMark.getHeight();
            // 在src的左上角画入水印
            cv.drawBitmap(waterMark, 0, 0, paint);
        }

        // 加入文字文字水印
        if (title != null) {
            TextPaint textPaint = new TextPaint();
            textPaint.setColor(Color.WHITE);
            textPaint.setTextSize(30);
            Rect bounds = new Rect();
            //得到能够包裹文字的最小矩形bounds,这里的Rect对象坐标并不是以左上角为准的，而是相对于左边中间靠下位置的一个点，r.top就是一个负值了
            textPaint.getTextBounds(title, 0, title.length(), bounds);
            cv.drawText(title, srcWidth / 2 - bounds.width() / 2, srcHeight / 2, textPaint);//画在左上角
        }

        cv.save(Canvas.ALL_SAVE_FLAG);// 保存
        cv.restore();// 存储

        return newBitmap;
    }
}
