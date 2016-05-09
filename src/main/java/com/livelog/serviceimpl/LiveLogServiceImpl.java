/**
 * 
 */
package com.livelog.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.livelog.service.LiveLogService;

/**
 * @author neildcruz
 *
 */
@Service
public class LiveLogServiceImpl implements LiveLogService {

	@Autowired
	private Environment env;

	private static final Logger log = Logger.getLogger(LiveLogServiceImpl.class.getName());

	@Override
	public String getLogAsString(Long lastLocation, Long numberOfLines) {
		String response = "";
		RandomAccessFile logFile = null;
		try {
			logFile  = new RandomAccessFile(new File(env.getProperty("logging.file")), "r");
		} catch (FileNotFoundException e) {
			log.error("File not found", e);
		}
		
		if( null != logFile) {
			try {
				if(logFile.length() > 100) {
//					logFile.seek(logFile.length() - 100);		
					logFile.seek(0);
				}else {
					logFile.seek(0);
				}
				String line = null;
				while((line = logFile.readLine()) != null) {
					response += line;
					response += "\n";
				}
				
			} catch (IOException e) {
				log.error("IO Exception : ", e);
			}
		}
		return response;
	}
}
