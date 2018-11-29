package filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.ActionContext;
import Util.MyUtil;
import config.MyConfig;
import config.ResultConfig;




public class MyFilter implements Filter{
	private Map<String, MyConfig> ConfigMap;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ConfigMap = MyUtil.getMap();
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res  = (HttpServletResponse) response;
		
		ActionContext actionContext = new ActionContext(req,res);
		ActionContext.setContext(actionContext);
		String reqUri = req.getRequestURI().substring(1);
		if (!ConfigMap.containsKey(reqUri) || (reqUri.equals("") || reqUri == null)) {
			chain.doFilter(req, res);
		}else {
           ResultConfig resultConfig = MyUtil.goAction(ConfigMap.get(reqUri));
           String resultType = resultConfig.getType();
           String resultPath = resultConfig.getPath();
           if (resultType.equals("dispatcher")) {
        	   req.getRequestDispatcher(resultPath).forward(req, res);;
           }else if (resultType.equals("redirect")) {
        	   res.sendRedirect(resultPath);
           }
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
