package hello.springmvc.basic.response;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Controller
@RestController
public class ResponseBodyController {

	@GetMapping("/reponse-body-string-v1")
	public void responseBodyV1(HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}

	@GetMapping("/reponse-body-string-v2")
	public HttpEntity<String> responseBodyV2() {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	// @ResponseBody
	@GetMapping("/reponse-body-string-v3")
	public String responseBodyV3() {
		return "ok";
	}

	@GetMapping("/reponse-body-json-v1")
	public HttpEntity<HelloData> responseBodyJsonV1() {
		HelloData helloData = new HelloData();
		helloData.setUsername("userA");
		helloData.setAge(20);

		return new ResponseEntity<>(helloData, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	// @ResponseBody
	@GetMapping("/reponse-body-json-v2")
	public HelloData responseBodyJsonV2() {
		HelloData helloData = new HelloData();
		helloData.setUsername("userA");
		helloData.setAge(20);
		return helloData;
	}
}
