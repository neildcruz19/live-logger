/**
 * 
 */
package com.livelog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livelog.service.LiveLogService;

/**
 * @author neildcruz
 *
 */
@RestController
public class LiveLogController {

	@Autowired
	private LiveLogService liveLogService;

	@RequestMapping(value = "/api/log",method = RequestMethod.GET, produces = "text/plain")
	public String getLiveLog(@RequestParam(value="lastLocation", required = false) Long lastLocation,
			@RequestParam(value = "numberOfLines", required = false) Long numberOfLines) {
		return liveLogService.getLogAsString(lastLocation, numberOfLines);
	}

}
