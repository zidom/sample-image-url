package org.zidom.image.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.zidom.image.service.ImageProcessCommand.Builder;

/**
 * 使用正则对image url中的参数进行分析，不包括url的路径，只包括名称和指令部分.<br/>
 * 
 * 正则如下:
 * 
 * <pre>
 * <b><code>
 * String regex = "^([a-z0-9]+)((\\.(\\d+)_)|[_!.])?(((\\d+)x(\\d+))|([sml]))?(x([FN]))?(\\.[a-zA-Z]{3})$";
 * </code>
 * </b>
 * 该正则共有12个捕获组,其中，有意义的捕获组如下：
 * 0：完整路径
 * 1: 名称
 * 2: 强制按照宽或高进行resize的标识
 *    <b><code>!</code></b> 按宽度比例进行缩放
 *    <b><code>_</code></b> 按高度比例进行缩放
 * 
 *    <b>注意：</b>除以上两张情况外，其他情况不属于强制处理
 * 		
 * 4:  图片压缩比例
 * 7:  宽度 
 * 8：   高度
 * 9:  预定的图片大小S,M,L
 * 11: 是否使用背景的标识,N/F
 * 12: 图片扩展名，带<code>.<code>
 * </pre>
 * 
 * 以上处理0,1不为空以外，其他的都可能为空
 * 
 * @author zidom
 *
 */
public class RegexImageArgsParser implements
		ImageArgsParser<ImageProcessCommand> {

	private final String regex = "^([a-z0-9]+)((\\.(\\d+)_)|[_!.])?(((\\d+)x(\\d+))|([sml]))?(x([FN]))?(\\.[a-zA-Z]{3})$";

	private final Pattern pattern = Pattern.compile(regex);

	@Override
	public ImageProcessCommand parse(String args) {

		Matcher matcher = pattern.matcher(args);
		// 判断是否匹配
		if (!matcher.matches()) {
			return null;
		}
		
		Builder builder = ImageProcessCommand.Builder.build();
		
		builder.name(matcher.group(1));
		
		return ImageProcessCommand.Builder.build()//
				.name(matcher.group(1))//
				.resizeFlag(matcher.group(1).charAt(0))//
				.name(matcher.group(1))//
				.name(matcher.group(1))//
				.name(matcher.group(1))//
				.name(matcher.group(1))//
				.name(matcher.group(1))//
				.name(matcher.group(1))//
				.get();

	}

	static char a;

	public static void main(String[] args) {

		// 测试一下char的默认值
		System.out.println(a == '\0');

		String url = "";

		url = "123456789";
		url = "123456789	_		200x100";
		url = "123456789	!		200x100";
		// url = "123456789	.		200x100		xF";
		url = "123456789	.		200x100		xN";
		url = "123456789	.1_		200x100		xN";
		// url = "123456789	.		s			xF";
		// url = "123456789	.		s			xN";
		// url = "123456789	.		m			xF";

		url = "123456789.png";
		url = "123456789_200x100.png";
		url = "123456789!200x100.jpg";
		url = "123456789.200x100xF.gif";
		// url = "123456789.200x100xN.png";
		url = "123456789.1_200x100xN.JPG";
		// url = "123456789.sxF.PNG";
		// url = "123456789.sxN.jpg";
		// url = "123456789.mxF.png";

		RegexImageArgsParser argsParser = new RegexImageArgsParser();

		Matcher matcher = argsParser.pattern.matcher(url);

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
