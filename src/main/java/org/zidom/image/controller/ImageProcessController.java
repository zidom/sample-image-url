package org.zidom.image.controller;

import org.springframework.stereotype.Controller;

/**
 * 图片处理控制器<br>
 * 通过url路径参数，返回特定的图片
 * 
 * 
 * <pre>
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

}
