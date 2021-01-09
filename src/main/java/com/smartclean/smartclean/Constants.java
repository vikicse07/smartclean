package com.smartclean.smartclean;

public final class Constants {
	private Constants() {
	}

	public static final String SERVICE_STATUS_STARTED       =   "Started";
	public static final String SERVICE_STATUS_STOPPED       =   "Stopped";
	public static final String SERVICE_STATUS_RUNNING       =   "Running";
	public static final String SERVICE_STATUS_PAUSED        =   "Paused";

	public static final String SMART_CLEAN_API_CREATE_NEW   =   "/sc/createnew/{startVal}/{steptime}";
	public static final String SMART_CLEAN_API_GET_CURRENT_COUNT_BY_UNIQUEID = "/sc/getbyid/{uniqueId}";
	public static final String SMART_CLEAN_API_GET_ALL_CURRENT_COUNT         = "/sc/getallcurrentcount";
	public static final String SMART_CLEAN_API_RENDER_ALL_CURRENT_COUNT      = "/sc/renderallcurrentcount";
	public static final String SMART_CLEAN_API_STOP_SERVICE_BY_UNIQUEID      = "/sc/stopservice/{uniqueId}";
	public static final String SMART_CLEAN_API_PAUSE_SERVICE_BY_UNIQUEID     = "/sc/pauseservice/{uniqueId}";
}
