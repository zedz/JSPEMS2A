package tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	private String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext ctx=(PageContext)getJspContext();
		JspWriter out=ctx.getOut();
		String date=new SimpleDateFormat(pattern).format(new Date());
		out.println(date);
	}
}
