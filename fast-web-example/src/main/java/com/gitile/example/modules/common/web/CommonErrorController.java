package com.gitile.example.modules.common.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.gitile.fast.core.entity.FastR;

/**
 * 错误页面
 */
@RestController
public class CommonErrorController implements ErrorController {
	
	@RequestMapping(value = "/error",  produces = {MediaType.APPLICATION_JSON_VALUE})
    private FastR error(WebRequest request) {
		return FastR.error("系统发生错误，请稍后重试");
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
