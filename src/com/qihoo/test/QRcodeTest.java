package com.qihoo.test;

import javax.management.RuntimeErrorException;

import com.qihoo.QRCodeUtil;

public class QRcodeTest {
	static String url_parm="";//apk path
	static String image_parm=""; // image name
	static String save_path=""; // save path
	public static void main(String[] args) throws Exception {
		
		if(args.length != 0){
			for (String arg : args) {
				if(arg.startsWith("url=")){
					url_parm = arg.trim().toLowerCase().split("=")[1];
				}else if(arg.startsWith("image=")){
					image_parm = arg.trim().toLowerCase().split("=")[1];
				}else if(arg.startsWith("save=")){
					save_path = arg.trim().toLowerCase().split("=")[1];
				}
			}
		}else{
			throw new RuntimeErrorException(null, "url or image save path are mandatory!");
		}
		
		//String url = "http://10.18.61.81:8080/jenkins/job/sdk4android/lastSuccessfulBuild/artifact/TesterDemo/build/outputs/apk/TesterDemo-debug.apk";

		if(url_parm==""){
			url_parm="http://www.so.com";
		}
		QRCodeUtil.encode(url_parm,image_parm,save_path,true);
	}

}
