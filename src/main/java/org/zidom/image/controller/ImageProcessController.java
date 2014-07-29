package org.zidom.image.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 图片处理控制器<br>
 * 通过url路径参数，返回特定的图片
 * 
 * 
 * <pre>
 * 
 * String fileInfo1 = &quot;123456789.jpg&quot;;
 * String fileInfo2 = &quot;123456789_200x100.jpg&quot;;
 * String fileInfo3 = &quot;123456789!200x100.jpg&quot;;
 * String fileInfo4 = &quot;123456789.1_200x100xF&quot;;
 * String fileInfo5 = &quot;123456789.1_200x100xN&quot;;
 * String fileInfo6 = &quot;123456789.sxF.jpg&quot;;
 * String fileInfo7 = &quot;123456789.sxN.jpg&quot;;
 * String fileInfo8 = &quot;123456789.mxF.jpg&quot;;
 * String matcherCommon = &quot;(\\d){9}&quot;;
 * String matcher1 = matcherCommon + &quot;\\.(\\w){3,4}$&quot;;
 * String matcher2 = matcherCommon
 * 		+ &quot;\\.(\\d){1,2}_(\\d){2,4}x(\\d){2,4}x[N,F]{1}$&quot;;
 * String matcher3 = matcherCommon + &quot;\\.[s,m,l]x[N,F]{1}.(\\w){3,4}$&quot;;
 * String matcher4 = matcherCommon + &quot;_(\\d){2,4}+x(\\d){2,4}+\\.(\\w){3,4}$&quot;;
 * String matcher5 = matcherCommon + &quot;!(\\d){2,4}+x(\\d){2,4}+\\.(\\w){3,4}$&quot;;
 * </pre>
 * 
 * @author zidom
 * 
 */
@Controller
public class ImageProcessController {

	private static final Logger	log	= LoggerFactory
											.getLogger(ImageProcessController.class);

	@RequestMapping(value = "/images/{name:[a-z0-9]+}{flag:[._!]}{w:\\.+}", method = RequestMethod.GET)
	public @ResponseBody
	String nomal(@PathVariable("name") String name,
			@PathVariable("ext") String ext, HttpServletResponse response) {

		response.setHeader("Content-Type", "text/plain");

		System.err.printf("***** name: %s.%s \n\n", name, ext);
		return "aha";
	}

	public static void main(String[] args) {

		String p = "^(.+?)((([_!])(\\d+)x(\\d+))|(\\.([sml]x([NF]))))$";
		p = "^(.+?)((([_!])(\\d+)x(\\d+))|(\\.(([sml])x([NFnf])(x([FNfn]))?)))?$";
		p = "^(.+?)(([_!])|(\\.\\d+_))(((\\d+)x(\\d+))|([sml]))(x([NFnf]))?$";
		Pattern pattern = Pattern
				.compile(p);

		String url = "";

		url = "123456789";
		url = "123456789_200x100";
		url = "123456789!200x100";
		// url = "123456789.200x100xF";
		url = "123456789.200x100xN";
		// url = "123456789.sxf";
		// url = "123456789.sxN";
		// url = "123456789.mxf";

		Matcher matcher = pattern.matcher(url);

		if (!matcher.matches()) {
			System.out.println("errr");
			return;
		}

		System.out.println(matcher.groupCount());

		for (int i = 0; i <= matcher.groupCount(); i++) {
			System.out.println(i + ":" + matcher.group(i));
		}

	}
}
