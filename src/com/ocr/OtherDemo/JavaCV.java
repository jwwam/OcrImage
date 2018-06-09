package com.ocr.OtherDemo;
import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_core.*;//定义了图像数据结构的核心库
import static org.bytedeco.javacpp.opencv_highgui.*;//包含了所有图形接口函数
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;	//COLOR_RGB2GRAY

/**
 * javaCV灰度&图像二值化
 */
public class JavaCV {

    public static void main(String[] args) {
        //图片地址
        String imgUrl = "C:\\mysoftware\\images\\upload\\OcrImg\\girl.png";
        //得到灰度图像
        getHuidu(imgUrl);
        //得到二值化处理图像
        getErzhihua(imgUrl);
    }

    //得到灰度图像
    public static void getHuidu(String imgUrl){
        Mat image=imread(imgUrl,CV_LOAD_IMAGE_GRAYSCALE);
        //读入一个图像文件并转换为灰度图像（由无符号字节构成）
        Mat image1=imread(imgUrl,CV_LOAD_IMAGE_COLOR);
        //读取图像，并转换为三通道彩色图像，这里创建的图像中每个像素有3字节
        //如果输入图像为灰度图像，这三个通道的值就是相同的
        System.out.println("image has "+image1.channels()+" channel(s)");
        //channels方法可用来检查图像的通道数
        flip(image,image,1);//就地处理,参数1表示输入图像，参数2表示输出图像
        //在一窗口显示结果
        namedWindow("输入图片显示窗口");//定义窗口
        imshow("输入图片显示窗口",image);//显示窗口
        waitKey(0);//因为他是控制台窗口，会在mian函数结束时关闭;0表示永远的等待按键,正数表示等待指定的毫秒数
    }

    //得到二值化处理图像
    public static void getErzhihua(String imgUrl){
        // TODO Auto-generated method stub
        Mat image=imread(imgUrl);	//加载图像
        if(image.empty())
        {
            System.out.println("图像加载错误，请检查图片路径！");
            return ;
        }
        imshow("原始图像",image);
        Mat gray=new Mat();
        cvtColor(image,gray,COLOR_RGB2GRAY);		//彩色图像转为灰度图像
        imshow("灰度图像",gray);
        Mat bin=new Mat();
        threshold(gray,bin,120,255,THRESH_TOZERO); 	//图像二值化
        imshow("二值图像",bin);
        waitKey(0);
    }
}
