package com.tcs.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ErrorHandleFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(ErrorHandleFilter.class);



	private FilterConfig filterConfig;

	public ErrorHandleFilter() {

	}

	@Override
	public void init(FilterConfig filterConfig)
	{
		LOG.info("Inside Filter");
		this.filterConfig = filterConfig;
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	{
		try
		{



			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;


			String ipAddress = request.getRemoteAddr();
			LOG.debug("Data is coming from IP info "+ipAddress);
			LOG.debug("Request URL is "+req.getRequestURL());


			String exactPathRequested=req.getPathInfo();

			LOG.info("path requested is "+exactPathRequested);

			String sharedSecretKey=null;

			
			
			if(exactPathRequested!=null){

				

					Enumeration headerNames = req.getHeaderNames();

					while(headerNames.hasMoreElements()) {
						String paramName = (String)headerNames.nextElement();

				

						if(paramName.equalsIgnoreCase("key"))
						{

							sharedSecretKey=req.getHeader(paramName); 


							break;
						}
					}
				
			}





			res.setHeader("pragma", "no-cache");
			res.setHeader("Cache-Control", "no-cache");
			res.setHeader("Cache-Control", "no-store");
			res.addDateHeader("Expires", 0L);
			res.setDateHeader("max-age", 0L);
			res.setIntHeader("Expires", -1);



		/*	if(flagOfSecrectKey!=0){
				if (!checkSharedSecretKey(sharedSecretKey)) {
					LOG.error("UNAUTHORIZED ACCESS : Invalid shared secret key ");

					return;

				}
			}*/
			LOG.info("Filter class passed, going to controller");
			
			System.out.println("received key was"+sharedSecretKey);
			
			chain.doFilter(request, response);
		} catch (IOException io) {
			LOG.error("IOException", io);
			LOG.error("IOException raised");
		} catch (ServletException se) {
			LOG.error("ServletException", se);
			LOG.error("ServletException raised");
		} catch (Exception e) {
			LOG.error("Exception", e);
			LOG.error(e.getMessage());
		}

	}
	private void checkSharedSecretKey(String sharedSecretKey) {/*
		LOG.info("Client version number is "+rb.getString("CURRENT_VERSION_NO"));

		LOG.info("received shared key "+sharedSecretKey);
		try {




			int indexOfSpace=sharedSecretKey.indexOf(Constants.SPACE);

			if(indexOfSpace!=-1){
				sharedSecretKey=sharedSecretKey.replaceAll(Constants.SPACE,Constants.PLUS);

			}


			String decryptedStringFromClient = CustomAttributeService.decrypt(sharedSecretKey, CustomAttributeService.getEncryptkey());

			String decryptedStringFromInforms = CustomAttributeService.decrypt(rb.getString(Constants.SHARED_SECRET_KEY), CustomAttributeService.getEncryptkey());



			if(decryptedStringFromInforms.equals(decryptedStringFromClient))
			{

				return true;
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException | IOException e) {
			LOG.error("Error in checking shared Secret Key : ",e);
		}
		catch(Exception e)
		{
			LOG.error("Error in checking shared Secret Key : ",e);
		}
		return false;
	*/}

	public FilterConfig getFilterConfig() {
		LOG.info("CustomAuth Filter---Informs| getFilterConfig initiated");
		return this.filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		LOG.info("CustomAuth Filter---Informsr | setFilterConfig initiated");
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		LOG.info("CustomAuth Filter---Informs destroy called");
	}

}