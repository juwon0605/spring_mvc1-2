package hello.springmvc.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {

	// private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";

		// System.out.println();

		//잘못 된 예. 동작하지 않을 수도 있는 함수에도 파라미터 연산이 먼저 일어남.
		// log.trace("trace log=" + name);
		//올바른 예
		log.trace("trace log={}", name);
		log.debug("trace log={}", name);
		log.info(" info log={}", name);
		log.warn("trace log={}", name);
		log.error("trace log={}", name);

		return "ok";
	}
}
