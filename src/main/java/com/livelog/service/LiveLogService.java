/**
 * 
 */
package com.livelog.service;

/**
 * @author neildcruz
 *
 */
public interface LiveLogService {

	/**
	 * Service method to get the log from a file
	 * If lastLocation is known it will read forward n lines
	 * else will read n lines back from EOF
	 * @param lastLocation
	 * @return
	 */
	public String getLogAsString(Long lastLocation, Long numberOfLines);
}
