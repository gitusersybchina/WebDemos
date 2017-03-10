package com.xiaodemo.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DownLoadAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		download(req, resp);
	}

	public void download(HttpServletRequest req, HttpServletResponse resp) {

		try {

			URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489161016805&di=2efa1ee0856d342138e430b0d8d6fe9b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121209%2F234928-12120Z0543764.jpg");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();

			//将文件下载 到eclipse安装目录下
			File file = new File("download.jpg");
			if (file.exists()) {

				System.out.println("文件已经存在......");
				System.out.println(file.getAbsolutePath());

			} else {
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);

				int t = 0;
				byte b[] = new byte[1024];
				while ((t = is.read(b)) != -1) {
					// 读多少字节写入多少字节
					bos.write(b, 0, t);
				}

				bos.close();
				fos.close();
				is.close();

				System.out.println("-----Download SUCCESS-----");
				resp.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
